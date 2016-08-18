package org.eclipse.fx.text.ui.internal;

import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BiConsumer;

import org.eclipse.fx.text.hover.HtmlString;
import org.eclipse.fx.text.hover.LinkActionEvent;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.events.EventListener;
import org.w3c.dom.events.EventTarget;
import org.w3c.dom.html.HTMLDocument;

import javafx.beans.binding.ObjectBinding;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.concurrent.Worker;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

@SuppressWarnings("javadoc")
public class SimpleHtmlViewer extends BorderPane {

	private ObjectProperty<HtmlString> content = new SimpleObjectProperty<>(this, "content"); //$NON-NLS-1$
	public ObjectProperty<HtmlString> contentProperty() {
		return this.content;
	}
	public HtmlString getContent() {
		return this.content.get();
	}
	public void setContent(HtmlString content) {
		this.content.set(content);
	}
	
	private WebView webView;
	private WebEngine webEngine;
		
	private Region findFirstParentWithBackground(Node n) {
		System.err.println("CHECKING " + n);
		if (n == null) return null;
		if (n instanceof Region) {
			if (((Region)n).getBackground() != null) {
				System.err.println("found parent: " + n);
				System.err.println(" -> " + ((Region)n).getBackground().getFills().get(0).getFill());
				return (Region) n;
			}
		}
		return findFirstParentWithBackground(n.getParent());
	}
	
	// TODO 3.0.0 replace listeners with FXBindings
	public SimpleHtmlViewer() {
		this.webView = new WebView();
		this.webEngine = this.webView.getEngine();
		
		this.webView.setContextMenuEnabled(false);
		
		setCenter(this.webView);
		
		BiConsumer<Document, Color> applyBackground = (doc, col) -> {
			if (doc == null || col == null) return;
			String style = "background: rgb(" + Math.round(col.getRed() * 255) + ", " + Math.round(col.getGreen() * 255) + ", " + Math.round(col.getBlue() * 255) + ");"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
			((HTMLDocument)doc).getBody().setAttribute("style", style); //$NON-NLS-1$
		};
		
		AtomicReference<Color> curCol = new AtomicReference<>();
		this.webEngine.documentProperty().addListener((x, o, n)-> {
			applyBackground.accept(n, curCol.get());
		});
		
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
		parentProperty().addListener(parentListener);
		
		// install the Link Callbacks
		EventListener listener = event -> {
			HtmlString html = getContent();
			if (html != null) {
				if ("mouseup".equals(event.getType())) { //$NON-NLS-1$
					org.w3c.dom.events.MouseEvent ev = (org.w3c.dom.events.MouseEvent)event;
					if (ev.getButton() == 0) {
						System.err.println(ev.getScreenX() + "/" + ev.getScreenY());
						html.fireEvent(new LinkActionEvent(LinkActionEvent.LINK_ACTION, event.getCurrentTarget().toString(), ev.getScreenX(), ev.getScreenY()));
					}
					else if (ev.getButton() == 2) {
						html.fireEvent(new LinkActionEvent(LinkActionEvent.LINK_CONTEXT, event.getCurrentTarget().toString(), ev.getScreenX(), ev.getScreenY()));
					}
				}
			}
		};
		this.webEngine.getLoadWorker().stateProperty().addListener((x, o, n)-> {
			if (n == Worker.State.SUCCEEDED) {
				NodeList links = this.webEngine.getDocument().getElementsByTagName("a"); //$NON-NLS-1$
				for (int i=0; i < links.getLength(); i++) {
					((EventTarget)links.item(i)).addEventListener("mouseup", listener, false); //$NON-NLS-1$
				}
			}
		});
		
		// bind the content
		contentProperty().addListener((x, o, n) -> {
			if (n != null) {
				this.webEngine.loadContent("<html><body>" + n.toString() + "</body></html>"); //$NON-NLS-1$ //$NON-NLS-2$
			}
			else {
				this.webEngine.load("about:blank"); //$NON-NLS-1$
			}
			
			
		});
	}

	
	
	
}
