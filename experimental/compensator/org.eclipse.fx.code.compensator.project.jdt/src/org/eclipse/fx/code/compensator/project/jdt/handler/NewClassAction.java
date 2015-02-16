package org.eclipse.fx.code.compensator.project.jdt.handler;

import static org.eclipse.fx.core.function.ExExecutor.executeSupplier;

import java.nio.ByteBuffer;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import javafx.scene.Node;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.fx.code.compensator.project.Constants;
import org.eclipse.fx.code.compensator.project.InstanceProject;
import org.eclipse.fx.code.compensator.project.ProjectNavigatorItem;
import org.eclipse.fx.code.compensator.project.jdt.internal.JDTPackageFragmentRootItem;
import org.eclipse.fx.code.compensator.project.jdt.internal.JDTPathItem;
import org.eclipse.fx.core.command.CommandService;
import org.eclipse.fx.ui.controls.stage.DefaultWindowPane;
import org.eclipse.fx.ui.di.FXMLBuilder;
import org.eclipse.fx.ui.di.FXMLBuilder.Data;
import org.eclipse.fx.ui.di.FXMLLoader;
import org.eclipse.fx.ui.di.FXMLLoaderFactory;
import org.eclipse.fx.ui.dialogs.TitleAreaDialog;

public class NewClassAction {
	@Execute
	public void createNewClass(InstanceProject project, @Named("navigatorSelection") JDTPathItem navigationItem,
			@FXMLLoader FXMLLoaderFactory factory, Stage stage, IEventBroker broker, 
			CommandService commandService) {
		FXMLBuilder<Node> builder = factory.loadRequestorRelative("NewClassPane.fxml");
		Data<Node, NewClassPaneController> data = executeSupplier(
				() -> builder.<NewClassPaneController> loadWithController(), "Failed to load FXML file").get();
		TitleAreaDialog dialog = new TitleAreaDialog(stage,"New Class","New Class","Create a new class","new-java-class-dialog") {
			
			@Override
			protected Node createDialogContent() {
				return data.getNode();
			}
			
			protected org.eclipse.fx.ui.controls.stage.WindowPane getCustomWindowPane() {
				return new DefaultWindowPane(new StackPane());
			}
		};
		if( dialog.open() == TitleAreaDialog.OK_BUTTON ) {
			String packageName = data.getController().getPackageName();
			String className = data.getController().getClassName();
			
			ProjectNavigatorItem i = navigationItem;
			while( i != null ) {
				if( i instanceof JDTPackageFragmentRootItem ) {
					break;
				}
				i = i.getParent();
			}
			
			String path = ((JDTPackageFragmentRootItem)i).getLabel().toString();
			path += "/" + packageName.replace('.', '/');
			path += "/" + className + ".java";
			
//			System.err.println("CREATING: " + path);
			
			try {
				Path p = navigationItem.getModuleItem().getPath().resolve(path);
				Boolean rv = navigationItem.getJdtProject().getProjectServer().createFile(navigationItem.getModuleItem().getDomainObject().getName(), path, ByteBuffer.wrap(NewClassTemplate.generate(packageName, className).toString().getBytes())).get();
				if( rv.booleanValue() ) {
					broker.post(Constants.TOPIC_NEW_FILE, p);	
				}
				Map<String, Object> map = new HashMap<>();
				map.put("projectid", project.getProject().getProjectId());
				map.put("moduleName", navigationItem.getModuleItem().getDomainObject().getName());
				map.put("modulePath", path);
				commandService.execute("org.eclipse.fx.code.compensator.project.jdt.command.serverfile", map);
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
//		Dialog<ButtonType> dialog = new Dialog<>();
//		dialog.initOwner(stage);
//		dialog.getDialogPane().getStyleClass().add("new-java-class-dialog");
//		dialog.getDialogPane().setHeaderText("New Class");
//		dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK,ButtonType.CANCEL);
//		dialog.getDialogPane().setContent(data.getNode());
//		dialog.showAndWait().ifPresent(this::handleDialogResult);
	}
}
