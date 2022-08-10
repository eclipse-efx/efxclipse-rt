/*******************************************************************************
 * Copyright (c) 2017 BestSolution.at and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core;

import java.util.Optional;

/**
 * Version object modeled after <a href="http://semver.org/">Semantic Versioning
 * 2.0.0</a>
 *
 * @since 2.6.0
 */
public abstract class Version implements Comparable<Version> {
	private int hash;

	/**
	 * @return major version
	 */
	public abstract int getMajor();

	/**
	 * @return minor version
	 */
	public abstract int getMinor();

	/**
	 * @return micro version
	 */
	public abstract int getMicro();

	/**
	 * @return qualifier
	 */
	public abstract Optional<String> getQualifier();

	@Override
	public final int hashCode() {
		int h = this.hash;
		if (h != 0) {
			return h;
		}
		h = 31 * 17;
		h = 31 * h + this.getMajor();
		h = 31 * h + this.getMinor();
		h = 31 * h + this.getMicro();
		h = 31 * h + this.getQualifier().hashCode();
		return this.hash = h;
	}

	@Override
	public final boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof Version)) {
			return false;
		}
		Version v = (Version) obj;
		return getMajor() == v.getMajor() && getMinor() == v.getMinor() && getMicro() == v.getMicro()
				&& getQualifier().equals(v.getQualifier());
	}

	/**
	 * Create a new version instance
	 *
	 * @param major
	 *            the major version
	 * @param minor
	 *            the minor version
	 * @param micro
	 *            the micro version
	 * @return a new version instance
	 */
	public static Version createVersion(int major, int minor, int micro) {
		return new VersionImpl(major, minor, micro, null);
	}

	/**
	 * Create a new version instance
	 *
	 * @param major
	 *            the major version
	 * @param minor
	 *            the minor version
	 * @param micro
	 *            the micro version
	 * @param qualifier
	 *            the qualifier
	 * @return a new version instance
	 */
	public static Version createVersion(int major, int minor, int micro, String qualifier) {
		return new VersionImpl(major, minor, micro, qualifier);
	}

	/**
	 * Create a new version from the provided string
	 * <p>
	 * Required format:
	 *
	 * <pre>
	 * version ::= major '.' minor '.' micro (('_'|'-'))qualifier)?
	 * major ::= digit+
	 * minor ::= digit+
	 * micro ::= digit+
	 * qualifier ::=(alpha|digit)+
	 * digit ::= [0..9]
	 * alpha ::= [a..zA..Z]
	 * </pre>
	 * </p>
	 *
	 * @param versionString
	 *            the version string
	 * @return a new version instance
	 * @throws IllegalArgumentException
	 *             if version string does not conform to specified format
	 */
	public static Version createVersion(String versionString) {
		String[] parts = versionString.split("\\."); //$NON-NLS-1$
		if (parts.length > 2) {
			String qualifier = null;
			if (parts[2].indexOf('_') != -1) {
				qualifier = parts[2].substring(parts[2].indexOf('_') + 1);
				parts[2] = parts[2].substring(0, parts[2].indexOf('_'));
			}

			if (parts[2].indexOf('-') != -1) {
				qualifier = parts[2].substring(parts[2].indexOf('-') + 1);
				parts[2] = parts[2].substring(0, parts[2].indexOf('-'));
			}
			return createVersion(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2]),
					qualifier);
		} else {
			throw new IllegalArgumentException("Invalid version string '"+versionString+"'"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	static class VersionImpl extends Version {
		private final int major;
		private final int minor;
		private final int micro;
		private final Optional<String> qualifier;

		public VersionImpl(int major, int minor, int micro, String qualifier) {
			this.major = major;
			this.minor = minor;
			this.micro = micro;
			this.qualifier = Optional.ofNullable(qualifier);
		}

		@Override
		public int getMajor() {
			return this.major;
		}

		@Override
		public int getMinor() {
			return this.minor;
		}

		@Override
		public int getMicro() {
			return this.micro;
		}

		@Override
		public Optional<String> getQualifier() {
			return this.qualifier;
		}

		@Override
		public int compareTo(Version o) {
			int rv = Integer.compare(this.major, o.getMajor());
			if (rv != 0) {
				return rv;
			}

			rv = Integer.compare(this.minor, o.getMinor());
			if (rv != 0) {
				return rv;
			}

			rv = Integer.compare(this.micro, o.getMicro());
			if (rv != 0) {
				return rv;
			}

			return this.qualifier.orElse("").compareTo(o.getQualifier().orElse("")); //$NON-NLS-1$//$NON-NLS-2$
		}

		@Override
		public String toString() {
			return "VersionImpl [major=" + this.major + ", minor=" + this.minor + ", micro=" + this.micro + ", qualifier=" //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
					+ this.qualifier + "]"; //$NON-NLS-1$
		}

	}
}
