package org.eclipse.swt.snippets;

import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.JFrame;
import javax.swing.JScrollBar;

public class TestSwing {

	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		final JScrollBar bar = new JScrollBar(JScrollBar.VERTICAL);
		bar.setMaximum(100);
//		bar.setVisibleAmount(50);
		f.getContentPane().add(bar);
		bar.addAdjustmentListener(new AdjustmentListener() {
			
			@Override
			public void adjustmentValueChanged(AdjustmentEvent e) {
				System.err.println(bar.getValue());
			}
		});
		f.pack();
		f.setVisible(true);
		
	}

}
