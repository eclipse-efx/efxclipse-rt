/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.controls;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.fx.ui.controls.styledtext.StyledString;
import org.eclipse.fx.ui.controls.styledtext.StyledStringSegment;

import javafx.geometry.BoundingBox;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Window;

/**
 * Utility methods
 *
 * @since 1.2
 */
public class Util {
	/**
	 * Dump the scene graph to a formatted string
	 *
	 * @param n
	 *            the node to start with
	 * @return the dump as a formatted XML
	 */
	public static String dumpSceneGraph(Node n) {
		return new SceneGraphDumper().dump(n).toString();
	}

	static class SceneGraphDumper {
		private StringBuilder sb = new StringBuilder();
		private int ident = 0;

		public StringBuilder dump(Node n) {
			for (int i = 0; i < this.ident; i++) {
				this.sb.append("    "); //$NON-NLS-1$
			}
			this.ident++;

			this.sb.append("<" + n.getClass().getName() + " styleClass=\"" //$NON-NLS-1$ //$NON-NLS-2$
					+ n.getStyleClass() + "\">\n"); //$NON-NLS-1$
			if (n instanceof Parent) {
				for (Node subNode : ((Parent) n).getChildrenUnmodifiable()) {
					dump(subNode);
				}
			}

			this.ident--;
			for (int i = 0; i < this.ident; i++) {
				this.sb.append("    "); //$NON-NLS-1$
			}
			this.sb.append("</" + n.getClass().getName() + ">\n"); //$NON-NLS-1$ //$NON-NLS-2$

			return this.sb;
		}
	}

	/**
	 * Create a scenegraph node from the styled string
	 *
	 * @param s
	 *            the string
	 * @return a scenegraph node
	 */
	public static Node toNode(StyledString s) {
		List<Text> segList = new ArrayList<>();
		for (StyledStringSegment seg : s.getSegmentList()) {
			Text t = new Text(seg.getText());
			t.getStyleClass().addAll(seg.getStyleClass());
			segList.add(t);
		}

		return new TextFlow(segList.toArray(new Node[0]));
	}

	/**
	 * Find a node in all windows
	 * 
	 * @param w
	 *            the preferred window
	 * @param screenX
	 *            the screen x
	 * @param screenY
	 *            the screen y
	 * @return the node or <code>null</code>
	 */
	@SuppressWarnings("deprecation")
	public static Node findNode(Window w, double screenX, double screenY) {
		// First check the owner
		if (new BoundingBox(w.getX(), w.getY(), w.getWidth(), w.getHeight()).contains(screenX, screenY)) {
			return findNode(w.getScene().getRoot(), screenX, screenY);
		}

		// FIXME If multiple match take the closest
		Iterator<Window> impl_getWindows = Window.impl_getWindows();
		while (impl_getWindows.hasNext()) {
			Window window = impl_getWindows.next();
			if (new BoundingBox(window.getX(), window.getY(), window.getWidth(), window.getHeight()).contains(screenX, screenY)) {
				return findNode(window.getScene().getRoot(), screenX, screenY);
			}
		}
		return null;
	}

	/**
	 * Find all node at the given x/y location starting the search from the
	 * given node
	 * 
	 * @param n
	 *            the node to use as the start
	 * @param screenX
	 *            the screen x
	 * @param screenY
	 *            the screen y
	 * @return the node or <code>null</code>
	 */
	public static Node findNode(Node n, double screenX, double screenY) {
		Node rv = null;
		if( ! n.isVisible() ) {
			return rv;
		}
		Point2D b = n.screenToLocal(screenX, screenY);
		if (n.getBoundsInLocal().contains(b)) {
			rv = n;
			if (n instanceof Parent) {
				for (Node c : ((Parent) n).getChildrenUnmodifiable()) {
					Node cn = findNode(c, screenX, screenY);
					if (cn != null) {
						rv = cn;
						break;
					}
				}
			}
		}
		return rv;
	}
}