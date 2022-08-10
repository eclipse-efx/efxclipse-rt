/*******************************************************************************
 * Copyright (c) 2000, 2004 IBM Corporation and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.swt.snippets;

/*
 * Browser example snippet: query DOM node value (Eclipse/SWT 3.4 and earlier).
 * For an improved implementation of this snippet that can be used with Eclipse/SWT 3.5
 * and newer see
 * http://git.eclipse.org/c/platform/eclipse.platform.swt.git/tree/examples/org.eclipse.swt.snippets/src/org/eclipse/swt/snippets/Snippet308.java
 *
 * For a list of all SWT example snippets see
 * http://www.eclipse.org/swt/snippets/
 * 
 * @since 3.1
 */
import org.eclipse.fx.runtime.swtutil.SWTUtil;
import org.eclipse.fx.runtime.swtutil.SWTUtil.BlockCondition;
import org.eclipse.fx.runtime.swtutil.SWTUtil.SWTAppStart;
import org.eclipse.swt.*;
import org.eclipse.swt.browser.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

public class Snippet160 implements SWTAppStart {
	@Override
	public BlockCondition createApp(Display display) {
		final String html = "<html><title>Snippet</title><body><p id='myid'>Best Friends</p><p id='myid2'>Cat and Dog</p></body></html>";
		final Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		final Browser browser;
		try {
			browser = new Browser(shell, SWT.NONE);
		} catch (SWTError e) {
			System.out.println("Could not instantiate Browser: " + e.getMessage());
			return null;
		}
		browser.addStatusTextListener(new StatusTextListener() {
			public void changed(StatusTextEvent event) {
				browser.setData("query", event.text);
			}
		});
		browser.addProgressListener(new ProgressListener() {
			public void changed(ProgressEvent event) {
			}
			public void completed(ProgressEvent event) {
				System.err.println("EXEC");
				/* 
				 * Use JavaScript to query the desired node content through the Document Object Model
				 * 
				 * Assign result to the window property status to pass the result to the StatusTextListener
				 * This trick is required since <code>execute</code> does not return the <code>String</code>
				 * directly.
				 */
				boolean result = browser.execute("window.status=document.getElementById('myid').childNodes[0].nodeValue;");
				if (!result) {
					/* Script may fail or may not be supported on certain platforms. */
					System.out.println("Script was not executed.");
					return;
				}
				String value = (String)browser.getData("query");
				System.out.println("Node value: "+value);
			}
		});
		/* Load an HTML document */
		browser.setText(html);
		SWTUtil.getInstance().openBlocking(shell);
		return null;
	}
	
	public static void main(String[] args) {
		SWTUtil.getInstance().bootstrap(new Snippet160());
	}
}


