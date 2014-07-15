package org.eclipse.fx.ui.workbench.renderers.base;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.contexts.RunAndTrack;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.model.application.ui.MElementContainer;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.menu.MItem;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.Selector;
import org.eclipse.e4.ui.workbench.UIEvents;
import org.eclipse.fx.core.di.ScopedObjectFactory;
import org.eclipse.fx.ui.workbench.renderers.base.EventProcessor.ChildrenHandler;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WWidget;
import org.eclipse.jdt.annotation.NonNull;

/**
 * Base renderer handling generic part for item containers
 * 
 * @param <M>
 *            the element
 * @param <I>
 *            the child type
 * @param <W>
 *            the widget
 */
public abstract class BaseItemContainerRenderer<M extends MElementContainer<I>, I extends MUIElement, W extends WWidget<M>> extends BaseRenderer<M, W> implements ChildrenHandler<M, I> {
	private List<I> widgets = new ArrayList<>();

	@Inject
	IEclipseContext context;

	@PostConstruct
	void init(IEventBroker eventBroker) {
		EventProcessor.attachChildProcessor(eventBroker, this);
		EventProcessor.attachVisibleProcessor(eventBroker, this);

		Selector noop = m -> true;
		eventBroker.subscribe(ScopedObjectFactory.KEYMODIFED_TOPIC, e -> checkExecute(noop));
		eventBroker.subscribe(UIEvents.REQUEST_ENABLEMENT_UPDATE_TOPIC, e -> {
			Object d = e.getProperty(IEventBroker.DATA);
			if (d instanceof Selector) {
				checkExecute((Selector) d);
			} else if (UIEvents.ALL_ELEMENT_ID.equals(d)) {
				checkExecute(noop);
			} else if (d != null) {
				checkExecute(m -> d.equals(m.getElementId()));
			}
		});
		eventBroker.subscribe(UIEvents.Dirtyable.TOPIC_DIRTY, e -> checkExecute(noop));
		this.context.runAndTrack(new RunAndTrack() {

			@Override
			public boolean changed(IEclipseContext context) {
				context.get(IServiceConstants.ACTIVE_CONTEXTS);
				context.get(IServiceConstants.ACTIVE_SELECTION);
				context.get(IServiceConstants.ACTIVE_PART);
				checkExecute(noop);
				return true;
			}
		});
		do_init(eventBroker);
	}

	void checkExecute(Selector selector) {
		List<I> iterationCopy;

		// not ideal because we'll probably check items are already
		// removed
		// from the ui
		synchronized (BaseItemContainerRenderer.this.widgets) {
			iterationCopy = new ArrayList<>(BaseItemContainerRenderer.this.widgets);
		}

		for (I e : iterationCopy) {
			if (e instanceof MItem && e.getRenderer() instanceof BaseItemRenderer<?, ?> && selector.select(e)) {
				final MItem tmp = (MItem) e;
				@SuppressWarnings("unchecked")
				final BaseItemRenderer<MItem, ?> r = (BaseItemRenderer<MItem, ?>) tmp.getRenderer();
				if (tmp.getRenderer() != null) {
					r.checkEnablement(tmp);
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void childRendered(M parentElement, MUIElement element) {
		if (element instanceof MItem) {
			synchronized (this.widgets) {
				this.widgets.add((I) element);
			}
		}
		do_childRendered(parentElement, element);
	}

	@Override
	public void hideChild(M container, MUIElement changedObj) {
		if (changedObj instanceof MItem) {
			synchronized (this.widgets) {
				this.widgets.remove(changedObj);
			}
		}
		do_hideChild(container, changedObj);
	}

	/**
	 * Called to init
	 * 
	 * @param broker
	 *            the event broker
	 */
	protected abstract void do_init(@NonNull IEventBroker broker);

	/**
	 * Called to render the child
	 * 
	 * @param parentElement
	 *            the parent
	 * @param element
	 *            the element
	 */
	protected abstract void do_childRendered(@NonNull M parentElement, @NonNull MUIElement element);

	/**
	 * Called to hide a child
	 * 
	 * @param container
	 *            the container
	 * @param changedObj
	 *            the child hidden
	 */
	protected abstract void do_hideChild(@NonNull M container, @NonNull MUIElement changedObj);
}
