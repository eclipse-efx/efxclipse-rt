package org.eclipse.fx.ui.controls.image;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

	private final List<Adornment> adornments;

	/**
	 * Create an adorned graphic node
	 *
	 * @param adornedGraphic
	 *            the base node
	 * @param adornments
	 *            the adornments
	 */
	public AdornedGraphicNode(@NonNull Node adornedGraphic, @NonNull Adornment... adornments) {
		this(adornedGraphic, Arrays.asList(adornments));
	}

	/**
	 * Create an adorned graphic node
	 *
	 * @param adornedGraphic
	 *            the base node
	 * @param adornments
	 *            the adornments
	 */
	public AdornedGraphicNode(@NonNull Node adornedGraphic, List<@NonNull Adornment> adornments) {
		this.adornments = new ArrayList<Adornment>(adornments);
		getStyleClass().setAll( "adorned-gaphic-node" ); //$NON-NLS-1$
		getChildren().add(adornedGraphic);
		getChildren().addAll(adornments.stream()
				.map( a -> a.getGraphic())
				.filter( g -> g != null)
				.map( g -> {
					if( g != null ) {
						g.setManaged(false);
					}
					return g;
				})
				.collect(Collectors.toList()));
	}

	@Override
	protected void layoutChildren() {
		super.layoutChildren();

		{
			List<Node> collect = this.adornments.stream().filter((ad) -> ad.getLocation() == Location.LEFT_TOP).map((ad) -> ad.getGraphic()).filter(n -> n != null).collect(Collectors.toList());

			if (collect != null && !collect.isEmpty()) {
				if (collect.size() == 1) {
					Node graphicsNode = collect.get(0);
					graphicsNode.autosize();
					graphicsNode.relocate(0, 0);
				} else {
					double start = 0;
					for (Node n : collect) {
						n.autosize();
						n.relocate(start, 0);
						start += n.prefWidth(-1);
					}
				}
			}
		}

		{
			List<Node> collect = this.adornments.stream().filter((ad) -> ad.getLocation() == Location.RIGHT_TOP).map((ad) -> ad.getGraphic()).filter(n -> n != null).collect(Collectors.toList());

			if (collect != null && !collect.isEmpty()) {
				if (collect.size() == 1) {
					Node graphicsNode = collect.get(0);
					graphicsNode.autosize();
					graphicsNode.relocate(getWidth()-graphicsNode.prefWidth(-1), 0);

				} else {
					double start = 0;
					for (Node n : collect) {
						n.autosize();
						n.relocate(getWidth()-n.prefWidth(-1) - start, 0);
						start += n.prefWidth(-1);
					}
				}
			}
		}

		{
			List<Node> collect = this.adornments.stream().filter((ad) -> ad.getLocation() == Location.LEFT_BOTTOM).map((ad) -> ad.getGraphic()).filter(n -> n != null).collect(Collectors.toList());

			if (collect != null && !collect.isEmpty()) {
				if (collect.size() == 1) {
					Node graphicsNode = collect.get(0);
					graphicsNode.autosize();
					graphicsNode.relocate(0, getHeight() - graphicsNode.prefHeight(-1));
				} else {
					double start = 0;
					for (Node n : collect) {
						n.autosize();
						n.relocate(start, getHeight() - n.prefHeight(-1));
						start += n.prefWidth(-1);
					}
				}
			}
		}

		{
			List<Node> collect = this.adornments.stream().filter((ad) -> ad.getLocation() == Location.RIGHT_BOTTOM).map((ad) -> ad.getGraphic()).filter(n -> n != null).collect(Collectors.toList());

			if (collect != null && !collect.isEmpty()) {
				if (collect.size() == 1) {
					Node graphicsNode = collect.get(0);
					graphicsNode.autosize();
					graphicsNode.relocate( getWidth() - graphicsNode.prefWidth(-1), getHeight() - graphicsNode.prefHeight(-1));
				} else {
					double start = 0;
					for (Node n : collect) {
						n.autosize();
						n.relocate( getWidth() - n.prefWidth(-1) - start, getHeight() - n.prefHeight(-1));
						start += n.prefWidth(-1);
					}
				}
			}
		}
	}
}
