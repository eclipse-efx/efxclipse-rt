package org.eclipse.fx.core.junit;

import org.eclipse.fx.core.ServiceUtils;
import org.eclipse.fx.core.event.EventBus;
import org.eclipse.fx.core.event.GlobalEventBus;
import org.eclipse.fx.core.event.SimpleEventBus;
import org.eclipse.fx.core.event.Topic;
import org.junit.runner.Description;
import org.junit.runner.notification.RunListener;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;

public class JUnitRunner extends BlockJUnit4ClassRunner {

	public static Topic<Description> BEFORE_TEST_TOPIC = new Topic<>("org/eclipse/fx/core/junit/test/before");
	public static Topic<Description> AFTER_TEST_TOPIC = new Topic<>("org/eclipse/fx/core/junit/test/after");

	private EventBus eventBus;

	public JUnitRunner(Class<?> klass) throws InitializationError {
		super(klass);
		this.eventBus = ServiceUtils.getService(GlobalEventBus.class)
					.map( e -> (EventBus)e)
					.orElseGet( () -> new SimpleEventBus());
	}

	@Override
	public void run(RunNotifier notifier) {
		notifier.addListener(new Listener(eventBus));
		super.run(notifier);
	}

	static class Listener extends RunListener {
		private final EventBus eventBus;

		public Listener(EventBus eventBus) {
			this.eventBus = eventBus;
		}

		@Override
		public void testStarted(Description description) throws Exception {
			super.testStarted(description);
			eventBus.publish(BEFORE_TEST_TOPIC, description, true);
		}

		@Override
		public void testFinished(Description description) throws Exception {
			super.testFinished(description);
			eventBus.publish(AFTER_TEST_TOPIC, description, true);
		}
	}
}
