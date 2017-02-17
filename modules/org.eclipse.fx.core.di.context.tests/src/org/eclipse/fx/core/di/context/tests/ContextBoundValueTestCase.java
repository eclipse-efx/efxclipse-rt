/*******************************************************************************
 * Copyright (c) 2013 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *     Thorsten Hake <mail@thorsten-hake.com> - test for Bug 477344
 *******************************************************************************/
package org.eclipse.fx.core.di.context.tests;

import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.IValueChangeListener;
import org.eclipse.core.databinding.observable.value.ValueChangeEvent;
import org.eclipse.core.runtime.AssertionFailedException;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.fx.core.di.ContextBoundValue;
import org.eclipse.fx.core.di.ContextValue;
import org.junit.Assert;
import org.junit.Test;
import org.osgi.framework.FrameworkUtil;

/**
 * 
 */
public class ContextBoundValueTestCase {

	/**
	 *
	 */
	public static class SimpleInject {
		/**
		 * 
		 */
		@Inject
		@ContextValue("simpleValue")
		public ContextBoundValue<String> value;
	}

	/**
	 *
	 */
	public static class ObservableInject {
		/**
		 * 
		 */
		@Inject
		@ContextValue("simpleValue")
		public ContextBoundValue<String> value;

		/**
		 * 
		 */
		public IObservableValue observableValue;

		/**
		 * 
		 */
		@Inject
		@Named("simpleValue")
		@Optional
		public String injectedValue;

		@PostConstruct
		void makeObservable() {
			this.observableValue = this.value.adaptTo(IObservableValue.class);
		}
	}

	/**
	 *
	 */
	public static class DirectObservableInject {
		/**
		 * 
		 */
		@Inject
		@ContextValue("simpleValue")
		public IObservableValue value;
	}

	/**
	 *
	 */
	public static class Target {
		/**
		 * 
		 */
		@Inject
		@Named("simpleValue")
		@Optional
		public String injectedValue;

	}

	/**
	 *
	 */
	public static class ContextConsistency {
		@Inject
		@ContextValue("simpleValue")
		ContextBoundValue<String> value;

		/**
		 * @param contextValue
		 */
		@Inject
		public void testInjection(@Optional @Named("simpleValue") final String contextValue) {
			Assert.assertEquals(contextValue, this.value.getValue());
		}
	}

	/**
	 *
	 */
	public static class ContextObservableConsistency {
		@Inject
		@ContextValue("simpleValue")
		IObservableValue value;

		/**
		 * @param contextValue
		 */
		@Inject
		public void testInjection(@Optional @Named("simpleValue") final String contextValue) {

			Assert.assertEquals(contextValue, this.value.getValue());
		}
	}

	private static class ThreadRealm extends Realm {
		private final ExecutorService executor;
		private Thread realmThread;

		public ThreadRealm() {
			super();
			this.executor = Executors.newSingleThreadExecutor((r) -> {
				this.realmThread = new Thread(r, "Realm Thread"); //$NON-NLS-1$
				return this.realmThread;
			});

		}

		@Override
		public boolean isCurrent() {
			return Thread.currentThread().equals(this.realmThread);
		}

		@Override
		public void asyncExec(final Runnable runnable) {
			this.executor.submit(() -> {
				safeRun(runnable);
			});
		}
	}

	/**
	 * 
	 */
	@Test
	public void testSimpleInjection() {
		IEclipseContext serviceContext = EclipseContextFactory.getServiceContext(FrameworkUtil.getBundle(getClass()).getBundleContext());
		SimpleInject simpleInject = ContextInjectionFactory.make(SimpleInject.class, serviceContext);
		Assert.assertNotNull(simpleInject.value);
	}

	/**
	 * 
	 */
	@Test
	public void testSimpleObservable() {
		IEclipseContext serviceContext = EclipseContextFactory.getServiceContext(FrameworkUtil.getBundle(getClass()).getBundleContext());
		ObservableInject obsInject = ContextInjectionFactory.make(ObservableInject.class, serviceContext);
		Assert.assertNotNull(obsInject.observableValue);
	}

