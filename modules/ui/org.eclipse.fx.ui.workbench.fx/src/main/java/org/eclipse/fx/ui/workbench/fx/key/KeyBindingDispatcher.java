/*******************************************************************************
 * Copyright (c) 2012 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.workbench.fx.key;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import javax.inject.Inject;

import org.eclipse.core.commands.Command;
import org.eclipse.core.commands.ParameterizedCommand;
import org.eclipse.core.commands.common.CommandException;
import org.eclipse.e4.core.commands.EHandlerService;
import org.eclipse.e4.core.commands.internal.HandlerServiceImpl;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.fx.ui.keybindings.Binding;
import org.eclipse.fx.ui.keybindings.KeyLookup;
import org.eclipse.fx.ui.keybindings.KeySequence;
import org.eclipse.fx.ui.keybindings.KeyStroke;
import org.eclipse.fx.ui.keybindings.e4.EBindingService;
import org.eclipse.fx.ui.keybindings.service.BindingFactory;
import org.eclipse.fx.ui.services.commands.NativeStrategy;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * Dispatch key bindings to commands
 */
@SuppressWarnings("restriction")
public class KeyBindingDispatcher {

	/**
	 * Filter for key events
	 */
	public class KeyDownFilter implements EventHandler<KeyEvent> {
		private transient boolean enabled = true;

		@SuppressWarnings("null")
		@Override
		public void handle(KeyEvent event) {
			if (!this.enabled) {
				return;
			}

			filterKeySequenceBindings(event);
		}

		/**
		 * Returns whether the key binding filter is enabled.
		 * 
		 * @return Whether the key filter is enabled.
		 */
		public final boolean isEnabled() {
			return this.enabled;
		}

		/**
		 * Sets whether this filter should be enabled or disabled.
		 * 
		 * @param enabled
		 *            Whether key binding filter should be enabled.
		 */
		public final void setEnabled(final boolean enabled) {
			this.enabled = enabled;
		}
	}

	@NonNull
	private final IEclipseContext context;
	@NonNull
	private final EventHandler<KeyEvent> keyHandler = new KeyDownFilter();
	@Nullable
	private EBindingService bindingService;
	@NonNull
	private KeySequence state;

	// private long startTime;

	@NonNull
	private final BindingFactory factory;
	
	@NonNull
	private final KeyLookup lookup;

	@Nullable
	private EHandlerService handlerService;

	/**
	 * Create a new dispatcher
	 * 
	 * @param context
	 *            the context
	 * @param factory
	 *            the binding factory
	 * @param lookup
	 *            the key lookup
	 */
	@Inject
	public KeyBindingDispatcher(@NonNull IEclipseContext context, @NonNull BindingFactory factory, @NonNull KeyLookup lookup) {
		this.context = context;
		this.factory = factory;
		this.lookup = lookup;
		this.state = factory.getKeySequenceInstance();
	}

	/**
	 * @return the handler to attache
	 */
	public @NonNull EventHandler<KeyEvent> getKeyHandler() {
		return this.keyHandler;
	}

	private static boolean isModifierKey(KeyEvent event) {
		switch (event.getCode()) {
		case ALT:
		case CONTROL:
		case SHIFT:
		case COMMAND:
			return true;
		default:
			return false;
		}
	}

	private static boolean hasModifierPressed(KeyEvent event) {
		return event.isAltDown() || event.isControlDown() || event.isMetaDown() || event.isShiftDown();
	}

	void filterKeySequenceBindings(@NonNull KeyEvent event) {
		/*
		 * Only process key strokes containing natural keys to trigger key
		 * bindings.
		 */
		if (isModifierKey(event)) {
			return;
		}

		// Allow special key out-of-order processing.
		List<@NonNull KeyStroke> keyStrokes = generatePossibleKeyStrokes(event);

		// if (isOutOfOrderKey(keyStrokes)) {
		// // Widget widget = event.widget;
		// if ((event.getCode() == KeyCode.DELETE)
		// && ! isModifierKey(event)
		// /*&& ((widget instanceof Text) || (widget instanceof Combo) ||
		// (widget instanceof Browser))*/) {
		// /*
		// * KLUDGE. Bug 54654. The text widget relies on no listener doing any
		// work before
		// * dispatching the native delete event. This does not work, as we are
		// restricted to
		// * listeners. However, it can be said that pressing a delete key in a
		// text widget
		// * will never use key bindings. This can be shown be considering how
		// the event
		// * dispatching is expected to work in a text widget. So, we should do
		// nothing ...
		// * ever.
		// */
		// return;
		//
		// // } else if (widget instanceof StyledText) {
		// //
		// // if (event.type == SWT.KeyDown) {
		// // /*
		// // * KLUDGE. Some people try to do useful work in verify listeners.
		// The way verify
		// // * listeners work in SWT, we need to verify the key as well;
		// otherwise, we can't
		// // * detect that useful work has been done.
		// // */
		// // if (!outOfOrderVerifyListener.isActive(event.time)) {
		// // ((StyledText)
		// widget).addVerifyKeyListener(outOfOrderVerifyListener);
		// // outOfOrderVerifyListener.setActive(event.time);
		// // }
		// // }
		// //
		// } else {
		// if (!outOfOrderListener.isActive(event.time)) {
		// widget.addListener(SWT.KeyDown, outOfOrderListener);
		// outOfOrderListener.setActive(event.time);
		// }
		// }
		//
		// /*
		// * Otherwise, we count on a key down arriving eventually. Expecting
		// out of order
		// * handling on Ctrl+Tab, for example, is a bad idea (stick to keys
		// that are not window
		// * traversal keys).
		// */
		//
		// } else {
		processKeyEvent(keyStrokes, event);
		// }
	}

