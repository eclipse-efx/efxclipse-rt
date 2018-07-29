package org.eclipse.fx.ui.preferences.context;

import javax.inject.Inject;

import org.eclipse.e4.core.contexts.ContextFunction;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IContextFunction;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.fx.core.Memento;
import org.eclipse.fx.core.MementoStore;
import org.eclipse.fx.ui.preferences.PreferencePage;
import org.eclipse.fx.ui.preferences.PreferencePageFactory;
import org.eclipse.fx.ui.preferences.PreferencePageProvider;
import org.osgi.framework.FrameworkUtil;
import org.osgi.service.component.annotations.Component;

import javafx.scene.layout.BorderPane;

@Component(property = "service.context.key:String=org.eclipse.fx.ui.preferences.PreferencePageFactory")
public class PreferencePageFactoryCF extends ContextFunction implements IContextFunction {

	@Override
	public Object compute(IEclipseContext context, String contextKey) {
		return ContextInjectionFactory.make(PreferencePageFactoryImpl.class, context);
	}

	static class PreferencePageFactoryImpl implements PreferencePageFactory {
		private final IEclipseContext context;
		private final MementoStore store;
		
		@Inject
		public PreferencePageFactoryImpl(IEclipseContext context, @org.eclipse.e4.core.di.annotations.Optional MementoStore store) {
			this.context = context;
			this.store = store;
		}

		@Override
		public PreferencePage make(BorderPane parent, PreferencePageProvider provider) {
			IEclipseContext ctx = context.createChild(provider.id());
			ctx.set(BorderPane.class, parent);
			ctx.set(PreferencePageProvider.class, provider);
			
			Memento memento = provider.memento().orElseGet( () -> {
				if( store != null ) {
					String prefId = FrameworkUtil.getBundle(provider.getClass()).getSymbolicName();
					return store.getMemento(prefId);
				}
				return null;
			});
			
			if( memento != null ) {
				ctx.set(Memento.class, memento);	
			}
			
			return ContextInjectionFactory.make(provider.pageType(), ctx);
		}

	}
}
