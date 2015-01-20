package org.eclipse.fx.code.compensator.project.jdt.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import javafx.scene.Node;

import org.eclipse.fx.code.compensator.editor.Input;
import org.eclipse.fx.code.compensator.editor.ProposalComputer;
import org.eclipse.fx.code.compensator.editor.ProposalComputer.ProposalContext;
import org.eclipse.fx.code.compensator.editor.services.ProposalComputerFactory;
import org.eclipse.fx.code.server.jdt.shared.JavaCodeCompleteProposal;
import org.eclipse.fx.code.server.jdt.shared.JavaCodeCompleteProposal.Modifier;
import org.eclipse.fx.code.server.jdt.shared.JavaCodeCompleteProposal.Type;
import org.eclipse.fx.core.URI;
import org.eclipse.fx.core.log.Logger;
import org.eclipse.fx.core.log.Logger.Level;
import org.eclipse.fx.core.log.LoggerCreator;
import org.eclipse.fx.ui.controls.styledtext.StyledString;
import org.eclipse.fx.ui.services.resources.AdornedImageDescriptor;
import org.eclipse.fx.ui.services.resources.AdornedImageDescriptor.Adornment;
import org.eclipse.fx.ui.services.resources.AdornedImageDescriptor.Location;
import org.eclipse.fx.ui.services.resources.GraphicsLoader;
import org.eclipse.jface.text.contentassist.CompletetionProposal;
import org.eclipse.jface.text.contentassist.ICompletionProposal;

public class JDTProposalComputerFactory implements ProposalComputerFactory {
	private static Logger LOGGER;

	private static Logger getLogger() {
		if( LOGGER == null ) {
			LOGGER = LoggerCreator.createLogger(JDTProposalComputerFactory.class);
		}
		return LOGGER;
	}

	@Override
	public boolean applies(Input<?> input) {
		if( getLogger().isEnabled(Level.DEBUG) ) {
			getLogger().debug("Checking of the computer applies to '"+input+"'");
		}
		return input instanceof JDTServerInput;
	}

	@Override
	public ProposalComputer createProposalComputer(GraphicsLoader graphicsLoader) {
		return new ProposalComputer() {

			@Override
			public Future<List<ICompletionProposal>> compute(ProposalContext context) {
				try {
					JDTServerInput i = (JDTServerInput) context.input;
					Future<List<org.eclipse.fx.code.server.jdt.shared.Proposal>> proposals = i.server.getProposals(i.openFile.get(), context.location);
					return CompletableFuture.supplyAsync(() -> {
						try {
							return proposals.get().stream().map((p) -> createProposal(context,p,graphicsLoader)).collect(Collectors.toList());
						} catch (Exception e) {
							throw new RuntimeException(e);
						}
					});
				} catch (InterruptedException | ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return CompletableFuture.supplyAsync(() -> Collections.emptyList());
			}
		};
	}

	static ICompletionProposal createProposal(ProposalContext context, org.eclipse.fx.code.server.jdt.shared.Proposal proposal, GraphicsLoader graphicsLoader) {
		JavaCodeCompleteProposal cp = (JavaCodeCompleteProposal) proposal;
		StyledString s = new StyledString();
		s.appendSegment(cp.getLabel(), "java-element-name");
		if( cp.getAdditionalLabel() != null ) {
			s.appendSegment(cp.getAdditionalLabel(), "java-type-info");
		}

		URI baseImage;
		List<Adornment> adornments = new ArrayList<>();

		if( cp.getType() == Type.CLASS ) {
			baseImage = URI.createPlatformPluginURI("org.eclipse.fx.code.compensator.jdt", "css/icons/16/classpub_obj.png");

			if( isStatic(cp.getModifiers()) ) {
				adornments.add(new Adornment(Location.RIGHT_TOP,URI.createPlatformPluginURI("org.eclipse.fx.code.compensator.jdt", "css/icons/7/static_co.png")));
			} else if( isFinal(cp.getModifiers()) ) {
				adornments.add(new Adornment(Location.RIGHT_TOP,URI.createPlatformPluginURI("org.eclipse.fx.code.compensator.jdt", "css/icons/7/final_co.png")));
			}
		} else if( cp.getType() == Type.METHOD ) {
			switch (cp.getVisibility()) {
			case PACKAGE_PRIVATE:
				baseImage = URI.createPlatformPluginURI("org.eclipse.fx.code.compensator.jdt", "css/icons/16/methdef_obj.png");
				break;
			case PRIVATE:
				baseImage = URI.createPlatformPluginURI("org.eclipse.fx.code.compensator.jdt", "css/icons/16/methpri_obj.png");
				break;
			case PROTECTED:
				baseImage = URI.createPlatformPluginURI("org.eclipse.fx.code.compensator.jdt", "css/icons/16/methpro_obj.png");
				break;
			default:
				baseImage = URI.createPlatformPluginURI("org.eclipse.fx.code.compensator.jdt", "css/icons/16/methpub_obj.png");
				break;
			}

			if( isStatic(cp.getModifiers()) ) {
				adornments.add(new Adornment(Location.RIGHT_TOP,URI.createPlatformPluginURI("org.eclipse.fx.code.compensator.jdt", "css/icons/7/static_co.png")));
			} else if( isFinal(cp.getModifiers()) ) {
				adornments.add(new Adornment(Location.RIGHT_TOP,URI.createPlatformPluginURI("org.eclipse.fx.code.compensator.jdt", "css/icons/7/final_co.png")));
			}
		} else if( cp.getType() == Type.FIELD ) {
			switch (cp.getVisibility()) {
			case PACKAGE_PRIVATE:
				baseImage = URI.createPlatformPluginURI("org.eclipse.fx.code.compensator.jdt", "css/icons/16/field_default_obj.png");
				break;
			case PRIVATE:
				baseImage = URI.createPlatformPluginURI("org.eclipse.fx.code.compensator.jdt", "css/icons/16/field_private_obj.png");
				break;
			case PROTECTED:
				baseImage = URI.createPlatformPluginURI("org.eclipse.fx.code.compensator.jdt", "css/icons/16/field_protected_obj.png");
				break;
			default:
				baseImage = URI.createPlatformPluginURI("org.eclipse.fx.code.compensator.jdt", "css/icons/16/field_public_obj.png");
				break;
			}

			if( isStatic(cp.getModifiers()) ) {
				adornments.add(new Adornment(Location.RIGHT_TOP,URI.createPlatformPluginURI("org.eclipse.fx.code.compensator.jdt", "css/icons/7/static_co.png")));
			} else if( isFinal(cp.getModifiers()) ) {
				adornments.add(new Adornment(Location.RIGHT_TOP,URI.createPlatformPluginURI("org.eclipse.fx.code.compensator.jdt", "css/icons/7/final_co.png")));
			}

		} else {
			baseImage = null;
		}

		Supplier<Node> supplier;
		if( baseImage != null ) {
			if( adornments.isEmpty() ) {
				supplier = () -> graphicsLoader.getGraphicsNode(baseImage);
			} else {
				supplier = () -> graphicsLoader.getGraphicsNode(new AdornedImageDescriptor(baseImage, adornments));
			}
		} else {
			supplier = () -> null;
		}

		return new CompletetionProposal(cp.getValue(), cp.getReplacementOffset(), cp.getReplacementLength(),s, supplier);
	}

	private static final boolean isFinal(List<Modifier> m) {
		return m.contains(Modifier.FINAL);
	}

	private static final boolean isStatic(List<Modifier> m) {
		return m.contains(Modifier.STATIC);
	}
}
