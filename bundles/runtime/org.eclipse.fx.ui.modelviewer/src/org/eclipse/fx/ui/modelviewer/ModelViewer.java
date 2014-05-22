/*******************************************************************************
 * Copyright (c) 2013 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.modelviewer;

import java.util.HashMap;
import java.util.Map;

import javafx.scene.Node;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeView;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.e4.ui.model.application.MApplicationElement;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.fx.core.di.ContextBoundValue;
import org.eclipse.fx.core.di.ContextValue;
import org.eclipse.fx.core.di.ScopedObjectFactory;
import org.eclipse.fx.core.log.Log;
import org.eclipse.fx.core.log.Logger;
import org.eclipse.fx.ui.databinding.TreeUtil;
import org.eclipse.fx.ui.databinding.TreeUtil.ObservableFactory;
import org.eclipse.fx.ui.modelviewer.delegates.ElementDelegateRegistry;
import org.eclipse.fx.ui.modelviewer.internal.StyledString;

/**
 * Viewer of the application model
 */
public class ModelViewer {
	@Inject
	ModelProvider modelProvider;
	
	@Inject
	ElementDelegateRegistry registry;
	
	@Inject
	@Log
	Logger logger;
	
	@Inject
	ScopedObjectFactory objectFactory;
	
	private DelegateLookup lookup = new DelegateLookup();
	
	@Inject
	@ContextValue("delegateLookup")
	ContextBoundValue<DelegateLookup> lookupSlot;
	
	@PostConstruct
	void initUI(BorderPane p) {
		lookupSlot.publish(lookup);
		SplitPane main = new SplitPane();
		main.getItems().addAll(createTreeArea(), createDetailArea());
		main.setDividerPositions(0.3);
		p.setCenter(main);
		
	}
	
	private Node createTreeArea() {
		TreeView<TreeNode> tree = new TreeView<>();
		tree.setRoot(TreeUtil.createModel(new EObjectTreeNode(modelProvider.getApplication(),"Application"), new FactoryImpl()));
		tree.setCellFactory(new Callback<TreeView<TreeNode>, TreeCell<TreeNode>>() {
			
			@Override
			public TreeCell<TreeNode> call(TreeView<TreeNode> param) {
				return new TreeCellImpl();
			}
		});
		return tree;
	}
	
	private Node createDetailArea() {
		BorderPane contentArea = new BorderPane();
		return contentArea;
	}
	
	static class TreeCellImpl extends TreeCell<TreeNode> {
		@Override
		protected void updateItem(TreeNode item, boolean empty) {
			textProperty().unbind();
			
			if( item != null ) {
				String t = item.labelProperty().get();
				if( t.startsWith("##styled##") ) {
					String s = t.substring("##styled##".length());
					setGraphic(StyledString.toTextFlow(s));
				} else {
					textProperty().bind(item.labelProperty());	
				}
			} else {
				setText(null);
				setGraphic(null);
			}
			
			super.updateItem(item, empty);
		}
	}
	
	class FactoryImpl implements ObservableFactory<TreeNode> {
		
		@Override
		public IObservableList createObservable(TreeNode parent) {
			if( parent instanceof EObjectTreeNode ) {
				EObject eo = (EObject) ((EObjectTreeNode) parent).getObject();
				ElementDelegate d = lookup.getDelegate(eo.eClass());
				if( d == null ) {
					return new WritableList();
				}
				return d.createChildren((MApplicationElement) eo); 
			} else {
				VirtualTreeNode n = (VirtualTreeNode) parent;
				return n.getChildren();
			}
		}	
	}
	
	public class DelegateLookup {
		private Map<EClass,ElementDelegate> delegates = new HashMap<>();
		
		public ElementDelegate getDelegate(EClass eClass) {
			ElementDelegate d = delegates.get(eClass);
			if( d == null ) {
				Class<? extends ElementDelegate> delegateClass = registry.getDelegate(eClass);
				if( delegateClass != null ) {
					d = objectFactory.newInstance(delegateClass);
				} else {
					logger.error("Could not find delegate for '"+eClass+"'");
					return null;
				}
			}
			return d;
		}
	}
}
