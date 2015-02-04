/*******************************************************************************
 * Copyright (c) 2012 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.formats.svg.converter

import org.eclipse.fx.formats.svg.svg.ContentElement
import org.eclipse.fx.formats.svg.svg.SpreadMethod
import org.eclipse.fx.formats.svg.svg.Stroke_linecap
import org.eclipse.fx.formats.svg.svg.Stroke_linejoin
import org.eclipse.fx.formats.svg.svg.SvgDefsElement
import org.eclipse.fx.formats.svg.svg.SvgElement
import org.eclipse.fx.formats.svg.svg.SvgFeGaussianBlurElement
import org.eclipse.fx.formats.svg.svg.SvgFilterElement
import org.eclipse.fx.formats.svg.svg.SvgGElement
import org.eclipse.fx.formats.svg.svg.SvgLinearGradientElement
import org.eclipse.fx.formats.svg.svg.SvgPathElement
import org.eclipse.fx.formats.svg.svg.SvgRadialGradientElement
import org.eclipse.fx.formats.svg.svg.SvgRectElement
import org.eclipse.fx.formats.svg.svg.SvgStopElement
import org.eclipse.fx.formats.svg.svg.SvgSvgElement
import org.eclipse.fx.formats.svg.svg.XLinkAttributes
import org.eclipse.emf.ecore.EObject
import org.eclipse.fx.formats.svg.svg.SvgEllipseElement
import org.eclipse.fx.formats.svg.svg.SvgCircleElement
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.fx.formats.svg.svg.SvgClipPathElement
import org.eclipse.fx.formats.svg.svg.CoreAttributes
import java.awt.geom.AffineTransform
import java.awt.geom.Point2D
import org.eclipse.fx.formats.svg.svg.Fill_rule
import org.eclipse.fx.formats.svg.svg.SvgPolygonElement
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.fx.formats.svg.svg.SvgPackage$Literals
import org.eclipse.fx.formats.svg.svg.PresentationAttributes
import org.eclipse.fx.formats.svg.svg.FilterPrimitiveElement
import org.eclipse.fx.formats.svg.svg.SvgUseElement
import org.eclipse.fx.formats.svg.svg.SvgPolylineElement
import org.eclipse.fx.formats.svg.svg.SvgImageElement

class FXMLConverter {
	private SvgSvgElement rootElement

	new(SvgSvgElement rootElement) {
		this.rootElement = rootElement;
	}

	def generate() '''
	«val content = handle(rootElement)»
	<?xml version="1.0" encoding="UTF-8"?>

	<?import java.lang.*?>
	<?import javafx.scene.*?>
	<?import javafx.scene.shape.*?>
	<?import javafx.scene.paint.*?>
	<?import javafx.scene.image.*?>
	<?import javafx.scene.transform.*?>
	<?import javafx.scene.effect.*?>

	«content»
	'''

	def dispatch CharSequence handle(EObject o) '''
		<!-- Unhandled type '«o.eClass.name»' -->
	'''

	def dispatch CharSequence handle(SvgLinearGradientElement o) {
		// Nothing to do we reference them directly when needed because they can contain relative sizes
	}

	def dispatch CharSequence handle(SvgRadialGradientElement o) {
		// Nothing to do we reference them directly when needed because they can contain relative sizes
	}

	def dispatch CharSequence handle(SvgSvgElement element) '''
	<Group id='_root' xmlns:fx="http://javafx.com/fxml" xmlns:fxsvg="http://efxclipse.org/fxml-svg">
		«handleStyleClassAttributes(element.class_)»
«««		«IF element.styleSheet != null»
«««			<stylesheets>
«««				<String fx:value="«element.styleSheet»" />
«««			</stylesheets>
«««		«ENDIF»
		<children>
			«FOR o : element.children»
				«handle(o)»
			«ENDFOR»
		</children>
	</Group>
	'''

	def dispatch CharSequence handle(SvgDefsElement element) '''
	<fx:define>
		«FOR o : element.children»
			«handle(o)»
		«ENDFOR»
	</fx:define>
	'''

	def CharSequence handleGradient(SvgLinearGradientElement element, Double opacity) '''
	<LinearGradient
		«val t = createAffineTransform(element.gradientTransform) as AffineTransform»
		«var x1 = element.x1.parseCoordinate»
		«var y1 = element.y1.parseCoordinate»
		«var x2 = element.x2.parseCoordinate»
		«var y2 = element.y2.parseCoordinate»

		«IF element.x1 != null»startX="«t.transform( new Point2D$Double(x1,y1), null).x»"«ENDIF»
		«IF element.y1 != null»startY="«t.transform( new Point2D$Double(x1,y1),null).y»"«ENDIF»
		«IF element.x2 != null»endX="«t.transform( new Point2D$Double(x2,y2), null).x»"«ENDIF»
		«IF element.y2 != null»endY="«t.transform( new Point2D$Double(x2,y2), null).y»"«ENDIF»
		«IF element.spreadMethod != SpreadMethod::PAD»cycleMethod="«element.spreadMethod.toFx»"«ELSE»cycleMethod="NO_CYCLE"«ENDIF»
««« Gradients don't have an ID attribute should use fx:id?
«««		«IF element.id != null»id="«element.id.validateId»"«ENDIF»
		proportional="false">
		«val owner = resolveGradientStopElement(element)»
		«IF owner != null»
			<stops>
			«FOR o : (owner as ContentElement<?>).children.filter(typeof(SvgStopElement))»
				«handleStop(o,opacity)»
			«ENDFOR»
			</stops>
		«ENDIF»
	</LinearGradient>
	'''


	def CharSequence handleGradient(SvgRadialGradientElement element, Double opacity) '''
	<RadialGradient
		«val t = createAffineTransform(element.gradientTransform) as AffineTransform»
		«var cx = element.cx.parseCoordinate»
		«var cy = element.cy.parseCoordinate»
		«var fx = element.fx.parseCoordinate»
		«var fy = element.fy.parseCoordinate»

		«IF element.cx != null»centerX="«t.transform(new Point2D$Double(cx,cy),null).x»"«ENDIF»
		«IF element.cy != null»centerY="«t.transform(new Point2D$Double(cx,cy),null).y»"«ENDIF»
		«IF element.r != null»radius="«element.r.parseLength*t.scaleX»"«ENDIF»
		«IF element.fx != null || element.fy != null»focusDistance="«calculateFocusDistance(t,cx,cy,fx,fy)»"«ENDIF»
««« Is the Focus Radius calculation really correct???
		«IF element.fx != null || element.fy != null»focusAngle="«calculateFocusAngle(t,cx,cy,fx,fy)»"«ENDIF»
		«IF element.spreadMethod != SpreadMethod::PAD»cycleMethod="«element.spreadMethod.toFx»"«ELSE»cycleMethod="NO_CYCLE"«ENDIF»
««« Gradients don't have an ID attribute should use fx:id?
«««		«IF element.id != null»id="«element.id.validateId»"«ENDIF»
		proportional="false">
		«val owner = resolveGradientStopElement(element)»
		«IF owner != null»
			<stops>
			«FOR o : (owner as ContentElement<?>).children.filter(typeof(SvgStopElement))»
				«handleStop(o,opacity)»
			«ENDFOR»
			</stops>
		«ENDIF»
	</RadialGradient>
	'''

	def createAffineTransform(String transformSpec) {
		if( transformSpec == null ) {
			return new AffineTransform();
		} else {
			val params = transformSpec.substring(transformSpec.indexOf("(")+1,transformSpec.indexOf(")"))
			if( transformSpec.startsWith("matrix") ) {
				val parts = params.split("\\s*,\\s*|\\s+");
				val rv = new AffineTransform(
					Double::parseDouble(parts.get(0)),
					Double::parseDouble(parts.get(1)),
					Double::parseDouble(parts.get(2)),
					Double::parseDouble(parts.get(3)),
					Double::parseDouble(parts.get(4)),
					Double::parseDouble(parts.get(5))
				);

                return rv;

			} else if( transformSpec.startsWith("translate") ) {
				val parts = params.split("\\s*,\\s*|\\s+");
				val rv = new AffineTransform();
				rv.translate(
					Double::parseDouble(parts.get(0)),
					Double::parseDouble(parts.get(1))
				);
				return rv;
			} else if( transformSpec.startsWith("scale") ) {
				val parts = params.split("\\s*,\\s*|\\s+");
				val rv = new AffineTransform();
				rv.scale(
					Double::parseDouble(parts.get(0)),
					Double::parseDouble(parts.get(1))
				);
				return rv;
			} else if( transformSpec.startsWith("rotate") ) {
				val parts = params.split("\\s*,\\s*|\\s+");
				val rv = new AffineTransform();
				rv.rotate(
					Double::parseDouble(parts.get(0)),
					Double::parseDouble(parts.get(1)),
					Double::parseDouble(parts.get(2))
				);
				return rv;
			}
		}

		return new AffineTransform();
	}


//	def calculateFocusDistance(AffineTransform transform, double cx, double cy, double fx, double fy) {
//		if( fx == cx && fy == cy ) {
//			return 0;
//		} else {
//			val c = transform.transform(new Point2D$Double(cx,cy),null)
//			val f = transform.transform(new Point2D$Double(fx,fy),null)
//
//			return Math::sqrt(((f.x-c.x)*(f.x-c.x))+((f.y-c.y)*(f.y-c.y)));
//		}
//	}
//
//	def calculateFocusAngle(AffineTransform transform, double cx, double cy, double fx, double fy) {
//		if( fx == cx && fy == cy ) {
//			return 0;
//		} else {
//			val c = transform.transform(new Point2D$Double(cx,cy),null)
//			val f = transform.transform(new Point2D$Double(fx,fy),null)
//			return Math::atan2(f.y-c.y, f.x-c.x)*180*0.31830989;
//		}
//	}

	def calculateFocusDistance(AffineTransform transform, double cx, double cy, double fx, double fy) {
		if( fx == cx && fy == cy ) {
			return 0;
		} else {
			val c = transform.transform(new Point2D$Double(cx,cy),null)
			val f = transform.transform(new Point2D$Double(fx,fy),null)
			return Math::sqrt(Math::pow(c.x - f.x,2) + Math::pow(c.y - f.y,2));
		}
	}

	def calculateFocusAngle(AffineTransform transform, double cx, double cy, double fx, double fy) {
		if( fx == cx && fy == cy ) {
			return 0;
		} else {
			val c = transform.transform(new Point2D$Double(cx,cy),null)
			val f = transform.transform(new Point2D$Double(fx,fy),null)
			return Math::atan(Math::pow(c.y - f.y,2) / Math::pow(c.x - f.x,2));
		}
	}

	def ContentElement<?> resolveGradientStopElement(SvgElement element) {
		if( element instanceof ContentElement<?> ) {
			val rv = (element as ContentElement<?>);
			if( rv.children.filter(typeof(SvgStopElement)).empty ) {
				if( element instanceof XLinkAttributes ) {
					val v = element as XLinkAttributes;
					if( v.resolvedInstance != null ) {
						return resolveGradientStopElement(v.resolvedInstance);
					}
				}
			} else {
				return rv;
			}
		}
		return null;
	}

	def resolveElement(String id) {
		val treeIt = EcoreUtil::getAllContents(rootElement,true).filter(typeof(SvgElement));
		while( treeIt.hasNext ) {
			val o = treeIt.next;
			if( o instanceof CoreAttributes ) {
				if( id.equals((o as CoreAttributes).id) ) {
					return o as SvgElement; // Workaround for for 424279
				}
			} else {
				val eo = o as SvgElement;
				val f = eo.eClass.getEStructuralFeature("id");
				if( f != null && id.equals(eo.eGet(f)) ) {
					return o;
				}
			}
		}

		return null;
	}

	def handleStop(SvgStopElement element,Double opacity) '''
	<Stop
		«IF element.offset != null»offset="«element.offset.parsePercentage»"«ENDIF»
		>
		«IF element.stop_opacity != null»
		<color>
			«IF opacity != null»
				«IF element.stop_color != null»
					«element.stop_color.fillPaint(Double::parseDouble(element.stop_opacity)*opacity)»
				«ELSE»
					<opacity>«Double::parseDouble(element.stop_opacity)*opacity»</opacity>
				«ENDIF»
			«ELSE»
				«IF element.stop_color != null»
					«element.stop_color.fillPaint(Double::parseDouble(element.stop_opacity))»
				«ELSE»
					<opacity>«element.stop_opacity»</opacity>
				«ENDIF»
			«ENDIF»
		</color>
		«ELSEIF element.stop_color != null»
		<color>
			«IF opacity != null»
				«element.stop_color.fillPaint(opacity)»
			«ELSE»
				«element.stop_color.fillPaint»
			«ENDIF»
		</color>
		«ENDIF»
	</Stop>
	'''

	def dispatch CharSequence handle(SvgImageElement element) '''
	<ImageView
		«IF element.x != null»x="«element.x.parseLength»"«ENDIF»
		«IF element.y != null»y="«element.y.parseLength»"«ENDIF»
«««		«IF element.width != null»width="«element.width.parseLength»"«ENDIF»
«««		«IF element.height != null»height="«element.height.parseLength»"«ENDIF»
		>
		«handleStyleClassAttributes(element.class_)»
		<Image
			url="«element.xlink__href»"
		/>
		«IF element.transform != null»
			<transforms>
				«element.transform.handleTransform»
			</transforms>
		«ENDIF»
		«IF element.filter != null»
			«val e = resolveElement(element.filter.substring(5,element.filter.length-1).trim) as SvgFilterElement»
			«IF e != null»
				«IF e.children.filter(typeof(FilterPrimitiveElement)).size == 1»
				«val fiElement = e.children.filter(typeof(FilterPrimitiveElement)).head as SvgElement»
				<effect>
					«handleFilter(fiElement)»
				</effect>
				«ELSE»
				<!-- Multi filter needs different handling -->
				«ENDIF»
			«ENDIF»
		«ENDIF»
		«IF element.clip_path != null && element.clip_path.trim.length > 0 && ! element.clip_path.trim.equals("none")»
			<clip>
				«val clipElement = resolveElement(element.clip_path.substring(5,element.clip_path.length-1)) as SvgClipPathElement»
				<Group>
					<children>
						«FOR e : clipElement.children»
							«handle(e)»
						«ENDFOR»
					</children>
					«IF clipElement.transform != null && clipElement.transform.trim.length > 0 && ! element.clip_path.equals("none")»
					<transforms>
						«handleTransform(clipElement.transform)»
					</transforms>
					«ENDIF»
				</Group>
			</clip>
		«ENDIF»
	</ImageView>
	'''

	def dispatch CharSequence handle(SvgRectElement element) '''
	<Rectangle
		«IF element.x != null»x="«element.x.parseLength»"«ENDIF»
		«IF element.y != null»y="«element.y.parseLength»"«ENDIF»
		«IF element.width != null»width="«element.width.parseLength»"«ENDIF»
		«IF element.height != null»height="«element.height.parseLength»"«ENDIF»
		«IF element.rx != null»arcWidth="«element.rx.parseLength * Double::valueOf("2.0")»"«ENDIF»
		«IF element.ry != null»arcHeight="«element.ry.parseLength * Double::valueOf("2.0")»"«ENDIF»
		«IF element.opacity != null»opacity="«element.opacity»"«ENDIF»
		«IF element.id != null»id="«element.id.validateId»"«ENDIF»
		«handleShapePresentationAttributes(element)»
		>
		«handlePaint("fill", lookupFeature(SvgPackage$Literals::PRESENTATION_ATTRIBUTES__FILL,element) as String,lookupFeature(SvgPackage$Literals::PRESENTATION_ATTRIBUTES__FILL_OPACITY,element) as String)»
		«handlePaint("stroke",lookupFeature(SvgPackage$Literals::PRESENTATION_ATTRIBUTES__STROKE,element) as String,lookupFeature(SvgPackage$Literals::PRESENTATION_ATTRIBUTES__STROKE_OPACITY,element) as String)»
		«handleStyleClassAttributes(element.class_)»

		«IF element.transform != null»
			<transforms>
				«element.transform.handleTransform»
			</transforms>
		«ENDIF»
		«IF element.filter != null»
			«val e = resolveElement(element.filter.substring(5,element.filter.length-1).trim) as SvgFilterElement»
			«IF e != null»
				«IF e.children.filter(typeof(FilterPrimitiveElement)).size == 1»
				«val fiElement = e.children.filter(typeof(FilterPrimitiveElement)).head as SvgElement»
				<effect>
					«handleFilter(fiElement)»
				</effect>
				«ELSE»
				<!-- Multi filter needs different handling -->
				«ENDIF»
			«ENDIF»
		«ENDIF»
		«IF element.clip_path != null && element.clip_path.trim.length > 0 && ! element.clip_path.trim.equals("none")»
			<clip>
				«val clipElement = resolveElement(element.clip_path.substring(5,element.clip_path.length-1)) as SvgClipPathElement»
				<Group>
					<children>
						«FOR e : clipElement.children»
							«handle(e)»
						«ENDFOR»
					</children>
					«IF clipElement.transform != null && clipElement.transform.trim.length > 0 && ! element.clip_path.equals("none")»
					<transforms>
						«handleTransform(clipElement.transform)»
					</transforms>
					«ENDIF»
				</Group>
			</clip>
		«ENDIF»
	</Rectangle>
	'''

	def dispatch CharSequence handle(SvgGElement element) '''
	<Group
		«IF element.x != null»translateX="«element.x.parseCoordinate»"«ENDIF»
		«IF element.y != null»translateY="«element.y.parseCoordinate»"«ENDIF»
		«IF element.opacity != null»opacity="«element.opacity.parseDouble * element.fill_opacity.parseDouble»"«ENDIF»
		«IF element.id != null»id="«element.id.validateId»"«ENDIF»
		>
		«handleStyleClassAttributes(element.class_)»
		<children>
			«FOR o : element.children»
				«handle(o)»
			«ENDFOR»
		</children>
		«IF element.transform != null»
			<transforms>
				«element.transform.handleTransform»
			</transforms>
		«ENDIF»
		«IF element.filter != null»
			«val e = resolveElement(element.filter.substring(5,element.filter.length-1).trim) as SvgFilterElement»
			«IF e != null»
				«IF e.children.filter(typeof(FilterPrimitiveElement)).size == 1»
				«val fiElement = e.children.filter(typeof(FilterPrimitiveElement)).head as SvgElement»
				<effect>
					«handleFilter(fiElement)»
				</effect>
				«ELSE»
				<!-- Multi filter needs different handling -->
				«ENDIF»
			«ENDIF»
		«ENDIF»
		«IF element.clip_path != null && element.clip_path.trim.length > 0 && ! element.clip_path.trim.equals("none")»
			<clip>
				«val clipElement = resolveElement(element.clip_path.substring(5,element.clip_path.length-1)) as SvgClipPathElement»
				<Group>
					<children>
						«FOR e : clipElement.children»
							«handle(e)»
						«ENDFOR»
					</children>
					«IF clipElement.transform != null && clipElement.transform.trim.length > 0 && ! element.clip_path.equals("none")»
					<transforms>
						«handleTransform(clipElement.transform)»
					</transforms>
					«ENDIF»
				</Group>
			</clip>
		«ENDIF»
	</Group>
	'''

	def dispatch CharSequence handle(SvgUseElement element) '''
	<Group
		«IF element.x != null»translateX="«element.x.parseCoordinate»"«ENDIF»
		«IF element.y != null»translateY="«element.y.parseCoordinate»"«ENDIF»
		«IF element.opacity != null»opacity="«element.opacity.parseDouble * element.fill_opacity.parseDouble»"«ENDIF»
		«IF element.id != null»id="«element.id.validateId»"«ENDIF»
		>
		«handleStyleClassAttributes(element.class_)»

		«IF element.resolvedInstance != null»
		<children>
			«handle(element.resolvedInstance)»
		</children>
		«ENDIF»
		«IF element.transform != null»
			<transforms>
				«element.transform.handleTransform»
			</transforms>
		«ENDIF»
		«IF element.filter != null»
			«val e = resolveElement(element.filter.substring(5,element.filter.length-1).trim) as SvgFilterElement»
			«IF e != null»
				«IF e.children.filter(typeof(FilterPrimitiveElement)).size == 1»
				«val fiElement = e.children.filter(typeof(FilterPrimitiveElement)).head as SvgElement»
				<effect>
					«handleFilter(fiElement)»
				</effect>
				«ELSE»
				<!-- Multi filter needs different handling -->
				«ENDIF»
			«ENDIF»
		«ENDIF»
		«IF element.clip_path != null && element.clip_path.trim.length > 0 && ! element.clip_path.trim.equals("none")»
			<clip>
				«val clipElement = resolveElement(element.clip_path.substring(5,element.clip_path.length-1)) as SvgClipPathElement»
				<Group>
					<children>
						«FOR e : clipElement.children»
							«handle(e)»
						«ENDFOR»
					</children>
					«IF clipElement.transform != null && clipElement.transform.trim.length > 0 && ! element.clip_path.equals("none")»
					<transforms>
						«handleTransform(clipElement.transform)»
					</transforms>
					«ENDIF»
				</Group>
			</clip>
		«ENDIF»
	</Group>
	'''

	def lookupFeature(EStructuralFeature feature, EObject object) {
		var eo = object;
		do {
			if( eo.eClass.EAllStructuralFeatures.contains(feature) ) {
				if( eo.eIsSet(feature) ) {
					return eo.eGet(feature);
				}
			}
			eo = eo.eContainer;
		} while( eo != null );

		return null;
	}

	def handleShapePresentationAttributes(PresentationAttributes element) '''
«««		«IF element.stroke_dasharray != null»«ENDIF»
		«IF lookupFeature(SvgPackage$Literals::PRESENTATION_ATTRIBUTES__STROKE_DASHOFFSET,element) != null»strokeDashOffset="«(lookupFeature(SvgPackage$Literals::PRESENTATION_ATTRIBUTES__STROKE_DASHOFFSET,element) as String).parseLength»"«ENDIF»
		«IF lookupFeature(SvgPackage$Literals::PRESENTATION_ATTRIBUTES__STROKE_LINECAP,element) != null»strokeLineCap="«(lookupFeature(SvgPackage$Literals::PRESENTATION_ATTRIBUTES__STROKE_LINECAP,element) as Stroke_linecap).toFx»"«ENDIF»
		«IF lookupFeature(SvgPackage$Literals::PRESENTATION_ATTRIBUTES__STROKE_LINEJOIN,element) != null»strokeLineJoin="«(lookupFeature(SvgPackage$Literals::PRESENTATION_ATTRIBUTES__STROKE_LINEJOIN,element) as Stroke_linejoin).toFx»"«ENDIF»
		«IF lookupFeature(SvgPackage$Literals::PRESENTATION_ATTRIBUTES__STROKE_MITERLIMIT,element) != null»strokeMiterLimit="«(lookupFeature(SvgPackage$Literals::PRESENTATION_ATTRIBUTES__STROKE_MITERLIMIT,element) as String).parseLength»"«ENDIF»
		«IF lookupFeature(SvgPackage$Literals::PRESENTATION_ATTRIBUTES__STROKE_WIDTH,element) != null»strokeWidth="«(lookupFeature(SvgPackage$Literals::PRESENTATION_ATTRIBUTES__STROKE_WIDTH,element) as String).parseLength»"«ENDIF»
	'''

	def handleStyleClassAttributes(String styleClass) '''
		«IF styleClass != null»
			<styleClass>
				«FOR c : styleClass.split(" ")»
					<String fx:value="«c.trim»"/>
				«ENDFOR»
			</styleClass>
		«ENDIF»
	'''

	def dispatch CharSequence handle(SvgPathElement element) '''
	<SVGPath
		«IF element.d != null»content="«element.d»"«ENDIF»
		«IF element.opacity != null»opacity="«element.opacity»"«ENDIF»
		«IF element.fill_rule != Fill_rule::NONZERO»fillRule="EVEN_ODD"«ENDIF»
		«handleShapePresentationAttributes(element)»
		«IF element.id != null»id="«element.id.validateId»"«ENDIF»
		>
		«handlePaint("fill", lookupFeature(SvgPackage$Literals::PRESENTATION_ATTRIBUTES__FILL,element) as String,lookupFeature(SvgPackage$Literals::PRESENTATION_ATTRIBUTES__FILL_OPACITY,element) as String)»
		«handlePaint("stroke",lookupFeature(SvgPackage$Literals::PRESENTATION_ATTRIBUTES__STROKE,element) as String,lookupFeature(SvgPackage$Literals::PRESENTATION_ATTRIBUTES__STROKE_OPACITY,element) as String)»
		«handleStyleClassAttributes(element.class_)»
		«IF element.transform != null»
			<transforms>
				«element.transform.handleTransform»
			</transforms>
		«ENDIF»
		«IF element.filter != null»
			«val e = resolveElement(element.filter.substring(5,element.filter.length-1).trim) as SvgFilterElement»
			«IF e != null»
				«IF e.children.filter(typeof(FilterPrimitiveElement)).size == 1»
				«val fiElement = e.children.filter(typeof(FilterPrimitiveElement)).head as SvgElement»
				<effect>
					«handleFilter(fiElement)»
				</effect>
				«ELSE»
				<!-- Multi filter needs different handling -->
				«ENDIF»
			«ENDIF»
		«ENDIF»
		«IF element.clip_path != null && element.clip_path.trim.length > 0 && ! element.clip_path.trim.equals("none")»
			<clip>
				«val clipElement = resolveElement(element.clip_path.substring(5,element.clip_path.length-1)) as SvgClipPathElement»
				<Group>
					<children>
						«FOR e : clipElement.children»
							«handle(e)»
						«ENDFOR»
					</children>
					«IF clipElement.transform != null && clipElement.transform.trim.length > 0 && ! element.clip_path.equals("none")»
					<transforms>
						«handleTransform(clipElement.transform)»
					</transforms>
					«ENDIF»
				</Group>
			</clip>
		«ENDIF»
	</SVGPath>
	'''

	def dispatch handleFilter(EObject o) '''
	<!-- Unsupported filter type -->
	'''

	def dispatch handleFilter(SvgFeGaussianBlurElement blur) '''
		<GaussianBlur
			«IF blur.stdDeviation != null»radius="«blur.stdDeviation.parseDouble * 2»"«ENDIF»
		/>
	'''

	def handlePaint(String type, String fillDefinition, String typeOpacity) '''
	«IF fillDefinition != null»
		<«type»>
			«IF fillDefinition.equals("none")»
				TRANSPARENT
			«ELSEIF typeOpacity != null && Double::parseDouble(typeOpacity) != Double::valueOf("1.0")»
				«fillDefinition.fillPaint(Double::parseDouble(typeOpacity))»
			«ELSE»
				«fillDefinition.fillPaint»
			«ENDIF»
		</«type»>
	«ENDIF»
	'''

	def dispatch CharSequence handle(SvgClipPathElement element) {
	}

	def dispatch CharSequence handle(SvgEllipseElement element) '''
	<Ellipse
		«IF element.rx != null»radiusX="«element.rx.parseLength»"«ENDIF»
		«IF element.ry != null»radiusY="«element.ry.parseLength»"«ENDIF»
		«IF element.cx != null»centerX="«element.cx.parseCoordinate»"«ENDIF»
		«IF element.cy != null»centerY="«element.cy.parseCoordinate»"«ENDIF»
		«IF element.opacity != null»opacity="«element.opacity»"«ENDIF»
		«IF element.id != null»id="«element.id.validateId»"«ENDIF»
		«handleShapePresentationAttributes(element)»
		>
		«handlePaint("fill", lookupFeature(SvgPackage$Literals::PRESENTATION_ATTRIBUTES__FILL,element) as String,lookupFeature(SvgPackage$Literals::PRESENTATION_ATTRIBUTES__FILL_OPACITY,element) as String)»
		«handlePaint("stroke",lookupFeature(SvgPackage$Literals::PRESENTATION_ATTRIBUTES__STROKE,element) as String,lookupFeature(SvgPackage$Literals::PRESENTATION_ATTRIBUTES__STROKE_OPACITY,element) as String)»
		«handleStyleClassAttributes(element.class_)»

		«IF element.transform != null»
			<transforms>
				«element.transform.handleTransform»
			</transforms>
		«ENDIF»
		«IF element.filter != null»
			«val e = resolveElement(element.filter.substring(5,element.filter.length-1).trim) as SvgFilterElement»
			«IF e != null»
				«IF e.children.filter(typeof(FilterPrimitiveElement)).size == 1»
				«val fiElement = e.children.filter(typeof(FilterPrimitiveElement)).head as SvgElement»
				<effect>
					«handleFilter(fiElement)»
				</effect>
				«ELSE»
				<!-- Multi filter needs different handling -->
				«ENDIF»
			«ENDIF»
		«ENDIF»
		«IF element.clip_path != null && element.clip_path.trim.length > 0 && ! element.clip_path.trim.equals("none")»
			<clip>
				«val clipElement = resolveElement(element.clip_path.substring(5,element.clip_path.length-1)) as SvgClipPathElement»
				<Group>
					<children>
						«FOR e : clipElement.children»
							«handle(e)»
						«ENDFOR»
					</children>
					«IF clipElement.transform != null && clipElement.transform.trim.length > 0 && ! element.clip_path.equals("none")»
					<transforms>
						«handleTransform(clipElement.transform)»
					</transforms>
					«ENDIF»
				</Group>
			</clip>
		«ENDIF»
	</Ellipse>
	'''

	def dispatch CharSequence handle(SvgCircleElement element) '''
	<Circle
		«IF element.r != null»radius="«element.r.parseLength»"«ENDIF»
		«IF element.cx != null»centerX="«element.cx.parseCoordinate»"«ENDIF»
		«IF element.cy != null»centerY="«element.cy.parseCoordinate»"«ENDIF»
		«IF element.opacity != null»opacity="«element.opacity»"«ENDIF»
		«IF element.id != null»id="«element.id.validateId»"«ENDIF»
		«handleShapePresentationAttributes(element)»
		>
		«handlePaint("fill", lookupFeature(SvgPackage$Literals::PRESENTATION_ATTRIBUTES__FILL,element) as String,lookupFeature(SvgPackage$Literals::PRESENTATION_ATTRIBUTES__FILL_OPACITY,element) as String)»
		«handlePaint("stroke",lookupFeature(SvgPackage$Literals::PRESENTATION_ATTRIBUTES__STROKE,element) as String,lookupFeature(SvgPackage$Literals::PRESENTATION_ATTRIBUTES__STROKE_OPACITY,element) as String)»
		«handleStyleClassAttributes(element.class_)»

		«IF element.transform != null»
			<transforms>
				«element.transform.handleTransform»
			</transforms>
		«ENDIF»
		«IF element.filter != null»
			«val e = resolveElement(element.filter.substring(5,element.filter.length-1).trim) as SvgFilterElement»
			«IF e != null»
				«IF e.children.filter(typeof(FilterPrimitiveElement)).size == 1»
				«val fiElement = e.children.filter(typeof(FilterPrimitiveElement)).head as SvgElement»
				<effect>
					«handleFilter(fiElement)»
				</effect>
				«ELSE»
				<!-- Multi filter needs different handling -->
				«ENDIF»
			«ENDIF»
		«ENDIF»
		«IF element.clip_path != null && element.clip_path.trim.length > 0 && ! element.clip_path.trim.equals("none")»
			<clip>
				«val clipElement = resolveElement(element.clip_path.substring(5,element.clip_path.length-1)) as SvgClipPathElement»
				<Group>
					<children>
						«FOR e : clipElement.children»
							«handle(e)»
						«ENDFOR»
					</children>
					«IF clipElement.transform != null && clipElement.transform.trim.length > 0 && ! element.clip_path.equals("none")»
					<transforms>
						«handleTransform(clipElement.transform)»
					</transforms>
					«ENDIF»
				</Group>
			</clip>
		«ENDIF»
	</Circle>
	'''

	def dispatch CharSequence handle(SvgPolylineElement element) '''
	<Polyline
		«IF element.points != null»points="«element.points.replaceAll("\\s+",",")»"«ENDIF»
		«IF element.opacity != null»opacity="«element.opacity»"«ENDIF»
		«handleShapePresentationAttributes(element)»
		«IF element.id != null»id="«element.id.validateId»"«ENDIF»
		>
	«handlePaint("fill", lookupFeature(SvgPackage$Literals::PRESENTATION_ATTRIBUTES__FILL,element) as String,lookupFeature(SvgPackage$Literals::PRESENTATION_ATTRIBUTES__FILL_OPACITY,element) as String)»
	«handlePaint("stroke",lookupFeature(SvgPackage$Literals::PRESENTATION_ATTRIBUTES__STROKE,element) as String,lookupFeature(SvgPackage$Literals::PRESENTATION_ATTRIBUTES__STROKE_OPACITY,element) as String)»
	«handleStyleClassAttributes(element.class_)»

	«IF element.transform != null»
		<transforms>
			«element.transform.handleTransform»
		</transforms>
	«ENDIF»
		«IF element.filter != null»
			«val e = resolveElement(element.filter.substring(5,element.filter.length-1).trim) as SvgFilterElement»
			«IF e != null»
				«IF e.children.filter(typeof(FilterPrimitiveElement)).size == 1»
				«val fiElement = e.children.filter(typeof(FilterPrimitiveElement)).head as SvgElement»
				<effect>
					«handleFilter(fiElement)»
				</effect>
				«ELSE»
				<!-- Multi filter needs different handling -->
				«ENDIF»
			«ENDIF»
		«ENDIF»
	«IF element.clip_path != null && element.clip_path.trim.length > 0 && ! element.clip_path.trim.equals("none")»
		<clip>
			«val clipElement = resolveElement(element.clip_path.substring(5,element.clip_path.length-1)) as SvgClipPathElement»
			<Group>
				<children>
					«FOR e : clipElement.children»
						«handle(e)»
					«ENDFOR»
				</children>
				«IF clipElement.transform != null && clipElement.transform.trim.length > 0 && ! element.clip_path.equals("none")»
				<transforms>
					«handleTransform(clipElement.transform)»
				</transforms>
				«ENDIF»
			</Group>
		</clip>
	«ENDIF»
	</Polyline>
	'''

	def dispatch CharSequence handle(SvgPolygonElement element) '''
	<Polygon
		«IF element.points != null»points="«element.points.replaceAll("\\s+",",")»"«ENDIF»
		«IF element.opacity != null»opacity="«element.opacity»"«ENDIF»
		«handleShapePresentationAttributes(element)»
		«IF element.id != null»id="«element.id.validateId»"«ENDIF»
	>
	«handlePaint("fill", lookupFeature(SvgPackage$Literals::PRESENTATION_ATTRIBUTES__FILL,element) as String,lookupFeature(SvgPackage$Literals::PRESENTATION_ATTRIBUTES__FILL_OPACITY,element) as String)»
	«handlePaint("stroke",lookupFeature(SvgPackage$Literals::PRESENTATION_ATTRIBUTES__STROKE,element) as String,lookupFeature(SvgPackage$Literals::PRESENTATION_ATTRIBUTES__STROKE_OPACITY,element) as String)»
	«handleStyleClassAttributes(element.class_)»

	«IF element.transform != null»
		<transforms>
			«element.transform.handleTransform»
		</transforms>
	«ENDIF»
		«IF element.filter != null»
			«val e = resolveElement(element.filter.substring(5,element.filter.length-1).trim) as SvgFilterElement»
			«IF e != null»
				«IF e.children.filter(typeof(FilterPrimitiveElement)).size == 1»
				«val fiElement = e.children.filter(typeof(FilterPrimitiveElement)).head as SvgElement»
				<effect>
					«handleFilter(fiElement)»
				</effect>
				«ELSE»
				<!-- Multi filter needs different handling -->
				«ENDIF»
			«ENDIF»
		«ENDIF»
	«IF element.clip_path != null && element.clip_path.trim.length > 0 && ! element.clip_path.trim.equals("none")»
		<clip>
			«val clipElement = resolveElement(element.clip_path.substring(5,element.clip_path.length-1)) as SvgClipPathElement»
			<Group>
				<children>
					«FOR e : clipElement.children»
						«handle(e)»
					«ENDFOR»
				</children>
				«IF clipElement.transform != null && clipElement.transform.trim.length > 0 && ! element.clip_path.equals("none")»
				<transforms>
					«handleTransform(clipElement.transform)»
				</transforms>
				«ENDIF»
			</Group>
		</clip>
	«ENDIF»
	</Polygon>
	'''

	def fillPaint(String fill) {
		if( fill.startsWith("#") ) {
			return fill.hexColor
		} else if( fill.startsWith("rgb") ) {
			val c = fill.substring(fill.indexOf("(")+1,fill.indexOf(")"));
			return c.rgbColor();
		} else if( fill.startsWith("argb") ) {

		} else if( fill.startsWith("url") ) {
			val e = resolveElement(fill.substring(5,fill.length-1));
			if( e instanceof SvgLinearGradientElement ) {
				return handleGradient(e as SvgLinearGradientElement,null);
			} else if( e instanceof SvgRadialGradientElement ) {
				return handleGradient(e as SvgRadialGradientElement,null);
			}
		} else {
			return fill.toUpperCase
		}
	}

	def fillPaint(String fill, Double opacity) {
		if( fill.startsWith("#") ) {
			return fill.hexColor(opacity)
		} else if( fill.toLowerCase.startsWith("rgb") ) {
			val c = fill.substring(fill.indexOf("(")+1,fill.indexOf(")"));
			return c.rgbColor();
		} else if( fill.startsWith("argb") ) {

		} else if( fill.startsWith("url") ) {
			val e = resolveElement(fill.substring(5,fill.length-1));
			if( e instanceof SvgLinearGradientElement ) {
				return handleGradient(e as SvgLinearGradientElement,opacity);
			} else if( e instanceof SvgRadialGradientElement ) {
				return handleGradient(e as SvgRadialGradientElement,opacity);
			}
		} else {
			val c = Colors::findColorByName(fill);
			if (c != null) {
				return c.hexvalue.hexColor(opacity);
			}
			return fill.toUpperCase
		}
	}

	def rgbColor(String fill) '''
	<Color>
		<red>«fill.rgbRed»</red>
		<green>«fill.rgbGreen»</green>
		<blue>«fill.rgbBlue»</blue>
	</Color>
	'''

	def rgbColor(String fill, Double opacity) '''
	<Color>
		<red>«fill.rgbRed»</red>
		<green>«fill.rgbGreen»</green>
		<blue>«fill.rgbBlue»</blue>
		<opacity>«opacity»</opacity>
	</Color>
	'''

	def rgbRed(String color) {
		return Integer::parseInt(color.split(",").get(0))/Double::parseDouble("255");
	}

	def rgbGreen(String color) {
		return Integer::parseInt(color.split(",").get(1))/Double::parseDouble("255");
	}

	def rgbBlue(String color) {
		return Integer::parseInt(color.split(",").get(2))/Double::parseDouble("255");
	}

	def hexColor(String fill) '''
	<Color>
		<red>«fill.hexRed»</red>
		<green>«fill.hexGreen»</green>
		<blue>«fill.hexBlue»</blue>
	</Color>
	'''

	def hexColor(String fill, Double opacity) '''
	<Color>
		<red>«fill.hexRed»</red>
		<green>«fill.hexGreen»</green>
		<blue>«fill.hexBlue»</blue>
		<opacity>«opacity»</opacity>
	</Color>
	'''

	def hexRed(String color) {
		return Colors::hexRed(color);
	}

	def hexGreen(String color) {
		return Colors::hexGreen(color);
	}

	def hexBlue(String color) {
		return Colors::hexBlue(color);
	}

	def transformElement(String transform) '''
	«val params = transform.substring(transform.indexOf("(")+1,transform.indexOf(")"))»
	«IF transform.startsWith("translate")»
	<Translate
		«IF params.indexOf(",") != -1»
			«val parts = params.split(",")»
			x="«parts.get(0)»"
			y="«parts.get(1)»"
		«ELSE»
			x="«params»"
			y="«params»"
		«ENDIF»
		>
	</Translate>
	«ELSEIF transform.startsWith("scale")»
	<Scale
		«IF params.indexOf(",") != -1»
			«val parts = params.split(",")»
			x="«parts.get(0)»"
			y="«parts.get(1)»"
		«ELSE»
			x="«params»"
			y="«params»"
		«ENDIF»
	>
	</Scale>
	«ELSEIF transform.startsWith("rotate")»
	<Rotate
		«IF params.indexOf(",") != -1»
			«val parts = params.split(",")»
			«IF parts.size == 2»
				angle="«parts.get(0)»"
				pivotX="«parts.get(1)»"
				pivotY="«parts.get(1)»"
			«ELSEIF parts.size == 3»
				angle="«parts.get(0)»"
				pivotX="«parts.get(1)»"
				pivotY="«parts.get(2)»"
			«ENDIF»
		«ELSE»
			angle="«params»"
		«ENDIF»
	>
	</Rotate>
	«ELSEIF transform.startsWith("matrix")»
	«val parts = params.split("[,\\s+]")»
	<Affine
		mxx="«parts.get(0)»"
		myx="«parts.get(1)»"
		mxy="«parts.get(2)»"
		myy="«parts.get(3)»"
		tx="«parts.get(4)»"
		ty="«parts.get(5)»"
		>
	</Affine>
	«ENDIF»
	'''

	def handleTransform(String t) {
		var transform = t;
		var int endIdx;
		val builder = new StringBuilder
		while( (endIdx = transform.indexOf(')')) != -1 ) {
			builder.append(transformElement(transform.substring(0,endIdx+1)))

			if( endIdx+1 > transform.length ) {
				return builder.toString;
			}

			transform = transform.substring(endIdx+1).trim
		}
		return builder.toString;
	}

	def dispatch CharSequence handle(SvgFilterElement filter) {

	}

	def dispatch CharSequence handle(SvgFeGaussianBlurElement f) {

	}

	def String toFx(SpreadMethod m) {
		switch(m) {
			case SpreadMethod::PAD:
				return "NO_CYCLE"
			case SpreadMethod::REFLECT:
				return "REFLECT"
			case SpreadMethod::REPEAT:
				return "REPEAT"
		}

		return "NO_CYCLE";
	}

	def String toFx(Stroke_linecap m) {
		switch(m) {
			case Stroke_linecap::BUTT:
				return "BUTT"
			case Stroke_linecap::ROUND:
				return "ROUND"
			case Stroke_linecap::SQUARE:
				return "SQUARE"
			case Stroke_linecap::INHERIT:
				return "INHERIT"
		}
		return "BUTT";
	}

	def String toFx(Stroke_linejoin m) {
		switch(m) {
			case Stroke_linejoin::BEVEL:
				return "BEVEL"
			case Stroke_linejoin::MITER:
				return "MITER"
			case Stroke_linejoin::ROUND:
				return "ROUND"
			case Stroke_linejoin::INHERIT:
				return "INHERIT"
		}
		return "BEVEL";
	}

	def parseLength(String length) {
		if( length != null ) {
			if( length.endsWith("px") ) {
				return Double::parseDouble(length.substring(0,length.length - 2));
			} else {
				return Double::parseDouble(length);
			}
		}
		return 0.0;
	}

	def parseCoordinate(String coordinate) {
		if( coordinate != null ) {
			return Double::parseDouble(coordinate);
		}
		return 0.0;
	}

	def parsePercentage(String percentage) {
		if( percentage != null ) {
			return Double::parseDouble(percentage);
		}
		return 0.0;
	}

	def parseDouble(String value) {
		if( value != null ) {
			return Double::parseDouble(value)
		}
		return 0.0;
	}

	def validateId(String value) {
		// TODO replace http://www.w3.org/TR/2008/REC-xml-20081126/#NT-Name vs http://www.w3.org/TR/CSS21/syndata.html#value-def-identifier
		return value.replaceAll("\\.","_dot").replaceAll(" ","_space").replaceAll(":","_colon");
	}
}