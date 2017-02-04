package org.eclipse.fx.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

class MultiStatusImpl implements MultiStatus {
	private final List<@NonNull Status> states;
	private final String message;
	private final int code;
	private State state;
	
	public MultiStatusImpl(String message, int code, List<@NonNull Status> states) {
		this.message = message;
		this.code = code;
		this.states = new ArrayList<>(states);
	}
	
	MultiStatusImpl(String message, int code, List<@NonNull Status> states, boolean noCopy) {
		this.message = message;
		this.code = code;
		this.states = states;
	}

	@Override
	public @NonNull State getState() {
		State rv = this.state;
		if( rv == null ) {
			rv = this.state = this.states.stream().map( s -> s.getState() ).max(State::compareTo).orElse(State.OK);
		}
		return rv;
	}

	@Override
	public @Nullable String getMessage() {
		return this.message;
	}

	@Override
	public @Nullable Throwable getThrowable() {
		return null;
	}

	@Override
	public int getCode() {
		return this.code;
	}

	@Override
	public Optional<State> state() {
		return Optional.of(getState());
	}

	@Override
	public MultiStatus add(Status... status) {
		for( int i = 0; i < status.length; i++ ) {
			Status s = status[i];
			if( s != null ) {
				this.states.add(s);
			}
		}
		this.state = null;
		return this;
	}
	
	@Override
	public List<Status> getChildren() {
		return Collections.unmodifiableList(this.states);
	}
}
