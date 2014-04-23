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
package org.eclipse.swt.printing;

import javafx.print.Collation;
import javafx.print.PrintSides;
import javafx.print.PrinterJob;

import org.eclipse.swt.SWT;
import org.eclipse.swt.internal.Util;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Shell;

public class PrintDialog extends Dialog {
	private PrinterData printerData = new PrinterData();
	private Shell parent;
	
	public PrintDialog (Shell parent) {
		this (parent, SWT.PRIMARY_MODAL);
	}
	
	public PrintDialog (Shell parent, int style) {
		super (parent, style);
		this.parent = parent;
	}
	
	public void setPrinterData(PrinterData data) {
		if (data == null) data = new PrinterData();
		this.printerData = data;
	}
	
	public PrinterData getPrinterData() {
		return printerData;
	}
	
	public PrinterData open() {
		PrinterJob j = PrinterJob.createPrinterJob();
		if( j.showPrintDialog(parent.internal_getWindow()) ) {
			this.printerData.collate=j.getJobSettings().getCollation() == Collation.COLLATED;
			this.printerData.copyCount=j.getJobSettings().getCopies();
//			this.printerData.driver=j.getJobSettings().get
			switch (j.getJobSettings().getPrintSides()) {
			case DUPLEX:
				this.printerData.duplex=PrinterData.DUPLEX_LONG_EDGE;
				break;
			case ONE_SIDED:
				this.printerData.duplex=PrinterData.DUPLEX_NONE;
				break;
			case TUMBLE:
				this.printerData.duplex=PrinterData.DUPLEX_SHORT_EDGE;
				break;
			default:
				break;
			}
//			this.printerData.endPage=j.getJobSettings().getPageRanges()
//			this.printerData.fileName=j.getJobSettings().
//			this.printerData.name
			Util.logNotImplemented();
		}
		
		Util.logNotImplemented();
		return null;
	}
	
	public int getScope() {
		return printerData.scope;
	}
	
	public void setScope(int scope) {
		printerData.scope = scope;
	}
	
	public int getStartPage() {
		return printerData.startPage;
	}
	
	public void setStartPage(int startPage) {
		printerData.startPage = startPage;
	}

	public int getEndPage() {
		return printerData.endPage;
	}
	
	public void setEndPage(int endPage) {
		printerData.endPage = endPage;
	}
	
	public boolean getPrintToFile() {
		return printerData.printToFile;
	}
	
	public void setPrintToFile(boolean printToFile) {
		printerData.printToFile = printToFile;
	}
}
