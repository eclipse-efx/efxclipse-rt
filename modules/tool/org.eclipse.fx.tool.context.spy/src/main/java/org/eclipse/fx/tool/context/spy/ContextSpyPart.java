 
package org.eclipse.fx.tool.context.spy;

import org.eclipse.fx.tool.context.spy.internal.model.ContextSpyModel;
import org.eclipse.fx.tool.context.spy.internal.view.ContextSpyView;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import org.eclipse.e4.core.contexts.IEclipseContext;

import javax.annotation.PostConstruct;

/**
 * Part of Context Spy
 * 
 * @author x1jzimme
 */
public class ContextSpyPart {

	/**
	 * Creation of ContextSpyModel and view.
	 * Insertion of UI Elements to border pane.
	 * 
	 * @param parentPane
	 * @param cont
	 */
    @PostConstruct
    public void createControl( BorderPane parentPane, final IEclipseContext cont ) {
    	IEclipseContext context = getRootContext(cont);
    	
		ContextSpyModel contextSpyModel = new ContextSpyModel();

		contextSpyModel.setContext( context );
		ContextSpyView contextSpyView = new ContextSpyView(contextSpyModel);
		
		Node control = contextSpyView.getGui();
		parentPane.setCenter( control );
    }
    
    /**
     * returns root context of given context.
     * 
     * @param context
     * @return
     */
    private IEclipseContext getRootContext( IEclipseContext context ) {
    	
    	IEclipseContext parent = context;
    	do {
    		context = parent;
    		parent = context.getParent();
    	} while ( parent != null );
    	
    	return context;
    }
	
}