package org.eclipse.fx.formats.svg

import javafx.scene.Group
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.image.ImageView
import javafx.scene.layout.Region
import javafx.scene.shape.Arc
import javafx.scene.shape.Circle
import javafx.scene.shape.Ellipse
import javafx.scene.shape.Line
import javafx.scene.shape.Path
import javafx.scene.shape.Polygon
import javafx.scene.shape.Polyline
import javafx.scene.shape.QuadCurve
import javafx.scene.shape.Rectangle
import javafx.scene.shape.SVGPath
import javafx.scene.text.Text
import org.eclipse.fx.formats.svg.fx.PresentationAttributesUtil
import org.eclipse.fx.formats.svg.svg.SvgDefsElement
import org.eclipse.fx.formats.svg.svg.SvgElement
import org.eclipse.fx.formats.svg.svg.SvgFactory
import org.eclipse.fx.formats.svg.svg.SvgSvgElement

import static extension org.eclipse.fx.formats.svg.fx.FXToSvgUtils.*
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.fx.formats.svg.svg.SvgGElement

class FXToSvg {
	SvgSvgElement root;
	SvgDefsElement defs;

	Scene s;
	Parent p;

	extension PresentationAttributesUtil e = new PresentationAttributesUtil([ getDefs ]);

	new(Scene s) {
		this.s = s;
	}

	new(Parent p) {
		this.p = p;
	}

	def getDefs() {
		if( defs == null ) {
			defs = SvgFactory.eINSTANCE.createSvgDefsElement
			root.children.add(0,defs);
		}
		return defs;
	}

	def SvgSvgElement getSvgRoot() {
		if( root == null ) {
			root = SvgFactory.eINSTANCE.createSvgSvgElement;

			if( this.s != null ) {
				root.width = s.width.toString
				root.height = s.height.toString
				if( s.fill != null ) {
					root.applyFill(s.fill)
				}
				root.children += transform(this.s.root)
			} else {
				root = SvgFactory.eINSTANCE.createSvgSvgElement;
				root.width = p.layoutBounds.width.toString
				root.height = p.layoutBounds.height.toString
				val rr = transform(this.p) as SvgGElement;
				rr.transform = null
				root.children += rr
			}
		}

		return root;
	}

	def dispatch SvgElement transform(Region r) {
		var e = SvgFactory.eINSTANCE.createSvgGElement
		e.visibility = r.isVisible.toVisibility
		e.transform = '''translate(«r.boundsInParent.minX»,«r.boundsInParent.minY»)'''
		/*r.background
		r.boundsInParent
		r.blendMode
		r.border

		r.clip
		r.cursor
		r.effect
		r.opacity
		r.rotate*/

//		val bg = SvgFactory.eINSTANCE.createSvgRectElement
//		e.children += bg
//
//		bg.width = r.boundsInParent.width.toString
//		bg.height = r.boundsInParent.height.toString
//
//		if( r.background == null ) {
//			bg.fill = "transparent"
//		} else if( r.background.fills.size == 1 ) {
//			val bFill = r.background.fills.head
//			if( bFill.insets.isEmpty && bFill.radii.isEmpty ) {
//				bg.applyFill(bFill.fill)
//			} else {
//				bg.fill = "transparent"
//				e.children += r.background.fills.map[ createBackgroundFill(r) ].toList
//			}
//		} else {
//			bg.fill = "transparent"
//			e.children += r.background.fills.map[ createBackgroundFill(r) ].toList
//		}

		if( r.shape != null ) {
			//FIXME We need to use that node for background/... instead of the clip
			val cp = SvgFactory.eINSTANCE.createSvgClipPathElement
			cp.id = EcoreUtil.generateUUID
			cp.children += transform(r.shape)
			getDefs.children += cp
			e.clip_path = '''url(#«cp.id»)'''

			// Handle backgrounds
			if( r.background != null ) {
				e.children += r.background.fills.map[ createBackgroundFill(r) ].toList
			}

			// Handle borders
			if( r.border != null ) {
				e.children += r.border.createBorder(r)
			}
		} else {
			// Handle backgrounds
			if( r.background != null ) {
				e.children += r.background.fills.map[ createBackgroundFill(r) ].toList
			}

			// Handle borders
			if( r.border != null ) {
				e.children += r.border.createBorder(r)
			}

		}

		e.children += r.childrenUnmodifiable.filter[visible].map[ transform ].toList

		if( r.clip != null ) {
			println("Region-Clip " + r.clip)
			val cp = SvgFactory.eINSTANCE.createSvgClipPathElement
			cp.id = EcoreUtil.generateUUID
			cp.children += transform(r.clip)
			getDefs.children += cp
			e.clip_path = '''url(#«cp.id»)'''
		}

		return e;
	}

