package org.eclipse.fx.code.compensator.editor.hsl;

import java.io.IOException;
import java.io.InputStreamReader;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.eclipse.fx.code.compensator.hsl.hSL.Damager;
import org.eclipse.fx.code.compensator.hsl.hSL.JSDamager;
import org.eclipse.fx.code.compensator.hsl.hSL.Model;
import org.eclipse.fx.code.compensator.hsl.hSL.RuleDamager;
import org.eclipse.jface.text.presentation.IPresentationDamager;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.IPresentationRepairer;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;

public class HSLConfiguration extends SourceViewerConfiguration {
	private Model model;
	private ClassLoader cl;
	
	public HSLConfiguration(ClassLoader cl, Model model) {
		this.cl = cl;
		this.model = model;
	}
	
	public IPresentationReconciler getPresentationReconciler(ISourceViewer sourceViewer) {
		PresentationReconciler reconciler = new PresentationReconciler();
		
		for( Damager sc : model.getDamagers() ) {
			if( sc instanceof RuleDamager ) {
				RuleDamager rs = (RuleDamager) sc;
				HSLRuleScanner s = new HSLRuleScanner(rs);
				DefaultDamagerRepairer dr = new DefaultDamagerRepairer(s);
				reconciler.setDamager(dr, rs.getPartition().getName());
				reconciler.setRepairer(dr, rs.getPartition().getName());
			} else {
				JSDamager js = (JSDamager) sc;
				ScriptEngineManager m = new ScriptEngineManager(cl);
				ScriptEngine engine = m.getEngineByName("nashorn");
				try(InputStreamReader r = new InputStreamReader(cl.getResourceAsStream(js.getFileURI()))) {
					Object o = engine.eval(r);
					reconciler.setDamager((IPresentationDamager) o, js.getPartition().getName());
					reconciler.setRepairer((IPresentationRepairer) o, js.getPartition().getName());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ScriptException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return reconciler;
	}
}
