//package org.eclipse.fx.core.observable;
//
//import java.util.List;
//
//import org.eclipse.fx.core.Subscription;
//
//public interface ListObservable<E> extends List<E> {
//	public Subscription onListChange(ChangeSubscription<E> c);
//
//	public interface ListDiff<E> {
//
//	}
//
//	public interface ListChange<E> extends Iterable<ListDiff<E>> {
//
//	}
//
//	public interface ChangeSubscription<E> {
//		public void onListChange(ListChange<? extends E> c);
//	}
//}
