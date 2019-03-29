/*******************************************************************************
 * Copyright (c) Carl Zeiss Meditec AG
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Thomas Fahrmeyer (lauritziu_ii@yahoo.de) - initial API and implementation
*/
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
