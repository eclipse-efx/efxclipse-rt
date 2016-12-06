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
package org.eclipse.fx.formats.svg.svg.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.fx.formats.svg.svg.Alignment_baseline;
import org.eclipse.fx.formats.svg.svg.AnimationElement;
import org.eclipse.fx.formats.svg.svg.BasicShapeElement;
import org.eclipse.fx.formats.svg.svg.BlendMode;
import org.eclipse.fx.formats.svg.svg.ChannelSelector;
import org.eclipse.fx.formats.svg.svg.ClipPathUnits;
import org.eclipse.fx.formats.svg.svg.Clip_rule;
import org.eclipse.fx.formats.svg.svg.ColorMatrixType;
import org.eclipse.fx.formats.svg.svg.Color_interpolation;
import org.eclipse.fx.formats.svg.svg.Color_interpolation_filters;
import org.eclipse.fx.formats.svg.svg.Color_rendering;
import org.eclipse.fx.formats.svg.svg.CompositeOperator;
import org.eclipse.fx.formats.svg.svg.ConditionalProcessingAttributes;
import org.eclipse.fx.formats.svg.svg.ContainerElement;
import org.eclipse.fx.formats.svg.svg.ContentElement;
import org.eclipse.fx.formats.svg.svg.ConvolveMatrixEdgeMode;
import org.eclipse.fx.formats.svg.svg.CoreAttributes;
import org.eclipse.fx.formats.svg.svg.DescriptiveElement;
import org.eclipse.fx.formats.svg.svg.Direction;
import org.eclipse.fx.formats.svg.svg.Display;
import org.eclipse.fx.formats.svg.svg.DocumentEventAttributes;
import org.eclipse.fx.formats.svg.svg.Dominant_baseline;
import org.eclipse.fx.formats.svg.svg.Fill_rule;
import org.eclipse.fx.formats.svg.svg.FilterPrimitiveAttributes;
import org.eclipse.fx.formats.svg.svg.FilterPrimitiveElement;
import org.eclipse.fx.formats.svg.svg.FilterUnits;
import org.eclipse.fx.formats.svg.svg.Font_stretch;
import org.eclipse.fx.formats.svg.svg.Font_style;
import org.eclipse.fx.formats.svg.svg.Font_variant;
import org.eclipse.fx.formats.svg.svg.Font_weight;
import org.eclipse.fx.formats.svg.svg.GradientElement;
import org.eclipse.fx.formats.svg.svg.GradientUnits;
import org.eclipse.fx.formats.svg.svg.GraphicalEventAttributes;
import org.eclipse.fx.formats.svg.svg.GraphicsElement;
import org.eclipse.fx.formats.svg.svg.GraphicsReferencingElement;
import org.eclipse.fx.formats.svg.svg.Image_rendering;
import org.eclipse.fx.formats.svg.svg.LengthAdjust;
import org.eclipse.fx.formats.svg.svg.LightSourceElement;
import org.eclipse.fx.formats.svg.svg.MarkerUnits;
import org.eclipse.fx.formats.svg.svg.MaskUnits;
import org.eclipse.fx.formats.svg.svg.Method;
import org.eclipse.fx.formats.svg.svg.MorphologyOperator;
import org.eclipse.fx.formats.svg.svg.Overflow;
import org.eclipse.fx.formats.svg.svg.PatternUnits;
import org.eclipse.fx.formats.svg.svg.Pointer_events;
import org.eclipse.fx.formats.svg.svg.PresentationAttributes;
import org.eclipse.fx.formats.svg.svg.Rendering_intent;
import org.eclipse.fx.formats.svg.svg.ShapeElement;
import org.eclipse.fx.formats.svg.svg.Shape_rendering;
import org.eclipse.fx.formats.svg.svg.Spacing;
import org.eclipse.fx.formats.svg.svg.SpreadMethod;
import org.eclipse.fx.formats.svg.svg.StitchTiles;
import org.eclipse.fx.formats.svg.svg.Stroke_linecap;
import org.eclipse.fx.formats.svg.svg.Stroke_linejoin;
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
import org.eclipse.fx.formats.svg.svg.SvgFactory;
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
import org.eclipse.fx.formats.svg.svg.Text_anchor;
import org.eclipse.fx.formats.svg.svg.Text_rendering;
import org.eclipse.fx.formats.svg.svg.TurbulenceType;
import org.eclipse.fx.formats.svg.svg.Unicode_bidi;
import org.eclipse.fx.formats.svg.svg.Visibility;
import org.eclipse.fx.formats.svg.svg.Writing_mode;
import org.eclipse.fx.formats.svg.svg.XLinkAttributes;
import org.eclipse.fx.formats.svg.svg.ZoomAndPan;
import org.eclipse.fx.formats.svg.svg.____ATTRIBUTES____;
import org.eclipse.fx.formats.svg.svg.____DATATYPES____;
import org.eclipse.fx.formats.svg.svg.____ELEMENTES____;
import org.eclipse.fx.formats.svg.svg.____ENUMS____;
import org.eclipse.fx.formats.svg.svg.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SvgPackageImpl extends EPackageImpl implements SvgPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass contentElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass containerElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass structuralElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass svgElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass descriptiveElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass graphicsElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass graphicsReferencingElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass shapeElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass basicShapeElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass textContentElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass textContentChildElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass gradientElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lightSourceElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass filterPrimitiveElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass animationElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ____ENUMS____EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ____DATATYPES____EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ____ATTRIBUTES____EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conditionalProcessingAttributesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass coreAttributesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass documentEventAttributesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass graphicalEventAttributesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass presentationAttributesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xLinkAttributesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass filterPrimitiveAttributesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ____ELEMENTES____EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass svgSvgElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass svgGElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass svgDefsElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass svgDescElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass svgTitleElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass svgSymbolElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass svgUseElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass svgImageElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass svgSwitchElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass svgPathElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass svgRectElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass svgCircleElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass svgEllipseElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass svgLineElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass svgPolylineElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass svgPolygonElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass svgTextElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass svgTspanElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass svgTrefElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass svgTextPathElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass svgAltGlyphElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass svgAltGlyphDefElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass svgAltGlyphItemElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass svgAltGlyphRefElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass svgMarkerElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass svgColorProfileElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass svgLinearGradientElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass svgRadialGradientElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass svgStopElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass svgPatternElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass svgClipPathElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass svgMaskElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass svgFilterElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass svgFeDistantLightElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass svgFePointLightElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass svgFeSpotLightElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass svgFeBlendElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass svgFeColorMatrixElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass svgFeComponentTransferElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass svgFeFuncRElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass svgFeFuncGElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass svgFeFuncBElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass svgFeFuncAElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass svgFeCompositeElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass svgFeConvolveMatrixElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass svgFeDiffuseLightingElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass svgFeDisplacementMapElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass svgFeFloodElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass svgFeGaussianBlurElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass svgFeImageElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass svgFeMergeElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass svgFeMergeNodeElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass svgFeMorphologyElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass svgFeOffsetElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass svgFeSpecularLightingElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass svgFeTileElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass svgFeTurbulenceElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass svgAnimateElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass svgMetadataElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum alignment_baselineEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum clip_ruleEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum color_interpolationEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum color_interpolation_filtersEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum color_renderingEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum directionEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum displayEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum dominant_baselineEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum fill_ruleEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum font_stretchEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum font_styleEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum font_variantEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum font_weightEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum image_renderingEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum overflowEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum pointer_eventsEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum shape_renderingEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum stroke_linecapEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum stroke_linejoinEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum text_anchorEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum text_renderingEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum unicode_bidiEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum visibilityEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum writing_modeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum zoomAndPanEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum lengthAdjustEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum methodEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum spacingEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum markerUnitsEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum rendering_intentEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum gradientUnitsEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum spreadMethodEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum patternUnitsEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum clipPathUnitsEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum maskUnitsEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum filterUnitsEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum blendModeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum colorMatrixTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum compositeOperatorEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum convolveMatrixEdgeModeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum channelSelectorEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum morphologyOperatorEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum stitchTilesEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum turbulenceTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType lengthEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType angleEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType percentageEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType shapeEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType funciriEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType colorEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType paintEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType opacity_valueEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType baseline_shiftEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType clipEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType clip_pathEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType color_profileEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType cursorEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType enable_backgroundEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType fillEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType fill_opacityEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType filterEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType flood_colorEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType flood_opacityEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType font_familyEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType font_sizeEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType font_size_adjustEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType glyph_orientation_horizontalEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType glyph_orientation_verticalEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType kerningEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType letter_spacingEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType lighting_colorEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType marker_endEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType marker_midEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType marker_startEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType masksEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType opacityEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType stop_colorEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType stop_opacityEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType strokeEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType stroke_dasharrayEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType stroke_dashoffsetEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType stroke_miterlimitEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType stroke_opacityEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType stroke_widthEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType text_decorationEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType word_spacingEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType coordinateEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType viewBoxEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType preserveAspectRatioEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType numberEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType transformEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType pathDataEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType listOfPointsEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType listOfLengthsEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType listOfNumbersEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType listOfCoordinatesEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType nameEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType numberOptionalNumberEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType transformListEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SvgPackageImpl() {
		super(eNS_URI, SvgFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link SvgPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static SvgPackage init() {
		if (isInited) return (SvgPackage)EPackage.Registry.INSTANCE.getEPackage(SvgPackage.eNS_URI);

		// Obtain or create and register package
		SvgPackageImpl theSvgPackage = (SvgPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof SvgPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new SvgPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theSvgPackage.createPackageContents();

		// Initialize created meta-data
		theSvgPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSvgPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(SvgPackage.eNS_URI, theSvgPackage);
		return theSvgPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getContentElement() {
		return contentElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContentElement_Children() {
		return (EReference)contentElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getContainerElement() {
		return containerElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStructuralElement() {
		return structuralElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSvgElement() {
		return svgElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDescriptiveElement() {
		return descriptiveElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGraphicsElement() {
		return graphicsElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGraphicsReferencingElement() {
		return graphicsReferencingElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getShapeElement() {
		return shapeElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBasicShapeElement() {
		return basicShapeElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTextContentElement() {
		return textContentElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTextContentChildElement() {
		return textContentChildElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGradientElement() {
		return gradientElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLightSourceElement() {
		return lightSourceElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFilterPrimitiveElement() {
		return filterPrimitiveElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAnimationElement() {
		return animationElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass get____ENUMS____() {
		return ____ENUMS____EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass get____DATATYPES____() {
		return ____DATATYPES____EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass get____ATTRIBUTES____() {
		return ____ATTRIBUTES____EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConditionalProcessingAttributes() {
		return conditionalProcessingAttributesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConditionalProcessingAttributes_RequiredFeatures() {
		return (EAttribute)conditionalProcessingAttributesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConditionalProcessingAttributes_RequiredExtensions() {
		return (EAttribute)conditionalProcessingAttributesEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConditionalProcessingAttributes_SystemLanguage() {
		return (EAttribute)conditionalProcessingAttributesEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCoreAttributes() {
		return coreAttributesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCoreAttributes_Id() {
		return (EAttribute)coreAttributesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCoreAttributes_Xml__base() {
		return (EAttribute)coreAttributesEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCoreAttributes_Xml__lang() {
		return (EAttribute)coreAttributesEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCoreAttributes_Xml__space() {
		return (EAttribute)coreAttributesEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDocumentEventAttributes() {
		return documentEventAttributesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentEventAttributes_Onunload() {
		return (EAttribute)documentEventAttributesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentEventAttributes_Onabort() {
		return (EAttribute)documentEventAttributesEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentEventAttributes_Onerror() {
		return (EAttribute)documentEventAttributesEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentEventAttributes_Onresize() {
		return (EAttribute)documentEventAttributesEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentEventAttributes_Onscroll() {
		return (EAttribute)documentEventAttributesEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentEventAttributes_Onzoom() {
		return (EAttribute)documentEventAttributesEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGraphicalEventAttributes() {
		return graphicalEventAttributesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGraphicalEventAttributes_Onfocusin() {
		return (EAttribute)graphicalEventAttributesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGraphicalEventAttributes_Onfocusout() {
		return (EAttribute)graphicalEventAttributesEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGraphicalEventAttributes_Onactivate() {
		return (EAttribute)graphicalEventAttributesEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGraphicalEventAttributes_Onclick() {
		return (EAttribute)graphicalEventAttributesEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGraphicalEventAttributes_Onmousedown() {
		return (EAttribute)graphicalEventAttributesEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGraphicalEventAttributes_Onmouseup() {
		return (EAttribute)graphicalEventAttributesEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGraphicalEventAttributes_Onmouseover() {
		return (EAttribute)graphicalEventAttributesEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGraphicalEventAttributes_Onmousemove() {
		return (EAttribute)graphicalEventAttributesEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGraphicalEventAttributes_Onmouseout() {
		return (EAttribute)graphicalEventAttributesEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGraphicalEventAttributes_Onload() {
		return (EAttribute)graphicalEventAttributesEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPresentationAttributes() {
		return presentationAttributesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPresentationAttributes_Alignment_baseline() {
		return (EAttribute)presentationAttributesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPresentationAttributes_Baseline_shift() {
		return (EAttribute)presentationAttributesEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPresentationAttributes_Clip() {
		return (EAttribute)presentationAttributesEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPresentationAttributes_Clip_path() {
		return (EAttribute)presentationAttributesEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPresentationAttributes_Clip_rule() {
		return (EAttribute)presentationAttributesEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPresentationAttributes_Color() {
		return (EAttribute)presentationAttributesEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPresentationAttributes_Color_interpolation() {
		return (EAttribute)presentationAttributesEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPresentationAttributes_Color_interpolation_filters() {
		return (EAttribute)presentationAttributesEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPresentationAttributes_Color_profile() {
		return (EAttribute)presentationAttributesEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPresentationAttributes_Color_rendering() {
		return (EAttribute)presentationAttributesEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPresentationAttributes_Cursor() {
		return (EAttribute)presentationAttributesEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPresentationAttributes_Direction() {
		return (EAttribute)presentationAttributesEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPresentationAttributes_Display() {
		return (EAttribute)presentationAttributesEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPresentationAttributes_Dominant_baseline() {
		return (EAttribute)presentationAttributesEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPresentationAttributes_Enable_background() {
		return (EAttribute)presentationAttributesEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPresentationAttributes_Fill() {
		return (EAttribute)presentationAttributesEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPresentationAttributes_Fill_opacity() {
		return (EAttribute)presentationAttributesEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPresentationAttributes_Fill_rule() {
		return (EAttribute)presentationAttributesEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPresentationAttributes_Filter() {
		return (EAttribute)presentationAttributesEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPresentationAttributes_Flood_color() {
		return (EAttribute)presentationAttributesEClass.getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPresentationAttributes_Flood_opacity() {
		return (EAttribute)presentationAttributesEClass.getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPresentationAttributes_Font_family() {
		return (EAttribute)presentationAttributesEClass.getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPresentationAttributes_Font_size() {
		return (EAttribute)presentationAttributesEClass.getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPresentationAttributes_Font_size_adjust() {
		return (EAttribute)presentationAttributesEClass.getEStructuralFeatures().get(23);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPresentationAttributes_Font_stretch() {
		return (EAttribute)presentationAttributesEClass.getEStructuralFeatures().get(24);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPresentationAttributes_Font_style() {
		return (EAttribute)presentationAttributesEClass.getEStructuralFeatures().get(25);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPresentationAttributes_Font_variant() {
		return (EAttribute)presentationAttributesEClass.getEStructuralFeatures().get(26);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPresentationAttributes_Font_weight() {
		return (EAttribute)presentationAttributesEClass.getEStructuralFeatures().get(27);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPresentationAttributes_Glyph_orientation_horizontal() {
		return (EAttribute)presentationAttributesEClass.getEStructuralFeatures().get(28);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPresentationAttributes_Glyph_orientation_vertical() {
		return (EAttribute)presentationAttributesEClass.getEStructuralFeatures().get(29);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPresentationAttributes_Image_rendering() {
		return (EAttribute)presentationAttributesEClass.getEStructuralFeatures().get(30);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPresentationAttributes_Kerning() {
		return (EAttribute)presentationAttributesEClass.getEStructuralFeatures().get(31);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPresentationAttributes_Letter_spacing() {
		return (EAttribute)presentationAttributesEClass.getEStructuralFeatures().get(32);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPresentationAttributes_Lighting_color() {
		return (EAttribute)presentationAttributesEClass.getEStructuralFeatures().get(33);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPresentationAttributes_Marker_end() {
		return (EAttribute)presentationAttributesEClass.getEStructuralFeatures().get(34);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPresentationAttributes_Marker_mid() {
		return (EAttribute)presentationAttributesEClass.getEStructuralFeatures().get(35);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPresentationAttributes_Marker_start() {
		return (EAttribute)presentationAttributesEClass.getEStructuralFeatures().get(36);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPresentationAttributes_Masks() {
		return (EAttribute)presentationAttributesEClass.getEStructuralFeatures().get(37);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPresentationAttributes_Opacity() {
		return (EAttribute)presentationAttributesEClass.getEStructuralFeatures().get(38);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPresentationAttributes_Overflow() {
		return (EAttribute)presentationAttributesEClass.getEStructuralFeatures().get(39);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPresentationAttributes_Pointer_events() {
		return (EAttribute)presentationAttributesEClass.getEStructuralFeatures().get(40);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPresentationAttributes_Shape_rendering() {
		return (EAttribute)presentationAttributesEClass.getEStructuralFeatures().get(41);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPresentationAttributes_Stop_color() {
		return (EAttribute)presentationAttributesEClass.getEStructuralFeatures().get(42);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPresentationAttributes_Stop_opacity() {
		return (EAttribute)presentationAttributesEClass.getEStructuralFeatures().get(43);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPresentationAttributes_Stroke() {
		return (EAttribute)presentationAttributesEClass.getEStructuralFeatures().get(44);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPresentationAttributes_Stroke_dasharray() {
		return (EAttribute)presentationAttributesEClass.getEStructuralFeatures().get(45);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPresentationAttributes_Stroke_dashoffset() {
		return (EAttribute)presentationAttributesEClass.getEStructuralFeatures().get(46);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPresentationAttributes_Stroke_linecap() {
		return (EAttribute)presentationAttributesEClass.getEStructuralFeatures().get(47);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPresentationAttributes_Stroke_linejoin() {
		return (EAttribute)presentationAttributesEClass.getEStructuralFeatures().get(48);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPresentationAttributes_Stroke_miterlimit() {
		return (EAttribute)presentationAttributesEClass.getEStructuralFeatures().get(49);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPresentationAttributes_Stroke_opacity() {
		return (EAttribute)presentationAttributesEClass.getEStructuralFeatures().get(50);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPresentationAttributes_Stroke_width() {
		return (EAttribute)presentationAttributesEClass.getEStructuralFeatures().get(51);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPresentationAttributes_Text_anchor() {
		return (EAttribute)presentationAttributesEClass.getEStructuralFeatures().get(52);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPresentationAttributes_Text_decoration() {
		return (EAttribute)presentationAttributesEClass.getEStructuralFeatures().get(53);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPresentationAttributes_Text_rendering() {
		return (EAttribute)presentationAttributesEClass.getEStructuralFeatures().get(54);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPresentationAttributes_Unicode_bidi() {
		return (EAttribute)presentationAttributesEClass.getEStructuralFeatures().get(55);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPresentationAttributes_Visibility() {
		return (EAttribute)presentationAttributesEClass.getEStructuralFeatures().get(56);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPresentationAttributes_Word_spacing() {
		return (EAttribute)presentationAttributesEClass.getEStructuralFeatures().get(57);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPresentationAttributes_Writing_mode() {
		return (EAttribute)presentationAttributesEClass.getEStructuralFeatures().get(58);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXLinkAttributes() {
		return xLinkAttributesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXLinkAttributes_Xlink__href() {
		return (EAttribute)xLinkAttributesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXLinkAttributes_Xlink__show() {
		return (EAttribute)xLinkAttributesEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXLinkAttributes_Xlink__actuate() {
		return (EAttribute)xLinkAttributesEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXLinkAttributes_Xlink__type() {
		return (EAttribute)xLinkAttributesEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXLinkAttributes_Xlink__role() {
		return (EAttribute)xLinkAttributesEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXLinkAttributes_Xlink__arcrole() {
		return (EAttribute)xLinkAttributesEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXLinkAttributes_Xlink__title() {
		return (EAttribute)xLinkAttributesEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXLinkAttributes_ResolvedInstance() {
		return (EReference)xLinkAttributesEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFilterPrimitiveAttributes() {
		return filterPrimitiveAttributesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFilterPrimitiveAttributes_X() {
		return (EAttribute)filterPrimitiveAttributesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFilterPrimitiveAttributes_Y() {
		return (EAttribute)filterPrimitiveAttributesEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFilterPrimitiveAttributes_Width() {
		return (EAttribute)filterPrimitiveAttributesEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFilterPrimitiveAttributes_Height() {
		return (EAttribute)filterPrimitiveAttributesEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFilterPrimitiveAttributes_Result() {
		return (EAttribute)filterPrimitiveAttributesEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFilterPrimitiveAttributes_In() {
		return (EAttribute)filterPrimitiveAttributesEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass get____ELEMENTES____() {
		return ____ELEMENTES____EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSvgSvgElement() {
		return svgSvgElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgSvgElement_Class() {
		return (EAttribute)svgSvgElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgSvgElement_Style() {
		return (EAttribute)svgSvgElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgSvgElement_ExternalResourcesRequired() {
		return (EAttribute)svgSvgElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgSvgElement_X() {
		return (EAttribute)svgSvgElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgSvgElement_Y() {
		return (EAttribute)svgSvgElementEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgSvgElement_Width() {
		return (EAttribute)svgSvgElementEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgSvgElement_Height() {
		return (EAttribute)svgSvgElementEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgSvgElement_ViewBox() {
		return (EAttribute)svgSvgElementEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgSvgElement_PreserveAspectRatio() {
		return (EAttribute)svgSvgElementEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgSvgElement_ZoomAndPan() {
		return (EAttribute)svgSvgElementEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgSvgElement_Version() {
		return (EAttribute)svgSvgElementEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgSvgElement_BaseProfile() {
		return (EAttribute)svgSvgElementEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgSvgElement_ContentScriptType() {
		return (EAttribute)svgSvgElementEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgSvgElement_ContentStyleType() {
		return (EAttribute)svgSvgElementEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgSvgElement_StyleSheet() {
		return (EAttribute)svgSvgElementEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSvgGElement() {
		return svgGElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgGElement_Class() {
		return (EAttribute)svgGElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgGElement_Style() {
		return (EAttribute)svgGElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgGElement_ExternalResourcesRequired() {
		return (EAttribute)svgGElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgGElement_Transform() {
		return (EAttribute)svgGElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgGElement_X() {
		return (EAttribute)svgGElementEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgGElement_Y() {
		return (EAttribute)svgGElementEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSvgDefsElement() {
		return svgDefsElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgDefsElement_Class() {
		return (EAttribute)svgDefsElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgDefsElement_Style() {
		return (EAttribute)svgDefsElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgDefsElement_ExternalResourcesRequired() {
		return (EAttribute)svgDefsElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgDefsElement_Transform() {
		return (EAttribute)svgDefsElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSvgDescElement() {
		return svgDescElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgDescElement_Class() {
		return (EAttribute)svgDescElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgDescElement_Style() {
		return (EAttribute)svgDescElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSvgTitleElement() {
		return svgTitleElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgTitleElement_Class() {
		return (EAttribute)svgTitleElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgTitleElement_Style() {
		return (EAttribute)svgTitleElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSvgSymbolElement() {
		return svgSymbolElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgSymbolElement_Class() {
		return (EAttribute)svgSymbolElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgSymbolElement_Style() {
		return (EAttribute)svgSymbolElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgSymbolElement_ExternalResourcesRequired() {
		return (EAttribute)svgSymbolElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgSymbolElement_ViewBox() {
		return (EAttribute)svgSymbolElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgSymbolElement_PreserveAspectRatio() {
		return (EAttribute)svgSymbolElementEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSvgUseElement() {
		return svgUseElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgUseElement_Class() {
		return (EAttribute)svgUseElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgUseElement_Style() {
		return (EAttribute)svgUseElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgUseElement_ExternalResourcesRequired() {
		return (EAttribute)svgUseElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgUseElement_Transform() {
		return (EAttribute)svgUseElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgUseElement_Width() {
		return (EAttribute)svgUseElementEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgUseElement_Height() {
		return (EAttribute)svgUseElementEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgUseElement_X() {
		return (EAttribute)svgUseElementEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgUseElement_Y() {
		return (EAttribute)svgUseElementEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSvgImageElement() {
		return svgImageElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgImageElement_Class() {
		return (EAttribute)svgImageElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgImageElement_Style() {
		return (EAttribute)svgImageElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgImageElement_ExternalResourcesRequired() {
		return (EAttribute)svgImageElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgImageElement_PreserveAspectRatio() {
		return (EAttribute)svgImageElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgImageElement_Transform() {
		return (EAttribute)svgImageElementEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgImageElement_X() {
		return (EAttribute)svgImageElementEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgImageElement_Y() {
		return (EAttribute)svgImageElementEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgImageElement_Width() {
		return (EAttribute)svgImageElementEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgImageElement_Height() {
		return (EAttribute)svgImageElementEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSvgSwitchElement() {
		return svgSwitchElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgSwitchElement_Class() {
		return (EAttribute)svgSwitchElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgSwitchElement_Style() {
		return (EAttribute)svgSwitchElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgSwitchElement_ExternalResourcesRequired() {
		return (EAttribute)svgSwitchElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgSwitchElement_Transform() {
		return (EAttribute)svgSwitchElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSvgPathElement() {
		return svgPathElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgPathElement_Class() {
		return (EAttribute)svgPathElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgPathElement_Style() {
		return (EAttribute)svgPathElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgPathElement_ExternalResourcesRequired() {
		return (EAttribute)svgPathElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgPathElement_Transform() {
		return (EAttribute)svgPathElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgPathElement_D() {
		return (EAttribute)svgPathElementEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgPathElement_PathLength() {
		return (EAttribute)svgPathElementEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSvgRectElement() {
		return svgRectElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgRectElement_Class() {
		return (EAttribute)svgRectElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgRectElement_Style() {
		return (EAttribute)svgRectElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgRectElement_ExternalResourcesRequired() {
		return (EAttribute)svgRectElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgRectElement_Transform() {
		return (EAttribute)svgRectElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgRectElement_X() {
		return (EAttribute)svgRectElementEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgRectElement_Y() {
		return (EAttribute)svgRectElementEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgRectElement_Width() {
		return (EAttribute)svgRectElementEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgRectElement_Height() {
		return (EAttribute)svgRectElementEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgRectElement_Rx() {
		return (EAttribute)svgRectElementEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgRectElement_Ry() {
		return (EAttribute)svgRectElementEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSvgCircleElement() {
		return svgCircleElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgCircleElement_Class() {
		return (EAttribute)svgCircleElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgCircleElement_Style() {
		return (EAttribute)svgCircleElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgCircleElement_ExternalResourcesRequired() {
		return (EAttribute)svgCircleElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgCircleElement_Transform() {
		return (EAttribute)svgCircleElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgCircleElement_Cx() {
		return (EAttribute)svgCircleElementEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgCircleElement_Cy() {
		return (EAttribute)svgCircleElementEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgCircleElement_R() {
		return (EAttribute)svgCircleElementEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSvgEllipseElement() {
		return svgEllipseElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgEllipseElement_Class() {
		return (EAttribute)svgEllipseElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgEllipseElement_Style() {
		return (EAttribute)svgEllipseElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgEllipseElement_ExternalResourcesRequired() {
		return (EAttribute)svgEllipseElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgEllipseElement_Transform() {
		return (EAttribute)svgEllipseElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgEllipseElement_Cx() {
		return (EAttribute)svgEllipseElementEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgEllipseElement_Cy() {
		return (EAttribute)svgEllipseElementEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgEllipseElement_Rx() {
		return (EAttribute)svgEllipseElementEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgEllipseElement_Ry() {
		return (EAttribute)svgEllipseElementEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSvgLineElement() {
		return svgLineElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgLineElement_Class() {
		return (EAttribute)svgLineElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgLineElement_Style() {
		return (EAttribute)svgLineElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgLineElement_ExternalResourcesRequired() {
		return (EAttribute)svgLineElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgLineElement_Transform() {
		return (EAttribute)svgLineElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgLineElement_X1() {
		return (EAttribute)svgLineElementEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgLineElement_Y1() {
		return (EAttribute)svgLineElementEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgLineElement_X2() {
		return (EAttribute)svgLineElementEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgLineElement_Y2() {
		return (EAttribute)svgLineElementEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSvgPolylineElement() {
		return svgPolylineElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgPolylineElement_Class() {
		return (EAttribute)svgPolylineElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgPolylineElement_Style() {
		return (EAttribute)svgPolylineElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgPolylineElement_ExternalResourcesRequired() {
		return (EAttribute)svgPolylineElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgPolylineElement_Transform() {
		return (EAttribute)svgPolylineElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgPolylineElement_Points() {
		return (EAttribute)svgPolylineElementEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSvgPolygonElement() {
		return svgPolygonElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgPolygonElement_Class() {
		return (EAttribute)svgPolygonElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgPolygonElement_Style() {
		return (EAttribute)svgPolygonElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgPolygonElement_ExternalResourcesRequired() {
		return (EAttribute)svgPolygonElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgPolygonElement_Transform() {
		return (EAttribute)svgPolygonElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgPolygonElement_Points() {
		return (EAttribute)svgPolygonElementEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSvgTextElement() {
		return svgTextElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgTextElement_Class() {
		return (EAttribute)svgTextElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgTextElement_Style() {
		return (EAttribute)svgTextElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgTextElement_ExternalResourcesRequired() {
		return (EAttribute)svgTextElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgTextElement_Transform() {
		return (EAttribute)svgTextElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgTextElement_LengthAdjust() {
		return (EAttribute)svgTextElementEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgTextElement_X() {
		return (EAttribute)svgTextElementEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgTextElement_Y() {
		return (EAttribute)svgTextElementEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgTextElement_Dx() {
		return (EAttribute)svgTextElementEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgTextElement_Dy() {
		return (EAttribute)svgTextElementEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgTextElement_Rotate() {
		return (EAttribute)svgTextElementEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgTextElement_TextLength() {
		return (EAttribute)svgTextElementEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgTextElement_TextContent() {
		return (EAttribute)svgTextElementEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSvgTspanElement() {
		return svgTspanElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgTspanElement_Class() {
		return (EAttribute)svgTspanElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgTspanElement_Style() {
		return (EAttribute)svgTspanElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgTspanElement_ExternalResourcesRequired() {
		return (EAttribute)svgTspanElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgTspanElement_X() {
		return (EAttribute)svgTspanElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgTspanElement_Y() {
		return (EAttribute)svgTspanElementEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgTspanElement_Dx() {
		return (EAttribute)svgTspanElementEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgTspanElement_Dy() {
		return (EAttribute)svgTspanElementEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgTspanElement_Rotate() {
		return (EAttribute)svgTspanElementEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgTspanElement_TextLength() {
		return (EAttribute)svgTspanElementEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgTspanElement_LengthAdjust() {
		return (EAttribute)svgTspanElementEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSvgTrefElement() {
		return svgTrefElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgTrefElement_Class() {
		return (EAttribute)svgTrefElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgTrefElement_Style() {
		return (EAttribute)svgTrefElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgTrefElement_ExternalResourcesRequired() {
		return (EAttribute)svgTrefElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSvgTextPathElement() {
		return svgTextPathElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgTextPathElement_Class() {
		return (EAttribute)svgTextPathElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgTextPathElement_Style() {
		return (EAttribute)svgTextPathElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgTextPathElement_ExternalResourcesRequired() {
		return (EAttribute)svgTextPathElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgTextPathElement_StartOffset() {
		return (EAttribute)svgTextPathElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgTextPathElement_Method() {
		return (EAttribute)svgTextPathElementEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgTextPathElement_Spacing() {
		return (EAttribute)svgTextPathElementEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSvgAltGlyphElement() {
		return svgAltGlyphElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgAltGlyphElement_Class() {
		return (EAttribute)svgAltGlyphElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgAltGlyphElement_Style() {
		return (EAttribute)svgAltGlyphElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgAltGlyphElement_ExternalResourcesRequired() {
		return (EAttribute)svgAltGlyphElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgAltGlyphElement_X() {
		return (EAttribute)svgAltGlyphElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgAltGlyphElement_Y() {
		return (EAttribute)svgAltGlyphElementEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgAltGlyphElement_Dx() {
		return (EAttribute)svgAltGlyphElementEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgAltGlyphElement_Dy() {
		return (EAttribute)svgAltGlyphElementEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgAltGlyphElement_GlyphRef() {
		return (EAttribute)svgAltGlyphElementEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgAltGlyphElement_Format() {
		return (EAttribute)svgAltGlyphElementEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgAltGlyphElement_Rotate() {
		return (EAttribute)svgAltGlyphElementEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSvgAltGlyphDefElement() {
		return svgAltGlyphDefElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSvgAltGlyphItemElement() {
		return svgAltGlyphItemElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSvgAltGlyphRefElement() {
		return svgAltGlyphRefElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgAltGlyphRefElement_Class() {
		return (EAttribute)svgAltGlyphRefElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgAltGlyphRefElement_Style() {
		return (EAttribute)svgAltGlyphRefElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgAltGlyphRefElement_X() {
		return (EAttribute)svgAltGlyphRefElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgAltGlyphRefElement_Y() {
		return (EAttribute)svgAltGlyphRefElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgAltGlyphRefElement_Dx() {
		return (EAttribute)svgAltGlyphRefElementEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgAltGlyphRefElement_Dy() {
		return (EAttribute)svgAltGlyphRefElementEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgAltGlyphRefElement_GlyphRef() {
		return (EAttribute)svgAltGlyphRefElementEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgAltGlyphRefElement_Format() {
		return (EAttribute)svgAltGlyphRefElementEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSvgMarkerElement() {
		return svgMarkerElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgMarkerElement_Class() {
		return (EAttribute)svgMarkerElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgMarkerElement_Style() {
		return (EAttribute)svgMarkerElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgMarkerElement_ExternalResourcesRequired() {
		return (EAttribute)svgMarkerElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgMarkerElement_ViewBox() {
		return (EAttribute)svgMarkerElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgMarkerElement_PreserveAspectRatio() {
		return (EAttribute)svgMarkerElementEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgMarkerElement_RefX() {
		return (EAttribute)svgMarkerElementEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgMarkerElement_RefY() {
		return (EAttribute)svgMarkerElementEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgMarkerElement_MarkerUnits() {
		return (EAttribute)svgMarkerElementEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgMarkerElement_MarkerWidth() {
		return (EAttribute)svgMarkerElementEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgMarkerElement_MarkerHeight() {
		return (EAttribute)svgMarkerElementEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgMarkerElement_Orient() {
		return (EAttribute)svgMarkerElementEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSvgColorProfileElement() {
		return svgColorProfileElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgColorProfileElement_Local() {
		return (EAttribute)svgColorProfileElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgColorProfileElement_Name() {
		return (EAttribute)svgColorProfileElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgColorProfileElement_Rendering_intent() {
		return (EAttribute)svgColorProfileElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSvgLinearGradientElement() {
		return svgLinearGradientElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgLinearGradientElement_Class() {
		return (EAttribute)svgLinearGradientElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgLinearGradientElement_Style() {
		return (EAttribute)svgLinearGradientElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgLinearGradientElement_ExternalResourcesRequired() {
		return (EAttribute)svgLinearGradientElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgLinearGradientElement_X1() {
		return (EAttribute)svgLinearGradientElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgLinearGradientElement_Y1() {
		return (EAttribute)svgLinearGradientElementEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgLinearGradientElement_X2() {
		return (EAttribute)svgLinearGradientElementEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgLinearGradientElement_Y2() {
		return (EAttribute)svgLinearGradientElementEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgLinearGradientElement_GradientUnits() {
		return (EAttribute)svgLinearGradientElementEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgLinearGradientElement_SpreadMethod() {
		return (EAttribute)svgLinearGradientElementEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgLinearGradientElement_GradientTransform() {
		return (EAttribute)svgLinearGradientElementEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSvgRadialGradientElement() {
		return svgRadialGradientElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgRadialGradientElement_Class() {
		return (EAttribute)svgRadialGradientElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgRadialGradientElement_Style() {
		return (EAttribute)svgRadialGradientElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgRadialGradientElement_ExternalResourcesRequired() {
		return (EAttribute)svgRadialGradientElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgRadialGradientElement_Cx() {
		return (EAttribute)svgRadialGradientElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgRadialGradientElement_Cy() {
		return (EAttribute)svgRadialGradientElementEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgRadialGradientElement_R() {
		return (EAttribute)svgRadialGradientElementEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgRadialGradientElement_Fx() {
		return (EAttribute)svgRadialGradientElementEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgRadialGradientElement_Fy() {
		return (EAttribute)svgRadialGradientElementEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgRadialGradientElement_SpreadMethod() {
		return (EAttribute)svgRadialGradientElementEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgRadialGradientElement_GradientUnits() {
		return (EAttribute)svgRadialGradientElementEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgRadialGradientElement_GradientTransform() {
		return (EAttribute)svgRadialGradientElementEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSvgStopElement() {
		return svgStopElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgStopElement_Class() {
		return (EAttribute)svgStopElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgStopElement_Style() {
		return (EAttribute)svgStopElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgStopElement_Offset() {
		return (EAttribute)svgStopElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSvgPatternElement() {
		return svgPatternElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgPatternElement_Class() {
		return (EAttribute)svgPatternElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgPatternElement_Style() {
		return (EAttribute)svgPatternElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgPatternElement_ExternalResourcesRequired() {
		return (EAttribute)svgPatternElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgPatternElement_ViewBox() {
		return (EAttribute)svgPatternElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgPatternElement_PreserveAspectRatio() {
		return (EAttribute)svgPatternElementEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgPatternElement_X() {
		return (EAttribute)svgPatternElementEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgPatternElement_Y() {
		return (EAttribute)svgPatternElementEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgPatternElement_Width() {
		return (EAttribute)svgPatternElementEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgPatternElement_Height() {
		return (EAttribute)svgPatternElementEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgPatternElement_PatternUnits() {
		return (EAttribute)svgPatternElementEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgPatternElement_PatternContentUnits() {
		return (EAttribute)svgPatternElementEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgPatternElement_PatternTransform() {
		return (EAttribute)svgPatternElementEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSvgClipPathElement() {
		return svgClipPathElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgClipPathElement_Class() {
		return (EAttribute)svgClipPathElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgClipPathElement_Style() {
		return (EAttribute)svgClipPathElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgClipPathElement_ExternalResourcesRequired() {
		return (EAttribute)svgClipPathElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgClipPathElement_Transform() {
		return (EAttribute)svgClipPathElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgClipPathElement_ClipPathUnits() {
		return (EAttribute)svgClipPathElementEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSvgMaskElement() {
		return svgMaskElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgMaskElement_Class() {
		return (EAttribute)svgMaskElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgMaskElement_Style() {
		return (EAttribute)svgMaskElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgMaskElement_ExternalResourcesRequired() {
		return (EAttribute)svgMaskElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgMaskElement_X() {
		return (EAttribute)svgMaskElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgMaskElement_Y() {
		return (EAttribute)svgMaskElementEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgMaskElement_Width() {
		return (EAttribute)svgMaskElementEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgMaskElement_Height() {
		return (EAttribute)svgMaskElementEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgMaskElement_MaskUnits() {
		return (EAttribute)svgMaskElementEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgMaskElement_MaskContentUnits() {
		return (EAttribute)svgMaskElementEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSvgFilterElement() {
		return svgFilterElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgFilterElement_Class() {
		return (EAttribute)svgFilterElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgFilterElement_Style() {
		return (EAttribute)svgFilterElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgFilterElement_ExternalResourcesRequired() {
		return (EAttribute)svgFilterElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgFilterElement_X() {
		return (EAttribute)svgFilterElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgFilterElement_Y() {
		return (EAttribute)svgFilterElementEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgFilterElement_Width() {
		return (EAttribute)svgFilterElementEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgFilterElement_Height() {
		return (EAttribute)svgFilterElementEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgFilterElement_FilterRes() {
		return (EAttribute)svgFilterElementEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgFilterElement_FilterUnits() {
		return (EAttribute)svgFilterElementEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgFilterElement_PrimitiveUnits() {
		return (EAttribute)svgFilterElementEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSvgFeDistantLightElement() {
		return svgFeDistantLightElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgFeDistantLightElement_Azimuth() {
		return (EAttribute)svgFeDistantLightElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgFeDistantLightElement_Elevation() {
		return (EAttribute)svgFeDistantLightElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSvgFePointLightElement() {
		return svgFePointLightElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgFePointLightElement_X() {
		return (EAttribute)svgFePointLightElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgFePointLightElement_Y() {
		return (EAttribute)svgFePointLightElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgFePointLightElement_Z() {
		return (EAttribute)svgFePointLightElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSvgFeSpotLightElement() {
		return svgFeSpotLightElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgFeSpotLightElement_X() {
		return (EAttribute)svgFeSpotLightElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgFeSpotLightElement_Y() {
		return (EAttribute)svgFeSpotLightElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgFeSpotLightElement_Z() {
		return (EAttribute)svgFeSpotLightElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgFeSpotLightElement_PointsAtX() {
		return (EAttribute)svgFeSpotLightElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgFeSpotLightElement_PointsAtY() {
		return (EAttribute)svgFeSpotLightElementEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgFeSpotLightElement_PointsAtZ() {
		return (EAttribute)svgFeSpotLightElementEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgFeSpotLightElement_SpecularExponent() {
		return (EAttribute)svgFeSpotLightElementEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgFeSpotLightElement_LimitingConeAngle() {
		return (EAttribute)svgFeSpotLightElementEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSvgFeBlendElement() {
		return svgFeBlendElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgFeBlendElement_Class() {
		return (EAttribute)svgFeBlendElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgFeBlendElement_Style() {
		return (EAttribute)svgFeBlendElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgFeBlendElement_In2() {
		return (EAttribute)svgFeBlendElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgFeBlendElement_Mode() {
		return (EAttribute)svgFeBlendElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSvgFeColorMatrixElement() {
		return svgFeColorMatrixElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgFeColorMatrixElement_Class() {
		return (EAttribute)svgFeColorMatrixElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgFeColorMatrixElement_Style() {
		return (EAttribute)svgFeColorMatrixElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgFeColorMatrixElement_Type() {
		return (EAttribute)svgFeColorMatrixElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgFeColorMatrixElement_Values() {
		return (EAttribute)svgFeColorMatrixElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSvgFeComponentTransferElement() {
		return svgFeComponentTransferElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgFeComponentTransferElement_Class() {
		return (EAttribute)svgFeComponentTransferElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgFeComponentTransferElement_Style() {
		return (EAttribute)svgFeComponentTransferElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSvgFeFuncRElement() {
		return svgFeFuncRElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSvgFeFuncGElement() {
		return svgFeFuncGElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSvgFeFuncBElement() {
		return svgFeFuncBElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSvgFeFuncAElement() {
		return svgFeFuncAElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSvgFeCompositeElement() {
		return svgFeCompositeElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgFeCompositeElement_Class() {
		return (EAttribute)svgFeCompositeElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgFeCompositeElement_Style() {
		return (EAttribute)svgFeCompositeElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgFeCompositeElement_In2() {
		return (EAttribute)svgFeCompositeElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgFeCompositeElement_Operator() {
		return (EAttribute)svgFeCompositeElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgFeCompositeElement_K1() {
		return (EAttribute)svgFeCompositeElementEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgFeCompositeElement_K2() {
		return (EAttribute)svgFeCompositeElementEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgFeCompositeElement_K3() {
		return (EAttribute)svgFeCompositeElementEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgFeCompositeElement_K4() {
		return (EAttribute)svgFeCompositeElementEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSvgFeConvolveMatrixElement() {
		return svgFeConvolveMatrixElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgFeConvolveMatrixElement_Class() {
		return (EAttribute)svgFeConvolveMatrixElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgFeConvolveMatrixElement_Style() {
		return (EAttribute)svgFeConvolveMatrixElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgFeConvolveMatrixElement_Order() {
		return (EAttribute)svgFeConvolveMatrixElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgFeConvolveMatrixElement_KernelMatrix() {
		return (EAttribute)svgFeConvolveMatrixElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgFeConvolveMatrixElement_Divisor() {
		return (EAttribute)svgFeConvolveMatrixElementEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgFeConvolveMatrixElement_Bias() {
		return (EAttribute)svgFeConvolveMatrixElementEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgFeConvolveMatrixElement_TargetX() {
		return (EAttribute)svgFeConvolveMatrixElementEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgFeConvolveMatrixElement_TargetY() {
		return (EAttribute)svgFeConvolveMatrixElementEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgFeConvolveMatrixElement_EdgeMode() {
		return (EAttribute)svgFeConvolveMatrixElementEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgFeConvolveMatrixElement_KernelUnitLength() {
		return (EAttribute)svgFeConvolveMatrixElementEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgFeConvolveMatrixElement_PreserveAlpha() {
		return (EAttribute)svgFeConvolveMatrixElementEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSvgFeDiffuseLightingElement() {
		return svgFeDiffuseLightingElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgFeDiffuseLightingElement_Class() {
		return (EAttribute)svgFeDiffuseLightingElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgFeDiffuseLightingElement_Style() {
		return (EAttribute)svgFeDiffuseLightingElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgFeDiffuseLightingElement_SurfaceScale() {
		return (EAttribute)svgFeDiffuseLightingElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgFeDiffuseLightingElement_DiffuseConstant() {
		return (EAttribute)svgFeDiffuseLightingElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgFeDiffuseLightingElement_KernelUnitLength() {
		return (EAttribute)svgFeDiffuseLightingElementEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSvgFeDisplacementMapElement() {
		return svgFeDisplacementMapElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgFeDisplacementMapElement_Class() {
		return (EAttribute)svgFeDisplacementMapElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgFeDisplacementMapElement_Style() {
		return (EAttribute)svgFeDisplacementMapElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgFeDisplacementMapElement_In2() {
		return (EAttribute)svgFeDisplacementMapElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgFeDisplacementMapElement_Scale() {
		return (EAttribute)svgFeDisplacementMapElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgFeDisplacementMapElement_XChannelSelector() {
		return (EAttribute)svgFeDisplacementMapElementEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgFeDisplacementMapElement_YChannelSelector() {
		return (EAttribute)svgFeDisplacementMapElementEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSvgFeFloodElement() {
		return svgFeFloodElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgFeFloodElement_Class() {
		return (EAttribute)svgFeFloodElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgFeFloodElement_Style() {
		return (EAttribute)svgFeFloodElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSvgFeGaussianBlurElement() {
		return svgFeGaussianBlurElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgFeGaussianBlurElement_Class() {
		return (EAttribute)svgFeGaussianBlurElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgFeGaussianBlurElement_Style() {
		return (EAttribute)svgFeGaussianBlurElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgFeGaussianBlurElement_StdDeviation() {
		return (EAttribute)svgFeGaussianBlurElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSvgFeImageElement() {
		return svgFeImageElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgFeImageElement_Class() {
		return (EAttribute)svgFeImageElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgFeImageElement_Style() {
		return (EAttribute)svgFeImageElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgFeImageElement_ExternalResourcesRequired() {
		return (EAttribute)svgFeImageElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgFeImageElement_PreserveAspectRatio() {
		return (EAttribute)svgFeImageElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSvgFeMergeElement() {
		return svgFeMergeElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgFeMergeElement_Class() {
		return (EAttribute)svgFeMergeElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgFeMergeElement_Style() {
		return (EAttribute)svgFeMergeElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSvgFeMergeNodeElement() {
		return svgFeMergeNodeElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSvgFeMorphologyElement() {
		return svgFeMorphologyElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgFeMorphologyElement_Class() {
		return (EAttribute)svgFeMorphologyElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgFeMorphologyElement_Style() {
		return (EAttribute)svgFeMorphologyElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgFeMorphologyElement_Operator() {
		return (EAttribute)svgFeMorphologyElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgFeMorphologyElement_Radius() {
		return (EAttribute)svgFeMorphologyElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSvgFeOffsetElement() {
		return svgFeOffsetElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgFeOffsetElement_Class() {
		return (EAttribute)svgFeOffsetElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgFeOffsetElement_Style() {
		return (EAttribute)svgFeOffsetElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgFeOffsetElement_Dx() {
		return (EAttribute)svgFeOffsetElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgFeOffsetElement_Dy() {
		return (EAttribute)svgFeOffsetElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSvgFeSpecularLightingElement() {
		return svgFeSpecularLightingElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgFeSpecularLightingElement_Class() {
		return (EAttribute)svgFeSpecularLightingElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgFeSpecularLightingElement_Style() {
		return (EAttribute)svgFeSpecularLightingElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgFeSpecularLightingElement_SurfaceScale() {
		return (EAttribute)svgFeSpecularLightingElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgFeSpecularLightingElement_SpecularConstant() {
		return (EAttribute)svgFeSpecularLightingElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgFeSpecularLightingElement_SpecularExponent() {
		return (EAttribute)svgFeSpecularLightingElementEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgFeSpecularLightingElement_KernelUnitLength() {
		return (EAttribute)svgFeSpecularLightingElementEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSvgFeTileElement() {
		return svgFeTileElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgFeTileElement_Class() {
		return (EAttribute)svgFeTileElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgFeTileElement_Style() {
		return (EAttribute)svgFeTileElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSvgFeTurbulenceElement() {
		return svgFeTurbulenceElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgFeTurbulenceElement_Class() {
		return (EAttribute)svgFeTurbulenceElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgFeTurbulenceElement_Style() {
		return (EAttribute)svgFeTurbulenceElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgFeTurbulenceElement_BaseFrequency() {
		return (EAttribute)svgFeTurbulenceElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgFeTurbulenceElement_NumOctaves() {
		return (EAttribute)svgFeTurbulenceElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgFeTurbulenceElement_Seed() {
		return (EAttribute)svgFeTurbulenceElementEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgFeTurbulenceElement_StitchTiles() {
		return (EAttribute)svgFeTurbulenceElementEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSvgFeTurbulenceElement_Type() {
		return (EAttribute)svgFeTurbulenceElementEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSvgAnimateElement() {
		return svgAnimateElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSvgMetadataElement() {
		return svgMetadataElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getAlignment_baseline() {
		return alignment_baselineEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getClip_rule() {
		return clip_ruleEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getColor_interpolation() {
		return color_interpolationEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getColor_interpolation_filters() {
		return color_interpolation_filtersEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getColor_rendering() {
		return color_renderingEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getDirection() {
		return directionEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getDisplay() {
		return displayEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getDominant_baseline() {
		return dominant_baselineEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getFill_rule() {
		return fill_ruleEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getFont_stretch() {
		return font_stretchEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getFont_style() {
		return font_styleEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getFont_variant() {
		return font_variantEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getFont_weight() {
		return font_weightEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getImage_rendering() {
		return image_renderingEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getOverflow() {
		return overflowEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getPointer_events() {
		return pointer_eventsEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getShape_rendering() {
		return shape_renderingEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getStroke_linecap() {
		return stroke_linecapEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getStroke_linejoin() {
		return stroke_linejoinEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getText_anchor() {
		return text_anchorEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getText_rendering() {
		return text_renderingEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getUnicode_bidi() {
		return unicode_bidiEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getVisibility() {
		return visibilityEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getWriting_mode() {
		return writing_modeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getZoomAndPan() {
		return zoomAndPanEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getLengthAdjust() {
		return lengthAdjustEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getMethod() {
		return methodEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getSpacing() {
		return spacingEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getMarkerUnits() {
		return markerUnitsEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getRendering_intent() {
		return rendering_intentEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getGradientUnits() {
		return gradientUnitsEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getSpreadMethod() {
		return spreadMethodEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getPatternUnits() {
		return patternUnitsEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getClipPathUnits() {
		return clipPathUnitsEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getMaskUnits() {
		return maskUnitsEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getFilterUnits() {
		return filterUnitsEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getBlendMode() {
		return blendModeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getColorMatrixType() {
		return colorMatrixTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getCompositeOperator() {
		return compositeOperatorEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getConvolveMatrixEdgeMode() {
		return convolveMatrixEdgeModeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getChannelSelector() {
		return channelSelectorEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getMorphologyOperator() {
		return morphologyOperatorEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getStitchTiles() {
		return stitchTilesEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getTurbulenceType() {
		return turbulenceTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getLength() {
		return lengthEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getAngle() {
		return angleEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getPercentage() {
		return percentageEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getShape() {
		return shapeEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getFunciri() {
		return funciriEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getColor() {
		return colorEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getPaint() {
		return paintEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getOpacity_value() {
		return opacity_valueEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getBaseline_shift() {
		return baseline_shiftEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getClip() {
		return clipEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getClip_path() {
		return clip_pathEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getColor_profile() {
		return color_profileEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getCursor() {
		return cursorEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getEnable_background() {
		return enable_backgroundEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getFill() {
		return fillEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getFill_opacity() {
		return fill_opacityEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getFilter() {
		return filterEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getFlood_color() {
		return flood_colorEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getFlood_opacity() {
		return flood_opacityEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getFont_family() {
		return font_familyEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getFont_size() {
		return font_sizeEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getFont_size_adjust() {
		return font_size_adjustEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getGlyph_orientation_horizontal() {
		return glyph_orientation_horizontalEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getGlyph_orientation_vertical() {
		return glyph_orientation_verticalEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getKerning() {
		return kerningEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getLetter_spacing() {
		return letter_spacingEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getLighting_color() {
		return lighting_colorEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getMarker_end() {
		return marker_endEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getMarker_mid() {
		return marker_midEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getMarker_start() {
		return marker_startEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getMasks() {
		return masksEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getOpacity() {
		return opacityEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getStop_color() {
		return stop_colorEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getStop_opacity() {
		return stop_opacityEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getStroke() {
		return strokeEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getStroke_dasharray() {
		return stroke_dasharrayEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getStroke_dashoffset() {
		return stroke_dashoffsetEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getStroke_miterlimit() {
		return stroke_miterlimitEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getStroke_opacity() {
		return stroke_opacityEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getStroke_width() {
		return stroke_widthEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getText_decoration() {
		return text_decorationEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getWord_spacing() {
		return word_spacingEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getCoordinate() {
		return coordinateEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getViewBox() {
		return viewBoxEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getPreserveAspectRatio() {
		return preserveAspectRatioEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getNumber() {
		return numberEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getTransform() {
		return transformEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getPathData() {
		return pathDataEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getListOfPoints() {
		return listOfPointsEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getListOfLengths() {
		return listOfLengthsEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getListOfNumbers() {
		return listOfNumbersEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getListOfCoordinates() {
		return listOfCoordinatesEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getName_() {
		return nameEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getNumberOptionalNumber() {
		return numberOptionalNumberEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getTransformList() {
		return transformListEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SvgFactory getSvgFactory() {
		return (SvgFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		contentElementEClass = createEClass(CONTENT_ELEMENT);
		createEReference(contentElementEClass, CONTENT_ELEMENT__CHILDREN);

		containerElementEClass = createEClass(CONTAINER_ELEMENT);

		structuralElementEClass = createEClass(STRUCTURAL_ELEMENT);

		svgElementEClass = createEClass(SVG_ELEMENT);

		descriptiveElementEClass = createEClass(DESCRIPTIVE_ELEMENT);

		graphicsElementEClass = createEClass(GRAPHICS_ELEMENT);

		graphicsReferencingElementEClass = createEClass(GRAPHICS_REFERENCING_ELEMENT);

		shapeElementEClass = createEClass(SHAPE_ELEMENT);

		basicShapeElementEClass = createEClass(BASIC_SHAPE_ELEMENT);

		textContentElementEClass = createEClass(TEXT_CONTENT_ELEMENT);

		textContentChildElementEClass = createEClass(TEXT_CONTENT_CHILD_ELEMENT);

		gradientElementEClass = createEClass(GRADIENT_ELEMENT);

		lightSourceElementEClass = createEClass(LIGHT_SOURCE_ELEMENT);

		filterPrimitiveElementEClass = createEClass(FILTER_PRIMITIVE_ELEMENT);

		animationElementEClass = createEClass(ANIMATION_ELEMENT);

		____ENUMS____EClass = createEClass(_ENUMS_);

		____DATATYPES____EClass = createEClass(_DATATYPES_);

		____ATTRIBUTES____EClass = createEClass(_ATTRIBUTES_);

		conditionalProcessingAttributesEClass = createEClass(CONDITIONAL_PROCESSING_ATTRIBUTES);
		createEAttribute(conditionalProcessingAttributesEClass, CONDITIONAL_PROCESSING_ATTRIBUTES__REQUIRED_FEATURES);
		createEAttribute(conditionalProcessingAttributesEClass, CONDITIONAL_PROCESSING_ATTRIBUTES__REQUIRED_EXTENSIONS);
		createEAttribute(conditionalProcessingAttributesEClass, CONDITIONAL_PROCESSING_ATTRIBUTES__SYSTEM_LANGUAGE);

		coreAttributesEClass = createEClass(CORE_ATTRIBUTES);
		createEAttribute(coreAttributesEClass, CORE_ATTRIBUTES__ID);
		createEAttribute(coreAttributesEClass, CORE_ATTRIBUTES__XML_BASE);
		createEAttribute(coreAttributesEClass, CORE_ATTRIBUTES__XML_LANG);
		createEAttribute(coreAttributesEClass, CORE_ATTRIBUTES__XML_SPACE);

		documentEventAttributesEClass = createEClass(DOCUMENT_EVENT_ATTRIBUTES);
		createEAttribute(documentEventAttributesEClass, DOCUMENT_EVENT_ATTRIBUTES__ONUNLOAD);
		createEAttribute(documentEventAttributesEClass, DOCUMENT_EVENT_ATTRIBUTES__ONABORT);
		createEAttribute(documentEventAttributesEClass, DOCUMENT_EVENT_ATTRIBUTES__ONERROR);
		createEAttribute(documentEventAttributesEClass, DOCUMENT_EVENT_ATTRIBUTES__ONRESIZE);
		createEAttribute(documentEventAttributesEClass, DOCUMENT_EVENT_ATTRIBUTES__ONSCROLL);
		createEAttribute(documentEventAttributesEClass, DOCUMENT_EVENT_ATTRIBUTES__ONZOOM);

		graphicalEventAttributesEClass = createEClass(GRAPHICAL_EVENT_ATTRIBUTES);
		createEAttribute(graphicalEventAttributesEClass, GRAPHICAL_EVENT_ATTRIBUTES__ONFOCUSIN);
		createEAttribute(graphicalEventAttributesEClass, GRAPHICAL_EVENT_ATTRIBUTES__ONFOCUSOUT);
		createEAttribute(graphicalEventAttributesEClass, GRAPHICAL_EVENT_ATTRIBUTES__ONACTIVATE);
		createEAttribute(graphicalEventAttributesEClass, GRAPHICAL_EVENT_ATTRIBUTES__ONCLICK);
		createEAttribute(graphicalEventAttributesEClass, GRAPHICAL_EVENT_ATTRIBUTES__ONMOUSEDOWN);
		createEAttribute(graphicalEventAttributesEClass, GRAPHICAL_EVENT_ATTRIBUTES__ONMOUSEUP);
		createEAttribute(graphicalEventAttributesEClass, GRAPHICAL_EVENT_ATTRIBUTES__ONMOUSEOVER);
		createEAttribute(graphicalEventAttributesEClass, GRAPHICAL_EVENT_ATTRIBUTES__ONMOUSEMOVE);
		createEAttribute(graphicalEventAttributesEClass, GRAPHICAL_EVENT_ATTRIBUTES__ONMOUSEOUT);
		createEAttribute(graphicalEventAttributesEClass, GRAPHICAL_EVENT_ATTRIBUTES__ONLOAD);

		presentationAttributesEClass = createEClass(PRESENTATION_ATTRIBUTES);
		createEAttribute(presentationAttributesEClass, PRESENTATION_ATTRIBUTES__ALIGNMENT_BASELINE);
		createEAttribute(presentationAttributesEClass, PRESENTATION_ATTRIBUTES__BASELINE_SHIFT);
		createEAttribute(presentationAttributesEClass, PRESENTATION_ATTRIBUTES__CLIP);
		createEAttribute(presentationAttributesEClass, PRESENTATION_ATTRIBUTES__CLIP_PATH);
		createEAttribute(presentationAttributesEClass, PRESENTATION_ATTRIBUTES__CLIP_RULE);
		createEAttribute(presentationAttributesEClass, PRESENTATION_ATTRIBUTES__COLOR);
		createEAttribute(presentationAttributesEClass, PRESENTATION_ATTRIBUTES__COLOR_INTERPOLATION);
		createEAttribute(presentationAttributesEClass, PRESENTATION_ATTRIBUTES__COLOR_INTERPOLATION_FILTERS);
		createEAttribute(presentationAttributesEClass, PRESENTATION_ATTRIBUTES__COLOR_PROFILE);
		createEAttribute(presentationAttributesEClass, PRESENTATION_ATTRIBUTES__COLOR_RENDERING);
		createEAttribute(presentationAttributesEClass, PRESENTATION_ATTRIBUTES__CURSOR);
		createEAttribute(presentationAttributesEClass, PRESENTATION_ATTRIBUTES__DIRECTION);
		createEAttribute(presentationAttributesEClass, PRESENTATION_ATTRIBUTES__DISPLAY);
		createEAttribute(presentationAttributesEClass, PRESENTATION_ATTRIBUTES__DOMINANT_BASELINE);
		createEAttribute(presentationAttributesEClass, PRESENTATION_ATTRIBUTES__ENABLE_BACKGROUND);
		createEAttribute(presentationAttributesEClass, PRESENTATION_ATTRIBUTES__FILL);
		createEAttribute(presentationAttributesEClass, PRESENTATION_ATTRIBUTES__FILL_OPACITY);
		createEAttribute(presentationAttributesEClass, PRESENTATION_ATTRIBUTES__FILL_RULE);
		createEAttribute(presentationAttributesEClass, PRESENTATION_ATTRIBUTES__FILTER);
		createEAttribute(presentationAttributesEClass, PRESENTATION_ATTRIBUTES__FLOOD_COLOR);
		createEAttribute(presentationAttributesEClass, PRESENTATION_ATTRIBUTES__FLOOD_OPACITY);
		createEAttribute(presentationAttributesEClass, PRESENTATION_ATTRIBUTES__FONT_FAMILY);
		createEAttribute(presentationAttributesEClass, PRESENTATION_ATTRIBUTES__FONT_SIZE);
		createEAttribute(presentationAttributesEClass, PRESENTATION_ATTRIBUTES__FONT_SIZE_ADJUST);
		createEAttribute(presentationAttributesEClass, PRESENTATION_ATTRIBUTES__FONT_STRETCH);
		createEAttribute(presentationAttributesEClass, PRESENTATION_ATTRIBUTES__FONT_STYLE);
		createEAttribute(presentationAttributesEClass, PRESENTATION_ATTRIBUTES__FONT_VARIANT);
		createEAttribute(presentationAttributesEClass, PRESENTATION_ATTRIBUTES__FONT_WEIGHT);
		createEAttribute(presentationAttributesEClass, PRESENTATION_ATTRIBUTES__GLYPH_ORIENTATION_HORIZONTAL);
		createEAttribute(presentationAttributesEClass, PRESENTATION_ATTRIBUTES__GLYPH_ORIENTATION_VERTICAL);
		createEAttribute(presentationAttributesEClass, PRESENTATION_ATTRIBUTES__IMAGE_RENDERING);
		createEAttribute(presentationAttributesEClass, PRESENTATION_ATTRIBUTES__KERNING);
		createEAttribute(presentationAttributesEClass, PRESENTATION_ATTRIBUTES__LETTER_SPACING);
		createEAttribute(presentationAttributesEClass, PRESENTATION_ATTRIBUTES__LIGHTING_COLOR);
		createEAttribute(presentationAttributesEClass, PRESENTATION_ATTRIBUTES__MARKER_END);
		createEAttribute(presentationAttributesEClass, PRESENTATION_ATTRIBUTES__MARKER_MID);
		createEAttribute(presentationAttributesEClass, PRESENTATION_ATTRIBUTES__MARKER_START);
		createEAttribute(presentationAttributesEClass, PRESENTATION_ATTRIBUTES__MASKS);
		createEAttribute(presentationAttributesEClass, PRESENTATION_ATTRIBUTES__OPACITY);
		createEAttribute(presentationAttributesEClass, PRESENTATION_ATTRIBUTES__OVERFLOW);
		createEAttribute(presentationAttributesEClass, PRESENTATION_ATTRIBUTES__POINTER_EVENTS);
		createEAttribute(presentationAttributesEClass, PRESENTATION_ATTRIBUTES__SHAPE_RENDERING);
		createEAttribute(presentationAttributesEClass, PRESENTATION_ATTRIBUTES__STOP_COLOR);
		createEAttribute(presentationAttributesEClass, PRESENTATION_ATTRIBUTES__STOP_OPACITY);
		createEAttribute(presentationAttributesEClass, PRESENTATION_ATTRIBUTES__STROKE);
		createEAttribute(presentationAttributesEClass, PRESENTATION_ATTRIBUTES__STROKE_DASHARRAY);
		createEAttribute(presentationAttributesEClass, PRESENTATION_ATTRIBUTES__STROKE_DASHOFFSET);
		createEAttribute(presentationAttributesEClass, PRESENTATION_ATTRIBUTES__STROKE_LINECAP);
		createEAttribute(presentationAttributesEClass, PRESENTATION_ATTRIBUTES__STROKE_LINEJOIN);
		createEAttribute(presentationAttributesEClass, PRESENTATION_ATTRIBUTES__STROKE_MITERLIMIT);
		createEAttribute(presentationAttributesEClass, PRESENTATION_ATTRIBUTES__STROKE_OPACITY);
		createEAttribute(presentationAttributesEClass, PRESENTATION_ATTRIBUTES__STROKE_WIDTH);
		createEAttribute(presentationAttributesEClass, PRESENTATION_ATTRIBUTES__TEXT_ANCHOR);
		createEAttribute(presentationAttributesEClass, PRESENTATION_ATTRIBUTES__TEXT_DECORATION);
		createEAttribute(presentationAttributesEClass, PRESENTATION_ATTRIBUTES__TEXT_RENDERING);
		createEAttribute(presentationAttributesEClass, PRESENTATION_ATTRIBUTES__UNICODE_BIDI);
		createEAttribute(presentationAttributesEClass, PRESENTATION_ATTRIBUTES__VISIBILITY);
		createEAttribute(presentationAttributesEClass, PRESENTATION_ATTRIBUTES__WORD_SPACING);
		createEAttribute(presentationAttributesEClass, PRESENTATION_ATTRIBUTES__WRITING_MODE);

		xLinkAttributesEClass = createEClass(XLINK_ATTRIBUTES);
		createEAttribute(xLinkAttributesEClass, XLINK_ATTRIBUTES__XLINK_HREF);
		createEAttribute(xLinkAttributesEClass, XLINK_ATTRIBUTES__XLINK_SHOW);
		createEAttribute(xLinkAttributesEClass, XLINK_ATTRIBUTES__XLINK_ACTUATE);
		createEAttribute(xLinkAttributesEClass, XLINK_ATTRIBUTES__XLINK_TYPE);
		createEAttribute(xLinkAttributesEClass, XLINK_ATTRIBUTES__XLINK_ROLE);
		createEAttribute(xLinkAttributesEClass, XLINK_ATTRIBUTES__XLINK_ARCROLE);
		createEAttribute(xLinkAttributesEClass, XLINK_ATTRIBUTES__XLINK_TITLE);
		createEReference(xLinkAttributesEClass, XLINK_ATTRIBUTES__RESOLVED_INSTANCE);

		filterPrimitiveAttributesEClass = createEClass(FILTER_PRIMITIVE_ATTRIBUTES);
		createEAttribute(filterPrimitiveAttributesEClass, FILTER_PRIMITIVE_ATTRIBUTES__X);
		createEAttribute(filterPrimitiveAttributesEClass, FILTER_PRIMITIVE_ATTRIBUTES__Y);
		createEAttribute(filterPrimitiveAttributesEClass, FILTER_PRIMITIVE_ATTRIBUTES__WIDTH);
		createEAttribute(filterPrimitiveAttributesEClass, FILTER_PRIMITIVE_ATTRIBUTES__HEIGHT);
		createEAttribute(filterPrimitiveAttributesEClass, FILTER_PRIMITIVE_ATTRIBUTES__RESULT);
		createEAttribute(filterPrimitiveAttributesEClass, FILTER_PRIMITIVE_ATTRIBUTES__IN);

		____ELEMENTES____EClass = createEClass(_ELEMENTES_);

		svgSvgElementEClass = createEClass(SVG_SVG_ELEMENT);
		createEAttribute(svgSvgElementEClass, SVG_SVG_ELEMENT__CLASS);
		createEAttribute(svgSvgElementEClass, SVG_SVG_ELEMENT__STYLE);
		createEAttribute(svgSvgElementEClass, SVG_SVG_ELEMENT__EXTERNAL_RESOURCES_REQUIRED);
		createEAttribute(svgSvgElementEClass, SVG_SVG_ELEMENT__X);
		createEAttribute(svgSvgElementEClass, SVG_SVG_ELEMENT__Y);
		createEAttribute(svgSvgElementEClass, SVG_SVG_ELEMENT__WIDTH);
		createEAttribute(svgSvgElementEClass, SVG_SVG_ELEMENT__HEIGHT);
		createEAttribute(svgSvgElementEClass, SVG_SVG_ELEMENT__VIEW_BOX);
		createEAttribute(svgSvgElementEClass, SVG_SVG_ELEMENT__PRESERVE_ASPECT_RATIO);
		createEAttribute(svgSvgElementEClass, SVG_SVG_ELEMENT__ZOOM_AND_PAN);
		createEAttribute(svgSvgElementEClass, SVG_SVG_ELEMENT__VERSION);
		createEAttribute(svgSvgElementEClass, SVG_SVG_ELEMENT__BASE_PROFILE);
		createEAttribute(svgSvgElementEClass, SVG_SVG_ELEMENT__CONTENT_SCRIPT_TYPE);
		createEAttribute(svgSvgElementEClass, SVG_SVG_ELEMENT__CONTENT_STYLE_TYPE);
		createEAttribute(svgSvgElementEClass, SVG_SVG_ELEMENT__STYLE_SHEET);

		svgGElementEClass = createEClass(SVG_GELEMENT);
		createEAttribute(svgGElementEClass, SVG_GELEMENT__CLASS);
		createEAttribute(svgGElementEClass, SVG_GELEMENT__STYLE);
		createEAttribute(svgGElementEClass, SVG_GELEMENT__EXTERNAL_RESOURCES_REQUIRED);
		createEAttribute(svgGElementEClass, SVG_GELEMENT__TRANSFORM);
		createEAttribute(svgGElementEClass, SVG_GELEMENT__X);
		createEAttribute(svgGElementEClass, SVG_GELEMENT__Y);

		svgDefsElementEClass = createEClass(SVG_DEFS_ELEMENT);
		createEAttribute(svgDefsElementEClass, SVG_DEFS_ELEMENT__CLASS);
		createEAttribute(svgDefsElementEClass, SVG_DEFS_ELEMENT__STYLE);
		createEAttribute(svgDefsElementEClass, SVG_DEFS_ELEMENT__EXTERNAL_RESOURCES_REQUIRED);
		createEAttribute(svgDefsElementEClass, SVG_DEFS_ELEMENT__TRANSFORM);

		svgDescElementEClass = createEClass(SVG_DESC_ELEMENT);
		createEAttribute(svgDescElementEClass, SVG_DESC_ELEMENT__CLASS);
		createEAttribute(svgDescElementEClass, SVG_DESC_ELEMENT__STYLE);

		svgTitleElementEClass = createEClass(SVG_TITLE_ELEMENT);
		createEAttribute(svgTitleElementEClass, SVG_TITLE_ELEMENT__CLASS);
		createEAttribute(svgTitleElementEClass, SVG_TITLE_ELEMENT__STYLE);

		svgSymbolElementEClass = createEClass(SVG_SYMBOL_ELEMENT);
		createEAttribute(svgSymbolElementEClass, SVG_SYMBOL_ELEMENT__CLASS);
		createEAttribute(svgSymbolElementEClass, SVG_SYMBOL_ELEMENT__STYLE);
		createEAttribute(svgSymbolElementEClass, SVG_SYMBOL_ELEMENT__EXTERNAL_RESOURCES_REQUIRED);
		createEAttribute(svgSymbolElementEClass, SVG_SYMBOL_ELEMENT__VIEW_BOX);
		createEAttribute(svgSymbolElementEClass, SVG_SYMBOL_ELEMENT__PRESERVE_ASPECT_RATIO);

		svgUseElementEClass = createEClass(SVG_USE_ELEMENT);
		createEAttribute(svgUseElementEClass, SVG_USE_ELEMENT__CLASS);
		createEAttribute(svgUseElementEClass, SVG_USE_ELEMENT__STYLE);
		createEAttribute(svgUseElementEClass, SVG_USE_ELEMENT__EXTERNAL_RESOURCES_REQUIRED);
		createEAttribute(svgUseElementEClass, SVG_USE_ELEMENT__TRANSFORM);
		createEAttribute(svgUseElementEClass, SVG_USE_ELEMENT__WIDTH);
		createEAttribute(svgUseElementEClass, SVG_USE_ELEMENT__HEIGHT);
		createEAttribute(svgUseElementEClass, SVG_USE_ELEMENT__X);
		createEAttribute(svgUseElementEClass, SVG_USE_ELEMENT__Y);

		svgImageElementEClass = createEClass(SVG_IMAGE_ELEMENT);
		createEAttribute(svgImageElementEClass, SVG_IMAGE_ELEMENT__CLASS);
		createEAttribute(svgImageElementEClass, SVG_IMAGE_ELEMENT__STYLE);
		createEAttribute(svgImageElementEClass, SVG_IMAGE_ELEMENT__EXTERNAL_RESOURCES_REQUIRED);
		createEAttribute(svgImageElementEClass, SVG_IMAGE_ELEMENT__PRESERVE_ASPECT_RATIO);
		createEAttribute(svgImageElementEClass, SVG_IMAGE_ELEMENT__TRANSFORM);
		createEAttribute(svgImageElementEClass, SVG_IMAGE_ELEMENT__X);
		createEAttribute(svgImageElementEClass, SVG_IMAGE_ELEMENT__Y);
		createEAttribute(svgImageElementEClass, SVG_IMAGE_ELEMENT__WIDTH);
		createEAttribute(svgImageElementEClass, SVG_IMAGE_ELEMENT__HEIGHT);

		svgSwitchElementEClass = createEClass(SVG_SWITCH_ELEMENT);
		createEAttribute(svgSwitchElementEClass, SVG_SWITCH_ELEMENT__CLASS);
		createEAttribute(svgSwitchElementEClass, SVG_SWITCH_ELEMENT__STYLE);
		createEAttribute(svgSwitchElementEClass, SVG_SWITCH_ELEMENT__EXTERNAL_RESOURCES_REQUIRED);
		createEAttribute(svgSwitchElementEClass, SVG_SWITCH_ELEMENT__TRANSFORM);

		svgPathElementEClass = createEClass(SVG_PATH_ELEMENT);
		createEAttribute(svgPathElementEClass, SVG_PATH_ELEMENT__CLASS);
		createEAttribute(svgPathElementEClass, SVG_PATH_ELEMENT__STYLE);
		createEAttribute(svgPathElementEClass, SVG_PATH_ELEMENT__EXTERNAL_RESOURCES_REQUIRED);
		createEAttribute(svgPathElementEClass, SVG_PATH_ELEMENT__TRANSFORM);
		createEAttribute(svgPathElementEClass, SVG_PATH_ELEMENT__D);
		createEAttribute(svgPathElementEClass, SVG_PATH_ELEMENT__PATH_LENGTH);

		svgRectElementEClass = createEClass(SVG_RECT_ELEMENT);
		createEAttribute(svgRectElementEClass, SVG_RECT_ELEMENT__CLASS);
		createEAttribute(svgRectElementEClass, SVG_RECT_ELEMENT__STYLE);
		createEAttribute(svgRectElementEClass, SVG_RECT_ELEMENT__EXTERNAL_RESOURCES_REQUIRED);
		createEAttribute(svgRectElementEClass, SVG_RECT_ELEMENT__TRANSFORM);
		createEAttribute(svgRectElementEClass, SVG_RECT_ELEMENT__X);
		createEAttribute(svgRectElementEClass, SVG_RECT_ELEMENT__Y);
		createEAttribute(svgRectElementEClass, SVG_RECT_ELEMENT__WIDTH);
		createEAttribute(svgRectElementEClass, SVG_RECT_ELEMENT__HEIGHT);
		createEAttribute(svgRectElementEClass, SVG_RECT_ELEMENT__RX);
		createEAttribute(svgRectElementEClass, SVG_RECT_ELEMENT__RY);

		svgCircleElementEClass = createEClass(SVG_CIRCLE_ELEMENT);
		createEAttribute(svgCircleElementEClass, SVG_CIRCLE_ELEMENT__CLASS);
		createEAttribute(svgCircleElementEClass, SVG_CIRCLE_ELEMENT__STYLE);
		createEAttribute(svgCircleElementEClass, SVG_CIRCLE_ELEMENT__EXTERNAL_RESOURCES_REQUIRED);
		createEAttribute(svgCircleElementEClass, SVG_CIRCLE_ELEMENT__TRANSFORM);
		createEAttribute(svgCircleElementEClass, SVG_CIRCLE_ELEMENT__CX);
		createEAttribute(svgCircleElementEClass, SVG_CIRCLE_ELEMENT__CY);
		createEAttribute(svgCircleElementEClass, SVG_CIRCLE_ELEMENT__R);

		svgEllipseElementEClass = createEClass(SVG_ELLIPSE_ELEMENT);
		createEAttribute(svgEllipseElementEClass, SVG_ELLIPSE_ELEMENT__CLASS);
		createEAttribute(svgEllipseElementEClass, SVG_ELLIPSE_ELEMENT__STYLE);
		createEAttribute(svgEllipseElementEClass, SVG_ELLIPSE_ELEMENT__EXTERNAL_RESOURCES_REQUIRED);
		createEAttribute(svgEllipseElementEClass, SVG_ELLIPSE_ELEMENT__TRANSFORM);
		createEAttribute(svgEllipseElementEClass, SVG_ELLIPSE_ELEMENT__CX);
		createEAttribute(svgEllipseElementEClass, SVG_ELLIPSE_ELEMENT__CY);
		createEAttribute(svgEllipseElementEClass, SVG_ELLIPSE_ELEMENT__RX);
		createEAttribute(svgEllipseElementEClass, SVG_ELLIPSE_ELEMENT__RY);

		svgLineElementEClass = createEClass(SVG_LINE_ELEMENT);
		createEAttribute(svgLineElementEClass, SVG_LINE_ELEMENT__CLASS);
		createEAttribute(svgLineElementEClass, SVG_LINE_ELEMENT__STYLE);
		createEAttribute(svgLineElementEClass, SVG_LINE_ELEMENT__EXTERNAL_RESOURCES_REQUIRED);
		createEAttribute(svgLineElementEClass, SVG_LINE_ELEMENT__TRANSFORM);
		createEAttribute(svgLineElementEClass, SVG_LINE_ELEMENT__X1);
		createEAttribute(svgLineElementEClass, SVG_LINE_ELEMENT__Y1);
		createEAttribute(svgLineElementEClass, SVG_LINE_ELEMENT__X2);
		createEAttribute(svgLineElementEClass, SVG_LINE_ELEMENT__Y2);

		svgPolylineElementEClass = createEClass(SVG_POLYLINE_ELEMENT);
		createEAttribute(svgPolylineElementEClass, SVG_POLYLINE_ELEMENT__CLASS);
		createEAttribute(svgPolylineElementEClass, SVG_POLYLINE_ELEMENT__STYLE);
		createEAttribute(svgPolylineElementEClass, SVG_POLYLINE_ELEMENT__EXTERNAL_RESOURCES_REQUIRED);
		createEAttribute(svgPolylineElementEClass, SVG_POLYLINE_ELEMENT__TRANSFORM);
		createEAttribute(svgPolylineElementEClass, SVG_POLYLINE_ELEMENT__POINTS);

		svgPolygonElementEClass = createEClass(SVG_POLYGON_ELEMENT);
		createEAttribute(svgPolygonElementEClass, SVG_POLYGON_ELEMENT__CLASS);
		createEAttribute(svgPolygonElementEClass, SVG_POLYGON_ELEMENT__STYLE);
		createEAttribute(svgPolygonElementEClass, SVG_POLYGON_ELEMENT__EXTERNAL_RESOURCES_REQUIRED);
		createEAttribute(svgPolygonElementEClass, SVG_POLYGON_ELEMENT__TRANSFORM);
		createEAttribute(svgPolygonElementEClass, SVG_POLYGON_ELEMENT__POINTS);

		svgTextElementEClass = createEClass(SVG_TEXT_ELEMENT);
		createEAttribute(svgTextElementEClass, SVG_TEXT_ELEMENT__CLASS);
		createEAttribute(svgTextElementEClass, SVG_TEXT_ELEMENT__STYLE);
		createEAttribute(svgTextElementEClass, SVG_TEXT_ELEMENT__EXTERNAL_RESOURCES_REQUIRED);
		createEAttribute(svgTextElementEClass, SVG_TEXT_ELEMENT__TRANSFORM);
		createEAttribute(svgTextElementEClass, SVG_TEXT_ELEMENT__LENGTH_ADJUST);
		createEAttribute(svgTextElementEClass, SVG_TEXT_ELEMENT__X);
		createEAttribute(svgTextElementEClass, SVG_TEXT_ELEMENT__Y);
		createEAttribute(svgTextElementEClass, SVG_TEXT_ELEMENT__DX);
		createEAttribute(svgTextElementEClass, SVG_TEXT_ELEMENT__DY);
		createEAttribute(svgTextElementEClass, SVG_TEXT_ELEMENT__ROTATE);
		createEAttribute(svgTextElementEClass, SVG_TEXT_ELEMENT__TEXT_LENGTH);
		createEAttribute(svgTextElementEClass, SVG_TEXT_ELEMENT__TEXT_CONTENT);

		svgTspanElementEClass = createEClass(SVG_TSPAN_ELEMENT);
		createEAttribute(svgTspanElementEClass, SVG_TSPAN_ELEMENT__CLASS);
		createEAttribute(svgTspanElementEClass, SVG_TSPAN_ELEMENT__STYLE);
		createEAttribute(svgTspanElementEClass, SVG_TSPAN_ELEMENT__EXTERNAL_RESOURCES_REQUIRED);
		createEAttribute(svgTspanElementEClass, SVG_TSPAN_ELEMENT__X);
		createEAttribute(svgTspanElementEClass, SVG_TSPAN_ELEMENT__Y);
		createEAttribute(svgTspanElementEClass, SVG_TSPAN_ELEMENT__DX);
		createEAttribute(svgTspanElementEClass, SVG_TSPAN_ELEMENT__DY);
		createEAttribute(svgTspanElementEClass, SVG_TSPAN_ELEMENT__ROTATE);
		createEAttribute(svgTspanElementEClass, SVG_TSPAN_ELEMENT__TEXT_LENGTH);
		createEAttribute(svgTspanElementEClass, SVG_TSPAN_ELEMENT__LENGTH_ADJUST);

		svgTrefElementEClass = createEClass(SVG_TREF_ELEMENT);
		createEAttribute(svgTrefElementEClass, SVG_TREF_ELEMENT__CLASS);
		createEAttribute(svgTrefElementEClass, SVG_TREF_ELEMENT__STYLE);
		createEAttribute(svgTrefElementEClass, SVG_TREF_ELEMENT__EXTERNAL_RESOURCES_REQUIRED);

		svgTextPathElementEClass = createEClass(SVG_TEXT_PATH_ELEMENT);
		createEAttribute(svgTextPathElementEClass, SVG_TEXT_PATH_ELEMENT__CLASS);
		createEAttribute(svgTextPathElementEClass, SVG_TEXT_PATH_ELEMENT__STYLE);
		createEAttribute(svgTextPathElementEClass, SVG_TEXT_PATH_ELEMENT__EXTERNAL_RESOURCES_REQUIRED);
		createEAttribute(svgTextPathElementEClass, SVG_TEXT_PATH_ELEMENT__START_OFFSET);
		createEAttribute(svgTextPathElementEClass, SVG_TEXT_PATH_ELEMENT__METHOD);
		createEAttribute(svgTextPathElementEClass, SVG_TEXT_PATH_ELEMENT__SPACING);

		svgAltGlyphElementEClass = createEClass(SVG_ALT_GLYPH_ELEMENT);
		createEAttribute(svgAltGlyphElementEClass, SVG_ALT_GLYPH_ELEMENT__CLASS);
		createEAttribute(svgAltGlyphElementEClass, SVG_ALT_GLYPH_ELEMENT__STYLE);
		createEAttribute(svgAltGlyphElementEClass, SVG_ALT_GLYPH_ELEMENT__EXTERNAL_RESOURCES_REQUIRED);
		createEAttribute(svgAltGlyphElementEClass, SVG_ALT_GLYPH_ELEMENT__X);
		createEAttribute(svgAltGlyphElementEClass, SVG_ALT_GLYPH_ELEMENT__Y);
		createEAttribute(svgAltGlyphElementEClass, SVG_ALT_GLYPH_ELEMENT__DX);
		createEAttribute(svgAltGlyphElementEClass, SVG_ALT_GLYPH_ELEMENT__DY);
		createEAttribute(svgAltGlyphElementEClass, SVG_ALT_GLYPH_ELEMENT__GLYPH_REF);
		createEAttribute(svgAltGlyphElementEClass, SVG_ALT_GLYPH_ELEMENT__FORMAT);
		createEAttribute(svgAltGlyphElementEClass, SVG_ALT_GLYPH_ELEMENT__ROTATE);

		svgAltGlyphDefElementEClass = createEClass(SVG_ALT_GLYPH_DEF_ELEMENT);

		svgAltGlyphItemElementEClass = createEClass(SVG_ALT_GLYPH_ITEM_ELEMENT);

		svgAltGlyphRefElementEClass = createEClass(SVG_ALT_GLYPH_REF_ELEMENT);
		createEAttribute(svgAltGlyphRefElementEClass, SVG_ALT_GLYPH_REF_ELEMENT__CLASS);
		createEAttribute(svgAltGlyphRefElementEClass, SVG_ALT_GLYPH_REF_ELEMENT__STYLE);
		createEAttribute(svgAltGlyphRefElementEClass, SVG_ALT_GLYPH_REF_ELEMENT__X);
		createEAttribute(svgAltGlyphRefElementEClass, SVG_ALT_GLYPH_REF_ELEMENT__Y);
		createEAttribute(svgAltGlyphRefElementEClass, SVG_ALT_GLYPH_REF_ELEMENT__DX);
		createEAttribute(svgAltGlyphRefElementEClass, SVG_ALT_GLYPH_REF_ELEMENT__DY);
		createEAttribute(svgAltGlyphRefElementEClass, SVG_ALT_GLYPH_REF_ELEMENT__GLYPH_REF);
		createEAttribute(svgAltGlyphRefElementEClass, SVG_ALT_GLYPH_REF_ELEMENT__FORMAT);

		svgMarkerElementEClass = createEClass(SVG_MARKER_ELEMENT);
		createEAttribute(svgMarkerElementEClass, SVG_MARKER_ELEMENT__CLASS);
		createEAttribute(svgMarkerElementEClass, SVG_MARKER_ELEMENT__STYLE);
		createEAttribute(svgMarkerElementEClass, SVG_MARKER_ELEMENT__EXTERNAL_RESOURCES_REQUIRED);
		createEAttribute(svgMarkerElementEClass, SVG_MARKER_ELEMENT__VIEW_BOX);
		createEAttribute(svgMarkerElementEClass, SVG_MARKER_ELEMENT__PRESERVE_ASPECT_RATIO);
		createEAttribute(svgMarkerElementEClass, SVG_MARKER_ELEMENT__REF_X);
		createEAttribute(svgMarkerElementEClass, SVG_MARKER_ELEMENT__REF_Y);
		createEAttribute(svgMarkerElementEClass, SVG_MARKER_ELEMENT__MARKER_UNITS);
		createEAttribute(svgMarkerElementEClass, SVG_MARKER_ELEMENT__MARKER_WIDTH);
		createEAttribute(svgMarkerElementEClass, SVG_MARKER_ELEMENT__MARKER_HEIGHT);
		createEAttribute(svgMarkerElementEClass, SVG_MARKER_ELEMENT__ORIENT);

		svgColorProfileElementEClass = createEClass(SVG_COLOR_PROFILE_ELEMENT);
		createEAttribute(svgColorProfileElementEClass, SVG_COLOR_PROFILE_ELEMENT__LOCAL);
		createEAttribute(svgColorProfileElementEClass, SVG_COLOR_PROFILE_ELEMENT__NAME);
		createEAttribute(svgColorProfileElementEClass, SVG_COLOR_PROFILE_ELEMENT__RENDERING_INTENT);

		svgLinearGradientElementEClass = createEClass(SVG_LINEAR_GRADIENT_ELEMENT);
		createEAttribute(svgLinearGradientElementEClass, SVG_LINEAR_GRADIENT_ELEMENT__CLASS);
		createEAttribute(svgLinearGradientElementEClass, SVG_LINEAR_GRADIENT_ELEMENT__STYLE);
		createEAttribute(svgLinearGradientElementEClass, SVG_LINEAR_GRADIENT_ELEMENT__EXTERNAL_RESOURCES_REQUIRED);
		createEAttribute(svgLinearGradientElementEClass, SVG_LINEAR_GRADIENT_ELEMENT__X1);
		createEAttribute(svgLinearGradientElementEClass, SVG_LINEAR_GRADIENT_ELEMENT__Y1);
		createEAttribute(svgLinearGradientElementEClass, SVG_LINEAR_GRADIENT_ELEMENT__X2);
		createEAttribute(svgLinearGradientElementEClass, SVG_LINEAR_GRADIENT_ELEMENT__Y2);
		createEAttribute(svgLinearGradientElementEClass, SVG_LINEAR_GRADIENT_ELEMENT__GRADIENT_UNITS);
		createEAttribute(svgLinearGradientElementEClass, SVG_LINEAR_GRADIENT_ELEMENT__SPREAD_METHOD);
		createEAttribute(svgLinearGradientElementEClass, SVG_LINEAR_GRADIENT_ELEMENT__GRADIENT_TRANSFORM);

		svgRadialGradientElementEClass = createEClass(SVG_RADIAL_GRADIENT_ELEMENT);
		createEAttribute(svgRadialGradientElementEClass, SVG_RADIAL_GRADIENT_ELEMENT__CLASS);
		createEAttribute(svgRadialGradientElementEClass, SVG_RADIAL_GRADIENT_ELEMENT__STYLE);
		createEAttribute(svgRadialGradientElementEClass, SVG_RADIAL_GRADIENT_ELEMENT__EXTERNAL_RESOURCES_REQUIRED);
		createEAttribute(svgRadialGradientElementEClass, SVG_RADIAL_GRADIENT_ELEMENT__CX);
		createEAttribute(svgRadialGradientElementEClass, SVG_RADIAL_GRADIENT_ELEMENT__CY);
		createEAttribute(svgRadialGradientElementEClass, SVG_RADIAL_GRADIENT_ELEMENT__R);
		createEAttribute(svgRadialGradientElementEClass, SVG_RADIAL_GRADIENT_ELEMENT__FX);
		createEAttribute(svgRadialGradientElementEClass, SVG_RADIAL_GRADIENT_ELEMENT__FY);
		createEAttribute(svgRadialGradientElementEClass, SVG_RADIAL_GRADIENT_ELEMENT__SPREAD_METHOD);
		createEAttribute(svgRadialGradientElementEClass, SVG_RADIAL_GRADIENT_ELEMENT__GRADIENT_UNITS);
		createEAttribute(svgRadialGradientElementEClass, SVG_RADIAL_GRADIENT_ELEMENT__GRADIENT_TRANSFORM);

		svgStopElementEClass = createEClass(SVG_STOP_ELEMENT);
		createEAttribute(svgStopElementEClass, SVG_STOP_ELEMENT__CLASS);
		createEAttribute(svgStopElementEClass, SVG_STOP_ELEMENT__STYLE);
		createEAttribute(svgStopElementEClass, SVG_STOP_ELEMENT__OFFSET);

		svgPatternElementEClass = createEClass(SVG_PATTERN_ELEMENT);
		createEAttribute(svgPatternElementEClass, SVG_PATTERN_ELEMENT__CLASS);
		createEAttribute(svgPatternElementEClass, SVG_PATTERN_ELEMENT__STYLE);
		createEAttribute(svgPatternElementEClass, SVG_PATTERN_ELEMENT__EXTERNAL_RESOURCES_REQUIRED);
		createEAttribute(svgPatternElementEClass, SVG_PATTERN_ELEMENT__VIEW_BOX);
		createEAttribute(svgPatternElementEClass, SVG_PATTERN_ELEMENT__PRESERVE_ASPECT_RATIO);
		createEAttribute(svgPatternElementEClass, SVG_PATTERN_ELEMENT__X);
		createEAttribute(svgPatternElementEClass, SVG_PATTERN_ELEMENT__Y);
		createEAttribute(svgPatternElementEClass, SVG_PATTERN_ELEMENT__WIDTH);
		createEAttribute(svgPatternElementEClass, SVG_PATTERN_ELEMENT__HEIGHT);
		createEAttribute(svgPatternElementEClass, SVG_PATTERN_ELEMENT__PATTERN_UNITS);
		createEAttribute(svgPatternElementEClass, SVG_PATTERN_ELEMENT__PATTERN_CONTENT_UNITS);
		createEAttribute(svgPatternElementEClass, SVG_PATTERN_ELEMENT__PATTERN_TRANSFORM);

		svgClipPathElementEClass = createEClass(SVG_CLIP_PATH_ELEMENT);
		createEAttribute(svgClipPathElementEClass, SVG_CLIP_PATH_ELEMENT__CLASS);
		createEAttribute(svgClipPathElementEClass, SVG_CLIP_PATH_ELEMENT__STYLE);
		createEAttribute(svgClipPathElementEClass, SVG_CLIP_PATH_ELEMENT__EXTERNAL_RESOURCES_REQUIRED);
		createEAttribute(svgClipPathElementEClass, SVG_CLIP_PATH_ELEMENT__TRANSFORM);
		createEAttribute(svgClipPathElementEClass, SVG_CLIP_PATH_ELEMENT__CLIP_PATH_UNITS);

		svgMaskElementEClass = createEClass(SVG_MASK_ELEMENT);
		createEAttribute(svgMaskElementEClass, SVG_MASK_ELEMENT__CLASS);
		createEAttribute(svgMaskElementEClass, SVG_MASK_ELEMENT__STYLE);
		createEAttribute(svgMaskElementEClass, SVG_MASK_ELEMENT__EXTERNAL_RESOURCES_REQUIRED);
		createEAttribute(svgMaskElementEClass, SVG_MASK_ELEMENT__X);
		createEAttribute(svgMaskElementEClass, SVG_MASK_ELEMENT__Y);
		createEAttribute(svgMaskElementEClass, SVG_MASK_ELEMENT__WIDTH);
		createEAttribute(svgMaskElementEClass, SVG_MASK_ELEMENT__HEIGHT);
		createEAttribute(svgMaskElementEClass, SVG_MASK_ELEMENT__MASK_UNITS);
		createEAttribute(svgMaskElementEClass, SVG_MASK_ELEMENT__MASK_CONTENT_UNITS);

		svgFilterElementEClass = createEClass(SVG_FILTER_ELEMENT);
		createEAttribute(svgFilterElementEClass, SVG_FILTER_ELEMENT__CLASS);
		createEAttribute(svgFilterElementEClass, SVG_FILTER_ELEMENT__STYLE);
		createEAttribute(svgFilterElementEClass, SVG_FILTER_ELEMENT__EXTERNAL_RESOURCES_REQUIRED);
		createEAttribute(svgFilterElementEClass, SVG_FILTER_ELEMENT__X);
		createEAttribute(svgFilterElementEClass, SVG_FILTER_ELEMENT__Y);
		createEAttribute(svgFilterElementEClass, SVG_FILTER_ELEMENT__WIDTH);
		createEAttribute(svgFilterElementEClass, SVG_FILTER_ELEMENT__HEIGHT);
		createEAttribute(svgFilterElementEClass, SVG_FILTER_ELEMENT__FILTER_RES);
		createEAttribute(svgFilterElementEClass, SVG_FILTER_ELEMENT__FILTER_UNITS);
		createEAttribute(svgFilterElementEClass, SVG_FILTER_ELEMENT__PRIMITIVE_UNITS);

		svgFeDistantLightElementEClass = createEClass(SVG_FE_DISTANT_LIGHT_ELEMENT);
		createEAttribute(svgFeDistantLightElementEClass, SVG_FE_DISTANT_LIGHT_ELEMENT__AZIMUTH);
		createEAttribute(svgFeDistantLightElementEClass, SVG_FE_DISTANT_LIGHT_ELEMENT__ELEVATION);

		svgFePointLightElementEClass = createEClass(SVG_FE_POINT_LIGHT_ELEMENT);
		createEAttribute(svgFePointLightElementEClass, SVG_FE_POINT_LIGHT_ELEMENT__X);
		createEAttribute(svgFePointLightElementEClass, SVG_FE_POINT_LIGHT_ELEMENT__Y);
		createEAttribute(svgFePointLightElementEClass, SVG_FE_POINT_LIGHT_ELEMENT__Z);

		svgFeSpotLightElementEClass = createEClass(SVG_FE_SPOT_LIGHT_ELEMENT);
		createEAttribute(svgFeSpotLightElementEClass, SVG_FE_SPOT_LIGHT_ELEMENT__X);
		createEAttribute(svgFeSpotLightElementEClass, SVG_FE_SPOT_LIGHT_ELEMENT__Y);
		createEAttribute(svgFeSpotLightElementEClass, SVG_FE_SPOT_LIGHT_ELEMENT__Z);
		createEAttribute(svgFeSpotLightElementEClass, SVG_FE_SPOT_LIGHT_ELEMENT__POINTS_AT_X);
		createEAttribute(svgFeSpotLightElementEClass, SVG_FE_SPOT_LIGHT_ELEMENT__POINTS_AT_Y);
		createEAttribute(svgFeSpotLightElementEClass, SVG_FE_SPOT_LIGHT_ELEMENT__POINTS_AT_Z);
		createEAttribute(svgFeSpotLightElementEClass, SVG_FE_SPOT_LIGHT_ELEMENT__SPECULAR_EXPONENT);
		createEAttribute(svgFeSpotLightElementEClass, SVG_FE_SPOT_LIGHT_ELEMENT__LIMITING_CONE_ANGLE);

		svgFeBlendElementEClass = createEClass(SVG_FE_BLEND_ELEMENT);
		createEAttribute(svgFeBlendElementEClass, SVG_FE_BLEND_ELEMENT__CLASS);
		createEAttribute(svgFeBlendElementEClass, SVG_FE_BLEND_ELEMENT__STYLE);
		createEAttribute(svgFeBlendElementEClass, SVG_FE_BLEND_ELEMENT__IN2);
		createEAttribute(svgFeBlendElementEClass, SVG_FE_BLEND_ELEMENT__MODE);

		svgFeColorMatrixElementEClass = createEClass(SVG_FE_COLOR_MATRIX_ELEMENT);
		createEAttribute(svgFeColorMatrixElementEClass, SVG_FE_COLOR_MATRIX_ELEMENT__CLASS);
		createEAttribute(svgFeColorMatrixElementEClass, SVG_FE_COLOR_MATRIX_ELEMENT__STYLE);
		createEAttribute(svgFeColorMatrixElementEClass, SVG_FE_COLOR_MATRIX_ELEMENT__TYPE);
		createEAttribute(svgFeColorMatrixElementEClass, SVG_FE_COLOR_MATRIX_ELEMENT__VALUES);

		svgFeComponentTransferElementEClass = createEClass(SVG_FE_COMPONENT_TRANSFER_ELEMENT);
		createEAttribute(svgFeComponentTransferElementEClass, SVG_FE_COMPONENT_TRANSFER_ELEMENT__CLASS);
		createEAttribute(svgFeComponentTransferElementEClass, SVG_FE_COMPONENT_TRANSFER_ELEMENT__STYLE);

		svgFeFuncRElementEClass = createEClass(SVG_FE_FUNC_RELEMENT);

		svgFeFuncGElementEClass = createEClass(SVG_FE_FUNC_GELEMENT);

		svgFeFuncBElementEClass = createEClass(SVG_FE_FUNC_BELEMENT);

		svgFeFuncAElementEClass = createEClass(SVG_FE_FUNC_AELEMENT);

		svgFeCompositeElementEClass = createEClass(SVG_FE_COMPOSITE_ELEMENT);
		createEAttribute(svgFeCompositeElementEClass, SVG_FE_COMPOSITE_ELEMENT__CLASS);
		createEAttribute(svgFeCompositeElementEClass, SVG_FE_COMPOSITE_ELEMENT__STYLE);
		createEAttribute(svgFeCompositeElementEClass, SVG_FE_COMPOSITE_ELEMENT__IN2);
		createEAttribute(svgFeCompositeElementEClass, SVG_FE_COMPOSITE_ELEMENT__OPERATOR);
		createEAttribute(svgFeCompositeElementEClass, SVG_FE_COMPOSITE_ELEMENT__K1);
		createEAttribute(svgFeCompositeElementEClass, SVG_FE_COMPOSITE_ELEMENT__K2);
		createEAttribute(svgFeCompositeElementEClass, SVG_FE_COMPOSITE_ELEMENT__K3);
		createEAttribute(svgFeCompositeElementEClass, SVG_FE_COMPOSITE_ELEMENT__K4);

		svgFeConvolveMatrixElementEClass = createEClass(SVG_FE_CONVOLVE_MATRIX_ELEMENT);
		createEAttribute(svgFeConvolveMatrixElementEClass, SVG_FE_CONVOLVE_MATRIX_ELEMENT__CLASS);
		createEAttribute(svgFeConvolveMatrixElementEClass, SVG_FE_CONVOLVE_MATRIX_ELEMENT__STYLE);
		createEAttribute(svgFeConvolveMatrixElementEClass, SVG_FE_CONVOLVE_MATRIX_ELEMENT__ORDER);
		createEAttribute(svgFeConvolveMatrixElementEClass, SVG_FE_CONVOLVE_MATRIX_ELEMENT__KERNEL_MATRIX);
		createEAttribute(svgFeConvolveMatrixElementEClass, SVG_FE_CONVOLVE_MATRIX_ELEMENT__DIVISOR);
		createEAttribute(svgFeConvolveMatrixElementEClass, SVG_FE_CONVOLVE_MATRIX_ELEMENT__BIAS);
		createEAttribute(svgFeConvolveMatrixElementEClass, SVG_FE_CONVOLVE_MATRIX_ELEMENT__TARGET_X);
		createEAttribute(svgFeConvolveMatrixElementEClass, SVG_FE_CONVOLVE_MATRIX_ELEMENT__TARGET_Y);
		createEAttribute(svgFeConvolveMatrixElementEClass, SVG_FE_CONVOLVE_MATRIX_ELEMENT__EDGE_MODE);
		createEAttribute(svgFeConvolveMatrixElementEClass, SVG_FE_CONVOLVE_MATRIX_ELEMENT__KERNEL_UNIT_LENGTH);
		createEAttribute(svgFeConvolveMatrixElementEClass, SVG_FE_CONVOLVE_MATRIX_ELEMENT__PRESERVE_ALPHA);

		svgFeDiffuseLightingElementEClass = createEClass(SVG_FE_DIFFUSE_LIGHTING_ELEMENT);
		createEAttribute(svgFeDiffuseLightingElementEClass, SVG_FE_DIFFUSE_LIGHTING_ELEMENT__CLASS);
		createEAttribute(svgFeDiffuseLightingElementEClass, SVG_FE_DIFFUSE_LIGHTING_ELEMENT__STYLE);
		createEAttribute(svgFeDiffuseLightingElementEClass, SVG_FE_DIFFUSE_LIGHTING_ELEMENT__SURFACE_SCALE);
		createEAttribute(svgFeDiffuseLightingElementEClass, SVG_FE_DIFFUSE_LIGHTING_ELEMENT__DIFFUSE_CONSTANT);
		createEAttribute(svgFeDiffuseLightingElementEClass, SVG_FE_DIFFUSE_LIGHTING_ELEMENT__KERNEL_UNIT_LENGTH);

		svgFeDisplacementMapElementEClass = createEClass(SVG_FE_DISPLACEMENT_MAP_ELEMENT);
		createEAttribute(svgFeDisplacementMapElementEClass, SVG_FE_DISPLACEMENT_MAP_ELEMENT__CLASS);
		createEAttribute(svgFeDisplacementMapElementEClass, SVG_FE_DISPLACEMENT_MAP_ELEMENT__STYLE);
		createEAttribute(svgFeDisplacementMapElementEClass, SVG_FE_DISPLACEMENT_MAP_ELEMENT__IN2);
		createEAttribute(svgFeDisplacementMapElementEClass, SVG_FE_DISPLACEMENT_MAP_ELEMENT__SCALE);
		createEAttribute(svgFeDisplacementMapElementEClass, SVG_FE_DISPLACEMENT_MAP_ELEMENT__XCHANNEL_SELECTOR);
		createEAttribute(svgFeDisplacementMapElementEClass, SVG_FE_DISPLACEMENT_MAP_ELEMENT__YCHANNEL_SELECTOR);

		svgFeFloodElementEClass = createEClass(SVG_FE_FLOOD_ELEMENT);
		createEAttribute(svgFeFloodElementEClass, SVG_FE_FLOOD_ELEMENT__CLASS);
		createEAttribute(svgFeFloodElementEClass, SVG_FE_FLOOD_ELEMENT__STYLE);

		svgFeGaussianBlurElementEClass = createEClass(SVG_FE_GAUSSIAN_BLUR_ELEMENT);
		createEAttribute(svgFeGaussianBlurElementEClass, SVG_FE_GAUSSIAN_BLUR_ELEMENT__CLASS);
		createEAttribute(svgFeGaussianBlurElementEClass, SVG_FE_GAUSSIAN_BLUR_ELEMENT__STYLE);
		createEAttribute(svgFeGaussianBlurElementEClass, SVG_FE_GAUSSIAN_BLUR_ELEMENT__STD_DEVIATION);

		svgFeImageElementEClass = createEClass(SVG_FE_IMAGE_ELEMENT);
		createEAttribute(svgFeImageElementEClass, SVG_FE_IMAGE_ELEMENT__CLASS);
		createEAttribute(svgFeImageElementEClass, SVG_FE_IMAGE_ELEMENT__STYLE);
		createEAttribute(svgFeImageElementEClass, SVG_FE_IMAGE_ELEMENT__EXTERNAL_RESOURCES_REQUIRED);
		createEAttribute(svgFeImageElementEClass, SVG_FE_IMAGE_ELEMENT__PRESERVE_ASPECT_RATIO);

		svgFeMergeElementEClass = createEClass(SVG_FE_MERGE_ELEMENT);
		createEAttribute(svgFeMergeElementEClass, SVG_FE_MERGE_ELEMENT__CLASS);
		createEAttribute(svgFeMergeElementEClass, SVG_FE_MERGE_ELEMENT__STYLE);

		svgFeMergeNodeElementEClass = createEClass(SVG_FE_MERGE_NODE_ELEMENT);

		svgFeMorphologyElementEClass = createEClass(SVG_FE_MORPHOLOGY_ELEMENT);
		createEAttribute(svgFeMorphologyElementEClass, SVG_FE_MORPHOLOGY_ELEMENT__CLASS);
		createEAttribute(svgFeMorphologyElementEClass, SVG_FE_MORPHOLOGY_ELEMENT__STYLE);
		createEAttribute(svgFeMorphologyElementEClass, SVG_FE_MORPHOLOGY_ELEMENT__OPERATOR);
		createEAttribute(svgFeMorphologyElementEClass, SVG_FE_MORPHOLOGY_ELEMENT__RADIUS);

		svgFeOffsetElementEClass = createEClass(SVG_FE_OFFSET_ELEMENT);
		createEAttribute(svgFeOffsetElementEClass, SVG_FE_OFFSET_ELEMENT__CLASS);
		createEAttribute(svgFeOffsetElementEClass, SVG_FE_OFFSET_ELEMENT__STYLE);
		createEAttribute(svgFeOffsetElementEClass, SVG_FE_OFFSET_ELEMENT__DX);
		createEAttribute(svgFeOffsetElementEClass, SVG_FE_OFFSET_ELEMENT__DY);

		svgFeSpecularLightingElementEClass = createEClass(SVG_FE_SPECULAR_LIGHTING_ELEMENT);
		createEAttribute(svgFeSpecularLightingElementEClass, SVG_FE_SPECULAR_LIGHTING_ELEMENT__CLASS);
		createEAttribute(svgFeSpecularLightingElementEClass, SVG_FE_SPECULAR_LIGHTING_ELEMENT__STYLE);
		createEAttribute(svgFeSpecularLightingElementEClass, SVG_FE_SPECULAR_LIGHTING_ELEMENT__SURFACE_SCALE);
		createEAttribute(svgFeSpecularLightingElementEClass, SVG_FE_SPECULAR_LIGHTING_ELEMENT__SPECULAR_CONSTANT);
		createEAttribute(svgFeSpecularLightingElementEClass, SVG_FE_SPECULAR_LIGHTING_ELEMENT__SPECULAR_EXPONENT);
		createEAttribute(svgFeSpecularLightingElementEClass, SVG_FE_SPECULAR_LIGHTING_ELEMENT__KERNEL_UNIT_LENGTH);

		svgFeTileElementEClass = createEClass(SVG_FE_TILE_ELEMENT);
		createEAttribute(svgFeTileElementEClass, SVG_FE_TILE_ELEMENT__CLASS);
		createEAttribute(svgFeTileElementEClass, SVG_FE_TILE_ELEMENT__STYLE);

		svgFeTurbulenceElementEClass = createEClass(SVG_FE_TURBULENCE_ELEMENT);
		createEAttribute(svgFeTurbulenceElementEClass, SVG_FE_TURBULENCE_ELEMENT__CLASS);
		createEAttribute(svgFeTurbulenceElementEClass, SVG_FE_TURBULENCE_ELEMENT__STYLE);
		createEAttribute(svgFeTurbulenceElementEClass, SVG_FE_TURBULENCE_ELEMENT__BASE_FREQUENCY);
		createEAttribute(svgFeTurbulenceElementEClass, SVG_FE_TURBULENCE_ELEMENT__NUM_OCTAVES);
		createEAttribute(svgFeTurbulenceElementEClass, SVG_FE_TURBULENCE_ELEMENT__SEED);
		createEAttribute(svgFeTurbulenceElementEClass, SVG_FE_TURBULENCE_ELEMENT__STITCH_TILES);
		createEAttribute(svgFeTurbulenceElementEClass, SVG_FE_TURBULENCE_ELEMENT__TYPE);

		svgAnimateElementEClass = createEClass(SVG_ANIMATE_ELEMENT);

		svgMetadataElementEClass = createEClass(SVG_METADATA_ELEMENT);

		// Create enums
		alignment_baselineEEnum = createEEnum(ALIGNMENT_BASELINE);
		clip_ruleEEnum = createEEnum(CLIP_RULE);
		color_interpolationEEnum = createEEnum(COLOR_INTERPOLATION);
		color_interpolation_filtersEEnum = createEEnum(COLOR_INTERPOLATION_FILTERS);
		color_renderingEEnum = createEEnum(COLOR_RENDERING);
		directionEEnum = createEEnum(DIRECTION);
		displayEEnum = createEEnum(DISPLAY);
		dominant_baselineEEnum = createEEnum(DOMINANT_BASELINE);
		fill_ruleEEnum = createEEnum(FILL_RULE);
		font_stretchEEnum = createEEnum(FONT_STRETCH);
		font_styleEEnum = createEEnum(FONT_STYLE);
		font_variantEEnum = createEEnum(FONT_VARIANT);
		font_weightEEnum = createEEnum(FONT_WEIGHT);
		image_renderingEEnum = createEEnum(IMAGE_RENDERING);
		overflowEEnum = createEEnum(OVERFLOW);
		pointer_eventsEEnum = createEEnum(POINTER_EVENTS);
		shape_renderingEEnum = createEEnum(SHAPE_RENDERING);
		stroke_linecapEEnum = createEEnum(STROKE_LINECAP);
		stroke_linejoinEEnum = createEEnum(STROKE_LINEJOIN);
		text_anchorEEnum = createEEnum(TEXT_ANCHOR);
		text_renderingEEnum = createEEnum(TEXT_RENDERING);
		unicode_bidiEEnum = createEEnum(UNICODE_BIDI);
		visibilityEEnum = createEEnum(VISIBILITY);
		writing_modeEEnum = createEEnum(WRITING_MODE);
		zoomAndPanEEnum = createEEnum(ZOOM_AND_PAN);
		lengthAdjustEEnum = createEEnum(LENGTH_ADJUST);
		methodEEnum = createEEnum(METHOD);
		spacingEEnum = createEEnum(SPACING);
		markerUnitsEEnum = createEEnum(MARKER_UNITS);
		rendering_intentEEnum = createEEnum(RENDERING_INTENT);
		gradientUnitsEEnum = createEEnum(GRADIENT_UNITS);
		spreadMethodEEnum = createEEnum(SPREAD_METHOD);
		patternUnitsEEnum = createEEnum(PATTERN_UNITS);
		clipPathUnitsEEnum = createEEnum(CLIP_PATH_UNITS);
		maskUnitsEEnum = createEEnum(MASK_UNITS);
		filterUnitsEEnum = createEEnum(FILTER_UNITS);
		blendModeEEnum = createEEnum(BLEND_MODE);
		colorMatrixTypeEEnum = createEEnum(COLOR_MATRIX_TYPE);
		compositeOperatorEEnum = createEEnum(COMPOSITE_OPERATOR);
		convolveMatrixEdgeModeEEnum = createEEnum(CONVOLVE_MATRIX_EDGE_MODE);
		channelSelectorEEnum = createEEnum(CHANNEL_SELECTOR);
		morphologyOperatorEEnum = createEEnum(MORPHOLOGY_OPERATOR);
		stitchTilesEEnum = createEEnum(STITCH_TILES);
		turbulenceTypeEEnum = createEEnum(TURBULENCE_TYPE);

		// Create data types
		lengthEDataType = createEDataType(LENGTH);
		angleEDataType = createEDataType(ANGLE);
		percentageEDataType = createEDataType(PERCENTAGE);
		shapeEDataType = createEDataType(SHAPE);
		funciriEDataType = createEDataType(FUNCIRI);
		colorEDataType = createEDataType(COLOR);
		paintEDataType = createEDataType(PAINT);
		opacity_valueEDataType = createEDataType(OPACITY_VALUE);
		baseline_shiftEDataType = createEDataType(BASELINE_SHIFT);
		clipEDataType = createEDataType(CLIP);
		clip_pathEDataType = createEDataType(CLIP_PATH);
		color_profileEDataType = createEDataType(COLOR_PROFILE);
		cursorEDataType = createEDataType(CURSOR);
		enable_backgroundEDataType = createEDataType(ENABLE_BACKGROUND);
		fillEDataType = createEDataType(FILL);
		fill_opacityEDataType = createEDataType(FILL_OPACITY);
		filterEDataType = createEDataType(FILTER);
		flood_colorEDataType = createEDataType(FLOOD_COLOR);
		flood_opacityEDataType = createEDataType(FLOOD_OPACITY);
		font_familyEDataType = createEDataType(FONT_FAMILY);
		font_sizeEDataType = createEDataType(FONT_SIZE);
		font_size_adjustEDataType = createEDataType(FONT_SIZE_ADJUST);
		glyph_orientation_horizontalEDataType = createEDataType(GLYPH_ORIENTATION_HORIZONTAL);
		glyph_orientation_verticalEDataType = createEDataType(GLYPH_ORIENTATION_VERTICAL);
		kerningEDataType = createEDataType(KERNING);
		letter_spacingEDataType = createEDataType(LETTER_SPACING);
		lighting_colorEDataType = createEDataType(LIGHTING_COLOR);
		marker_endEDataType = createEDataType(MARKER_END);
		marker_midEDataType = createEDataType(MARKER_MID);
		marker_startEDataType = createEDataType(MARKER_START);
		masksEDataType = createEDataType(MASKS);
		opacityEDataType = createEDataType(OPACITY);
		stop_colorEDataType = createEDataType(STOP_COLOR);
		stop_opacityEDataType = createEDataType(STOP_OPACITY);
		strokeEDataType = createEDataType(STROKE);
		stroke_dasharrayEDataType = createEDataType(STROKE_DASHARRAY);
		stroke_dashoffsetEDataType = createEDataType(STROKE_DASHOFFSET);
		stroke_miterlimitEDataType = createEDataType(STROKE_MITERLIMIT);
		stroke_opacityEDataType = createEDataType(STROKE_OPACITY);
		stroke_widthEDataType = createEDataType(STROKE_WIDTH);
		text_decorationEDataType = createEDataType(TEXT_DECORATION);
		word_spacingEDataType = createEDataType(WORD_SPACING);
		coordinateEDataType = createEDataType(COORDINATE);
		viewBoxEDataType = createEDataType(VIEW_BOX);
		preserveAspectRatioEDataType = createEDataType(PRESERVE_ASPECT_RATIO);
		numberEDataType = createEDataType(NUMBER);
		transformEDataType = createEDataType(TRANSFORM);
		pathDataEDataType = createEDataType(PATH_DATA);
		listOfPointsEDataType = createEDataType(LIST_OF_POINTS);
		listOfLengthsEDataType = createEDataType(LIST_OF_LENGTHS);
		listOfNumbersEDataType = createEDataType(LIST_OF_NUMBERS);
		listOfCoordinatesEDataType = createEDataType(LIST_OF_COORDINATES);
		nameEDataType = createEDataType(NAME);
		numberOptionalNumberEDataType = createEDataType(NUMBER_OPTIONAL_NUMBER);
		transformListEDataType = createEDataType(TRANSFORM_LIST);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters
		ETypeParameter contentElementEClass_T = addETypeParameter(contentElementEClass, "T");
		ETypeParameter containerElementEClass_T = addETypeParameter(containerElementEClass, "T");

		// Set bounds for type parameters
		EGenericType g1 = createEGenericType(this.getSvgElement());
		contentElementEClass_T.getEBounds().add(g1);
		g1 = createEGenericType(this.getSvgElement());
		containerElementEClass_T.getEBounds().add(g1);

		// Add supertypes to classes
		g1 = createEGenericType(this.getContentElement());
		EGenericType g2 = createEGenericType(containerElementEClass_T);
		g1.getETypeArguments().add(g2);
		containerElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getSvgElement());
		svgSvgElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getContainerElement());
		g2 = createEGenericType(this.getSvgElement());
		g1.getETypeArguments().add(g2);
		svgSvgElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getStructuralElement());
		svgSvgElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getConditionalProcessingAttributes());
		svgSvgElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getCoreAttributes());
		svgSvgElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getDocumentEventAttributes());
		svgSvgElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getGraphicalEventAttributes());
		svgSvgElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getPresentationAttributes());
		svgSvgElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getContentElement());
		g2 = createEGenericType(this.getSvgElement());
		g1.getETypeArguments().add(g2);
		svgSvgElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getSvgElement());
		svgGElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getContainerElement());
		g2 = createEGenericType(this.getSvgElement());
		g1.getETypeArguments().add(g2);
		svgGElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getStructuralElement());
		svgGElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getConditionalProcessingAttributes());
		svgGElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getCoreAttributes());
		svgGElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getGraphicalEventAttributes());
		svgGElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getPresentationAttributes());
		svgGElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getContentElement());
		g2 = createEGenericType(this.getSvgElement());
		g1.getETypeArguments().add(g2);
		svgGElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getSvgElement());
		svgDefsElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getContainerElement());
		g2 = createEGenericType(this.getSvgElement());
		g1.getETypeArguments().add(g2);
		svgDefsElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getStructuralElement());
		svgDefsElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getConditionalProcessingAttributes());
		svgDefsElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getCoreAttributes());
		svgDefsElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getGraphicalEventAttributes());
		svgDefsElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getPresentationAttributes());
		svgDefsElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getContentElement());
		g2 = createEGenericType(this.getSvgElement());
		g1.getETypeArguments().add(g2);
		svgDefsElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getSvgElement());
		svgDescElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getDescriptiveElement());
		svgDescElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getCoreAttributes());
		svgDescElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getContentElement());
		g2 = createEGenericType(this.getSvgElement());
		g1.getETypeArguments().add(g2);
		svgDescElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getSvgElement());
		svgTitleElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getDescriptiveElement());
		svgTitleElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getCoreAttributes());
		svgTitleElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getContentElement());
		g2 = createEGenericType(this.getSvgElement());
		g1.getETypeArguments().add(g2);
		svgTitleElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getSvgElement());
		svgSymbolElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getContainerElement());
		g2 = createEGenericType(this.getSvgElement());
		g1.getETypeArguments().add(g2);
		svgSymbolElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getStructuralElement());
		svgSymbolElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getCoreAttributes());
		svgSymbolElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getGraphicalEventAttributes());
		svgSymbolElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getPresentationAttributes());
		svgSymbolElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getContentElement());
		g2 = createEGenericType(this.getSvgElement());
		g1.getETypeArguments().add(g2);
		svgSymbolElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getSvgElement());
		svgUseElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getGraphicsElement());
		svgUseElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getGraphicsReferencingElement());
		svgUseElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getStructuralElement());
		svgUseElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getConditionalProcessingAttributes());
		svgUseElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getCoreAttributes());
		svgUseElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getGraphicalEventAttributes());
		svgUseElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getPresentationAttributes());
		svgUseElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getXLinkAttributes());
		svgUseElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getContentElement());
		g2 = createEGenericType(this.getSvgElement());
		g1.getETypeArguments().add(g2);
		svgUseElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getSvgElement());
		svgImageElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getGraphicsElement());
		svgImageElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getGraphicsReferencingElement());
		svgImageElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getConditionalProcessingAttributes());
		svgImageElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getCoreAttributes());
		svgImageElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getGraphicalEventAttributes());
		svgImageElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getPresentationAttributes());
		svgImageElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getXLinkAttributes());
		svgImageElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getContentElement());
		g2 = createEGenericType(this.getSvgElement());
		g1.getETypeArguments().add(g2);
		svgImageElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getSvgElement());
		svgSwitchElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getContainerElement());
		g2 = createEGenericType(this.getSvgElement());
		g1.getETypeArguments().add(g2);
		svgSwitchElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getConditionalProcessingAttributes());
		svgSwitchElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getCoreAttributes());
		svgSwitchElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getGraphicalEventAttributes());
		svgSwitchElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getPresentationAttributes());
		svgSwitchElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getContentElement());
		g2 = createEGenericType(this.getSvgElement());
		g1.getETypeArguments().add(g2);
		svgSwitchElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getSvgElement());
		svgPathElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getGraphicsElement());
		svgPathElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getShapeElement());
		svgPathElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getConditionalProcessingAttributes());
		svgPathElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getCoreAttributes());
		svgPathElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getGraphicalEventAttributes());
		svgPathElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getPresentationAttributes());
		svgPathElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getContentElement());
		g2 = createEGenericType(this.getSvgElement());
		g1.getETypeArguments().add(g2);
		svgPathElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getSvgElement());
		svgRectElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getBasicShapeElement());
		svgRectElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getGraphicsElement());
		svgRectElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getShapeElement());
		svgRectElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getConditionalProcessingAttributes());
		svgRectElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getCoreAttributes());
		svgRectElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getGraphicalEventAttributes());
		svgRectElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getPresentationAttributes());
		svgRectElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getContentElement());
		g2 = createEGenericType(this.getSvgElement());
		g1.getETypeArguments().add(g2);
		svgRectElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getSvgElement());
		svgCircleElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getBasicShapeElement());
		svgCircleElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getGraphicsElement());
		svgCircleElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getShapeElement());
		svgCircleElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getConditionalProcessingAttributes());
		svgCircleElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getCoreAttributes());
		svgCircleElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getGraphicalEventAttributes());
		svgCircleElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getPresentationAttributes());
		svgCircleElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getContentElement());
		g2 = createEGenericType(this.getSvgElement());
		g1.getETypeArguments().add(g2);
		svgCircleElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getSvgElement());
		svgEllipseElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getBasicShapeElement());
		svgEllipseElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getGraphicsElement());
		svgEllipseElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getShapeElement());
		svgEllipseElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getConditionalProcessingAttributes());
		svgEllipseElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getCoreAttributes());
		svgEllipseElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getGraphicalEventAttributes());
		svgEllipseElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getPresentationAttributes());
		svgEllipseElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getContentElement());
		g2 = createEGenericType(this.getSvgElement());
		g1.getETypeArguments().add(g2);
		svgEllipseElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getSvgElement());
		svgLineElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getBasicShapeElement());
		svgLineElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getGraphicsElement());
		svgLineElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getShapeElement());
		svgLineElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getConditionalProcessingAttributes());
		svgLineElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getCoreAttributes());
		svgLineElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getGraphicalEventAttributes());
		svgLineElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getPresentationAttributes());
		svgLineElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getContentElement());
		g2 = createEGenericType(this.getSvgElement());
		g1.getETypeArguments().add(g2);
		svgLineElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getSvgElement());
		svgPolylineElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getBasicShapeElement());
		svgPolylineElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getGraphicsElement());
		svgPolylineElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getShapeElement());
		svgPolylineElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getConditionalProcessingAttributes());
		svgPolylineElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getCoreAttributes());
		svgPolylineElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getGraphicalEventAttributes());
		svgPolylineElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getPresentationAttributes());
		svgPolylineElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getContentElement());
		g2 = createEGenericType(this.getSvgElement());
		g1.getETypeArguments().add(g2);
		svgPolylineElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getSvgElement());
		svgPolygonElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getBasicShapeElement());
		svgPolygonElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getGraphicsElement());
		svgPolygonElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getShapeElement());
		svgPolygonElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getConditionalProcessingAttributes());
		svgPolygonElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getCoreAttributes());
		svgPolygonElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getGraphicalEventAttributes());
		svgPolygonElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getPresentationAttributes());
		svgPolygonElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getContentElement());
		g2 = createEGenericType(this.getSvgElement());
		g1.getETypeArguments().add(g2);
		svgPolygonElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getSvgElement());
		svgTextElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getGraphicsElement());
		svgTextElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getTextContentElement());
		svgTextElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getConditionalProcessingAttributes());
		svgTextElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getCoreAttributes());
		svgTextElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getGraphicalEventAttributes());
		svgTextElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getPresentationAttributes());
		svgTextElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getContentElement());
		g2 = createEGenericType(this.getSvgElement());
		g1.getETypeArguments().add(g2);
		svgTextElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getSvgElement());
		svgTspanElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getTextContentElement());
		svgTspanElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getTextContentChildElement());
		svgTspanElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getConditionalProcessingAttributes());
		svgTspanElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getCoreAttributes());
		svgTspanElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getGraphicalEventAttributes());
		svgTspanElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getPresentationAttributes());
		svgTspanElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getContentElement());
		g2 = createEGenericType(this.getSvgElement());
		g1.getETypeArguments().add(g2);
		svgTspanElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getSvgElement());
		svgTrefElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getTextContentElement());
		svgTrefElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getTextContentChildElement());
		svgTrefElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getConditionalProcessingAttributes());
		svgTrefElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getCoreAttributes());
		svgTrefElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getGraphicalEventAttributes());
		svgTrefElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getPresentationAttributes());
		svgTrefElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getXLinkAttributes());
		svgTrefElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getContentElement());
		g2 = createEGenericType(this.getSvgElement());
		g1.getETypeArguments().add(g2);
		svgTrefElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getSvgElement());
		svgTextPathElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getTextContentElement());
		svgTextPathElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getTextContentChildElement());
		svgTextPathElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getConditionalProcessingAttributes());
		svgTextPathElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getCoreAttributes());
		svgTextPathElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getGraphicalEventAttributes());
		svgTextPathElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getPresentationAttributes());
		svgTextPathElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getXLinkAttributes());
		svgTextPathElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getContentElement());
		g2 = createEGenericType(this.getSvgElement());
		g1.getETypeArguments().add(g2);
		svgTextPathElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getSvgElement());
		svgAltGlyphElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getTextContentElement());
		svgAltGlyphElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getTextContentChildElement());
		svgAltGlyphElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getConditionalProcessingAttributes());
		svgAltGlyphElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getCoreAttributes());
		svgAltGlyphElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getGraphicalEventAttributes());
		svgAltGlyphElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getPresentationAttributes());
		svgAltGlyphElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getXLinkAttributes());
		svgAltGlyphElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getContentElement());
		g2 = createEGenericType(this.getSvgElement());
		g1.getETypeArguments().add(g2);
		svgAltGlyphElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getSvgElement());
		svgAltGlyphDefElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getCoreAttributes());
		svgAltGlyphDefElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getContentElement());
		g2 = createEGenericType(this.getSvgElement());
		g1.getETypeArguments().add(g2);
		svgAltGlyphDefElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getSvgElement());
		svgAltGlyphItemElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getCoreAttributes());
		svgAltGlyphItemElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getContentElement());
		g2 = createEGenericType(this.getSvgElement());
		g1.getETypeArguments().add(g2);
		svgAltGlyphItemElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getSvgElement());
		svgAltGlyphRefElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getCoreAttributes());
		svgAltGlyphRefElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getPresentationAttributes());
		svgAltGlyphRefElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getXLinkAttributes());
		svgAltGlyphRefElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getContentElement());
		g2 = createEGenericType(this.getSvgElement());
		g1.getETypeArguments().add(g2);
		svgAltGlyphRefElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getSvgElement());
		svgMarkerElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getCoreAttributes());
		svgMarkerElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getPresentationAttributes());
		svgMarkerElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getContentElement());
		g2 = createEGenericType(this.getSvgElement());
		g1.getETypeArguments().add(g2);
		svgMarkerElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getSvgElement());
		svgColorProfileElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getCoreAttributes());
		svgColorProfileElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getPresentationAttributes());
		svgColorProfileElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getXLinkAttributes());
		svgColorProfileElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getContentElement());
		g2 = createEGenericType(this.getSvgElement());
		g1.getETypeArguments().add(g2);
		svgColorProfileElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getSvgElement());
		svgLinearGradientElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getGradientElement());
		svgLinearGradientElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getCoreAttributes());
		svgLinearGradientElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getPresentationAttributes());
		svgLinearGradientElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getXLinkAttributes());
		svgLinearGradientElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getContentElement());
		g2 = createEGenericType(this.getSvgElement());
		g1.getETypeArguments().add(g2);
		svgLinearGradientElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getSvgElement());
		svgRadialGradientElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getGradientElement());
		svgRadialGradientElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getCoreAttributes());
		svgRadialGradientElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getPresentationAttributes());
		svgRadialGradientElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getXLinkAttributes());
		svgRadialGradientElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getContentElement());
		g2 = createEGenericType(this.getSvgElement());
		g1.getETypeArguments().add(g2);
		svgRadialGradientElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getSvgElement());
		svgStopElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getCoreAttributes());
		svgStopElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getPresentationAttributes());
		svgStopElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getContentElement());
		g2 = createEGenericType(this.getSvgElement());
		g1.getETypeArguments().add(g2);
		svgStopElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getSvgElement());
		svgPatternElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getContainerElement());
		g2 = createEGenericType(this.getSvgElement());
		g1.getETypeArguments().add(g2);
		svgPatternElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getConditionalProcessingAttributes());
		svgPatternElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getCoreAttributes());
		svgPatternElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getPresentationAttributes());
		svgPatternElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getXLinkAttributes());
		svgPatternElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getContentElement());
		g2 = createEGenericType(this.getSvgElement());
		g1.getETypeArguments().add(g2);
		svgPatternElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getSvgElement());
		svgClipPathElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getConditionalProcessingAttributes());
		svgClipPathElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getCoreAttributes());
		svgClipPathElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getPresentationAttributes());
		svgClipPathElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getContentElement());
		g2 = createEGenericType(this.getSvgElement());
		g1.getETypeArguments().add(g2);
		svgClipPathElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getSvgElement());
		svgMaskElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getConditionalProcessingAttributes());
		svgMaskElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getCoreAttributes());
		svgMaskElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getPresentationAttributes());
		svgMaskElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getContentElement());
		g2 = createEGenericType(this.getSvgElement());
		g1.getETypeArguments().add(g2);
		svgMaskElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getSvgElement());
		svgFilterElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getCoreAttributes());
		svgFilterElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getPresentationAttributes());
		svgFilterElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getXLinkAttributes());
		svgFilterElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getContentElement());
		g2 = createEGenericType(this.getSvgElement());
		g1.getETypeArguments().add(g2);
		svgFilterElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getSvgElement());
		svgFeDistantLightElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getCoreAttributes());
		svgFeDistantLightElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getContentElement());
		g2 = createEGenericType(this.getSvgElement());
		g1.getETypeArguments().add(g2);
		svgFeDistantLightElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getSvgElement());
		svgFePointLightElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getCoreAttributes());
		svgFePointLightElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getLightSourceElement());
		svgFePointLightElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getContentElement());
		g2 = createEGenericType(this.getSvgElement());
		g1.getETypeArguments().add(g2);
		svgFePointLightElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getSvgElement());
		svgFeSpotLightElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getCoreAttributes());
		svgFeSpotLightElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getLightSourceElement());
		svgFeSpotLightElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getContentElement());
		g2 = createEGenericType(this.getSvgElement());
		g1.getETypeArguments().add(g2);
		svgFeSpotLightElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getSvgElement());
		svgFeBlendElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getCoreAttributes());
		svgFeBlendElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getPresentationAttributes());
		svgFeBlendElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getFilterPrimitiveAttributes());
		svgFeBlendElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getContentElement());
		g2 = createEGenericType(this.getSvgElement());
		g1.getETypeArguments().add(g2);
		svgFeBlendElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getSvgElement());
		svgFeColorMatrixElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getCoreAttributes());
		svgFeColorMatrixElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getPresentationAttributes());
		svgFeColorMatrixElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getFilterPrimitiveAttributes());
		svgFeColorMatrixElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getContentElement());
		g2 = createEGenericType(this.getSvgElement());
		g1.getETypeArguments().add(g2);
		svgFeColorMatrixElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getSvgElement());
		svgFeComponentTransferElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getCoreAttributes());
		svgFeComponentTransferElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getPresentationAttributes());
		svgFeComponentTransferElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getFilterPrimitiveAttributes());
		svgFeComponentTransferElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getContentElement());
		g2 = createEGenericType(this.getSvgElement());
		g1.getETypeArguments().add(g2);
		svgFeComponentTransferElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getSvgElement());
		svgFeFuncRElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getCoreAttributes());
		svgFeFuncRElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getPresentationAttributes());
		svgFeFuncRElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getContentElement());
		g2 = createEGenericType(this.getSvgElement());
		g1.getETypeArguments().add(g2);
		svgFeFuncRElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getSvgElement());
		svgFeFuncGElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getCoreAttributes());
		svgFeFuncGElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getPresentationAttributes());
		svgFeFuncGElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getContentElement());
		g2 = createEGenericType(this.getSvgElement());
		g1.getETypeArguments().add(g2);
		svgFeFuncGElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getSvgElement());
		svgFeFuncBElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getCoreAttributes());
		svgFeFuncBElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getPresentationAttributes());
		svgFeFuncBElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getContentElement());
		g2 = createEGenericType(this.getSvgElement());
		g1.getETypeArguments().add(g2);
		svgFeFuncBElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getSvgElement());
		svgFeFuncAElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getCoreAttributes());
		svgFeFuncAElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getPresentationAttributes());
		svgFeFuncAElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getContentElement());
		g2 = createEGenericType(this.getSvgElement());
		g1.getETypeArguments().add(g2);
		svgFeFuncAElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getSvgElement());
		svgFeCompositeElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getCoreAttributes());
		svgFeCompositeElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getPresentationAttributes());
		svgFeCompositeElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getFilterPrimitiveAttributes());
		svgFeCompositeElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getContentElement());
		g2 = createEGenericType(this.getSvgElement());
		g1.getETypeArguments().add(g2);
		svgFeCompositeElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getSvgElement());
		svgFeConvolveMatrixElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getCoreAttributes());
		svgFeConvolveMatrixElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getPresentationAttributes());
		svgFeConvolveMatrixElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getFilterPrimitiveAttributes());
		svgFeConvolveMatrixElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getContentElement());
		g2 = createEGenericType(this.getSvgElement());
		g1.getETypeArguments().add(g2);
		svgFeConvolveMatrixElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getSvgElement());
		svgFeDiffuseLightingElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getCoreAttributes());
		svgFeDiffuseLightingElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getPresentationAttributes());
		svgFeDiffuseLightingElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getFilterPrimitiveAttributes());
		svgFeDiffuseLightingElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getContentElement());
		g2 = createEGenericType(this.getSvgElement());
		g1.getETypeArguments().add(g2);
		svgFeDiffuseLightingElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getSvgElement());
		svgFeDisplacementMapElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getCoreAttributes());
		svgFeDisplacementMapElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getPresentationAttributes());
		svgFeDisplacementMapElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getFilterPrimitiveAttributes());
		svgFeDisplacementMapElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getContentElement());
		g2 = createEGenericType(this.getSvgElement());
		g1.getETypeArguments().add(g2);
		svgFeDisplacementMapElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getSvgElement());
		svgFeFloodElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getCoreAttributes());
		svgFeFloodElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getPresentationAttributes());
		svgFeFloodElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getFilterPrimitiveAttributes());
		svgFeFloodElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getContentElement());
		g2 = createEGenericType(this.getSvgElement());
		g1.getETypeArguments().add(g2);
		svgFeFloodElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getSvgElement());
		svgFeGaussianBlurElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getCoreAttributes());
		svgFeGaussianBlurElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getPresentationAttributes());
		svgFeGaussianBlurElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getFilterPrimitiveAttributes());
		svgFeGaussianBlurElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getContentElement());
		g2 = createEGenericType(this.getSvgElement());
		g1.getETypeArguments().add(g2);
		svgFeGaussianBlurElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getFilterPrimitiveElement());
		svgFeGaussianBlurElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getSvgElement());
		svgFeImageElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getCoreAttributes());
		svgFeImageElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getPresentationAttributes());
		svgFeImageElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getFilterPrimitiveAttributes());
		svgFeImageElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getXLinkAttributes());
		svgFeImageElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getContentElement());
		g2 = createEGenericType(this.getSvgElement());
		g1.getETypeArguments().add(g2);
		svgFeImageElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getSvgElement());
		svgFeMergeElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getCoreAttributes());
		svgFeMergeElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getPresentationAttributes());
		svgFeMergeElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getFilterPrimitiveAttributes());
		svgFeMergeElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getContentElement());
		g2 = createEGenericType(this.getSvgElement());
		g1.getETypeArguments().add(g2);
		svgFeMergeElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getSvgElement());
		svgFeMergeNodeElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getCoreAttributes());
		svgFeMergeNodeElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getContentElement());
		g2 = createEGenericType(this.getSvgElement());
		g1.getETypeArguments().add(g2);
		svgFeMergeNodeElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getSvgElement());
		svgFeMorphologyElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getCoreAttributes());
		svgFeMorphologyElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getPresentationAttributes());
		svgFeMorphologyElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getFilterPrimitiveAttributes());
		svgFeMorphologyElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getContentElement());
		g2 = createEGenericType(this.getSvgElement());
		g1.getETypeArguments().add(g2);
		svgFeMorphologyElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getSvgElement());
		svgFeOffsetElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getCoreAttributes());
		svgFeOffsetElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getPresentationAttributes());
		svgFeOffsetElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getFilterPrimitiveAttributes());
		svgFeOffsetElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getContentElement());
		g2 = createEGenericType(this.getSvgElement());
		g1.getETypeArguments().add(g2);
		svgFeOffsetElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getSvgElement());
		svgFeSpecularLightingElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getCoreAttributes());
		svgFeSpecularLightingElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getPresentationAttributes());
		svgFeSpecularLightingElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getFilterPrimitiveAttributes());
		svgFeSpecularLightingElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getContentElement());
		g2 = createEGenericType(this.getSvgElement());
		g1.getETypeArguments().add(g2);
		svgFeSpecularLightingElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getSvgElement());
		svgFeTileElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getCoreAttributes());
		svgFeTileElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getPresentationAttributes());
		svgFeTileElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getFilterPrimitiveAttributes());
		svgFeTileElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getContentElement());
		g2 = createEGenericType(this.getSvgElement());
		g1.getETypeArguments().add(g2);
		svgFeTileElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getSvgElement());
		svgFeTurbulenceElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getCoreAttributes());
		svgFeTurbulenceElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getPresentationAttributes());
		svgFeTurbulenceElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getFilterPrimitiveAttributes());
		svgFeTurbulenceElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getContentElement());
		g2 = createEGenericType(this.getSvgElement());
		g1.getETypeArguments().add(g2);
		svgFeTurbulenceElementEClass.getEGenericSuperTypes().add(g1);
		svgAnimateElementEClass.getESuperTypes().add(this.getSvgElement());
		svgMetadataElementEClass.getESuperTypes().add(this.getSvgElement());
		svgMetadataElementEClass.getESuperTypes().add(this.getCoreAttributes());

		// Initialize classes and features; add operations and parameters
		initEClass(contentElementEClass, ContentElement.class, "ContentElement", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		g1 = createEGenericType(contentElementEClass_T);
		initEReference(getContentElement_Children(), g1, null, "children", null, 0, -1, ContentElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(containerElementEClass, ContainerElement.class, "ContainerElement", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(structuralElementEClass, StructuralElement.class, "StructuralElement", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(svgElementEClass, SvgElement.class, "SvgElement", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(descriptiveElementEClass, DescriptiveElement.class, "DescriptiveElement", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(graphicsElementEClass, GraphicsElement.class, "GraphicsElement", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(graphicsReferencingElementEClass, GraphicsReferencingElement.class, "GraphicsReferencingElement", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(shapeElementEClass, ShapeElement.class, "ShapeElement", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(basicShapeElementEClass, BasicShapeElement.class, "BasicShapeElement", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(textContentElementEClass, TextContentElement.class, "TextContentElement", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(textContentChildElementEClass, TextContentChildElement.class, "TextContentChildElement", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(gradientElementEClass, GradientElement.class, "GradientElement", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(lightSourceElementEClass, LightSourceElement.class, "LightSourceElement", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(filterPrimitiveElementEClass, FilterPrimitiveElement.class, "FilterPrimitiveElement", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(animationElementEClass, AnimationElement.class, "AnimationElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(____ENUMS____EClass, ____ENUMS____.class, "____ENUMS____", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(____DATATYPES____EClass, ____DATATYPES____.class, "____DATATYPES____", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(____ATTRIBUTES____EClass, ____ATTRIBUTES____.class, "____ATTRIBUTES____", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(conditionalProcessingAttributesEClass, ConditionalProcessingAttributes.class, "ConditionalProcessingAttributes", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConditionalProcessingAttributes_RequiredFeatures(), ecorePackage.getEString(), "requiredFeatures", null, 0, 1, ConditionalProcessingAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConditionalProcessingAttributes_RequiredExtensions(), ecorePackage.getEString(), "requiredExtensions", null, 0, 1, ConditionalProcessingAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConditionalProcessingAttributes_SystemLanguage(), ecorePackage.getEString(), "systemLanguage", null, 0, 1, ConditionalProcessingAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(coreAttributesEClass, CoreAttributes.class, "CoreAttributes", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCoreAttributes_Id(), ecorePackage.getEString(), "id", null, 0, 1, CoreAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCoreAttributes_Xml__base(), ecorePackage.getEString(), "xml__base", null, 0, 1, CoreAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCoreAttributes_Xml__lang(), ecorePackage.getEString(), "xml__lang", null, 0, 1, CoreAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCoreAttributes_Xml__space(), ecorePackage.getEString(), "xml__space", null, 0, 1, CoreAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(documentEventAttributesEClass, DocumentEventAttributes.class, "DocumentEventAttributes", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDocumentEventAttributes_Onunload(), ecorePackage.getEString(), "onunload", null, 0, 1, DocumentEventAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDocumentEventAttributes_Onabort(), ecorePackage.getEString(), "onabort", null, 0, 1, DocumentEventAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDocumentEventAttributes_Onerror(), ecorePackage.getEString(), "onerror", null, 0, 1, DocumentEventAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDocumentEventAttributes_Onresize(), ecorePackage.getEString(), "onresize", null, 0, 1, DocumentEventAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDocumentEventAttributes_Onscroll(), ecorePackage.getEString(), "onscroll", null, 0, 1, DocumentEventAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDocumentEventAttributes_Onzoom(), ecorePackage.getEString(), "onzoom", null, 0, 1, DocumentEventAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(graphicalEventAttributesEClass, GraphicalEventAttributes.class, "GraphicalEventAttributes", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGraphicalEventAttributes_Onfocusin(), ecorePackage.getEString(), "onfocusin", null, 0, 1, GraphicalEventAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGraphicalEventAttributes_Onfocusout(), ecorePackage.getEString(), "onfocusout", null, 0, 1, GraphicalEventAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGraphicalEventAttributes_Onactivate(), ecorePackage.getEString(), "onactivate", null, 0, 1, GraphicalEventAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGraphicalEventAttributes_Onclick(), ecorePackage.getEString(), "onclick", null, 0, 1, GraphicalEventAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGraphicalEventAttributes_Onmousedown(), ecorePackage.getEString(), "onmousedown", null, 0, 1, GraphicalEventAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGraphicalEventAttributes_Onmouseup(), ecorePackage.getEString(), "onmouseup", null, 0, 1, GraphicalEventAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGraphicalEventAttributes_Onmouseover(), ecorePackage.getEString(), "onmouseover", null, 0, 1, GraphicalEventAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGraphicalEventAttributes_Onmousemove(), ecorePackage.getEString(), "onmousemove", null, 0, 1, GraphicalEventAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGraphicalEventAttributes_Onmouseout(), ecorePackage.getEString(), "onmouseout", null, 0, 1, GraphicalEventAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGraphicalEventAttributes_Onload(), ecorePackage.getEString(), "onload", null, 0, 1, GraphicalEventAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(presentationAttributesEClass, PresentationAttributes.class, "PresentationAttributes", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPresentationAttributes_Alignment_baseline(), this.getAlignment_baseline(), "alignment_baseline", "alignment_baseline.auto", 0, 1, PresentationAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPresentationAttributes_Baseline_shift(), this.getBaseline_shift(), "baseline_shift", "\"baseline\"", 0, 1, PresentationAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPresentationAttributes_Clip(), this.getClip(), "clip", "auto", 0, 1, PresentationAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPresentationAttributes_Clip_path(), this.getClip_path(), "clip_path", "none", 0, 1, PresentationAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPresentationAttributes_Clip_rule(), this.getClip_rule(), "clip_rule", "clip_rule.nonzero", 0, 1, PresentationAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPresentationAttributes_Color(), this.getColor(), "color", null, 0, 1, PresentationAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPresentationAttributes_Color_interpolation(), this.getColor_interpolation(), "color_interpolation", "color_interpolation.sRGB", 0, 1, PresentationAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPresentationAttributes_Color_interpolation_filters(), this.getColor_interpolation_filters(), "color_interpolation_filters", "color_interpolation_filters.linearRGB", 0, 1, PresentationAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPresentationAttributes_Color_profile(), this.getColor_profile(), "color_profile", "\"auto\"", 0, 1, PresentationAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPresentationAttributes_Color_rendering(), this.getColor_rendering(), "color_rendering", "\"auto\"", 0, 1, PresentationAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPresentationAttributes_Cursor(), this.getCursor(), "cursor", "\"auto\"", 0, 1, PresentationAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPresentationAttributes_Direction(), this.getDirection(), "direction", "direction.ltr", 0, 1, PresentationAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPresentationAttributes_Display(), this.getDisplay(), "display", "display.inline", 0, 1, PresentationAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPresentationAttributes_Dominant_baseline(), this.getDominant_baseline(), "dominant_baseline", "dominant_baseline.auto", 0, 1, PresentationAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPresentationAttributes_Enable_background(), this.getEnable_background(), "enable_background", "\"inherit\"", 0, 1, PresentationAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPresentationAttributes_Fill(), this.getFill(), "fill", "black", 0, 1, PresentationAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPresentationAttributes_Fill_opacity(), this.getFill_opacity(), "fill_opacity", "1", 0, 1, PresentationAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPresentationAttributes_Fill_rule(), this.getFill_rule(), "fill_rule", "fill_rule.nonzero", 0, 1, PresentationAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPresentationAttributes_Filter(), this.getFilter(), "filter", "\"none\"", 0, 1, PresentationAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPresentationAttributes_Flood_color(), this.getFlood_color(), "flood_color", "\"black\"", 0, 1, PresentationAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPresentationAttributes_Flood_opacity(), this.getFlood_opacity(), "flood_opacity", "\"1\"", 0, 1, PresentationAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPresentationAttributes_Font_family(), this.getFont_family(), "font_family", null, 0, 1, PresentationAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPresentationAttributes_Font_size(), this.getFont_size(), "font_size", "\"medium\"", 0, 1, PresentationAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPresentationAttributes_Font_size_adjust(), this.getFont_size_adjust(), "font_size_adjust", "\"none\"", 0, 1, PresentationAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPresentationAttributes_Font_stretch(), this.getFont_stretch(), "font_stretch", "font_stretch.none", 0, 1, PresentationAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPresentationAttributes_Font_style(), this.getFont_style(), "font_style", "font_style.normal", 0, 1, PresentationAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPresentationAttributes_Font_variant(), this.getFont_variant(), "font_variant", "font_variant.normal", 0, 1, PresentationAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPresentationAttributes_Font_weight(), this.getFont_weight(), "font_weight", "font_weight.normal", 0, 1, PresentationAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPresentationAttributes_Glyph_orientation_horizontal(), this.getGlyph_orientation_horizontal(), "glyph_orientation_horizontal", "\"0deg\"", 0, 1, PresentationAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPresentationAttributes_Glyph_orientation_vertical(), this.getGlyph_orientation_vertical(), "glyph_orientation_vertical", "\"auto\"", 0, 1, PresentationAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPresentationAttributes_Image_rendering(), this.getImage_rendering(), "image_rendering", "\"auto\"", 0, 1, PresentationAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPresentationAttributes_Kerning(), this.getKerning(), "kerning", "\"auto\"", 0, 1, PresentationAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPresentationAttributes_Letter_spacing(), this.getLetter_spacing(), "letter_spacing", "\"normal\"", 0, 1, PresentationAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPresentationAttributes_Lighting_color(), this.getLighting_color(), "lighting_color", "\"white\"", 0, 1, PresentationAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPresentationAttributes_Marker_end(), this.getMarker_end(), "marker_end", "\"none\"", 0, 1, PresentationAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPresentationAttributes_Marker_mid(), this.getMarker_mid(), "marker_mid", "\"none\"", 0, 1, PresentationAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPresentationAttributes_Marker_start(), this.getMarker_start(), "marker_start", "\"none\"", 0, 1, PresentationAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPresentationAttributes_Masks(), this.getMasks(), "masks", "\"none\"", 0, 1, PresentationAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPresentationAttributes_Opacity(), this.getOpacity(), "opacity", "1", 0, 1, PresentationAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPresentationAttributes_Overflow(), this.getOverflow(), "overflow", "null", 0, 1, PresentationAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPresentationAttributes_Pointer_events(), this.getPointer_events(), "pointer_events", "pointer_events.visiblePainted", 0, 1, PresentationAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPresentationAttributes_Shape_rendering(), this.getShape_rendering(), "shape_rendering", "shape_rendering.auto", 0, 1, PresentationAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPresentationAttributes_Stop_color(), this.getStop_color(), "stop_color", "black", 0, 1, PresentationAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPresentationAttributes_Stop_opacity(), this.getStop_opacity(), "stop_opacity", "1", 0, 1, PresentationAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPresentationAttributes_Stroke(), this.getStroke(), "stroke", "none", 0, 1, PresentationAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPresentationAttributes_Stroke_dasharray(), this.getStroke_dasharray(), "stroke_dasharray", "none", 0, 1, PresentationAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPresentationAttributes_Stroke_dashoffset(), this.getStroke_dashoffset(), "stroke_dashoffset", "0", 0, 1, PresentationAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPresentationAttributes_Stroke_linecap(), this.getStroke_linecap(), "stroke_linecap", "Stroke_linecap.butt", 0, 1, PresentationAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPresentationAttributes_Stroke_linejoin(), this.getStroke_linejoin(), "stroke_linejoin", "stroke_linejoin.miter", 0, 1, PresentationAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPresentationAttributes_Stroke_miterlimit(), this.getStroke_miterlimit(), "stroke_miterlimit", "4", 0, 1, PresentationAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPresentationAttributes_Stroke_opacity(), this.getStroke_opacity(), "stroke_opacity", "1", 0, 1, PresentationAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPresentationAttributes_Stroke_width(), this.getStroke_width(), "stroke_width", "1", 0, 1, PresentationAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPresentationAttributes_Text_anchor(), this.getText_anchor(), "text_anchor", "text_anchor.start", 0, 1, PresentationAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPresentationAttributes_Text_decoration(), this.getText_decoration(), "text_decoration", "\"none\"", 0, 1, PresentationAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPresentationAttributes_Text_rendering(), this.getText_rendering(), "text_rendering", "text_rendering.auto", 0, 1, PresentationAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPresentationAttributes_Unicode_bidi(), this.getUnicode_bidi(), "unicode_bidi", "unicode_bidi.normal", 0, 1, PresentationAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPresentationAttributes_Visibility(), this.getVisibility(), "visibility", "visibility.visible", 0, 1, PresentationAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPresentationAttributes_Word_spacing(), this.getWord_spacing(), "word_spacing", "\"normal\"", 0, 1, PresentationAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPresentationAttributes_Writing_mode(), this.getWriting_mode(), "writing_mode", "writing_mode.lr_tb", 0, 1, PresentationAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xLinkAttributesEClass, XLinkAttributes.class, "XLinkAttributes", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getXLinkAttributes_Xlink__href(), ecorePackage.getEString(), "xlink__href", null, 0, 1, XLinkAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXLinkAttributes_Xlink__show(), ecorePackage.getEString(), "xlink__show", null, 0, 1, XLinkAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXLinkAttributes_Xlink__actuate(), ecorePackage.getEString(), "xlink__actuate", null, 0, 1, XLinkAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXLinkAttributes_Xlink__type(), ecorePackage.getEString(), "xlink__type", null, 0, 1, XLinkAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXLinkAttributes_Xlink__role(), ecorePackage.getEString(), "xlink__role", null, 0, 1, XLinkAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXLinkAttributes_Xlink__arcrole(), ecorePackage.getEString(), "xlink__arcrole", null, 0, 1, XLinkAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXLinkAttributes_Xlink__title(), ecorePackage.getEString(), "xlink__title", null, 0, 1, XLinkAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXLinkAttributes_ResolvedInstance(), this.getSvgElement(), null, "resolvedInstance", null, 0, 1, XLinkAttributes.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(filterPrimitiveAttributesEClass, FilterPrimitiveAttributes.class, "FilterPrimitiveAttributes", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFilterPrimitiveAttributes_X(), this.getCoordinate(), "x", null, 0, 1, FilterPrimitiveAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFilterPrimitiveAttributes_Y(), this.getCoordinate(), "y", null, 0, 1, FilterPrimitiveAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFilterPrimitiveAttributes_Width(), this.getLength(), "width", null, 0, 1, FilterPrimitiveAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFilterPrimitiveAttributes_Height(), this.getLength(), "height", null, 0, 1, FilterPrimitiveAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFilterPrimitiveAttributes_Result(), ecorePackage.getEString(), "result", null, 0, 1, FilterPrimitiveAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFilterPrimitiveAttributes_In(), ecorePackage.getEString(), "in", null, 0, 1, FilterPrimitiveAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(____ELEMENTES____EClass, ____ELEMENTES____.class, "____ELEMENTES____", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(svgSvgElementEClass, SvgSvgElement.class, "SvgSvgElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSvgSvgElement_Class(), ecorePackage.getEString(), "class", null, 0, 1, SvgSvgElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgSvgElement_Style(), ecorePackage.getEString(), "style", null, 0, 1, SvgSvgElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgSvgElement_ExternalResourcesRequired(), ecorePackage.getEString(), "externalResourcesRequired", null, 0, 1, SvgSvgElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgSvgElement_X(), this.getCoordinate(), "x", null, 0, 1, SvgSvgElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgSvgElement_Y(), this.getCoordinate(), "y", null, 0, 1, SvgSvgElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgSvgElement_Width(), this.getLength(), "width", null, 0, 1, SvgSvgElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgSvgElement_Height(), this.getLength(), "height", null, 0, 1, SvgSvgElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgSvgElement_ViewBox(), this.getViewBox(), "viewBox", null, 0, 1, SvgSvgElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgSvgElement_PreserveAspectRatio(), this.getPreserveAspectRatio(), "preserveAspectRatio", null, 0, 1, SvgSvgElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgSvgElement_ZoomAndPan(), this.getZoomAndPan(), "zoomAndPan", "zoomandpan.disable", 0, 1, SvgSvgElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgSvgElement_Version(), this.getNumber(), "version", null, 0, 1, SvgSvgElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgSvgElement_BaseProfile(), ecorePackage.getEString(), "baseProfile", null, 0, 1, SvgSvgElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgSvgElement_ContentScriptType(), ecorePackage.getEString(), "contentScriptType", null, 0, 1, SvgSvgElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgSvgElement_ContentStyleType(), ecorePackage.getEString(), "contentStyleType", null, 0, 1, SvgSvgElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgSvgElement_StyleSheet(), ecorePackage.getEString(), "styleSheet", null, 0, 1, SvgSvgElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(svgGElementEClass, SvgGElement.class, "SvgGElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSvgGElement_Class(), ecorePackage.getEString(), "class", null, 0, 1, SvgGElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgGElement_Style(), ecorePackage.getEString(), "style", null, 0, 1, SvgGElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgGElement_ExternalResourcesRequired(), ecorePackage.getEString(), "externalResourcesRequired", null, 0, 1, SvgGElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgGElement_Transform(), this.getTransform(), "transform", null, 0, 1, SvgGElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgGElement_X(), this.getCoordinate(), "x", null, 0, 1, SvgGElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgGElement_Y(), this.getCoordinate(), "y", null, 0, 1, SvgGElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(svgDefsElementEClass, SvgDefsElement.class, "SvgDefsElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSvgDefsElement_Class(), ecorePackage.getEString(), "class", null, 0, 1, SvgDefsElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgDefsElement_Style(), ecorePackage.getEString(), "style", null, 0, 1, SvgDefsElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgDefsElement_ExternalResourcesRequired(), ecorePackage.getEString(), "externalResourcesRequired", null, 0, 1, SvgDefsElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgDefsElement_Transform(), this.getTransform(), "transform", null, 0, 1, SvgDefsElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(svgDescElementEClass, SvgDescElement.class, "SvgDescElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSvgDescElement_Class(), ecorePackage.getEString(), "class", null, 0, 1, SvgDescElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgDescElement_Style(), ecorePackage.getEString(), "style", null, 0, 1, SvgDescElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(svgTitleElementEClass, SvgTitleElement.class, "SvgTitleElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSvgTitleElement_Class(), ecorePackage.getEString(), "class", null, 0, 1, SvgTitleElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgTitleElement_Style(), ecorePackage.getEString(), "style", null, 0, 1, SvgTitleElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(svgSymbolElementEClass, SvgSymbolElement.class, "SvgSymbolElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSvgSymbolElement_Class(), ecorePackage.getEString(), "class", null, 0, 1, SvgSymbolElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgSymbolElement_Style(), ecorePackage.getEString(), "style", null, 0, 1, SvgSymbolElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgSymbolElement_ExternalResourcesRequired(), ecorePackage.getEString(), "externalResourcesRequired", null, 0, 1, SvgSymbolElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgSymbolElement_ViewBox(), this.getViewBox(), "viewBox", null, 0, 1, SvgSymbolElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgSymbolElement_PreserveAspectRatio(), this.getPreserveAspectRatio(), "preserveAspectRatio", null, 0, 1, SvgSymbolElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(svgUseElementEClass, SvgUseElement.class, "SvgUseElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSvgUseElement_Class(), ecorePackage.getEString(), "class", null, 0, 1, SvgUseElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgUseElement_Style(), ecorePackage.getEString(), "style", null, 0, 1, SvgUseElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgUseElement_ExternalResourcesRequired(), ecorePackage.getEString(), "externalResourcesRequired", null, 0, 1, SvgUseElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgUseElement_Transform(), this.getTransform(), "transform", null, 0, 1, SvgUseElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgUseElement_Width(), this.getLength(), "width", null, 0, 1, SvgUseElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgUseElement_Height(), this.getLength(), "height", null, 0, 1, SvgUseElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgUseElement_X(), this.getCoordinate(), "x", null, 0, 1, SvgUseElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgUseElement_Y(), this.getCoordinate(), "y", null, 0, 1, SvgUseElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(svgImageElementEClass, SvgImageElement.class, "SvgImageElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSvgImageElement_Class(), ecorePackage.getEString(), "class", null, 0, 1, SvgImageElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgImageElement_Style(), ecorePackage.getEString(), "style", null, 0, 1, SvgImageElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgImageElement_ExternalResourcesRequired(), ecorePackage.getEString(), "externalResourcesRequired", null, 0, 1, SvgImageElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgImageElement_PreserveAspectRatio(), this.getPreserveAspectRatio(), "preserveAspectRatio", null, 0, 1, SvgImageElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgImageElement_Transform(), this.getTransform(), "transform", null, 0, 1, SvgImageElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgImageElement_X(), this.getCoordinate(), "x", null, 0, 1, SvgImageElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgImageElement_Y(), this.getCoordinate(), "y", null, 0, 1, SvgImageElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgImageElement_Width(), this.getLength(), "width", null, 0, 1, SvgImageElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgImageElement_Height(), this.getLength(), "height", null, 0, 1, SvgImageElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(svgSwitchElementEClass, SvgSwitchElement.class, "SvgSwitchElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSvgSwitchElement_Class(), ecorePackage.getEString(), "class", null, 0, 1, SvgSwitchElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgSwitchElement_Style(), ecorePackage.getEString(), "style", null, 0, 1, SvgSwitchElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgSwitchElement_ExternalResourcesRequired(), ecorePackage.getEString(), "externalResourcesRequired", null, 0, 1, SvgSwitchElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgSwitchElement_Transform(), this.getTransform(), "transform", null, 0, 1, SvgSwitchElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(svgPathElementEClass, SvgPathElement.class, "SvgPathElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSvgPathElement_Class(), ecorePackage.getEString(), "class", null, 0, 1, SvgPathElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgPathElement_Style(), ecorePackage.getEString(), "style", null, 0, 1, SvgPathElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgPathElement_ExternalResourcesRequired(), ecorePackage.getEString(), "externalResourcesRequired", null, 0, 1, SvgPathElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgPathElement_Transform(), this.getTransform(), "transform", null, 0, 1, SvgPathElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgPathElement_D(), this.getPathData(), "d", null, 0, 1, SvgPathElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgPathElement_PathLength(), this.getNumber(), "pathLength", null, 0, 1, SvgPathElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(svgRectElementEClass, SvgRectElement.class, "SvgRectElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSvgRectElement_Class(), ecorePackage.getEString(), "class", null, 0, 1, SvgRectElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgRectElement_Style(), ecorePackage.getEString(), "style", null, 0, 1, SvgRectElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgRectElement_ExternalResourcesRequired(), ecorePackage.getEString(), "externalResourcesRequired", null, 0, 1, SvgRectElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgRectElement_Transform(), this.getTransform(), "transform", null, 0, 1, SvgRectElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgRectElement_X(), this.getCoordinate(), "x", null, 0, 1, SvgRectElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgRectElement_Y(), this.getCoordinate(), "y", null, 0, 1, SvgRectElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgRectElement_Width(), this.getLength(), "width", null, 0, 1, SvgRectElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgRectElement_Height(), this.getLength(), "height", null, 0, 1, SvgRectElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgRectElement_Rx(), this.getLength(), "rx", null, 0, 1, SvgRectElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgRectElement_Ry(), this.getLength(), "ry", null, 0, 1, SvgRectElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(svgCircleElementEClass, SvgCircleElement.class, "SvgCircleElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSvgCircleElement_Class(), ecorePackage.getEString(), "class", null, 0, 1, SvgCircleElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgCircleElement_Style(), ecorePackage.getEString(), "style", null, 0, 1, SvgCircleElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgCircleElement_ExternalResourcesRequired(), ecorePackage.getEString(), "externalResourcesRequired", null, 0, 1, SvgCircleElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgCircleElement_Transform(), this.getTransform(), "transform", null, 0, 1, SvgCircleElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgCircleElement_Cx(), this.getCoordinate(), "cx", null, 0, 1, SvgCircleElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgCircleElement_Cy(), this.getCoordinate(), "cy", null, 0, 1, SvgCircleElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgCircleElement_R(), this.getLength(), "r", null, 0, 1, SvgCircleElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(svgEllipseElementEClass, SvgEllipseElement.class, "SvgEllipseElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSvgEllipseElement_Class(), ecorePackage.getEString(), "class", null, 0, 1, SvgEllipseElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgEllipseElement_Style(), ecorePackage.getEString(), "style", null, 0, 1, SvgEllipseElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgEllipseElement_ExternalResourcesRequired(), ecorePackage.getEString(), "externalResourcesRequired", null, 0, 1, SvgEllipseElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgEllipseElement_Transform(), this.getTransform(), "transform", null, 0, 1, SvgEllipseElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgEllipseElement_Cx(), this.getCoordinate(), "cx", null, 0, 1, SvgEllipseElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgEllipseElement_Cy(), this.getCoordinate(), "cy", null, 0, 1, SvgEllipseElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgEllipseElement_Rx(), this.getLength(), "rx", null, 0, 1, SvgEllipseElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgEllipseElement_Ry(), this.getLength(), "ry", null, 0, 1, SvgEllipseElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(svgLineElementEClass, SvgLineElement.class, "SvgLineElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSvgLineElement_Class(), ecorePackage.getEString(), "class", null, 0, 1, SvgLineElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgLineElement_Style(), ecorePackage.getEString(), "style", null, 0, 1, SvgLineElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgLineElement_ExternalResourcesRequired(), ecorePackage.getEString(), "externalResourcesRequired", null, 0, 1, SvgLineElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgLineElement_Transform(), this.getTransform(), "transform", null, 0, 1, SvgLineElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgLineElement_X1(), this.getCoordinate(), "x1", null, 0, 1, SvgLineElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgLineElement_Y1(), this.getCoordinate(), "y1", null, 0, 1, SvgLineElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgLineElement_X2(), this.getCoordinate(), "x2", null, 0, 1, SvgLineElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgLineElement_Y2(), this.getCoordinate(), "y2", null, 0, 1, SvgLineElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(svgPolylineElementEClass, SvgPolylineElement.class, "SvgPolylineElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSvgPolylineElement_Class(), ecorePackage.getEString(), "class", null, 0, 1, SvgPolylineElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgPolylineElement_Style(), ecorePackage.getEString(), "style", null, 0, 1, SvgPolylineElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgPolylineElement_ExternalResourcesRequired(), ecorePackage.getEString(), "externalResourcesRequired", null, 0, 1, SvgPolylineElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgPolylineElement_Transform(), this.getTransform(), "transform", null, 0, 1, SvgPolylineElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgPolylineElement_Points(), this.getListOfPoints(), "points", null, 0, 1, SvgPolylineElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(svgPolygonElementEClass, SvgPolygonElement.class, "SvgPolygonElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSvgPolygonElement_Class(), ecorePackage.getEString(), "class", null, 0, 1, SvgPolygonElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgPolygonElement_Style(), ecorePackage.getEString(), "style", null, 0, 1, SvgPolygonElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgPolygonElement_ExternalResourcesRequired(), ecorePackage.getEString(), "externalResourcesRequired", null, 0, 1, SvgPolygonElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgPolygonElement_Transform(), this.getTransform(), "transform", null, 0, 1, SvgPolygonElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgPolygonElement_Points(), this.getListOfPoints(), "points", null, 0, 1, SvgPolygonElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(svgTextElementEClass, SvgTextElement.class, "SvgTextElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSvgTextElement_Class(), ecorePackage.getEString(), "class", null, 0, 1, SvgTextElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgTextElement_Style(), ecorePackage.getEString(), "style", null, 0, 1, SvgTextElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgTextElement_ExternalResourcesRequired(), ecorePackage.getEString(), "externalResourcesRequired", null, 0, 1, SvgTextElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgTextElement_Transform(), this.getTransform(), "transform", null, 0, 1, SvgTextElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgTextElement_LengthAdjust(), this.getLengthAdjust(), "lengthAdjust", "LengthAdjust.spacing", 0, 1, SvgTextElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgTextElement_X(), this.getCoordinate(), "x", null, 0, 1, SvgTextElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgTextElement_Y(), this.getCoordinate(), "y", null, 0, 1, SvgTextElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgTextElement_Dx(), this.getListOfLengths(), "dx", null, 0, 1, SvgTextElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgTextElement_Dy(), this.getListOfLengths(), "dy", null, 0, 1, SvgTextElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgTextElement_Rotate(), this.getListOfNumbers(), "rotate", null, 0, 1, SvgTextElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgTextElement_TextLength(), this.getLength(), "textLength", null, 0, 1, SvgTextElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgTextElement_TextContent(), ecorePackage.getEString(), "textContent", null, 0, 1, SvgTextElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(svgTspanElementEClass, SvgTspanElement.class, "SvgTspanElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSvgTspanElement_Class(), ecorePackage.getEString(), "class", null, 0, 1, SvgTspanElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgTspanElement_Style(), ecorePackage.getEString(), "style", null, 0, 1, SvgTspanElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgTspanElement_ExternalResourcesRequired(), ecorePackage.getEString(), "externalResourcesRequired", null, 0, 1, SvgTspanElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgTspanElement_X(), this.getListOfCoordinates(), "x", null, 0, 1, SvgTspanElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgTspanElement_Y(), this.getListOfCoordinates(), "y", null, 0, 1, SvgTspanElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgTspanElement_Dx(), this.getListOfLengths(), "dx", null, 0, 1, SvgTspanElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgTspanElement_Dy(), this.getListOfLengths(), "dy", null, 0, 1, SvgTspanElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgTspanElement_Rotate(), this.getListOfNumbers(), "rotate", null, 0, 1, SvgTspanElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgTspanElement_TextLength(), this.getLength(), "textLength", null, 0, 1, SvgTspanElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgTspanElement_LengthAdjust(), this.getLengthAdjust(), "lengthAdjust", "LengthAdjust.spacing", 0, 1, SvgTspanElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(svgTrefElementEClass, SvgTrefElement.class, "SvgTrefElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSvgTrefElement_Class(), ecorePackage.getEString(), "class", null, 0, 1, SvgTrefElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgTrefElement_Style(), ecorePackage.getEString(), "style", null, 0, 1, SvgTrefElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgTrefElement_ExternalResourcesRequired(), ecorePackage.getEString(), "externalResourcesRequired", null, 0, 1, SvgTrefElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(svgTextPathElementEClass, SvgTextPathElement.class, "SvgTextPathElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSvgTextPathElement_Class(), ecorePackage.getEString(), "class", null, 0, 1, SvgTextPathElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgTextPathElement_Style(), ecorePackage.getEString(), "style", null, 0, 1, SvgTextPathElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgTextPathElement_ExternalResourcesRequired(), ecorePackage.getEString(), "externalResourcesRequired", null, 0, 1, SvgTextPathElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgTextPathElement_StartOffset(), this.getLength(), "startOffset", null, 0, 1, SvgTextPathElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgTextPathElement_Method(), this.getMethod(), "method", "Method.align", 0, 1, SvgTextPathElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgTextPathElement_Spacing(), this.getSpacing(), "spacing", "Spacing.exact", 0, 1, SvgTextPathElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(svgAltGlyphElementEClass, SvgAltGlyphElement.class, "SvgAltGlyphElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSvgAltGlyphElement_Class(), ecorePackage.getEString(), "class", null, 0, 1, SvgAltGlyphElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgAltGlyphElement_Style(), ecorePackage.getEString(), "style", null, 0, 1, SvgAltGlyphElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgAltGlyphElement_ExternalResourcesRequired(), ecorePackage.getEString(), "externalResourcesRequired", null, 0, 1, SvgAltGlyphElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgAltGlyphElement_X(), this.getListOfCoordinates(), "x", null, 0, 1, SvgAltGlyphElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgAltGlyphElement_Y(), this.getListOfCoordinates(), "y", null, 0, 1, SvgAltGlyphElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgAltGlyphElement_Dx(), this.getListOfLengths(), "dx", null, 0, 1, SvgAltGlyphElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgAltGlyphElement_Dy(), this.getListOfLengths(), "dy", null, 0, 1, SvgAltGlyphElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgAltGlyphElement_GlyphRef(), ecorePackage.getEString(), "glyphRef", null, 0, 1, SvgAltGlyphElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgAltGlyphElement_Format(), ecorePackage.getEString(), "format", null, 0, 1, SvgAltGlyphElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgAltGlyphElement_Rotate(), this.getListOfNumbers(), "rotate", null, 0, 1, SvgAltGlyphElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(svgAltGlyphDefElementEClass, SvgAltGlyphDefElement.class, "SvgAltGlyphDefElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(svgAltGlyphItemElementEClass, SvgAltGlyphItemElement.class, "SvgAltGlyphItemElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(svgAltGlyphRefElementEClass, SvgAltGlyphRefElement.class, "SvgAltGlyphRefElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSvgAltGlyphRefElement_Class(), ecorePackage.getEString(), "class", null, 0, 1, SvgAltGlyphRefElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgAltGlyphRefElement_Style(), ecorePackage.getEString(), "style", null, 0, 1, SvgAltGlyphRefElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgAltGlyphRefElement_X(), this.getNumber(), "x", null, 0, 1, SvgAltGlyphRefElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgAltGlyphRefElement_Y(), this.getNumber(), "y", null, 0, 1, SvgAltGlyphRefElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgAltGlyphRefElement_Dx(), this.getNumber(), "dx", null, 0, 1, SvgAltGlyphRefElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgAltGlyphRefElement_Dy(), this.getNumber(), "dy", null, 0, 1, SvgAltGlyphRefElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgAltGlyphRefElement_GlyphRef(), ecorePackage.getEString(), "glyphRef", null, 0, 1, SvgAltGlyphRefElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgAltGlyphRefElement_Format(), ecorePackage.getEString(), "format", null, 0, 1, SvgAltGlyphRefElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(svgMarkerElementEClass, SvgMarkerElement.class, "SvgMarkerElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSvgMarkerElement_Class(), ecorePackage.getEString(), "class", null, 0, 1, SvgMarkerElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgMarkerElement_Style(), ecorePackage.getEString(), "style", null, 0, 1, SvgMarkerElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgMarkerElement_ExternalResourcesRequired(), ecorePackage.getEString(), "externalResourcesRequired", null, 0, 1, SvgMarkerElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgMarkerElement_ViewBox(), this.getViewBox(), "viewBox", null, 0, 1, SvgMarkerElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgMarkerElement_PreserveAspectRatio(), this.getPreserveAspectRatio(), "preserveAspectRatio", null, 0, 1, SvgMarkerElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgMarkerElement_RefX(), this.getCoordinate(), "refX", null, 0, 1, SvgMarkerElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgMarkerElement_RefY(), this.getCoordinate(), "refY", null, 0, 1, SvgMarkerElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgMarkerElement_MarkerUnits(), this.getMarkerUnits(), "markerUnits", "MarkerUnits.strokeWidth", 0, 1, SvgMarkerElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgMarkerElement_MarkerWidth(), this.getLength(), "markerWidth", null, 0, 1, SvgMarkerElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgMarkerElement_MarkerHeight(), this.getLength(), "markerHeight", null, 0, 1, SvgMarkerElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgMarkerElement_Orient(), ecorePackage.getEString(), "orient", null, 0, 1, SvgMarkerElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(svgColorProfileElementEClass, SvgColorProfileElement.class, "SvgColorProfileElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSvgColorProfileElement_Local(), ecorePackage.getEString(), "local", null, 0, 1, SvgColorProfileElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgColorProfileElement_Name(), this.getName_(), "name", null, 0, 1, SvgColorProfileElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgColorProfileElement_Rendering_intent(), this.getRendering_intent(), "rendering_intent", "Rendering_intent.auto", 0, 1, SvgColorProfileElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(svgLinearGradientElementEClass, SvgLinearGradientElement.class, "SvgLinearGradientElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSvgLinearGradientElement_Class(), ecorePackage.getEString(), "class", null, 0, 1, SvgLinearGradientElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgLinearGradientElement_Style(), ecorePackage.getEString(), "style", null, 0, 1, SvgLinearGradientElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgLinearGradientElement_ExternalResourcesRequired(), ecorePackage.getEString(), "externalResourcesRequired", null, 0, 1, SvgLinearGradientElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgLinearGradientElement_X1(), this.getCoordinate(), "x1", null, 0, 1, SvgLinearGradientElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgLinearGradientElement_Y1(), this.getCoordinate(), "y1", null, 0, 1, SvgLinearGradientElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgLinearGradientElement_X2(), this.getCoordinate(), "x2", null, 0, 1, SvgLinearGradientElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgLinearGradientElement_Y2(), this.getCoordinate(), "y2", null, 0, 1, SvgLinearGradientElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgLinearGradientElement_GradientUnits(), this.getGradientUnits(), "gradientUnits", "GradientUnits.objectBoundingBox", 0, 1, SvgLinearGradientElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgLinearGradientElement_SpreadMethod(), this.getSpreadMethod(), "spreadMethod", "SpreadMethod.pad", 0, 1, SvgLinearGradientElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgLinearGradientElement_GradientTransform(), this.getTransformList(), "gradientTransform", null, 0, 1, SvgLinearGradientElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(svgRadialGradientElementEClass, SvgRadialGradientElement.class, "SvgRadialGradientElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSvgRadialGradientElement_Class(), ecorePackage.getEString(), "class", null, 0, 1, SvgRadialGradientElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgRadialGradientElement_Style(), ecorePackage.getEString(), "style", null, 0, 1, SvgRadialGradientElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgRadialGradientElement_ExternalResourcesRequired(), ecorePackage.getEString(), "externalResourcesRequired", null, 0, 1, SvgRadialGradientElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgRadialGradientElement_Cx(), this.getCoordinate(), "cx", null, 0, 1, SvgRadialGradientElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgRadialGradientElement_Cy(), this.getCoordinate(), "cy", null, 0, 1, SvgRadialGradientElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgRadialGradientElement_R(), this.getLength(), "r", null, 0, 1, SvgRadialGradientElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgRadialGradientElement_Fx(), this.getCoordinate(), "fx", null, 0, 1, SvgRadialGradientElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgRadialGradientElement_Fy(), this.getCoordinate(), "fy", null, 0, 1, SvgRadialGradientElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgRadialGradientElement_SpreadMethod(), this.getSpreadMethod(), "spreadMethod", "SpreadMethod.pad", 0, 1, SvgRadialGradientElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgRadialGradientElement_GradientUnits(), this.getGradientUnits(), "gradientUnits", "GradientUnits.objectBoundingBox", 0, 1, SvgRadialGradientElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgRadialGradientElement_GradientTransform(), this.getTransformList(), "gradientTransform", null, 0, 1, SvgRadialGradientElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(svgStopElementEClass, SvgStopElement.class, "SvgStopElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSvgStopElement_Class(), ecorePackage.getEString(), "class", null, 0, 1, SvgStopElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgStopElement_Style(), ecorePackage.getEString(), "style", null, 0, 1, SvgStopElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgStopElement_Offset(), ecorePackage.getEString(), "offset", null, 0, 1, SvgStopElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(svgPatternElementEClass, SvgPatternElement.class, "SvgPatternElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSvgPatternElement_Class(), ecorePackage.getEString(), "class", null, 0, 1, SvgPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgPatternElement_Style(), ecorePackage.getEString(), "style", null, 0, 1, SvgPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgPatternElement_ExternalResourcesRequired(), ecorePackage.getEString(), "externalResourcesRequired", null, 0, 1, SvgPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgPatternElement_ViewBox(), this.getViewBox(), "viewBox", null, 0, 1, SvgPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgPatternElement_PreserveAspectRatio(), this.getPreserveAspectRatio(), "preserveAspectRatio", null, 0, 1, SvgPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgPatternElement_X(), this.getCoordinate(), "x", null, 0, 1, SvgPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgPatternElement_Y(), this.getCoordinate(), "y", null, 0, 1, SvgPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgPatternElement_Width(), this.getLength(), "width", null, 0, 1, SvgPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgPatternElement_Height(), this.getLength(), "height", null, 0, 1, SvgPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgPatternElement_PatternUnits(), this.getPatternUnits(), "patternUnits", "PatternUnits.objectBoundingBox", 0, 1, SvgPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgPatternElement_PatternContentUnits(), this.getPatternUnits(), "patternContentUnits", "PatternUnits.userSpaceOnUse", 0, 1, SvgPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgPatternElement_PatternTransform(), ecorePackage.getEString(), "patternTransform", null, 0, 1, SvgPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(svgClipPathElementEClass, SvgClipPathElement.class, "SvgClipPathElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSvgClipPathElement_Class(), ecorePackage.getEString(), "class", null, 0, 1, SvgClipPathElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgClipPathElement_Style(), ecorePackage.getEString(), "style", null, 0, 1, SvgClipPathElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgClipPathElement_ExternalResourcesRequired(), ecorePackage.getEString(), "externalResourcesRequired", null, 0, 1, SvgClipPathElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgClipPathElement_Transform(), this.getTransform(), "transform", null, 0, 1, SvgClipPathElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgClipPathElement_ClipPathUnits(), this.getClipPathUnits(), "clipPathUnits", "ClipPathUnits.userSpaceOnUse", 0, 1, SvgClipPathElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(svgMaskElementEClass, SvgMaskElement.class, "SvgMaskElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSvgMaskElement_Class(), ecorePackage.getEString(), "class", null, 0, 1, SvgMaskElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgMaskElement_Style(), ecorePackage.getEString(), "style", null, 0, 1, SvgMaskElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgMaskElement_ExternalResourcesRequired(), ecorePackage.getEString(), "externalResourcesRequired", null, 0, 1, SvgMaskElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgMaskElement_X(), this.getCoordinate(), "x", null, 0, 1, SvgMaskElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgMaskElement_Y(), this.getCoordinate(), "y", null, 0, 1, SvgMaskElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgMaskElement_Width(), this.getLength(), "width", null, 0, 1, SvgMaskElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgMaskElement_Height(), this.getLength(), "height", null, 0, 1, SvgMaskElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgMaskElement_MaskUnits(), this.getMaskUnits(), "maskUnits", "MaskUnits.objectBoundingBox", 0, 1, SvgMaskElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgMaskElement_MaskContentUnits(), this.getMaskUnits(), "maskContentUnits", "MaskUnits.userSpaceOnUse", 0, 1, SvgMaskElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(svgFilterElementEClass, SvgFilterElement.class, "SvgFilterElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSvgFilterElement_Class(), ecorePackage.getEString(), "class", null, 0, 1, SvgFilterElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgFilterElement_Style(), ecorePackage.getEString(), "style", null, 0, 1, SvgFilterElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgFilterElement_ExternalResourcesRequired(), ecorePackage.getEString(), "externalResourcesRequired", null, 0, 1, SvgFilterElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgFilterElement_X(), this.getCoordinate(), "x", null, 0, 1, SvgFilterElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgFilterElement_Y(), this.getCoordinate(), "y", null, 0, 1, SvgFilterElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgFilterElement_Width(), this.getLength(), "width", null, 0, 1, SvgFilterElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgFilterElement_Height(), this.getLength(), "height", null, 0, 1, SvgFilterElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgFilterElement_FilterRes(), this.getNumberOptionalNumber(), "filterRes", null, 0, 1, SvgFilterElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgFilterElement_FilterUnits(), this.getFilterUnits(), "filterUnits", "FilterUnits.userSpaceOnUse", 0, 1, SvgFilterElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgFilterElement_PrimitiveUnits(), this.getFilterUnits(), "primitiveUnits", "FilterUnits.userSpaceOnUse", 0, 1, SvgFilterElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(svgFeDistantLightElementEClass, SvgFeDistantLightElement.class, "SvgFeDistantLightElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSvgFeDistantLightElement_Azimuth(), this.getNumber(), "azimuth", null, 0, 1, SvgFeDistantLightElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgFeDistantLightElement_Elevation(), this.getNumber(), "elevation", null, 0, 1, SvgFeDistantLightElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(svgFePointLightElementEClass, SvgFePointLightElement.class, "SvgFePointLightElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSvgFePointLightElement_X(), this.getNumber(), "x", null, 0, 1, SvgFePointLightElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgFePointLightElement_Y(), this.getNumber(), "y", null, 0, 1, SvgFePointLightElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgFePointLightElement_Z(), this.getNumber(), "z", null, 0, 1, SvgFePointLightElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(svgFeSpotLightElementEClass, SvgFeSpotLightElement.class, "SvgFeSpotLightElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSvgFeSpotLightElement_X(), this.getNumber(), "x", null, 0, 1, SvgFeSpotLightElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgFeSpotLightElement_Y(), this.getNumber(), "y", null, 0, 1, SvgFeSpotLightElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgFeSpotLightElement_Z(), this.getNumber(), "z", null, 0, 1, SvgFeSpotLightElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgFeSpotLightElement_PointsAtX(), this.getNumber(), "pointsAtX", null, 0, 1, SvgFeSpotLightElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgFeSpotLightElement_PointsAtY(), this.getNumber(), "pointsAtY", null, 0, 1, SvgFeSpotLightElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgFeSpotLightElement_PointsAtZ(), this.getNumber(), "pointsAtZ", null, 0, 1, SvgFeSpotLightElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgFeSpotLightElement_SpecularExponent(), this.getNumber(), "specularExponent", null, 0, 1, SvgFeSpotLightElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgFeSpotLightElement_LimitingConeAngle(), this.getNumber(), "limitingConeAngle", null, 0, 1, SvgFeSpotLightElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(svgFeBlendElementEClass, SvgFeBlendElement.class, "SvgFeBlendElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSvgFeBlendElement_Class(), ecorePackage.getEString(), "class", null, 0, 1, SvgFeBlendElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgFeBlendElement_Style(), ecorePackage.getEString(), "style", null, 0, 1, SvgFeBlendElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgFeBlendElement_In2(), ecorePackage.getEString(), "in2", null, 0, 1, SvgFeBlendElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgFeBlendElement_Mode(), this.getBlendMode(), "mode", "Mode.normal", 0, 1, SvgFeBlendElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(svgFeColorMatrixElementEClass, SvgFeColorMatrixElement.class, "SvgFeColorMatrixElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSvgFeColorMatrixElement_Class(), ecorePackage.getEString(), "class", null, 0, 1, SvgFeColorMatrixElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgFeColorMatrixElement_Style(), ecorePackage.getEString(), "style", null, 0, 1, SvgFeColorMatrixElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgFeColorMatrixElement_Type(), this.getColorMatrixType(), "type", "ColorMatrixType.matrix", 0, 1, SvgFeColorMatrixElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgFeColorMatrixElement_Values(), this.getListOfNumbers(), "values", null, 0, 1, SvgFeColorMatrixElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(svgFeComponentTransferElementEClass, SvgFeComponentTransferElement.class, "SvgFeComponentTransferElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSvgFeComponentTransferElement_Class(), ecorePackage.getEString(), "class", null, 0, 1, SvgFeComponentTransferElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgFeComponentTransferElement_Style(), ecorePackage.getEString(), "style", null, 0, 1, SvgFeComponentTransferElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(svgFeFuncRElementEClass, SvgFeFuncRElement.class, "SvgFeFuncRElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(svgFeFuncGElementEClass, SvgFeFuncGElement.class, "SvgFeFuncGElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(svgFeFuncBElementEClass, SvgFeFuncBElement.class, "SvgFeFuncBElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(svgFeFuncAElementEClass, SvgFeFuncAElement.class, "SvgFeFuncAElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(svgFeCompositeElementEClass, SvgFeCompositeElement.class, "SvgFeCompositeElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSvgFeCompositeElement_Class(), ecorePackage.getEString(), "class", null, 0, 1, SvgFeCompositeElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgFeCompositeElement_Style(), ecorePackage.getEString(), "style", null, 0, 1, SvgFeCompositeElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgFeCompositeElement_In2(), ecorePackage.getEString(), "in2", null, 0, 1, SvgFeCompositeElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgFeCompositeElement_Operator(), this.getCompositeOperator(), "operator", "CompositeOperator.over", 0, 1, SvgFeCompositeElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgFeCompositeElement_K1(), this.getNumber(), "k1", null, 0, 1, SvgFeCompositeElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgFeCompositeElement_K2(), this.getNumber(), "k2", null, 0, 1, SvgFeCompositeElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgFeCompositeElement_K3(), this.getNumber(), "k3", null, 0, 1, SvgFeCompositeElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgFeCompositeElement_K4(), this.getNumber(), "k4", null, 0, 1, SvgFeCompositeElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(svgFeConvolveMatrixElementEClass, SvgFeConvolveMatrixElement.class, "SvgFeConvolveMatrixElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSvgFeConvolveMatrixElement_Class(), ecorePackage.getEString(), "class", null, 0, 1, SvgFeConvolveMatrixElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgFeConvolveMatrixElement_Style(), ecorePackage.getEString(), "style", null, 0, 1, SvgFeConvolveMatrixElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgFeConvolveMatrixElement_Order(), this.getNumberOptionalNumber(), "order", null, 0, 1, SvgFeConvolveMatrixElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgFeConvolveMatrixElement_KernelMatrix(), this.getListOfNumbers(), "kernelMatrix", null, 0, 1, SvgFeConvolveMatrixElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgFeConvolveMatrixElement_Divisor(), this.getNumber(), "divisor", null, 0, 1, SvgFeConvolveMatrixElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgFeConvolveMatrixElement_Bias(), this.getNumber(), "bias", null, 0, 1, SvgFeConvolveMatrixElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgFeConvolveMatrixElement_TargetX(), ecorePackage.getEIntegerObject(), "targetX", null, 0, 1, SvgFeConvolveMatrixElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgFeConvolveMatrixElement_TargetY(), ecorePackage.getEIntegerObject(), "targetY", null, 0, 1, SvgFeConvolveMatrixElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgFeConvolveMatrixElement_EdgeMode(), this.getConvolveMatrixEdgeMode(), "edgeMode", "ConvolveMatrixEdgeMode.duplicate", 0, 1, SvgFeConvolveMatrixElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgFeConvolveMatrixElement_KernelUnitLength(), this.getNumberOptionalNumber(), "kernelUnitLength", null, 0, 1, SvgFeConvolveMatrixElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgFeConvolveMatrixElement_PreserveAlpha(), ecorePackage.getEBoolean(), "preserveAlpha", null, 0, 1, SvgFeConvolveMatrixElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(svgFeDiffuseLightingElementEClass, SvgFeDiffuseLightingElement.class, "SvgFeDiffuseLightingElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSvgFeDiffuseLightingElement_Class(), ecorePackage.getEString(), "class", null, 0, 1, SvgFeDiffuseLightingElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgFeDiffuseLightingElement_Style(), ecorePackage.getEString(), "style", null, 0, 1, SvgFeDiffuseLightingElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgFeDiffuseLightingElement_SurfaceScale(), this.getNumber(), "surfaceScale", null, 0, 1, SvgFeDiffuseLightingElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgFeDiffuseLightingElement_DiffuseConstant(), this.getNumber(), "diffuseConstant", null, 0, 1, SvgFeDiffuseLightingElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgFeDiffuseLightingElement_KernelUnitLength(), this.getNumberOptionalNumber(), "kernelUnitLength", null, 0, 1, SvgFeDiffuseLightingElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(svgFeDisplacementMapElementEClass, SvgFeDisplacementMapElement.class, "SvgFeDisplacementMapElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSvgFeDisplacementMapElement_Class(), ecorePackage.getEString(), "class", null, 0, 1, SvgFeDisplacementMapElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgFeDisplacementMapElement_Style(), ecorePackage.getEString(), "style", null, 0, 1, SvgFeDisplacementMapElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgFeDisplacementMapElement_In2(), ecorePackage.getEString(), "in2", null, 0, 1, SvgFeDisplacementMapElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgFeDisplacementMapElement_Scale(), this.getNumber(), "scale", null, 0, 1, SvgFeDisplacementMapElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgFeDisplacementMapElement_XChannelSelector(), this.getChannelSelector(), "xChannelSelector", null, 0, 1, SvgFeDisplacementMapElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgFeDisplacementMapElement_YChannelSelector(), this.getChannelSelector(), "yChannelSelector", null, 0, 1, SvgFeDisplacementMapElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(svgFeFloodElementEClass, SvgFeFloodElement.class, "SvgFeFloodElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSvgFeFloodElement_Class(), ecorePackage.getEString(), "class", null, 0, 1, SvgFeFloodElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgFeFloodElement_Style(), ecorePackage.getEString(), "style", null, 0, 1, SvgFeFloodElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(svgFeGaussianBlurElementEClass, SvgFeGaussianBlurElement.class, "SvgFeGaussianBlurElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSvgFeGaussianBlurElement_Class(), ecorePackage.getEString(), "class", null, 0, 1, SvgFeGaussianBlurElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgFeGaussianBlurElement_Style(), ecorePackage.getEString(), "style", null, 0, 1, SvgFeGaussianBlurElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgFeGaussianBlurElement_StdDeviation(), this.getNumberOptionalNumber(), "stdDeviation", null, 0, 1, SvgFeGaussianBlurElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(svgFeImageElementEClass, SvgFeImageElement.class, "SvgFeImageElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSvgFeImageElement_Class(), ecorePackage.getEString(), "class", null, 0, 1, SvgFeImageElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgFeImageElement_Style(), ecorePackage.getEString(), "style", null, 0, 1, SvgFeImageElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgFeImageElement_ExternalResourcesRequired(), ecorePackage.getEString(), "externalResourcesRequired", null, 0, 1, SvgFeImageElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgFeImageElement_PreserveAspectRatio(), this.getPreserveAspectRatio(), "preserveAspectRatio", null, 0, 1, SvgFeImageElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(svgFeMergeElementEClass, SvgFeMergeElement.class, "SvgFeMergeElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSvgFeMergeElement_Class(), ecorePackage.getEString(), "class", null, 0, 1, SvgFeMergeElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgFeMergeElement_Style(), ecorePackage.getEString(), "style", null, 0, 1, SvgFeMergeElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(svgFeMergeNodeElementEClass, SvgFeMergeNodeElement.class, "SvgFeMergeNodeElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(svgFeMorphologyElementEClass, SvgFeMorphologyElement.class, "SvgFeMorphologyElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSvgFeMorphologyElement_Class(), ecorePackage.getEString(), "class", null, 0, 1, SvgFeMorphologyElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgFeMorphologyElement_Style(), ecorePackage.getEString(), "style", null, 0, 1, SvgFeMorphologyElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgFeMorphologyElement_Operator(), this.getMorphologyOperator(), "operator", "MorphologyOperator.erode", 0, 1, SvgFeMorphologyElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgFeMorphologyElement_Radius(), this.getNumberOptionalNumber(), "radius", null, 0, 1, SvgFeMorphologyElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(svgFeOffsetElementEClass, SvgFeOffsetElement.class, "SvgFeOffsetElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSvgFeOffsetElement_Class(), ecorePackage.getEString(), "class", null, 0, 1, SvgFeOffsetElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgFeOffsetElement_Style(), ecorePackage.getEString(), "style", null, 0, 1, SvgFeOffsetElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgFeOffsetElement_Dx(), this.getNumber(), "dx", null, 0, 1, SvgFeOffsetElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgFeOffsetElement_Dy(), this.getNumber(), "dy", null, 0, 1, SvgFeOffsetElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(svgFeSpecularLightingElementEClass, SvgFeSpecularLightingElement.class, "SvgFeSpecularLightingElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSvgFeSpecularLightingElement_Class(), ecorePackage.getEString(), "class", null, 0, 1, SvgFeSpecularLightingElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgFeSpecularLightingElement_Style(), ecorePackage.getEString(), "style", null, 0, 1, SvgFeSpecularLightingElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgFeSpecularLightingElement_SurfaceScale(), this.getNumber(), "surfaceScale", null, 0, 1, SvgFeSpecularLightingElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgFeSpecularLightingElement_SpecularConstant(), this.getNumber(), "specularConstant", null, 0, 1, SvgFeSpecularLightingElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgFeSpecularLightingElement_SpecularExponent(), this.getNumber(), "specularExponent", null, 0, 1, SvgFeSpecularLightingElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgFeSpecularLightingElement_KernelUnitLength(), this.getNumberOptionalNumber(), "kernelUnitLength", null, 0, 1, SvgFeSpecularLightingElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(svgFeTileElementEClass, SvgFeTileElement.class, "SvgFeTileElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSvgFeTileElement_Class(), ecorePackage.getEString(), "class", null, 0, 1, SvgFeTileElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgFeTileElement_Style(), ecorePackage.getEString(), "style", null, 0, 1, SvgFeTileElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(svgFeTurbulenceElementEClass, SvgFeTurbulenceElement.class, "SvgFeTurbulenceElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSvgFeTurbulenceElement_Class(), ecorePackage.getEString(), "class", null, 0, 1, SvgFeTurbulenceElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgFeTurbulenceElement_Style(), ecorePackage.getEString(), "style", null, 0, 1, SvgFeTurbulenceElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgFeTurbulenceElement_BaseFrequency(), this.getNumberOptionalNumber(), "baseFrequency", null, 0, 1, SvgFeTurbulenceElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgFeTurbulenceElement_NumOctaves(), ecorePackage.getEInt(), "numOctaves", "1", 0, 1, SvgFeTurbulenceElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgFeTurbulenceElement_Seed(), this.getNumber(), "seed", "0", 0, 1, SvgFeTurbulenceElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgFeTurbulenceElement_StitchTiles(), this.getStitchTiles(), "stitchTiles", "StitchTiles.noStitch", 0, 1, SvgFeTurbulenceElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSvgFeTurbulenceElement_Type(), this.getTurbulenceType(), "type", "TurbulenceType.turbulence", 0, 1, SvgFeTurbulenceElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(svgAnimateElementEClass, SvgAnimateElement.class, "SvgAnimateElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(svgMetadataElementEClass, SvgMetadataElement.class, "SvgMetadataElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Initialize enums and add enum literals
		initEEnum(alignment_baselineEEnum, Alignment_baseline.class, "Alignment_baseline");
		addEEnumLiteral(alignment_baselineEEnum, Alignment_baseline.AUTO);
		addEEnumLiteral(alignment_baselineEEnum, Alignment_baseline.BASELINE);
		addEEnumLiteral(alignment_baselineEEnum, Alignment_baseline.BEFORE_EDGE);
		addEEnumLiteral(alignment_baselineEEnum, Alignment_baseline.TEXT_BEFORE_EDGE);
		addEEnumLiteral(alignment_baselineEEnum, Alignment_baseline.MIDDLE);
		addEEnumLiteral(alignment_baselineEEnum, Alignment_baseline.CENTRAL);
		addEEnumLiteral(alignment_baselineEEnum, Alignment_baseline.AFTER_EDGE);
		addEEnumLiteral(alignment_baselineEEnum, Alignment_baseline.TEXT_AFTER_EDGE);
		addEEnumLiteral(alignment_baselineEEnum, Alignment_baseline.IDEOGRAPHIC);
		addEEnumLiteral(alignment_baselineEEnum, Alignment_baseline.ALPHABETIC);
		addEEnumLiteral(alignment_baselineEEnum, Alignment_baseline.HANGING);
		addEEnumLiteral(alignment_baselineEEnum, Alignment_baseline.MATHEMATICAL);
		addEEnumLiteral(alignment_baselineEEnum, Alignment_baseline.INHERIT);

		initEEnum(clip_ruleEEnum, Clip_rule.class, "Clip_rule");
		addEEnumLiteral(clip_ruleEEnum, Clip_rule.NONZERO);
		addEEnumLiteral(clip_ruleEEnum, Clip_rule.EVENODD);
		addEEnumLiteral(clip_ruleEEnum, Clip_rule.INHERIT);

		initEEnum(color_interpolationEEnum, Color_interpolation.class, "Color_interpolation");
		addEEnumLiteral(color_interpolationEEnum, Color_interpolation.SRGB);
		addEEnumLiteral(color_interpolationEEnum, Color_interpolation.AUTO);
		addEEnumLiteral(color_interpolationEEnum, Color_interpolation.LINEAR_RGB);
		addEEnumLiteral(color_interpolationEEnum, Color_interpolation.INHERIT);

		initEEnum(color_interpolation_filtersEEnum, Color_interpolation_filters.class, "Color_interpolation_filters");
		addEEnumLiteral(color_interpolation_filtersEEnum, Color_interpolation_filters.AUTO);
		addEEnumLiteral(color_interpolation_filtersEEnum, Color_interpolation_filters.SRGB);
		addEEnumLiteral(color_interpolation_filtersEEnum, Color_interpolation_filters.LINEAR_RGB);
		addEEnumLiteral(color_interpolation_filtersEEnum, Color_interpolation_filters.INHERIT);

		initEEnum(color_renderingEEnum, Color_rendering.class, "Color_rendering");
		addEEnumLiteral(color_renderingEEnum, Color_rendering.AUTO);
		addEEnumLiteral(color_renderingEEnum, Color_rendering.OPTIMIZE_SPEED);
		addEEnumLiteral(color_renderingEEnum, Color_rendering.OPTIMIZE_QUALITY);
		addEEnumLiteral(color_renderingEEnum, Color_rendering.INHERIT);

		initEEnum(directionEEnum, Direction.class, "Direction");
		addEEnumLiteral(directionEEnum, Direction.LTR);
		addEEnumLiteral(directionEEnum, Direction.RTL);
		addEEnumLiteral(directionEEnum, Direction.INHERIT);

		initEEnum(displayEEnum, Display.class, "Display");
		addEEnumLiteral(displayEEnum, Display.INLINE);
		addEEnumLiteral(displayEEnum, Display.BLOCK);
		addEEnumLiteral(displayEEnum, Display.LIST_ITEM);
		addEEnumLiteral(displayEEnum, Display.RUN_IN);
		addEEnumLiteral(displayEEnum, Display.COMPACT);
		addEEnumLiteral(displayEEnum, Display.MARKER);
		addEEnumLiteral(displayEEnum, Display.TABLE);
		addEEnumLiteral(displayEEnum, Display.INLINE_TABLE);
		addEEnumLiteral(displayEEnum, Display.TABLE_ROW_GROUP);
		addEEnumLiteral(displayEEnum, Display.TABLE_HEADER_GROUP);
		addEEnumLiteral(displayEEnum, Display.TABLE_FOOTER_GROUP);
		addEEnumLiteral(displayEEnum, Display.TABLE_ROW);
		addEEnumLiteral(displayEEnum, Display.TABLE_COLUMN_GROUP);
		addEEnumLiteral(displayEEnum, Display.TABLE_COLUMN);
		addEEnumLiteral(displayEEnum, Display.TABLE_CELL);
		addEEnumLiteral(displayEEnum, Display.TABLE_CAPTION);
		addEEnumLiteral(displayEEnum, Display.NONE);
		addEEnumLiteral(displayEEnum, Display.INHERIT);

		initEEnum(dominant_baselineEEnum, Dominant_baseline.class, "Dominant_baseline");
		addEEnumLiteral(dominant_baselineEEnum, Dominant_baseline.AUTO);
		addEEnumLiteral(dominant_baselineEEnum, Dominant_baseline.USE_SCRIPT);
		addEEnumLiteral(dominant_baselineEEnum, Dominant_baseline.NO_CHANGE);
		addEEnumLiteral(dominant_baselineEEnum, Dominant_baseline.RESET_SIZE);
		addEEnumLiteral(dominant_baselineEEnum, Dominant_baseline.IDEOGRAPHIC);
		addEEnumLiteral(dominant_baselineEEnum, Dominant_baseline.ALPHABETIC);
		addEEnumLiteral(dominant_baselineEEnum, Dominant_baseline.HANGING);
		addEEnumLiteral(dominant_baselineEEnum, Dominant_baseline.MATHEMATICAL);
		addEEnumLiteral(dominant_baselineEEnum, Dominant_baseline.CENTRAL);
		addEEnumLiteral(dominant_baselineEEnum, Dominant_baseline.MIDDLE);
		addEEnumLiteral(dominant_baselineEEnum, Dominant_baseline.TEXT_AFTER_EDGE);
		addEEnumLiteral(dominant_baselineEEnum, Dominant_baseline.TEXT_BEFORE_EDGE);
		addEEnumLiteral(dominant_baselineEEnum, Dominant_baseline.INHERIT);

		initEEnum(fill_ruleEEnum, Fill_rule.class, "Fill_rule");
		addEEnumLiteral(fill_ruleEEnum, Fill_rule.NONZERO);
		addEEnumLiteral(fill_ruleEEnum, Fill_rule.EVENODD);
		addEEnumLiteral(fill_ruleEEnum, Fill_rule.INHERIT);

		initEEnum(font_stretchEEnum, Font_stretch.class, "Font_stretch");
		addEEnumLiteral(font_stretchEEnum, Font_stretch.NORMAL);
		addEEnumLiteral(font_stretchEEnum, Font_stretch.WIDER);
		addEEnumLiteral(font_stretchEEnum, Font_stretch.NARROWER);
		addEEnumLiteral(font_stretchEEnum, Font_stretch.ULTRA_CONDENSED);
		addEEnumLiteral(font_stretchEEnum, Font_stretch.EXTRA_CONDENSED);
		addEEnumLiteral(font_stretchEEnum, Font_stretch.CONDENSED);
		addEEnumLiteral(font_stretchEEnum, Font_stretch.SEMI_CONDENSED);
		addEEnumLiteral(font_stretchEEnum, Font_stretch.SEMI_EXPANDED);
		addEEnumLiteral(font_stretchEEnum, Font_stretch.EXPANDED);
		addEEnumLiteral(font_stretchEEnum, Font_stretch.EXTRA_EXPANDED);
		addEEnumLiteral(font_stretchEEnum, Font_stretch.ULTRA_EXPANDED);
		addEEnumLiteral(font_stretchEEnum, Font_stretch.INHERIT);

		initEEnum(font_styleEEnum, Font_style.class, "Font_style");
		addEEnumLiteral(font_styleEEnum, Font_style.NORMAL);
		addEEnumLiteral(font_styleEEnum, Font_style.ITALIC);
		addEEnumLiteral(font_styleEEnum, Font_style.OBLIQUE);
		addEEnumLiteral(font_styleEEnum, Font_style.INHERIT);

		initEEnum(font_variantEEnum, Font_variant.class, "Font_variant");
		addEEnumLiteral(font_variantEEnum, Font_variant.NORMAL);
		addEEnumLiteral(font_variantEEnum, Font_variant.SMALL_CAPS);
		addEEnumLiteral(font_variantEEnum, Font_variant.INHERIT);

		initEEnum(font_weightEEnum, Font_weight.class, "Font_weight");
		addEEnumLiteral(font_weightEEnum, Font_weight.NORMAL);
		addEEnumLiteral(font_weightEEnum, Font_weight.BOLD);
		addEEnumLiteral(font_weightEEnum, Font_weight.BOLDER);
		addEEnumLiteral(font_weightEEnum, Font_weight.LIGHTER);
		addEEnumLiteral(font_weightEEnum, Font_weight.EM100);
		addEEnumLiteral(font_weightEEnum, Font_weight.EM200);
		addEEnumLiteral(font_weightEEnum, Font_weight.EM300);
		addEEnumLiteral(font_weightEEnum, Font_weight.EM400);
		addEEnumLiteral(font_weightEEnum, Font_weight.EM500);
		addEEnumLiteral(font_weightEEnum, Font_weight.EM600);
		addEEnumLiteral(font_weightEEnum, Font_weight.EM700);
		addEEnumLiteral(font_weightEEnum, Font_weight.EM800);
		addEEnumLiteral(font_weightEEnum, Font_weight.EM900);
		addEEnumLiteral(font_weightEEnum, Font_weight.INHERIT);

		initEEnum(image_renderingEEnum, Image_rendering.class, "Image_rendering");
		addEEnumLiteral(image_renderingEEnum, Image_rendering.AUTO);
		addEEnumLiteral(image_renderingEEnum, Image_rendering.OPTIMIZE_SPEED);
		addEEnumLiteral(image_renderingEEnum, Image_rendering.OPTIMIZE_QUALITY);
		addEEnumLiteral(image_renderingEEnum, Image_rendering.INHERIT);

		initEEnum(overflowEEnum, Overflow.class, "Overflow");
		addEEnumLiteral(overflowEEnum, Overflow.VISIBLE);
		addEEnumLiteral(overflowEEnum, Overflow.HIDDEN);
		addEEnumLiteral(overflowEEnum, Overflow.SCROLL);
		addEEnumLiteral(overflowEEnum, Overflow.AUTO);
		addEEnumLiteral(overflowEEnum, Overflow.INHERIT);

		initEEnum(pointer_eventsEEnum, Pointer_events.class, "Pointer_events");
		addEEnumLiteral(pointer_eventsEEnum, Pointer_events.VISIBLE_PAINTED);
		addEEnumLiteral(pointer_eventsEEnum, Pointer_events.VISIBLE_FILL);
		addEEnumLiteral(pointer_eventsEEnum, Pointer_events.VISIBLE_STROKE);
		addEEnumLiteral(pointer_eventsEEnum, Pointer_events.VISIBLE);
		addEEnumLiteral(pointer_eventsEEnum, Pointer_events.PAINTED);
		addEEnumLiteral(pointer_eventsEEnum, Pointer_events.FILL);
		addEEnumLiteral(pointer_eventsEEnum, Pointer_events.STROKE);
		addEEnumLiteral(pointer_eventsEEnum, Pointer_events.ALL);
		addEEnumLiteral(pointer_eventsEEnum, Pointer_events.NONE);
		addEEnumLiteral(pointer_eventsEEnum, Pointer_events.INHERIT);

		initEEnum(shape_renderingEEnum, Shape_rendering.class, "Shape_rendering");
		addEEnumLiteral(shape_renderingEEnum, Shape_rendering.AUTO);
		addEEnumLiteral(shape_renderingEEnum, Shape_rendering.OPTIMIZE_SPEED);
		addEEnumLiteral(shape_renderingEEnum, Shape_rendering.CRISP_EDGES);
		addEEnumLiteral(shape_renderingEEnum, Shape_rendering.GEOMETRIC_PRECISION);
		addEEnumLiteral(shape_renderingEEnum, Shape_rendering.INHERIT);

		initEEnum(stroke_linecapEEnum, Stroke_linecap.class, "Stroke_linecap");
		addEEnumLiteral(stroke_linecapEEnum, Stroke_linecap.BUTT);
		addEEnumLiteral(stroke_linecapEEnum, Stroke_linecap.ROUND);
		addEEnumLiteral(stroke_linecapEEnum, Stroke_linecap.SQUARE);
		addEEnumLiteral(stroke_linecapEEnum, Stroke_linecap.INHERIT);

		initEEnum(stroke_linejoinEEnum, Stroke_linejoin.class, "Stroke_linejoin");
		addEEnumLiteral(stroke_linejoinEEnum, Stroke_linejoin.MITER);
		addEEnumLiteral(stroke_linejoinEEnum, Stroke_linejoin.ROUND);
		addEEnumLiteral(stroke_linejoinEEnum, Stroke_linejoin.BEVEL);
		addEEnumLiteral(stroke_linejoinEEnum, Stroke_linejoin.INHERIT);

		initEEnum(text_anchorEEnum, Text_anchor.class, "Text_anchor");
		addEEnumLiteral(text_anchorEEnum, Text_anchor.START);
		addEEnumLiteral(text_anchorEEnum, Text_anchor.MIDDLE);
		addEEnumLiteral(text_anchorEEnum, Text_anchor.END);
		addEEnumLiteral(text_anchorEEnum, Text_anchor.INHERIT);

		initEEnum(text_renderingEEnum, Text_rendering.class, "Text_rendering");
		addEEnumLiteral(text_renderingEEnum, Text_rendering.AUTO);
		addEEnumLiteral(text_renderingEEnum, Text_rendering.OPTIMIZE_SPEED);
		addEEnumLiteral(text_renderingEEnum, Text_rendering.OPTIMIZE_LEGIBILITY);
		addEEnumLiteral(text_renderingEEnum, Text_rendering.GEOMETRIC_PRECISION);
		addEEnumLiteral(text_renderingEEnum, Text_rendering.INHERIT);

		initEEnum(unicode_bidiEEnum, Unicode_bidi.class, "Unicode_bidi");
		addEEnumLiteral(unicode_bidiEEnum, Unicode_bidi.NORMAL);
		addEEnumLiteral(unicode_bidiEEnum, Unicode_bidi.EMBED);
		addEEnumLiteral(unicode_bidiEEnum, Unicode_bidi.BIDI_OVERRIDE);
		addEEnumLiteral(unicode_bidiEEnum, Unicode_bidi.INHERIT);

		initEEnum(visibilityEEnum, Visibility.class, "Visibility");
		addEEnumLiteral(visibilityEEnum, Visibility.VISIBLE);
		addEEnumLiteral(visibilityEEnum, Visibility.HIDDEN);
		addEEnumLiteral(visibilityEEnum, Visibility.COLLAPSE);
		addEEnumLiteral(visibilityEEnum, Visibility.INHERIT);

		initEEnum(writing_modeEEnum, Writing_mode.class, "Writing_mode");
		addEEnumLiteral(writing_modeEEnum, Writing_mode.LR_TB);
		addEEnumLiteral(writing_modeEEnum, Writing_mode.RL_TB);
		addEEnumLiteral(writing_modeEEnum, Writing_mode.TB_RL);
		addEEnumLiteral(writing_modeEEnum, Writing_mode.LR);
		addEEnumLiteral(writing_modeEEnum, Writing_mode.RL);
		addEEnumLiteral(writing_modeEEnum, Writing_mode.TB);
		addEEnumLiteral(writing_modeEEnum, Writing_mode.INHERIT);

		initEEnum(zoomAndPanEEnum, ZoomAndPan.class, "ZoomAndPan");
		addEEnumLiteral(zoomAndPanEEnum, ZoomAndPan.DISABLE);
		addEEnumLiteral(zoomAndPanEEnum, ZoomAndPan.MAGNIFY);

		initEEnum(lengthAdjustEEnum, LengthAdjust.class, "LengthAdjust");
		addEEnumLiteral(lengthAdjustEEnum, LengthAdjust.SPACING);
		addEEnumLiteral(lengthAdjustEEnum, LengthAdjust.SPACING_AND_GLYPHS);

		initEEnum(methodEEnum, Method.class, "Method");
		addEEnumLiteral(methodEEnum, Method.ALIGN);
		addEEnumLiteral(methodEEnum, Method.STRETCH);

		initEEnum(spacingEEnum, Spacing.class, "Spacing");
		addEEnumLiteral(spacingEEnum, Spacing.AUTO);
		addEEnumLiteral(spacingEEnum, Spacing.EXACT);

		initEEnum(markerUnitsEEnum, MarkerUnits.class, "MarkerUnits");
		addEEnumLiteral(markerUnitsEEnum, MarkerUnits.STROKE_WIDTH);
		addEEnumLiteral(markerUnitsEEnum, MarkerUnits.USER_SPACE_ON_USE);

		initEEnum(rendering_intentEEnum, Rendering_intent.class, "Rendering_intent");
		addEEnumLiteral(rendering_intentEEnum, Rendering_intent.AUTO);
		addEEnumLiteral(rendering_intentEEnum, Rendering_intent.PERCEPTUAL);
		addEEnumLiteral(rendering_intentEEnum, Rendering_intent.RELATIVE_COLORIMETRIC);
		addEEnumLiteral(rendering_intentEEnum, Rendering_intent.SATURATION);
		addEEnumLiteral(rendering_intentEEnum, Rendering_intent.ABSOLUTE_COLORIMETRIC);

		initEEnum(gradientUnitsEEnum, GradientUnits.class, "GradientUnits");
		addEEnumLiteral(gradientUnitsEEnum, GradientUnits.USER_SPACE_ON_USE);
		addEEnumLiteral(gradientUnitsEEnum, GradientUnits.OBJECT_BOUNDING_BOX);

		initEEnum(spreadMethodEEnum, SpreadMethod.class, "SpreadMethod");
		addEEnumLiteral(spreadMethodEEnum, SpreadMethod.PAD);
		addEEnumLiteral(spreadMethodEEnum, SpreadMethod.REFLECT);
		addEEnumLiteral(spreadMethodEEnum, SpreadMethod.REPEAT);

		initEEnum(patternUnitsEEnum, PatternUnits.class, "PatternUnits");
		addEEnumLiteral(patternUnitsEEnum, PatternUnits.USER_SPACE_ON_USE);
		addEEnumLiteral(patternUnitsEEnum, PatternUnits.OBJECT_BOUNDING_BOX);

		initEEnum(clipPathUnitsEEnum, ClipPathUnits.class, "ClipPathUnits");
		addEEnumLiteral(clipPathUnitsEEnum, ClipPathUnits.USER_SPACE_ON_USE);
		addEEnumLiteral(clipPathUnitsEEnum, ClipPathUnits.OBJECT_BOUNDING_BOX);

		initEEnum(maskUnitsEEnum, MaskUnits.class, "MaskUnits");
		addEEnumLiteral(maskUnitsEEnum, MaskUnits.USER_SPACE_ON_USE);
		addEEnumLiteral(maskUnitsEEnum, MaskUnits.OBJECT_BOUNDING_BOX);

		initEEnum(filterUnitsEEnum, FilterUnits.class, "FilterUnits");
		addEEnumLiteral(filterUnitsEEnum, FilterUnits.USER_SPACE_ON_USE);
		addEEnumLiteral(filterUnitsEEnum, FilterUnits.OBJECT_BOUNDING_BOX);

		initEEnum(blendModeEEnum, BlendMode.class, "BlendMode");
		addEEnumLiteral(blendModeEEnum, BlendMode.NORMAL);
		addEEnumLiteral(blendModeEEnum, BlendMode.LIGHTEN);
		addEEnumLiteral(blendModeEEnum, BlendMode.MULTIPLY);
		addEEnumLiteral(blendModeEEnum, BlendMode.SCREEN);
		addEEnumLiteral(blendModeEEnum, BlendMode.DARKEN);

		initEEnum(colorMatrixTypeEEnum, ColorMatrixType.class, "ColorMatrixType");
		addEEnumLiteral(colorMatrixTypeEEnum, ColorMatrixType.MATRIX);
		addEEnumLiteral(colorMatrixTypeEEnum, ColorMatrixType.SATURATE);
		addEEnumLiteral(colorMatrixTypeEEnum, ColorMatrixType.HUE_ROTATE);
		addEEnumLiteral(colorMatrixTypeEEnum, ColorMatrixType.LUMINANCE_TO_ALPHA);

		initEEnum(compositeOperatorEEnum, CompositeOperator.class, "CompositeOperator");
		addEEnumLiteral(compositeOperatorEEnum, CompositeOperator.OVER);
		addEEnumLiteral(compositeOperatorEEnum, CompositeOperator.IN);
		addEEnumLiteral(compositeOperatorEEnum, CompositeOperator.OUT);
		addEEnumLiteral(compositeOperatorEEnum, CompositeOperator.ATOP);
		addEEnumLiteral(compositeOperatorEEnum, CompositeOperator.XOR);
		addEEnumLiteral(compositeOperatorEEnum, CompositeOperator.ARITHMETIC);

		initEEnum(convolveMatrixEdgeModeEEnum, ConvolveMatrixEdgeMode.class, "ConvolveMatrixEdgeMode");
		addEEnumLiteral(convolveMatrixEdgeModeEEnum, ConvolveMatrixEdgeMode.DUPLICATE);
		addEEnumLiteral(convolveMatrixEdgeModeEEnum, ConvolveMatrixEdgeMode.WRAP);
		addEEnumLiteral(convolveMatrixEdgeModeEEnum, ConvolveMatrixEdgeMode.NONE);

		initEEnum(channelSelectorEEnum, ChannelSelector.class, "ChannelSelector");
		addEEnumLiteral(channelSelectorEEnum, ChannelSelector.R);
		addEEnumLiteral(channelSelectorEEnum, ChannelSelector.G);
		addEEnumLiteral(channelSelectorEEnum, ChannelSelector.B);
		addEEnumLiteral(channelSelectorEEnum, ChannelSelector.A);

		initEEnum(morphologyOperatorEEnum, MorphologyOperator.class, "MorphologyOperator");
		addEEnumLiteral(morphologyOperatorEEnum, MorphologyOperator.ERODE);
		addEEnumLiteral(morphologyOperatorEEnum, MorphologyOperator.DILATE);

		initEEnum(stitchTilesEEnum, StitchTiles.class, "StitchTiles");
		addEEnumLiteral(stitchTilesEEnum, StitchTiles.STITCH);
		addEEnumLiteral(stitchTilesEEnum, StitchTiles.NO_STITCH);

		initEEnum(turbulenceTypeEEnum, TurbulenceType.class, "TurbulenceType");
		addEEnumLiteral(turbulenceTypeEEnum, TurbulenceType.FRACTAL_NOISE);
		addEEnumLiteral(turbulenceTypeEEnum, TurbulenceType.TURBULENCE);

		// Initialize data types
		initEDataType(lengthEDataType, String.class, "Length", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(angleEDataType, String.class, "Angle", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(percentageEDataType, String.class, "Percentage", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(shapeEDataType, String.class, "Shape", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(funciriEDataType, String.class, "Funciri", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(colorEDataType, String.class, "Color", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(paintEDataType, String.class, "Paint", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(opacity_valueEDataType, String.class, "Opacity_value", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(baseline_shiftEDataType, String.class, "Baseline_shift", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(clipEDataType, String.class, "Clip", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(clip_pathEDataType, String.class, "Clip_path", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(color_profileEDataType, String.class, "Color_profile", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(cursorEDataType, String.class, "Cursor", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(enable_backgroundEDataType, String.class, "Enable_background", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(fillEDataType, String.class, "Fill", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(fill_opacityEDataType, String.class, "Fill_opacity", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(filterEDataType, String.class, "Filter", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(flood_colorEDataType, String.class, "Flood_color", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(flood_opacityEDataType, String.class, "Flood_opacity", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(font_familyEDataType, String.class, "Font_family", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(font_sizeEDataType, String.class, "Font_size", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(font_size_adjustEDataType, String.class, "Font_size_adjust", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(glyph_orientation_horizontalEDataType, String.class, "Glyph_orientation_horizontal", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(glyph_orientation_verticalEDataType, String.class, "Glyph_orientation_vertical", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(kerningEDataType, String.class, "Kerning", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(letter_spacingEDataType, String.class, "Letter_spacing", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(lighting_colorEDataType, String.class, "Lighting_color", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(marker_endEDataType, String.class, "Marker_end", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(marker_midEDataType, String.class, "Marker_mid", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(marker_startEDataType, String.class, "Marker_start", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(masksEDataType, String.class, "Masks", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(opacityEDataType, String.class, "Opacity", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(stop_colorEDataType, String.class, "Stop_color", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(stop_opacityEDataType, String.class, "Stop_opacity", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(strokeEDataType, String.class, "Stroke", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(stroke_dasharrayEDataType, String.class, "Stroke_dasharray", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(stroke_dashoffsetEDataType, String.class, "Stroke_dashoffset", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(stroke_miterlimitEDataType, String.class, "Stroke_miterlimit", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(stroke_opacityEDataType, String.class, "Stroke_opacity", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(stroke_widthEDataType, String.class, "Stroke_width", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(text_decorationEDataType, String.class, "Text_decoration", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(word_spacingEDataType, String.class, "Word_spacing", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(coordinateEDataType, String.class, "Coordinate", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(viewBoxEDataType, String.class, "ViewBox", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(preserveAspectRatioEDataType, String.class, "PreserveAspectRatio", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(numberEDataType, Double.class, "Number", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(transformEDataType, String.class, "Transform", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(pathDataEDataType, String.class, "PathData", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(listOfPointsEDataType, String.class, "ListOfPoints", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(listOfLengthsEDataType, String.class, "ListOfLengths", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(listOfNumbersEDataType, String.class, "ListOfNumbers", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(listOfCoordinatesEDataType, String.class, "ListOfCoordinates", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(nameEDataType, String.class, "Name", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(numberOptionalNumberEDataType, String.class, "NumberOptionalNumber", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(transformListEDataType, String.class, "TransformList", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //SvgPackageImpl