	private @NonNull List<@NonNull KeyStroke> generatePossibleKeyStrokes(@NonNull KeyEvent event) {
		final List<@NonNull KeyStroke> keyStrokes = new ArrayList<>(3);

		/*
		 * If this is not a keyboard event, then there are no key strokes. This
		 * can happen if we are listening to focus traversal events.
		 */
		if (!hasModifierPressed(event) && (event.getCode() == KeyCode.UNDEFINED) /*
																				 * &&
																				 * (
																				 * event
																				 * .
																				 * character
																				 * ==
																				 * 0
																				 * )
																				 */) {
			return keyStrokes;
		}

		// Add each unique key stroke to the list for consideration.
		final int firstAccelerator = FxKeySupport.convertEventToUnmodifiedAccelerator(event);
		keyStrokes.add(FxKeySupport.convertAcceleratorToKeyStroke(this.factory, this.lookup, firstAccelerator));

		// We shouldn't allow delete to undergo shift resolution.
		if (event.getCode() == KeyCode.DELETE) {
			return keyStrokes;
		}

		final int secondAccelerator = FxKeySupport.convertEventToUnshiftedModifiedAccelerator(event);
		if (secondAccelerator != firstAccelerator) {
			keyStrokes.add(FxKeySupport.convertAcceleratorToKeyStroke(this.factory, this.lookup, secondAccelerator));
		}

		final int thirdAccelerator = FxKeySupport.convertEventToModifiedAccelerator(event);
		if ((thirdAccelerator != secondAccelerator) && (thirdAccelerator != firstAccelerator)) {
			keyStrokes.add(FxKeySupport.convertAcceleratorToKeyStroke(this.factory, this.lookup, thirdAccelerator));
		}

		return keyStrokes;
	}

	void processKeyEvent(@NonNull List<@NonNull KeyStroke> keyStrokes, @NonNull KeyEvent event) {
		// Dispatch the keyboard shortcut, if any.
		boolean eatKey = false;

		if (!keyStrokes.isEmpty()) {
			eatKey = press(keyStrokes, event);
		}

		if (eatKey) {
			event.consume();
			// switch (event.type) {
			// case SWT.KeyDown:
			// event.doit = false;
			// break;
			// case SWT.Traverse:
			// event.detail = SWT.TRAVERSE_NONE;
			// event.doit = true;
			// break;
			// default:
			// }
			// event.type = SWT.NONE;
		}
	}

	private boolean press(@NonNull List<@NonNull KeyStroke> potentialKeyStrokes, @NonNull KeyEvent event) {
		KeySequence errorSequence = null;
		Collection<Binding> errorMatch = null;

		KeySequence sequenceBeforeKeyStroke = this.state;
		for (Iterator<@NonNull KeyStroke> iterator = potentialKeyStrokes.iterator(); iterator.hasNext();) {
			KeySequence sequenceAfterKeyStroke = this.factory.getKeySequenceInstance(sequenceBeforeKeyStroke, iterator.next());

			if (isPartialMatch(sequenceAfterKeyStroke)) {
				incrementState(sequenceAfterKeyStroke);
				return true;

			} else if (isPerfectMatch(sequenceAfterKeyStroke)) {
				final ParameterizedCommand cmd = getPerfectMatch(sequenceAfterKeyStroke);
				try {
					return executeCommand(cmd, event) || !sequenceBeforeKeyStroke.isEmpty();
				} catch (final CommandException e) {
					return true;
				}

				// } else if ((keyAssistDialog != null)
				// && (keyAssistDialog.getShell() != null)
				// && ((event.keyCode == SWT.ARROW_DOWN) || (event.keyCode ==
				// SWT.ARROW_UP)
				// || (event.keyCode == SWT.ARROW_LEFT)
				// || (event.keyCode == SWT.ARROW_RIGHT) || (event.keyCode ==
				// SWT.CR)
				// || (event.keyCode == SWT.PAGE_UP) || (event.keyCode ==
				// SWT.PAGE_DOWN))) {
				// // We don't want to swallow keyboard navigation keys.
				// return false;

			} else {
				Collection<Binding> matches = getBindingService().getConflictsFor(sequenceAfterKeyStroke);
				if (matches != null && !matches.isEmpty()) {
					errorSequence = sequenceAfterKeyStroke;
					errorMatch = matches;
				}
			}
		}
		resetState(true);
		if (sequenceBeforeKeyStroke.isEmpty() && errorSequence != null) {
			openKeyAssistShell(errorMatch);
		}
		return !sequenceBeforeKeyStroke.isEmpty();
	}

