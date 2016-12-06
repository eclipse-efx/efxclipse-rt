package org.eclipse.fx.formats.svg.fx

import com.sun.javafx.geom.PathIterator
import javafx.geometry.Insets
import javafx.scene.layout.CornerRadii
import javafx.scene.paint.Color
import javafx.scene.shape.Shape
import org.eclipse.fx.formats.svg.svg.SvgFactory
import org.eclipse.fx.formats.svg.svg.SvgPathElement
import org.eclipse.fx.formats.svg.svg.Visibility

class FXToSvgUtils {
	def static String toRGBHex(Color c) {
		var r = Math.round(c.red * 255.0);
        var g = Math.round(c.green * 255.0);
        var b = Math.round(c.blue * 255.0);
		return String.format("#%02x%02x%02x" , r, g, b);
	}

	def static Visibility toVisibility(boolean b) {
		if( b ) {
			return Visibility.VISIBLE
		} else {
			return Visibility.HIDDEN
		}
	}

	def static SvgPathElement createPath(Shape s) {
		val i = s.impl_configShape.getPathIterator(null);
		val f = newFloatArrayOfSize(6);
		val b = new StringBuilder();
		for( ; ! i.done; i.next ) {
			val type = i.currentSegment(f);
			if( type == PathIterator.SEG_LINETO ) {
				b.append('''L «f.get(0)» «f.get(1)»''')
			} else if( type == PathIterator.SEG_CLOSE ) {
				b.append("z")
			} else if( type == PathIterator.SEG_CUBICTO ) {
				b.append('''C «f.get(0)» «f.get(1)» «f.get(2)» «f.get(3)» «f.get(4)» «f.get(5)»''')
			} else if( type == PathIterator.SEG_MOVETO ) {
				b.append('''M «f.get(0)» «f.get(1)»''')
			} else if( type == PathIterator.SEG_QUADTO ) {
				b.append('''Q «f.get(0)» «f.get(1)» «f.get(2)» «f.get(3)»''')
			}
		}

		var p = SvgFactory.eINSTANCE.createSvgPathElement
		p.d = b.toString
		return p
	}

	def static String toProportion(double v) {
		return v * 100 + "%"
	}

	def static boolean isEmpty(Insets i) {
		if( i == null ) {
			return true
		} else {
			return i.left == 0 && i.right == 0 && i.top == 0 && i.bottom == 0
		}
	}

	def static boolean isEmpty(CornerRadii r) {
		if( r == null ) {
			return true;
		} else {
			return r.bottomLeftHorizontalRadius == 0
					&& r.bottomLeftVerticalRadius == 0
					&& r.bottomRightHorizontalRadius == 0
					&& r.bottomRightVerticalRadius == 0
					&& r.topLeftHorizontalRadius == 0
					&& r.topLeftVerticalRadius == 0
					&& r.topRightHorizontalRadius == 0
					&& r.topRightVerticalRadius == 0
		}
	}
}