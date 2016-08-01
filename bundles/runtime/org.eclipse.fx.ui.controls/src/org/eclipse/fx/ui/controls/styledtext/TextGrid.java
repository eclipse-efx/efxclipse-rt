package org.eclipse.fx.ui.controls.styledtext;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.eclipse.fx.ui.controls.styledtext.StyledTextContent.TextChangeListener;

import javafx.application.Application;
import javafx.beans.Observable;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

class TextGrid extends BorderPane {
	private StyledTextContent content = new DefaultContent();

	public TextGrid() {
		ContentLayer grid = new ContentLayer(this);
		setCenter(grid);

		ScrollBar vScroll = new ScrollBar();
		vScroll.maxProperty().bind(grid.virtualHeight);
		vScroll.valueProperty().addListener(e -> {
			grid.setVShift(vScroll.getValue());
		});
		vScroll.setOrientation(Orientation.VERTICAL);
		setRight(vScroll);

		ScrollBar hScroll = new ScrollBar();
		hScroll.maxProperty().bind(grid.virtualWidth);
		hScroll.valueProperty().addListener( e -> {
			grid.setHShift(hScroll.getValue());
		});
		setBottom(hScroll);
	}

	public void setText(String text) {
		content.setText(text);
	}

	private static class ContentLayer extends StackPane {
		private Text[][] textGrid = new Text[0][0] ;
		private Text calcNode;
		private int columnOffset;
		private int rowOffset;

		private DoubleProperty virtualHeight = new SimpleDoubleProperty(100);
		private DoubleProperty virtualWidth = new SimpleDoubleProperty(100);
		private int longestLine;
		private double totalHeight;
		private final TextGrid container;

		Font font = Font.font("Monospace", 13);

		public ContentLayer(TextGrid container) {
			this.container = container;
			this.calcNode = new Text("m");
			this.calcNode.setFont(font);
			this.calcNode.setManaged(false);
			getChildren().add(this.calcNode);
			widthProperty().addListener(this::handleWidthChange);
			heightProperty().addListener(this::handleHeightChange);
			container.content.addTextChangeListener( new TextChangeListener() {

				@Override
				public void textChanged(TextChangedEvent event) {
					update();
				}

				@Override
				public void textSet(TextChangedEvent event) {
					update();
				}

				@Override
				public void textChanging(TextChangingEvent event) {
					update();
				}

				private void update() {
					totalHeight = 0;
					longestLine = 0;
					for( int i = 0; i < container.content.getLineCount(); i++ ) {
						totalHeight += getTextHeight();
						longestLine = Math.max(longestLine, container.content.getLine(i).length());
					}

					if(  textGrid.length > 0 ) {
						virtualWidth.set(longestLine * getTextWidth() - textGrid[0].length * getTextWidth() );
					}
					virtualHeight.set(totalHeight - (textGrid.length - 2) * getTextHeight());
				}
			});
		}

		private Text[] allocate(int amount) {
			Text[] rv = new Text[amount];
			for( int i = 0; i < amount; i++ ) {
				rv[i] = new Text();
				rv[i].setFont(font);
				rv[i].setManaged(false);
			}
			getChildren().addAll(rv);
			return rv;
		}

		private void deallocate(Text... texts) {
			getChildren().removeAll(texts);
		}

		private int getTextWidth() {
			return (int) Math.ceil(this.calcNode.getLayoutBounds().getWidth());
		}

		private int getTextHeight() {
			return (int) Math.ceil(this.calcNode.getLayoutBounds().getHeight());
		}

		private void handleWidthChange(Observable o, Number ol, Number ne) {
			this.calcNode.autosize();
			double s = getTextWidth();

			int textCount = (int)Math.ceil(getWidth() / s) + 2;

			if( this.textGrid.length == 0) {
				this.textGrid = new Text[1][0];
				this.textGrid[0] =  allocate(textCount);
			} else {
				int length = this.textGrid[0].length;
				if(length < textCount ) {
					int delta = textCount - length;
					for( int i = 0; i < this.textGrid.length; i++ ) {
						Text[] newLine = new Text[textCount];
						System.arraycopy(this.textGrid[i], 0, newLine, 0, this.textGrid[i].length);
						System.arraycopy(allocate(delta),0,newLine,length,delta);
						this.textGrid[i] = newLine;
					}
				} else if( length > textCount ) {
					int delta = length - textCount;
					for( int i = 0; i < this.textGrid.length; i++ ) {
						Text[] newLine = new Text[textCount];
						System.arraycopy(this.textGrid[i], 0, newLine, 0, textCount);
						Text[] cleanup = new Text[delta];
						for( int j = 0; j < delta; j++ ) {
							cleanup[j] = this.textGrid[i][textCount+j];
						}
						deallocate(cleanup);
						this.textGrid[i] = newLine;
					}
				}
			}

			fixContent();

			virtualWidth.set(longestLine * getTextWidth() - textGrid[0].length * getTextWidth() );
		}