	private @Nullable ParameterizedCommand getPerfectMatch(@NonNull KeySequence keySequence) {
		Binding perfectMatch = getBindingService().getPerfectMatch(keySequence);
		return perfectMatch == null ? null : perfectMatch.getParameterizedCommand();
	}

	private boolean isPartialMatch(@NonNull KeySequence keySequence) {
		return getBindingService().isPartialMatch(keySequence);
	}

	private boolean isPerfectMatch(@NonNull KeySequence keySequence) {
		return getBindingService().isPerfectMatch(keySequence);
	}

	private void resetState(boolean clearRememberedState) {
		// this.startTime = Long.MAX_VALUE;
		this.state = this.factory.getKeySequenceInstance();
		// closeMultiKeyAssistShell();
		// if (keyAssistDialog != null && clearRememberedState) {
		// keyAssistDialog.clearRememberedState();
		// }
	}

	private @NonNull EBindingService getBindingService() {
		EBindingService bindingService = this.bindingService;
		if (bindingService == null) {
			bindingService = (EBindingService) this.context.get(EBindingService.class.getName());
			if( bindingService == null ) {
				throw new IllegalStateException("EBindingService service must not be null"); //$NON-NLS-1$
			}
			this.bindingService = bindingService;
		}
		return bindingService;
	}

	private void incrementState(@NonNull final KeySequence sequence) {
		this.state = sequence;
		// Record the starting time.
		// this.startTime = System.currentTimeMillis();
		// final long myStartTime = startTime;
		// final Display display = getDisplay();
		// display.timerExec(DELAY, new Runnable() {
		// public void run() {
		// if ((System.currentTimeMillis() > (myStartTime - DELAY))
		// && (startTime == myStartTime)) {
		// Collection<Binding> partialMatches =
		// bindingService.getPartialMatches(sequence);
		// openKeyAssistShell(partialMatches);
		// }
		// }
		// });
	}

	private final void openKeyAssistShell(final Collection<Binding> bindings) {
		// if (keyAssistDialog == null) {
		// keyAssistDialog = new KeyAssistDialog(context, this);
		// }
		// if (keyAssistDialog.getShell() == null) {
		// keyAssistDialog.setParentShell(getDisplay().getActiveShell());
		// }
		// keyAssistDialog.open(bindings);
	}

	private final boolean executeCommand(final ParameterizedCommand parameterizedCommand, final Event trigger) throws CommandException {

		// Reset the key binding state (close window, clear status line, etc.)
		resetState(false);

		final EHandlerService handlerService = getHandlerService();
		final Command command = parameterizedCommand.getCommand();

		final IEclipseContext staticContext = EclipseContextFactory.create("keys-staticContext"); //$NON-NLS-1$
		staticContext.set(Event.class, trigger);

		final boolean commandDefined = command.isDefined();
		// boolean commandEnabled;
		boolean commandHandled;

		try {
			 if( ! handlerService.canExecute(parameterizedCommand, staticContext) ) {
				 return false;
			 }
			commandHandled = HandlerServiceImpl.lookUpHandler(this.context, command.getId()) != null;

			try {
				Object o = handlerService.executeHandler(parameterizedCommand, staticContext);
				if (o == NativeStrategy.PROCEED) {
					return false;
				}
			} catch (final Exception e) {
				commandHandled = false;
				e.printStackTrace();
			}
			/*
			 * Now that the command has executed (and had the opportunity to use
			 * the remembered state of the dialog), it is safe to delete that
			 * information.
			 */
			// if (keyAssistDialog != null) {
			// keyAssistDialog.clearRememberedState();
			// }
		} finally {
			staticContext.dispose();
		}
		return (commandDefined && commandHandled);
	}

	private @NonNull EHandlerService getHandlerService() {
		EHandlerService handlerService = this.handlerService;
		if (handlerService == null) {
			handlerService = (EHandlerService) this.context.get(EHandlerService.class.getName());
			if( handlerService == null ) {
				throw new IllegalStateException("EHandlerService must not be null"); //$NON-NLS-1$
			}
			this.handlerService = handlerService;
		}
		return handlerService;
	}
}
