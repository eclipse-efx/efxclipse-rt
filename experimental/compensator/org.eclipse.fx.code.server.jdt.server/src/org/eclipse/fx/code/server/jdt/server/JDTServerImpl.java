package org.eclipse.fx.code.server.jdt.server;

import static org.eclipse.fx.core.function.ExExecutor.executeConsumer;
import static org.eclipse.fx.core.function.ExExecutor.executeFunction;
import static org.eclipse.fx.core.function.ExExecutor.executeRunnable;
import static org.eclipse.fx.core.function.ExExecutor.executeSupplier;

import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IProblemRequestor;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.compiler.IProblem;

public class JDTServerImpl {
	private Map<String, ResourceContainer<?>> openResources = new HashMap<>();

	public String registerModule(URI uri) {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		Path path = Paths.get(uri).resolve(".project");
		if( Files.exists(path) ) {
			try {
				IProjectDescription p = workspace.loadProjectDescription(new org.eclipse.core.runtime.Path(path.toFile().getAbsolutePath()));
				IProject project = workspace.getRoot().getProject(p.getName());
				if( ! project.exists() ) {
					project.create(p, null);
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
		ResourceContainer<?> rc = openResources.values().stream().filter(r -> r.module.equals(moduleName) && r.path.equals(path)).findFirst().orElseGet(() -> createResourceContainer(moduleName,path));
		if( rc != null ) {
			openResources.put(rc.id, rc);
			return rc.id;
		}
		throw new IllegalArgumentException("Unable file '"+moduleName+"' in path '"+path+"'");
	}

	private ResourceContainer<?> createResourceContainer(String moduleName, String path) {
		if( path.endsWith(".java") ) {
			IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(moduleName);
			IFile file = project.getFile(new org.eclipse.core.runtime.Path(path));

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

	private static void assertExists(IProject project) {
		if( ! project.exists() ) {
			throw new RuntimeException("Project named '"+project.getName()+"' is not known");
		}
	}

	private static void assertJavaProject(IProject project) {
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
		public abstract void persist();
		public abstract void dispose();
	}

	static class CompilationUnitContainer extends ResourceContainer<ICompilationUnit> implements IProblemRequestor {
		private ICompilationUnit unit;
		private final IFile file;

		public CompilationUnitContainer(String module, String path,IFile file) {
			super(module, path);
			this.file = file;
		}

		@Override
		public ICompilationUnit getResource() {
			if( unit == null ) {
				unit = executeSupplier(() -> {
					return ((ICompilationUnit) JavaCore.create(file)).getWorkingCopy(new JDTWorkingCopyOwner(this), new NullProgressMonitor());
				}, "Failed to create compilation unit").get();
			}
			return unit;
		}

		@Override
		public byte[] getContent() {
			return executeSupplier(getResource()::getBuffer, "Unable to retrieve content from '"+file+"'").get().getContents().getBytes();
		}

		@Override
		public void insertContent(int start, byte[] content) {
			executeSupplier(getResource()::getBuffer, "Unable to insert content into file '"+file+"'").get().replace(start, 0, new String(content));
			executeRunnable(() -> getResource().reconcile(ICompilationUnit.NO_AST, true, null, null),"Failed to reconcile '"+file+"'");
		}

		public void replaceContent(int start, int length, byte[] content) {
			String data = content == null ? "" : new String(content);
			executeSupplier(getResource()::getBuffer, "Unable to replace content in file '"+file+"'").get().replace(start, length, data);
		}

		@Override
		public void setContent(byte[] content) {
			executeSupplier(getResource()::getBuffer,"Unable to set content from '"+file+"'").get().setContents(new String(content));
			executeRunnable(() -> getResource().reconcile(ICompilationUnit.NO_AST, true, null, null),"Failed to reconcile '"+file+"'");
		}

		@Override
		public void dispose() {
			executeRunnable(getResource()::close, "Failed to close unit");
		}

		@Override
		public void persist() {
			executeRunnable(() -> getResource().commitWorkingCopy(true, new NullProgressMonitor()), "Unable to persist file '"+file+"'");
		}

		@Override
		public void acceptProblem(IProblem arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void beginReporting() {
			// TODO Auto-generated method stub

		}

		@Override
		public void endReporting() {
			// TODO Auto-generated method stub

		}

		@Override
		public boolean isActive() {
			// TODO Auto-generated method stub
			return false;
		}

	}


}
