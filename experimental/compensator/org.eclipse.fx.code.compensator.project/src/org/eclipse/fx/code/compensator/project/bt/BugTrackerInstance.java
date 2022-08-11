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
package org.eclipse.fx.code.compensator.project.bt;

import java.util.List;
import java.util.function.Supplier;

import javafx.collections.ObservableList;
import javafx.scene.Node;

public interface BugTrackerInstance {
	public static CommitAction NO_ACTION = new DefaultAction("--", () -> null);
	
	public interface CommitAction {
		public String getLabel();
		public Node getGraphic();
		public String getMessageTemplate();
	}
	
	public static class DefaultAction implements CommitAction {
		private final String label;
		private final Supplier<Node> supplier;
		private final String messageTemplate;
		
		public DefaultAction(String label, String messageTemplate, Supplier<Node> supplier) {
			this.label = label;
			this.messageTemplate = messageTemplate;
			this.supplier = supplier;
		}
		
		public DefaultAction(String label, String messageTemplate) {
			this.label = label;
			this.messageTemplate = messageTemplate;
			this.supplier = null;
		}
		
		public DefaultAction(String label, Supplier<Node> supplier) {
			this.label = label;
			this.supplier = supplier;
			this.messageTemplate = null;
		}
		
		public DefaultAction(String label) {
			this.label = label;
			this.supplier = null;
			this.messageTemplate = null;
		}
		
		@Override
		public String getLabel() {
			return label;
		}

		@Override
		public Node getGraphic() {
			return supplier != null ? supplier.get() : null;
		}

		@Override
		public String getMessageTemplate() {
			return messageTemplate;
		}
	}
	
	public interface IssueState {
		public String getLabel();
		public Node getGraphic();
	}
	
	public static class DefaultIssueState implements IssueState {
		private final String label;
		private final Supplier<Node> graphicSupplier;
		
		public DefaultIssueState(String label, Supplier<Node> graphicSupplier) {
			this.label = label;
			this.graphicSupplier = graphicSupplier;
		}
		
		@Override
		public String getLabel() {
			return this.label;
		}

		@Override
		public Node getGraphic() {
			return this.graphicSupplier != null ? this.graphicSupplier.get() : null;
		}
	}
	
	public interface BugTrackerIssue {
		public String getId();
		public String getTitle();
		public String getDescription();
		public IssueState getState();
		public ObservableList<BugFollowUp> getFollowUpList();
	}
	
	public interface BugFollowUp {
		public String getId();
		public String getDescription();
	}
	
	public List<CommitAction> getCommitActions();
	public ObservableList<BugTrackerIssue> getIssues();
	public BugTrackerService getService();
}