	/**
	 * 
	 */
	@Test
	public void observableSupportModify() {
		IEclipseContext serviceContext = EclipseContextFactory.getServiceContext(FrameworkUtil.getBundle(getClass()).getBundleContext());
		serviceContext.declareModifiable("simpleValue"); //$NON-NLS-1$
		ObservableInject obsInject = ContextInjectionFactory.make(ObservableInject.class, serviceContext);
		Assert.assertNull(obsInject.injectedValue);

		{
			String uuid = UUID.randomUUID().toString();
			obsInject.observableValue.setValue(uuid);

			Assert.assertEquals(uuid, obsInject.injectedValue);
			Assert.assertEquals(uuid, obsInject.value.getValue());
		}

		final AtomicBoolean bool = new AtomicBoolean();
		final String uuid = UUID.randomUUID().toString();
		obsInject.observableValue.addValueChangeListener(new IValueChangeListener() {

			@Override
			public void handleValueChange(ValueChangeEvent event) {
				bool.set(uuid.equals(event.diff.getNewValue()));
			}
		});
		serviceContext.modify("simpleValue", uuid); //$NON-NLS-1$
		Assert.assertTrue(bool.get());
	}

	/**
	 * 
	 */
	@Test
	public void testContextModify() {
		IEclipseContext serviceContext = EclipseContextFactory.getServiceContext(FrameworkUtil.getBundle(getClass()).getBundleContext());
		serviceContext.declareModifiable("simpleValue"); //$NON-NLS-1$

		Target t = ContextInjectionFactory.make(Target.class, serviceContext);

		IEclipseContext c = serviceContext.createChild();
		SimpleInject i = ContextInjectionFactory.make(SimpleInject.class, c);
		String uuid = UUID.randomUUID().toString();
		i.value.publish(uuid);

		Assert.assertEquals(uuid, t.injectedValue);
	}

	/**
	 * 
	 */
	@Test
	public void testDirectObservable() {
		IEclipseContext serviceContext = EclipseContextFactory.getServiceContext(FrameworkUtil.getBundle(getClass()).getBundleContext());
		serviceContext.declareModifiable("simpleValue"); //$NON-NLS-1$
		Realm r = new Realm() {

			@Override
			public boolean isCurrent() {
				return true;
			}

		};
		serviceContext.set(Realm.class, r);
		DirectObservableInject directObservableInject = ContextInjectionFactory.make(DirectObservableInject.class, serviceContext);
		Assert.assertNotNull(directObservableInject.value);
		Assert.assertEquals(r, directObservableInject.value.getRealm());
	}

	/**
	 * This test case checks whether the value of the ContexBoundValue equals the value that will be injected
	 * from the context.
	 */
	@Test
	public void testContextConsistency() {
		IEclipseContext serviceContext = EclipseContextFactory.getServiceContext(FrameworkUtil.getBundle(getClass()).getBundleContext());
		IEclipseContext usedContext = serviceContext.createChild();
		// resetting context variable
		usedContext.set("simpleValue", null); //$NON-NLS-1$
		// We have to create several instances of the test class, as the
		// IEclipseContext#runAndTrack does not guarantee an order of injection.
		// Having multiple objects injected increases the chances.
		for (int i = 0; i < 10; i++) {
			ContextInjectionFactory.make(ContextConsistency.class, usedContext);
		}
		// Now change the context value, assertion will be done in
		// ContextConsistency
		usedContext.set("simpleValue", "New Value!"); //$NON-NLS-1$ //$NON-NLS-2$
		usedContext.dispose();
	}

	/**
	 * 
	 */
	@Test
	public void testObservableContextConsistency() {
		IEclipseContext serviceContext = EclipseContextFactory.getServiceContext(FrameworkUtil.getBundle(getClass()).getBundleContext());
		IEclipseContext usedContext = serviceContext.createChild();
		// resetting context variable
		usedContext.set("simpleValue", null); //$NON-NLS-1$
		// We have to create several instances of the test class, as the
		// IEclipseContext#runAndTrack does not guarantee an order of injection.
		// Having multiple objects injected increases the chances.
		for (int i = 0; i < 10; i++) {
			ContextInjectionFactory.make(ContextObservableConsistency.class, usedContext);
		}
		// Now change the context value, assertion will be done in
		// ContextConsistency
		usedContext.set("simpleValue", "New Value!"); //$NON-NLS-1$ //$NON-NLS-2$
		usedContext.dispose();
	}

