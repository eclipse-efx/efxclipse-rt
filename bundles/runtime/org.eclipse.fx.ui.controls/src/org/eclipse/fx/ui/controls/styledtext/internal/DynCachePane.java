/*******************************************************************************
 * Copyright (c) 2016 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.controls.styledtext.internal;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.function.Supplier;

import javafx.scene.Node;
import javafx.scene.layout.Pane;

@SuppressWarnings("javadoc")
public class DynCachePane<K, N extends Node> extends Pane {

	int maxCache = 100;

	protected Map<K, N> existingNodes = new HashMap<>();

	protected Map<K, N> usedNodes = new HashMap<>();

	protected Queue<N> cachedNodes = new LinkedList<>();

	private Supplier<N> nodeFactory;

	long count = 0;

	public DynCachePane(Supplier<N> nodeFactory) {
		this.nodeFactory = nodeFactory;
	}


	protected N get(K key) {
		N node = this.usedNodes.get(key);
		if (node == null) {
			node = this.existingNodes.get(key);
		}
		if (node == null) {
			if (!this.cachedNodes.isEmpty()) {
				node = this.cachedNodes.poll();
			}
		}
		if (node == null) {

			node = this.nodeFactory.get();
			this.existingNodes.put(key, node);
		}
		this.usedNodes.put(key, node);
		node.setVisible(true);
		return node;
	}

	protected void release(K key) {
		N node = this.existingNodes.get(key);
		if (node != null) {
			node.setVisible(false);
			this.usedNodes.remove(node);
			this.cachedNodes.add(node);
		}
	}


//	protected N create(K key) {
//		N node = this.nodeFactory.get();
//		this.existingNodes.put(key, node);
//		this.getChildren().add(node);
//		count++;
//		if (count > 1000 ) {
//			System.err.println("ALLOCATED "+ count + " nodes!!!");
//		}
//		return node;
//	}
//
//	protected void destroy(K key) {
//		N removed = this.existingNodes.remove(key);
//		getChildren().remove(removed);
//	}
//
//	protected void release(K key) {
//		N removed = this.existingNodes.remove(key);
//		removed.setVisible(false);
//		cachedNodes.add(removed);
//	}
//
//	protected Optional<N> get(K key) {
//		return Optional.ofNullable(this.existingNodes.get(key));
//	}
//
//	protected N getCreate(K key) {
//		N n = this.existingNodes.get(key);
//		if (n == null) {
//			return create(key);
//		}
//		return n;
//	}





}
