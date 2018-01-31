package org.eclipse.fx.core.bindings.internal;

import java.util.List;
import java.util.Objects;

import javafx.beans.binding.ListBinding;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ListChangeListener.Change;
import javafx.collections.ObservableList;
import javafx.collections.WeakListChangeListener;

@SuppressWarnings("javadoc")
public class FixListBinding<A> extends ListBinding<A> {
	private final ObservableList<A> source;
	private ObservableList<A> fixed;

	private ListChangeListener<A> changeListener = this::onSourceChange;
	private WeakListChangeListener<A> weakChangeListener = new WeakListChangeListener<>(this.changeListener);

	public FixListBinding(ObservableList<A> source) {
		this.source = source;
		this.source.addListener(this.weakChangeListener);
	}

	private void onSourceChange(Change<? extends A> change) {
		// make sure that fixed is initialized
		if (this.fixed == null) {
			this.fixed = FXCollections.observableArrayList();
		}
		while (change.next()) {
			// we handle the setAll change explicitly to produce a nice change event
			if (change.wasRemoved() && change.wasAdded() && change.getRemovedSize() == this.fixed.size()) {

				int maxIdx = Math.max(change.getRemovedSize(), change.getAddedSize());
				int firstMismatch = -1;

				for (int i = 0; i < maxIdx; i++) {
					final boolean inRemoved = change.getRemovedSize() > i;
					final boolean inAdded = change.getAddedSize() > i;

					if (inAdded != inRemoved) {
						firstMismatch = i;
						break;
					}

					if (inAdded && inRemoved) {
						A removed = change.getRemoved().get(i);
						A added = change.getAddedSubList().get(i);

						if (added == removed || Objects.equals(added, removed)) {
							// Safe
						} else {
							// first mismatch
							firstMismatch = i;
							break;
						}
					}
				}

				int offset = change.getAddedSize() - change.getRemovedSize();

				int firstMatchAfterChange = change.getRemovedSize();

				for (int i = firstMismatch; i < maxIdx; i++) {
					int idxAdded = i + offset;
					if (idxAdded < 0)
						continue;

					final boolean inRemoved = change.getRemovedSize() > i;
					final boolean inAdded = change.getAddedSize() > idxAdded;
					//
					// if (inRemoved && !inAdded) {
					// firstMatchAfterChange = idxAdded;
					// }

					// if (!inAdded) {
					// firstMatchAfterChange = i;
					// if (firstMatchAfterChange == change.getRemovedSize() - 1)
					// firstMatchAfterChange+=1;
					// break;
					// }
					//

					if (inAdded && inRemoved) {
						A removed = change.getRemoved().get(i);
						A added = change.getAddedSubList().get(idxAdded);

						if (added == removed || Objects.equals(added, removed)) {
							// Safe
							firstMatchAfterChange = i;
							break;
						} else {
							// last mismatch
						}
					}
				}

				int removed = firstMatchAfterChange - firstMismatch;

				if (firstMismatch != -1) {
					List<A> subList = this.fixed.subList(firstMismatch, firstMatchAfterChange);
					subList.clear();
					if (offset + removed > 0) {
						List<? extends A> add = change.getAddedSubList().subList(firstMismatch,
								firstMismatch + offset + removed);
						subList.addAll(add);
					}
				} else {
					// replace
					this.fixed.setAll(change.getAddedSubList());
				}

			} else {
				// standard jfx change handling
				if (change.wasPermutated()) {
					this.fixed.subList(change.getFrom(), change.getTo()).clear();
					this.fixed.addAll(change.getFrom(), change.getList().subList(change.getFrom(), change.getTo()));
				} else {
					if (change.wasRemoved()) {
						this.fixed.subList(change.getFrom(), change.getFrom() + change.getRemovedSize()).clear();
					}
					if (change.wasAdded()) {
						this.fixed.addAll(change.getFrom(), change.getAddedSubList());
					}
				}
			}
		}

	}

	@Override
	protected ObservableList<A> computeValue() {
		if (this.fixed == null) {
			this.fixed = FXCollections.observableArrayList(this.source);
		}
		return this.fixed;
	}

	@Override
	public void dispose() {
		this.source.removeListener(this.weakChangeListener);
		super.dispose();
	}

}
