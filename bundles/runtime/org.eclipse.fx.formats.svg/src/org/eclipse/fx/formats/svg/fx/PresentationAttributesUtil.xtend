package org.eclipse.fx.formats.svg.fx

import java.util.Collections
import java.util.List
import java.util.function.Supplier
import javafx.scene.layout.BackgroundFill
import javafx.scene.layout.Border
import javafx.scene.layout.BorderStroke
import javafx.scene.layout.CornerRadii
import javafx.scene.layout.Region
import javafx.scene.paint.Color
import javafx.scene.paint.CycleMethod
import javafx.scene.paint.ImagePattern
import javafx.scene.paint.LinearGradient
import javafx.scene.paint.RadialGradient
import javafx.scene.paint.Stop
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.fx.formats.svg.svg.PresentationAttributes
import org.eclipse.fx.formats.svg.svg.SpreadMethod
import org.eclipse.fx.formats.svg.svg.SvgDefsElement
import org.eclipse.fx.formats.svg.svg.SvgElement
import org.eclipse.fx.formats.svg.svg.SvgFactory
import org.eclipse.fx.formats.svg.svg.SvgLinearGradientElement
import org.eclipse.fx.formats.svg.svg.SvgStopElement

import static extension org.eclipse.fx.formats.svg.fx.FXToSvgUtils.*

class PresentationAttributesUtil {
	Supplier<SvgDefsElement> defSupplier;

	new(Supplier<SvgDefsElement> defSupplier) {
		this.defSupplier = defSupplier;
	}

	def List<SvgElement> createBorder(Border b, Region r) {
		if( b == null ) {
			return Collections.emptyList
		} else {
			return b.strokes.map[ createBorderStroke(r) ].flatten.toList
		}
	}

	def List<SvgElement> createBorderStroke(BorderStroke s, Region r) {
		val w = s.widths.bottom == s.widths.left
		     && s.widths.bottom == s.widths.right
		     && s.widths.bottom == s.widths.top

		val c = s.bottomStroke == s.leftStroke
		    && s.bottomStroke == s.rightStroke
		    && s.bottomStroke == s.topStroke

		val st = s.bottomStyle == s.leftStyle
		    && s.bottomStyle == s.rightStyle
		    && s.bottomStyle == s.topStyle

		if( w && c && st && s.radii.checkRadii ) {
			val rv = SvgFactory.eINSTANCE.createSvgRectElement
			rv.fill = "transparent"
			rv.x = (r.layoutBounds.minX + s.insets.left).toString
			rv.y = (r.layoutBounds.minY + s.insets.top).toString
			rv.width = (r.layoutBounds.width - s.insets.left - s.insets.right).toString
			rv.height = (r.layoutBounds.height - s.insets.top - s.insets.bottom).toString
			rv.stroke_width = s.widths.bottom.toString
			rv.applyStroke(s.bottomStroke)
			return Collections.singletonList(rv);
		} else {
			println("====> Dup actions")
		}

		return Collections.emptyList;
	}

	def static checkRadii(CornerRadii r) {
		val rx = r.bottomLeftHorizontalRadius == r.bottomRightHorizontalRadius
			&& r.bottomLeftHorizontalRadius == r.topLeftHorizontalRadius
			&& r.bottomLeftHorizontalRadius == r.topRightHorizontalRadius

		val ry = r.bottomLeftVerticalRadius == r.bottomRightVerticalRadius
			&& r.bottomLeftVerticalRadius == r.topLeftVerticalRadius
			&& r.bottomLeftVerticalRadius == r.topRightVerticalRadius

		return rx && ry;
	}

