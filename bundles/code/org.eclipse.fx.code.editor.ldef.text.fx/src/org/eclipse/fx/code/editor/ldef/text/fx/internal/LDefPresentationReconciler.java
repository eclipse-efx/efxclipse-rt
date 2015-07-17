package org.eclipse.fx.code.editor.ldef.text.fx.internal;

import javax.inject.Inject;

import org.eclipse.fx.code.editor.ldef.lDef.LDef;
import org.eclipse.fx.code.editor.ldef.lDef.LexicalPartitionHighlighting;
import org.eclipse.fx.code.editor.ldef.lDef.LexicalPartitionHighlighting_Rule;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.rules.DefaultDamagerRepairer;

public class LDefPresentationReconciler extends PresentationReconciler {

	@Inject
	public LDefPresentationReconciler(LDef model) {
		for( LexicalPartitionHighlighting sc : model.getLexicalHighlighting().getList() ) {
			if( sc instanceof LexicalPartitionHighlighting_Rule ) {
				LexicalPartitionHighlighting_Rule rs = (LexicalPartitionHighlighting_Rule) sc;
				LDefRuleScanner s = new LDefRuleScanner(rs);
				DefaultDamagerRepairer dr = new DefaultDamagerRepairer(s);
				setDamager(dr, rs.getPartition().getName());
				setRepairer(dr, rs.getPartition().getName());
			}
		}
	}
}
