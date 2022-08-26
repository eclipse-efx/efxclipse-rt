/*******************************************************************************
 * Copyright (c) 2022 BestSolution.at and others.
 *  
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *  
 * SPDX-License-Identifier: EPL-2.0
 *  
 * Contributors:
 *     BestSolution.at - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.code.server.jdt.server;

import static org.eclipse.fx.core.function.ExExecutor.executeConsumer;
import static org.eclipse.fx.core.function.ExExecutor.executeFunction;
import static org.eclipse.fx.core.function.ExExecutor.executeRunnable;
import static org.eclipse.fx.core.function.ExExecutor.executeSupplier;
import static org.eclipse.fx.core.function.ExExecutor.executeSupplierOrDefault;

import java.io.ByteArrayInputStream;
import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.fx.code.server.jdt.shared.JavaCodeCompleteProposal;
import org.eclipse.fx.code.server.jdt.shared.JavaCodeCompleteProposal.Modifier;
import org.eclipse.fx.code.server.jdt.shared.JavaCodeCompleteProposal.Type;
import org.eclipse.fx.code.server.jdt.shared.JavaCodeCompleteProposal.Visibility;
import org.eclipse.fx.code.server.jdt.shared.Marker;
import org.eclipse.fx.code.server.jdt.shared.Proposal;
import org.eclipse.jdt.core.CompletionProposal;
import org.eclipse.jdt.core.CompletionRequestor;
import org.eclipse.jdt.core.Flags;
import org.eclipse.jdt.core.IAccessRule;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.IProblemRequestor;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.Signature;
import org.eclipse.jdt.core.compiler.IProblem;

public class JDTServerImpl {
	private Map<String, ResourceContainer<?>> openResources = new HashMap<>();

	public JDTServerImpl() {
//		System.err.println(node.get(ResourcesPlugin.PREF_LIGHTWEIGHT_AUTO_REFRESH,"NIX DA"));
//		System.err.println(node.get(ResourcesPlugin.PREF_AUTO_REFRESH,"NIX DA"));
		
//		System.err.println(JavaRuntime.getDefaultVMInstall());
	}

	public String registerModule(URI uri) {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		
		Path path = Paths.get(uri).resolve(".project");
		try {
			if( Files.exists(path) ) {
				try {
					IProjectDescription p = workspace.loadProjectDescription(new org.eclipse.core.runtime.Path(path.toFile().getAbsolutePath()));
					IProject project = workspace.getRoot().getProject(p.getName());
					if( ! project.exists() ) {
						workspace.run(new IWorkspaceRunnable() {
							
							@Override
							public void run(IProgressMonitor monitor) throws CoreException {
								project.create(p, null);
								project.open(null);
							}
						}, null);
						return p.getName();
					} else {
						if( Paths.get(project.getLocationURI()).equals(Paths.get(uri)) ) {
							return p.getName();
						} else {
							throw new RuntimeException("A module with name '"+p.getName()+"' already exists in the workspace");
						}
					}
				} catch (CoreException e) {
					throw new RuntimeException("Failed to register module '"+uri+"' in the workspace", e);
				}
			} else {
				throw new RuntimeException("There's no valid project module at the given location '"+uri+"'");
			}			
		} finally {
			executeRunnable(() -> workspace.save(true, null), "Unable to save workbench state");	
		}		
	}

	public List<String> getSourceFolders(String moduleName) {
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(moduleName);

		assertExists(project);
		if( ! project.isOpen() ) {
			executeConsumer(new NullProgressMonitor(), project::open, "Unable to open project");
		}
		assertJavaProject(project);
		IJavaProject jp = JavaCore.create(project);

		Optional<List<String>> map = executeSupplier(jp::getPackageFragmentRoots, "Unable to retrieve fragement roots")
				.map(Arrays::asList)
				.map(pl -> {
						return pl.stream()
								.filter(pfr -> executeSupplier(() -> pfr.getKind() == IPackageFragmentRoot.K_SOURCE,"").get())
								.map(pfr -> pfr.getPath().toString().substring(project.getFullPath().toString().length()+1))
								.collect(Collectors.toList());
					}
				);
		if( map.isPresent() ) {
			return map.get();
		} else {
			return Collections.emptyList();
		}
	}

	public byte[] getFileContent(String id) {
		ResourceContainer<?> c = openResources.get(id);
		if( c == null ) {
			throw new IllegalStateException("There's no open resource with id '"+id+"'");
		}
		return c.getContent();
	}

	public void setFileContent(String id, byte[] data) {
		ResourceContainer<?> c = openResources.get(id);
		if( c == null ) {
			throw new IllegalStateException("There's no open resource with id '"+id+"'");
		}
		c.setContent(data);
	}

	public void insertContent(String id, int start, byte[] data) {
		ResourceContainer<?> c = openResources.get(id);
		if( c == null ) {
			throw new IllegalStateException("There's no open resource with id '"+id+"'");
		}
		c.insertContent(start, data);
	}

	public void replaceContent(String id, int start, int length, byte[] data) {
		ResourceContainer<?> c = openResources.get(id);
		if( c == null ) {
			throw new IllegalStateException("There's no open resource with id '"+id+"'");
		}
		c.replaceContent(start, length, data);
	}

	public void persistFileContent(String id) {
		ResourceContainer<?> c = openResources.get(id);
		if( c == null ) {
			throw new IllegalStateException("There's no open resource with id '"+id+"'");
		}
		c.persist();
	}

	public String openFile(String moduleName, String path) {
		ResourceContainer<?> rc = createResourceContainer(moduleName,path);
		if( rc != null ) {
			openResources.put(rc.id, rc);
			return rc.id;
		}
		throw new IllegalArgumentException("Unable file '"+moduleName+"' in path '"+path+"'");
	}
	
	public Boolean createFile(String moduleName, String path, ByteBuffer content) {
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(moduleName);
		if( project.exists() ) {
			IFile file = project.getFile(new org.eclipse.core.runtime.Path(path));
			if( ! file.exists() ) {
				try {
					file.create(new ByteArrayInputStream(content.array()), true, null);
					return Boolean.TRUE;
				} catch (CoreException e) {
					throw new IllegalArgumentException("Unable to create new file '"+moduleName+"' in path '"+path+"'", e);
				}
			}
		}
		
		throw new IllegalArgumentException("Unable to create new file '"+moduleName+"' in path '"+path+"'");
	}


	private ResourceContainer<?> createResourceContainer(String moduleName, String path) {
		if( path.endsWith(".java") ) {
			IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(moduleName);
			IFile file = project.getFile(new org.eclipse.core.runtime.Path(path));
//			executeRunnable(() -> file.refreshLocal(IResource.DEPTH_ONE, null), "Failed to synchronize file '"+file+"'");

			if( ! file.exists() ) {
				throw new IllegalStateException("The requested file does not exist");
			}
			return new CompilationUnitContainer(moduleName, path, file);
		}
		return null;
	}

	public void closeFile(String id) {
		ResourceContainer<?> c = openResources.get(id);
		if( c == null ) {
			throw new IllegalStateException("There's no open resource with id '"+id+"'");
		}
		c.dispose();
	}

	public boolean isManaged(String moduleName, String path) {
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(moduleName);
		if( project != null ) {
			if( path.endsWith(".java") ) {
				return true;
			}
		}

		return false;
	}

	public List<Proposal> getProposals(String id, int offset) {
		ResourceContainer<?> c = openResources.get(id);
		if( c == null ) {
			throw new IllegalStateException("There's no open resource with id '"+id+"'");
		}
		return c.getProposals(id, offset);
	}

	public void reset(String id) {
		ResourceContainer<?> c = openResources.get(id);
		if( c == null ) {
			throw new IllegalStateException("There's no open resource with id '"+id+"'");
		}
		c.reset();
	}

	public void dispose(String id) {
		ResourceContainer<?> c = openResources.get(id);
		if( c == null ) {
			throw new IllegalStateException("There's no open resource with id '"+id+"'");
		}
		openResources.remove(id);
		c.dispose();
	}

	public List<Marker> getMarkers(String id) {
		ResourceContainer<?> c = openResources.get(id);
		if( c == null ) {
			throw new IllegalStateException("There's no open resource with id '"+id+"'");
		}
		return c.getMarkers();
	}

	private static void assertExists(IProject project) {
		if( ! project.exists() ) {
			throw new RuntimeException("Project named '"+project.getName()+"' is not known");
		}
	}

	private static void assertJavaProject(IProject project) {
		try {
			System.err.println(project);
			System.err.println("CHECK NATURE: " + project.hasNature(JavaCore.NATURE_ID));
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		executeFunction(JavaCore.NATURE_ID, project::hasNature, "Unable to retrieve nature").ifPresent(
				v -> {
					if( ! v ) {
						throw new RuntimeException("The module '"+project.getName()+"' is not a JDT project");
					}
				});
	}



	static abstract class ResourceContainer<T> {
		public final String id;
		public final String module;
		public final String path;

		public ResourceContainer(String module, String path) {
			this.id = UUID.randomUUID().toString();
			this.module = module;
			this.path = path;
		}

		public abstract T getResource();
		public abstract byte[] getContent();
		public abstract void setContent(byte[] content);
		public abstract void insertContent(int start, byte[] content);
		public abstract void replaceContent(int start, int length, byte[] content);
		public abstract List<Proposal> getProposals(String id, int offset);
		public abstract void persist();
		public abstract void dispose();
		public abstract void reset();
		public abstract List<Marker> getMarkers();
	}

	static class CompilationUnitContainer extends ResourceContainer<ICompilationUnit> implements IProblemRequestor {
		private ICompilationUnit unit;
		private final IFile file;
		private boolean needsReconcile = true;
		private JDTWorkingCopyOwner owner;

		public CompilationUnitContainer(String module, String path,IFile file) {
			super(module, path);
			this.file = file;
		}

		@Override
		public ICompilationUnit getResource() {
			if( unit == null ) {
				owner = new JDTWorkingCopyOwner(this);
				unit = executeSupplier(() -> {
					return ((ICompilationUnit) JavaCore.create(file)).getWorkingCopy(owner, new NullProgressMonitor());
				}, "Failed to create compilation unit").get();
					reconcile();
//					unit.reconcile(ICompilationUnit.NO_AST, true, null, null);
			}
			return unit;
		}

		@Override
		public List<Marker> getMarkers() {
			reconcile();
			IMarker[] errorMarkers = executeSupplier( () -> file.findMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE), "Unable to retrieve markers").get();
			IMarker[] taskMarkers = executeSupplier( () -> file.findMarkers(IMarker.TASK, true, IResource.DEPTH_INFINITE), "Unable to retrieve markers").get();

			return Stream.concat(Stream.of(errorMarkers),Stream.of(taskMarkers)).map(this::toMarker).collect(Collectors.toList());
		}

		private Marker toMarker(IMarker marker) {
//			System.err.println("===========================");
//			try {
//				marker.getAttributes().forEach((k,v) -> System.err.println(k + " => " + v));
//			} catch (CoreException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			return new Marker(
					toType(executeSupplierOrDefault(marker::getType, t -> IMarker.PROBLEM).get()),
					toSeverity(
							marker.getAttribute(IMarker.SEVERITY, IMarker.SEVERITY_INFO)),
					marker.getAttribute(IMarker.MESSAGE, null),
					id,
					marker.getAttribute(IMarker.LINE_NUMBER, -1),
					marker.getAttribute(IMarker.CHAR_START, -1),
					marker.getAttribute(IMarker.CHAR_END,-1));
		}

		private static Marker.Type toType(String type) {
			switch (type) {
			case IMarker.TASK:
				return Marker.Type.TASK;
			default:
				return Marker.Type.PROBLEM;
			}
		}

		private static Marker.Severity toSeverity(int severity) {
			switch (severity) {
			case IMarker.SEVERITY_ERROR:
				return Marker.Severity.ERROR;
			case IMarker.SEVERITY_INFO:
				return Marker.Severity.INFO;
			default:
				return Marker.Severity.WARNING;
			}
		}

		@Override
		public void reset() {
			executeRunnable(getResource()::restore,"Unable to restore file content");
		}

		@Override
		public byte[] getContent() {
			return executeSupplier(getResource()::getBuffer, "Unable to retrieve content from '"+file+"'").get().getContents().getBytes();
		}

		@Override
		public void insertContent(int start, byte[] content) {
			executeSupplier(getResource()::getBuffer, "Unable to insert content into file '"+file+"'").get().replace(start, 0, new String(content));
			this.needsReconcile = true;
		}

		public void replaceContent(int start, int length, byte[] content) {
			String data = content == null ? "" : new String(content);
			executeSupplier(getResource()::getBuffer, "Unable to replace content in file '"+file+"'").get().replace(start, length, data);
			this.needsReconcile = true;
		}

		@Override
		public void setContent(byte[] content) {
			executeSupplier(getResource()::getBuffer,"Unable to set content from '"+file+"'").get().setContents(new String(content));
			this.needsReconcile = true;
		}

		private void reconcile() {
			if( needsReconcile ) {
				System.err.println("DOING A RECONCILE");
				executeRunnable(() -> getResource().reconcile(ICompilationUnit.NO_AST, true, null, null),"Failed to reconcile '"+file+"'");
				needsReconcile = false;
			}
		}

		@Override
		public List<Proposal> getProposals(String id, int offset) {
			List<Proposal> rv = new ArrayList<>();
			try {
				reconcile();
				getResource().codeComplete(offset, new CompletionRequestor() {
					@Override
					public void completionFailure(IProblem problem) {
						super.completionFailure(problem);
						System.err.println("Houston we have a problem: " + problem);
					}

					@Override
					public void accept(CompletionProposal proposal) {
						String completion = new String(proposal.getCompletion());

						System.err.println("TO COMPUTE: " + proposal + " => " + completion);

						if (proposal.getKind() == CompletionProposal.METHOD_REF) {
							String sig = Signature.toString(new String(proposal.getSignature()), new String(proposal.getName()), null, false, false);
							rv.add(new JavaCodeCompleteProposal(
									Type.METHOD,
									visibility(proposal.getFlags()),
									modifiers(proposal.getFlags()),
									proposal.getReplaceStart(),
									length(proposal),
									completion,
									sig + " : " + Signature.getSimpleName(Signature.toString(Signature.getReturnType(new String(proposal.getSignature())))),
									" - " + Signature.getSignatureSimpleName(new String(proposal.getDeclarationSignature()))));
						} else if (proposal.getKind() == CompletionProposal.FIELD_REF) {
							rv.add(new JavaCodeCompleteProposal(
									Type.FIELD,
									visibility(proposal.getFlags()),
									modifiers(proposal.getFlags()),
									proposal.getReplaceStart(),
									length(proposal),
									completion,
									completion + " : " + (proposal.getSignature() != null ? Signature.getSignatureSimpleName(new String(proposal.getSignature())) : "<unknown>"),
									" - " + (proposal.getDeclarationSignature() != null ? Signature.getSignatureSimpleName(new String(proposal.getDeclarationSignature())) : "<unknown>")));
						} else if (proposal.getKind() == CompletionProposal.TYPE_REF) {
							if (proposal.getAccessibility() == IAccessRule.K_NON_ACCESSIBLE) {
								return;
							}

							rv.add(new JavaCodeCompleteProposal(
									Type.CLASS,
									visibility(proposal.getFlags()),
									modifiers(proposal.getFlags()),
									proposal.getReplaceStart(),
									length(proposal),
									completion,
									Signature.getSignatureSimpleName(new String(proposal.getSignature())),
									" - " + new String(proposal.getDeclarationSignature())));
						} else {
							System.err.println("UNKNOWN: " + proposal);
						}
					}
				},owner);
			} catch (JavaModelException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return rv;
		}

		private static List<Modifier> modifiers(int value) {
			List<Modifier> rv = new ArrayList<Modifier>();
			if( Flags.isStatic(value) ) {
				rv.add(Modifier.STATIC);
			}

			if(Flags.isFinal(value)) {
				rv.add(Modifier.FINAL);
			}

			return rv;
		}

		private static Visibility visibility(int value) {
			if( Flags.isPublic(value) ) {
				return Visibility.PUBLIC;
			} else if( Flags.isPrivate(value) ) {
				return Visibility.PRIVATE;
			} else if( Flags.isProtected(value) ) {
				return Visibility.PROTECTED;
			}
			return Visibility.PACKAGE_PRIVATE;
		}

		private static int length(CompletionProposal proposal) {
			return proposal.getReplaceEnd() - proposal.getReplaceStart();
		}

		@Override
		public void dispose() {
			executeRunnable(getResource()::close, "Failed to close unit");
			this.unit = null;
		}

		@Override
		public void persist() {
			if( this.unit != null ) {
				reconcile();
				executeRunnable(() -> getResource().commitWorkingCopy(true, new NullProgressMonitor()), "Unable to persist file '"+file+"'");
			}
		}

		@Override
		public void acceptProblem(IProblem arg0) {
			try {
				System.err.println("CREATING MARKER FOR " + arg0);
				IMarker m = file.createMarker(arg0.getID() == IProblem.Task ? IMarker.TASK : IMarker.PROBLEM);
				m.setAttribute(IMarker.MESSAGE, arg0.getMessage());
				m.setAttribute(IMarker.LINE_NUMBER, arg0.getSourceLineNumber());
				m.setAttribute(IMarker.CHAR_START, arg0.getSourceStart());
				m.setAttribute(IMarker.CHAR_END, arg0.getSourceEnd());
				if( arg0.isError() ) {
					m.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_ERROR);
				} else if( arg0.isWarning() ) {
					m.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_WARNING);
				} else {
					m.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_INFO);
				}
			} catch (CoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		@Override
		public void beginReporting() {
			try {
				file.deleteMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE);
				file.deleteMarkers(IMarker.TASK, true, IResource.DEPTH_INFINITE);
			} catch (CoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		@Override
		public void endReporting() {
			// TODO Auto-generated method stub
			System.err.println("END WITH REPORTS");
		}

		@Override
		public boolean isActive() {
			return true;
		}

	}
}