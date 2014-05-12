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
package org.eclipse.fx.ui.workbench.renderers.base.services;

import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WDragTargetWidget.DropType;

public interface DnDFeedbackService {
	public static class DnDFeedbackData {
		public final MUIElement reference;
		public final MUIElement sourceElement;
		public final DropType dropType;
		
		public final MUIElement feedbackContainerElement;
		public final Region containerRegion;
		
		public DnDFeedbackData(MUIElement reference, MUIElement sourceElement, DropType dropType, MUIElement feedbackContainerElement, Region containerRegion) {
			this.reference = reference;
			this.sourceElement = sourceElement;
			this.dropType = dropType;
			
			this.feedbackContainerElement = feedbackContainerElement;
			this.containerRegion = containerRegion;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((containerRegion == null) ? 0 : containerRegion.hashCode());
			result = prime * result + ((dropType == null) ? 0 : dropType.hashCode());
			result = prime * result + ((feedbackContainerElement == null) ? 0 : feedbackContainerElement.hashCode());
			result = prime * result + ((reference == null) ? 0 : reference.hashCode());
			result = prime * result + ((sourceElement == null) ? 0 : sourceElement.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			DnDFeedbackData other = (DnDFeedbackData) obj;
			if (containerRegion == null) {
				if (other.containerRegion != null)
					return false;
			} else if (!containerRegion.equals(other.containerRegion))
				return false;
			if (dropType != other.dropType)
				return false;
			if (feedbackContainerElement == null) {
				if (other.feedbackContainerElement != null)
					return false;
			} else if (!feedbackContainerElement.equals(other.feedbackContainerElement))
				return false;
			if (reference == null) {
				if (other.reference != null)
					return false;
			} else if (!reference.equals(other.reference))
				return false;
			if (sourceElement == null) {
				if (other.sourceElement != null)
					return false;
			} else if (!sourceElement.equals(other.sourceElement))
				return false;
			return true;
		}
	}
	
	public static class Region {
		public double x;
		public double y;
		public double width;
		public double height;
		
		public Region(double x, double y, double width, double height) {
			this.x = x;
			this.y = y;
			this.width = width;
			this.height = height;
		}
	}
	
	public abstract static class MarkerFeedback {
		public final DnDFeedbackData data;
		
		public MarkerFeedback(DnDFeedbackData data) {
			this.data = data;
		}
		
		public abstract void hide();
	}
	
	public MarkerFeedback showFeedback(DnDFeedbackData data);
}
