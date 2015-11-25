package org.eclipse.fx.code.editor.configuration.text;

import java.util.function.IntPredicate;

import org.eclipse.fx.code.editor.configuration.Check;
import org.eclipse.fx.code.editor.configuration.Equals;
import org.eclipse.fx.code.editor.configuration.Range;
import org.eclipse.fx.core.function.IntRelationOperation;
import org.eclipse.fx.text.rules.ColumnStartRule;
import org.eclipse.fx.text.rules.PredicateColumnStartRule;
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
				if( r.getMin() != -1 && r.getMax() != -1 ) {
					int min = r.getMin();
					int max = r.getMax();
					IntRelationOperation minOp = r.isMinIncl() ? IntRelationOperation::lt : IntRelationOperation::lte;
					IntRelationOperation maxOp = r.isMaxIncl() ? IntRelationOperation::lt : IntRelationOperation::lte;
					p = v -> minOp.apply(min, v) && maxOp.apply(v,max);
				} else if( r.getMin() != -1 ) {
					int min = r.getMin();
					IntRelationOperation minOp = r.isMinIncl() ? IntRelationOperation::lt : IntRelationOperation::lte;
					p = v -> minOp.apply(min, v);
				} else if( r.getMax() != -1 ) {
					int max = r.getMax();
					IntRelationOperation maxOp = r.isMaxIncl() ? IntRelationOperation::lt : IntRelationOperation::lte;
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
