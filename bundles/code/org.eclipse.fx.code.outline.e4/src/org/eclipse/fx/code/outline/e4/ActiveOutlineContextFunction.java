package org.eclipse.fx.code.outline.e4;

import java.util.Map;
import java.util.WeakHashMap;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IContextFunction;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.contexts.RunAndTrack;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.fx.code.editor.Constants;
import org.eclipse.fx.code.editor.Input;
import org.eclipse.fx.code.outline.Outline;
import org.eclipse.fx.code.outline.services.OutlineTypeProvider;
import org.eclipse.fx.core.di.context.ServiceContextFunction;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ReferencePolicyOption;

@Component(service=IContextFunction.class,property={"service.context.key=activeOutline"})
public class ActiveOutlineContextFunction extends ServiceContextFunction<OutlineTypeProvider> {
	private Map<Input<?>, Outline> outlineCache = new WeakHashMap<>();

	@Reference(cardinality=ReferenceCardinality.MULTIPLE,policy=ReferencePolicy.DYNAMIC,policyOption=ReferencePolicyOption.GREEDY)
	@Override
	protected void registerService(OutlineTypeProvider service, Map<String, Object> properties) {
		super.registerService(service, properties);
	}

	@Override
	protected void unregisterService(OutlineTypeProvider service) {
		super.unregisterService(service);
	}

	@Override
	public Object compute(IEclipseContext outerContext, String contextKey) {

		if( outerContext.containsKey("_local_rat") ) {
			return null;
		}

		outerContext.get(IEventBroker.class).subscribe(Constants.OUTLINE_RELOAD, (e) -> {
			Input<?> input = (Input<?>) e.getProperty(IEventBroker.DATA);
			outlineCache.remove(input);
			if( outerContext.get("activeInput") == input ) {
				outerContext.set("activeOutline",createOutline(outerContext));
			}
		});

		outerContext.set("_local_rat", Boolean.TRUE);
		outerContext.runAndTrack(new RunAndTrack() {

			@Override
			public boolean changed(IEclipseContext context) {
				outerContext.set("activeOutline",createOutline(context));
				return true;
			}
		});
		Outline outline = createOutline(outerContext);
		return outline;
	}

	private Outline createOutline(IEclipseContext context) {
		Input<?> input = (Input<?>) context.get("activeInput");
		context.set(Input.class, input);
		if( input != null ) {
			Outline rv = outlineCache.get(input);
			if( rv == null ) {
				synchronized (registry) {
					registry.unsynchronizedStream().filter( p -> p.test(input)).findFirst().ifPresent( p -> {
						outlineCache.put(input, ContextInjectionFactory.make(p.getType(input),context));
					});
					rv = outlineCache.get(input);
				}
			}
			return rv;
		}
		return null;
	}
}