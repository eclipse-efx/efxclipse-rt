package org.eclipse.fx.ui.controls.tree;

import java.util.List;
import java.util.function.Function;

import javafx.scene.control.Label;
import javafx.scene.control.TreeCell;

import org.eclipse.fx.ui.controls.styledtext.StyledLabel;
import org.eclipse.fx.ui.controls.styledtext.StyledString;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * A cell who knows how to deal {@link StyledString}
 *
 * @param <T>
 *            the domain type
 * @since 1.2
 */
public class SimpleTreeCell<T> extends TreeCell<T> {
	private final Function<@Nullable T, @Nullable CharSequence> labelExtractor;
	private final Function<@Nullable T, @NonNull List<@NonNull String>> cssClassProvider;

	/**
	 * Create a new instance
	 *
	 * @param labelExtractor
	 *            extract the text from the domain object
	 * @param cssClassProvider
	 *            get the CSS classes for the given domain object
	 */
	public SimpleTreeCell(
			Function<@Nullable T, @Nullable CharSequence> labelExtractor,
			Function<@Nullable T, @NonNull List<@NonNull String>> cssClassProvider) {
		this.labelExtractor = labelExtractor;
		this.cssClassProvider = cssClassProvider;
	}

	@Override
	protected void updateItem(T item, boolean empty) {
		super.updateItem(item, empty);
		if (!empty) {
			CharSequence t = this.labelExtractor.apply(item);
			if (t == null) {
				setGraphic(null);
			} else if (t instanceof StyledString) {
				StyledLabel l = new StyledLabel((StyledString) t);
				l.getStyleClass().addAll(this.cssClassProvider.apply(item));
				setGraphic(l);
			} else {
				Label l = new Label(t.toString());
				l.getStyleClass().addAll(this.cssClassProvider.apply(item));
				setGraphic(l);
			}
		} else {
			setGraphic(null);
		}
	}
}
