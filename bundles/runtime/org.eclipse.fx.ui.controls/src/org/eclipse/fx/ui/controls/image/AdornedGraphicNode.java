package org.eclipse.fx.ui.controls.image;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

/**
 * A node who allows to add adornments
 *
 * @since 2.1.0
 */
public class AdornedGraphicNode extends AnchorPane {

	/**
	 * The location to place the adornment
	 */
	public enum Location {
		/**
		 * Place it to the left top
		 */
		LEFT_TOP, /**
					 * Place it to the left bottom
					 */
		LEFT_BOTTOM, /**
						 * Place it to the right top
						 */
		RIGHT_TOP, /**
					 * Place it to the right bottom
					 */
		RIGHT_BOTTOM
	}

	/**
	 * The adornment to place above the base image
	 */
	public interface Adornment {
		/**
		 * @return the location
		 */
		public @NonNull Location getLocation();

		/**
		 * @return the graphic node
		 */
		public @Nullable Node getGraphic();

		/**
		 * Create an adornment
		 *
		 * @param location
		 *            the location
		 * @param graphic
		 *            the graphic
		 * @return the adornment
		 */
		public static Adornment create(@NonNull Location location, @NonNull Node graphic) {
			return new Adornment() {

				@Override
				public @NonNull Location getLocation() {
					return location;
				}

				@Override
				public @Nullable Node getGraphic() {
					return graphic;
				}
			};
		}
	}

	/**
	 * Create an adorned graphic node
	 *
	 * @param adornedGraphic
	 *            the base node
	 * @param adornments
	 *            the adornments
	 */
	public AdornedGraphicNode(Node adornedGraphic, Adornment... adornments) {
		Double zero = Double.valueOf(0.0);
		{
			AnchorPane.setBottomAnchor(adornedGraphic, zero);
			AnchorPane.setLeftAnchor(adornedGraphic, zero);
			AnchorPane.setRightAnchor(adornedGraphic, zero);
			AnchorPane.setTopAnchor(adornedGraphic, zero);
			getChildren().add(adornedGraphic);
		}

		{
			List<Node> collect = Stream.of(adornments).filter((ad) -> ad.getLocation() == Location.LEFT_TOP).map((ad) -> ad.getGraphic()).filter(n -> n != null).collect(Collectors.toList());

			if (collect != null && !collect.isEmpty()) {
				if (collect.size() == 1) {
					Node graphicsNode = collect.get(0);
					AnchorPane.setLeftAnchor(graphicsNode, zero);
					AnchorPane.setTopAnchor(graphicsNode, zero);
					getChildren().add(graphicsNode);
				} else {
					double start = 0;
					for (Node n : collect) {
						Node graphicsNode = collect.get(0);
						AnchorPane.setLeftAnchor(graphicsNode, Double.valueOf(start));
						AnchorPane.setTopAnchor(graphicsNode, zero);
						getChildren().add(graphicsNode);
						start += n.prefWidth(-1);
					}
				}
			}
		}

		{
			List<Node> collect = Stream.of(adornments).filter((ad) -> ad.getLocation() == Location.RIGHT_TOP).map((ad) -> ad.getGraphic()).filter(n -> n != null).collect(Collectors.toList());

			if (collect != null && !collect.isEmpty()) {
				if (collect.size() == 1) {
					Node graphicsNode = collect.get(0);
					AnchorPane.setRightAnchor(graphicsNode, zero);
					AnchorPane.setTopAnchor(graphicsNode, zero);
					getChildren().add(graphicsNode);
				} else {
					double start = 0;
					for (Node n : collect) {
						Node graphicsNode = collect.get(0);
						AnchorPane.setRightAnchor(graphicsNode, Double.valueOf(start));
						AnchorPane.setTopAnchor(graphicsNode, zero);
						getChildren().add(graphicsNode);
						start += n.prefWidth(-1);
					}
				}
			}
		}

		{
			List<Node> collect = Stream.of(adornments).filter((ad) -> ad.getLocation() == Location.LEFT_BOTTOM).map((ad) -> ad.getGraphic()).filter(n -> n != null).collect(Collectors.toList());

			if (collect != null && !collect.isEmpty()) {
				if (collect.size() == 1) {
					Node graphicsNode = collect.get(0);
					AnchorPane.setLeftAnchor(graphicsNode, zero);
					AnchorPane.setBottomAnchor(graphicsNode, zero);
					getChildren().add(graphicsNode);
				} else {
					double start = 0;
					for (Node n : collect) {
						Node graphicsNode = collect.get(0);
						AnchorPane.setLeftAnchor(graphicsNode, Double.valueOf(start));
						AnchorPane.setBottomAnchor(graphicsNode, zero);
						getChildren().add(graphicsNode);
						start += n.prefWidth(-1);
					}
				}
			}
		}

		{
			List<Node> collect = Stream.of(adornments).filter((ad) -> ad.getLocation() == Location.RIGHT_BOTTOM).map((ad) -> ad.getGraphic()).filter(n -> n != null).collect(Collectors.toList());

			if (collect != null && !collect.isEmpty()) {
				if (collect.size() == 1) {
					Node graphicsNode = collect.get(0);
					AnchorPane.setRightAnchor(graphicsNode, zero);
					AnchorPane.setBottomAnchor(graphicsNode, zero);
					getChildren().add(graphicsNode);
				} else {
					double start = 0;
					for (Node n : collect) {
						Node graphicsNode = collect.get(0);
						AnchorPane.setRightAnchor(graphicsNode, Double.valueOf(start));
						AnchorPane.setBottomAnchor(graphicsNode, zero);
						getChildren().add(graphicsNode);
						start += n.prefWidth(-1);
					}
				}
			}
		}
	}
}
