package org.eclipse.fx.ui.controls.styledtext.model;

import java.util.Set;
import java.util.function.Consumer;

import org.eclipse.fx.core.Subscription;

import com.google.common.collect.RangeSet;

public interface AnnotationProvider {

	Set<? extends Annotation> computeAnnotations(int index);

	Subscription registerChangeListener(Consumer<RangeSet<Integer>> onChange);
}
