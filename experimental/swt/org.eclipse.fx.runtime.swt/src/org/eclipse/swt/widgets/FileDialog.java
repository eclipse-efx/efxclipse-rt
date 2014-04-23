/*******************************************************************************
 * Copyright (c) 2014 IBM Corporation, BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	   IBM Corporation - initial API
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.swt.widgets;

import java.io.File;

import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

import org.eclipse.swt.SWT;

public class FileDialog extends Dialog {
	private String filename = "";
	private String[] filterNames = {};
	private String[] filterExtensions = {};
	private int filterIndex = -1;
	private String [] fileNames = {};
	private String filterPath = "";
	private boolean overwrite;
	
	public FileDialog (Shell parent) {
		this(parent, SWT.APPLICATION_MODAL);
	}
	
	public FileDialog (Shell parent, int style) {
		super(parent,style);
	}
	
	public String getFileName () {
		return filename;
	}
	
	public String [] getFileNames () {
		return filterNames;
	}
	
	public String [] getFilterExtensions () {
		return filterExtensions;
	}
	
	public int getFilterIndex () {
		return filterIndex;
	}
	
	public String [] getFilterNames () {
		return filterNames;
	}
	
	public String getFilterPath () {
		return filterPath;
	}
	
	public boolean getOverwrite () {
		return overwrite;
	}
	
	public String open () {
		FileChooser fc = new FileChooser();
		if( filterPath != null && ! filterPath.trim().isEmpty() ) {
			fc.setInitialDirectory(new File(filterPath));	
		}
		if( filename != null && ! filename.trim().isEmpty() ) {
			fc.setInitialFileName(filename);
		}
		
		fc.setTitle(getText());
		
		for( int i = 0; i < filterExtensions.length; i++ ) {
			String desc = filterExtensions[i];
			if( fileNames != null && i < fileNames.length ) {
				desc = filterNames[i];
			}
			ExtensionFilter ef = new ExtensionFilter(desc, filterExtensions[i]);
			fc.getExtensionFilters().add(ef);
			
			if( i == filterIndex ) {
				fc.setSelectedExtensionFilter(ef);
			}
		}
		
		if( (getStyle() & SWT.SAVE) == SWT.SAVE ) {
			File f = fc.showSaveDialog(getParent().internal_getWindow());
			if( f != null ) {
				fileNames = new String[1];
				filename = f.getName();
				fileNames[0] = f.getName();
				filterPath = f.getParentFile().getAbsolutePath();
			
				return f.getAbsolutePath();
			}
		} else if( (getStyle() & SWT.MULTI) == SWT.MULTI ) {
			java.util.List<File> files = fc.showOpenMultipleDialog(getParent().internal_getWindow());
			
			fileNames = new String[files.size()];
			if( ! files.isEmpty() ) {
				filename = files.get(0).getName();
				filterPath = files.get(0).getParentFile().getAbsolutePath();
				
				for( int i = 0; i < files.size(); i++ ) {
					fileNames[i] = files.get(i).getName();	
				}
				
				if( files.get(0) != null ) {
					return files.get(0).getAbsolutePath();
				}	
			}
		} else {
			File f = fc.showOpenDialog(getParent().internal_getWindow());
			if( f != null ) {
				fileNames = new String[1];
				filename = f.getName();
				fileNames[0] = f.getName();
				filterPath = f.getParentFile().getAbsolutePath();
			
				return f.getAbsolutePath();
			}
		}
		return null;
	}
	
	public void setFileName (String string) {
		this.filename = string;
	}
	
	public void setFilterExtensions (String [] extensions) {
		this.filterExtensions = extensions;
	}
	
	public void setFilterIndex (int index) {
		this.filterIndex = index;
	}
	
	public void setFilterNames (String [] names) {
		this.filterNames = names;
	}
	
	public void setFilterPath (String string) {
		this.filterPath = string;
	}
	
	public void setOverwrite (boolean overwrite) {
		this.overwrite = overwrite;
	}
}
