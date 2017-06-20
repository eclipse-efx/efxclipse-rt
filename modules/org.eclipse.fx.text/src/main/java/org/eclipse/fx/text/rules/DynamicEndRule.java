/*******************************************************************************
* Copyright (c) 2016 BestSolution.at and others.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
* 	Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
*******************************************************************************/
package org.eclipse.fx.text.rules;

import java.text.MessageFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.jface.text.rules.ICharacterScanner;
import org.eclipse.jface.text.rules.IToken;

/**
 * This is a specialized rule who can be used to implement rules who have to
 * have dynamic end who is built from information at the start rule
 * <p>
 * A good example for this is Lua multi-line comments and strings
 * </p>
 *
 * <pre>
 * {@code
 * [[
 *  THIS IS MULTILINE
 *  STRING
 * ]]
 * }
 * </pre>
 *
 * Where it is allowed to put as many = signs between the two [[ and ]] the only
 * requirement is that start and end matches
 *
 * <pre>
 * {@code
 * [=====[
 *  THIS IS MULTILINE
 *  STRING
 * ]=====]
 * }
 * </pre>
 *
 * would be expressed as
 *
 * <pre>
 * {@code
 * new DynamicEndRule( "[", Pattern.compile("(=*)"), "[", "]{0}]" );
 * }
 * </pre>
 */
@SuppressWarnings("restriction")
public class DynamicEndRule extends ExtendedPatternRule {
	private final char[] beginSuffix;
	private final Pattern beginPattern;
	private final String endTemplate;

	/**
	 * Create a new dynamic end rule
	 *
	 * @param token
	 *            the token if succeeded
	 * @param beginPrefix
	 *            the prefix for the start must be at least one char
	 * @param beginPattern
	 *            the pattern with groups to find the end of the start-sequence
	 * @param beginSuffix
	 * 			  the suffix might be empty
	 * @param endTemplate
	 *            the end template who can references groups from the start
	 *            sequence using {index} like in {@link MessageFormat}
	 */
	public DynamicEndRule(IToken token, String beginPrefix, Pattern beginPattern, String beginSuffix, String endTemplate) {
		super(beginPrefix, "", token, '\\', false, false);
		this.beginPattern = beginPattern;
		this.beginSuffix = beginSuffix == null ? new char[0] : beginSuffix.toCharArray();
		this.endTemplate = endTemplate;
	}

	@Override
	public IToken evaluate(ICharacterScanner scanner, boolean resume) {
		if (!resume) {
			fEndSequence = new char[0];
		}
		return super.evaluate(scanner, resume);
	}

	@Override
	protected boolean sequenceStartDetected(ICharacterScanner scanner, char[] sequence, boolean eofAllowed) {
		CheckPointScanner cs = new CheckPointScanner(scanner);
		cs.setCheckpoint();
		boolean rv = super.sequenceStartDetected(cs, sequence, eofAllowed);
		if (rv) {
			if( beginSuffix.length > 0 ) {
				rv = false;
				StringBuilder b = new StringBuilder();
				int c;
				while ((c = cs.read()) != ICharacterScanner.EOF) {
					if( c == '\r' || c == '\n' ) {
						rv = false;
						break;
					}
					if( c == beginSuffix[0] ) {
						rv = super.sequenceDetected(cs, beginSuffix, false);
						if( rv ) {
							Matcher matcher = beginPattern.matcher(b);
							rv = matcher.matches();
							if( rv ) {
								Object[] g = new String[matcher.groupCount()];
								for (int i = 0; i < matcher.groupCount(); i++) {
									g[i] = matcher.group(i + 1);
								}
								fEndSequence = MessageFormat.format(endTemplate, g).toCharArray();
								break;
							}
						}
					} else {
						b.append((char)c);
					}
				}
			} else {
				throw new UnsupportedOperationException();
			}
		}

		if( ! rv ) {
			cs.rollbackToCheckPoint();
		}

		return rv;
	}
}