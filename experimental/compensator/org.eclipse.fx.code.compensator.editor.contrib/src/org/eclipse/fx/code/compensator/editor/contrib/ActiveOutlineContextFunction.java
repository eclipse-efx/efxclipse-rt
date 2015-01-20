package org.eclipse.fx.code.compensator.editor.contrib;

import java.util.Optional;

import org.eclipse.e4.core.contexts.ContextFunction;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.contexts.RunAndTrack;
import org.eclipse.fx.code.compensator.editor.Input;
import org.eclipse.fx.code.compensator.editor.Outline;

public class ActiveOutlineContextFunction extends ContextFunction {
	@Override
	public Object compute(IEclipseContext outerContext, String contextKey) {
		if( outerContext.containsKey("_local_rat") ) {
			return null;
		}

		outerContext.set("_local_rat", Boolean.TRUE);
		outerContext.runAndTrack(new RunAndTrack() {

			@Override
			public boolean changed(IEclipseContext context) {
				outerContext.set("activeOutline",createOutline(context));
				return true;
			}
		});
		Outline outline = createOutline(outerContext);
		System.err.println("THE OUTLINE IS: " + outline);
		return outline;
	}

	private Outline createOutline(IEclipseContext context) {
		Input<?> input = (Input<?>) context.get("activeInput");
		context.set(Input.class, input);
		if( input != null ) {
			Optional<Class<? extends Outline>> outline = context.get(ServiceCollector.class).createOutline(input);
			if( outline.isPresent() ) {
				return ContextInjectionFactory.make(outline.get(),context);
			}
		}
		return null;
	}
}
