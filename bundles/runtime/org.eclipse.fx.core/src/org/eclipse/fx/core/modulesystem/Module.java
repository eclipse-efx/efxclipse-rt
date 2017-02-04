package org.eclipse.fx.core.modulesystem;

import java.util.Optional;

import org.eclipse.fx.core.Version;

public interface Module {
	public String getId();
	public Optional<Version> getVersion();
}
