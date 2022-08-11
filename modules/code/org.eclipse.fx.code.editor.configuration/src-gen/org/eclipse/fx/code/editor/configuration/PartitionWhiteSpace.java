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
package org.eclipse.fx.code.editor.configuration;

public interface PartitionWhiteSpace extends EditorBase {
	public boolean isJavawhiteSpace();
	public java.util.List<String> getCharacterList();

	public interface Builder {
		public Builder javawhiteSpace(boolean javawhiteSpace);
		public Builder characterList(java.util.List<String> characterList);
		public Builder appendCharacterList(String characterList);
		public PartitionWhiteSpace build();
	}
}
