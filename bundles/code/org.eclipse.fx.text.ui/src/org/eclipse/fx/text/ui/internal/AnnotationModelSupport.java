package org.eclipse.fx.text.ui.internal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

import org.eclipse.fx.core.Subscription;
import org.eclipse.fx.ui.controls.styledtext.StyledTextArea;
import org.eclipse.fx.ui.controls.styledtext.StyledTextContent.TextChangeListener;
import org.eclipse.fx.ui.controls.styledtext.TextChangedEvent;
import org.eclipse.fx.ui.controls.styledtext.TextChangingEvent;
import org.eclipse.fx.ui.controls.styledtext.model.AnnotationProvider;
import org.eclipse.fx.ui.controls.styledtext.model.TextAnnotation;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.AnnotationModelEvent;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.text.source.IAnnotationModelListener;
import org.eclipse.jface.text.source.IAnnotationModelListenerExtension;

import com.google.common.collect.Range;
import com.google.common.collect.RangeSet;
import com.google.common.collect.TreeRangeSet;

import javafx.application.Platform;

public class AnnotationModelSupport {

	private IAnnotationModel annotationModel;
	private StyledTextArea control;

	private Map<Integer, Set<MarkerAnnotation>> annotationCache = new HashMap<>();

	public AnnotationModelSupport(IAnnotationModel model, StyledTextArea control) {
		this.annotationModel = model;
		this.control = control;
	}

	static class MarkerAnnotation implements TextAnnotation, WrappedAnnotation {
		public final Range<Integer> range;
		public final Annotation annotation;
		public final int tabAdvance;

		private final String nfo;

		public MarkerAnnotation(Annotation annotation, Range<Integer> range, int tabAdvance) {
			this.annotation = annotation;
			this.range = range;
			this.tabAdvance = tabAdvance;
			this.nfo = annotation.getType() + annotation.getText();
		}

		@Override
		public Annotation getAnnotation() {
			return annotation;
		}

		@Override
		public Object getModel() {
			return annotation;
		}

		@Override
		public Range<Integer> getRange() {
			return range;
		}

		@Override
		public String toString() {
			return "MarkerAnnotation("+range+", "+nfo+")";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((nfo == null) ? 0 : nfo.hashCode());
			result = prime * result + ((range == null) ? 0 : range.hashCode());
			result = prime * result + tabAdvance;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			MarkerAnnotation other = (MarkerAnnotation) obj;
			if (nfo == null) {
				if (other.nfo != null)
					return false;
			} else if (!nfo.equals(other.nfo))
				return false;
			if (range == null) {
				if (other.range != null)
					return false;
			} else if (!range.equals(other.range))
				return false;
			if (tabAdvance != other.tabAdvance)
				return false;
			return true;
		}





	}

	class AnnotationModelAnnotationProvider implements AnnotationProvider {
		@Override
		public Set<? extends org.eclipse.fx.ui.controls.styledtext.model.Annotation> computeAnnotations(int index) {
			return getAnnotations(index);
		}


		@Override
		public Subscription registerChangeListener(Consumer<RangeSet<Integer>> onChange) {
			AnnotationModelSupport.this.listener.add(onChange);
			return new Subscription() {
				@Override
				public void dispose() {
					AnnotationModelSupport.this.listener.remove(onChange);
				}
			};
		}


	}

	private List<Consumer<RangeSet<Integer>>> listener = new ArrayList<>();

	public void triggerChange(RangeSet<Integer> range) {
		Platform.runLater(()-> {
			this.listener.forEach(l->l.accept(range));
		});
	}

	private Set<MarkerAnnotation> findAnnotations(int lineIndex) {
		long now = System.currentTimeMillis();
		Set<MarkerAnnotation> result = new HashSet<>();
		Iterator<Annotation> annotationIterator = annotationModel.getAnnotationIterator();
		while( annotationIterator.hasNext() ) {
			Annotation a = annotationIterator.next();
			Position position = annotationModel.getPosition(a);
			int curLineIndex = control.getLineAtOffset(position.offset);
			if (curLineIndex == lineIndex) {
				int lineBegin = control.getOffsetAtLine(curLineIndex);
				int lineLength = control.getContent().getLine(curLineIndex).length();
				// TODO multiline = ????
				int lower = position.offset - lineBegin;
				int upper = lower + Math.min(position.length, lineLength);
				Range<Integer> lineLocalRange = Range.closed(lower, upper);
				MarkerAnnotation annotation = new MarkerAnnotation(a, lineLocalRange, control.getTabAdvance());
				result.add(annotation);
			}
		}
//		System.err.println("AnnotationModelSupport: findAnnotations("+lineIndex+") needed " + (System.currentTimeMillis() - now) + "ms");
		return result;
	}



	private Set<MarkerAnnotation> getAnnotations(int lineIndex) {
		Set<MarkerAnnotation> set = annotationCache.get(lineIndex);
		if (set == null) {
			set = findAnnotations(lineIndex);
			annotationCache.put(lineIndex, set);
		}
		return set;
	}

	private void onAnnotationModelChange() {
//		System.err.println("AnnotationModelSupport: clearing annotation cache");
		annotationCache.clear();
		RangeSet<Integer> range = TreeRangeSet.create();
		range.add(com.google.common.collect.Range.closed(0, Integer.MAX_VALUE));
		triggerChange(range);

	}

	class Listener implements IAnnotationModelListener, IAnnotationModelListenerExtension {
		@Override
		public void modelChanged(AnnotationModelEvent event) {
			onAnnotationModelChange();
//			System.err.println("modelChanged");
//			System.err.println(" added: " + Arrays.toString(event.getAddedAnnotations()));
//			System.err.println(" removed: " + Arrays.toString(event.getRemovedAnnotations()));
//			System.err.println(" changed: " + Arrays.toString(event.getChangedAnnotations()));
		}

		@Override
		public void modelChanged(IAnnotationModel model) {
			// full
		}

	}


	public void install() {
		annotationModel.addAnnotationModelListener(new Listener());
		control.getAnnotationProvider().add(new AnnotationModelAnnotationProvider());
		control.tabAvanceProperty().addListener((x, o, n)->{
			onAnnotationModelChange();
//			System.err.println("ON TAB ADVANCE CHANGE!");
//			RangeSet<Integer> rs = TreeRangeSet.<Integer>create().complement();
//			triggerChange(rs);
		});

		TextChangeListener textChangeListener = new TextChangeListener() {
			@Override
			public void textSet(TextChangedEvent event) {
				onAnnotationModelChange();
			}

			@Override
			public void textChanging(TextChangingEvent event) {

			}

			@Override
			public void textChanged(TextChangedEvent event) {
				onAnnotationModelChange();
			}
		};

		control.contentProperty().addListener((x,o,n)-> {
			if (o != null) {
				o.removeTextChangeListener(textChangeListener);
			}
			if (n != null) {
				n.addTextChangeListener(textChangeListener);
			}
		});
	}

}