	def dispatch SvgElement transform(Group g) {
		var e = SvgFactory.eINSTANCE.createSvgGElement
		e.visibility = g.isVisible.toVisibility

		e.children += g.childrenUnmodifiable.filter[visible].map[ transform ].toList

		if( g.clip != null ) {
			println("Group-CLIP: " + g.clip)
			val cp = SvgFactory.eINSTANCE.createSvgClipPathElement
			cp.id = EcoreUtil.generateUUID
			cp.children += transform(g.clip)
			getDefs.children += cp
			e.clip_path = '''url(#«cp.id»)'''
		}

		return e
	}

	def dispatch SvgElement transform(ImageView v) {
		var e = SvgFactory.eINSTANCE.createSvgImageElement
		e.visibility = v.isVisible.toVisibility
		return e;
	}

	def dispatch SvgElement transform(Arc a) {
		var e = a.createPath
		e.visibility = a.isVisible.toVisibility
		e.applyFill(a.fill)
		return e;
	}

	def dispatch SvgElement transform(Circle c) {
		print("Circle arc")
		return null;
	}

	def dispatch SvgElement transform(Ellipse e) {
		print("Ellipse arc")
		return null;
	}

	def dispatch SvgElement transform(Line e) {
		print("Line arc")
		return null;

	}

	def dispatch SvgElement transform(Path p) {
		var e = p.createPath
		e.visibility = p.isVisible.toVisibility
		e.applyFill(p.fill)

		if( p.clip != null ) {
			println("PATH_CLIP:" + p.clip)
			val cp = SvgFactory.eINSTANCE.createSvgClipPathElement
			cp.id = EcoreUtil.generateUUID
			cp.children += transform(p.clip)
			getDefs.children += cp
			e.clip_path = '''url(#«cp.id»)'''
		}

		return e;
	}

	def dispatch SvgElement transform(Polygon e) {
		print("Polygon arc")
		return null;

	}

	def dispatch SvgElement transform(Polyline e) {
		print("Polyline arc")
		return null;

	}

	def dispatch SvgElement transform(QuadCurve e) {
		print("QuadCurve arc")
		return null;

	}

	def dispatch SvgElement transform(Rectangle e) {
		val r = SvgFactory.eINSTANCE.createSvgRectElement
		r.x = e.x.toString
		r.y = e.y.toString
		r.width = e.width.toString
		r.height = e.height.toString

		r.visibility = e.isVisible.toVisibility
		r.applyFill(e.fill)

		return r;

	}

	def dispatch SvgElement transform(SVGPath e) {
		val p = SvgFactory.eINSTANCE.createSvgPathElement
		p.d = e.content
		return p;

	}

	def dispatch SvgElement transform(Text e) {
		val p = e.createPath
		p.visibility = e.isVisible.toVisibility
		p.applyFill(e.fill)

		var g = SvgFactory.eINSTANCE.createSvgGElement
		g.transform = '''translate(«e.boundsInParent.minX»,«e.boundsInParent.minY + e.baselineOffset»)'''
		g.children += p;

		return g;
	}
}