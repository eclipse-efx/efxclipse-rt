package org.eclipse.fx.text.ui.hover.internal;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

import org.eclipse.fx.text.hover.DefaultHoverInfoType;
import org.eclipse.fx.text.hover.HoverInfo;
import org.eclipse.fx.text.ui.TextViewerHoverManager;
import org.eclipse.fx.text.ui.hover.HoverPresenter;
import org.eclipse.fx.text.ui.hover.HoverWindowPresenter;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Control;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
import javafx.stage.Popup;
import javafx.stage.PopupWindow;
import javafx.stage.Screen;
import javafx.stage.WindowEvent;
import javafx.util.Duration;

public class DefaultHoverWindowPresenter implements HoverWindowPresenter {

	private List<HoverPresenter> presenters = new ArrayList<>();

	private final Control parent;

	private final PopupWindow popup;
	private final VBox root;

	private List<HoverInfo> currentVisible;
	
	private boolean preventHide = false;

	private AtomicReference<Boolean> currentScheduledHide = new AtomicReference<>(true);
	private void scheduleHide(long delay) {
		this.currentScheduledHide.set(true);
		Timeline t = new Timeline(new KeyFrame(Duration.millis(delay), (a) -> {
			if (preventHide) return;
			if (this.currentScheduledHide.get()) {
				DefaultHoverWindowPresenter.this.popup.hide();
			}
		}));
		t.play();
	}
	private void cancelScheduledHide() {
		this.currentScheduledHide.set(false);
	}

	
	
	public DefaultHoverWindowPresenter(Control parent) {
		this.parent = parent;
		this.popup = new PopupWindow() {
		};
		this.popup.setAutoFix(false);
		this.popup.setAutoHide(false);
		parent.sceneProperty().addListener( e -> {
			if( parent.getScene() != null ) {
				popup.getScene().getStylesheets().setAll(parent.getScene().getStylesheets());
			}
			else {
				this.popup.getScene().getStylesheets().clear();
			}
		});
		this.root = new VBox();
		this.root.setSpacing(3);
		this.root.getStyleClass().add("styled-text-hover");
		this.popup.getScene().setRoot(this.root);
//		this.popup.setAnchorLocation(AnchorLocation.CONTENT_BOTTOM_LEFT);
		
		
		this.popup.setOnShowing(this::onShowing);
		this.popup.setOnShown(this::onShown);

		
		this.root.setOnMouseEntered(this::onMouseEntered);
		this.root.setOnMouseExited(this::onMouseExited);
		
	}
	
	private void onMouseEntered(MouseEvent event) {
		cancelScheduledHide();
		preventHide = true;
		
		setDisableOnWebViews(root, false);
	}
	private void onMouseExited(MouseEvent event) {
		preventHide = false;
		
		setDisableOnWebViews(root, true);
	}
	
	private void onShowing(WindowEvent event) {
		// fix popup size to stay on screen
		
		this.root.setPrefHeight(150);
		this.root.setPrefWidth(500);
		
		Rectangle2D popupBounds = new Rectangle2D( this.popup.getX(), this.popup.getY(), this.popup.getWidth(), this.popup.getHeight());
		ObservableList<Screen> screens = Screen.getScreensForRectangle( this.popup.getX(), this.popup.getY(), this.popup.getWidth(), this.popup.getHeight());
		System.err.println(popupBounds);
		System.err.println(screens);
		
		Optional<Screen> popupScreen = screens.stream().filter(s -> s.getBounds().contains(popup.getX(), popup.getY())).findFirst();
		
		
		if (popupScreen.isPresent()) {
			Screen screen = popupScreen.get();
			
			boolean isOk = screen.getBounds().contains(popupBounds);
			
			if (!isOk) {
//				System.err.println("Popup: needs fixing!!");
				if (!screen.getBounds().contains(this.popup.getX(), this.popup.getY() + this.popup.getHeight())) {
//					System.err.println("Popup: needs height adjustment");
					double adjustedHeight = screen.getBounds().getMaxY() - this.popup.getY();
					System.err.println("Popup: adjusted height = " + adjustedHeight);
					this.root.setPrefHeight(adjustedHeight);
				}
				if (!screen.getBounds().contains(this.popup.getX() + this.popup.getWidth(), this.popup.getY())) {
//					System.err.println("Popup: needs x adjustment");
					double adjustedX = screen.getBounds().getMaxX() - this.popup.getWidth();
//					System.err.println("Popup: adjusted X = " + adjustedX);
					this.popup.setX(adjustedX);
				}
			}
			else {
//				System.err.println("Popup: perfectly visible");
			}
		}
				
	}
	private void onShown(WindowEvent event) {
		
		
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
		setDisableOnWebViews(root, true);
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
		this.popup.show(this.parent.getScene().getWindow(), screenAnchor.getX(), screenAnchor.getY());
	}

	@Override
	public void hide() {
		scheduleHide(300);
	}

	public void setHoverPresenter(List<HoverPresenter> hoverPresenters) {
		this.presenters = hoverPresenters;
	}
}
