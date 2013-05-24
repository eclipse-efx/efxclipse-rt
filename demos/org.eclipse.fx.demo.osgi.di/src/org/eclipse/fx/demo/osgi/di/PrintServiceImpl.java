package org.eclipse.fx.demo.osgi.di;

public class PrintServiceImpl implements PrintService {
	@Override
	public void pring(String message) {
		System.err.println(message);
	}
}
