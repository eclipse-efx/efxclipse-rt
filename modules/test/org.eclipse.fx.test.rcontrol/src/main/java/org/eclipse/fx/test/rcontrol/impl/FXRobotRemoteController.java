/*******************************************************************************
 * Copyright (c) 2019 BestSolution.at and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.test.rcontrol.impl;

import java.time.Duration;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

import org.eclipse.fx.core.ServiceUtils;
import org.eclipse.fx.core.ThreadSynchronize;
import org.eclipse.fx.core.ThreadSynchronize.BlockCondition;
import org.eclipse.fx.test.rcontrol.Operation;
import org.eclipse.fx.test.rcontrol.Query;
import org.eclipse.fx.test.rcontrol.RController;
import org.eclipse.fx.test.rcontrol.RNode;
import org.eclipse.fx.test.rcontrol.RRobot;
import org.eclipse.fx.ui.controls.JavaFXCompatUtil;

import com.sun.glass.ui.Application;
import com.sun.glass.ui.Robot;

import javafx.event.Event;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination.ModifierValue;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;

@SuppressWarnings({ "restriction", "javadoc" })
public class FXRobotRemoteController implements RController, RRobot {
	private final Scene scene;
	private final Robot glassRobot;
	private final ThreadSynchronize threadSynchronize;

	public FXRobotRemoteController(Scene scene) {
		this.scene = scene;
		this.glassRobot = Application.GetApplication().createRobot();
		this.threadSynchronize = ServiceUtils.getService(ThreadSynchronize.class).orElse(null);
	}

	public FXRobotRemoteController(FXRobotRemoteController r) {
		this.scene = r.scene;
		this.glassRobot = r.glassRobot;
		this.threadSynchronize = r.threadSynchronize;
	}

	@Override
	public RRobot eventGenerator() {
		return this;
	}

	public final int mouseX() {
		return glassRobot.getMouseX();
	}

	public final int mouseY() {
		return glassRobot.getMouseY();
	}

	public final RController mouseMoveTo(int x, int y) {
		glassRobot.mouseMove(x, y);
		return this;
	}

	public final RController press(MouseButton button) {
		glassRobot.mousePress(button.ordinal());
		return this;
	}

	public final RController release(MouseButton button) {
		glassRobot.mouseRelease(button.ordinal());
		return this;
	}

	public final RController block(BlockCondition<Void> b) {
		threadSynchronize.block(b);
		return this;
	}

	@Override
	public RController run(Operation... ops) {
		for( Operation op : ops ) {
			op.execute(this);
		}
		sleep(100);
		return this;
	}

	@Override
	public RController waitForRender() {
		sleep(2000);
		return this;
	}

	@Override
	public <T extends Node> Query<T, ?> cssQuery(String selector) {
		return new CSSQuery<T>(this, scene.getRoot(), selector);
	}

	@Override
	public <T extends Node> Query<T, ?> labelQuery(String label) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public <T extends Node> Query<T, ?> predicateQuery(Class<T> type, Predicate<T> p) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends Node> Stream<RNode<T>> css(String selector) {
		if (scene.getRoot() != null) {
			return scene.getRoot().lookupAll(selector).stream().map(v -> new RNodeImpl<>((T) v, this));
		}
		return Stream.empty();
	}

	@Override
	public <T extends Node> Stream<RNode<T>> css(Class<T> type, String selector) {
		return this.<T>css(selector).filter(r -> type.isAssignableFrom(r.node().getClass()));
	}

	@Override
	public <T extends Node> Optional<RNode<T>> cssFirst(String selector) {
		return this.<T>css(selector).findFirst();
	}

	@Override
	public <T extends Node> Optional<RNode<T>> cssFirst(Class<T> type, String selector) {
		return this.<T>css(type, selector).findFirst();
	}

	@Override
	public <T extends Node> Optional<RNode<T>> cssFirst(Duration timeout, Class<T> type, String selector) {
		long t = timeout.toMillis();
		while( t > 0 ) {
			Optional<RNode<T>> rv = cssFirst(type, selector);
			if( rv.isPresent() ) {
				return rv;
			}
			sleep(100);
			t -= 100;
		}
		return Optional.empty();
	}

	@Override
	public <T extends Node> Optional<RNode<T>> cssFirst(Duration timeout, String selector) {
		long t = timeout.toMillis();
		while( t > 0 ) {
			Optional<RNode<T>> rv = cssFirst(selector);
			if( rv.isPresent() ) {
				return rv;
			}
			sleep(100);
			t -= 100;
		}
		return Optional.empty();
	}

	@Override
	public RController type(KeyCode... codes) {
		for( KeyCode code : codes ) {
			int c = JavaFXCompatUtil.getCode(code);
			glassRobot.keyPress(c);
			glassRobot.keyRelease(c);
		}
		return this;
	}

	@Override
	public RController type(KeyCodeCombination... combinations) {
		for( KeyCodeCombination combination : combinations ) {
			if( combination.getAlt() == ModifierValue.DOWN ) {
				glassRobot.keyPress(JavaFXCompatUtil.getCode(KeyCode.ALT));
			}
			if( combination.getShift() == ModifierValue.DOWN ) {
				glassRobot.keyPress(JavaFXCompatUtil.getCode(KeyCode.SHIFT));
			}
			if( combination.getControl() == ModifierValue.DOWN ) {
				glassRobot.keyPress(JavaFXCompatUtil.getCode(KeyCode.CONTROL));
			}

			glassRobot.keyPress(JavaFXCompatUtil.getCode(combination.getCode()));
			glassRobot.keyRelease(JavaFXCompatUtil.getCode(combination.getCode()));

			if( combination.getAlt() == ModifierValue.DOWN ) {
				glassRobot.keyRelease(JavaFXCompatUtil.getCode(KeyCode.ALT));
			}
			if( combination.getShift() == ModifierValue.DOWN ) {
				glassRobot.keyRelease(JavaFXCompatUtil.getCode(KeyCode.SHIFT));
			}
			if( combination.getControl() == ModifierValue.DOWN ) {
				glassRobot.keyRelease(JavaFXCompatUtil.getCode(KeyCode.CONTROL));
			}
		}
		return this;
	}

	@Override
	public RController text(String text) {
		Node node = scene.getFocusOwner();
		for( int i = 0; i < text.length(); i++ ) {
			KeyEvent evt = new KeyEvent(node, node, KeyEvent.KEY_TYPED,text.substring(i, i+1),text.substring(i, i+1),KeyCode.UNDEFINED,false,false,false,false);
			Event.fireEvent(node, evt);
		}
		return this;
	}

	public RController sleep(Duration duration) {
		sleep((long)duration.toMillis());
		return this;
	}

	@Override
	public RController run(Consumer<RController> c) {
		c.accept(this);
		return this;
	}

	@Override
	public <R> R run(Function<RController, R> f) {
		return f.apply(this);
	}

	@Override
	public RController run(Runnable r) {
		r.run();
		return this;
	}

	public final RController sleep(long millis) {
		BlockCondition<Void> b = new BlockCondition<>();
		this.threadSynchronize.scheduleExecution(millis, () -> b.release(null));
		this.threadSynchronize.block(b);
		return this;
	}
}