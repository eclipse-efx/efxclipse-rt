/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.fx.formats.svg.svg.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.fx.formats.svg.svg.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SvgFactoryImpl extends EFactoryImpl implements SvgFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SvgFactory init() {
		try {
			SvgFactory theSvgFactory = (SvgFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.w3.org/2000/svg"); 
			if (theSvgFactory != null) {
				return theSvgFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SvgFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SvgFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case SvgPackage.ANIMATION_ELEMENT: return createAnimationElement();
			case SvgPackage._ENUMS_: return create____ENUMS____();
			case SvgPackage._DATATYPES_: return create____DATATYPES____();
			case SvgPackage._ATTRIBUTES_: return create____ATTRIBUTES____();
			case SvgPackage._ELEMENTES_: return create____ELEMENTES____();
			case SvgPackage.SVG_SVG_ELEMENT: return createSvgSvgElement();
			case SvgPackage.SVG_GELEMENT: return createSvgGElement();
			case SvgPackage.SVG_DEFS_ELEMENT: return createSvgDefsElement();
			case SvgPackage.SVG_DESC_ELEMENT: return createSvgDescElement();
			case SvgPackage.SVG_TITLE_ELEMENT: return createSvgTitleElement();
			case SvgPackage.SVG_SYMBOL_ELEMENT: return createSvgSymbolElement();
			case SvgPackage.SVG_USE_ELEMENT: return createSvgUseElement();
			case SvgPackage.SVG_IMAGE_ELEMENT: return createSvgImageElement();
			case SvgPackage.SVG_SWITCH_ELEMENT: return createSvgSwitchElement();
			case SvgPackage.SVG_PATH_ELEMENT: return createSvgPathElement();
			case SvgPackage.SVG_RECT_ELEMENT: return createSvgRectElement();
			case SvgPackage.SVG_CIRCLE_ELEMENT: return createSvgCircleElement();
			case SvgPackage.SVG_ELLIPSE_ELEMENT: return createSvgEllipseElement();
			case SvgPackage.SVG_LINE_ELEMENT: return createSvgLineElement();
			case SvgPackage.SVG_POLYLINE_ELEMENT: return createSvgPolylineElement();
			case SvgPackage.SVG_POLYGON_ELEMENT: return createSvgPolygonElement();
			case SvgPackage.SVG_TEXT_ELEMENT: return createSvgTextElement();
			case SvgPackage.SVG_TSPAN_ELEMENT: return createSvgTspanElement();
			case SvgPackage.SVG_TREF_ELEMENT: return createSvgTrefElement();
			case SvgPackage.SVG_TEXT_PATH_ELEMENT: return createSvgTextPathElement();
			case SvgPackage.SVG_ALT_GLYPH_ELEMENT: return createSvgAltGlyphElement();
			case SvgPackage.SVG_ALT_GLYPH_DEF_ELEMENT: return createSvgAltGlyphDefElement();
			case SvgPackage.SVG_ALT_GLYPH_ITEM_ELEMENT: return createSvgAltGlyphItemElement();
			case SvgPackage.SVG_ALT_GLYPH_REF_ELEMENT: return createSvgAltGlyphRefElement();
			case SvgPackage.SVG_MARKER_ELEMENT: return createSvgMarkerElement();
			case SvgPackage.SVG_COLOR_PROFILE_ELEMENT: return createSvgColorProfileElement();
			case SvgPackage.SVG_LINEAR_GRADIENT_ELEMENT: return createSvgLinearGradientElement();
			case SvgPackage.SVG_RADIAL_GRADIENT_ELEMENT: return createSvgRadialGradientElement();
			case SvgPackage.SVG_STOP_ELEMENT: return createSvgStopElement();
			case SvgPackage.SVG_PATTERN_ELEMENT: return createSvgPatternElement();
			case SvgPackage.SVG_CLIP_PATH_ELEMENT: return createSvgClipPathElement();
			case SvgPackage.SVG_MASK_ELEMENT: return createSvgMaskElement();
			case SvgPackage.SVG_FILTER_ELEMENT: return createSvgFilterElement();
			case SvgPackage.SVG_FE_DISTANT_LIGHT_ELEMENT: return createSvgFeDistantLightElement();
			case SvgPackage.SVG_FE_POINT_LIGHT_ELEMENT: return createSvgFePointLightElement();
			case SvgPackage.SVG_FE_SPOT_LIGHT_ELEMENT: return createSvgFeSpotLightElement();
			case SvgPackage.SVG_FE_BLEND_ELEMENT: return createSvgFeBlendElement();
			case SvgPackage.SVG_FE_COLOR_MATRIX_ELEMENT: return createSvgFeColorMatrixElement();
			case SvgPackage.SVG_FE_COMPONENT_TRANSFER_ELEMENT: return createSvgFeComponentTransferElement();
			case SvgPackage.SVG_FE_FUNC_RELEMENT: return createSvgFeFuncRElement();
			case SvgPackage.SVG_FE_FUNC_GELEMENT: return createSvgFeFuncGElement();
			case SvgPackage.SVG_FE_FUNC_BELEMENT: return createSvgFeFuncBElement();
			case SvgPackage.SVG_FE_FUNC_AELEMENT: return createSvgFeFuncAElement();
			case SvgPackage.SVG_FE_COMPOSITE_ELEMENT: return createSvgFeCompositeElement();
			case SvgPackage.SVG_FE_CONVOLVE_MATRIX_ELEMENT: return createSvgFeConvolveMatrixElement();
			case SvgPackage.SVG_FE_DIFFUSE_LIGHTING_ELEMENT: return createSvgFeDiffuseLightingElement();
			case SvgPackage.SVG_FE_DISPLACEMENT_MAP_ELEMENT: return createSvgFeDisplacementMapElement();
			case SvgPackage.SVG_FE_FLOOD_ELEMENT: return createSvgFeFloodElement();
			case SvgPackage.SVG_FE_GAUSSIAN_BLUR_ELEMENT: return createSvgFeGaussianBlurElement();
			case SvgPackage.SVG_FE_IMAGE_ELEMENT: return createSvgFeImageElement();
			case SvgPackage.SVG_FE_MERGE_ELEMENT: return createSvgFeMergeElement();
			case SvgPackage.SVG_FE_MERGE_NODE_ELEMENT: return createSvgFeMergeNodeElement();
			case SvgPackage.SVG_FE_MORPHOLOGY_ELEMENT: return createSvgFeMorphologyElement();
			case SvgPackage.SVG_FE_OFFSET_ELEMENT: return createSvgFeOffsetElement();
			case SvgPackage.SVG_FE_SPECULAR_LIGHTING_ELEMENT: return createSvgFeSpecularLightingElement();
			case SvgPackage.SVG_FE_TILE_ELEMENT: return createSvgFeTileElement();
			case SvgPackage.SVG_FE_TURBULENCE_ELEMENT: return createSvgFeTurbulenceElement();
			case SvgPackage.SVG_ANIMATE_ELEMENT: return createSvgAnimateElement();
			case SvgPackage.SVG_METADATA_ELEMENT: return createSvgMetadataElement();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case SvgPackage.ALIGNMENT_BASELINE:
				return createAlignment_baselineFromString(eDataType, initialValue);
			case SvgPackage.CLIP_RULE:
				return createClip_ruleFromString(eDataType, initialValue);
			case SvgPackage.COLOR_INTERPOLATION:
				return createColor_interpolationFromString(eDataType, initialValue);
			case SvgPackage.COLOR_INTERPOLATION_FILTERS:
				return createColor_interpolation_filtersFromString(eDataType, initialValue);
			case SvgPackage.COLOR_RENDERING:
				return createColor_renderingFromString(eDataType, initialValue);
			case SvgPackage.DIRECTION:
				return createDirectionFromString(eDataType, initialValue);
			case SvgPackage.DISPLAY:
				return createDisplayFromString(eDataType, initialValue);
			case SvgPackage.DOMINANT_BASELINE:
				return createDominant_baselineFromString(eDataType, initialValue);
			case SvgPackage.FILL_RULE:
				return createFill_ruleFromString(eDataType, initialValue);
			case SvgPackage.FONT_STRETCH:
				return createFont_stretchFromString(eDataType, initialValue);
			case SvgPackage.FONT_STYLE:
				return createFont_styleFromString(eDataType, initialValue);
			case SvgPackage.FONT_VARIANT:
				return createFont_variantFromString(eDataType, initialValue);
			case SvgPackage.FONT_WEIGHT:
				return createFont_weightFromString(eDataType, initialValue);
			case SvgPackage.IMAGE_RENDERING:
				return createImage_renderingFromString(eDataType, initialValue);
			case SvgPackage.OVERFLOW:
				return createOverflowFromString(eDataType, initialValue);
			case SvgPackage.POINTER_EVENTS:
				return createPointer_eventsFromString(eDataType, initialValue);
			case SvgPackage.SHAPE_RENDERING:
				return createShape_renderingFromString(eDataType, initialValue);
			case SvgPackage.STROKE_LINECAP:
				return createStroke_linecapFromString(eDataType, initialValue);
			case SvgPackage.STROKE_LINEJOIN:
				return createStroke_linejoinFromString(eDataType, initialValue);
			case SvgPackage.TEXT_ANCHOR:
				return createText_anchorFromString(eDataType, initialValue);
			case SvgPackage.TEXT_RENDERING:
				return createText_renderingFromString(eDataType, initialValue);
			case SvgPackage.UNICODE_BIDI:
				return createUnicode_bidiFromString(eDataType, initialValue);
			case SvgPackage.VISIBILITY:
				return createVisibilityFromString(eDataType, initialValue);
			case SvgPackage.WRITING_MODE:
				return createWriting_modeFromString(eDataType, initialValue);
			case SvgPackage.ZOOM_AND_PAN:
				return createZoomAndPanFromString(eDataType, initialValue);
			case SvgPackage.LENGTH_ADJUST:
				return createLengthAdjustFromString(eDataType, initialValue);
			case SvgPackage.METHOD:
				return createMethodFromString(eDataType, initialValue);
			case SvgPackage.SPACING:
				return createSpacingFromString(eDataType, initialValue);
			case SvgPackage.MARKER_UNITS:
				return createMarkerUnitsFromString(eDataType, initialValue);
			case SvgPackage.RENDERING_INTENT:
				return createRendering_intentFromString(eDataType, initialValue);
			case SvgPackage.GRADIENT_UNITS:
				return createGradientUnitsFromString(eDataType, initialValue);
			case SvgPackage.SPREAD_METHOD:
				return createSpreadMethodFromString(eDataType, initialValue);
			case SvgPackage.PATTERN_UNITS:
				return createPatternUnitsFromString(eDataType, initialValue);
			case SvgPackage.CLIP_PATH_UNITS:
				return createClipPathUnitsFromString(eDataType, initialValue);
			case SvgPackage.MASK_UNITS:
				return createMaskUnitsFromString(eDataType, initialValue);
			case SvgPackage.FILTER_UNITS:
				return createFilterUnitsFromString(eDataType, initialValue);
			case SvgPackage.BLEND_MODE:
				return createBlendModeFromString(eDataType, initialValue);
			case SvgPackage.COLOR_MATRIX_TYPE:
				return createColorMatrixTypeFromString(eDataType, initialValue);
			case SvgPackage.COMPOSITE_OPERATOR:
				return createCompositeOperatorFromString(eDataType, initialValue);
			case SvgPackage.CONVOLVE_MATRIX_EDGE_MODE:
				return createConvolveMatrixEdgeModeFromString(eDataType, initialValue);
			case SvgPackage.CHANNEL_SELECTOR:
				return createChannelSelectorFromString(eDataType, initialValue);
			case SvgPackage.MORPHOLOGY_OPERATOR:
				return createMorphologyOperatorFromString(eDataType, initialValue);
			case SvgPackage.STITCH_TILES:
				return createStitchTilesFromString(eDataType, initialValue);
			case SvgPackage.TURBULENCE_TYPE:
				return createTurbulenceTypeFromString(eDataType, initialValue);
			case SvgPackage.LENGTH:
				return createLengthFromString(eDataType, initialValue);
			case SvgPackage.ANGLE:
				return createAngleFromString(eDataType, initialValue);
			case SvgPackage.PERCENTAGE:
				return createPercentageFromString(eDataType, initialValue);
			case SvgPackage.SHAPE:
				return createShapeFromString(eDataType, initialValue);
			case SvgPackage.FUNCIRI:
				return createFunciriFromString(eDataType, initialValue);
			case SvgPackage.COLOR:
				return createColorFromString(eDataType, initialValue);
			case SvgPackage.PAINT:
				return createPaintFromString(eDataType, initialValue);
			case SvgPackage.OPACITY_VALUE:
				return createOpacity_valueFromString(eDataType, initialValue);
			case SvgPackage.BASELINE_SHIFT:
				return createBaseline_shiftFromString(eDataType, initialValue);
			case SvgPackage.CLIP:
				return createClipFromString(eDataType, initialValue);
			case SvgPackage.CLIP_PATH:
				return createClip_pathFromString(eDataType, initialValue);
			case SvgPackage.COLOR_PROFILE:
				return createColor_profileFromString(eDataType, initialValue);
			case SvgPackage.CURSOR:
				return createCursorFromString(eDataType, initialValue);
			case SvgPackage.ENABLE_BACKGROUND:
				return createEnable_backgroundFromString(eDataType, initialValue);
			case SvgPackage.FILL:
				return createFillFromString(eDataType, initialValue);
			case SvgPackage.FILL_OPACITY:
				return createFill_opacityFromString(eDataType, initialValue);
			case SvgPackage.FILTER:
				return createFilterFromString(eDataType, initialValue);
			case SvgPackage.FLOOD_COLOR:
				return createFlood_colorFromString(eDataType, initialValue);
			case SvgPackage.FLOOD_OPACITY:
				return createFlood_opacityFromString(eDataType, initialValue);
			case SvgPackage.FONT_FAMILY:
				return createFont_familyFromString(eDataType, initialValue);
			case SvgPackage.FONT_SIZE:
				return createFont_sizeFromString(eDataType, initialValue);
			case SvgPackage.FONT_SIZE_ADJUST:
				return createFont_size_adjustFromString(eDataType, initialValue);
			case SvgPackage.GLYPH_ORIENTATION_HORIZONTAL:
				return createGlyph_orientation_horizontalFromString(eDataType, initialValue);
			case SvgPackage.GLYPH_ORIENTATION_VERTICAL:
				return createGlyph_orientation_verticalFromString(eDataType, initialValue);
			case SvgPackage.KERNING:
				return createKerningFromString(eDataType, initialValue);
			case SvgPackage.LETTER_SPACING:
				return createLetter_spacingFromString(eDataType, initialValue);
			case SvgPackage.LIGHTING_COLOR:
				return createLighting_colorFromString(eDataType, initialValue);
			case SvgPackage.MARKER_END:
				return createMarker_endFromString(eDataType, initialValue);
			case SvgPackage.MARKER_MID:
				return createMarker_midFromString(eDataType, initialValue);
			case SvgPackage.MARKER_START:
				return createMarker_startFromString(eDataType, initialValue);
			case SvgPackage.MASKS:
				return createMasksFromString(eDataType, initialValue);
			case SvgPackage.OPACITY:
				return createOpacityFromString(eDataType, initialValue);
			case SvgPackage.STOP_COLOR:
				return createStop_colorFromString(eDataType, initialValue);
			case SvgPackage.STOP_OPACITY:
				return createStop_opacityFromString(eDataType, initialValue);
			case SvgPackage.STROKE:
				return createStrokeFromString(eDataType, initialValue);
			case SvgPackage.STROKE_DASHARRAY:
				return createStroke_dasharrayFromString(eDataType, initialValue);
			case SvgPackage.STROKE_DASHOFFSET:
				return createStroke_dashoffsetFromString(eDataType, initialValue);
			case SvgPackage.STROKE_MITERLIMIT:
				return createStroke_miterlimitFromString(eDataType, initialValue);
			case SvgPackage.STROKE_OPACITY:
				return createStroke_opacityFromString(eDataType, initialValue);
			case SvgPackage.STROKE_WIDTH:
				return createStroke_widthFromString(eDataType, initialValue);
			case SvgPackage.TEXT_DECORATION:
				return createText_decorationFromString(eDataType, initialValue);
			case SvgPackage.WORD_SPACING:
				return createWord_spacingFromString(eDataType, initialValue);
			case SvgPackage.COORDINATE:
				return createCoordinateFromString(eDataType, initialValue);
			case SvgPackage.VIEW_BOX:
				return createViewBoxFromString(eDataType, initialValue);
			case SvgPackage.PRESERVE_ASPECT_RATIO:
				return createPreserveAspectRatioFromString(eDataType, initialValue);
			case SvgPackage.NUMBER:
				return createNumberFromString(eDataType, initialValue);
			case SvgPackage.TRANSFORM:
				return createTransformFromString(eDataType, initialValue);
			case SvgPackage.PATH_DATA:
				return createPathDataFromString(eDataType, initialValue);
			case SvgPackage.LIST_OF_POINTS:
				return createListOfPointsFromString(eDataType, initialValue);
			case SvgPackage.LIST_OF_LENGTHS:
				return createListOfLengthsFromString(eDataType, initialValue);
			case SvgPackage.LIST_OF_NUMBERS:
				return createListOfNumbersFromString(eDataType, initialValue);
			case SvgPackage.LIST_OF_COORDINATES:
				return createListOfCoordinatesFromString(eDataType, initialValue);
			case SvgPackage.NAME:
				return createNameFromString(eDataType, initialValue);
			case SvgPackage.NUMBER_OPTIONAL_NUMBER:
				return createNumberOptionalNumberFromString(eDataType, initialValue);
			case SvgPackage.TRANSFORM_LIST:
				return createTransformListFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case SvgPackage.ALIGNMENT_BASELINE:
				return convertAlignment_baselineToString(eDataType, instanceValue);
			case SvgPackage.CLIP_RULE:
				return convertClip_ruleToString(eDataType, instanceValue);
			case SvgPackage.COLOR_INTERPOLATION:
				return convertColor_interpolationToString(eDataType, instanceValue);
			case SvgPackage.COLOR_INTERPOLATION_FILTERS:
				return convertColor_interpolation_filtersToString(eDataType, instanceValue);
			case SvgPackage.COLOR_RENDERING:
				return convertColor_renderingToString(eDataType, instanceValue);
			case SvgPackage.DIRECTION:
				return convertDirectionToString(eDataType, instanceValue);
			case SvgPackage.DISPLAY:
				return convertDisplayToString(eDataType, instanceValue);
			case SvgPackage.DOMINANT_BASELINE:
				return convertDominant_baselineToString(eDataType, instanceValue);
			case SvgPackage.FILL_RULE:
				return convertFill_ruleToString(eDataType, instanceValue);
			case SvgPackage.FONT_STRETCH:
				return convertFont_stretchToString(eDataType, instanceValue);
			case SvgPackage.FONT_STYLE:
				return convertFont_styleToString(eDataType, instanceValue);
			case SvgPackage.FONT_VARIANT:
				return convertFont_variantToString(eDataType, instanceValue);
			case SvgPackage.FONT_WEIGHT:
				return convertFont_weightToString(eDataType, instanceValue);
			case SvgPackage.IMAGE_RENDERING:
				return convertImage_renderingToString(eDataType, instanceValue);
			case SvgPackage.OVERFLOW:
				return convertOverflowToString(eDataType, instanceValue);
			case SvgPackage.POINTER_EVENTS:
				return convertPointer_eventsToString(eDataType, instanceValue);
			case SvgPackage.SHAPE_RENDERING:
				return convertShape_renderingToString(eDataType, instanceValue);
			case SvgPackage.STROKE_LINECAP:
				return convertStroke_linecapToString(eDataType, instanceValue);
			case SvgPackage.STROKE_LINEJOIN:
				return convertStroke_linejoinToString(eDataType, instanceValue);
			case SvgPackage.TEXT_ANCHOR:
				return convertText_anchorToString(eDataType, instanceValue);
			case SvgPackage.TEXT_RENDERING:
				return convertText_renderingToString(eDataType, instanceValue);
			case SvgPackage.UNICODE_BIDI:
				return convertUnicode_bidiToString(eDataType, instanceValue);
			case SvgPackage.VISIBILITY:
				return convertVisibilityToString(eDataType, instanceValue);
			case SvgPackage.WRITING_MODE:
				return convertWriting_modeToString(eDataType, instanceValue);
			case SvgPackage.ZOOM_AND_PAN:
				return convertZoomAndPanToString(eDataType, instanceValue);
			case SvgPackage.LENGTH_ADJUST:
				return convertLengthAdjustToString(eDataType, instanceValue);
			case SvgPackage.METHOD:
				return convertMethodToString(eDataType, instanceValue);
			case SvgPackage.SPACING:
				return convertSpacingToString(eDataType, instanceValue);
			case SvgPackage.MARKER_UNITS:
				return convertMarkerUnitsToString(eDataType, instanceValue);
			case SvgPackage.RENDERING_INTENT:
				return convertRendering_intentToString(eDataType, instanceValue);
			case SvgPackage.GRADIENT_UNITS:
				return convertGradientUnitsToString(eDataType, instanceValue);
			case SvgPackage.SPREAD_METHOD:
				return convertSpreadMethodToString(eDataType, instanceValue);
			case SvgPackage.PATTERN_UNITS:
				return convertPatternUnitsToString(eDataType, instanceValue);
			case SvgPackage.CLIP_PATH_UNITS:
				return convertClipPathUnitsToString(eDataType, instanceValue);
			case SvgPackage.MASK_UNITS:
				return convertMaskUnitsToString(eDataType, instanceValue);
			case SvgPackage.FILTER_UNITS:
				return convertFilterUnitsToString(eDataType, instanceValue);
			case SvgPackage.BLEND_MODE:
				return convertBlendModeToString(eDataType, instanceValue);
			case SvgPackage.COLOR_MATRIX_TYPE:
				return convertColorMatrixTypeToString(eDataType, instanceValue);
			case SvgPackage.COMPOSITE_OPERATOR:
				return convertCompositeOperatorToString(eDataType, instanceValue);
			case SvgPackage.CONVOLVE_MATRIX_EDGE_MODE:
				return convertConvolveMatrixEdgeModeToString(eDataType, instanceValue);
			case SvgPackage.CHANNEL_SELECTOR:
				return convertChannelSelectorToString(eDataType, instanceValue);
			case SvgPackage.MORPHOLOGY_OPERATOR:
				return convertMorphologyOperatorToString(eDataType, instanceValue);
			case SvgPackage.STITCH_TILES:
				return convertStitchTilesToString(eDataType, instanceValue);
			case SvgPackage.TURBULENCE_TYPE:
				return convertTurbulenceTypeToString(eDataType, instanceValue);
			case SvgPackage.LENGTH:
				return convertLengthToString(eDataType, instanceValue);
			case SvgPackage.ANGLE:
				return convertAngleToString(eDataType, instanceValue);
			case SvgPackage.PERCENTAGE:
				return convertPercentageToString(eDataType, instanceValue);
			case SvgPackage.SHAPE:
				return convertShapeToString(eDataType, instanceValue);
			case SvgPackage.FUNCIRI:
				return convertFunciriToString(eDataType, instanceValue);
			case SvgPackage.COLOR:
				return convertColorToString(eDataType, instanceValue);
			case SvgPackage.PAINT:
				return convertPaintToString(eDataType, instanceValue);
			case SvgPackage.OPACITY_VALUE:
				return convertOpacity_valueToString(eDataType, instanceValue);
			case SvgPackage.BASELINE_SHIFT:
				return convertBaseline_shiftToString(eDataType, instanceValue);
			case SvgPackage.CLIP:
				return convertClipToString(eDataType, instanceValue);
			case SvgPackage.CLIP_PATH:
				return convertClip_pathToString(eDataType, instanceValue);
			case SvgPackage.COLOR_PROFILE:
				return convertColor_profileToString(eDataType, instanceValue);
			case SvgPackage.CURSOR:
				return convertCursorToString(eDataType, instanceValue);
			case SvgPackage.ENABLE_BACKGROUND:
				return convertEnable_backgroundToString(eDataType, instanceValue);
			case SvgPackage.FILL:
				return convertFillToString(eDataType, instanceValue);
			case SvgPackage.FILL_OPACITY:
				return convertFill_opacityToString(eDataType, instanceValue);
			case SvgPackage.FILTER:
				return convertFilterToString(eDataType, instanceValue);
			case SvgPackage.FLOOD_COLOR:
				return convertFlood_colorToString(eDataType, instanceValue);
			case SvgPackage.FLOOD_OPACITY:
				return convertFlood_opacityToString(eDataType, instanceValue);
			case SvgPackage.FONT_FAMILY:
				return convertFont_familyToString(eDataType, instanceValue);
			case SvgPackage.FONT_SIZE:
				return convertFont_sizeToString(eDataType, instanceValue);
			case SvgPackage.FONT_SIZE_ADJUST:
				return convertFont_size_adjustToString(eDataType, instanceValue);
			case SvgPackage.GLYPH_ORIENTATION_HORIZONTAL:
				return convertGlyph_orientation_horizontalToString(eDataType, instanceValue);
			case SvgPackage.GLYPH_ORIENTATION_VERTICAL:
				return convertGlyph_orientation_verticalToString(eDataType, instanceValue);
			case SvgPackage.KERNING:
				return convertKerningToString(eDataType, instanceValue);
			case SvgPackage.LETTER_SPACING:
				return convertLetter_spacingToString(eDataType, instanceValue);
			case SvgPackage.LIGHTING_COLOR:
				return convertLighting_colorToString(eDataType, instanceValue);
			case SvgPackage.MARKER_END:
				return convertMarker_endToString(eDataType, instanceValue);
			case SvgPackage.MARKER_MID:
				return convertMarker_midToString(eDataType, instanceValue);
			case SvgPackage.MARKER_START:
				return convertMarker_startToString(eDataType, instanceValue);
			case SvgPackage.MASKS:
				return convertMasksToString(eDataType, instanceValue);
			case SvgPackage.OPACITY:
				return convertOpacityToString(eDataType, instanceValue);
			case SvgPackage.STOP_COLOR:
				return convertStop_colorToString(eDataType, instanceValue);
			case SvgPackage.STOP_OPACITY:
				return convertStop_opacityToString(eDataType, instanceValue);
			case SvgPackage.STROKE:
				return convertStrokeToString(eDataType, instanceValue);
			case SvgPackage.STROKE_DASHARRAY:
				return convertStroke_dasharrayToString(eDataType, instanceValue);
			case SvgPackage.STROKE_DASHOFFSET:
				return convertStroke_dashoffsetToString(eDataType, instanceValue);
			case SvgPackage.STROKE_MITERLIMIT:
				return convertStroke_miterlimitToString(eDataType, instanceValue);
			case SvgPackage.STROKE_OPACITY:
				return convertStroke_opacityToString(eDataType, instanceValue);
			case SvgPackage.STROKE_WIDTH:
				return convertStroke_widthToString(eDataType, instanceValue);
			case SvgPackage.TEXT_DECORATION:
				return convertText_decorationToString(eDataType, instanceValue);
			case SvgPackage.WORD_SPACING:
				return convertWord_spacingToString(eDataType, instanceValue);
			case SvgPackage.COORDINATE:
				return convertCoordinateToString(eDataType, instanceValue);
			case SvgPackage.VIEW_BOX:
				return convertViewBoxToString(eDataType, instanceValue);
			case SvgPackage.PRESERVE_ASPECT_RATIO:
				return convertPreserveAspectRatioToString(eDataType, instanceValue);
			case SvgPackage.NUMBER:
				return convertNumberToString(eDataType, instanceValue);
			case SvgPackage.TRANSFORM:
				return convertTransformToString(eDataType, instanceValue);
			case SvgPackage.PATH_DATA:
				return convertPathDataToString(eDataType, instanceValue);
			case SvgPackage.LIST_OF_POINTS:
				return convertListOfPointsToString(eDataType, instanceValue);
			case SvgPackage.LIST_OF_LENGTHS:
				return convertListOfLengthsToString(eDataType, instanceValue);
			case SvgPackage.LIST_OF_NUMBERS:
				return convertListOfNumbersToString(eDataType, instanceValue);
			case SvgPackage.LIST_OF_COORDINATES:
				return convertListOfCoordinatesToString(eDataType, instanceValue);
			case SvgPackage.NAME:
				return convertNameToString(eDataType, instanceValue);
			case SvgPackage.NUMBER_OPTIONAL_NUMBER:
				return convertNumberOptionalNumberToString(eDataType, instanceValue);
			case SvgPackage.TRANSFORM_LIST:
				return convertTransformListToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnimationElement createAnimationElement() {
		AnimationElementImpl animationElement = new AnimationElementImpl();
		return animationElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ____ENUMS____ create____ENUMS____() {
		____ENUMS____Impl ____ENUMS____ = new ____ENUMS____Impl();
		return ____ENUMS____;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ____DATATYPES____ create____DATATYPES____() {
		____DATATYPES____Impl ____DATATYPES____ = new ____DATATYPES____Impl();
		return ____DATATYPES____;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ____ATTRIBUTES____ create____ATTRIBUTES____() {
		____ATTRIBUTES____Impl ____ATTRIBUTES____ = new ____ATTRIBUTES____Impl();
		return ____ATTRIBUTES____;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ____ELEMENTES____ create____ELEMENTES____() {
		____ELEMENTES____Impl ____ELEMENTES____ = new ____ELEMENTES____Impl();
		return ____ELEMENTES____;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SvgSvgElement createSvgSvgElement() {
		SvgSvgElementImpl svgSvgElement = new SvgSvgElementImpl();
		return svgSvgElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SvgGElement createSvgGElement() {
		SvgGElementImpl svgGElement = new SvgGElementImpl();
		return svgGElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SvgDefsElement createSvgDefsElement() {
		SvgDefsElementImpl svgDefsElement = new SvgDefsElementImpl();
		return svgDefsElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SvgDescElement createSvgDescElement() {
		SvgDescElementImpl svgDescElement = new SvgDescElementImpl();
		return svgDescElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SvgTitleElement createSvgTitleElement() {
		SvgTitleElementImpl svgTitleElement = new SvgTitleElementImpl();
		return svgTitleElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SvgSymbolElement createSvgSymbolElement() {
		SvgSymbolElementImpl svgSymbolElement = new SvgSymbolElementImpl();
		return svgSymbolElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SvgUseElement createSvgUseElement() {
		SvgUseElementImpl svgUseElement = new SvgUseElementImpl();
		return svgUseElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SvgImageElement createSvgImageElement() {
		SvgImageElementImpl svgImageElement = new SvgImageElementImpl();
		return svgImageElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SvgSwitchElement createSvgSwitchElement() {
		SvgSwitchElementImpl svgSwitchElement = new SvgSwitchElementImpl();
		return svgSwitchElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SvgPathElement createSvgPathElement() {
		SvgPathElementImpl svgPathElement = new SvgPathElementImpl();
		return svgPathElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SvgRectElement createSvgRectElement() {
		SvgRectElementImpl svgRectElement = new SvgRectElementImpl();
		return svgRectElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SvgCircleElement createSvgCircleElement() {
		SvgCircleElementImpl svgCircleElement = new SvgCircleElementImpl();
		return svgCircleElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SvgEllipseElement createSvgEllipseElement() {
		SvgEllipseElementImpl svgEllipseElement = new SvgEllipseElementImpl();
		return svgEllipseElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SvgLineElement createSvgLineElement() {
		SvgLineElementImpl svgLineElement = new SvgLineElementImpl();
		return svgLineElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SvgPolylineElement createSvgPolylineElement() {
		SvgPolylineElementImpl svgPolylineElement = new SvgPolylineElementImpl();
		return svgPolylineElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SvgPolygonElement createSvgPolygonElement() {
		SvgPolygonElementImpl svgPolygonElement = new SvgPolygonElementImpl();
		return svgPolygonElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SvgTextElement createSvgTextElement() {
		SvgTextElementImpl svgTextElement = new SvgTextElementImpl();
		return svgTextElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SvgTspanElement createSvgTspanElement() {
		SvgTspanElementImpl svgTspanElement = new SvgTspanElementImpl();
		return svgTspanElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SvgTrefElement createSvgTrefElement() {
		SvgTrefElementImpl svgTrefElement = new SvgTrefElementImpl();
		return svgTrefElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SvgTextPathElement createSvgTextPathElement() {
		SvgTextPathElementImpl svgTextPathElement = new SvgTextPathElementImpl();
		return svgTextPathElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SvgAltGlyphElement createSvgAltGlyphElement() {
		SvgAltGlyphElementImpl svgAltGlyphElement = new SvgAltGlyphElementImpl();
		return svgAltGlyphElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SvgAltGlyphDefElement createSvgAltGlyphDefElement() {
		SvgAltGlyphDefElementImpl svgAltGlyphDefElement = new SvgAltGlyphDefElementImpl();
		return svgAltGlyphDefElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SvgAltGlyphItemElement createSvgAltGlyphItemElement() {
		SvgAltGlyphItemElementImpl svgAltGlyphItemElement = new SvgAltGlyphItemElementImpl();
		return svgAltGlyphItemElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SvgAltGlyphRefElement createSvgAltGlyphRefElement() {
		SvgAltGlyphRefElementImpl svgAltGlyphRefElement = new SvgAltGlyphRefElementImpl();
		return svgAltGlyphRefElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SvgMarkerElement createSvgMarkerElement() {
		SvgMarkerElementImpl svgMarkerElement = new SvgMarkerElementImpl();
		return svgMarkerElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SvgColorProfileElement createSvgColorProfileElement() {
		SvgColorProfileElementImpl svgColorProfileElement = new SvgColorProfileElementImpl();
		return svgColorProfileElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SvgLinearGradientElement createSvgLinearGradientElement() {
		SvgLinearGradientElementImpl svgLinearGradientElement = new SvgLinearGradientElementImpl();
		return svgLinearGradientElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SvgRadialGradientElement createSvgRadialGradientElement() {
		SvgRadialGradientElementImpl svgRadialGradientElement = new SvgRadialGradientElementImpl();
		return svgRadialGradientElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SvgStopElement createSvgStopElement() {
		SvgStopElementImpl svgStopElement = new SvgStopElementImpl();
		return svgStopElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SvgPatternElement createSvgPatternElement() {
		SvgPatternElementImpl svgPatternElement = new SvgPatternElementImpl();
		return svgPatternElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SvgClipPathElement createSvgClipPathElement() {
		SvgClipPathElementImpl svgClipPathElement = new SvgClipPathElementImpl();
		return svgClipPathElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SvgMaskElement createSvgMaskElement() {
		SvgMaskElementImpl svgMaskElement = new SvgMaskElementImpl();
		return svgMaskElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SvgFilterElement createSvgFilterElement() {
		SvgFilterElementImpl svgFilterElement = new SvgFilterElementImpl();
		return svgFilterElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SvgFeDistantLightElement createSvgFeDistantLightElement() {
		SvgFeDistantLightElementImpl svgFeDistantLightElement = new SvgFeDistantLightElementImpl();
		return svgFeDistantLightElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SvgFePointLightElement createSvgFePointLightElement() {
		SvgFePointLightElementImpl svgFePointLightElement = new SvgFePointLightElementImpl();
		return svgFePointLightElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SvgFeSpotLightElement createSvgFeSpotLightElement() {
		SvgFeSpotLightElementImpl svgFeSpotLightElement = new SvgFeSpotLightElementImpl();
		return svgFeSpotLightElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SvgFeBlendElement createSvgFeBlendElement() {
		SvgFeBlendElementImpl svgFeBlendElement = new SvgFeBlendElementImpl();
		return svgFeBlendElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SvgFeColorMatrixElement createSvgFeColorMatrixElement() {
		SvgFeColorMatrixElementImpl svgFeColorMatrixElement = new SvgFeColorMatrixElementImpl();
		return svgFeColorMatrixElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SvgFeComponentTransferElement createSvgFeComponentTransferElement() {
		SvgFeComponentTransferElementImpl svgFeComponentTransferElement = new SvgFeComponentTransferElementImpl();
		return svgFeComponentTransferElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SvgFeFuncRElement createSvgFeFuncRElement() {
		SvgFeFuncRElementImpl svgFeFuncRElement = new SvgFeFuncRElementImpl();
		return svgFeFuncRElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SvgFeFuncGElement createSvgFeFuncGElement() {
		SvgFeFuncGElementImpl svgFeFuncGElement = new SvgFeFuncGElementImpl();
		return svgFeFuncGElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SvgFeFuncBElement createSvgFeFuncBElement() {
		SvgFeFuncBElementImpl svgFeFuncBElement = new SvgFeFuncBElementImpl();
		return svgFeFuncBElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SvgFeFuncAElement createSvgFeFuncAElement() {
		SvgFeFuncAElementImpl svgFeFuncAElement = new SvgFeFuncAElementImpl();
		return svgFeFuncAElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SvgFeCompositeElement createSvgFeCompositeElement() {
		SvgFeCompositeElementImpl svgFeCompositeElement = new SvgFeCompositeElementImpl();
		return svgFeCompositeElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SvgFeConvolveMatrixElement createSvgFeConvolveMatrixElement() {
		SvgFeConvolveMatrixElementImpl svgFeConvolveMatrixElement = new SvgFeConvolveMatrixElementImpl();
		return svgFeConvolveMatrixElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SvgFeDiffuseLightingElement createSvgFeDiffuseLightingElement() {
		SvgFeDiffuseLightingElementImpl svgFeDiffuseLightingElement = new SvgFeDiffuseLightingElementImpl();
		return svgFeDiffuseLightingElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SvgFeDisplacementMapElement createSvgFeDisplacementMapElement() {
		SvgFeDisplacementMapElementImpl svgFeDisplacementMapElement = new SvgFeDisplacementMapElementImpl();
		return svgFeDisplacementMapElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SvgFeFloodElement createSvgFeFloodElement() {
		SvgFeFloodElementImpl svgFeFloodElement = new SvgFeFloodElementImpl();
		return svgFeFloodElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SvgFeGaussianBlurElement createSvgFeGaussianBlurElement() {
		SvgFeGaussianBlurElementImpl svgFeGaussianBlurElement = new SvgFeGaussianBlurElementImpl();
		return svgFeGaussianBlurElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SvgFeImageElement createSvgFeImageElement() {
		SvgFeImageElementImpl svgFeImageElement = new SvgFeImageElementImpl();
		return svgFeImageElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SvgFeMergeElement createSvgFeMergeElement() {
		SvgFeMergeElementImpl svgFeMergeElement = new SvgFeMergeElementImpl();
		return svgFeMergeElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SvgFeMergeNodeElement createSvgFeMergeNodeElement() {
		SvgFeMergeNodeElementImpl svgFeMergeNodeElement = new SvgFeMergeNodeElementImpl();
		return svgFeMergeNodeElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SvgFeMorphologyElement createSvgFeMorphologyElement() {
		SvgFeMorphologyElementImpl svgFeMorphologyElement = new SvgFeMorphologyElementImpl();
		return svgFeMorphologyElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SvgFeOffsetElement createSvgFeOffsetElement() {
		SvgFeOffsetElementImpl svgFeOffsetElement = new SvgFeOffsetElementImpl();
		return svgFeOffsetElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SvgFeSpecularLightingElement createSvgFeSpecularLightingElement() {
		SvgFeSpecularLightingElementImpl svgFeSpecularLightingElement = new SvgFeSpecularLightingElementImpl();
		return svgFeSpecularLightingElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SvgFeTileElement createSvgFeTileElement() {
		SvgFeTileElementImpl svgFeTileElement = new SvgFeTileElementImpl();
		return svgFeTileElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SvgFeTurbulenceElement createSvgFeTurbulenceElement() {
		SvgFeTurbulenceElementImpl svgFeTurbulenceElement = new SvgFeTurbulenceElementImpl();
		return svgFeTurbulenceElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SvgAnimateElement createSvgAnimateElement() {
		SvgAnimateElementImpl svgAnimateElement = new SvgAnimateElementImpl();
		return svgAnimateElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SvgMetadataElement createSvgMetadataElement() {
		SvgMetadataElementImpl svgMetadataElement = new SvgMetadataElementImpl();
		return svgMetadataElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Alignment_baseline createAlignment_baselineFromString(EDataType eDataType, String initialValue) {
		Alignment_baseline result = Alignment_baseline.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAlignment_baselineToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Clip_rule createClip_ruleFromString(EDataType eDataType, String initialValue) {
		Clip_rule result = Clip_rule.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertClip_ruleToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Color_interpolation createColor_interpolationFromString(EDataType eDataType, String initialValue) {
		Color_interpolation result = Color_interpolation.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertColor_interpolationToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Color_interpolation_filters createColor_interpolation_filtersFromString(EDataType eDataType, String initialValue) {
		Color_interpolation_filters result = Color_interpolation_filters.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertColor_interpolation_filtersToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Color_rendering createColor_renderingFromString(EDataType eDataType, String initialValue) {
		Color_rendering result = Color_rendering.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertColor_renderingToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Direction createDirectionFromString(EDataType eDataType, String initialValue) {
		Direction result = Direction.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDirectionToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Display createDisplayFromString(EDataType eDataType, String initialValue) {
		Display result = Display.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDisplayToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Dominant_baseline createDominant_baselineFromString(EDataType eDataType, String initialValue) {
		Dominant_baseline result = Dominant_baseline.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDominant_baselineToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Fill_rule createFill_ruleFromString(EDataType eDataType, String initialValue) {
		Fill_rule result = Fill_rule.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertFill_ruleToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Font_stretch createFont_stretchFromString(EDataType eDataType, String initialValue) {
		Font_stretch result = Font_stretch.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertFont_stretchToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Font_style createFont_styleFromString(EDataType eDataType, String initialValue) {
		Font_style result = Font_style.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertFont_styleToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Font_variant createFont_variantFromString(EDataType eDataType, String initialValue) {
		Font_variant result = Font_variant.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertFont_variantToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Font_weight createFont_weightFromString(EDataType eDataType, String initialValue) {
		Font_weight result = Font_weight.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertFont_weightToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Image_rendering createImage_renderingFromString(EDataType eDataType, String initialValue) {
		Image_rendering result = Image_rendering.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertImage_renderingToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Overflow createOverflowFromString(EDataType eDataType, String initialValue) {
		Overflow result = Overflow.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertOverflowToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Pointer_events createPointer_eventsFromString(EDataType eDataType, String initialValue) {
		Pointer_events result = Pointer_events.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPointer_eventsToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Shape_rendering createShape_renderingFromString(EDataType eDataType, String initialValue) {
		Shape_rendering result = Shape_rendering.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertShape_renderingToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Stroke_linecap createStroke_linecapFromString(EDataType eDataType, String initialValue) {
		Stroke_linecap result = Stroke_linecap.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertStroke_linecapToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Stroke_linejoin createStroke_linejoinFromString(EDataType eDataType, String initialValue) {
		Stroke_linejoin result = Stroke_linejoin.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertStroke_linejoinToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Text_anchor createText_anchorFromString(EDataType eDataType, String initialValue) {
		Text_anchor result = Text_anchor.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertText_anchorToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Text_rendering createText_renderingFromString(EDataType eDataType, String initialValue) {
		Text_rendering result = Text_rendering.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertText_renderingToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Unicode_bidi createUnicode_bidiFromString(EDataType eDataType, String initialValue) {
		Unicode_bidi result = Unicode_bidi.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertUnicode_bidiToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Visibility createVisibilityFromString(EDataType eDataType, String initialValue) {
		Visibility result = Visibility.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertVisibilityToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Writing_mode createWriting_modeFromString(EDataType eDataType, String initialValue) {
		Writing_mode result = Writing_mode.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertWriting_modeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ZoomAndPan createZoomAndPanFromString(EDataType eDataType, String initialValue) {
		ZoomAndPan result = ZoomAndPan.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertZoomAndPanToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LengthAdjust createLengthAdjustFromString(EDataType eDataType, String initialValue) {
		LengthAdjust result = LengthAdjust.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLengthAdjustToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Method createMethodFromString(EDataType eDataType, String initialValue) {
		Method result = Method.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMethodToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Spacing createSpacingFromString(EDataType eDataType, String initialValue) {
		Spacing result = Spacing.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSpacingToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MarkerUnits createMarkerUnitsFromString(EDataType eDataType, String initialValue) {
		MarkerUnits result = MarkerUnits.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMarkerUnitsToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Rendering_intent createRendering_intentFromString(EDataType eDataType, String initialValue) {
		Rendering_intent result = Rendering_intent.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertRendering_intentToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GradientUnits createGradientUnitsFromString(EDataType eDataType, String initialValue) {
		GradientUnits result = GradientUnits.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertGradientUnitsToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpreadMethod createSpreadMethodFromString(EDataType eDataType, String initialValue) {
		SpreadMethod result = SpreadMethod.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSpreadMethodToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PatternUnits createPatternUnitsFromString(EDataType eDataType, String initialValue) {
		PatternUnits result = PatternUnits.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPatternUnitsToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClipPathUnits createClipPathUnitsFromString(EDataType eDataType, String initialValue) {
		ClipPathUnits result = ClipPathUnits.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertClipPathUnitsToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MaskUnits createMaskUnitsFromString(EDataType eDataType, String initialValue) {
		MaskUnits result = MaskUnits.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMaskUnitsToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FilterUnits createFilterUnitsFromString(EDataType eDataType, String initialValue) {
		FilterUnits result = FilterUnits.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertFilterUnitsToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BlendMode createBlendModeFromString(EDataType eDataType, String initialValue) {
		BlendMode result = BlendMode.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertBlendModeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ColorMatrixType createColorMatrixTypeFromString(EDataType eDataType, String initialValue) {
		ColorMatrixType result = ColorMatrixType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertColorMatrixTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositeOperator createCompositeOperatorFromString(EDataType eDataType, String initialValue) {
		CompositeOperator result = CompositeOperator.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCompositeOperatorToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConvolveMatrixEdgeMode createConvolveMatrixEdgeModeFromString(EDataType eDataType, String initialValue) {
		ConvolveMatrixEdgeMode result = ConvolveMatrixEdgeMode.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertConvolveMatrixEdgeModeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChannelSelector createChannelSelectorFromString(EDataType eDataType, String initialValue) {
		ChannelSelector result = ChannelSelector.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertChannelSelectorToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MorphologyOperator createMorphologyOperatorFromString(EDataType eDataType, String initialValue) {
		MorphologyOperator result = MorphologyOperator.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMorphologyOperatorToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StitchTiles createStitchTilesFromString(EDataType eDataType, String initialValue) {
		StitchTiles result = StitchTiles.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertStitchTilesToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TurbulenceType createTurbulenceTypeFromString(EDataType eDataType, String initialValue) {
		TurbulenceType result = TurbulenceType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTurbulenceTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createLengthFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLengthToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createAngleFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAngleToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createPercentageFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPercentageToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createShapeFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertShapeToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createFunciriFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertFunciriToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createColorFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertColorToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createPaintFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPaintToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createOpacity_valueFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertOpacity_valueToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createBaseline_shiftFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertBaseline_shiftToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createClipFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertClipToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createClip_pathFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertClip_pathToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createColor_profileFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertColor_profileToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createCursorFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCursorToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createEnable_backgroundFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEnable_backgroundToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createFillFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertFillToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createFill_opacityFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertFill_opacityToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createFilterFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertFilterToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createFlood_colorFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertFlood_colorToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createFlood_opacityFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertFlood_opacityToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createFont_familyFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertFont_familyToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createFont_sizeFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertFont_sizeToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createFont_size_adjustFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertFont_size_adjustToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createGlyph_orientation_horizontalFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertGlyph_orientation_horizontalToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createGlyph_orientation_verticalFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertGlyph_orientation_verticalToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createKerningFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertKerningToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createLetter_spacingFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLetter_spacingToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createLighting_colorFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLighting_colorToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createMarker_endFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMarker_endToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createMarker_midFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMarker_midToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createMarker_startFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMarker_startToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createMasksFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMasksToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createOpacityFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertOpacityToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createStop_colorFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertStop_colorToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createStop_opacityFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertStop_opacityToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createStrokeFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertStrokeToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createStroke_dasharrayFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertStroke_dasharrayToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createStroke_dashoffsetFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertStroke_dashoffsetToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createStroke_miterlimitFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertStroke_miterlimitToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createStroke_opacityFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertStroke_opacityToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createStroke_widthFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertStroke_widthToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createText_decorationFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertText_decorationToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createWord_spacingFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertWord_spacingToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createCoordinateFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCoordinateToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createViewBoxFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertViewBoxToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createPreserveAspectRatioFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPreserveAspectRatioToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Double createNumberFromString(EDataType eDataType, String initialValue) {
		return (Double)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertNumberToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createTransformFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTransformToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createPathDataFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPathDataToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createListOfPointsFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertListOfPointsToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createListOfLengthsFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertListOfLengthsToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createListOfNumbersFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertListOfNumbersToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createListOfCoordinatesFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertListOfCoordinatesToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createNameFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertNameToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createNumberOptionalNumberFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertNumberOptionalNumberToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createTransformListFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTransformListToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SvgPackage getSvgPackage() {
		return (SvgPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SvgPackage getPackage() {
		return SvgPackage.eINSTANCE;
	}

} //SvgFactoryImpl
