package org.eclipse.fx.runtime.fswt.graphics;

public class FFadeTransition implements FTransition {

	public static class Basic extends FFadeTransition {
		public final double fromOpacity;
		public final double toOpacity;
		public final long duration;

		Basic(double fromOpacity, double toOpacity, long duration) {
			this.fromOpacity = fromOpacity;
			this.toOpacity = toOpacity;
			this.duration = duration;
		}
	}

	public static FFadeTransition basic(double fromOpacity, double toOpacity, long duration) {
		return new Basic(fromOpacity, toOpacity, duration);
	}
}
