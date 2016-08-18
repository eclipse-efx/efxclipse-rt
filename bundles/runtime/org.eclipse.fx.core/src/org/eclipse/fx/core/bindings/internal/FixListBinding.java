package org.eclipse.fx.core.bindings.internal;

import java.util.List;
import java.util.Objects;

import javafx.beans.binding.ListBinding;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener.Change;
import javafx.collections.ObservableList;
import javafx.collections.WeakListChangeListener;


@SuppressWarnings("javadoc")
public class FixListBinding<A> extends ListBinding<A> {
	private ObservableList<A> source;
	private ObservableList<A> fixed;
	
	private WeakListChangeListener<A> changeListener = new WeakListChangeListener<>(this::onSourceChange);
	
	public FixListBinding(ObservableList<A> source) {
		this.source = source;
		this.source.addListener(this.changeListener);
	}
	
	private void onSourceChange(Change<? extends A> change) {
		while (change.next()) {
			// we handle the setAll change explicitly to produce a nice change event
			if (change.wasRemoved() && change.wasAdded() && change.getRemovedSize() == this.fixed.size()) {
				
				int maxIdx = Math.max(change.getRemovedSize(), change.getAddedSize());
				System.err.println("removed = " + change.getRemoved());
				System.err.println("added = " + change.getAddedSubList());
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
						}
						else {
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
					System.err.println("i = " + i + " / idxAdded = " + idxAdded);
					if (idxAdded < 0) continue;
					
					final boolean inRemoved = change.getRemovedSize() > i;
					final boolean inAdded = change.getAddedSize() > idxAdded;
//					
//					if (inRemoved && !inAdded) {
//						firstMatchAfterChange = idxAdded;
//					}
					
//					if (!inAdded) {
//						System.err.println("foo");
//						firstMatchAfterChange = i;
//						if (firstMatchAfterChange == change.getRemovedSize() - 1) firstMatchAfterChange+=1;
//						break;
//					}
//					
					
					if (inAdded && inRemoved) {
						System.err.println("inAddedRemoved");
						A removed = change.getRemoved().get(i);
						A added = change.getAddedSubList().get(idxAdded);
						
						if (added == removed || Objects.equals(added, removed)) {
							// Safe
							firstMatchAfterChange = i;
							break;
						}
						else {
							// last mismatch 
						}
					}
				}
				
				System.err.println("firstMismatch = " + firstMismatch);
				System.err.println("firstMatchAfterChange = " + firstMatchAfterChange);
				
				int removed = firstMatchAfterChange - firstMismatch;
				
				if (firstMismatch != -1) {
					List<A> subList = this.fixed.subList(firstMismatch, firstMatchAfterChange);
					System.err.println("clear-add-subList = " + subList);
					subList.clear();
					if (offset + removed > 0) {
						List<? extends A> add = change.getAddedSubList().subList(firstMismatch, firstMismatch + offset + removed);
						System.err.println("add-sublist = " + add);
						subList.addAll(add);
					}
				}
				else {
					// replace
					System.err.println("REPLACE CASE");
					this.fixed.setAll(change.getAddedSubList());
				}
				
			}
			else {
				// standard jfx change handling
				if (change.wasPermutated()) {
					this.fixed.subList(change.getFrom(), change.getTo())
							.clear();
					this.fixed.addAll(change.getFrom(), change.getList()
							.subList(change.getFrom(), change.getTo()));
				} else {
					if (change.wasRemoved()) {
						this.fixed.subList(change.getFrom(),
								change.getFrom() + change.getRemovedSize())
								.clear();
					}
					if (change.wasAdded()) {
						this.fixed.addAll(change.getFrom(),
								change.getAddedSubList());
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
		this.source.removeListener(this.changeListener);
		super.dispose();
	}

}
