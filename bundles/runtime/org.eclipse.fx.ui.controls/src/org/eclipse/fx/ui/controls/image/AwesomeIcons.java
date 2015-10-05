/*******************************************************************************
 * Copyright (c) 2015 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Christoph Caks <ccaks@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.controls.image;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.fx.ui.controls.image.fontawesome.AwesomeIconFontProvider;

import javafx.scene.text.Font;

/**
 * All font awesome icons
 *
 * @since 2.2.0
 */
public enum AwesomeIcons {
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-adjust"> fa-adjust</i>
	 */
	FA_ADJUST('\uf042', "fa-adjust"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-adn"> fa-adn</i>
	 */
	FA_ADN('\uf170', "fa-adn"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-align-center"> fa-align-center</i>
	 */
	FA_ALIGN_CENTER('\uf037', "fa-align-center"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-align-justify"> fa-align-justify</i>
	 */
	FA_ALIGN_JUSTIFY('\uf039', "fa-align-justify"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-align-left"> fa-align-left</i>
	 */
	FA_ALIGN_LEFT('\uf036', "fa-align-left"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-align-right"> fa-align-right</i>
	 */
	FA_ALIGN_RIGHT('\uf038', "fa-align-right"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-ambulance"> fa-ambulance</i>
	 */
	FA_AMBULANCE('\uf0f9', "fa-ambulance"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-anchor"> fa-anchor</i>
	 */
	FA_ANCHOR('\uf13d', "fa-anchor"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-android"> fa-android</i>
	 */
	FA_ANDROID('\uf17b', "fa-android"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-angle-double-down"> fa-angle-double-down</i>
	 */
	FA_ANGLE_DOUBLE_DOWN('\uf103', "fa-angle-double-down"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-angle-double-left"> fa-angle-double-left</i>
	 */
	FA_ANGLE_DOUBLE_LEFT('\uf100', "fa-angle-double-left"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-angle-double-right"> fa-angle-double-right</i>
	 */
	FA_ANGLE_DOUBLE_RIGHT('\uf101', "fa-angle-double-right"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-angle-double-up"> fa-angle-double-up</i>
	 */
	FA_ANGLE_DOUBLE_UP('\uf102', "fa-angle-double-up"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-angle-down"> fa-angle-down</i>
	 */
	FA_ANGLE_DOWN('\uf107', "fa-angle-down"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-angle-left"> fa-angle-left</i>
	 */
	FA_ANGLE_LEFT('\uf104', "fa-angle-left"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-angle-right"> fa-angle-right</i>
	 */
	FA_ANGLE_RIGHT('\uf105', "fa-angle-right"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-angle-up"> fa-angle-up</i>
	 */
	FA_ANGLE_UP('\uf106', "fa-angle-up"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-apple"> fa-apple</i>
	 */
	FA_APPLE('\uf179', "fa-apple"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-archive"> fa-archive</i>
	 */
	FA_ARCHIVE('\uf187', "fa-archive"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-arrow-circle-down"> fa-arrow-circle-down</i>
	 */
	FA_ARROW_CIRCLE_DOWN('\uf0ab', "fa-arrow-circle-down"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-arrow-circle-left"> fa-arrow-circle-left</i>
	 */
	FA_ARROW_CIRCLE_LEFT('\uf0a8', "fa-arrow-circle-left"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-arrow-circle-o-down"> fa-arrow-circle-o-down</i>
	 */
	FA_ARROW_CIRCLE_O_DOWN('\uf01a', "fa-arrow-circle-o-down"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-arrow-circle-o-left"> fa-arrow-circle-o-left</i>
	 */
	FA_ARROW_CIRCLE_O_LEFT('\uf190', "fa-arrow-circle-o-left"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-arrow-circle-o-right"> fa-arrow-circle-o-right</i>
	 */
	FA_ARROW_CIRCLE_O_RIGHT('\uf18e', "fa-arrow-circle-o-right"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-arrow-circle-o-up"> fa-arrow-circle-o-up</i>
	 */
	FA_ARROW_CIRCLE_O_UP('\uf01b', "fa-arrow-circle-o-up"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-arrow-circle-right"> fa-arrow-circle-right</i>
	 */
	FA_ARROW_CIRCLE_RIGHT('\uf0a9', "fa-arrow-circle-right"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-arrow-circle-up"> fa-arrow-circle-up</i>
	 */
	FA_ARROW_CIRCLE_UP('\uf0aa', "fa-arrow-circle-up"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-arrow-down"> fa-arrow-down</i>
	 */
	FA_ARROW_DOWN('\uf063', "fa-arrow-down"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-arrow-left"> fa-arrow-left</i>
	 */
	FA_ARROW_LEFT('\uf060', "fa-arrow-left"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-arrow-right"> fa-arrow-right</i>
	 */
	FA_ARROW_RIGHT('\uf061', "fa-arrow-right"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-arrow-up"> fa-arrow-up</i>
	 */
	FA_ARROW_UP('\uf062', "fa-arrow-up"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-arrows"> fa-arrows</i>
	 */
	FA_ARROWS('\uf047', "fa-arrows"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-arrows-alt"> fa-arrows-alt</i>
	 */
	FA_ARROWS_ALT('\uf0b2', "fa-arrows-alt"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "fa-arrows-h""> "fa-arrows-h"</i>
	 */
	FA_ARROWS_H('\uf07e', "fa-arrows-h"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-arrows-v"> fa-arrows-v</i>
	 */
	FA_ARROWS_V('\uf07d', "fa-arrows-v"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-asterisk"> fa-asterisk</i>
	 */
	FA_ASTERISK('\uf069', "fa-asterisk"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-automobile"> fa-automobile</i>
	 */
	FA_AUTOMOBILE('\uf1b9', "fa-automobile"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-backward"> fa-backward</i>
	 */
	FA_BACKWARD('\uf04a', "fa-backward"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-ban"> fa-ban</i>
	 */
	FA_BAN('\uf05e', "fa-ban"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-bank"> fa-bank</i>
	 */
	FA_BANK('\uf19c', "fa-bank"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-bar-chart-o"> fa-bar-chart-o</i>
	 */
	FA_BAR_CHART_O('\uf080', "fa-bar-chart-o"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-barcode"> fa-barcode</i>
	 */
	FA_BARCODE('\uf02a', "fa-barcode"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-bars"> fa-bars</i>
	 */
	FA_BARS('\uf0c9', "fa-bars"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-beer"> fa-beer</i>
	 */
	FA_BEER('\uf0fc', "fa-beer"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-behance"> fa-behance</i>
	 */
	FA_BEHANCE('\uf1b4', "fa-behance"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-behance-square"> fa-behance-square</i>
	 */
	FA_BEHANCE_SQUARE('\uf1b5', "fa-behance-square"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-bell"> fa-bell</i>
	 */
	FA_BELL('\uf0f3', "fa-bell"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-bell-o"> fa-bell-o</i>
	 */
	FA_BELL_O('\uf0a2', "fa-bell-o"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-bitbucket"> fa-bitbucket</i>
	 */
	FA_BITBUCKET('\uf171', "fa-bitbucket"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-bitbucket-square"> fa-bitbucket-square</i>
	 */
	FA_BITBUCKET_SQUARE('\uf172', "fa-bitbucket-square"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-bitcoin"> fa-bitcoin</i>
	 */
	FA_BITCOIN('\uf15a', "fa-bitcoin"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-bold"> fa-bold</i>
	 */
	FA_BOLD('\uf032', "fa-bold"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-bolt"> fa-bolt</i>
	 */
	FA_BOLT('\uf0e7', "fa-bolt"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-bomb"> fa-bomb</i>
	 */
	FA_BOMB('\uf1e2', "fa-bomb"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-book"> fa-book</i>
	 */
	FA_BOOK('\uf02d', "fa-book"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-bookmark"> fa-bookmark</i>
	 */
	FA_BOOKMARK('\uf02e', "fa-bookmark"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-bookmark-o"> fa-bookmark-o</i>
	 */
	FA_BOOKMARK_O('\uf097', "fa-bookmark-o"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-briefcase"> fa-briefcase</i>
	 */
	FA_BRIEFCASE('\uf0b1', "fa-briefcase"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-btc"> fa-btc</i>
	 */
	FA_BTC('\uf15a', "fa-btc"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-bug"> fa-bug</i>
	 */
	FA_BUG('\uf188', "fa-bug"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-building"> fa-building</i>
	 */
	FA_BUILDING('\uf1ad', "fa-building"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-building-o"> fa-building-o</i>
	 */
	FA_BUILDING_O('\uf0f7', "fa-building-o"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-bullhorn"> fa-bullhorn</i>
	 */
	FA_BULLHORN('\uf0a1', "fa-bullhorn"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-bullseye"> fa-bullseye</i>
	 */
	FA_BULLSEYE('\uf140', "fa-bullseye"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-cab"> fa-cab</i>
	 */
	FA_CAB('\uf1ba', "fa-cab"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-calendar"> fa-calendar</i>
	 */
	FA_CALENDAR('\uf073', "fa-calendar"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-calendar-o"> fa-calendar-o</i>
	 */
	FA_CALENDAR_O('\uf133', "fa-calendar-o"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-camera"> fa-camera</i>
	 */
	FA_CAMERA('\uf030', "fa-camera"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-camera-retro"> fa-camera-retro</i>
	 */
	FA_CAMERA_RETRO('\uf083', "fa-camera-retro"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-car"> fa-car</i>
	 */
	FA_CAR('\uf1b9', "fa-car"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-caret-down"> fa-caret-down</i>
	 */
	FA_CARET_DOWN('\uf0d7', "fa-caret-down"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-caret-left"> fa-caret-left</i>
	 */
	FA_CARET_LEFT('\uf0d9', "fa-caret-left"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-caret-right"> fa-caret-right</i>
	 */
	FA_CARET_RIGHT('\uf0da', "fa-caret-right"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-caret-square-o-down"> fa-caret-square-o-down</i>
	 */
	FA_CARET_SQUARE_O_DOWN('\uf150', "fa-caret-square-o-down"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-caret-square-o-left"> fa-caret-square-o-left</i>
	 */
	FA_CARET_SQUARE_O_LEFT('\uf191', "fa-caret-square-o-left"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-caret-square-o-right"> fa-caret-square-o-right</i>
	 */
	FA_CARET_SQUARE_O_RIGHT('\uf152', "fa-caret-square-o-right"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-caret-square-o-up"> fa-caret-square-o-up</i>
	 */
	FA_CARET_SQUARE_O_UP('\uf151', "fa-caret-square-o-up"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-caret-up"> fa-caret-up</i>
	 */
	FA_CARET_UP('\uf0d8', "fa-caret-up"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-certificate"> fa-certificate</i>
	 */
	FA_CERTIFICATE('\uf0a3', "fa-certificate"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-chain"> fa-chain</i>
	 */
	FA_CHAIN('\uf0c1', "fa-chain"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-chain-broken"> fa-chain-broken</i>
	 */
	FA_CHAIN_BROKEN('\uf127', "fa-chain-broken"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-check"> fa-check</i>
	 */
	FA_CHECK('\uf00c', "fa-check"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-check-circle"> fa-check-circle</i>
	 */
	FA_CHECK_CIRCLE('\uf058', "fa-check-circle"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-check-circle-o"> fa-check-circle-o</i>
	 */
	FA_CHECK_CIRCLE_O('\uf05d', "fa-check-circle-o"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-check-square"> fa-check-square</i>
	 */
	FA_CHECK_SQUARE('\uf14a', "fa-check-square"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-check-square-o"> fa-check-square-o</i>
	 */
	FA_CHECK_SQUARE_O('\uf046', "fa-check-square-o"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-chevron-circle-down"> fa-chevron-circle-down</i>
	 */
	FA_CHEVRON_CIRCLE_DOWN('\uf13a', "fa-chevron-circle-down"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-chevron-circle-left"> fa-chevron-circle-left</i>
	 */
	FA_CHEVRON_CIRCLE_LEFT('\uf137', "fa-chevron-circle-left"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-chevron-circle-right"> fa-chevron-circle-right</i>
	 */
	FA_CHEVRON_CIRCLE_RIGHT('\uf138', "fa-chevron-circle-right"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-chevron-circle-up"> fa-chevron-circle-up</i>
	 */
	FA_CHEVRON_CIRCLE_UP('\uf139', "fa-chevron-circle-up"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-chevron-down"> fa-chevron-down</i>
	 */
	FA_CHEVRON_DOWN('\uf078', "fa-chevron-down"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-chevron-left"> fa-chevron-left</i>
	 */
	FA_CHEVRON_LEFT('\uf053', "fa-chevron-left"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-chevron-right"> fa-chevron-right</i>
	 */
	FA_CHEVRON_RIGHT('\uf054', "fa-chevron-right"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-chevron-up"> fa-chevron-up</i>
	 */
	FA_CHEVRON_UP('\uf077', "fa-chevron-up"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-child"> fa-child</i>
	 */
	FA_CHILD('\uf1ae', "fa-child"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-circle"> fa-circle</i>
	 */
	FA_CIRCLE('\uf111', "fa-circle"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-circle-o"> fa-circle-o</i>
	 */
	FA_CIRCLE_O('\uf10c', "fa-circle-o"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-circle-o-notch"> fa-circle-o-notch</i>
	 */
	FA_CIRCLE_O_NOTCH('\uf1ce', "fa-circle-o-notch"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-circle-thin"> fa-circle-thin</i>
	 */
	FA_CIRCLE_THIN('\uf1db', "fa-circle-thin"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-clipboard"> fa-clipboard</i>
	 */
	FA_CLIPBOARD('\uf0ea', "fa-clipboard"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-clock-o"> fa-clock-o</i>
	 */
	FA_CLOCK_O('\uf017', "fa-clock-o"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-cloud"> fa-cloud</i>
	 */
	FA_CLOUD('\uf0c2', "fa-cloud"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-cloud-download"> fa-cloud-download</i>
	 */
	FA_CLOUD_DOWNLOAD('\uf0ed', "fa-cloud-download"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-cloud-upload"> fa-cloud-upload</i>
	 */
	FA_CLOUD_UPLOAD('\uf0ee', "fa-cloud-upload"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-cny"> fa-cny</i>
	 */
	FA_CNY('\uf157', "fa-cny"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-code"> fa-code</i>
	 */
	FA_CODE('\uf121', "fa-code"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-code-fork"> fa-code-fork</i>
	 */
	FA_CODE_FORK('\uf126', "fa-code-fork"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-codepen"> fa-codepen</i>
	 */
	FA_CODEPEN('\uf1cb', "fa-codepen"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-coffee"> fa-coffee</i>
	 */
	FA_COFFEE('\uf0f4', "fa-coffee"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-cog"> fa-cog</i>
	 */
	FA_COG('\uf013', "fa-cog"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-cogs"> fa-cogs</i>
	 */
	FA_COGS('\uf085', "fa-cogs"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-columns"> fa-columns</i>
	 */
	FA_COLUMNS('\uf0db', "fa-columns"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-comment"> fa-comment</i>
	 */
	FA_COMMENT('\uf075', "fa-comment"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-comment-o"> fa-comment-o</i>
	 */
	FA_COMMENT_O('\uf0e5', "fa-comment-o"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-comments"> fa-comments</i>
	 */
	FA_COMMENTS('\uf086', "fa-comments"), //$NON-NLS-1$
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa fa-comments-o"> fa-comments-o</i>
	 */
	FA_COMMENTS_O('\uf0e6', "fa-comments-o"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_COMPASS('\uf14e', "fa-compass"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_COMPRESS('\uf066', "fa-compress"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_COPY('\uf0c5', "fa-copy"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_CREDIT_CARD('\uf09d', "fa-credit-card"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_CROP('\uf125', "fa-crop"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_CROSSHAIRS('\uf05b', "fa-crosshairs"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_CSS('\uf13c', "fa-css"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_CUBE('\uf1b2', "fa-cube"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_CUBES('\uf1b3', "fa-cubes"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_CUT('\uf0c4', "fa-cut"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_CUTLERY('\uf0f5', "fa-cutlery"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_DASHBOARD('\uf0e4', "fa-dashboard"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_DATABASE('\uf1c0', "fa-database"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_DEDENT('\uf03b', "fa-dedent"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_DELICIOUS('\uf1a5', "fa-delicious"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_DESKTOP('\uf108', "fa-desktop"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_DEVIANTART('\uf1bd', "fa-deviantart"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_DIGG('\uf1a6', "fa-digg"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_DOLLAR('\uf155', "fa-dollar"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_DOT_CIRCLE_O('\uf192', "fa-dot-circle-o"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_DOWNLOAD('\uf019', "fa-download"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_DRIBBBLE('\uf17d', "fa-dribbble"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_DROPBOX('\uf16b', "fa-dropbox"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_DRUPAL('\uf1a9', "fa-drupal"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_EDIT('\uf044', "fa-edit"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_EJECT('\uf052', "fa-eject"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_ELLIPSIS_H('\uf141', "fa-ellipsis-h"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_ELLIPSIS_V('\uf142', "fa-ellipsis-v"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_EMPIRE('\uf1d1', "fa-empire"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_ENVELOPE('\uf0e0', "fa-envelope"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_ENVELOPE_O('\uf003', "fa-envelope-o"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_ENVELOPE_SQUARE('\uf199', "fa-envelope-square"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_ERASER('\uf12d', "fa-eraser"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_EUR('\uf153', "fa-eur"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_EURO('\uf153', "fa-euro"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_EXCHANGE('\uf0ec', "fa-exchange"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_EXCLAMATION('\uf12a', "fa-exclamation"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_EXCLAMATION_CIRCLE('\uf06a', "fa-exclamation-circle"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_EXCLAMATION_TRIANGLE('\uf071', "fa-exclamation-triangle"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_EXPAND('\uf065', "fa-expand"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_EXTERNAL_LINK('\uf08e', "fa-external-link"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_EXTERNAL_LINK_SQUARE('\uf14c', "fa-external-link-square"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_EYE('\uf06e', "fa-eye"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_EYE_SLASH('\uf070', "fa-eye-slash"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_FACEBOOK('\uf09a', "fa-facebook"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_FACEBOOK_SQUARE('\uf082', "fa-facebook-square"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_FAST_BACKWARD('\uf049', "fa-fast-backward"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_FAST_FORWARD('\uf050', "fa-fast-forward"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_FAX('\uf1ac', "fa-fax"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_FEMALE('\uf182', "fa-female"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_FIGHTER_JET('\uf0fb', "fa-fighter-jet"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_FILE('\uf15b', "fa-file"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_FILE_ARCHIVE_O('\uf1c6', "fa-file-archive-o"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_FILE_AUDIO_O('\uf1c7', "fa-file-audio-o"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_FILE_CODE_O('\uf1c9', "fa-file-code-o"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_FILE_EXCEL_O('\uf1c3', "fa-file-excel-o"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_FILE_IMAGE_O('\uf1c5', "fa-file-image-o"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_FILE_MOVIE_O('\uf1c8', "fa-file-movie-o"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_FILE_O('\uf016', "fa-file-o"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_FILE_PDF_O('\uf1c1', "fa-file-pdf-o"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_FILE_PHOTO_O('\uf1c5', "fa-file-photo-o"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_FILE_PICTURE_O('\uf1c5', "fa-file-picture-o"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_FILE_POWERPOINT_O('\uf1c4', "fa-file-powerpoint-o"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_FILE_SOUND_O('\uf1c7', "fa-file-sound-o"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_FILE_TEXT('\uf15c', "fa-file-text"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_FILE_TEXT_O('\uf0f6', "fa-file-text-o"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_FILE_VIDEO_O('\uf1c8', "fa-file-video-o"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_FILE_WORD_O('\uf1c2', "fa-file-word-o"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_FILE_ZIP_O('\uf1c6', "fa-file-zip-o"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_FILES_O('\uf0c5', "fa-files-o"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_FILM('\uf008', "fa-film"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_FILTER('\uf0b0', "fa-filter"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_FIRE('\uf06d', "fa-fire"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_FIRE_EXTINGUISHER('\uf134', "fa-fire-extinguisher"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_FLAG('\uf024', "fa-flag"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_FLAG_CHECKERED('\uf11e', "fa-flag-checkered"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_FLAG_O('\uf11d', "fa-flag-o"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_FLASH('\uf0e7', "fa-flash"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_FLASK('\uf0c3', "fa-flask"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_FLICKR('\uf16e', "fa-flickr"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_FLOPPY_O('\uf0c7', "fa-floppy-o"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_FOLDER('\uf07b', "fa-folder"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_FOLDER_O('\uf114', "fa-folder-o"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_FOLDER_OPEN('\uf07c', "fa-folder-open"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_FOLDER_OPEN_O('\uf115', "fa-folder-open-o"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_FONT('\uf031', "fa-font"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_FORWARD('\uf04e', "fa-forward"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_FOURSQUARE('\uf180', "fa-foursquare"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_FROWN_O('\uf119', "fa-frown-o"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_GAMEPAD('\uf11b', "fa-gamepad"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_GAVEL('\uf0e3', "fa-gavel"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_GBP('\uf154', "fa-gbp"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_GE('\uf1d1', "fa-ge"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_GEAR('\uf013', "fa-gear"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_GEARS('\uf085', "fa-gears"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_GIFT('\uf06b', "fa-gift"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_GIT('\uf1d3', "fa-git"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_GIT_SQUARE('\uf1d2', "fa-git-square"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_GITHUB('\uf09b', "fa-github"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_GITHUB_ALT('\uf113', "fa-github-alt"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_GITHUB_SQUARE('\uf092', "fa-github-square"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_GITTIP('\uf184', "fa-gittip"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_GLASS('\uf000', "fa-glass"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_GLOBE('\uf0ac', "fa-globe"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_GOOGLE('\uf1a0', "fa-google"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_GOOGLE_PLUS('\uf0d5', "fa-google-plus"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_GOOGLE_PLUS_SQUARE('\uf0d4', "fa-google-plus-square"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_GRADUATION_CAP('\uf19d', "fa-graduation-cap"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_GROUP('\uf0c0', "fa-group"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_H_SQUARE('\uf0fd', "fa-h-square"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_HACKER_NEWS('\uf1d4', "fa-hacker-news"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_HAND_O_DOWN('\uf0a7', "fa-hand-o-down"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_HAND_O_LEFT('\uf0a5', "fa-hand-o-left"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_HAND_O_RIGHT('\uf0a4', "fa-hand-o-right"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_HAND_O_UP('\uf0a6', "fa-hand-o-up"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_HDD_O('\uf0a0', "fa-hdd-o"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_HEADER('\uf1dc', "fa-header"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_HEADPHONES('\uf025', "fa-headphones"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_HEART('\uf004', "fa-heart"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_HEART_O('\uf08a', "fa-heart-o"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_HISTORY('\uf1da', "fa-history"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_HOME('\uf015', "fa-home"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_HOSPITAL_O('\uf0f8', "fa-hospital-o"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_HTML('\uf13b', "fa-html"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_IMAGE('\uf03e', "fa-image"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_INBOX('\uf01c', "fa-inbox"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_INDENT('\uf03c', "fa-indent"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_INFO('\uf129', "fa-info"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_INFO_CIRCLE('\uf05a', "fa-info-circle"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_INR('\uf156', "fa-inr"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_INSTAGRAM('\uf16d', "fa-instagram"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_INSTITUTION('\uf19c', "fa-institution"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_ITALIC('\uf033', "fa-italic"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_JOOMLA('\uf1aa', "fa-joomla"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_JPY('\uf157', "fa-jpy"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_JSFIDDLE('\uf1cc', "fa-jsfiddle"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_KEY('\uf084', "fa-key"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_KEYBOARD_O('\uf11c', "fa-keyboard-o"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_KRW('\uf159', "fa-krw"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_LANGUAGE('\uf1ab', "fa-language"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_LAPTOP('\uf109', "fa-laptop"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_LEAF('\uf06c', "fa-leaf"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_LEGAL('\uf0e3', "fa-legal"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_LEMON_O('\uf094', "fa-lemon-o"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_LEVEL_DOWN('\uf149', "fa-level-down"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_LEVEL_UP('\uf148', "fa-level-up"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_LIFE_BOUY('\uf1cd', "fa-life-bouy"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_LIFE_RING('\uf1cd', "fa-life-ring"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_LIFE_SAVER('\uf1cd', "fa-life-saver"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_LIGHTBULB_O('\uf0eb', "fa-lightbulb-o"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_LINK('\uf0c1', "fa-link"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_LINKEDIN('\uf0e1', "fa-linkedin"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_LINKEDIN_SQUARE('\uf08c', "fa-linkedin-square"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_LINUX('\uf17c', "fa-linux"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_LIST('\uf03a', "fa-list"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_LIST_ALT('\uf022', "fa-list-alt"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_LIST_OL('\uf0cb', "fa-list-ol"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_LIST_UL('\uf0ca', "fa-list-ul"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_LOCATION_ARROW('\uf124', "fa-location-arrow"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_LOCK('\uf023', "fa-lock"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_LONG_ARROW_DOWN('\uf175', "fa-long-arrow-down"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_LONG_ARROW_LEFT('\uf177', "fa-long-arrow-left"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_LONG_ARROW_RIGHT('\uf178', "fa-long-arrow-right"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_LONG_ARROW_UP('\uf176', "fa-long-arrow-up"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_MAGIC('\uf0d0', "fa-magic"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_MAGNET('\uf076', "fa-magnet"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_MAIL_FORWARD('\uf064', "fa-mail-forward"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_MAIL_REPLY('\uf112', "fa-mail-reply"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_MAIL_REPLY_ALL('\uf122', "fa-mail-reply-all"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_MALE('\uf183', "fa-male"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_MAP_MARKER('\uf041', "fa-map-marker"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_MAXCDN('\uf136', "fa-maxcdn"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_MEDKIT('\uf0fa', "fa-medkit"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_MEH_O('\uf11a', "fa-meh-o"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_MICROPHONE('\uf130', "fa-microphone"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_MICROPHONE_SLASH('\uf131', "fa-microphone-slash"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_MINUS('\uf068', "fa-minus"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_MINUS_CIRCLE('\uf056', "fa-minus-circle"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_MINUS_SQUARE('\uf146', "fa-minus-square"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_MINUS_SQUARE_O('\uf147', "fa-minus-square-o"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_MOBILE('\uf10b', "fa-mobile"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_MOBILE_PHONE('\uf10b', "fa-mobile-phone"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_MONEY('\uf0d6', "fa-money"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_MOON_O('\uf186', "fa-moon-o"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_MORTAR_BOARD('\uf19d', "fa-mortar-board"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_MUSIC('\uf001', "fa-music"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_NAVICON('\uf0c9', "fa-navicon"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_OPENID('\uf19b', "fa-openid"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_OUTDENT('\uf03b', "fa-outdent"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_PAGELINES('\uf18c', "fa-pagelines"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_PAPER_PLANE('\uf1d8', "fa-paper-plane"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_PAPER_PLANE_O('\uf1d9', "fa-paper-plane-o"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_PAPERCLIP('\uf0c6', "fa-paperclip"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_PARAGRAPH('\uf1dd', "fa-paragraph"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_PASTE('\uf0ea', "fa-paste"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_PAUSE('\uf04c', "fa-pause"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_PAW('\uf1b0', "fa-paw"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_PENCIL('\uf040', "fa-pencil"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_PENCIL_SQUARE('\uf14b', "fa-pencil-square"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_PENCIL_SQUARE_O('\uf044', "fa-pencil-square-o"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_PHONE('\uf095', "fa-phone"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_PHONE_SQUARE('\uf098', "fa-phone-square"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_PHOTO('\uf03e', "fa-photo"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_PICTURE_O('\uf03e', "fa-picture-o"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_PIED_PIPER('\uf1a7', "fa-pied-piper"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_PIED_PIPER_ALT('\uf1a8', "fa-pied-piper-alt"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_PIED_PIPER_SQUARE('\uf1a7', "fa-pied-piper-square"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_PINTEREST('\uf0d2', "fa-pinterest"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_PINTEREST_SQUARE('\uf0d3', "fa-pinterest-square"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_PLANE('\uf072', "fa-plane"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_PLAY('\uf04b', "fa-play"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_PLAY_CIRCLE('\uf144', "fa-play-circle"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_PLAY_CIRCLE_O('\uf01d', "fa-play-circle-o"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_PLUS('\uf067', "fa-plus"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_PLUS_CIRCLE('\uf055', "fa-plus-circle"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_PLUS_SQUARE('\uf0fe', "fa-plus-square"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_PLUS_SQUARE_O('\uf196', "fa-plus-square-o"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_POWER_OFF('\uf011', "fa-power-off"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_PRINT('\uf02f', "fa-print"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_PUZZLE_PIECE('\uf12e', "fa-puzzle-piece"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_QQ('\uf1d6', "fa-qq"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_QRCODE('\uf029', "fa-qrcode"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_QUESTION('\uf128', "fa-question"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_QUESTION_CIRCLE('\uf059', "fa-question-circle"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_QUOTE_LEFT('\uf10d', "fa-quote-left"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_QUOTE_RIGHT('\uf10e', "fa-quote-right"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_RA('\uf1d0', "fa-ra"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_RANDOM('\uf074', "fa-random"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_REBEL('\uf1d0', "fa-rebel"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_RECYCLE('\uf1b8', "fa-recycle"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_REDDIT('\uf1a1', "fa-reddit"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_REDDIT_SQUARE('\uf1a2', "fa-reddit-square"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_REFRESH('\uf021', "fa-refresh"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_RENREN('\uf18b', "fa-renren"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_REORDER('\uf0c9', "fa-reorder"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_REPEAT('\uf01e', "fa-repeat"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_REPLY('\uf112', "fa-reply"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_REPLY_ALL('\uf122', "fa-reply-all"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_RETWEET('\uf079', "fa-retweet"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_RMB('\uf157', "fa-rmb"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_ROAD('\uf018', "fa-road"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_ROCKET('\uf135', "fa-rocket"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_ROTATE_LEFT('\uf0e2', "fa-rotate-left"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_ROTATE_RIGHT('\uf01e', "fa-rotate-right"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_ROUBLE('\uf158', "fa-rouble"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_RSS('\uf09e', "fa-rss"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_RSS_SQUARE('\uf143', "fa-rss-square"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_RUB('\uf158', "fa-rub"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_RUBLE('\uf158', "fa-ruble"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_RUPEE('\uf156', "fa-rupee"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_SAVE('\uf0c7', "fa-save"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_SCISSORS('\uf0c4', "fa-scissors"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_SEARCH('\uf002', "fa-search"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_SEARCH_MINUS('\uf010', "fa-search-minus"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_SEARCH_PLUS('\uf00e', "fa-search-plus"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_SEND('\uf1d8', "fa-send"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_SEND_O('\uf1d9', "fa-send-o"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_SHARE('\uf064', "fa-share"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_SHARE_ALT('\uf1e0', "fa-share-alt"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_SHARE_ALT_SQUARE('\uf1e1', "fa-share-alt-square"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_SHARE_SQUARE('\uf14d', "fa-share-square"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_SHARE_SQUARE_O('\uf045', "fa-share-square-o"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_SHIELD('\uf132', "fa-shield"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_SHOPPING_CART('\uf07a', "fa-shopping-cart"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_SIGN_IN('\uf090', "fa-sign-in"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_SIGN_OUT('\uf08b', "fa-sign-out"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_SIGNAL('\uf012', "fa-signal"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_SITEMAP('\uf0e8', "fa-sitemap"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_SKYPE('\uf17e', "fa-skype"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_SLACK('\uf198', "fa-slack"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_SLIDERS('\uf1de', "fa-sliders"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_SMILE_O('\uf118', "fa-smile-o"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_SORT('\uf0dc', "fa-sort"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_SORT_ALPHA_ASC('\uf15d', "fa-sort-alpha-asc"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_SORT_ALPHA_DESC('\uf15e', "fa-sort-alpha-desc"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_SORT_AMOUNT_ASC('\uf160', "fa-sort-amount-asc"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_SORT_AMOUNT_DESC('\uf161', "fa-sort-amount-desc"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_SORT_ASC('\uf0de', "fa-sort-asc"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_SORT_DESC('\uf0dd', "fa-sort-desc"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_SORT_DOWN('\uf0dd', "fa-sort-down"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_SORT_NUMERIC_ASC('\uf162', "fa-sort-numeric-asc"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_SORT_NUMERIC_DESC('\uf163', "fa-sort-numeric-desc"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_SORT_UP('\uf0de', "fa-sort-up"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_SOUNDCLOUD('\uf1be', "fa-soundcloud"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_SPACE_SHUTTLE('\uf197', "fa-space-shuttle"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_SPINNER('\uf110', "fa-spinner"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_SPOON('\uf1b1', "fa-spoon"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_SPOTIFY('\uf1bc', "fa-spotify"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_SQUARE('\uf0c8', "fa-square"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_SQUARE_O('\uf096', "fa-square-o"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_STACK_EXCHANGE('\uf18d', "fa-stack-exchange"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_STACK_OVERFLOW('\uf16c', "fa-stack-overflow"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_STAR('\uf005', "fa-star"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_STAR_HALF('\uf089', "fa-star-half"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_STAR_HALF_EMPTY('\uf123', "fa-star-half-empty"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_STAR_HALF_FULL('\uf123', "fa-star-half-full"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_STAR_HALF_O('\uf123', "fa-star-half-o"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_STAR_O('\uf006', "fa-star-o"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_STEAM('\uf1b6', "fa-steam"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_STEAM_SQUARE('\uf1b7', "fa-steam-square"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_STEP_BACKWARD('\uf048', "fa-step-backward"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_STEP_FORWARD('\uf051', "fa-step-forward"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_STETHOSCOPE('\uf0f1', "fa-stethoscope"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_STOP('\uf04d', "fa-stop"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_STRIKETHROUGH('\uf0cc', "fa-strikethrough"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_STUMBLEUPON('\uf1a4', "fa-stumbleupon"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_STUMBLEUPON_CIRCLE('\uf1a3', "fa-stumbleupon-circle"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_SUBSCRIPT('\uf12c', "fa-subscript"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_SUITCASE('\uf0f2', "fa-suitcase"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_SUN_O('\uf185', "fa-sun-o"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_SUPERSCRIPT('\uf12b', "fa-superscript"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_SUPPORT('\uf1cd', "fa-support"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_TABLE('\uf0ce', "fa-table"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_TABLET('\uf10a', "fa-tablet"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_TACHOMETER('\uf0e4', "fa-tachometer"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_TAG('\uf02b', "fa-tag"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_TAGS('\uf02c', "fa-tags"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_TASKS('\uf0ae', "fa-tasks"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_TAXI('\uf1ba', "fa-taxi"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_TENCENT_WEIBO('\uf1d5', "fa-tencent-weibo"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_TERMINAL('\uf120', "fa-terminal"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_TEXT_HEIGHT('\uf034', "fa-text-height"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_TEXT_WIDTH('\uf035', "fa-text-width"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_TH('\uf00a', "fa-th"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_TH_LARGE('\uf009', "fa-th-large"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_TH_LIST('\uf00b', "fa-th-list"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_THUMB_TACK('\uf08d', "fa-thumb-tack"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_THUMBS_DOWN('\uf165', "fa-thumbs-down"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_THUMBS_O_DOWN('\uf088', "fa-thumbs-o-down"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_THUMBS_O_UP('\uf087', "fa-thumbs-o-up"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_THUMBS_UP('\uf164', "fa-thumbs-up"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_TICKET('\uf145', "fa-ticket"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_TIMES('\uf00d', "fa-times"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_TIMES_CIRCLE('\uf057', "fa-times-circle"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_TIMES_CIRCLE_O('\uf05c', "fa-times-circle-o"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_TINT('\uf043', "fa-tint"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_TOGGLE_DOWN('\uf150', "fa-toggle-down"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_TOGGLE_LEFT('\uf191', "fa-toggle-left"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_TOGGLE_RIGHT('\uf152', "fa-toggle-right"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_TOGGLE_UP('\uf151', "fa-toggle-up"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_TRASH_O('\uf014', "fa-trash-o"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_TREE('\uf1bb', "fa-tree"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_TRELLO('\uf181', "fa-trello"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_TROPHY('\uf091', "fa-trophy"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_TRUCK('\uf0d1', "fa-truck"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_TRY('\uf195', "fa-try"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_TUMBLR('\uf173', "fa-tumblr"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_TUMBLR_SQUARE('\uf174', "fa-tumblr-square"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_TURKISH_LIRA('\uf195', "fa-turkish-lira"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_TWITTER('\uf099', "fa-twitter"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_TWITTER_SQUARE('\uf081', "fa-twitter-square"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_UMBRELLA('\uf0e9', "fa-umbrella"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_UNDERLINE('\uf0cd', "fa-underline"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_UNDO('\uf0e2', "fa-undo"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_UNIVERSITY('\uf19c', "fa-university"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_UNLINK('\uf127', "fa-unlink"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_UNLOCK('\uf09c', "fa-unlock"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_UNLOCK_ALT('\uf13e', "fa-unlock-alt"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_UNSORTED('\uf0dc', "fa-unsorted"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_UPLOAD('\uf093', "fa-upload"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_USD('\uf155', "fa-usd"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_USER('\uf007', "fa-user"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_USER_MD('\uf0f0', "fa-user-md"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_USERS('\uf0c0', "fa-users"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_VIDEO_CAMERA('\uf03d', "fa-video-camera"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_VIMEO_SQUARE('\uf194', "fa-vimeo-square"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_VINE('\uf1ca', "fa-vine"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_VK('\uf189', "fa-vk"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_VOLUME_DOWN('\uf027', "fa-volume-down"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_VOLUME_OFF('\uf026', "fa-volume-off"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_VOLUME_UP('\uf028', "fa-volume-up"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_WARNING('\uf071', "fa-warning"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_WECHAT('\uf1d7', "fa-wechat"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_WEIBO('\uf18a', "fa-weibo"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_WEIXIN('\uf1d7', "fa-weixin"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_WHEELCHAIR('\uf193', "fa-wheelchair"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_WINDOWS('\uf17a', "fa-windows"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_WON('\uf159', "fa-won"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_WORDPRESS('\uf19a', "fa-wordpress"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_WRENCH('\uf0ad', "fa-wrench"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_XING('\uf168', "fa-xing"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_XING_SQUARE('\uf169', "fa-xing-square"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_YAHOO('\uf19e', "fa-yahoo"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_YEN('\uf157', "fa-yen"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_YOUTUBE('\uf167', "fa-youtube"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_YOUTUBE_PLAY('\uf16a', "fa-youtube-play"),
	/**
	 * <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	 * <i class="fa "> </i>
	 */
	FA_YOUTUBE_SQUARE('\uf166', "fa-youtube-square");

	private String name;
	private char value;

	private AwesomeIcons(char value, String name) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public char getValue() {
		return value;
	}

	private static Map<String, AwesomeIcons> byNameMap = new HashMap<String, AwesomeIcons>();

	static {
		for (AwesomeIcons i : AwesomeIcons.values()) {
			byNameMap.put(i.name, i);
		}
	}

	public static AwesomeIcons get(String name) {
		return byNameMap.get(name);
	}

	/**
	 * @return The font that is used to provide the icons
	 */
	public static Font getFont() {
		return AwesomeIconFontProvider.getFont();
	}

}
