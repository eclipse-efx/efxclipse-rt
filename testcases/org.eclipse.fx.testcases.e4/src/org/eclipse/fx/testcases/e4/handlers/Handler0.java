package org.eclipse.fx.testcases.e4.handlers;

import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.fx.core.di.ScopedObjectFactory;

@SuppressWarnings("restriction")
public class Handler0 {
	@CanExecute
	boolean canRun(@Named("test_2") @Optional Integer i) {
		return i != null && i.intValue() % 2 == 0;
	}
	
	@Execute
	public void execute(MApplication application) {
		System.err.println("Executing H0");
		Integer v = (Integer) application.getContext().get("test");
		if( v == null ) {
			v = Integer.valueOf(0);
		} else {
			v = Integer.valueOf(v.intValue()+1);
		}
		application.getContext().get(ScopedObjectFactory.class).put("test", v);
//		application.getContext().set("test", v);
	}

}
