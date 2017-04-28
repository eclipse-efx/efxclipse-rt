package org.eclipse.fx.core.di.context.internal;

import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import javax.inject.Inject;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.suppliers.ExtendedObjectSupplier;
import org.eclipse.e4.core.di.suppliers.IObjectDescriptor;
import org.eclipse.e4.core.di.suppliers.IRequestor;
import org.eclipse.e4.core.internal.di.Requestor;
import org.eclipse.fx.core.TypeTypeProviderService;
import org.eclipse.fx.core.di.Service;
import org.osgi.service.component.annotations.Component;

@SuppressWarnings("restriction")
@Component(service=ExtendedObjectSupplier.class,property="dependency.injection.annotation:String=org.eclipse.fx.core.di.LocalInstance")
public class LocalInstanceObjectSupplier extends ExtendedObjectSupplier {

	@Override
	public Object get(IObjectDescriptor descriptor, IRequestor requestor, boolean track, boolean group) {
		Requestor<?> r = (Requestor<?>) requestor;
		InstanceCreator instanceCreator = r.getInjector().make(InstanceCreator.class, r.getPrimarySupplier());

		Type descriptorsClass = descriptor.getDesiredType();

		return instanceCreator.createInstance(descriptorsClass, r.getRequestingObjectClass());
	}

	private static Class<?> getDesiredClass(Type desiredType) {
		if (desiredType instanceof Class<?>)
			return (Class<?>) desiredType;
		if (desiredType instanceof ParameterizedType) {
			Type rawType = ((ParameterizedType) desiredType).getRawType();
			if (rawType instanceof Class<?>)
				return (Class<?>) rawType;
		}
		return null;
	}

	public static class InstanceCreator {
		private final IEclipseContext context;
		private final List<TypeTypeProviderService<?>> providerList;

		@Inject
		public InstanceCreator(IEclipseContext context, @Service List<TypeTypeProviderService<?>> providerList) {
			this.context = context;
			this.providerList = providerList;
		}

		public Object createInstance(Type iType, Class<?> owner) {
			Supplier<Class<?>> classSuplier = () -> {
				if( iType instanceof Class<?> ) {
					Class<?> cl = (Class<?>) iType;
					if( ! Modifier.isAbstract(cl.getModifiers())
							&& ! Modifier.isInterface(cl.getModifiers())) {
						return (Class<?>) iType;
					}
				}
				return null;
			};

			Class<?> type = this.providerList
					.stream()
					.filter( p -> p.test(iType))
					.findFirst()
					.map( p -> (Class)p.getType(iType))
					.orElseGet( classSuplier );

			if( type == null ) {
				return null;
			}

			IEclipseContext staticContext = EclipseContextFactory.create("static"); //$NON-NLS-1$
			try {
				staticContext.set(TypeTypeProviderService.DI_KEY, owner);
				return ContextInjectionFactory.make(type, this.context, staticContext);
			} finally {
				staticContext.dispose();
			}
		}
	}
}