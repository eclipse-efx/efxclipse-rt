package org.eclipse.fx.ui.controls.styledtext.skin;

import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import com.sun.javafx.scene.text.GlyphList;
import com.sun.javafx.scene.text.TextLayout;
import com.sun.javafx.scene.text.TextLayoutFactory;
import com.sun.javafx.tk.Toolkit;

@SuppressWarnings("restriction")
public class TextLayouter {
	private final Runnable layoutRunnable;
	private final Pane layoutPane;


	public TextLayouter(boolean useraster, Runnable layoutRunnable) {
		if( useraster ) {
			this.layoutPane = new RasterLayoutPane(layoutRunnable);
		} else {
			this.layoutPane = new TextFlow() {
				@Override
				protected void layoutChildren() {
					super.layoutChildren();
					layoutRunnable.run();
				}
			};
		}

		this.layoutPane.setUserData(this);
		this.layoutRunnable = layoutRunnable;
	}

	public void setText(String text) {
		if( layoutPane instanceof  RasterLayoutPane) {
			((RasterLayoutPane)layoutPane).setText(text);
		}
	}

	public Pane getLayoutPane() {
		return layoutPane;
	}

	class RasterLayoutPane extends Pane {
		private Runnable layoutRunnable;
		private String text;
		private GlyphList glyphList;

		public RasterLayoutPane(Runnable layoutRunnable) {
			this.layoutRunnable = layoutRunnable;

		}

		public void setText(String text) {
			this.text = text;
			this.glyphList = null;
		}

		@SuppressWarnings("deprecation")
		@Override
		protected void layoutChildren() {
			super.layoutChildren();

			if( ! getChildren().isEmpty() ) {
				TextFlow f = (TextFlow) getChildren().get(0);

				if( this.glyphList == null ) {
					TextLayoutFactory factory = Toolkit.getToolkit().getTextLayoutFactory();
					TextLayout layout = factory.createLayout();
					layout.setContent(this.text, ((Text)f.getChildren().get(0)).getFont().impl_getNativeFont());
					this.glyphList = layout.getLines()[0].getRuns()[0];
				}

				int start = ((Integer) f.getUserData()).intValue();
				for( Node n : getChildren() ) {
					double offset = this.glyphList.getPosX((((Integer)n.getUserData()).intValue()-start));
					TextFlow t = (TextFlow) n;
					t.relocate(offset, 0);
				}
			}


			this.layoutRunnable.run();
		}
	}
}
