package org.eclipse.fx.text.ui.hover.internal;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.eclipse.fx.text.hover.DefaultHoverInfoType;
import org.eclipse.fx.text.hover.HoverInfo;
import org.eclipse.fx.text.ui.hover.HoverPresenter;
import org.eclipse.fx.text.ui.hover.HoverWindowPresenter;

import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.control.Control;
import javafx.scene.layout.VBox;
import javafx.stage.PopupWindow;

public class DefaultHoverWindowPresenter implements HoverWindowPresenter {

	private List<HoverPresenter> presenters = new ArrayList<>();

	private final Control parent;

	private final PopupWindow popup;
	private final VBox root;

	private List<HoverInfo> currentVisible;

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

	}

	private Optional<HoverPresenter> findPresenter(HoverInfo hover) {
		return this.presenters.stream().filter(p->p.isApplicable(hover.getClass()))
				.sorted((a,b)->a.getOrder()-b.getOrder())
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
	}

	@Override
	public void show(Point2D screenAnchor, Bounds screenBounds, List<HoverInfo> hover) {
		populate(hover);
		this.popup.show(this.parent.getScene().getWindow(), screenAnchor.getX(), screenAnchor.getY());
	}

	@Override
	public void hide() {
		this.popup.hide();
	}

	public void setHoverPresenter(List<HoverPresenter> hoverPresenters) {
		this.presenters = hoverPresenters;
	}
}
