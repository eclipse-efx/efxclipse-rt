package org.eclipse.fx.ui.controls.tabpane;

import static org.eclipse.fx.ui.controls.tabpane.DndTabPaneFactory.setup;
import static org.eclipse.fx.ui.controls.tabpane.DndTabPaneFactory.teardown;

import java.util.function.Consumer;

import org.eclipse.fx.ui.controls.tabpane.DndTabPaneFactory.DragSetup;
import org.eclipse.fx.ui.controls.tabpane.DndTabPaneFactory.FeedbackType;
import org.eclipse.fx.ui.controls.tabpane.skin.DnDTabPaneSkinHookerFullDrag;
import org.eclipse.fx.ui.controls.tabpane.skin.DndTabPaneSkinHooker;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.control.Skin;
import javafx.scene.control.SkinBase;
import javafx.scene.control.TabPane;

/**
 * A TabPane with Drag and Drop Support
 *
 * @author Adrodoc55
 */
public class DndTabPane extends TabPane {
	private static final FeedbackType DEFAULT_FEEDBACK_TYPE = FeedbackType.MARKER;
	private final BooleanProperty allowDetach = new SimpleBooleanProperty();
	private final ObjectProperty<FeedbackType> feedbackType = new SimpleObjectProperty<>(DEFAULT_FEEDBACK_TYPE);

	private DragSetup setup;

	/**
	 * Create a tab pane with a default setup for Drag and Drop Feedback
	 */
	public DndTabPane() {
		this(DEFAULT_FEEDBACK_TYPE, false);
	}

	/**
	 * Create a tab pane with a default setup for Drag and Drop Feedback
	 *
	 * @param feedbackType
	 *            the feedback type
	 * @param allowDetach
	 *            allow detaching
	 */
	public DndTabPane(FeedbackType feedbackType, boolean allowDetach) {
		setFeedbackType(feedbackType);
		setAllowDetach(allowDetach);
		initListeners(setup -> setup(this.feedbackType::get, this, getChildren(), setup, null));
	}

	/**
	 * Create a tab pane and set the drag strategy
	 *
	 * @param allowDetach
	 *            allow detaching
	 * @param setup
	 *            the setup instance for the pane
	 */
	public DndTabPane(boolean allowDetach, Consumer<DragSetup> setup) {
		this(DEFAULT_FEEDBACK_TYPE, allowDetach, setup);
	}

	/**
	 * Create a tab pane and set the drag strategy
	 *
	 * @param feedbackType
	 *            the feedback type
	 * @param allowDetach
	 *            allow detaching
	 * @param setup
	 *            the setup instance for the pane
	 */
	public DndTabPane(FeedbackType feedbackType, boolean allowDetach, Consumer<DragSetup> setup) {
		setFeedbackType(feedbackType);
		setAllowDetach(allowDetach);
		initListeners(setup);
	}

	private void initListeners(Consumer<DragSetup> setup) {
		skinProperty().addListener((observable, oldValue, newValue) -> {
			if (oldValue != null && this.setup != null) {
				teardown(this.setup);
			}
			if (newValue != null) {
				setupDnd(newValue, setup);
			}
		});
		this.allowDetach.addListener((observable, oldValue, newValue) -> {
			if (newValue != null) {
				Skin<?> skin = getSkin();
				if (skin != null) {
					setupDnd(skin, setup);
				}
			}
		});
	}

	private void setupDnd(Skin<?> skin, Consumer<DragSetup> setup) {
		if (isAllowDetach()) {
			this.setup = new DnDTabPaneSkinHookerFullDrag((SkinBase<TabPane>) skin);
		} else {
			this.setup = new DndTabPaneSkinHooker((Skin<TabPane>) skin);
		}
		setup.accept(this.setup);
	}

	/**
	 * @return a property indicating whether Tabs can be detached or not
	 */
	public BooleanProperty allowDetachProperty() {
		return this.allowDetach;
	}

	/**
	 * @return whether Tabs can be detached or not
	 */
	public boolean isAllowDetach() {
		return this.allowDetach.get();
	}

	/**
	 * @param allowDetach
	 *            whether Tabs can be detached or not
	 */
	public void setAllowDetach(boolean allowDetach) {
		this.allowDetach.set(allowDetach);
	}

	/**
	 * @return the type of visual Feedback for the User
	 */
	public ObjectProperty<FeedbackType> feedbackTypeProperty() {
		return this.feedbackType;
	}

	/**
	 * @return the type of visual Feedback for the User
	 */
	public FeedbackType getFeedbackType() {
		return this.feedbackType.get();
	}

	/**
	 * @param feedbackType
	 *            the type of visual Feedback for the User
	 */
	public void setFeedbackType(FeedbackType feedbackType) {
		this.feedbackType.set(feedbackType);
	}
}