		private void handleHeightChange(Observable o, Number ol, Number ne) {
			this.calcNode.autosize();
			double s = Math.ceil(this.calcNode.getLayoutBounds().getHeight());

			int textCount = (int)Math.ceil(getHeight() / s) + 2;

			if( this.textGrid.length == 0) {
				this.textGrid = new Text[textCount][0];
			} else if(this.textGrid.length < textCount ) {
				int delta = textCount - this.textGrid.length;
				Text[][] newGrid = new Text[textCount][this.textGrid[0].length];
				for( int i = 0; i < this.textGrid.length; i++ ) {
					System.arraycopy(this.textGrid[i], 0, newGrid[i], 0, this.textGrid[i].length);
				}

				for( int i = 0; i < delta; i++ ) {
					newGrid[this.textGrid.length+i] = allocate(this.textGrid[0].length);
				}
				this.textGrid = newGrid;
			} else if( this.textGrid.length > textCount ) {
				int delta = this.textGrid.length - textCount;
				Text[][] newGrid = new Text[textCount][this.textGrid[0].length];
				for( int i = 0; i < textCount; i++ ) {
					System.arraycopy(this.textGrid[i], 0, newGrid[i], 0, this.textGrid[0].length);
				}
				for( int i = 0; i < delta; i++ ) {
					deallocate(this.textGrid[textCount+i]);
				}
				this.textGrid = newGrid;
			}

			fixContent();
			virtualHeight.set(totalHeight - (textGrid.length - 2) * getTextHeight());
		}

		private void fixContent() {
			for( int r = 0; r < this.textGrid.length; r++ ) {
				int row = r + this.rowOffset;
				for( int c = 0; c < this.textGrid[r].length; c++ ) {
					if( row < container.content.getLineCount() ) {
						String l = container.content.getLine(row);
						int col = c + this.columnOffset;
						if( col < l.length() ) {
							this.textGrid[r][c].setText(String.valueOf(l.charAt(col)));
						} else {
							this.textGrid[r][c].setText(""); //$NON-NLS-1$
						}
					} else {
						this.textGrid[r][c].setText(""); //$NON-NLS-1$
					}
				}
			}
		}

		@Override
		protected void layoutChildren() {
			super.layoutChildren();
			int y = 0;
			for( int r = 0; r < this.textGrid.length; r++ ) {
				int x = 0;
				for( int c = 0; c < this.textGrid[r].length; c++ ) {
					this.textGrid[r][c].relocate(x, y);
					x += getTextWidth();
				}
				y += Math.ceil(this.calcNode.getLayoutBounds().getHeight());
			}
		}

		public void setHShift(double value) {
			int width = (int)getTextWidth();
			double v = value % width;
			setTranslateX(v*-1);
			int columnOffset = (int)(value / width);
			if( columnOffset != this.columnOffset ) {
				this.columnOffset = columnOffset;
				fixContent();
			}
		}

		public void setVShift(double value) {
			int height = (int) Math.ceil(this.calcNode.getLayoutBounds().getHeight());
			double v = value % height;
			setTranslateY(v*-1);
			int rowOffset = (int)(value / height);
			if( rowOffset != this.rowOffset ) {
				this.rowOffset = rowOffset;
				fixContent();
			}
		}
	}


	public static void main(String[] args) {
		Application.launch(MyApplication.class, args);
	}

	public static class MyApplication extends Application {

		@Override
		public void start(Stage primaryStage) throws Exception {
			TextGrid grid = new TextGrid();
			grid.setText(new String( Files.readAllBytes(Paths.get("/Users/tomschindl/dart-samples/Grid.java")) ));
			primaryStage.setScene(new Scene(grid, 500, 500));
			primaryStage.show();
		}

	}
}