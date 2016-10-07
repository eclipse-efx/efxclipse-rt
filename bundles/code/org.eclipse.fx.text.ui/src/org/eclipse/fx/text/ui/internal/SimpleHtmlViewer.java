package org.eclipse.fx.text.ui.internal;

import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import org.eclipse.fx.text.hover.HtmlString;
import org.eclipse.fx.text.hover.LinkActionEvent;
import org.w3c.dom.Document;
import org.w3c.dom.html.HTMLDocument;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.concurrent.Worker.State;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import netscape.javascript.JSObject;

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
		
	private static String STYLE_INLINE = "<style>body{display: inline;}</style>"; //$NON-NLS-1$
	private static String STYLE_NO_PADDING = "<style>body{padding: 0px}</style>"; //$NON-NLS-1$
	
	private boolean inline;
	
	@Override
	protected double computePrefWidth(double height) {
		if (inline && webEngine.getDocument() != null) {
			Integer width = (Integer) this.webEngine.executeScript("document.body.offsetWidth");
			System.err.println("computePrefWidth -> " + width);
			return width + 4;
		}
		return super.computePrefWidth(height);
	}
	
	@Override
	protected double computePrefHeight(double width) {
		if (inline && webEngine.getDocument() != null) {
			Integer height = (Integer) this.webEngine.executeScript("document.body.offsetHeight");
			System.err.println("computePrefHeight -> " + height);
			return height + 4;
		}
		return super.computePrefHeight(width);
	}
	
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
	
	public SimpleHtmlViewer() {
		this(false, false);
	}
	
	public static class WebBridge {
		private HtmlString html;
		
		public WebBridge(HtmlString html) {
			this.html = html;
		}
		
		public void onLinkAction(String target, long screenX, long screenY) {
			this.html.fireEvent(new LinkActionEvent(LinkActionEvent.LINK_ACTION, target, screenX, screenY));
		}
		public void onLinkContext(String target, long screenX, long screenY) {
			this.html.fireEvent(new LinkActionEvent(LinkActionEvent.LINK_CONTEXT, target, screenX, screenY));
		}
	}
	
	private class WorkerStateChangeListener implements ChangeListener<Worker.State> {
		@Override
		public void changed(ObservableValue<? extends State> observable, State oldValue, State newValue) {
			if (newValue == Worker.State.SUCCEEDED) {
				
				// install WebBridge
				JSObject window = (JSObject) webEngine.executeScript("window"); //$NON-NLS-1$
				window.setMember("java", new WebBridge(getContent())); //$NON-NLS-1$

				// hook all links
				webEngine.executeScript(
					"var callback = function(e) {" + 									//$NON-NLS-1$
					"	if (e.button == 0) {" + 										//$NON-NLS-1$
					"		java.onLinkAction(e.target.href, e.screenX, e.screenY);" + 	//$NON-NLS-1$
					"	}" + 															//$NON-NLS-1$
					"	else if (e.button == 2) {" + 									//$NON-NLS-1$
					"		java.onLinkContext(e.target.href, e.screenX, e.screenY);" +	//$NON-NLS-1$
					"	}" +															//$NON-NLS-1$
					"};" +																//$NON-NLS-1$
					"var allAnchors = document.getElementsByTagName('a');" +			//$NON-NLS-1$
					"for (var i = 0; i < allAnchors.length; i++) {" +					//$NON-NLS-1$
					"	allAnchors[i].onmousedown = callback;" +						//$NON-NLS-1$
					"}"																	//$NON-NLS-1$
				);
			}
		}
	}
	
	private WorkerStateChangeListener workerStateChangeListener = new WorkerStateChangeListener();
	
	// TODO 3.0.0 replace listeners with FXBindings
	public SimpleHtmlViewer(boolean noPaddingInBody, boolean inline) {
		this.inline = inline;
		this.webView = new WebView();
		this.webEngine = this.webView.getEngine();
		
		this.webView.setContextMenuEnabled(false);
		
		setCenter(this.webView);
		
		BiConsumer<Document, Color> applyBackground = (doc, col) -> {
			if (doc == null || col == null) return;
			String style = "background: rgb(" + Math.round(col.getRed() * 255) + ", " + Math.round(col.getGreen() * 255) + ", " + Math.round(col.getBlue() * 255) + ");"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
			((HTMLDocument)doc).getBody().setAttribute("style", style); //$NON-NLS-1$
		};
		
		Consumer<Document> updateSizes = (doc) -> {
			if (inline) {
				Integer width = (Integer) this.webEngine.executeScript("document.body.offsetWidth");
				Integer height = (Integer) this.webEngine.executeScript("document.body.offsetHeight");
				if (width != null) {
					setPrefWidth(width + 20);
				}
				if (height != null) {
//					System.err.println("SET PREF HEIGHT " + height);
					setPrefHeight(height + 4);
				}
			}
		};
		
		AtomicReference<Color> curCol = new AtomicReference<>();
		this.webEngine.documentProperty().addListener((x, o, n)-> {
			applyBackground.accept(n, curCol.get());
			updateSizes.accept(n);
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
		webEngine.getLoadWorker().stateProperty().addListener(workerStateChangeListener);
		
		// bind the content
		contentProperty().addListener((x, o, n) -> {
			if (n != null) {
				this.webEngine.loadContent("<html>"+(noPaddingInBody?STYLE_NO_PADDING:"")+(inline?STYLE_INLINE:"")+"<body>" + n.toString() + "</body></html>"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$			
			}
			else {
				this.webEngine.load("about:blank"); //$NON-NLS-1$
			}
			
			
		});
		
		sceneProperty().addListener((x, o, n)->{
			if (o != null) {
				o.getWindow().setOnHidden(null);
				o.getWindow().setOnShown(null);
			}
			if (n != null) {
				n.getWindow().setOnShown(e -> {
					// install WebBridge
					JSObject window = (JSObject) webEngine.executeScript("window"); //$NON-NLS-1$
					window.setMember("java", new WebBridge(getContent())); //$NON-NLS-1$
				});
				n.getWindow().setOnHidden(e-> {
					// uninstall WebBridge
					JSObject window = (JSObject) webEngine.executeScript("window"); //$NON-NLS-1$
					window.removeMember("java"); //$NON-NLS-1$
				});
			}
		});
	}
	
}