	def SvgElement createBackgroundFill(BackgroundFill f, Region r) {
		if( f.radii.checkRadii ) {
			val rv = SvgFactory.eINSTANCE.createSvgRectElement
			rv.rx = f.radii.bottomLeftHorizontalRadius.toString
			rv.ry = f.radii.bottomLeftVerticalRadius.toString
			rv.x = f.insets.left.toString
			rv.y = f.insets.top.toString
			rv.width = (r.layoutBounds.width - f.insets.left - f.insets.right).toString
			rv.height = (r.layoutBounds.height - f.insets.top - f.insets.bottom).toString
			rv.fill = "transparent"
			rv.applyFill(f.fill)
			println( r + " ===> " + rv.fill + "; " + f.fill)
			return rv
		} else {
			val rv = SvgFactory.eINSTANCE.createSvgPathElement
			return rv;
		}
	}

//	def void applyBackground(PresentationAttributes e, Background b) {
//		if( b ==  null ) {
//			return
//		}
//
//		//TODO What is outset for?
//
//		if( !b.fills.empty ) {
//			if( b.fills.size == 1 ) {
//				if( b.fills.head.insets.empty && b.fills.head.radii.empty ) {
//					e.applyFill(b.fills.head.fill)
//				}
//			}
//		} else if( !b.images.empty ) {
//
//		}
//	}

	def dispatch void applyFill(PresentationAttributes e, Color p) {
		e.fill = p.toRGBHex
		if( p.opacity != 1.0 ) {
			e.fill_opacity = p.opacity.toString
		}
	}

	def dispatch void applyFill(PresentationAttributes e, ImagePattern p) {
		System.err.println("ImagePattern not yet supported")
	}

	def dispatch void applyFill(PresentationAttributes e, LinearGradient p) {
		var SvgLinearGradientElement l = SvgFactory.eINSTANCE.createSvgLinearGradientElement
		l.id = EcoreUtil.generateUUID
		l.x1 = if (p.isProportional) { p.startX.toProportion } else { p.startX.toString }
		l.x2 = if (p.isProportional) { p.endX.toProportion } else { p.endX.toString }
		l.y1 = if (p.isProportional) { p.startY.toProportion } else { p.startY.toString }
		l.y2 = if (p.isProportional) { p.endY.toProportion } else { p.endY.toString }
		l.spreadMethod = p.cycleMethod.toSpread
		for( Stop s : p.stops ) {
			l.children += s.toStop
		}

		defSupplier.get.children += l;
		e.fill = '''url(#«l.id»)'''
	}

	def dispatch void applyFill(PresentationAttributes e, RadialGradient p) {
		System.err.println("RadialGradient not yet supported")
	}

	def dispatch void applyStroke(PresentationAttributes e, Color p) {
		e.stroke = p.toRGBHex
		if( p.opacity != 0.0 ) {
			e.stroke_opacity = p.opacity.toString
		}
	}

	def dispatch void applyStroke(PresentationAttributes e, ImagePattern p) {
		System.err.println("ImagePattern not yet supported")
	}

	def dispatch void applyStroke(PresentationAttributes e, LinearGradient p) {
		var SvgLinearGradientElement l = SvgFactory.eINSTANCE.createSvgLinearGradientElement
		l.id = EcoreUtil.generateUUID
		l.x1 = if (p.isProportional) { p.startX.toProportion } else { p.startX.toString }
		l.x2 = if (p.isProportional) { p.endX.toProportion } else { p.endX.toString }
		l.y1 = if (p.isProportional) { p.startY.toProportion } else { p.startY.toString }
		l.y2 = if (p.isProportional) { p.endY.toProportion } else { p.endY.toString }
		l.spreadMethod = p.cycleMethod.toSpread
		for( Stop s : p.stops ) {
			l.children += s.toStop
		}

		defSupplier.get.children += l;
		e.stroke = '''url(#«l.id»)'''
	}

	def dispatch void applyStroke(PresentationAttributes e, RadialGradient p) {
		System.err.println("RadialGradient not yet supported")
	}

	def static SvgStopElement toStop(Stop s) {
		var e = SvgFactory.eINSTANCE.createSvgStopElement
		e.stop_color = s.color.toRGBHex
		e.offset = s.offset.toString

		return e;
	}

	def static SpreadMethod toSpread(CycleMethod cm) {
		switch(cm) {
			case NO_CYCLE: SpreadMethod.PAD
			case REFLECT: SpreadMethod.REFLECT
			case REPEAT: SpreadMethod.REPEAT
		}
	}
}