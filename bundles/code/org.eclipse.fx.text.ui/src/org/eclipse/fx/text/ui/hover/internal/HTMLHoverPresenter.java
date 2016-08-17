package org.eclipse.fx.text.ui.hover.internal;

import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BiConsumer;

import org.eclipse.fx.text.hover.HTMLHoverInfo;
import org.eclipse.fx.text.hover.HoverInfo;
import org.eclipse.fx.text.ui.hover.HoverPresenter;
import org.w3c.dom.Document;
import org.w3c.dom.html.HTMLDocument;

import javafx.beans.value.ChangeListener;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;


@SuppressWarnings("javadoc")
public class HTMLHoverPresenter implements HoverPresenter {

	@Override
	public int getOrder() {
		return -1000;
	}

	@Override
	public boolean isApplicable(Class<? extends HoverInfo> hover) {
		return hover == HTMLHoverInfo.class;
	}

	@Override
	public Node createHoverContent(HoverInfo hover) {
		
		
		HBox b = new HBox();

		WebView content = new WebView();
//		content.setBlendMode(BlendMode.OVERLAY);
		// Use reflection to retrieve the WebEngine's private 'page' field. 
        
		//content.setBlendMode(BlendMode.SRC_OVER);
		WebEngine webEngine = content.getEngine();

		BiConsumer<Document, Color> applyBackground = (doc, col) -> {
			if (doc == null || col == null) return;
			String style = "background: rgb(" + Math.round(col.getRed() * 255) + ", " + Math.round(col.getGreen() * 255) + ", " + Math.round(col.getBlue() * 255) + ");"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
			((HTMLDocument)doc).getBody().setAttribute("style", style); //$NON-NLS-1$
		};
		
		AtomicReference<Color> curCol = new AtomicReference<>();
		
		
		// TODO replace later with FXBindings
		ChangeListener<? super Background> backgroundListener = (x1, o1, background) -> {
			if (background == null) return;
			if (background.getFills().size() > 0) {
				if (background.getFills().get(0).getFill() instanceof Color) {
					Color c = (Color) background.getFills().get(0).getFill();
					curCol.set(c);
					applyBackground.accept(webEngine.getDocument(), c);
				}
			}
		};
		ChangeListener<? super Parent> parentListener = (x, o, n) -> {
			if (o instanceof Region) {
				((Region)o).backgroundProperty().removeListener(backgroundListener);
			}
			if (n instanceof Region) {
				((Region)n).backgroundProperty().addListener(backgroundListener);
			}
		};
		b.parentProperty().addListener(parentListener);
		
		webEngine.documentProperty().addListener((x, o, d) -> {
			applyBackground.accept(d, curCol.get());
		});

		webEngine.loadContent("<html><body>" + hover.getHoverContent().toString() + "</body></html>"); //$NON-NLS-1$ //$NON-NLS-2$
		
//		Platform.runLater(new Runnable(){
//            @Override                                
//            public void run() {
//                try {
//                    Object result = webEngine.executeScript("document.getElementById('content').offsetHeight");
//                    if (result instanceof Integer) {
//                        Integer i = (Integer) result;
//                        double height = new Double(i);
//                        height = height + 40;
//                        System.err.println("SETTING HEIGHT TO " + height);
//                        content.setPrefHeight(height);
////                        content.getPrefHeight();
//                    }
//                } catch (JSException e) { } 
//            }               
//        });
		
		
		b.getChildren().setAll(content);

		return b;
	}

}
