package org.eclipse.fx.code.editor.configuration.text;

import java.util.List;
import java.util.Map;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;

import org.eclipse.fx.code.editor.Input;
import org.eclipse.fx.code.editor.InputContext;
import org.eclipse.fx.code.editor.configuration.Check;
import org.eclipse.fx.code.editor.configuration.CompositeCondition;
import org.eclipse.fx.code.editor.configuration.Condition;
import org.eclipse.fx.code.editor.configuration.Equals;
import org.eclipse.fx.code.editor.configuration.EqualsCondition;
import org.eclipse.fx.code.editor.configuration.ExistsCondition;
import org.eclipse.fx.code.editor.configuration.Range;
import org.eclipse.fx.core.NamedValue;
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

	public static boolean checkCondition(Condition condition, Map<String,NamedValue<Object>> values) {
		if( condition != null ) {
			if( condition instanceof EqualsCondition ) {
				NamedValue<Object> namedValue = values.get(condition.getName());
				if( namedValue != null ) {
					String value = ((EqualsCondition)condition).getValue();
					if( value == null ) {
						return value == namedValue.getValue();
					} else {
						return value.equals(namedValue.getValue());
					}
				}
				return false;
			} else if( condition instanceof ExistsCondition ) {
				return values.containsKey( condition.getName() );
			} else if( condition instanceof CompositeCondition ) {
				boolean and = ((CompositeCondition)condition).isAnd();
				for( Condition e : ((CompositeCondition) condition).getElementList() ) {
					if( and ) {
						if( ! checkCondition(e, values) ) {
							return false;
						}
					} else {
						if( checkCondition(e, values) ) {
							return true;
						}
					}
				}
				if( and ) {
					return true;
				} else {
					return false;
				}
			}
		}
		return true;
	}

	public static Map<String,NamedValue<Object>> createNamedValueList(InputContext context, Input<?> input, List<ConfigurationConditionDataProvider> providers) {
		return providers.stream()
				.filter( p -> p.test(context,input))
				.map( p -> p.get(context,input))
				.flatMap( l -> l.stream())
				.collect(Collectors.toMap( NamedValue::getName, v -> v));
	}
}
