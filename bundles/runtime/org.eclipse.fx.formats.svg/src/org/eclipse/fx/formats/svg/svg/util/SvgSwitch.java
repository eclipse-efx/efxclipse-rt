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
package org.eclipse.fx.formats.svg.svg.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.eclipse.fx.formats.svg.svg.AnimationElement;
import org.eclipse.fx.formats.svg.svg.BasicShapeElement;
import org.eclipse.fx.formats.svg.svg.ConditionalProcessingAttributes;
import org.eclipse.fx.formats.svg.svg.ContainerElement;
import org.eclipse.fx.formats.svg.svg.ContentElement;
import org.eclipse.fx.formats.svg.svg.CoreAttributes;
import org.eclipse.fx.formats.svg.svg.DescriptiveElement;
import org.eclipse.fx.formats.svg.svg.DocumentEventAttributes;
import org.eclipse.fx.formats.svg.svg.FilterPrimitiveAttributes;
import org.eclipse.fx.formats.svg.svg.FilterPrimitiveElement;
import org.eclipse.fx.formats.svg.svg.GradientElement;
import org.eclipse.fx.formats.svg.svg.GraphicalEventAttributes;
import org.eclipse.fx.formats.svg.svg.GraphicsElement;
import org.eclipse.fx.formats.svg.svg.GraphicsReferencingElement;
import org.eclipse.fx.formats.svg.svg.LightSourceElement;
import org.eclipse.fx.formats.svg.svg.PresentationAttributes;
import org.eclipse.fx.formats.svg.svg.ShapeElement;
import org.eclipse.fx.formats.svg.svg.StructuralElement;
import org.eclipse.fx.formats.svg.svg.SvgAltGlyphDefElement;
import org.eclipse.fx.formats.svg.svg.SvgAltGlyphElement;
import org.eclipse.fx.formats.svg.svg.SvgAltGlyphItemElement;
import org.eclipse.fx.formats.svg.svg.SvgAltGlyphRefElement;
import org.eclipse.fx.formats.svg.svg.SvgAnimateElement;
import org.eclipse.fx.formats.svg.svg.SvgCircleElement;
import org.eclipse.fx.formats.svg.svg.SvgClipPathElement;
import org.eclipse.fx.formats.svg.svg.SvgColorProfileElement;
import org.eclipse.fx.formats.svg.svg.SvgDefsElement;
import org.eclipse.fx.formats.svg.svg.SvgDescElement;
import org.eclipse.fx.formats.svg.svg.SvgElement;
import org.eclipse.fx.formats.svg.svg.SvgEllipseElement;
import org.eclipse.fx.formats.svg.svg.SvgFeBlendElement;
import org.eclipse.fx.formats.svg.svg.SvgFeColorMatrixElement;
import org.eclipse.fx.formats.svg.svg.SvgFeComponentTransferElement;
import org.eclipse.fx.formats.svg.svg.SvgFeCompositeElement;
import org.eclipse.fx.formats.svg.svg.SvgFeConvolveMatrixElement;
import org.eclipse.fx.formats.svg.svg.SvgFeDiffuseLightingElement;
import org.eclipse.fx.formats.svg.svg.SvgFeDisplacementMapElement;
import org.eclipse.fx.formats.svg.svg.SvgFeDistantLightElement;
import org.eclipse.fx.formats.svg.svg.SvgFeFloodElement;
import org.eclipse.fx.formats.svg.svg.SvgFeFuncAElement;
import org.eclipse.fx.formats.svg.svg.SvgFeFuncBElement;
import org.eclipse.fx.formats.svg.svg.SvgFeFuncGElement;
import org.eclipse.fx.formats.svg.svg.SvgFeFuncRElement;
import org.eclipse.fx.formats.svg.svg.SvgFeGaussianBlurElement;
import org.eclipse.fx.formats.svg.svg.SvgFeImageElement;
import org.eclipse.fx.formats.svg.svg.SvgFeMergeElement;
import org.eclipse.fx.formats.svg.svg.SvgFeMergeNodeElement;
import org.eclipse.fx.formats.svg.svg.SvgFeMorphologyElement;
import org.eclipse.fx.formats.svg.svg.SvgFeOffsetElement;
import org.eclipse.fx.formats.svg.svg.SvgFePointLightElement;
import org.eclipse.fx.formats.svg.svg.SvgFeSpecularLightingElement;
import org.eclipse.fx.formats.svg.svg.SvgFeSpotLightElement;
import org.eclipse.fx.formats.svg.svg.SvgFeTileElement;
import org.eclipse.fx.formats.svg.svg.SvgFeTurbulenceElement;
import org.eclipse.fx.formats.svg.svg.SvgFilterElement;
import org.eclipse.fx.formats.svg.svg.SvgGElement;
import org.eclipse.fx.formats.svg.svg.SvgImageElement;
import org.eclipse.fx.formats.svg.svg.SvgLineElement;
import org.eclipse.fx.formats.svg.svg.SvgLinearGradientElement;
import org.eclipse.fx.formats.svg.svg.SvgMarkerElement;
import org.eclipse.fx.formats.svg.svg.SvgMaskElement;
import org.eclipse.fx.formats.svg.svg.SvgMetadataElement;
import org.eclipse.fx.formats.svg.svg.SvgPackage;
import org.eclipse.fx.formats.svg.svg.SvgPathElement;
import org.eclipse.fx.formats.svg.svg.SvgPatternElement;
import org.eclipse.fx.formats.svg.svg.SvgPolygonElement;
import org.eclipse.fx.formats.svg.svg.SvgPolylineElement;
import org.eclipse.fx.formats.svg.svg.SvgRadialGradientElement;
import org.eclipse.fx.formats.svg.svg.SvgRectElement;
import org.eclipse.fx.formats.svg.svg.SvgStopElement;
import org.eclipse.fx.formats.svg.svg.SvgSvgElement;
import org.eclipse.fx.formats.svg.svg.SvgSwitchElement;
import org.eclipse.fx.formats.svg.svg.SvgSymbolElement;
import org.eclipse.fx.formats.svg.svg.SvgTextElement;
import org.eclipse.fx.formats.svg.svg.SvgTextPathElement;
import org.eclipse.fx.formats.svg.svg.SvgTitleElement;
import org.eclipse.fx.formats.svg.svg.SvgTrefElement;
import org.eclipse.fx.formats.svg.svg.SvgTspanElement;
import org.eclipse.fx.formats.svg.svg.SvgUseElement;
import org.eclipse.fx.formats.svg.svg.TextContentChildElement;
import org.eclipse.fx.formats.svg.svg.TextContentElement;
import org.eclipse.fx.formats.svg.svg.XLinkAttributes;
import org.eclipse.fx.formats.svg.svg.____ATTRIBUTES____;
import org.eclipse.fx.formats.svg.svg.____DATATYPES____;
import org.eclipse.fx.formats.svg.svg.____ELEMENTES____;
import org.eclipse.fx.formats.svg.svg.____ENUMS____;
import org.eclipse.jdt.annotation.Nullable;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.fx.formats.svg.svg.SvgPackage
 * @generated
 */
