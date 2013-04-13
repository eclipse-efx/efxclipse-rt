/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.fx.formats.svg.svg.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.fx.formats.svg.svg.*;
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

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.fx.formats.svg.svg.SvgPackage
 * @generated
 */
public class SvgAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static SvgPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SvgAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = SvgPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SvgSwitch<Adapter> modelSwitch =
		new SvgSwitch<Adapter>() {
			@Override
			public <T extends SvgElement> Adapter caseContentElement(ContentElement<T> object) {
				return createContentElementAdapter();
			}
			@Override
			public <T extends SvgElement> Adapter caseContainerElement(ContainerElement<T> object) {
				return createContainerElementAdapter();
			}
			@Override
			public Adapter caseStructuralElement(StructuralElement object) {
				return createStructuralElementAdapter();
			}
			@Override
			public Adapter caseSvgElement(SvgElement object) {
				return createSvgElementAdapter();
			}
			@Override
			public Adapter caseDescriptiveElement(DescriptiveElement object) {
				return createDescriptiveElementAdapter();
			}
			@Override
			public Adapter caseGraphicsElement(GraphicsElement object) {
				return createGraphicsElementAdapter();
			}
			@Override
			public Adapter caseGraphicsReferencingElement(GraphicsReferencingElement object) {
				return createGraphicsReferencingElementAdapter();
			}
			@Override
			public Adapter caseShapeElement(ShapeElement object) {
				return createShapeElementAdapter();
			}
			@Override
			public Adapter caseBasicShapeElement(BasicShapeElement object) {
				return createBasicShapeElementAdapter();
			}
			@Override
			public Adapter caseTextContentElement(TextContentElement object) {
				return createTextContentElementAdapter();
			}
			@Override
			public Adapter caseTextContentChildElement(TextContentChildElement object) {
				return createTextContentChildElementAdapter();
			}
			@Override
			public Adapter caseGradientElement(GradientElement object) {
				return createGradientElementAdapter();
			}
			@Override
			public Adapter caseLightSourceElement(LightSourceElement object) {
				return createLightSourceElementAdapter();
			}
			@Override
			public Adapter caseFilterPrimitiveElement(FilterPrimitiveElement object) {
				return createFilterPrimitiveElementAdapter();
			}
			@Override
			public Adapter caseAnimationElement(AnimationElement object) {
				return createAnimationElementAdapter();
			}
			@Override
			public Adapter case____ENUMS____(____ENUMS____ object) {
				return create____ENUMS____Adapter();
			}
			@Override
			public Adapter case____DATATYPES____(____DATATYPES____ object) {
				return create____DATATYPES____Adapter();
			}
			@Override
			public Adapter case____ATTRIBUTES____(____ATTRIBUTES____ object) {
				return create____ATTRIBUTES____Adapter();
			}
			@Override
			public Adapter caseConditionalProcessingAttributes(ConditionalProcessingAttributes object) {
				return createConditionalProcessingAttributesAdapter();
			}
			@Override
			public Adapter caseCoreAttributes(CoreAttributes object) {
				return createCoreAttributesAdapter();
			}
			@Override
			public Adapter caseDocumentEventAttributes(DocumentEventAttributes object) {
				return createDocumentEventAttributesAdapter();
			}
			@Override
			public Adapter caseGraphicalEventAttributes(GraphicalEventAttributes object) {
				return createGraphicalEventAttributesAdapter();
			}
			@Override
			public Adapter casePresentationAttributes(PresentationAttributes object) {
				return createPresentationAttributesAdapter();
			}
			@Override
			public Adapter caseXLinkAttributes(XLinkAttributes object) {
				return createXLinkAttributesAdapter();
			}
			@Override
			public Adapter caseFilterPrimitiveAttributes(FilterPrimitiveAttributes object) {
				return createFilterPrimitiveAttributesAdapter();
			}
			@Override
			public Adapter case____ELEMENTES____(____ELEMENTES____ object) {
				return create____ELEMENTES____Adapter();
			}
			@Override
			public Adapter caseSvgSvgElement(SvgSvgElement object) {
				return createSvgSvgElementAdapter();
			}
			@Override
			public Adapter caseSvgGElement(SvgGElement object) {
				return createSvgGElementAdapter();
			}
			@Override
			public Adapter caseSvgDefsElement(SvgDefsElement object) {
				return createSvgDefsElementAdapter();
			}
			@Override
			public Adapter caseSvgDescElement(SvgDescElement object) {
				return createSvgDescElementAdapter();
			}
			@Override
			public Adapter caseSvgTitleElement(SvgTitleElement object) {
				return createSvgTitleElementAdapter();
			}
			@Override
			public Adapter caseSvgSymbolElement(SvgSymbolElement object) {
				return createSvgSymbolElementAdapter();
			}
			@Override
			public Adapter caseSvgUseElement(SvgUseElement object) {
				return createSvgUseElementAdapter();
			}
			@Override
			public Adapter caseSvgImageElement(SvgImageElement object) {
				return createSvgImageElementAdapter();
			}
			@Override
			public Adapter caseSvgSwitchElement(SvgSwitchElement object) {
				return createSvgSwitchElementAdapter();
			}
			@Override
			public Adapter caseSvgPathElement(SvgPathElement object) {
				return createSvgPathElementAdapter();
			}
			@Override
			public Adapter caseSvgRectElement(SvgRectElement object) {
				return createSvgRectElementAdapter();
			}
			@Override
			public Adapter caseSvgCircleElement(SvgCircleElement object) {
				return createSvgCircleElementAdapter();
			}
			@Override
			public Adapter caseSvgEllipseElement(SvgEllipseElement object) {
				return createSvgEllipseElementAdapter();
			}
			@Override
			public Adapter caseSvgLineElement(SvgLineElement object) {
				return createSvgLineElementAdapter();
			}
			@Override
			public Adapter caseSvgPolylineElement(SvgPolylineElement object) {
				return createSvgPolylineElementAdapter();
			}
			@Override
			public Adapter caseSvgPolygonElement(SvgPolygonElement object) {
				return createSvgPolygonElementAdapter();
			}
			@Override
			public Adapter caseSvgTextElement(SvgTextElement object) {
				return createSvgTextElementAdapter();
			}
			@Override
			public Adapter caseSvgTspanElement(SvgTspanElement object) {
				return createSvgTspanElementAdapter();
			}
			@Override
			public Adapter caseSvgTrefElement(SvgTrefElement object) {
				return createSvgTrefElementAdapter();
			}
			@Override
			public Adapter caseSvgTextPathElement(SvgTextPathElement object) {
				return createSvgTextPathElementAdapter();
			}
			@Override
			public Adapter caseSvgAltGlyphElement(SvgAltGlyphElement object) {
				return createSvgAltGlyphElementAdapter();
			}
			@Override
			public Adapter caseSvgAltGlyphDefElement(SvgAltGlyphDefElement object) {
				return createSvgAltGlyphDefElementAdapter();
			}
			@Override
			public Adapter caseSvgAltGlyphItemElement(SvgAltGlyphItemElement object) {
				return createSvgAltGlyphItemElementAdapter();
			}
			@Override
			public Adapter caseSvgAltGlyphRefElement(SvgAltGlyphRefElement object) {
				return createSvgAltGlyphRefElementAdapter();
			}
			@Override
			public Adapter caseSvgMarkerElement(SvgMarkerElement object) {
				return createSvgMarkerElementAdapter();
			}
			@Override
			public Adapter caseSvgColorProfileElement(SvgColorProfileElement object) {
				return createSvgColorProfileElementAdapter();
			}
			@Override
			public Adapter caseSvgLinearGradientElement(SvgLinearGradientElement object) {
				return createSvgLinearGradientElementAdapter();
			}
			@Override
			public Adapter caseSvgRadialGradientElement(SvgRadialGradientElement object) {
				return createSvgRadialGradientElementAdapter();
			}
			@Override
			public Adapter caseSvgStopElement(SvgStopElement object) {
				return createSvgStopElementAdapter();
			}
			@Override
			public Adapter caseSvgPatternElement(SvgPatternElement object) {
				return createSvgPatternElementAdapter();
			}
			@Override
			public Adapter caseSvgClipPathElement(SvgClipPathElement object) {
				return createSvgClipPathElementAdapter();
			}
			@Override
			public Adapter caseSvgMaskElement(SvgMaskElement object) {
				return createSvgMaskElementAdapter();
			}
			@Override
			public Adapter caseSvgFilterElement(SvgFilterElement object) {
				return createSvgFilterElementAdapter();
			}
			@Override
			public Adapter caseSvgFeDistantLightElement(SvgFeDistantLightElement object) {
				return createSvgFeDistantLightElementAdapter();
			}
			@Override
			public Adapter caseSvgFePointLightElement(SvgFePointLightElement object) {
				return createSvgFePointLightElementAdapter();
			}
			@Override
			public Adapter caseSvgFeSpotLightElement(SvgFeSpotLightElement object) {
				return createSvgFeSpotLightElementAdapter();
			}
			@Override
			public Adapter caseSvgFeBlendElement(SvgFeBlendElement object) {
				return createSvgFeBlendElementAdapter();
			}
			@Override
			public Adapter caseSvgFeColorMatrixElement(SvgFeColorMatrixElement object) {
				return createSvgFeColorMatrixElementAdapter();
			}
			@Override
			public Adapter caseSvgFeComponentTransferElement(SvgFeComponentTransferElement object) {
				return createSvgFeComponentTransferElementAdapter();
			}
			@Override
			public Adapter caseSvgFeFuncRElement(SvgFeFuncRElement object) {
				return createSvgFeFuncRElementAdapter();
			}
			@Override
			public Adapter caseSvgFeFuncGElement(SvgFeFuncGElement object) {
				return createSvgFeFuncGElementAdapter();
			}
			@Override
			public Adapter caseSvgFeFuncBElement(SvgFeFuncBElement object) {
				return createSvgFeFuncBElementAdapter();
			}
			@Override
			public Adapter caseSvgFeFuncAElement(SvgFeFuncAElement object) {
				return createSvgFeFuncAElementAdapter();
			}
			@Override
			public Adapter caseSvgFeCompositeElement(SvgFeCompositeElement object) {
				return createSvgFeCompositeElementAdapter();
			}
			@Override
			public Adapter caseSvgFeConvolveMatrixElement(SvgFeConvolveMatrixElement object) {
				return createSvgFeConvolveMatrixElementAdapter();
			}
			@Override
			public Adapter caseSvgFeDiffuseLightingElement(SvgFeDiffuseLightingElement object) {
				return createSvgFeDiffuseLightingElementAdapter();
			}
			@Override
			public Adapter caseSvgFeDisplacementMapElement(SvgFeDisplacementMapElement object) {
				return createSvgFeDisplacementMapElementAdapter();
			}
			@Override
			public Adapter caseSvgFeFloodElement(SvgFeFloodElement object) {
				return createSvgFeFloodElementAdapter();
			}
			@Override
			public Adapter caseSvgFeGaussianBlurElement(SvgFeGaussianBlurElement object) {
				return createSvgFeGaussianBlurElementAdapter();
			}
			@Override
			public Adapter caseSvgFeImageElement(SvgFeImageElement object) {
				return createSvgFeImageElementAdapter();
			}
			@Override
			public Adapter caseSvgFeMergeElement(SvgFeMergeElement object) {
				return createSvgFeMergeElementAdapter();
			}
			@Override
			public Adapter caseSvgFeMergeNodeElement(SvgFeMergeNodeElement object) {
				return createSvgFeMergeNodeElementAdapter();
			}
			@Override
			public Adapter caseSvgFeMorphologyElement(SvgFeMorphologyElement object) {
				return createSvgFeMorphologyElementAdapter();
			}
			@Override
			public Adapter caseSvgFeOffsetElement(SvgFeOffsetElement object) {
				return createSvgFeOffsetElementAdapter();
			}
			@Override
			public Adapter caseSvgFeSpecularLightingElement(SvgFeSpecularLightingElement object) {
				return createSvgFeSpecularLightingElementAdapter();
			}
			@Override
			public Adapter caseSvgFeTileElement(SvgFeTileElement object) {
				return createSvgFeTileElementAdapter();
			}
			@Override
			public Adapter caseSvgFeTurbulenceElement(SvgFeTurbulenceElement object) {
				return createSvgFeTurbulenceElementAdapter();
			}
			@Override
			public Adapter caseSvgAnimateElement(SvgAnimateElement object) {
				return createSvgAnimateElementAdapter();
			}
			@Override
			public Adapter caseSvgMetadataElement(SvgMetadataElement object) {
				return createSvgMetadataElementAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.fx.formats.svg.svg.ContentElement <em>Content Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.fx.formats.svg.svg.ContentElement
	 * @generated
	 */
	public Adapter createContentElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.fx.formats.svg.svg.ContainerElement <em>Container Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.fx.formats.svg.svg.ContainerElement
	 * @generated
	 */
	public Adapter createContainerElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.fx.formats.svg.svg.StructuralElement <em>Structural Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.fx.formats.svg.svg.StructuralElement
	 * @generated
	 */
	public Adapter createStructuralElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.fx.formats.svg.svg.SvgElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.fx.formats.svg.svg.SvgElement
	 * @generated
	 */
	public Adapter createSvgElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.fx.formats.svg.svg.DescriptiveElement <em>Descriptive Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.fx.formats.svg.svg.DescriptiveElement
	 * @generated
	 */
	public Adapter createDescriptiveElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.fx.formats.svg.svg.GraphicsElement <em>Graphics Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.fx.formats.svg.svg.GraphicsElement
	 * @generated
	 */
	public Adapter createGraphicsElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.fx.formats.svg.svg.GraphicsReferencingElement <em>Graphics Referencing Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.fx.formats.svg.svg.GraphicsReferencingElement
	 * @generated
	 */
	public Adapter createGraphicsReferencingElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.fx.formats.svg.svg.ShapeElement <em>Shape Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.fx.formats.svg.svg.ShapeElement
	 * @generated
	 */
	public Adapter createShapeElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.fx.formats.svg.svg.BasicShapeElement <em>Basic Shape Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.fx.formats.svg.svg.BasicShapeElement
	 * @generated
	 */
	public Adapter createBasicShapeElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.fx.formats.svg.svg.TextContentElement <em>Text Content Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.fx.formats.svg.svg.TextContentElement
	 * @generated
	 */
	public Adapter createTextContentElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.fx.formats.svg.svg.TextContentChildElement <em>Text Content Child Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.fx.formats.svg.svg.TextContentChildElement
	 * @generated
	 */
	public Adapter createTextContentChildElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.fx.formats.svg.svg.GradientElement <em>Gradient Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.fx.formats.svg.svg.GradientElement
	 * @generated
	 */
	public Adapter createGradientElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.fx.formats.svg.svg.LightSourceElement <em>Light Source Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.fx.formats.svg.svg.LightSourceElement
	 * @generated
	 */
	public Adapter createLightSourceElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.fx.formats.svg.svg.FilterPrimitiveElement <em>Filter Primitive Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.fx.formats.svg.svg.FilterPrimitiveElement
	 * @generated
	 */
	public Adapter createFilterPrimitiveElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.fx.formats.svg.svg.AnimationElement <em>Animation Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.fx.formats.svg.svg.AnimationElement
	 * @generated
	 */
	public Adapter createAnimationElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.fx.formats.svg.svg.____ENUMS____ <em>ENUMS </em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.fx.formats.svg.svg.____ENUMS____
	 * @generated
	 */
	public Adapter create____ENUMS____Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.fx.formats.svg.svg.____DATATYPES____ <em>DATATYPES </em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.fx.formats.svg.svg.____DATATYPES____
	 * @generated
	 */
	public Adapter create____DATATYPES____Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.fx.formats.svg.svg.____ATTRIBUTES____ <em>ATTRIBUTES </em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.fx.formats.svg.svg.____ATTRIBUTES____
	 * @generated
	 */
	public Adapter create____ATTRIBUTES____Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.fx.formats.svg.svg.ConditionalProcessingAttributes <em>Conditional Processing Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.fx.formats.svg.svg.ConditionalProcessingAttributes
	 * @generated
	 */
	public Adapter createConditionalProcessingAttributesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.fx.formats.svg.svg.CoreAttributes <em>Core Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.fx.formats.svg.svg.CoreAttributes
	 * @generated
	 */
	public Adapter createCoreAttributesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.fx.formats.svg.svg.DocumentEventAttributes <em>Document Event Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.fx.formats.svg.svg.DocumentEventAttributes
	 * @generated
	 */
	public Adapter createDocumentEventAttributesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.fx.formats.svg.svg.GraphicalEventAttributes <em>Graphical Event Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.fx.formats.svg.svg.GraphicalEventAttributes
	 * @generated
	 */
	public Adapter createGraphicalEventAttributesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes <em>Presentation Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.fx.formats.svg.svg.PresentationAttributes
	 * @generated
	 */
	public Adapter createPresentationAttributesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.fx.formats.svg.svg.XLinkAttributes <em>XLink Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.fx.formats.svg.svg.XLinkAttributes
	 * @generated
	 */
	public Adapter createXLinkAttributesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.fx.formats.svg.svg.FilterPrimitiveAttributes <em>Filter Primitive Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.fx.formats.svg.svg.FilterPrimitiveAttributes
	 * @generated
	 */
	public Adapter createFilterPrimitiveAttributesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.fx.formats.svg.svg.____ELEMENTES____ <em>ELEMENTES </em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.fx.formats.svg.svg.____ELEMENTES____
	 * @generated
	 */
	public Adapter create____ELEMENTES____Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.fx.formats.svg.svg.SvgSvgElement <em>Svg Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.fx.formats.svg.svg.SvgSvgElement
	 * @generated
	 */
	public Adapter createSvgSvgElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.fx.formats.svg.svg.SvgGElement <em>GElement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.fx.formats.svg.svg.SvgGElement
	 * @generated
	 */
	public Adapter createSvgGElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.fx.formats.svg.svg.SvgDefsElement <em>Defs Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.fx.formats.svg.svg.SvgDefsElement
	 * @generated
	 */
	public Adapter createSvgDefsElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.fx.formats.svg.svg.SvgDescElement <em>Desc Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.fx.formats.svg.svg.SvgDescElement
	 * @generated
	 */
	public Adapter createSvgDescElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.fx.formats.svg.svg.SvgTitleElement <em>Title Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.fx.formats.svg.svg.SvgTitleElement
	 * @generated
	 */
	public Adapter createSvgTitleElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.fx.formats.svg.svg.SvgSymbolElement <em>Symbol Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.fx.formats.svg.svg.SvgSymbolElement
	 * @generated
	 */
	public Adapter createSvgSymbolElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.fx.formats.svg.svg.SvgUseElement <em>Use Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.fx.formats.svg.svg.SvgUseElement
	 * @generated
	 */
	public Adapter createSvgUseElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.fx.formats.svg.svg.SvgImageElement <em>Image Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.fx.formats.svg.svg.SvgImageElement
	 * @generated
	 */
	public Adapter createSvgImageElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.fx.formats.svg.svg.SvgSwitchElement <em>Switch Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.fx.formats.svg.svg.SvgSwitchElement
	 * @generated
	 */
	public Adapter createSvgSwitchElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.fx.formats.svg.svg.SvgPathElement <em>Path Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.fx.formats.svg.svg.SvgPathElement
	 * @generated
	 */
	public Adapter createSvgPathElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.fx.formats.svg.svg.SvgRectElement <em>Rect Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.fx.formats.svg.svg.SvgRectElement
	 * @generated
	 */
	public Adapter createSvgRectElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.fx.formats.svg.svg.SvgCircleElement <em>Circle Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.fx.formats.svg.svg.SvgCircleElement
	 * @generated
	 */
	public Adapter createSvgCircleElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.fx.formats.svg.svg.SvgEllipseElement <em>Ellipse Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.fx.formats.svg.svg.SvgEllipseElement
	 * @generated
	 */
	public Adapter createSvgEllipseElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.fx.formats.svg.svg.SvgLineElement <em>Line Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.fx.formats.svg.svg.SvgLineElement
	 * @generated
	 */
	public Adapter createSvgLineElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.fx.formats.svg.svg.SvgPolylineElement <em>Polyline Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.fx.formats.svg.svg.SvgPolylineElement
	 * @generated
	 */
	public Adapter createSvgPolylineElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.fx.formats.svg.svg.SvgPolygonElement <em>Polygon Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.fx.formats.svg.svg.SvgPolygonElement
	 * @generated
	 */
	public Adapter createSvgPolygonElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.fx.formats.svg.svg.SvgTextElement <em>Text Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.fx.formats.svg.svg.SvgTextElement
	 * @generated
	 */
	public Adapter createSvgTextElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.fx.formats.svg.svg.SvgTspanElement <em>Tspan Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.fx.formats.svg.svg.SvgTspanElement
	 * @generated
	 */
	public Adapter createSvgTspanElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.fx.formats.svg.svg.SvgTrefElement <em>Tref Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.fx.formats.svg.svg.SvgTrefElement
	 * @generated
	 */
	public Adapter createSvgTrefElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.fx.formats.svg.svg.SvgTextPathElement <em>Text Path Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.fx.formats.svg.svg.SvgTextPathElement
	 * @generated
	 */
	public Adapter createSvgTextPathElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.fx.formats.svg.svg.SvgAltGlyphElement <em>Alt Glyph Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.fx.formats.svg.svg.SvgAltGlyphElement
	 * @generated
	 */
	public Adapter createSvgAltGlyphElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.fx.formats.svg.svg.SvgAltGlyphDefElement <em>Alt Glyph Def Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.fx.formats.svg.svg.SvgAltGlyphDefElement
	 * @generated
	 */
	public Adapter createSvgAltGlyphDefElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.fx.formats.svg.svg.SvgAltGlyphItemElement <em>Alt Glyph Item Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.fx.formats.svg.svg.SvgAltGlyphItemElement
	 * @generated
	 */
	public Adapter createSvgAltGlyphItemElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.fx.formats.svg.svg.SvgAltGlyphRefElement <em>Alt Glyph Ref Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.fx.formats.svg.svg.SvgAltGlyphRefElement
	 * @generated
	 */
	public Adapter createSvgAltGlyphRefElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.fx.formats.svg.svg.SvgMarkerElement <em>Marker Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.fx.formats.svg.svg.SvgMarkerElement
	 * @generated
	 */
	public Adapter createSvgMarkerElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.fx.formats.svg.svg.SvgColorProfileElement <em>Color Profile Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.fx.formats.svg.svg.SvgColorProfileElement
	 * @generated
	 */
	public Adapter createSvgColorProfileElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.fx.formats.svg.svg.SvgLinearGradientElement <em>Linear Gradient Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.fx.formats.svg.svg.SvgLinearGradientElement
	 * @generated
	 */
	public Adapter createSvgLinearGradientElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.fx.formats.svg.svg.SvgRadialGradientElement <em>Radial Gradient Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.fx.formats.svg.svg.SvgRadialGradientElement
	 * @generated
	 */
	public Adapter createSvgRadialGradientElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.fx.formats.svg.svg.SvgStopElement <em>Stop Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.fx.formats.svg.svg.SvgStopElement
	 * @generated
	 */
	public Adapter createSvgStopElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.fx.formats.svg.svg.SvgPatternElement <em>Pattern Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.fx.formats.svg.svg.SvgPatternElement
	 * @generated
	 */
	public Adapter createSvgPatternElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.fx.formats.svg.svg.SvgClipPathElement <em>Clip Path Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.fx.formats.svg.svg.SvgClipPathElement
	 * @generated
	 */
	public Adapter createSvgClipPathElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.fx.formats.svg.svg.SvgMaskElement <em>Mask Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.fx.formats.svg.svg.SvgMaskElement
	 * @generated
	 */
	public Adapter createSvgMaskElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.fx.formats.svg.svg.SvgFilterElement <em>Filter Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.fx.formats.svg.svg.SvgFilterElement
	 * @generated
	 */
	public Adapter createSvgFilterElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.fx.formats.svg.svg.SvgFeDistantLightElement <em>Fe Distant Light Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.fx.formats.svg.svg.SvgFeDistantLightElement
	 * @generated
	 */
	public Adapter createSvgFeDistantLightElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.fx.formats.svg.svg.SvgFePointLightElement <em>Fe Point Light Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.fx.formats.svg.svg.SvgFePointLightElement
	 * @generated
	 */
	public Adapter createSvgFePointLightElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.fx.formats.svg.svg.SvgFeSpotLightElement <em>Fe Spot Light Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.fx.formats.svg.svg.SvgFeSpotLightElement
	 * @generated
	 */
	public Adapter createSvgFeSpotLightElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.fx.formats.svg.svg.SvgFeBlendElement <em>Fe Blend Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.fx.formats.svg.svg.SvgFeBlendElement
	 * @generated
	 */
	public Adapter createSvgFeBlendElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.fx.formats.svg.svg.SvgFeColorMatrixElement <em>Fe Color Matrix Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.fx.formats.svg.svg.SvgFeColorMatrixElement
	 * @generated
	 */
	public Adapter createSvgFeColorMatrixElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.fx.formats.svg.svg.SvgFeComponentTransferElement <em>Fe Component Transfer Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.fx.formats.svg.svg.SvgFeComponentTransferElement
	 * @generated
	 */
	public Adapter createSvgFeComponentTransferElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.fx.formats.svg.svg.SvgFeFuncRElement <em>Fe Func RElement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.fx.formats.svg.svg.SvgFeFuncRElement
	 * @generated
	 */
	public Adapter createSvgFeFuncRElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.fx.formats.svg.svg.SvgFeFuncGElement <em>Fe Func GElement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.fx.formats.svg.svg.SvgFeFuncGElement
	 * @generated
	 */
	public Adapter createSvgFeFuncGElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.fx.formats.svg.svg.SvgFeFuncBElement <em>Fe Func BElement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.fx.formats.svg.svg.SvgFeFuncBElement
	 * @generated
	 */
	public Adapter createSvgFeFuncBElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.fx.formats.svg.svg.SvgFeFuncAElement <em>Fe Func AElement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.fx.formats.svg.svg.SvgFeFuncAElement
	 * @generated
	 */
	public Adapter createSvgFeFuncAElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.fx.formats.svg.svg.SvgFeCompositeElement <em>Fe Composite Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.fx.formats.svg.svg.SvgFeCompositeElement
	 * @generated
	 */
	public Adapter createSvgFeCompositeElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.fx.formats.svg.svg.SvgFeConvolveMatrixElement <em>Fe Convolve Matrix Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.fx.formats.svg.svg.SvgFeConvolveMatrixElement
	 * @generated
	 */
	public Adapter createSvgFeConvolveMatrixElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.fx.formats.svg.svg.SvgFeDiffuseLightingElement <em>Fe Diffuse Lighting Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.fx.formats.svg.svg.SvgFeDiffuseLightingElement
	 * @generated
	 */
	public Adapter createSvgFeDiffuseLightingElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.fx.formats.svg.svg.SvgFeDisplacementMapElement <em>Fe Displacement Map Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.fx.formats.svg.svg.SvgFeDisplacementMapElement
	 * @generated
	 */
	public Adapter createSvgFeDisplacementMapElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.fx.formats.svg.svg.SvgFeFloodElement <em>Fe Flood Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.fx.formats.svg.svg.SvgFeFloodElement
	 * @generated
	 */
	public Adapter createSvgFeFloodElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.fx.formats.svg.svg.SvgFeGaussianBlurElement <em>Fe Gaussian Blur Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.fx.formats.svg.svg.SvgFeGaussianBlurElement
	 * @generated
	 */
	public Adapter createSvgFeGaussianBlurElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.fx.formats.svg.svg.SvgFeImageElement <em>Fe Image Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.fx.formats.svg.svg.SvgFeImageElement
	 * @generated
	 */
	public Adapter createSvgFeImageElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.fx.formats.svg.svg.SvgFeMergeElement <em>Fe Merge Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.fx.formats.svg.svg.SvgFeMergeElement
	 * @generated
	 */
	public Adapter createSvgFeMergeElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.fx.formats.svg.svg.SvgFeMergeNodeElement <em>Fe Merge Node Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.fx.formats.svg.svg.SvgFeMergeNodeElement
	 * @generated
	 */
	public Adapter createSvgFeMergeNodeElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.fx.formats.svg.svg.SvgFeMorphologyElement <em>Fe Morphology Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.fx.formats.svg.svg.SvgFeMorphologyElement
	 * @generated
	 */
	public Adapter createSvgFeMorphologyElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.fx.formats.svg.svg.SvgFeOffsetElement <em>Fe Offset Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.fx.formats.svg.svg.SvgFeOffsetElement
	 * @generated
	 */
	public Adapter createSvgFeOffsetElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.fx.formats.svg.svg.SvgFeSpecularLightingElement <em>Fe Specular Lighting Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.fx.formats.svg.svg.SvgFeSpecularLightingElement
	 * @generated
	 */
	public Adapter createSvgFeSpecularLightingElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.fx.formats.svg.svg.SvgFeTileElement <em>Fe Tile Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.fx.formats.svg.svg.SvgFeTileElement
	 * @generated
	 */
	public Adapter createSvgFeTileElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.fx.formats.svg.svg.SvgFeTurbulenceElement <em>Fe Turbulence Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.fx.formats.svg.svg.SvgFeTurbulenceElement
	 * @generated
	 */
	public Adapter createSvgFeTurbulenceElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.fx.formats.svg.svg.SvgAnimateElement <em>Animate Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.fx.formats.svg.svg.SvgAnimateElement
	 * @generated
	 */
	public Adapter createSvgAnimateElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.fx.formats.svg.svg.SvgMetadataElement <em>Metadata Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.fx.formats.svg.svg.SvgMetadataElement
	 * @generated
	 */
	public Adapter createSvgMetadataElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //SvgAdapterFactory
