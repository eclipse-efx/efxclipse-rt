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

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.eclipse.fx.core.Subscription;

import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

@SuppressWarnings("javadoc")
public class FXBindUtil {

	public static <A, B> Subscription uniMapBindList(ObservableList<A> a, ObservableList<B> b, Function<A, B> map) {
		final ListChangeListener<A> aChange = (ListChangeListener.Change<? extends A> change) -> {
			while (change.next()) {
				if (change.wasPermutated()) {
					List<B> beforePermutate = b.subList(change.getFrom(), change.getTo());
					for (int i = 0; i < beforePermutate.size(); i++) {
						b.set(change.getPermutation(change.getFrom() + i), beforePermutate.get(i));
					}
				}

				if (change.wasRemoved()) {
					b.remove(change.getFrom(), change.getFrom() + change.getRemovedSize());
				}
				if (change.wasAdded()) {
					List<? extends A> added = change.getAddedSubList();
					List<B> addedMapped = added.stream().map(map).collect(Collectors.toList());

					b.addAll(change.getFrom(), addedMapped);

				}
				else if (change.wasUpdated() || change.wasReplaced()) {
					List<? extends A> updated = a.subList(change.getFrom(), change.getTo());
					List<B> updatedMapped = updated.stream().map(map).collect(Collectors.toList());
					for (int i = 0; i < updatedMapped.size(); i++) {
						b.set(change.getFrom(), updatedMapped.get(i));
					}
				}
			}
		};

		a.addListener(aChange);

		return new Subscription() {
			@Override
			public void dispose() {
				a.removeListener(aChange);
			}
		};
	}

//	public static void main(String[] args) {
//		ObservableList<String> a = FXCollections.observableArrayList();
//		ObservableList<Integer> b = FXCollections.observableArrayList();
//
//		uniMapBindList(a, b, Integer::valueOf);
//
//		a.add("1");
//		assert(b.get(0) == 1);
//
//		a.add("2");
//		assert b.get(1) == 2;
//
//		a.add("3");
//		assert b.get(2) == 3;
//
//		a.remove("2");
//		assert b.get(1) == 3;
//
//		a.addAll(1, Arrays.asList("5", "6"));
//		assert b.get(1) == 5;
//		assert b.get(2) == 6;
//		assert b.get(3) == 3;
//
//		ArrayList<String> copy = new ArrayList<>(a);
//		String string = copy.get(2);
//		copy.remove(2);
//		copy.add(1, string);
//
//		a.setAll(copy);
//		assert b.get(1) == 6;
//		assert b.get(2) == 5;
//	}

}