public class SvgSwitch<@Nullable T1> extends Switch<T1> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static SvgPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SvgSwitch() {
		if (modelPackage == null) {
			modelPackage = SvgPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T1 doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case SvgPackage.CONTENT_ELEMENT: {
				ContentElement<?> contentElement = (ContentElement<?>)theEObject;
				T1 result = caseContentElement(contentElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SvgPackage.CONTAINER_ELEMENT: {
				ContainerElement<?> containerElement = (ContainerElement<?>)theEObject;
				T1 result = caseContainerElement(containerElement);
				if (result == null) result = caseContentElement(containerElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SvgPackage.STRUCTURAL_ELEMENT: {
				StructuralElement structuralElement = (StructuralElement)theEObject;
				T1 result = caseStructuralElement(structuralElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SvgPackage.SVG_ELEMENT: {
				SvgElement svgElement = (SvgElement)theEObject;
				T1 result = caseSvgElement(svgElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SvgPackage.DESCRIPTIVE_ELEMENT: {
				DescriptiveElement descriptiveElement = (DescriptiveElement)theEObject;
				T1 result = caseDescriptiveElement(descriptiveElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SvgPackage.GRAPHICS_ELEMENT: {
				GraphicsElement graphicsElement = (GraphicsElement)theEObject;
				T1 result = caseGraphicsElement(graphicsElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SvgPackage.GRAPHICS_REFERENCING_ELEMENT: {
				GraphicsReferencingElement graphicsReferencingElement = (GraphicsReferencingElement)theEObject;
				T1 result = caseGraphicsReferencingElement(graphicsReferencingElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SvgPackage.SHAPE_ELEMENT: {
				ShapeElement shapeElement = (ShapeElement)theEObject;
				T1 result = caseShapeElement(shapeElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SvgPackage.BASIC_SHAPE_ELEMENT: {
				BasicShapeElement basicShapeElement = (BasicShapeElement)theEObject;
				T1 result = caseBasicShapeElement(basicShapeElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SvgPackage.TEXT_CONTENT_ELEMENT: {
				TextContentElement textContentElement = (TextContentElement)theEObject;
				T1 result = caseTextContentElement(textContentElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SvgPackage.TEXT_CONTENT_CHILD_ELEMENT: {
				TextContentChildElement textContentChildElement = (TextContentChildElement)theEObject;
				T1 result = caseTextContentChildElement(textContentChildElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SvgPackage.GRADIENT_ELEMENT: {
				GradientElement gradientElement = (GradientElement)theEObject;
				T1 result = caseGradientElement(gradientElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SvgPackage.LIGHT_SOURCE_ELEMENT: {
				LightSourceElement lightSourceElement = (LightSourceElement)theEObject;
				T1 result = caseLightSourceElement(lightSourceElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SvgPackage.FILTER_PRIMITIVE_ELEMENT: {
				FilterPrimitiveElement filterPrimitiveElement = (FilterPrimitiveElement)theEObject;
				T1 result = caseFilterPrimitiveElement(filterPrimitiveElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SvgPackage.ANIMATION_ELEMENT: {
				AnimationElement animationElement = (AnimationElement)theEObject;
				T1 result = caseAnimationElement(animationElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SvgPackage._ENUMS_: {
				____ENUMS____ ____ENUMS____ = (____ENUMS____)theEObject;
				T1 result = case____ENUMS____(____ENUMS____);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SvgPackage._DATATYPES_: {
				____DATATYPES____ ____DATATYPES____ = (____DATATYPES____)theEObject;
				T1 result = case____DATATYPES____(____DATATYPES____);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SvgPackage._ATTRIBUTES_: {
				____ATTRIBUTES____ ____ATTRIBUTES____ = (____ATTRIBUTES____)theEObject;
				T1 result = case____ATTRIBUTES____(____ATTRIBUTES____);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SvgPackage.CONDITIONAL_PROCESSING_ATTRIBUTES: {
				ConditionalProcessingAttributes conditionalProcessingAttributes = (ConditionalProcessingAttributes)theEObject;
				T1 result = caseConditionalProcessingAttributes(conditionalProcessingAttributes);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SvgPackage.CORE_ATTRIBUTES: {
				CoreAttributes coreAttributes = (CoreAttributes)theEObject;
				T1 result = caseCoreAttributes(coreAttributes);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SvgPackage.DOCUMENT_EVENT_ATTRIBUTES: {
				DocumentEventAttributes documentEventAttributes = (DocumentEventAttributes)theEObject;
				T1 result = caseDocumentEventAttributes(documentEventAttributes);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SvgPackage.GRAPHICAL_EVENT_ATTRIBUTES: {
				GraphicalEventAttributes graphicalEventAttributes = (GraphicalEventAttributes)theEObject;
				T1 result = caseGraphicalEventAttributes(graphicalEventAttributes);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SvgPackage.PRESENTATION_ATTRIBUTES: {
				PresentationAttributes presentationAttributes = (PresentationAttributes)theEObject;
				T1 result = casePresentationAttributes(presentationAttributes);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SvgPackage.XLINK_ATTRIBUTES: {
				XLinkAttributes xLinkAttributes = (XLinkAttributes)theEObject;
				T1 result = caseXLinkAttributes(xLinkAttributes);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SvgPackage.FILTER_PRIMITIVE_ATTRIBUTES: {
				FilterPrimitiveAttributes filterPrimitiveAttributes = (FilterPrimitiveAttributes)theEObject;
				T1 result = caseFilterPrimitiveAttributes(filterPrimitiveAttributes);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SvgPackage._ELEMENTES_: {
				____ELEMENTES____ ____ELEMENTES____ = (____ELEMENTES____)theEObject;
				T1 result = case____ELEMENTES____(____ELEMENTES____);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SvgPackage.SVG_SVG_ELEMENT: {
				SvgSvgElement svgSvgElement = (SvgSvgElement)theEObject;
				T1 result = caseSvgSvgElement(svgSvgElement);
				if (result == null) result = caseSvgElement(svgSvgElement);
				if (result == null) result = caseContainerElement(svgSvgElement);
				if (result == null) result = caseStructuralElement(svgSvgElement);
				if (result == null) result = caseConditionalProcessingAttributes(svgSvgElement);
				if (result == null) result = caseCoreAttributes(svgSvgElement);
				if (result == null) result = caseDocumentEventAttributes(svgSvgElement);
				if (result == null) result = caseGraphicalEventAttributes(svgSvgElement);
				if (result == null) result = casePresentationAttributes(svgSvgElement);
				if (result == null) result = caseContentElement(svgSvgElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SvgPackage.SVG_GELEMENT: {
				SvgGElement svgGElement = (SvgGElement)theEObject;
				T1 result = caseSvgGElement(svgGElement);
				if (result == null) result = caseSvgElement(svgGElement);
				if (result == null) result = caseContainerElement(svgGElement);
				if (result == null) result = caseStructuralElement(svgGElement);
				if (result == null) result = caseConditionalProcessingAttributes(svgGElement);
				if (result == null) result = caseCoreAttributes(svgGElement);
				if (result == null) result = caseGraphicalEventAttributes(svgGElement);
				if (result == null) result = casePresentationAttributes(svgGElement);
				if (result == null) result = caseContentElement(svgGElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SvgPackage.SVG_DEFS_ELEMENT: {
				SvgDefsElement svgDefsElement = (SvgDefsElement)theEObject;
				T1 result = caseSvgDefsElement(svgDefsElement);
				if (result == null) result = caseSvgElement(svgDefsElement);
				if (result == null) result = caseContainerElement(svgDefsElement);
				if (result == null) result = caseStructuralElement(svgDefsElement);
				if (result == null) result = caseConditionalProcessingAttributes(svgDefsElement);
				if (result == null) result = caseCoreAttributes(svgDefsElement);
				if (result == null) result = caseGraphicalEventAttributes(svgDefsElement);
				if (result == null) result = casePresentationAttributes(svgDefsElement);
				if (result == null) result = caseContentElement(svgDefsElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SvgPackage.SVG_DESC_ELEMENT: {
				SvgDescElement svgDescElement = (SvgDescElement)theEObject;
				T1 result = caseSvgDescElement(svgDescElement);
				if (result == null) result = caseSvgElement(svgDescElement);
				if (result == null) result = caseDescriptiveElement(svgDescElement);
				if (result == null) result = caseCoreAttributes(svgDescElement);
				if (result == null) result = caseContentElement(svgDescElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SvgPackage.SVG_TITLE_ELEMENT: {
				SvgTitleElement svgTitleElement = (SvgTitleElement)theEObject;
				T1 result = caseSvgTitleElement(svgTitleElement);
				if (result == null) result = caseSvgElement(svgTitleElement);
				if (result == null) result = caseDescriptiveElement(svgTitleElement);
				if (result == null) result = caseCoreAttributes(svgTitleElement);
				if (result == null) result = caseContentElement(svgTitleElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SvgPackage.SVG_SYMBOL_ELEMENT: {
				SvgSymbolElement svgSymbolElement = (SvgSymbolElement)theEObject;
				T1 result = caseSvgSymbolElement(svgSymbolElement);
				if (result == null) result = caseSvgElement(svgSymbolElement);
				if (result == null) result = caseContainerElement(svgSymbolElement);
				if (result == null) result = caseStructuralElement(svgSymbolElement);
				if (result == null) result = caseCoreAttributes(svgSymbolElement);
				if (result == null) result = caseGraphicalEventAttributes(svgSymbolElement);
				if (result == null) result = casePresentationAttributes(svgSymbolElement);
				if (result == null) result = caseContentElement(svgSymbolElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SvgPackage.SVG_USE_ELEMENT: {
				SvgUseElement svgUseElement = (SvgUseElement)theEObject;
				T1 result = caseSvgUseElement(svgUseElement);
				if (result == null) result = caseSvgElement(svgUseElement);
				if (result == null) result = caseGraphicsElement(svgUseElement);
				if (result == null) result = caseGraphicsReferencingElement(svgUseElement);
				if (result == null) result = caseStructuralElement(svgUseElement);
				if (result == null) result = caseConditionalProcessingAttributes(svgUseElement);
				if (result == null) result = caseCoreAttributes(svgUseElement);
				if (result == null) result = caseGraphicalEventAttributes(svgUseElement);
				if (result == null) result = casePresentationAttributes(svgUseElement);
				if (result == null) result = caseXLinkAttributes(svgUseElement);
				if (result == null) result = caseContentElement(svgUseElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SvgPackage.SVG_IMAGE_ELEMENT: {
				SvgImageElement svgImageElement = (SvgImageElement)theEObject;
				T1 result = caseSvgImageElement(svgImageElement);
				if (result == null) result = caseSvgElement(svgImageElement);
				if (result == null) result = caseGraphicsElement(svgImageElement);
				if (result == null) result = caseGraphicsReferencingElement(svgImageElement);
				if (result == null) result = caseConditionalProcessingAttributes(svgImageElement);
				if (result == null) result = caseCoreAttributes(svgImageElement);
				if (result == null) result = caseGraphicalEventAttributes(svgImageElement);
				if (result == null) result = casePresentationAttributes(svgImageElement);
				if (result == null) result = caseXLinkAttributes(svgImageElement);
				if (result == null) result = caseContentElement(svgImageElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SvgPackage.SVG_SWITCH_ELEMENT: {
				SvgSwitchElement svgSwitchElement = (SvgSwitchElement)theEObject;
				T1 result = caseSvgSwitchElement(svgSwitchElement);
				if (result == null) result = caseSvgElement(svgSwitchElement);
				if (result == null) result = caseContainerElement(svgSwitchElement);
				if (result == null) result = caseConditionalProcessingAttributes(svgSwitchElement);
				if (result == null) result = caseCoreAttributes(svgSwitchElement);
				if (result == null) result = caseGraphicalEventAttributes(svgSwitchElement);
				if (result == null) result = casePresentationAttributes(svgSwitchElement);
				if (result == null) result = caseContentElement(svgSwitchElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SvgPackage.SVG_PATH_ELEMENT: {
				SvgPathElement svgPathElement = (SvgPathElement)theEObject;
				T1 result = caseSvgPathElement(svgPathElement);
				if (result == null) result = caseSvgElement(svgPathElement);
				if (result == null) result = caseGraphicsElement(svgPathElement);
				if (result == null) result = caseShapeElement(svgPathElement);
				if (result == null) result = caseConditionalProcessingAttributes(svgPathElement);
				if (result == null) result = caseCoreAttributes(svgPathElement);
				if (result == null) result = caseGraphicalEventAttributes(svgPathElement);
				if (result == null) result = casePresentationAttributes(svgPathElement);
				if (result == null) result = caseContentElement(svgPathElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SvgPackage.SVG_RECT_ELEMENT: {
				SvgRectElement svgRectElement = (SvgRectElement)theEObject;
				T1 result = caseSvgRectElement(svgRectElement);
				if (result == null) result = caseSvgElement(svgRectElement);
				if (result == null) result = caseBasicShapeElement(svgRectElement);
				if (result == null) result = caseGraphicsElement(svgRectElement);
				if (result == null) result = caseShapeElement(svgRectElement);
				if (result == null) result = caseConditionalProcessingAttributes(svgRectElement);
				if (result == null) result = caseCoreAttributes(svgRectElement);
				if (result == null) result = caseGraphicalEventAttributes(svgRectElement);
				if (result == null) result = casePresentationAttributes(svgRectElement);
				if (result == null) result = caseContentElement(svgRectElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SvgPackage.SVG_CIRCLE_ELEMENT: {
				SvgCircleElement svgCircleElement = (SvgCircleElement)theEObject;
				T1 result = caseSvgCircleElement(svgCircleElement);
				if (result == null) result = caseSvgElement(svgCircleElement);
				if (result == null) result = caseBasicShapeElement(svgCircleElement);
				if (result == null) result = caseGraphicsElement(svgCircleElement);
				if (result == null) result = caseShapeElement(svgCircleElement);
				if (result == null) result = caseConditionalProcessingAttributes(svgCircleElement);
				if (result == null) result = caseCoreAttributes(svgCircleElement);
				if (result == null) result = caseGraphicalEventAttributes(svgCircleElement);
				if (result == null) result = casePresentationAttributes(svgCircleElement);
				if (result == null) result = caseContentElement(svgCircleElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SvgPackage.SVG_ELLIPSE_ELEMENT: {
				SvgEllipseElement svgEllipseElement = (SvgEllipseElement)theEObject;
				T1 result = caseSvgEllipseElement(svgEllipseElement);
				if (result == null) result = caseSvgElement(svgEllipseElement);
				if (result == null) result = caseBasicShapeElement(svgEllipseElement);
				if (result == null) result = caseGraphicsElement(svgEllipseElement);
				if (result == null) result = caseShapeElement(svgEllipseElement);
				if (result == null) result = caseConditionalProcessingAttributes(svgEllipseElement);
				if (result == null) result = caseCoreAttributes(svgEllipseElement);
				if (result == null) result = caseGraphicalEventAttributes(svgEllipseElement);
				if (result == null) result = casePresentationAttributes(svgEllipseElement);
				if (result == null) result = caseContentElement(svgEllipseElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SvgPackage.SVG_LINE_ELEMENT: {
				SvgLineElement svgLineElement = (SvgLineElement)theEObject;
				T1 result = caseSvgLineElement(svgLineElement);
				if (result == null) result = caseSvgElement(svgLineElement);
				if (result == null) result = caseBasicShapeElement(svgLineElement);
				if (result == null) result = caseGraphicsElement(svgLineElement);
				if (result == null) result = caseShapeElement(svgLineElement);
				if (result == null) result = caseConditionalProcessingAttributes(svgLineElement);
				if (result == null) result = caseCoreAttributes(svgLineElement);
				if (result == null) result = caseGraphicalEventAttributes(svgLineElement);
				if (result == null) result = casePresentationAttributes(svgLineElement);
				if (result == null) result = caseContentElement(svgLineElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SvgPackage.SVG_POLYLINE_ELEMENT: {
				SvgPolylineElement svgPolylineElement = (SvgPolylineElement)theEObject;
				T1 result = caseSvgPolylineElement(svgPolylineElement);
				if (result == null) result = caseSvgElement(svgPolylineElement);
				if (result == null) result = caseBasicShapeElement(svgPolylineElement);
				if (result == null) result = caseGraphicsElement(svgPolylineElement);
				if (result == null) result = caseShapeElement(svgPolylineElement);
				if (result == null) result = caseConditionalProcessingAttributes(svgPolylineElement);
				if (result == null) result = caseCoreAttributes(svgPolylineElement);
				if (result == null) result = caseGraphicalEventAttributes(svgPolylineElement);
				if (result == null) result = casePresentationAttributes(svgPolylineElement);
				if (result == null) result = caseContentElement(svgPolylineElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SvgPackage.SVG_POLYGON_ELEMENT: {
				SvgPolygonElement svgPolygonElement = (SvgPolygonElement)theEObject;
				T1 result = caseSvgPolygonElement(svgPolygonElement);
				if (result == null) result = caseSvgElement(svgPolygonElement);
				if (result == null) result = caseBasicShapeElement(svgPolygonElement);
				if (result == null) result = caseGraphicsElement(svgPolygonElement);
				if (result == null) result = caseShapeElement(svgPolygonElement);
				if (result == null) result = caseConditionalProcessingAttributes(svgPolygonElement);
				if (result == null) result = caseCoreAttributes(svgPolygonElement);
				if (result == null) result = caseGraphicalEventAttributes(svgPolygonElement);
				if (result == null) result = casePresentationAttributes(svgPolygonElement);
				if (result == null) result = caseContentElement(svgPolygonElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SvgPackage.SVG_TEXT_ELEMENT: {
				SvgTextElement svgTextElement = (SvgTextElement)theEObject;
				T1 result = caseSvgTextElement(svgTextElement);
				if (result == null) result = caseSvgElement(svgTextElement);
				if (result == null) result = caseGraphicsElement(svgTextElement);
				if (result == null) result = caseTextContentElement(svgTextElement);
				if (result == null) result = caseConditionalProcessingAttributes(svgTextElement);
				if (result == null) result = caseCoreAttributes(svgTextElement);
				if (result == null) result = caseGraphicalEventAttributes(svgTextElement);
				if (result == null) result = casePresentationAttributes(svgTextElement);
				if (result == null) result = caseContentElement(svgTextElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SvgPackage.SVG_TSPAN_ELEMENT: {
				SvgTspanElement svgTspanElement = (SvgTspanElement)theEObject;
				T1 result = caseSvgTspanElement(svgTspanElement);
				if (result == null) result = caseSvgElement(svgTspanElement);
				if (result == null) result = caseTextContentElement(svgTspanElement);
				if (result == null) result = caseTextContentChildElement(svgTspanElement);
				if (result == null) result = caseConditionalProcessingAttributes(svgTspanElement);
				if (result == null) result = caseCoreAttributes(svgTspanElement);
				if (result == null) result = caseGraphicalEventAttributes(svgTspanElement);
				if (result == null) result = casePresentationAttributes(svgTspanElement);
				if (result == null) result = caseContentElement(svgTspanElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SvgPackage.SVG_TREF_ELEMENT: {
				SvgTrefElement svgTrefElement = (SvgTrefElement)theEObject;
				T1 result = caseSvgTrefElement(svgTrefElement);
				if (result == null) result = caseSvgElement(svgTrefElement);
				if (result == null) result = caseTextContentElement(svgTrefElement);
				if (result == null) result = caseTextContentChildElement(svgTrefElement);
				if (result == null) result = caseConditionalProcessingAttributes(svgTrefElement);
				if (result == null) result = caseCoreAttributes(svgTrefElement);
				if (result == null) result = caseGraphicalEventAttributes(svgTrefElement);
				if (result == null) result = casePresentationAttributes(svgTrefElement);
				if (result == null) result = caseXLinkAttributes(svgTrefElement);
				if (result == null) result = caseContentElement(svgTrefElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SvgPackage.SVG_TEXT_PATH_ELEMENT: {
				SvgTextPathElement svgTextPathElement = (SvgTextPathElement)theEObject;
				T1 result = caseSvgTextPathElement(svgTextPathElement);
				if (result == null) result = caseSvgElement(svgTextPathElement);
				if (result == null) result = caseTextContentElement(svgTextPathElement);
				if (result == null) result = caseTextContentChildElement(svgTextPathElement);
				if (result == null) result = caseConditionalProcessingAttributes(svgTextPathElement);
				if (result == null) result = caseCoreAttributes(svgTextPathElement);
				if (result == null) result = caseGraphicalEventAttributes(svgTextPathElement);
				if (result == null) result = casePresentationAttributes(svgTextPathElement);
				if (result == null) result = caseXLinkAttributes(svgTextPathElement);
				if (result == null) result = caseContentElement(svgTextPathElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SvgPackage.SVG_ALT_GLYPH_ELEMENT: {
				SvgAltGlyphElement svgAltGlyphElement = (SvgAltGlyphElement)theEObject;
				T1 result = caseSvgAltGlyphElement(svgAltGlyphElement);
				if (result == null) result = caseSvgElement(svgAltGlyphElement);
				if (result == null) result = caseTextContentElement(svgAltGlyphElement);
				if (result == null) result = caseTextContentChildElement(svgAltGlyphElement);
				if (result == null) result = caseConditionalProcessingAttributes(svgAltGlyphElement);
				if (result == null) result = caseCoreAttributes(svgAltGlyphElement);
				if (result == null) result = caseGraphicalEventAttributes(svgAltGlyphElement);
				if (result == null) result = casePresentationAttributes(svgAltGlyphElement);
				if (result == null) result = caseXLinkAttributes(svgAltGlyphElement);
				if (result == null) result = caseContentElement(svgAltGlyphElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SvgPackage.SVG_ALT_GLYPH_DEF_ELEMENT: {
				SvgAltGlyphDefElement svgAltGlyphDefElement = (SvgAltGlyphDefElement)theEObject;
				T1 result = caseSvgAltGlyphDefElement(svgAltGlyphDefElement);
				if (result == null) result = caseSvgElement(svgAltGlyphDefElement);
				if (result == null) result = caseCoreAttributes(svgAltGlyphDefElement);
				if (result == null) result = caseContentElement(svgAltGlyphDefElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SvgPackage.SVG_ALT_GLYPH_ITEM_ELEMENT: {
				SvgAltGlyphItemElement svgAltGlyphItemElement = (SvgAltGlyphItemElement)theEObject;
				T1 result = caseSvgAltGlyphItemElement(svgAltGlyphItemElement);
				if (result == null) result = caseSvgElement(svgAltGlyphItemElement);
				if (result == null) result = caseCoreAttributes(svgAltGlyphItemElement);
				if (result == null) result = caseContentElement(svgAltGlyphItemElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SvgPackage.SVG_ALT_GLYPH_REF_ELEMENT: {
				SvgAltGlyphRefElement svgAltGlyphRefElement = (SvgAltGlyphRefElement)theEObject;
				T1 result = caseSvgAltGlyphRefElement(svgAltGlyphRefElement);
				if (result == null) result = caseSvgElement(svgAltGlyphRefElement);
				if (result == null) result = caseCoreAttributes(svgAltGlyphRefElement);
				if (result == null) result = casePresentationAttributes(svgAltGlyphRefElement);
				if (result == null) result = caseXLinkAttributes(svgAltGlyphRefElement);
				if (result == null) result = caseContentElement(svgAltGlyphRefElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SvgPackage.SVG_MARKER_ELEMENT: {
				SvgMarkerElement svgMarkerElement = (SvgMarkerElement)theEObject;
				T1 result = caseSvgMarkerElement(svgMarkerElement);
				if (result == null) result = caseSvgElement(svgMarkerElement);
				if (result == null) result = caseCoreAttributes(svgMarkerElement);
				if (result == null) result = casePresentationAttributes(svgMarkerElement);
				if (result == null) result = caseContentElement(svgMarkerElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SvgPackage.SVG_COLOR_PROFILE_ELEMENT: {
				SvgColorProfileElement svgColorProfileElement = (SvgColorProfileElement)theEObject;
				T1 result = caseSvgColorProfileElement(svgColorProfileElement);
				if (result == null) result = caseSvgElement(svgColorProfileElement);
				if (result == null) result = caseCoreAttributes(svgColorProfileElement);
				if (result == null) result = casePresentationAttributes(svgColorProfileElement);
				if (result == null) result = caseXLinkAttributes(svgColorProfileElement);
				if (result == null) result = caseContentElement(svgColorProfileElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SvgPackage.SVG_LINEAR_GRADIENT_ELEMENT: {
				SvgLinearGradientElement svgLinearGradientElement = (SvgLinearGradientElement)theEObject;
				T1 result = caseSvgLinearGradientElement(svgLinearGradientElement);
				if (result == null) result = caseSvgElement(svgLinearGradientElement);
				if (result == null) result = caseGradientElement(svgLinearGradientElement);
				if (result == null) result = caseCoreAttributes(svgLinearGradientElement);
				if (result == null) result = casePresentationAttributes(svgLinearGradientElement);
				if (result == null) result = caseXLinkAttributes(svgLinearGradientElement);
				if (result == null) result = caseContentElement(svgLinearGradientElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SvgPackage.SVG_RADIAL_GRADIENT_ELEMENT: {
				SvgRadialGradientElement svgRadialGradientElement = (SvgRadialGradientElement)theEObject;
				T1 result = caseSvgRadialGradientElement(svgRadialGradientElement);
				if (result == null) result = caseSvgElement(svgRadialGradientElement);
				if (result == null) result = caseGradientElement(svgRadialGradientElement);
				if (result == null) result = caseCoreAttributes(svgRadialGradientElement);
				if (result == null) result = casePresentationAttributes(svgRadialGradientElement);
				if (result == null) result = caseXLinkAttributes(svgRadialGradientElement);
				if (result == null) result = caseContentElement(svgRadialGradientElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SvgPackage.SVG_STOP_ELEMENT: {
				SvgStopElement svgStopElement = (SvgStopElement)theEObject;
				T1 result = caseSvgStopElement(svgStopElement);
				if (result == null) result = caseSvgElement(svgStopElement);
				if (result == null) result = caseCoreAttributes(svgStopElement);
				if (result == null) result = casePresentationAttributes(svgStopElement);
				if (result == null) result = caseContentElement(svgStopElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SvgPackage.SVG_PATTERN_ELEMENT: {
				SvgPatternElement svgPatternElement = (SvgPatternElement)theEObject;
				T1 result = caseSvgPatternElement(svgPatternElement);
				if (result == null) result = caseSvgElement(svgPatternElement);
				if (result == null) result = caseContainerElement(svgPatternElement);
				if (result == null) result = caseConditionalProcessingAttributes(svgPatternElement);
				if (result == null) result = caseCoreAttributes(svgPatternElement);
				if (result == null) result = casePresentationAttributes(svgPatternElement);
				if (result == null) result = caseXLinkAttributes(svgPatternElement);
				if (result == null) result = caseContentElement(svgPatternElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SvgPackage.SVG_CLIP_PATH_ELEMENT: {
				SvgClipPathElement svgClipPathElement = (SvgClipPathElement)theEObject;
				T1 result = caseSvgClipPathElement(svgClipPathElement);
				if (result == null) result = caseSvgElement(svgClipPathElement);
				if (result == null) result = caseConditionalProcessingAttributes(svgClipPathElement);
				if (result == null) result = caseCoreAttributes(svgClipPathElement);
				if (result == null) result = casePresentationAttributes(svgClipPathElement);
				if (result == null) result = caseContentElement(svgClipPathElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SvgPackage.SVG_MASK_ELEMENT: {
				SvgMaskElement svgMaskElement = (SvgMaskElement)theEObject;
				T1 result = caseSvgMaskElement(svgMaskElement);
				if (result == null) result = caseSvgElement(svgMaskElement);
				if (result == null) result = caseConditionalProcessingAttributes(svgMaskElement);
				if (result == null) result = caseCoreAttributes(svgMaskElement);
				if (result == null) result = casePresentationAttributes(svgMaskElement);
				if (result == null) result = caseContentElement(svgMaskElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SvgPackage.SVG_FILTER_ELEMENT: {
				SvgFilterElement svgFilterElement = (SvgFilterElement)theEObject;
				T1 result = caseSvgFilterElement(svgFilterElement);
				if (result == null) result = caseSvgElement(svgFilterElement);
				if (result == null) result = caseCoreAttributes(svgFilterElement);
				if (result == null) result = casePresentationAttributes(svgFilterElement);
				if (result == null) result = caseXLinkAttributes(svgFilterElement);
				if (result == null) result = caseContentElement(svgFilterElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SvgPackage.SVG_FE_DISTANT_LIGHT_ELEMENT: {
				SvgFeDistantLightElement svgFeDistantLightElement = (SvgFeDistantLightElement)theEObject;
				T1 result = caseSvgFeDistantLightElement(svgFeDistantLightElement);
				if (result == null) result = caseSvgElement(svgFeDistantLightElement);
				if (result == null) result = caseCoreAttributes(svgFeDistantLightElement);
				if (result == null) result = caseContentElement(svgFeDistantLightElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SvgPackage.SVG_FE_POINT_LIGHT_ELEMENT: {
				SvgFePointLightElement svgFePointLightElement = (SvgFePointLightElement)theEObject;
				T1 result = caseSvgFePointLightElement(svgFePointLightElement);
				if (result == null) result = caseSvgElement(svgFePointLightElement);
				if (result == null) result = caseCoreAttributes(svgFePointLightElement);
				if (result == null) result = caseLightSourceElement(svgFePointLightElement);
				if (result == null) result = caseContentElement(svgFePointLightElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SvgPackage.SVG_FE_SPOT_LIGHT_ELEMENT: {
				SvgFeSpotLightElement svgFeSpotLightElement = (SvgFeSpotLightElement)theEObject;
				T1 result = caseSvgFeSpotLightElement(svgFeSpotLightElement);
				if (result == null) result = caseSvgElement(svgFeSpotLightElement);
				if (result == null) result = caseCoreAttributes(svgFeSpotLightElement);
				if (result == null) result = caseLightSourceElement(svgFeSpotLightElement);
				if (result == null) result = caseContentElement(svgFeSpotLightElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SvgPackage.SVG_FE_BLEND_ELEMENT: {
				SvgFeBlendElement svgFeBlendElement = (SvgFeBlendElement)theEObject;
				T1 result = caseSvgFeBlendElement(svgFeBlendElement);
				if (result == null) result = caseSvgElement(svgFeBlendElement);
				if (result == null) result = caseCoreAttributes(svgFeBlendElement);
				if (result == null) result = casePresentationAttributes(svgFeBlendElement);
				if (result == null) result = caseFilterPrimitiveAttributes(svgFeBlendElement);
				if (result == null) result = caseContentElement(svgFeBlendElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SvgPackage.SVG_FE_COLOR_MATRIX_ELEMENT: {
				SvgFeColorMatrixElement svgFeColorMatrixElement = (SvgFeColorMatrixElement)theEObject;
				T1 result = caseSvgFeColorMatrixElement(svgFeColorMatrixElement);
				if (result == null) result = caseSvgElement(svgFeColorMatrixElement);
				if (result == null) result = caseCoreAttributes(svgFeColorMatrixElement);
				if (result == null) result = casePresentationAttributes(svgFeColorMatrixElement);
				if (result == null) result = caseFilterPrimitiveAttributes(svgFeColorMatrixElement);
				if (result == null) result = caseContentElement(svgFeColorMatrixElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SvgPackage.SVG_FE_COMPONENT_TRANSFER_ELEMENT: {
				SvgFeComponentTransferElement svgFeComponentTransferElement = (SvgFeComponentTransferElement)theEObject;
				T1 result = caseSvgFeComponentTransferElement(svgFeComponentTransferElement);
				if (result == null) result = caseSvgElement(svgFeComponentTransferElement);
				if (result == null) result = caseCoreAttributes(svgFeComponentTransferElement);
				if (result == null) result = casePresentationAttributes(svgFeComponentTransferElement);
				if (result == null) result = caseFilterPrimitiveAttributes(svgFeComponentTransferElement);
				if (result == null) result = caseContentElement(svgFeComponentTransferElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SvgPackage.SVG_FE_FUNC_RELEMENT: {
				SvgFeFuncRElement svgFeFuncRElement = (SvgFeFuncRElement)theEObject;
				T1 result = caseSvgFeFuncRElement(svgFeFuncRElement);
				if (result == null) result = caseSvgElement(svgFeFuncRElement);
				if (result == null) result = caseCoreAttributes(svgFeFuncRElement);
				if (result == null) result = casePresentationAttributes(svgFeFuncRElement);
				if (result == null) result = caseContentElement(svgFeFuncRElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SvgPackage.SVG_FE_FUNC_GELEMENT: {
				SvgFeFuncGElement svgFeFuncGElement = (SvgFeFuncGElement)theEObject;
				T1 result = caseSvgFeFuncGElement(svgFeFuncGElement);
				if (result == null) result = caseSvgElement(svgFeFuncGElement);
				if (result == null) result = caseCoreAttributes(svgFeFuncGElement);
				if (result == null) result = casePresentationAttributes(svgFeFuncGElement);
				if (result == null) result = caseContentElement(svgFeFuncGElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SvgPackage.SVG_FE_FUNC_BELEMENT: {
				SvgFeFuncBElement svgFeFuncBElement = (SvgFeFuncBElement)theEObject;
				T1 result = caseSvgFeFuncBElement(svgFeFuncBElement);
				if (result == null) result = caseSvgElement(svgFeFuncBElement);
				if (result == null) result = caseCoreAttributes(svgFeFuncBElement);
				if (result == null) result = casePresentationAttributes(svgFeFuncBElement);
				if (result == null) result = caseContentElement(svgFeFuncBElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SvgPackage.SVG_FE_FUNC_AELEMENT: {
				SvgFeFuncAElement svgFeFuncAElement = (SvgFeFuncAElement)theEObject;
				T1 result = caseSvgFeFuncAElement(svgFeFuncAElement);
				if (result == null) result = caseSvgElement(svgFeFuncAElement);
				if (result == null) result = caseCoreAttributes(svgFeFuncAElement);
				if (result == null) result = casePresentationAttributes(svgFeFuncAElement);
				if (result == null) result = caseContentElement(svgFeFuncAElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SvgPackage.SVG_FE_COMPOSITE_ELEMENT: {
				SvgFeCompositeElement svgFeCompositeElement = (SvgFeCompositeElement)theEObject;
				T1 result = caseSvgFeCompositeElement(svgFeCompositeElement);
				if (result == null) result = caseSvgElement(svgFeCompositeElement);
				if (result == null) result = caseCoreAttributes(svgFeCompositeElement);
				if (result == null) result = casePresentationAttributes(svgFeCompositeElement);
				if (result == null) result = caseFilterPrimitiveAttributes(svgFeCompositeElement);
				if (result == null) result = caseContentElement(svgFeCompositeElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SvgPackage.SVG_FE_CONVOLVE_MATRIX_ELEMENT: {
				SvgFeConvolveMatrixElement svgFeConvolveMatrixElement = (SvgFeConvolveMatrixElement)theEObject;
				T1 result = caseSvgFeConvolveMatrixElement(svgFeConvolveMatrixElement);
				if (result == null) result = caseSvgElement(svgFeConvolveMatrixElement);
				if (result == null) result = caseCoreAttributes(svgFeConvolveMatrixElement);
				if (result == null) result = casePresentationAttributes(svgFeConvolveMatrixElement);
				if (result == null) result = caseFilterPrimitiveAttributes(svgFeConvolveMatrixElement);
				if (result == null) result = caseContentElement(svgFeConvolveMatrixElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SvgPackage.SVG_FE_DIFFUSE_LIGHTING_ELEMENT: {
				SvgFeDiffuseLightingElement svgFeDiffuseLightingElement = (SvgFeDiffuseLightingElement)theEObject;
				T1 result = caseSvgFeDiffuseLightingElement(svgFeDiffuseLightingElement);
				if (result == null) result = caseSvgElement(svgFeDiffuseLightingElement);
				if (result == null) result = caseCoreAttributes(svgFeDiffuseLightingElement);
				if (result == null) result = casePresentationAttributes(svgFeDiffuseLightingElement);
				if (result == null) result = caseFilterPrimitiveAttributes(svgFeDiffuseLightingElement);
				if (result == null) result = caseContentElement(svgFeDiffuseLightingElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SvgPackage.SVG_FE_DISPLACEMENT_MAP_ELEMENT: {
				SvgFeDisplacementMapElement svgFeDisplacementMapElement = (SvgFeDisplacementMapElement)theEObject;
				T1 result = caseSvgFeDisplacementMapElement(svgFeDisplacementMapElement);
				if (result == null) result = caseSvgElement(svgFeDisplacementMapElement);
				if (result == null) result = caseCoreAttributes(svgFeDisplacementMapElement);
				if (result == null) result = casePresentationAttributes(svgFeDisplacementMapElement);
				if (result == null) result = caseFilterPrimitiveAttributes(svgFeDisplacementMapElement);
				if (result == null) result = caseContentElement(svgFeDisplacementMapElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SvgPackage.SVG_FE_FLOOD_ELEMENT: {
				SvgFeFloodElement svgFeFloodElement = (SvgFeFloodElement)theEObject;
				T1 result = caseSvgFeFloodElement(svgFeFloodElement);
				if (result == null) result = caseSvgElement(svgFeFloodElement);
				if (result == null) result = caseCoreAttributes(svgFeFloodElement);
				if (result == null) result = casePresentationAttributes(svgFeFloodElement);
				if (result == null) result = caseFilterPrimitiveAttributes(svgFeFloodElement);
				if (result == null) result = caseContentElement(svgFeFloodElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SvgPackage.SVG_FE_GAUSSIAN_BLUR_ELEMENT: {
				SvgFeGaussianBlurElement svgFeGaussianBlurElement = (SvgFeGaussianBlurElement)theEObject;
				T1 result = caseSvgFeGaussianBlurElement(svgFeGaussianBlurElement);
				if (result == null) result = caseSvgElement(svgFeGaussianBlurElement);
				if (result == null) result = caseCoreAttributes(svgFeGaussianBlurElement);
				if (result == null) result = casePresentationAttributes(svgFeGaussianBlurElement);
				if (result == null) result = caseFilterPrimitiveAttributes(svgFeGaussianBlurElement);
				if (result == null) result = caseContentElement(svgFeGaussianBlurElement);
				if (result == null) result = caseFilterPrimitiveElement(svgFeGaussianBlurElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SvgPackage.SVG_FE_IMAGE_ELEMENT: {
				SvgFeImageElement svgFeImageElement = (SvgFeImageElement)theEObject;
				T1 result = caseSvgFeImageElement(svgFeImageElement);
				if (result == null) result = caseSvgElement(svgFeImageElement);
				if (result == null) result = caseCoreAttributes(svgFeImageElement);
				if (result == null) result = casePresentationAttributes(svgFeImageElement);
				if (result == null) result = caseFilterPrimitiveAttributes(svgFeImageElement);
				if (result == null) result = caseXLinkAttributes(svgFeImageElement);
				if (result == null) result = caseContentElement(svgFeImageElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SvgPackage.SVG_FE_MERGE_ELEMENT: {
				SvgFeMergeElement svgFeMergeElement = (SvgFeMergeElement)theEObject;
				T1 result = caseSvgFeMergeElement(svgFeMergeElement);
				if (result == null) result = caseSvgElement(svgFeMergeElement);
				if (result == null) result = caseCoreAttributes(svgFeMergeElement);
				if (result == null) result = casePresentationAttributes(svgFeMergeElement);
				if (result == null) result = caseFilterPrimitiveAttributes(svgFeMergeElement);
				if (result == null) result = caseContentElement(svgFeMergeElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SvgPackage.SVG_FE_MERGE_NODE_ELEMENT: {
				SvgFeMergeNodeElement svgFeMergeNodeElement = (SvgFeMergeNodeElement)theEObject;
				T1 result = caseSvgFeMergeNodeElement(svgFeMergeNodeElement);
				if (result == null) result = caseSvgElement(svgFeMergeNodeElement);
				if (result == null) result = caseCoreAttributes(svgFeMergeNodeElement);
				if (result == null) result = caseContentElement(svgFeMergeNodeElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SvgPackage.SVG_FE_MORPHOLOGY_ELEMENT: {
				SvgFeMorphologyElement svgFeMorphologyElement = (SvgFeMorphologyElement)theEObject;
				T1 result = caseSvgFeMorphologyElement(svgFeMorphologyElement);
				if (result == null) result = caseSvgElement(svgFeMorphologyElement);
				if (result == null) result = caseCoreAttributes(svgFeMorphologyElement);
				if (result == null) result = casePresentationAttributes(svgFeMorphologyElement);
				if (result == null) result = caseFilterPrimitiveAttributes(svgFeMorphologyElement);
				if (result == null) result = caseContentElement(svgFeMorphologyElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SvgPackage.SVG_FE_OFFSET_ELEMENT: {
				SvgFeOffsetElement svgFeOffsetElement = (SvgFeOffsetElement)theEObject;
				T1 result = caseSvgFeOffsetElement(svgFeOffsetElement);
				if (result == null) result = caseSvgElement(svgFeOffsetElement);
				if (result == null) result = caseCoreAttributes(svgFeOffsetElement);
				if (result == null) result = casePresentationAttributes(svgFeOffsetElement);
				if (result == null) result = caseFilterPrimitiveAttributes(svgFeOffsetElement);
				if (result == null) result = caseContentElement(svgFeOffsetElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SvgPackage.SVG_FE_SPECULAR_LIGHTING_ELEMENT: {
				SvgFeSpecularLightingElement svgFeSpecularLightingElement = (SvgFeSpecularLightingElement)theEObject;
				T1 result = caseSvgFeSpecularLightingElement(svgFeSpecularLightingElement);
				if (result == null) result = caseSvgElement(svgFeSpecularLightingElement);
				if (result == null) result = caseCoreAttributes(svgFeSpecularLightingElement);
				if (result == null) result = casePresentationAttributes(svgFeSpecularLightingElement);
				if (result == null) result = caseFilterPrimitiveAttributes(svgFeSpecularLightingElement);
				if (result == null) result = caseContentElement(svgFeSpecularLightingElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SvgPackage.SVG_FE_TILE_ELEMENT: {
				SvgFeTileElement svgFeTileElement = (SvgFeTileElement)theEObject;
				T1 result = caseSvgFeTileElement(svgFeTileElement);
				if (result == null) result = caseSvgElement(svgFeTileElement);
				if (result == null) result = caseCoreAttributes(svgFeTileElement);
				if (result == null) result = casePresentationAttributes(svgFeTileElement);
				if (result == null) result = caseFilterPrimitiveAttributes(svgFeTileElement);
				if (result == null) result = caseContentElement(svgFeTileElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SvgPackage.SVG_FE_TURBULENCE_ELEMENT: {
				SvgFeTurbulenceElement svgFeTurbulenceElement = (SvgFeTurbulenceElement)theEObject;
				T1 result = caseSvgFeTurbulenceElement(svgFeTurbulenceElement);
				if (result == null) result = caseSvgElement(svgFeTurbulenceElement);
				if (result == null) result = caseCoreAttributes(svgFeTurbulenceElement);
				if (result == null) result = casePresentationAttributes(svgFeTurbulenceElement);
				if (result == null) result = caseFilterPrimitiveAttributes(svgFeTurbulenceElement);
				if (result == null) result = caseContentElement(svgFeTurbulenceElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SvgPackage.SVG_ANIMATE_ELEMENT: {
				SvgAnimateElement svgAnimateElement = (SvgAnimateElement)theEObject;
				T1 result = caseSvgAnimateElement(svgAnimateElement);
				if (result == null) result = caseSvgElement(svgAnimateElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SvgPackage.SVG_METADATA_ELEMENT: {
				SvgMetadataElement svgMetadataElement = (SvgMetadataElement)theEObject;
				T1 result = caseSvgMetadataElement(svgMetadataElement);
				if (result == null) result = caseSvgElement(svgMetadataElement);
				if (result == null) result = caseCoreAttributes(svgMetadataElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Content Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Content Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T extends SvgElement> T1 caseContentElement(ContentElement<T> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Container Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Container Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T extends SvgElement> T1 caseContainerElement(ContainerElement<T> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Structural Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Structural Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseStructuralElement(StructuralElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSvgElement(SvgElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Descriptive Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Descriptive Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseDescriptiveElement(DescriptiveElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Graphics Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Graphics Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseGraphicsElement(GraphicsElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Graphics Referencing Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Graphics Referencing Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseGraphicsReferencingElement(GraphicsReferencingElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Shape Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Shape Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseShapeElement(ShapeElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Basic Shape Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Basic Shape Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseBasicShapeElement(BasicShapeElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Text Content Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Text Content Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseTextContentElement(TextContentElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Text Content Child Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Text Content Child Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseTextContentChildElement(TextContentChildElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Gradient Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Gradient Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseGradientElement(GradientElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Light Source Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Light Source Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseLightSourceElement(LightSourceElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Filter Primitive Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Filter Primitive Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseFilterPrimitiveElement(FilterPrimitiveElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Animation Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Animation Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseAnimationElement(AnimationElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ENUMS </em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ENUMS </em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 case____ENUMS____(____ENUMS____ object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DATATYPES </em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DATATYPES </em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 case____DATATYPES____(____DATATYPES____ object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ATTRIBUTES </em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ATTRIBUTES </em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 case____ATTRIBUTES____(____ATTRIBUTES____ object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Conditional Processing Attributes</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Conditional Processing Attributes</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseConditionalProcessingAttributes(ConditionalProcessingAttributes object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Core Attributes</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Core Attributes</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseCoreAttributes(CoreAttributes object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Document Event Attributes</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Document Event Attributes</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseDocumentEventAttributes(DocumentEventAttributes object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Graphical Event Attributes</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Graphical Event Attributes</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseGraphicalEventAttributes(GraphicalEventAttributes object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Presentation Attributes</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Presentation Attributes</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 casePresentationAttributes(PresentationAttributes object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XLink Attributes</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XLink Attributes</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseXLinkAttributes(XLinkAttributes object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Filter Primitive Attributes</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Filter Primitive Attributes</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseFilterPrimitiveAttributes(FilterPrimitiveAttributes object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ELEMENTES </em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ELEMENTES </em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 case____ELEMENTES____(____ELEMENTES____ object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Svg Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Svg Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSvgSvgElement(SvgSvgElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>GElement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>GElement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSvgGElement(SvgGElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Defs Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Defs Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSvgDefsElement(SvgDefsElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Desc Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Desc Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSvgDescElement(SvgDescElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Title Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Title Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSvgTitleElement(SvgTitleElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Symbol Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Symbol Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSvgSymbolElement(SvgSymbolElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Use Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Use Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSvgUseElement(SvgUseElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Image Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Image Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSvgImageElement(SvgImageElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Switch Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Switch Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSvgSwitchElement(SvgSwitchElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Path Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Path Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSvgPathElement(SvgPathElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Rect Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Rect Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSvgRectElement(SvgRectElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Circle Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Circle Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSvgCircleElement(SvgCircleElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ellipse Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ellipse Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSvgEllipseElement(SvgEllipseElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Line Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Line Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSvgLineElement(SvgLineElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Polyline Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Polyline Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSvgPolylineElement(SvgPolylineElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Polygon Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Polygon Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSvgPolygonElement(SvgPolygonElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Text Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Text Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSvgTextElement(SvgTextElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tspan Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tspan Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSvgTspanElement(SvgTspanElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tref Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tref Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSvgTrefElement(SvgTrefElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Text Path Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Text Path Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSvgTextPathElement(SvgTextPathElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Alt Glyph Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Alt Glyph Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSvgAltGlyphElement(SvgAltGlyphElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Alt Glyph Def Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Alt Glyph Def Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSvgAltGlyphDefElement(SvgAltGlyphDefElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Alt Glyph Item Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Alt Glyph Item Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSvgAltGlyphItemElement(SvgAltGlyphItemElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Alt Glyph Ref Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Alt Glyph Ref Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSvgAltGlyphRefElement(SvgAltGlyphRefElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Marker Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Marker Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSvgMarkerElement(SvgMarkerElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Color Profile Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Color Profile Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSvgColorProfileElement(SvgColorProfileElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Linear Gradient Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Linear Gradient Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSvgLinearGradientElement(SvgLinearGradientElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Radial Gradient Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Radial Gradient Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSvgRadialGradientElement(SvgRadialGradientElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Stop Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Stop Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSvgStopElement(SvgStopElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pattern Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pattern Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSvgPatternElement(SvgPatternElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Clip Path Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Clip Path Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSvgClipPathElement(SvgClipPathElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mask Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mask Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSvgMaskElement(SvgMaskElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Filter Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Filter Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSvgFilterElement(SvgFilterElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fe Distant Light Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fe Distant Light Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSvgFeDistantLightElement(SvgFeDistantLightElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fe Point Light Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fe Point Light Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSvgFePointLightElement(SvgFePointLightElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fe Spot Light Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fe Spot Light Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSvgFeSpotLightElement(SvgFeSpotLightElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fe Blend Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fe Blend Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSvgFeBlendElement(SvgFeBlendElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fe Color Matrix Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fe Color Matrix Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSvgFeColorMatrixElement(SvgFeColorMatrixElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fe Component Transfer Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fe Component Transfer Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSvgFeComponentTransferElement(SvgFeComponentTransferElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fe Func RElement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fe Func RElement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSvgFeFuncRElement(SvgFeFuncRElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fe Func GElement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fe Func GElement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSvgFeFuncGElement(SvgFeFuncGElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fe Func BElement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fe Func BElement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSvgFeFuncBElement(SvgFeFuncBElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fe Func AElement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fe Func AElement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSvgFeFuncAElement(SvgFeFuncAElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fe Composite Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fe Composite Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSvgFeCompositeElement(SvgFeCompositeElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fe Convolve Matrix Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fe Convolve Matrix Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSvgFeConvolveMatrixElement(SvgFeConvolveMatrixElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fe Diffuse Lighting Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fe Diffuse Lighting Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSvgFeDiffuseLightingElement(SvgFeDiffuseLightingElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fe Displacement Map Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fe Displacement Map Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSvgFeDisplacementMapElement(SvgFeDisplacementMapElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fe Flood Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fe Flood Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSvgFeFloodElement(SvgFeFloodElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fe Gaussian Blur Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fe Gaussian Blur Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSvgFeGaussianBlurElement(SvgFeGaussianBlurElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fe Image Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fe Image Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSvgFeImageElement(SvgFeImageElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fe Merge Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fe Merge Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSvgFeMergeElement(SvgFeMergeElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fe Merge Node Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fe Merge Node Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSvgFeMergeNodeElement(SvgFeMergeNodeElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fe Morphology Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fe Morphology Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSvgFeMorphologyElement(SvgFeMorphologyElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fe Offset Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fe Offset Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSvgFeOffsetElement(SvgFeOffsetElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fe Specular Lighting Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fe Specular Lighting Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSvgFeSpecularLightingElement(SvgFeSpecularLightingElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fe Tile Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fe Tile Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSvgFeTileElement(SvgFeTileElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fe Turbulence Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fe Turbulence Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSvgFeTurbulenceElement(SvgFeTurbulenceElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Animate Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Animate Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSvgAnimateElement(SvgAnimateElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Metadata Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Metadata Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSvgMetadataElement(SvgMetadataElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T1 defaultCase(EObject object) {
		return null;
	}

} //SvgSwitch
