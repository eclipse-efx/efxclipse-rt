package org.eclipse.fx.code.compensator.editor;

import java.util.concurrent.Future;

public interface VCSInput<O> extends Input<O> {
	public Future<Boolean> commit();
}
