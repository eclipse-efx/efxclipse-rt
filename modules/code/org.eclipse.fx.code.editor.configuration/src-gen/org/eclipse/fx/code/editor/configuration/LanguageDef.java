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

public interface LanguageDef extends EditorBase {
	public String getFileSuffix();
	public java.util.List<Partition> getPartitionList();

	public interface Builder {
		public Builder fileSuffix(String fileSuffix);
		public Builder partitionList(java.util.List<Partition> partitionList);
		public Builder appendPartitionList(Partition partitionList);
		public Builder partitionList(java.util.function.Function<EditorGModel,java.util.List<Partition>> provider);
		public Builder appendPartitionList(java.util.function.Function<Partition.Builder,Partition> provider);
		public LanguageDef build();
	}
}
