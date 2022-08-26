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

public interface Token extends EditorBase {
	public boolean isDefaultToken();
	public String getName();
	public java.util.List<TokenScanner> getTokenScannerList();

	public interface Builder {
		public Builder defaultToken(boolean defaultToken);
		public Builder name(String name);
		public Builder tokenScannerList(java.util.List<TokenScanner> tokenScannerList);
		public Builder appendTokenScannerList(TokenScanner tokenScannerList);
		public Builder tokenScannerList(java.util.function.Function<EditorGModel,java.util.List<TokenScanner>> provider);
		public Builder appendTokenScannerList(java.util.function.Function<TokenScanner.Builder,TokenScanner> provider);
		public Token build();
	}
}
