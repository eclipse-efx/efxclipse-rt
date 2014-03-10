/*******************************************************************************
 * Copyright (c) 2000, 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.swt.snippets;

/* 
 * Draw using transformations, paths and alpha blending
 *
 * For a list of all SWT example snippets see
 * http://www.eclipse.org/swt/snippets/
 * 
 * @since 3.1
 */
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;

import org.eclipse.fx.runtime.swtutil.SWTUtil;
import org.eclipse.fx.runtime.swtutil.SWTUtil.BlockCondition;
import org.eclipse.fx.runtime.swtutil.SWTUtil.SWTAppStart;
import org.eclipse.swt.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.widgets.*;

public class Snippet10 implements SWTAppStart {
	
	public static void main(String[] args) {
		SWTUtil.getInstance().bootstrap(new Snippet10());
	}
	
	public BlockCondition createApp(final Display display) {
		final Shell shell = new Shell(display);
		shell.setText("Advanced Graphics");
		FontData fd = shell.getFont().getFontData()[0];
		final Font font = new Font(display, fd.getName(), 60, SWT.BOLD | SWT.ITALIC);
		final Image image = new Image(display, 640, 480);
		final Rectangle rect = image.getBounds();
		GC gc = new GC(image);
		gc.setBackground(display.getSystemColor(SWT.COLOR_RED));
		gc.fillOval(rect.x, rect.y, rect.width, rect.height);
		gc.dispose();
		
		BufferedImage img = SwingFXUtils.fromFXImage(image.internal_getImage(), null);
		try {
			ImageIO.write(img, "png", new File("/Users/tomschindl/bla.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		shell.addListener(SWT.Paint, new Listener() {
			public void handleEvent(Event event) {
				System.err.println("PAINTING");
				GC gc = event.gc;				
				Transform tr = new Transform(display);
				tr.translate(50, 120);
				tr.rotate(-30);
				gc.drawImage(image, 0, 0, rect.width, rect.height, 0, 0, rect.width / 2, rect.height / 2);
				gc.setAlpha(100);
				gc.setTransform(tr);
				Path path = new Path(display);
				path.addString("SWT", 0, 0, font);
				gc.setBackground(display.getSystemColor(SWT.COLOR_GREEN));
				gc.setForeground(display.getSystemColor(SWT.COLOR_BLUE));
				gc.fillPath(path);
				gc.drawPath(path);
				tr.dispose();
				path.dispose();
			}			
		});
		shell.setSize(shell.computeSize(rect.width / 2, rect.height / 2));
		shell.open();
		
		SWTUtil.getInstance().block(display, SWTUtil.getInstance().createShellBlockCondition(shell));
		
		image.dispose();
		font.dispose();
		return null;
	}
}
