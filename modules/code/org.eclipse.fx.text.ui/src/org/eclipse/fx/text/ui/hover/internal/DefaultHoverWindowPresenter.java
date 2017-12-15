package org.eclipse.fx.text.ui.hover.internal;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.eclipse.fx.text.hover.DefaultHoverInfoType;
import org.eclipse.fx.text.hover.HoverInfo;
import org.eclipse.fx.text.ui.hover.HoverPresenter;
import org.eclipse.fx.text.ui.hover.HoverWindowPresenter;
import org.eclipse.fx.ui.controls.styledtext.StyledTextArea;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
import javafx.util.Duration;

public class DefaultHoverWindowPresenter implements HoverWindowPresenter {

	private static boolean DEBUG_HOVER = Boolean.getBoolean("org.eclipse.fx.ui.controls.styledtext.debug"); //$NON-NLS-1$
	
	private List<HoverPresenter> presenters = new ArrayList<>();

	private final StyledTextArea parent;

	private final ResizeablePopupWindow popup;
	private final VBox root;

	private List<HoverInfo> currentVisible;
	
	private boolean preventHide = false;

	private volatile Timeline hideTimeline;
	private void scheduleHide(long delay) {
		if (DEBUG_HOVER) System.err.println("DefaultHoverWindowPresenter: scheduleHide("+delay+")");  //$NON-NLS-1$//$NON-NLS-2$
		Timeline t = new Timeline();
		t.getKeyFrames().add(new KeyFrame(Duration.millis(delay), (a) -> {
			if (this.preventHide) return;
			if (t == this.hideTimeline) {
				DefaultHoverWindowPresenter.this.popup.hide();
			}
		}));
		this.hideTimeline = t;
		t.play();
	}
	private void cancelScheduledHide() {
		if (DEBUG_HOVER) System.err.println("DefaultHoverWindowPresenter: cancelScheduledHide()"); //$NON-NLS-1$
		if (this.hideTimeline != null) {
			this.hideTimeline.stop();
		}
		this.hideTimeline = null;
	}

	public DefaultHoverWindowPresenter(StyledTextArea parent) {
		this.parent = parent;
		this.root = new VBox();
		this.popup = new ResizeablePopupWindow(this.root);
		this.popup.setAutoFix(false);
		this.popup.setAutoHide(false);
		parent.sceneProperty().addListener( e -> {
			if( parent.getScene() != null ) {
				this.popup.getScene().getStylesheets().setAll(parent.getScene().getStylesheets());
				this.parent.getScene().getWindow().focusedProperty().addListener((x, o, n) -> {
					if (!n) {
						DefaultHoverWindowPresenter.this.popup.hide();
					}
				});
			}
			else {
				this.popup.getScene().getStylesheets().clear();
			}
		});
		this.popup.getScene().getRoot().setOnMouseExited(this::onMouseExited);
		this.popup.getScene().getRoot().setOnMouseEntered(this::onMouseEntered);
		this.root.setSpacing(3);
		this.root.getStyleClass().add("styled-text-hover"); //$NON-NLS-1$
	}
	
	public void configureWindowSize(Supplier<Point2D> windowSizeRetriever, Consumer<Point2D> windowSizePersister) {
		this.popup.configureWindowSize(windowSizeRetriever, windowSizePersister);
	}
	
	private void onMouseEntered(MouseEvent event) {
		if (DEBUG_HOVER) System.err.println("DefaultHoverWindowPresenter: onMouseEntered()"); //$NON-NLS-1$
		cancelScheduledHide();
		setDisableOnWebViews(this.root, false);
	}
	private void onMouseExited(MouseEvent event) {
		if (DEBUG_HOVER) System.err.println("DefaultHoverWindowPresenter: onMouseExited()"); //$NON-NLS-1$
		scheduleHide(500);
		setDisableOnWebViews(this.root, true);
	}
	
	private Optional<HoverPresenter> findPresenter(HoverInfo hover) {
		return this.presenters.stream().filter(p->p.isApplicable(hover))
				.sorted((a,b)->b.getOrder()-a.getOrder())
				.findFirst();
	}

	private int compare(HoverInfo a, HoverInfo b) {
		return a.getHoverText().compareTo(b.getHoverText());
	}

