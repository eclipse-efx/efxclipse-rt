package test.issue12.app;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.model.application.ui.basic.MPartStack;
import org.eclipse.e4.ui.model.application.ui.basic.MTrimmedWindow;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.e4.ui.workbench.modeling.EPartService;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

/**
 * @author tomschindl
 *
 */
public class MainPart {
	@Inject
	MApplication application;

	@Inject
	EModelService modelService;

	@PostConstruct
	void init(BorderPane p) {
		Button b = new Button("Open Window");
		b.setOnAction( this::openWindow );
		p.setCenter(b);
	}

	private void openWindow(ActionEvent e) {
		MTrimmedWindow w = modelService.createModelElement(MTrimmedWindow.class);
		w.getTags().add(EPartService.REMOVE_ON_HIDE_TAG);
		w.setLabel("New Top Level Window");

		MPartStack stack = modelService.createModelElement(MPartStack.class);

		MPart child = modelService.createModelElement(MPart.class);
		child.setContributionURI("bundleclass://test.issue12.app/test.issue12.app.ChildPart1");
		stack.getChildren().add(child);

		child = modelService.createModelElement(MPart.class);
		child.setContributionURI("bundleclass://test.issue12.app/test.issue12.app.ChildPart2");
		stack.getChildren().add(child);

		w.getChildren().add(stack);

		application.getChildren().add(w);
	}
}
