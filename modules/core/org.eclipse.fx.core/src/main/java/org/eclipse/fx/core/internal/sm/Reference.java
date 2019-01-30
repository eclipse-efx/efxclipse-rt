/*******************************************************************************
 * Copyright (c) 2015 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core.internal.sm;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * The reference
 */
public class Reference {

	private String bind;

	private String cardinality;

	private String iface;

	private String name;

	private String policy;

	private String policyOption;

	private String unbind;

	/**
	 * @return the bind method
	 */
	@XmlAttribute
	public String getBind() {
		return this.bind;
	}

	/**
	 * Set the bind method
	 *
	 * @param bind
	 *            the bind method
	 */
	public void setBind(String bind) {
		this.bind = bind;
	}

	/**
	 * @return the cardinality
	 */
	@XmlAttribute
	public String getCardinality() {
		return this.cardinality;
	}

	/**
	 * Set the cardinality
	 *
	 * @param cardinality
	 *            the cardinality
	 */
	public void setCardinality(String cardinality) {
		this.cardinality = cardinality;
	}

	/**
	 * @return the interface
	 */
	@XmlAttribute(name = "interface")
	public String getIface() {
		return this.iface;
	}

	/**
	 * Set the interface
	 *
	 * @param iface
	 *            the interface
	 */
	public void setIface(String iface) {
		this.iface = iface;
	}

	/**
	 * @return the name
	 */
	@XmlAttribute
	public String getName() {
		return this.name;
	}

	/**
	 * Set the name
	 *
	 * @param name
	 *            the name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the policy
	 */
	@XmlAttribute
	public String getPolicy() {
		return this.policy;
	}

	/**
	 * Set the policy
	 *
	 * @param policy
	 *            the policy
	 */
	public void setPolicy(String policy) {
		this.policy = policy;
	}

	/**
	 * @return the policy option
	 */
	@XmlAttribute(name = "policy-option")
	public String getPolicyOption() {
		return this.policyOption;
	}

	/**
	 * Set the policy option
	 *
	 * @param policyOption
	 *            the policy option
	 */
	public void setPolicyOption(String policyOption) {
		this.policyOption = policyOption;
	}

	/**
	 * @return the unbind method
	 */
	@XmlAttribute
	public String getUnbind() {
		return this.unbind;
	}

	/**
	 * Set the unbind method
	 *
	 * @param unbind
	 *            the unbind method
	 */
	public void setUnbind(String unbind) {
		this.unbind = unbind;
	}

	/**
	 * Reference policy
	 */
	public enum ReferencePolicy {
		/**
		 * static binding
		 */
		STATIC, /**
				 * dynamic binding
				 */
		DYNAMIC;

		/**
		 * Extract the vale from string
		 *
		 * @param data
		 *            the data
		 * @return the value
		 */
		public static ReferencePolicy fromString(String data) {
			switch (data) {
			case "static": //$NON-NLS-1$
				return ReferencePolicy.STATIC;
			default:
				return ReferencePolicy.DYNAMIC;
			}
		}
	}

	/**
	 * The policy option
	 */
	public enum ReferencePolicyOption {
		/**
		 * reluctant
		 */
		RELUCTANT,
		/**
		 * greedy
		 */
		GREEDY;

		/**
		 * Extract the vale from string
		 *
		 * @param data
		 *            the data
		 * @return the value
		 */
		public static ReferencePolicyOption fromString(String data) {
			switch (data) {
			case "reluctant": //$NON-NLS-1$
				return ReferencePolicyOption.RELUCTANT;
			default:
				return ReferencePolicyOption.GREEDY;
			}
		}
	}

	/**
	 * The cardinality
	 */
	public enum ReferenceCardinality {
		/**
		 * optional
		 */
		OPTIONAL,
		/**
		 * mandatory
		 */
		MANDATORY,
		/**
		 * multiple
		 */
		MULTIPLE,
		/**
		 * at least one
		 */
		AT_LEAST_ONE;

		/**
		 * Extract the vale from string
		 *
		 * @param data
		 *            the data
		 * @return the value
		 */
		public static ReferenceCardinality fromString(String data) {
			if (data == null || data.equals("")) { //$NON-NLS-1$
				return ReferenceCardinality.MANDATORY;
			}
			switch (data) {
			case "0..1": //$NON-NLS-1$
				return ReferenceCardinality.OPTIONAL;
			case "1..1": //$NON-NLS-1$
				return ReferenceCardinality.MANDATORY;
			case "0..n": //$NON-NLS-1$
				return ReferenceCardinality.MULTIPLE;
			default:
				return ReferenceCardinality.AT_LEAST_ONE;
			}
		}
	}
}
