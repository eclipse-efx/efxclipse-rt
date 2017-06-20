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
package org.eclipse.fx.formats.svg.svg;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Presentation Attributes</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getAlignment_baseline <em>Alignment baseline</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getBaseline_shift <em>Baseline shift</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getClip <em>Clip</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getClip_path <em>Clip path</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getClip_rule <em>Clip rule</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getColor <em>Color</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getColor_interpolation <em>Color interpolation</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getColor_interpolation_filters <em>Color interpolation filters</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getColor_profile <em>Color profile</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getColor_rendering <em>Color rendering</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getCursor <em>Cursor</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getDirection <em>Direction</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getDisplay <em>Display</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getDominant_baseline <em>Dominant baseline</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getEnable_background <em>Enable background</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getFill <em>Fill</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getFill_opacity <em>Fill opacity</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getFill_rule <em>Fill rule</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getFilter <em>Filter</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getFlood_color <em>Flood color</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getFlood_opacity <em>Flood opacity</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getFont_family <em>Font family</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getFont_size <em>Font size</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getFont_size_adjust <em>Font size adjust</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getFont_stretch <em>Font stretch</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getFont_style <em>Font style</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getFont_variant <em>Font variant</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getFont_weight <em>Font weight</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getGlyph_orientation_horizontal <em>Glyph orientation horizontal</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getGlyph_orientation_vertical <em>Glyph orientation vertical</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getImage_rendering <em>Image rendering</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getKerning <em>Kerning</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getLetter_spacing <em>Letter spacing</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getLighting_color <em>Lighting color</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getMarker_end <em>Marker end</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getMarker_mid <em>Marker mid</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getMarker_start <em>Marker start</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getMasks <em>Masks</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getOpacity <em>Opacity</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getOverflow <em>Overflow</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getPointer_events <em>Pointer events</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getShape_rendering <em>Shape rendering</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getStop_color <em>Stop color</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getStop_opacity <em>Stop opacity</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getStroke <em>Stroke</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getStroke_dasharray <em>Stroke dasharray</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getStroke_dashoffset <em>Stroke dashoffset</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getStroke_linecap <em>Stroke linecap</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getStroke_linejoin <em>Stroke linejoin</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getStroke_miterlimit <em>Stroke miterlimit</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getStroke_opacity <em>Stroke opacity</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getStroke_width <em>Stroke width</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getText_anchor <em>Text anchor</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getText_decoration <em>Text decoration</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getText_rendering <em>Text rendering</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getUnicode_bidi <em>Unicode bidi</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getWord_spacing <em>Word spacing</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getWriting_mode <em>Writing mode</em>}</li>
 * </ul>
 *
 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getPresentationAttributes()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface PresentationAttributes extends EObject {
	/**
	 * Returns the value of the '<em><b>Alignment baseline</b></em>' attribute.
	 * The default value is <code>"alignment_baseline.auto"</code>.
	 * The literals are from the enumeration {@link org.eclipse.fx.formats.svg.svg.Alignment_baseline}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Alignment baseline</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Alignment baseline</em>' attribute.
	 * @see org.eclipse.fx.formats.svg.svg.Alignment_baseline
	 * @see #setAlignment_baseline(Alignment_baseline)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getPresentationAttributes_Alignment_baseline()
	 * @model default="alignment_baseline.auto"
	 * @generated
	 */
	Alignment_baseline getAlignment_baseline();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getAlignment_baseline <em>Alignment baseline</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Alignment baseline</em>' attribute.
	 * @see org.eclipse.fx.formats.svg.svg.Alignment_baseline
	 * @see #getAlignment_baseline()
	 * @generated
	 */
	void setAlignment_baseline(Alignment_baseline value);

	/**
	 * Returns the value of the '<em><b>Baseline shift</b></em>' attribute.
	 * The default value is <code>"\"baseline\""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Baseline shift</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Baseline shift</em>' attribute.
	 * @see #setBaseline_shift(String)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getPresentationAttributes_Baseline_shift()
	 * @model default="\"baseline\"" dataType="org.eclipse.fx.formats.svg.svg.Baseline_shift"
	 * @generated
	 */
	String getBaseline_shift();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getBaseline_shift <em>Baseline shift</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Baseline shift</em>' attribute.
	 * @see #getBaseline_shift()
	 * @generated
	 */
	void setBaseline_shift(String value);

	/**
	 * Returns the value of the '<em><b>Clip</b></em>' attribute.
	 * The default value is <code>"auto"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Clip</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Clip</em>' attribute.
	 * @see #setClip(String)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getPresentationAttributes_Clip()
	 * @model default="auto" dataType="org.eclipse.fx.formats.svg.svg.Clip"
	 * @generated
	 */
	String getClip();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getClip <em>Clip</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Clip</em>' attribute.
	 * @see #getClip()
	 * @generated
	 */
	void setClip(String value);

	/**
	 * Returns the value of the '<em><b>Clip path</b></em>' attribute.
	 * The default value is <code>"none"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Clip path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Clip path</em>' attribute.
	 * @see #setClip_path(String)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getPresentationAttributes_Clip_path()
	 * @model default="none" dataType="org.eclipse.fx.formats.svg.svg.Clip_path"
	 * @generated
	 */
	String getClip_path();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getClip_path <em>Clip path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Clip path</em>' attribute.
	 * @see #getClip_path()
	 * @generated
	 */
	void setClip_path(String value);

	/**
	 * Returns the value of the '<em><b>Clip rule</b></em>' attribute.
	 * The default value is <code>"clip_rule.nonzero"</code>.
	 * The literals are from the enumeration {@link org.eclipse.fx.formats.svg.svg.Clip_rule}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Clip rule</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Clip rule</em>' attribute.
	 * @see org.eclipse.fx.formats.svg.svg.Clip_rule
	 * @see #setClip_rule(Clip_rule)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getPresentationAttributes_Clip_rule()
	 * @model default="clip_rule.nonzero"
	 * @generated
	 */
	Clip_rule getClip_rule();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getClip_rule <em>Clip rule</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Clip rule</em>' attribute.
	 * @see org.eclipse.fx.formats.svg.svg.Clip_rule
	 * @see #getClip_rule()
	 * @generated
	 */
	void setClip_rule(Clip_rule value);

	/**
	 * Returns the value of the '<em><b>Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Color</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Color</em>' attribute.
	 * @see #setColor(String)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getPresentationAttributes_Color()
	 * @model dataType="org.eclipse.fx.formats.svg.svg.Color"
	 * @generated
	 */
	String getColor();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getColor <em>Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Color</em>' attribute.
	 * @see #getColor()
	 * @generated
	 */
	void setColor(String value);

	/**
	 * Returns the value of the '<em><b>Color interpolation</b></em>' attribute.
	 * The default value is <code>"color_interpolation.sRGB"</code>.
	 * The literals are from the enumeration {@link org.eclipse.fx.formats.svg.svg.Color_interpolation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Color interpolation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Color interpolation</em>' attribute.
	 * @see org.eclipse.fx.formats.svg.svg.Color_interpolation
	 * @see #setColor_interpolation(Color_interpolation)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getPresentationAttributes_Color_interpolation()
	 * @model default="color_interpolation.sRGB"
	 * @generated
	 */
	Color_interpolation getColor_interpolation();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getColor_interpolation <em>Color interpolation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Color interpolation</em>' attribute.
	 * @see org.eclipse.fx.formats.svg.svg.Color_interpolation
	 * @see #getColor_interpolation()
	 * @generated
	 */
	void setColor_interpolation(Color_interpolation value);

	/**
	 * Returns the value of the '<em><b>Color interpolation filters</b></em>' attribute.
	 * The default value is <code>"color_interpolation_filters.linearRGB"</code>.
	 * The literals are from the enumeration {@link org.eclipse.fx.formats.svg.svg.Color_interpolation_filters}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Color interpolation filters</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Color interpolation filters</em>' attribute.
	 * @see org.eclipse.fx.formats.svg.svg.Color_interpolation_filters
	 * @see #setColor_interpolation_filters(Color_interpolation_filters)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getPresentationAttributes_Color_interpolation_filters()
	 * @model default="color_interpolation_filters.linearRGB"
	 * @generated
	 */
	Color_interpolation_filters getColor_interpolation_filters();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getColor_interpolation_filters <em>Color interpolation filters</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Color interpolation filters</em>' attribute.
	 * @see org.eclipse.fx.formats.svg.svg.Color_interpolation_filters
	 * @see #getColor_interpolation_filters()
	 * @generated
	 */
	void setColor_interpolation_filters(Color_interpolation_filters value);

	/**
	 * Returns the value of the '<em><b>Color profile</b></em>' attribute.
	 * The default value is <code>"\"auto\""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Color profile</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Color profile</em>' attribute.
	 * @see #setColor_profile(String)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getPresentationAttributes_Color_profile()
	 * @model default="\"auto\"" dataType="org.eclipse.fx.formats.svg.svg.Color_profile"
	 * @generated
	 */
	String getColor_profile();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getColor_profile <em>Color profile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Color profile</em>' attribute.
	 * @see #getColor_profile()
	 * @generated
	 */
	void setColor_profile(String value);

	/**
	 * Returns the value of the '<em><b>Color rendering</b></em>' attribute.
	 * The default value is <code>"\"auto\""</code>.
	 * The literals are from the enumeration {@link org.eclipse.fx.formats.svg.svg.Color_rendering}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Color rendering</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Color rendering</em>' attribute.
	 * @see org.eclipse.fx.formats.svg.svg.Color_rendering
	 * @see #setColor_rendering(Color_rendering)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getPresentationAttributes_Color_rendering()
	 * @model default="\"auto\""
	 * @generated
	 */
	Color_rendering getColor_rendering();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getColor_rendering <em>Color rendering</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Color rendering</em>' attribute.
	 * @see org.eclipse.fx.formats.svg.svg.Color_rendering
	 * @see #getColor_rendering()
	 * @generated
	 */
	void setColor_rendering(Color_rendering value);

	/**
	 * Returns the value of the '<em><b>Cursor</b></em>' attribute.
	 * The default value is <code>"\"auto\""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cursor</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cursor</em>' attribute.
	 * @see #setCursor(String)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getPresentationAttributes_Cursor()
	 * @model default="\"auto\"" dataType="org.eclipse.fx.formats.svg.svg.Cursor"
	 * @generated
	 */
	String getCursor();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getCursor <em>Cursor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cursor</em>' attribute.
	 * @see #getCursor()
	 * @generated
	 */
	void setCursor(String value);

	/**
	 * Returns the value of the '<em><b>Direction</b></em>' attribute.
	 * The default value is <code>"direction.ltr"</code>.
	 * The literals are from the enumeration {@link org.eclipse.fx.formats.svg.svg.Direction}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Direction</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Direction</em>' attribute.
	 * @see org.eclipse.fx.formats.svg.svg.Direction
	 * @see #setDirection(Direction)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getPresentationAttributes_Direction()
	 * @model default="direction.ltr"
	 * @generated
	 */
	Direction getDirection();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getDirection <em>Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Direction</em>' attribute.
	 * @see org.eclipse.fx.formats.svg.svg.Direction
	 * @see #getDirection()
	 * @generated
	 */
	void setDirection(Direction value);

	/**
	 * Returns the value of the '<em><b>Display</b></em>' attribute.
	 * The default value is <code>"display.inline"</code>.
	 * The literals are from the enumeration {@link org.eclipse.fx.formats.svg.svg.Display}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Display</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Display</em>' attribute.
	 * @see org.eclipse.fx.formats.svg.svg.Display
	 * @see #setDisplay(Display)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getPresentationAttributes_Display()
	 * @model default="display.inline"
	 * @generated
	 */
	Display getDisplay();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getDisplay <em>Display</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Display</em>' attribute.
	 * @see org.eclipse.fx.formats.svg.svg.Display
	 * @see #getDisplay()
	 * @generated
	 */
	void setDisplay(Display value);

	/**
	 * Returns the value of the '<em><b>Dominant baseline</b></em>' attribute.
	 * The default value is <code>"dominant_baseline.auto"</code>.
	 * The literals are from the enumeration {@link org.eclipse.fx.formats.svg.svg.Dominant_baseline}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dominant baseline</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dominant baseline</em>' attribute.
	 * @see org.eclipse.fx.formats.svg.svg.Dominant_baseline
	 * @see #setDominant_baseline(Dominant_baseline)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getPresentationAttributes_Dominant_baseline()
	 * @model default="dominant_baseline.auto"
	 * @generated
	 */
	Dominant_baseline getDominant_baseline();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getDominant_baseline <em>Dominant baseline</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dominant baseline</em>' attribute.
	 * @see org.eclipse.fx.formats.svg.svg.Dominant_baseline
	 * @see #getDominant_baseline()
	 * @generated
	 */
	void setDominant_baseline(Dominant_baseline value);

	/**
	 * Returns the value of the '<em><b>Enable background</b></em>' attribute.
	 * The default value is <code>"\"inherit\""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enable background</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enable background</em>' attribute.
	 * @see #setEnable_background(String)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getPresentationAttributes_Enable_background()
	 * @model default="\"inherit\"" dataType="org.eclipse.fx.formats.svg.svg.Enable_background"
	 * @generated
	 */
	String getEnable_background();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getEnable_background <em>Enable background</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enable background</em>' attribute.
	 * @see #getEnable_background()
	 * @generated
	 */
	void setEnable_background(String value);

	/**
	 * Returns the value of the '<em><b>Fill</b></em>' attribute.
	 * The default value is <code>"black"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fill</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fill</em>' attribute.
	 * @see #setFill(String)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getPresentationAttributes_Fill()
	 * @model default="black" dataType="org.eclipse.fx.formats.svg.svg.Fill"
	 * @generated
	 */
	String getFill();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getFill <em>Fill</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fill</em>' attribute.
	 * @see #getFill()
	 * @generated
	 */
	void setFill(String value);

	/**
	 * Returns the value of the '<em><b>Fill opacity</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fill opacity</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fill opacity</em>' attribute.
	 * @see #setFill_opacity(String)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getPresentationAttributes_Fill_opacity()
	 * @model default="1" dataType="org.eclipse.fx.formats.svg.svg.Fill_opacity"
	 * @generated
	 */
	String getFill_opacity();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getFill_opacity <em>Fill opacity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fill opacity</em>' attribute.
	 * @see #getFill_opacity()
	 * @generated
	 */
	void setFill_opacity(String value);

	/**
	 * Returns the value of the '<em><b>Fill rule</b></em>' attribute.
	 * The default value is <code>"fill_rule.nonzero"</code>.
	 * The literals are from the enumeration {@link org.eclipse.fx.formats.svg.svg.Fill_rule}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fill rule</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fill rule</em>' attribute.
	 * @see org.eclipse.fx.formats.svg.svg.Fill_rule
	 * @see #setFill_rule(Fill_rule)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getPresentationAttributes_Fill_rule()
	 * @model default="fill_rule.nonzero"
	 * @generated
	 */
	Fill_rule getFill_rule();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getFill_rule <em>Fill rule</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fill rule</em>' attribute.
	 * @see org.eclipse.fx.formats.svg.svg.Fill_rule
	 * @see #getFill_rule()
	 * @generated
	 */
	void setFill_rule(Fill_rule value);

	/**
	 * Returns the value of the '<em><b>Filter</b></em>' attribute.
	 * The default value is <code>"\"none\""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Filter</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Filter</em>' attribute.
	 * @see #setFilter(String)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getPresentationAttributes_Filter()
	 * @model default="\"none\"" dataType="org.eclipse.fx.formats.svg.svg.Filter"
	 * @generated
	 */
	String getFilter();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getFilter <em>Filter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Filter</em>' attribute.
	 * @see #getFilter()
	 * @generated
	 */
	void setFilter(String value);

	/**
	 * Returns the value of the '<em><b>Flood color</b></em>' attribute.
	 * The default value is <code>"\"black\""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Flood color</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Flood color</em>' attribute.
	 * @see #setFlood_color(String)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getPresentationAttributes_Flood_color()
	 * @model default="\"black\"" dataType="org.eclipse.fx.formats.svg.svg.Flood_color"
	 * @generated
	 */
	String getFlood_color();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getFlood_color <em>Flood color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Flood color</em>' attribute.
	 * @see #getFlood_color()
	 * @generated
	 */
	void setFlood_color(String value);

	/**
	 * Returns the value of the '<em><b>Flood opacity</b></em>' attribute.
	 * The default value is <code>"\"1\""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Flood opacity</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Flood opacity</em>' attribute.
	 * @see #setFlood_opacity(String)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getPresentationAttributes_Flood_opacity()
	 * @model default="\"1\"" dataType="org.eclipse.fx.formats.svg.svg.Flood_opacity"
	 * @generated
	 */
	String getFlood_opacity();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getFlood_opacity <em>Flood opacity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Flood opacity</em>' attribute.
	 * @see #getFlood_opacity()
	 * @generated
	 */
	void setFlood_opacity(String value);

	/**
	 * Returns the value of the '<em><b>Font family</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Font family</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Font family</em>' attribute.
	 * @see #setFont_family(String)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getPresentationAttributes_Font_family()
	 * @model dataType="org.eclipse.fx.formats.svg.svg.Font_family"
	 * @generated
	 */
	String getFont_family();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getFont_family <em>Font family</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Font family</em>' attribute.
	 * @see #getFont_family()
	 * @generated
	 */
	void setFont_family(String value);

	/**
	 * Returns the value of the '<em><b>Font size</b></em>' attribute.
	 * The default value is <code>"\"medium\""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Font size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Font size</em>' attribute.
	 * @see #setFont_size(String)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getPresentationAttributes_Font_size()
	 * @model default="\"medium\"" dataType="org.eclipse.fx.formats.svg.svg.Font_size"
	 * @generated
	 */
	String getFont_size();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getFont_size <em>Font size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Font size</em>' attribute.
	 * @see #getFont_size()
	 * @generated
	 */
	void setFont_size(String value);

	/**
	 * Returns the value of the '<em><b>Font size adjust</b></em>' attribute.
	 * The default value is <code>"\"none\""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Font size adjust</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Font size adjust</em>' attribute.
	 * @see #setFont_size_adjust(String)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getPresentationAttributes_Font_size_adjust()
	 * @model default="\"none\"" dataType="org.eclipse.fx.formats.svg.svg.Font_size_adjust"
	 * @generated
	 */
	String getFont_size_adjust();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getFont_size_adjust <em>Font size adjust</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Font size adjust</em>' attribute.
	 * @see #getFont_size_adjust()
	 * @generated
	 */
	void setFont_size_adjust(String value);

	/**
	 * Returns the value of the '<em><b>Font stretch</b></em>' attribute.
	 * The default value is <code>"font_stretch.none"</code>.
	 * The literals are from the enumeration {@link org.eclipse.fx.formats.svg.svg.Font_stretch}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Font stretch</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Font stretch</em>' attribute.
	 * @see org.eclipse.fx.formats.svg.svg.Font_stretch
	 * @see #setFont_stretch(Font_stretch)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getPresentationAttributes_Font_stretch()
	 * @model default="font_stretch.none"
	 * @generated
	 */
	Font_stretch getFont_stretch();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getFont_stretch <em>Font stretch</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Font stretch</em>' attribute.
	 * @see org.eclipse.fx.formats.svg.svg.Font_stretch
	 * @see #getFont_stretch()
	 * @generated
	 */
	void setFont_stretch(Font_stretch value);

	/**
	 * Returns the value of the '<em><b>Font style</b></em>' attribute.
	 * The default value is <code>"font_style.normal"</code>.
	 * The literals are from the enumeration {@link org.eclipse.fx.formats.svg.svg.Font_style}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Font style</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Font style</em>' attribute.
	 * @see org.eclipse.fx.formats.svg.svg.Font_style
	 * @see #setFont_style(Font_style)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getPresentationAttributes_Font_style()
	 * @model default="font_style.normal"
	 * @generated
	 */
	Font_style getFont_style();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getFont_style <em>Font style</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Font style</em>' attribute.
	 * @see org.eclipse.fx.formats.svg.svg.Font_style
	 * @see #getFont_style()
	 * @generated
	 */
	void setFont_style(Font_style value);

	/**
	 * Returns the value of the '<em><b>Font variant</b></em>' attribute.
	 * The default value is <code>"font_variant.normal"</code>.
	 * The literals are from the enumeration {@link org.eclipse.fx.formats.svg.svg.Font_variant}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Font variant</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Font variant</em>' attribute.
	 * @see org.eclipse.fx.formats.svg.svg.Font_variant
	 * @see #setFont_variant(Font_variant)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getPresentationAttributes_Font_variant()
	 * @model default="font_variant.normal"
	 * @generated
	 */
	Font_variant getFont_variant();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getFont_variant <em>Font variant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Font variant</em>' attribute.
	 * @see org.eclipse.fx.formats.svg.svg.Font_variant
	 * @see #getFont_variant()
	 * @generated
	 */
	void setFont_variant(Font_variant value);

	/**
	 * Returns the value of the '<em><b>Font weight</b></em>' attribute.
	 * The default value is <code>"font_weight.normal"</code>.
	 * The literals are from the enumeration {@link org.eclipse.fx.formats.svg.svg.Font_weight}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Font weight</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Font weight</em>' attribute.
	 * @see org.eclipse.fx.formats.svg.svg.Font_weight
	 * @see #setFont_weight(Font_weight)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getPresentationAttributes_Font_weight()
	 * @model default="font_weight.normal"
	 * @generated
	 */
	Font_weight getFont_weight();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getFont_weight <em>Font weight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Font weight</em>' attribute.
	 * @see org.eclipse.fx.formats.svg.svg.Font_weight
	 * @see #getFont_weight()
	 * @generated
	 */
	void setFont_weight(Font_weight value);

	/**
	 * Returns the value of the '<em><b>Glyph orientation horizontal</b></em>' attribute.
	 * The default value is <code>"\"0deg\""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Glyph orientation horizontal</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Glyph orientation horizontal</em>' attribute.
	 * @see #setGlyph_orientation_horizontal(String)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getPresentationAttributes_Glyph_orientation_horizontal()
	 * @model default="\"0deg\"" dataType="org.eclipse.fx.formats.svg.svg.Glyph_orientation_horizontal"
	 * @generated
	 */
	String getGlyph_orientation_horizontal();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getGlyph_orientation_horizontal <em>Glyph orientation horizontal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Glyph orientation horizontal</em>' attribute.
	 * @see #getGlyph_orientation_horizontal()
	 * @generated
	 */
	void setGlyph_orientation_horizontal(String value);

	/**
	 * Returns the value of the '<em><b>Glyph orientation vertical</b></em>' attribute.
	 * The default value is <code>"\"auto\""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Glyph orientation vertical</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Glyph orientation vertical</em>' attribute.
	 * @see #setGlyph_orientation_vertical(String)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getPresentationAttributes_Glyph_orientation_vertical()
	 * @model default="\"auto\"" dataType="org.eclipse.fx.formats.svg.svg.Glyph_orientation_vertical"
	 * @generated
	 */
	String getGlyph_orientation_vertical();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getGlyph_orientation_vertical <em>Glyph orientation vertical</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Glyph orientation vertical</em>' attribute.
	 * @see #getGlyph_orientation_vertical()
	 * @generated
	 */
	void setGlyph_orientation_vertical(String value);

	/**
	 * Returns the value of the '<em><b>Image rendering</b></em>' attribute.
	 * The default value is <code>"\"auto\""</code>.
	 * The literals are from the enumeration {@link org.eclipse.fx.formats.svg.svg.Image_rendering}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Image rendering</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Image rendering</em>' attribute.
	 * @see org.eclipse.fx.formats.svg.svg.Image_rendering
	 * @see #setImage_rendering(Image_rendering)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getPresentationAttributes_Image_rendering()
	 * @model default="\"auto\""
	 * @generated
	 */
	Image_rendering getImage_rendering();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getImage_rendering <em>Image rendering</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Image rendering</em>' attribute.
	 * @see org.eclipse.fx.formats.svg.svg.Image_rendering
	 * @see #getImage_rendering()
	 * @generated
	 */
	void setImage_rendering(Image_rendering value);

	/**
	 * Returns the value of the '<em><b>Kerning</b></em>' attribute.
	 * The default value is <code>"\"auto\""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kerning</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kerning</em>' attribute.
	 * @see #setKerning(String)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getPresentationAttributes_Kerning()
	 * @model default="\"auto\"" dataType="org.eclipse.fx.formats.svg.svg.Kerning"
	 * @generated
	 */
	String getKerning();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getKerning <em>Kerning</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kerning</em>' attribute.
	 * @see #getKerning()
	 * @generated
	 */
	void setKerning(String value);

	/**
	 * Returns the value of the '<em><b>Letter spacing</b></em>' attribute.
	 * The default value is <code>"\"normal\""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Letter spacing</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Letter spacing</em>' attribute.
	 * @see #setLetter_spacing(String)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getPresentationAttributes_Letter_spacing()
	 * @model default="\"normal\"" dataType="org.eclipse.fx.formats.svg.svg.Letter_spacing"
	 * @generated
	 */
	String getLetter_spacing();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getLetter_spacing <em>Letter spacing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Letter spacing</em>' attribute.
	 * @see #getLetter_spacing()
	 * @generated
	 */
	void setLetter_spacing(String value);

	/**
	 * Returns the value of the '<em><b>Lighting color</b></em>' attribute.
	 * The default value is <code>"\"white\""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lighting color</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lighting color</em>' attribute.
	 * @see #setLighting_color(String)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getPresentationAttributes_Lighting_color()
	 * @model default="\"white\"" dataType="org.eclipse.fx.formats.svg.svg.Lighting_color"
	 * @generated
	 */
	String getLighting_color();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getLighting_color <em>Lighting color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lighting color</em>' attribute.
	 * @see #getLighting_color()
	 * @generated
	 */
	void setLighting_color(String value);

	/**
	 * Returns the value of the '<em><b>Marker end</b></em>' attribute.
	 * The default value is <code>"\"none\""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Marker end</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Marker end</em>' attribute.
	 * @see #setMarker_end(String)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getPresentationAttributes_Marker_end()
	 * @model default="\"none\"" dataType="org.eclipse.fx.formats.svg.svg.Marker_end"
	 * @generated
	 */
	String getMarker_end();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getMarker_end <em>Marker end</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Marker end</em>' attribute.
	 * @see #getMarker_end()
	 * @generated
	 */
	void setMarker_end(String value);

	/**
	 * Returns the value of the '<em><b>Marker mid</b></em>' attribute.
	 * The default value is <code>"\"none\""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Marker mid</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Marker mid</em>' attribute.
	 * @see #setMarker_mid(String)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getPresentationAttributes_Marker_mid()
	 * @model default="\"none\"" dataType="org.eclipse.fx.formats.svg.svg.Marker_mid"
	 * @generated
	 */
	String getMarker_mid();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getMarker_mid <em>Marker mid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Marker mid</em>' attribute.
	 * @see #getMarker_mid()
	 * @generated
	 */
	void setMarker_mid(String value);

	/**
	 * Returns the value of the '<em><b>Marker start</b></em>' attribute.
	 * The default value is <code>"\"none\""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Marker start</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Marker start</em>' attribute.
	 * @see #setMarker_start(String)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getPresentationAttributes_Marker_start()
	 * @model default="\"none\"" dataType="org.eclipse.fx.formats.svg.svg.Marker_start"
	 * @generated
	 */
	String getMarker_start();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getMarker_start <em>Marker start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Marker start</em>' attribute.
	 * @see #getMarker_start()
	 * @generated
	 */
	void setMarker_start(String value);

	/**
	 * Returns the value of the '<em><b>Masks</b></em>' attribute.
	 * The default value is <code>"\"none\""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Masks</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Masks</em>' attribute.
	 * @see #setMasks(String)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getPresentationAttributes_Masks()
	 * @model default="\"none\"" dataType="org.eclipse.fx.formats.svg.svg.Masks"
	 * @generated
	 */
	String getMasks();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getMasks <em>Masks</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Masks</em>' attribute.
	 * @see #getMasks()
	 * @generated
	 */
	void setMasks(String value);

	/**
	 * Returns the value of the '<em><b>Opacity</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Opacity</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Opacity</em>' attribute.
	 * @see #setOpacity(String)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getPresentationAttributes_Opacity()
	 * @model default="1" dataType="org.eclipse.fx.formats.svg.svg.Opacity"
	 * @generated
	 */
	String getOpacity();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getOpacity <em>Opacity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Opacity</em>' attribute.
	 * @see #getOpacity()
	 * @generated
	 */
	void setOpacity(String value);

	/**
	 * Returns the value of the '<em><b>Overflow</b></em>' attribute.
	 * The default value is <code>"null"</code>.
	 * The literals are from the enumeration {@link org.eclipse.fx.formats.svg.svg.Overflow}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Overflow</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Overflow</em>' attribute.
	 * @see org.eclipse.fx.formats.svg.svg.Overflow
	 * @see #setOverflow(Overflow)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getPresentationAttributes_Overflow()
	 * @model default="null"
	 * @generated
	 */
	Overflow getOverflow();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getOverflow <em>Overflow</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Overflow</em>' attribute.
	 * @see org.eclipse.fx.formats.svg.svg.Overflow
	 * @see #getOverflow()
	 * @generated
	 */
	void setOverflow(Overflow value);

	/**
	 * Returns the value of the '<em><b>Pointer events</b></em>' attribute.
	 * The default value is <code>"pointer_events.visiblePainted"</code>.
	 * The literals are from the enumeration {@link org.eclipse.fx.formats.svg.svg.Pointer_events}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pointer events</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pointer events</em>' attribute.
	 * @see org.eclipse.fx.formats.svg.svg.Pointer_events
	 * @see #setPointer_events(Pointer_events)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getPresentationAttributes_Pointer_events()
	 * @model default="pointer_events.visiblePainted"
	 * @generated
	 */
	Pointer_events getPointer_events();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getPointer_events <em>Pointer events</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pointer events</em>' attribute.
	 * @see org.eclipse.fx.formats.svg.svg.Pointer_events
	 * @see #getPointer_events()
	 * @generated
	 */
	void setPointer_events(Pointer_events value);

	/**
	 * Returns the value of the '<em><b>Shape rendering</b></em>' attribute.
	 * The default value is <code>"shape_rendering.auto"</code>.
	 * The literals are from the enumeration {@link org.eclipse.fx.formats.svg.svg.Shape_rendering}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Shape rendering</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Shape rendering</em>' attribute.
	 * @see org.eclipse.fx.formats.svg.svg.Shape_rendering
	 * @see #setShape_rendering(Shape_rendering)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getPresentationAttributes_Shape_rendering()
	 * @model default="shape_rendering.auto"
	 * @generated
	 */
	Shape_rendering getShape_rendering();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getShape_rendering <em>Shape rendering</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Shape rendering</em>' attribute.
	 * @see org.eclipse.fx.formats.svg.svg.Shape_rendering
	 * @see #getShape_rendering()
	 * @generated
	 */
	void setShape_rendering(Shape_rendering value);

	/**
	 * Returns the value of the '<em><b>Stop color</b></em>' attribute.
	 * The default value is <code>"black"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stop color</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stop color</em>' attribute.
	 * @see #setStop_color(String)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getPresentationAttributes_Stop_color()
	 * @model default="black" dataType="org.eclipse.fx.formats.svg.svg.Stop_color"
	 * @generated
	 */
	String getStop_color();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getStop_color <em>Stop color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stop color</em>' attribute.
	 * @see #getStop_color()
	 * @generated
	 */
	void setStop_color(String value);

	/**
	 * Returns the value of the '<em><b>Stop opacity</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stop opacity</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stop opacity</em>' attribute.
	 * @see #setStop_opacity(String)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getPresentationAttributes_Stop_opacity()
	 * @model default="1" dataType="org.eclipse.fx.formats.svg.svg.Stop_opacity"
	 * @generated
	 */
	String getStop_opacity();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getStop_opacity <em>Stop opacity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stop opacity</em>' attribute.
	 * @see #getStop_opacity()
	 * @generated
	 */
	void setStop_opacity(String value);

	/**
	 * Returns the value of the '<em><b>Stroke</b></em>' attribute.
	 * The default value is <code>"none"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stroke</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stroke</em>' attribute.
	 * @see #setStroke(String)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getPresentationAttributes_Stroke()
	 * @model default="none" dataType="org.eclipse.fx.formats.svg.svg.Stroke"
	 * @generated
	 */
	String getStroke();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getStroke <em>Stroke</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stroke</em>' attribute.
	 * @see #getStroke()
	 * @generated
	 */
	void setStroke(String value);

	/**
	 * Returns the value of the '<em><b>Stroke dasharray</b></em>' attribute.
	 * The default value is <code>"none"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stroke dasharray</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stroke dasharray</em>' attribute.
	 * @see #setStroke_dasharray(String)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getPresentationAttributes_Stroke_dasharray()
	 * @model default="none" dataType="org.eclipse.fx.formats.svg.svg.Stroke_dasharray"
	 * @generated
	 */
	String getStroke_dasharray();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getStroke_dasharray <em>Stroke dasharray</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stroke dasharray</em>' attribute.
	 * @see #getStroke_dasharray()
	 * @generated
	 */
	void setStroke_dasharray(String value);

	/**
	 * Returns the value of the '<em><b>Stroke dashoffset</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stroke dashoffset</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stroke dashoffset</em>' attribute.
	 * @see #setStroke_dashoffset(String)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getPresentationAttributes_Stroke_dashoffset()
	 * @model default="0" dataType="org.eclipse.fx.formats.svg.svg.Stroke_dashoffset"
	 * @generated
	 */
	String getStroke_dashoffset();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getStroke_dashoffset <em>Stroke dashoffset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stroke dashoffset</em>' attribute.
	 * @see #getStroke_dashoffset()
	 * @generated
	 */
	void setStroke_dashoffset(String value);

	/**
	 * Returns the value of the '<em><b>Stroke linecap</b></em>' attribute.
	 * The default value is <code>"Stroke_linecap.butt"</code>.
	 * The literals are from the enumeration {@link org.eclipse.fx.formats.svg.svg.Stroke_linecap}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stroke linecap</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stroke linecap</em>' attribute.
	 * @see org.eclipse.fx.formats.svg.svg.Stroke_linecap
	 * @see #setStroke_linecap(Stroke_linecap)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getPresentationAttributes_Stroke_linecap()
	 * @model default="Stroke_linecap.butt"
	 * @generated
	 */
	Stroke_linecap getStroke_linecap();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getStroke_linecap <em>Stroke linecap</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stroke linecap</em>' attribute.
	 * @see org.eclipse.fx.formats.svg.svg.Stroke_linecap
	 * @see #getStroke_linecap()
	 * @generated
	 */
	void setStroke_linecap(Stroke_linecap value);

	/**
	 * Returns the value of the '<em><b>Stroke linejoin</b></em>' attribute.
	 * The default value is <code>"stroke_linejoin.miter"</code>.
	 * The literals are from the enumeration {@link org.eclipse.fx.formats.svg.svg.Stroke_linejoin}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stroke linejoin</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stroke linejoin</em>' attribute.
	 * @see org.eclipse.fx.formats.svg.svg.Stroke_linejoin
	 * @see #setStroke_linejoin(Stroke_linejoin)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getPresentationAttributes_Stroke_linejoin()
	 * @model default="stroke_linejoin.miter"
	 * @generated
	 */
	Stroke_linejoin getStroke_linejoin();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getStroke_linejoin <em>Stroke linejoin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stroke linejoin</em>' attribute.
	 * @see org.eclipse.fx.formats.svg.svg.Stroke_linejoin
	 * @see #getStroke_linejoin()
	 * @generated
	 */
	void setStroke_linejoin(Stroke_linejoin value);

	/**
	 * Returns the value of the '<em><b>Stroke miterlimit</b></em>' attribute.
	 * The default value is <code>"4"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stroke miterlimit</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stroke miterlimit</em>' attribute.
	 * @see #setStroke_miterlimit(String)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getPresentationAttributes_Stroke_miterlimit()
	 * @model default="4" dataType="org.eclipse.fx.formats.svg.svg.Stroke_miterlimit"
	 * @generated
	 */
	String getStroke_miterlimit();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getStroke_miterlimit <em>Stroke miterlimit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stroke miterlimit</em>' attribute.
	 * @see #getStroke_miterlimit()
	 * @generated
	 */
	void setStroke_miterlimit(String value);

	/**
	 * Returns the value of the '<em><b>Stroke opacity</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stroke opacity</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stroke opacity</em>' attribute.
	 * @see #setStroke_opacity(String)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getPresentationAttributes_Stroke_opacity()
	 * @model default="1" dataType="org.eclipse.fx.formats.svg.svg.Stroke_opacity"
	 * @generated
	 */
	String getStroke_opacity();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getStroke_opacity <em>Stroke opacity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stroke opacity</em>' attribute.
	 * @see #getStroke_opacity()
	 * @generated
	 */
	void setStroke_opacity(String value);

	/**
	 * Returns the value of the '<em><b>Stroke width</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stroke width</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stroke width</em>' attribute.
	 * @see #setStroke_width(String)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getPresentationAttributes_Stroke_width()
	 * @model default="1" dataType="org.eclipse.fx.formats.svg.svg.Stroke_width"
	 * @generated
	 */
	String getStroke_width();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getStroke_width <em>Stroke width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stroke width</em>' attribute.
	 * @see #getStroke_width()
	 * @generated
	 */
	void setStroke_width(String value);

	/**
	 * Returns the value of the '<em><b>Text anchor</b></em>' attribute.
	 * The default value is <code>"text_anchor.start"</code>.
	 * The literals are from the enumeration {@link org.eclipse.fx.formats.svg.svg.Text_anchor}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Text anchor</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Text anchor</em>' attribute.
	 * @see org.eclipse.fx.formats.svg.svg.Text_anchor
	 * @see #setText_anchor(Text_anchor)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getPresentationAttributes_Text_anchor()
	 * @model default="text_anchor.start"
	 * @generated
	 */
	Text_anchor getText_anchor();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getText_anchor <em>Text anchor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text anchor</em>' attribute.
	 * @see org.eclipse.fx.formats.svg.svg.Text_anchor
	 * @see #getText_anchor()
	 * @generated
	 */
	void setText_anchor(Text_anchor value);

	/**
	 * Returns the value of the '<em><b>Text decoration</b></em>' attribute.
	 * The default value is <code>"\"none\""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Text decoration</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Text decoration</em>' attribute.
	 * @see #setText_decoration(String)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getPresentationAttributes_Text_decoration()
	 * @model default="\"none\"" dataType="org.eclipse.fx.formats.svg.svg.Text_decoration"
	 * @generated
	 */
	String getText_decoration();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getText_decoration <em>Text decoration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text decoration</em>' attribute.
	 * @see #getText_decoration()
	 * @generated
	 */
	void setText_decoration(String value);

	/**
	 * Returns the value of the '<em><b>Text rendering</b></em>' attribute.
	 * The default value is <code>"text_rendering.auto"</code>.
	 * The literals are from the enumeration {@link org.eclipse.fx.formats.svg.svg.Text_rendering}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Text rendering</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Text rendering</em>' attribute.
	 * @see org.eclipse.fx.formats.svg.svg.Text_rendering
	 * @see #setText_rendering(Text_rendering)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getPresentationAttributes_Text_rendering()
	 * @model default="text_rendering.auto"
	 * @generated
	 */
	Text_rendering getText_rendering();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getText_rendering <em>Text rendering</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text rendering</em>' attribute.
	 * @see org.eclipse.fx.formats.svg.svg.Text_rendering
	 * @see #getText_rendering()
	 * @generated
	 */
	void setText_rendering(Text_rendering value);

	/**
	 * Returns the value of the '<em><b>Unicode bidi</b></em>' attribute.
	 * The default value is <code>"unicode_bidi.normal"</code>.
	 * The literals are from the enumeration {@link org.eclipse.fx.formats.svg.svg.Unicode_bidi}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unicode bidi</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unicode bidi</em>' attribute.
	 * @see org.eclipse.fx.formats.svg.svg.Unicode_bidi
	 * @see #setUnicode_bidi(Unicode_bidi)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getPresentationAttributes_Unicode_bidi()
	 * @model default="unicode_bidi.normal"
	 * @generated
	 */
	Unicode_bidi getUnicode_bidi();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getUnicode_bidi <em>Unicode bidi</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unicode bidi</em>' attribute.
	 * @see org.eclipse.fx.formats.svg.svg.Unicode_bidi
	 * @see #getUnicode_bidi()
	 * @generated
	 */
	void setUnicode_bidi(Unicode_bidi value);

	/**
	 * Returns the value of the '<em><b>Visibility</b></em>' attribute.
	 * The default value is <code>"visibility.visible"</code>.
	 * The literals are from the enumeration {@link org.eclipse.fx.formats.svg.svg.Visibility}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Visibility</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Visibility</em>' attribute.
	 * @see org.eclipse.fx.formats.svg.svg.Visibility
	 * @see #setVisibility(Visibility)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getPresentationAttributes_Visibility()
	 * @model default="visibility.visible"
	 * @generated
	 */
	Visibility getVisibility();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getVisibility <em>Visibility</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Visibility</em>' attribute.
	 * @see org.eclipse.fx.formats.svg.svg.Visibility
	 * @see #getVisibility()
	 * @generated
	 */
	void setVisibility(Visibility value);

	/**
	 * Returns the value of the '<em><b>Word spacing</b></em>' attribute.
	 * The default value is <code>"\"normal\""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Word spacing</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Word spacing</em>' attribute.
	 * @see #setWord_spacing(String)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getPresentationAttributes_Word_spacing()
	 * @model default="\"normal\"" dataType="org.eclipse.fx.formats.svg.svg.Word_spacing"
	 * @generated
	 */
	String getWord_spacing();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getWord_spacing <em>Word spacing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Word spacing</em>' attribute.
	 * @see #getWord_spacing()
	 * @generated
	 */
	void setWord_spacing(String value);

	/**
	 * Returns the value of the '<em><b>Writing mode</b></em>' attribute.
	 * The default value is <code>"writing_mode.lr_tb"</code>.
	 * The literals are from the enumeration {@link org.eclipse.fx.formats.svg.svg.Writing_mode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Writing mode</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Writing mode</em>' attribute.
	 * @see org.eclipse.fx.formats.svg.svg.Writing_mode
	 * @see #setWriting_mode(Writing_mode)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getPresentationAttributes_Writing_mode()
	 * @model default="writing_mode.lr_tb"
	 * @generated
	 */
	Writing_mode getWriting_mode();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.PresentationAttributes#getWriting_mode <em>Writing mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Writing mode</em>' attribute.
	 * @see org.eclipse.fx.formats.svg.svg.Writing_mode
	 * @see #getWriting_mode()
	 * @generated
	 */
	void setWriting_mode(Writing_mode value);

} // PresentationAttributes
