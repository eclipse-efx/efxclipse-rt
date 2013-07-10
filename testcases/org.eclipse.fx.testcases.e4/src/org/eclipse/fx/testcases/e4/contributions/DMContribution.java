package org.eclipse.fx.testcases.e4.contributions;

import org.eclipse.e4.ui.di.AboutToHide;
import org.eclipse.e4.ui.di.AboutToShow;
import org.eclipse.e4.ui.model.application.ui.menu.MMenu;

public class DMContribution {
	
	
	@AboutToShow
	public void ats(MMenu menu){
//		menu.getChildren().remove(0); <--works
		System.err.println(menu);
		System.err.println("ATSH");
	}
	
	@AboutToHide
	public void ath(){
		System.err.println("ATH");
	}

}