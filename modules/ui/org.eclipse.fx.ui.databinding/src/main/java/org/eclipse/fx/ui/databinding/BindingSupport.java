/*******************************************************************************
 * Copyright (c) 2022 BestSolution.at and others.
 *  
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *  
 * SPDX-License-Identifier: EPL-2.0
 *  
 * Contributors:
 *     BestSolution.at - initial API and implementation
 *******************************************************************************/
///*******************************************************************************
// * Copyright (c) 2016 BestSolution.at and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
// *
// * Contributors:
// *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
// *******************************************************************************/
//package org.eclipse.fx.ui.databinding;
//
//import org.eclipse.core.databinding.Binding;
//import org.eclipse.core.databinding.DataBindingContext;
//import org.eclipse.core.databinding.observable.value.IObservableValue;
//import org.eclipse.core.databinding.observable.value.WritableValue;
//import org.eclipse.core.runtime.IStatus;
//import org.eclipse.fx.core.Status;
//import org.eclipse.fx.core.Status.State;
//import org.eclipse.fx.ui.controls.form.DecoratedNode;
//import org.eclipse.fx.ui.controls.form.NodeDecorator;
//
//import javafx.scene.Node;
//
///**
// * Support utility to remove boilderplate code when binding values
// */
//@SuppressWarnings("restriction")
//public class BindingSupport<T> {
//	public static Binding decorate(Node node, Binding binding) {
//		DecoratedNode decoratedNode = NodeDecorator.apply(node);
//		binding.getValidationStatus().addValueChangeListener( d -> {
//			IStatus s = (IStatus) d.diff.getNewValue();
//			if( s.isOK() ) {
//				decoratedNode.setStatus(Status.ok());
//			} else {
//				State st = State.OK;
//				switch (s.getSeverity()) {
//				case IStatus.CANCEL:
//					st = State.CANCEL;
//					break;
//				case IStatus.ERROR:
//					st = State.ERROR;
//					break;
//				case IStatus.WARNING:
//					st = State.WARNING;
//					break;
//				case IStatus.INFO:
//				case IStatus.OK:
//					st = State.OK;
//					break;
//				default:
//					break;
//				}
//				decoratedNode.setStatus(
//						Status.status(st, s.getCode(), s.getMessage(), s.getException()));
//			}
//		});
//		return binding;
//	}
//
////	private final DataBindingContext context;
////	private final IObservableValue master;
////
////	public BindingSupport(DataBindingContext context, Class<T> masterType) {
////		this.context = context;
////		this.master = new WritableValue(null, masterType);
////	}
////
////	public BindingSupport(DataBindingContext context, IObservableValue masterValue) {
////		this.context = context;
////		this.master = masterValue;
////	}
//
////	public BindingBuilder create(Node node) {
////		return new BindingBuilder(this.context, node);
////	}
////
////	public static class BindingBuilder {
////		private final Node node;
////		private final DataBindingContext context;
////
////		public BindingBuilder(DataBindingContext context, Node node) {
////			this.context = context;
////			this.node = node;
////		}
////
////		public BindingBuilder model(IObservableValue master) {
////
////		}
////
////		public Binding build() {
////
////		}
////	}
//
//}
