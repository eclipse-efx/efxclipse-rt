package org.eclipse.fx.code.editor.ldef.text;

import java.util.function.IntPredicate;

import org.eclipse.fx.code.editor.ldef.lDef.Check;
import org.eclipse.fx.code.editor.ldef.lDef.Equals;
import org.eclipse.fx.code.editor.ldef.lDef.Range;
import org.eclipse.fx.core.function.IntRelationOperation;
import org.eclipse.fx.text.ColumnStartRule;
import org.eclipse.fx.text.PredicateColumnStartRule;
import org.eclipse.jface.text.rules.IPredicateRule;
import org.eclipse.jface.text.rules.IRule;

@SuppressWarnings("restriction")
public class Util {
	public static IRule wrap(Check check, IRule rule) {
		if( check == null ) {
			return rule;
		} else {
			IntPredicate p = null;
			if( check instanceof Equals ) {
				int c = ((Equals) check).getValue();
				p = v -> v == c;
			} else if( check instanceof Range ) {
				Range r = (Range) check;
				if( ! r.getMinValue().isEmpty() && ! r.getMaxValue().isEmpty() ) {
					int min = r.getMinValue().get(0);
					int max = r.getMaxValue().get(0);
					IntRelationOperation minOp = r.getLtIncl().equals("(") ? IntRelationOperation::lt : IntRelationOperation::lte;
					IntRelationOperation maxOp = r.getLtIncl().equals(")") ? IntRelationOperation::lt : IntRelationOperation::lte;
					p = v -> minOp.apply(min, v) && maxOp.apply(v,max);
				} else if( ! r.getMinValue().isEmpty() ) {
					int min = r.getMinValue().get(0);
					IntRelationOperation minOp = r.getLtIncl().equals("(") ? IntRelationOperation::lt : IntRelationOperation::lte;
					p = v -> minOp.apply(min, v);
				} else if( ! r.getMaxValue().isEmpty() ) {
					int max = r.getMaxValue().get(0);
					IntRelationOperation maxOp = r.getLtIncl().equals(")") ? IntRelationOperation::lt : IntRelationOperation::lte;
					p = v -> maxOp.apply(v,max);
				}
			}

			if( p != null ) {
				return rule instanceof IPredicateRule ? new PredicateColumnStartRule((IPredicateRule) rule, p) : new ColumnStartRule(rule, p);
			} else {
				return rule;
			}
		}
	}
}
