package org.eclipse.fx.code.compensator.editor.contrib;

import java.util.Map;
import java.util.Optional;
import java.util.WeakHashMap;

import org.eclipse.e4.core.contexts.ContextFunction;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.contexts.RunAndTrack;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.fx.code.compensator.editor.Constants;
import org.eclipse.fx.code.compensator.editor.Input;
import org.eclipse.fx.code.compensator.editor.Outline;

public class ActiveOutlineContextFunction extends ContextFunction {
	private Map<Input<?>, Outline> outlineCache = new WeakHashMap<>();

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
				Optional<Class<? extends Outline>> outline = context.get(ServiceCollector.class).createOutline(input);
				if( outline.isPresent() ) {
					rv = ContextInjectionFactory.make(outline.get(),context);
					outlineCache.put(input, rv);
				}
			}
			return rv;
		}
		return null;
	}
}