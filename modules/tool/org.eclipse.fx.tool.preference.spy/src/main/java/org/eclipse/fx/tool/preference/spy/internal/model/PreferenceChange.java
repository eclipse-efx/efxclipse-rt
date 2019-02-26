package org.eclipse.fx.tool.preference.spy.internal.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PreferenceChange extends PreferenceEntry {
	
	private long time;
	
	public PreferenceChange( long time, String nodePath, String key, String oldValue, String newValue ) {
		super( nodePath, key, oldValue, newValue );
		this.time = time;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public String getTimeString() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss  yyyy-MM-dd");
		String dateString = simpleDateFormat.format( new Date( time ) );
		return dateString;
	}

}
