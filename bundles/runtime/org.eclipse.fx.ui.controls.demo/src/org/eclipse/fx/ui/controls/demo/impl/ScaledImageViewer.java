package org.eclipse.fx.ui.controls.demo.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import org.eclipse.fx.core.ThreadSynchronize;
import org.eclipse.fx.ui.controls.demo.ControlDemo;
import org.eclipse.fx.ui.controls.image.DelegatingMultiDimensionImage;
import org.eclipse.fx.ui.controls.image.MultiDimensionImage;
import org.eclipse.fx.ui.controls.list.ScalingImageListCell;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

@SuppressWarnings("javadoc")
@Component
public class ScaledImageViewer implements ControlDemo {
	private ThreadSynchronize synchronize;

	public enum Size {
		SMALL,
		MEDIUM,
		LARG
	}

	private static Map<String, Image> IMAGE_CACHE = new HashMap<>();
	private static Image PLACEHOLDER;

	@Reference
	public void setThreadSynchronize(ThreadSynchronize synchronize) {
		this.synchronize = synchronize;
	}

	public void unsetThreadSynchronize(ThreadSynchronize synchronize) {

	}

	private static Image getPlaceholderImage() {
		if( PLACEHOLDER == null ) {
			PLACEHOLDER = new Image(ScaledImageViewer.class.getResource("load_100_130.png").toExternalForm());
		}
		return PLACEHOLDER;
	}

	@Override
	public Node createNode() {
		BorderPane p = new BorderPane();

		HBox container = new HBox();

		{
			ListView<String> multiImage = new ListView<>();
			multiImage.setCellFactory( v ->  new SingleSampleCell(v));
			multiImage.setItems(FXCollections.observableArrayList(new String("1"),new String("2"),new String("3"),new String("4"),new String("5")));
			container.getChildren().add(multiImage);
			HBox.setHgrow(multiImage, Priority.ALWAYS);
		}

		{
			ListView<String> multiImage = new ListView<>();
			multiImage.setCellFactory( v ->  new SingleAsyncSampleCell(v,synchronize));
			multiImage.setItems(FXCollections.observableArrayList(new String("1"),new String("2"),new String("3"),new String("4"),new String("5")));
			container.getChildren().add(multiImage);
			HBox.setHgrow(multiImage, Priority.ALWAYS);
		}

		{
			ListView<String> multiImage = new ListView<>();
			multiImage.setCellFactory( v ->  new MultiSampleCell(v,synchronize));
			multiImage.setItems(FXCollections.observableArrayList(new String("1"),new String("2"),new String("3"),new String("4"),new String("5")));
			container.getChildren().add(multiImage);
			HBox.setHgrow(multiImage, Priority.ALWAYS);
		}

		p.setCenter(container);

		return p;
	}

	@Override
	public String getLabel() {
		return "Scaled Image Viewer";
	}

	static class SingleSampleCell extends ScalingImageListCell<String> {
		public SingleSampleCell(ListView<String> view) {
			super(view, d -> imageProvider(d));
		}

		static ObservableValue<MultiDimensionImage> imageProvider(String data) {
			return new SimpleObjectProperty<>(MultiDimensionImage.singleDimension(new Image(ScaledImageViewer.class.getResource("sample_200_260.png").toExternalForm())));
		}
	}

	static class SingleAsyncSampleCell extends ScalingImageListCell<String> {
		public SingleAsyncSampleCell(ListView<String> view, ThreadSynchronize synchronize) {
			super(view, d -> imageProvider(d, synchronize));
		}

		static ObservableValue<MultiDimensionImage> imageProvider(String data, ThreadSynchronize synchronize) {
			return new SimpleObjectProperty<>(MultiDimensionImage.singleDimension(synchronize, getPlaceholderImage(), data, d -> {
				synchronized (IMAGE_CACHE) {
					if( IMAGE_CACHE.containsKey(data) ) {
						return IMAGE_CACHE.get(data);
					}
				}
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Image img = new Image(ScaledImageViewer.class.getResource("sample_200_260.png").toExternalForm());
				synchronized(IMAGE_CACHE) {
					IMAGE_CACHE.put(data,img);
				}
				return img;
			}));
		}
	}

	static class MultiSampleCell extends ScalingImageListCell<String> {

		public MultiSampleCell(ListView<String> view, ThreadSynchronize synchronize) {
			super(view, d -> imageProvider(d, synchronize));
		}

		static ObservableValue<MultiDimensionImage> imageProvider(String data, ThreadSynchronize synchronize) {
			MultiDimensionImage i = DelegatingMultiDimensionImage.async(synchronize, (w,h) -> dimensionImageComputer(data, w, h));
			return new SimpleObjectProperty<>(i);
		}

		static CompletableFuture<Optional<Image>> dimensionImageComputer(String data, double w, double h) {
			Size s;
			if( w <= 100 ) {
				s = Size.SMALL;
			} else if( w <= 200 ) {
				s = Size.MEDIUM;
			} else {
				s = Size.LARG;
			}

			String cacheKey = data + "_" + s.name();

			synchronized (IMAGE_CACHE) {
				if( IMAGE_CACHE.containsKey(cacheKey) ) {
					System.err.println("returning cached version for '"+cacheKey+"'");
					return CompletableFuture.completedFuture(Optional.of(IMAGE_CACHE.get(cacheKey)));
				}
			}

			return CompletableFuture.supplyAsync( () -> {
				// Only compute one at a time for the provided domain object
				synchronized (data) {
					System.err.println("Computing image version for '"+cacheKey+"'");

					synchronized (IMAGE_CACHE) {
						System.err.println("Rechecking cache if image pushed into in the meantime");
						if( IMAGE_CACHE.containsKey(cacheKey) ) {
							System.err.println("returning cached version for '"+cacheKey+"'");
							return Optional.of(IMAGE_CACHE.get(cacheKey));
						}
					}

					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					Image img;
					switch (s) {
					case SMALL:
						img = new Image(ScaledImageViewer.class.getResource("sample_100_130.png").toExternalForm());
						break;
					case MEDIUM:
						img = new Image(ScaledImageViewer.class.getResource("sample_200_260.png").toExternalForm());
						break;
					default:
						img = new Image(ScaledImageViewer.class.getResource("sample_300_390.png").toExternalForm());
						break;
					}

					synchronized (IMAGE_CACHE) {
						IMAGE_CACHE.put(cacheKey, img);
					}

					return Optional.of(img);
				}
			});
		}
	}
}