	/**
	 * @throws InterruptedException
	 */
	@Test
	public void testCorrectRealmUpdate() throws InterruptedException {
		IEclipseContext serviceContext = EclipseContextFactory.getServiceContext(FrameworkUtil.getBundle(getClass()).getBundleContext());
		IEclipseContext usedContext = serviceContext.createChild();
		// resetting context variable
		usedContext.set("simpleValue", null); //$NON-NLS-1$
		// Setting up a realm that is not current in this thread.
		Realm notCurrentThreadRealm = new ThreadRealm();
		usedContext.set(Realm.class, notCurrentThreadRealm);

		// Now change the context value, assertion will be done in
		// ContextConsistency
		boolean exceptionThrown = false;
		CountDownLatch eventReceived = new CountDownLatch(1);
		try {
			// Creating and changing the observable should not throw an exception
			ObservableInject injected = ContextInjectionFactory.make(ObservableInject.class, usedContext);
			// Add a listener to check if events are fired in the correct realm
			CountDownLatch listenerAdded = new CountDownLatch(1);
			// The concrete implementation of IObservableValue adds the listener in the observables realm.
			// This could be asynchronous. To preserve a synchronous workflow, we need to explicitly add the
			// listener in the Realm and wait until this is done. After that we can continue the test execution.
			notCurrentThreadRealm.exec(() -> {
				injected.observableValue.addValueChangeListener((event) -> {
					try {
						Assert.assertTrue("Events are not fired within Realm", notCurrentThreadRealm.isCurrent()); //$NON-NLS-1$
					} finally {
						eventReceived.countDown();
					}
				});
				listenerAdded.countDown();
			});
			Assert.assertTrue("Listener has not been added, cannot continue testing", listenerAdded.await(2, TimeUnit.SECONDS)); //$NON-NLS-1$
			usedContext.set("simpleValue", "New Value!"); //$NON-NLS-1$ //$NON-NLS-2$
		} catch (AssertionFailedException e) {
			exceptionThrown = true;
		} finally {
			usedContext.dispose();
		}
		Assert.assertTrue("No assertion failed exception should be thrown", !exceptionThrown); //$NON-NLS-1$
		Assert.assertTrue("Did not receive a value change event", eventReceived.await(10, TimeUnit.SECONDS)); //$NON-NLS-1$
	}
	
	/**
	 * @throws InterruptedException
	 */
	@Test
	public void testDefaultRealm() throws InterruptedException{
		IEclipseContext serviceContext = EclipseContextFactory.getServiceContext(FrameworkUtil.getBundle(getClass()).getBundleContext());
		IEclipseContext usedContext = serviceContext.createChild();
		CountDownLatch sync = new CountDownLatch(2);
		AtomicBoolean creatorThreadCurrent = new AtomicBoolean();
		AtomicBoolean independentThreadCurrent = new AtomicBoolean();
		AtomicReference<Realm> realmOfCreatedObservable = new AtomicReference<>();
		Thread threadWithoutRealm = new Thread(() -> {
			ObservableInject inject = ContextInjectionFactory.make(ObservableInject.class, usedContext);
			realmOfCreatedObservable.set(inject.observableValue.getRealm());
			//Spawn a new Thread
			Thread threadObservableNotCreatedIn = new Thread(() -> {
				independentThreadCurrent.set(realmOfCreatedObservable.get().isCurrent());				
				sync.countDown();
			});
			threadObservableNotCreatedIn.start();
			creatorThreadCurrent.set(realmOfCreatedObservable.get().isCurrent());
			sync.countDown();
		});
		threadWithoutRealm.start();
		Assert.assertTrue(sync.await(2,TimeUnit.SECONDS));
		Assert.assertTrue("Expecting default realm to be always the current realm, this is not the case for the creator thread.", creatorThreadCurrent.get()); //$NON-NLS-1$
		Assert.assertTrue("Expecting default realm to be always the current realm, this is not the case for a thread without a realm.", independentThreadCurrent.get()); //$NON-NLS-1$
		Assert.assertTrue("Expecting default realm to be always the current realm, this is not the case for the main thread.", realmOfCreatedObservable.get().isCurrent()); //$NON-NLS-1$
		usedContext.dispose();
	}
}
