package org.eclipse.fx.code.editor.ldef.text.fx.internal;

import javax.inject.Inject;

import org.eclipse.fx.code.editor.ldef.lDef.LanguageDef;
import org.eclipse.fx.code.editor.ldef.lDef.LexicalPartitionHighlighting;
import org.eclipse.fx.code.editor.ldef.lDef.LexicalPartitionHighlighting_Rule;
import org.eclipse.fx.text.ui.presentation.PresentationReconciler;
import org.eclipse.fx.text.ui.rules.DefaultDamagerRepairer;

public class LDefPresentationReconciler extends PresentationReconciler {

	@Inject
	public LDefPresentationReconciler(LanguageDef model) {
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
