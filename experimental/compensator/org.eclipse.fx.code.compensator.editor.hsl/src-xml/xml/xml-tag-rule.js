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
var f = function() {
	var MultiLineRule = Java.type("org.eclipse.jface.text.rules.MultiLineRule");
	var TagRule = Java.extend( MultiLineRule );
	var Character = Java.type("java.lang.Character");
	
	var Token = Java.type("org.eclipse.jface.text.rules.Token");
	var token = new Token("__xml_tag");
	var tagRule = new TagRule("<", ">",token) {
		sequenceDetected : function(scanner, sequence, eofAllowed) {
		  var c = scanner.read();
		  if (Character.toString(sequence[0]) == "<") {
		  	if (Character.toString(c) == '?') {
		  	  scanner.unread();
		  	  return false;
		  	}
		  	if (Character.toString(c) == '!') {
		  	  scanner.unread();
		  	  return false;
		  	}
		  } else if (Character.toString(sequence[0]) == '>') {
			scanner.unread();
		  }
		  
		  return Java.super(tagRule).sequenceDetected(scanner, sequence, eofAllowed);
		}
	};
	return tagRule;
};

f();