	private void populate(List<HoverInfo> hovers) {
		if (this.currentVisible != null && this.currentVisible.equals(hovers)) {
			return;
		}
		this.root.getChildren().clear();

		List<HoverInfo> errors = hovers.stream().filter(h->h.getType() == DefaultHoverInfoType.ERROR).sorted(this::compare).collect(Collectors.toList());
		List<HoverInfo> warnings = hovers.stream().filter(h->h.getType() == DefaultHoverInfoType.WARNING).sorted(this::compare).collect(Collectors.toList());
		List<HoverInfo> infos = hovers.stream().filter(h->h.getType() == DefaultHoverInfoType.INFO).sorted(this::compare).collect(Collectors.toList());
		List<HoverInfo> docs = hovers.stream().filter(h->h.getType() == DefaultHoverInfoType.DOCUMENTATION).sorted(this::compare).collect(Collectors.toList());
		List<HoverInfo> others = hovers.stream().filter(h->!errors.contains(h) && !warnings.contains(h) && !infos.contains(h) && !docs.contains(h)).sorted(this::compare).collect(Collectors.toList());

		if (!errors.isEmpty()) {
			VBox errorNode = new VBox();
			errorNode.getStyleClass().add("errors"); //$NON-NLS-1$
			errorNode.getChildren().addAll(errors.stream().map(e->findPresenter(e).map(p->p.createHoverContent(e))).filter(x->x.isPresent()).map(x->x.get()).collect(Collectors.toList()));
			this.root.getChildren().add(errorNode);
		}

		if (!warnings.isEmpty()) {
			VBox warnNode = new VBox();
			warnNode.getStyleClass().add("warnings"); //$NON-NLS-1$
			warnNode.getChildren().addAll(warnings.stream().map(e->findPresenter(e).map(p->p.createHoverContent(e))).filter(x->x.isPresent()).map(x->x.get()).collect(Collectors.toList()));
			this.root.getChildren().add(warnNode);
		}

		if (!infos.isEmpty()) {
			VBox infoNode = new VBox();
			infoNode.getStyleClass().add("infos"); //$NON-NLS-1$
			infoNode.getChildren().addAll(infos.stream().map(e->findPresenter(e).map(p->p.createHoverContent(e))).filter(x->x.isPresent()).map(x->x.get()).collect(Collectors.toList()));
			this.root.getChildren().add(infoNode);
		}

		if (!docs.isEmpty()) {
			VBox docsNode = new VBox();
			docsNode.getStyleClass().add("docs"); //$NON-NLS-1$
			docsNode.getChildren().addAll(docs.stream().map(e->findPresenter(e).map(p->p.createHoverContent(e))).filter(x->x.isPresent()).map(x->x.get()).collect(Collectors.toList()));
			this.root.getChildren().add(docsNode);
		}

		if (!others.isEmpty()) {
			VBox othersNode = new VBox();
			othersNode.getStyleClass().add("others"); //$NON-NLS-1$
			othersNode.getChildren().addAll(others.stream().map(e->
						findPresenter(e)
						.map(p->p.createHoverContent(e))
					)
					.filter(x->x.isPresent())
					.map(x->x.get())
					.collect(Collectors.toList())
			);
			this.root.getChildren().add(othersNode);
		}


		this.currentVisible = hovers;
		setDisableOnWebViews(this.root, true);
	}

	void setDisableOnWebViews(Node cur, boolean state) {
		if (cur instanceof WebView) {
			cur.setDisable(state);
		}
		else if (cur instanceof Parent) {
			((Parent)cur).getChildrenUnmodifiable().forEach(n->setDisableOnWebViews(n, state));
		}
	}
	
	@Override
	public void show(Point2D screenAnchor, Bounds screenBounds, List<HoverInfo> hover) {
		cancelScheduledHide();
		populate(hover);
		this.popup.show(this.parent.getScene().getWindow(), screenAnchor.getX(), screenAnchor.getY(), this.parent.getFixedLineHeight());
	}

	@Override
	public void hide() {
		scheduleHide(300);
	}

	public void setHoverPresenter(List<HoverPresenter> hoverPresenters) {
		this.presenters = hoverPresenters;
	}
}
