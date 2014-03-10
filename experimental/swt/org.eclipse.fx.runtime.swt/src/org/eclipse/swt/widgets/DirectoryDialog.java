package org.eclipse.swt.widgets;

import java.io.File;

import javafx.stage.DirectoryChooser;

public class DirectoryDialog extends Dialog {
	private String filterPath;
	private String message;
	
	public DirectoryDialog(Shell parent) {
		super(parent);
	}

	public DirectoryDialog (Shell parent, int style) {
		super(parent,style);
	}
	
	public String getFilterPath () {
		return filterPath;
	}
	
	public String getMessage () {
		return message;
	}
	
	public String open () {
		DirectoryChooser chooser = new DirectoryChooser();
		chooser.setInitialDirectory(new File(filterPath));
		File f = chooser.showDialog(getParent().internal_getWindow());
		return f == null ? null : f.getAbsolutePath();
	}
	
	public void setMessage (String string) {
		this.message = string;
	}
	
	public void setFilterPath (String string) {
		filterPath = string;
	}
}
