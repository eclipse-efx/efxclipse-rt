/*******************************************************************************
 * Copyright (c) 2015 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.controls.image;

import java.util.HashMap;
import java.util.Map;

/**
 * List of all available Font-Awesome icons
 */
public class FontAwesomeIcons {
	private FontAwesomeIcons() {

	}

	private static final Map<String, Character> NAME_TO_CHAR = new HashMap<String, Character>();

	/**
	 * Return the char-code for the provided name
	 *
	 * @param name
	 *            the name
	 * @return the character code
	 */
	public static char getCharacter(String name) {
		Character character = NAME_TO_CHAR.get(name);
		if (character == null) {
			throw new IllegalStateException("Unknown alias '" + name + "'"); //$NON-NLS-1$ //$NON-NLS-2$
		}
		return character.charValue();
	}

	static {
		NAME_TO_CHAR.put("fa-glass", Character.valueOf('\uf000')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-music", Character.valueOf('\uf001')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-search", Character.valueOf('\uf002')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-envelope-o", Character.valueOf('\uf003')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-heart", Character.valueOf('\uf004')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-star", Character.valueOf('\uf005')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-star-o", Character.valueOf('\uf006')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-user", Character.valueOf('\uf007')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-film", Character.valueOf('\uf008')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-th-large", Character.valueOf('\uf009')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-th", Character.valueOf('\uf00a')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-th-list", Character.valueOf('\uf00b')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-check", Character.valueOf('\uf00c')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-remove", Character.valueOf('\uf00d')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-times", Character.valueOf('\uf00d')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-close", Character.valueOf('\uf00d')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-search-plus", Character.valueOf('\uf00e')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-search-minus", Character.valueOf('\uf010')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-power-off", Character.valueOf('\uf011')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-signal", Character.valueOf('\uf012')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-gear", Character.valueOf('\uf013')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-cog", Character.valueOf('\uf013')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-trash-o", Character.valueOf('\uf014')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-home", Character.valueOf('\uf015')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-file-o", Character.valueOf('\uf016')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-clock-o", Character.valueOf('\uf017')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-road", Character.valueOf('\uf018')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-download", Character.valueOf('\uf019')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-arrow-circle-o-down", Character.valueOf('\uf01a')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-arrow-circle-o-up", Character.valueOf('\uf01b')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-inbox", Character.valueOf('\uf01c')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-play-circle-o", Character.valueOf('\uf01d')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-rotate-right", Character.valueOf('\uf01e')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-repeat", Character.valueOf('\uf01e')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-refresh", Character.valueOf('\uf021')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-list-alt", Character.valueOf('\uf022')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-lock", Character.valueOf('\uf023')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-flag", Character.valueOf('\uf024')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-headphones", Character.valueOf('\uf025')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-volume-off", Character.valueOf('\uf026')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-volume-down", Character.valueOf('\uf027')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-volume-up", Character.valueOf('\uf028')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-qrcode", Character.valueOf('\uf029')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-barcode", Character.valueOf('\uf02a')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-tag", Character.valueOf('\uf02b')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-tags", Character.valueOf('\uf02c')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-book", Character.valueOf('\uf02d')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-bookmark", Character.valueOf('\uf02e')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-print", Character.valueOf('\uf02f')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-camera", Character.valueOf('\uf030')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-font", Character.valueOf('\uf031')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-bold", Character.valueOf('\uf032')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-italic", Character.valueOf('\uf033')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-text-height", Character.valueOf('\uf034')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-text-width", Character.valueOf('\uf035')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-align-left", Character.valueOf('\uf036')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-align-center", Character.valueOf('\uf037')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-align-right", Character.valueOf('\uf038')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-align-justify", Character.valueOf('\uf039')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-list", Character.valueOf('\uf03a')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-outdent", Character.valueOf('\uf03b')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-dedent", Character.valueOf('\uf03b')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-indent", Character.valueOf('\uf03c')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-video-camera", Character.valueOf('\uf03d')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-image", Character.valueOf('\uf03e')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-photo", Character.valueOf('\uf03e')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-picture-o", Character.valueOf('\uf03e')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-pencil", Character.valueOf('\uf040')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-map-marker", Character.valueOf('\uf041')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-adjust", Character.valueOf('\uf042')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-tint", Character.valueOf('\uf043')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-edit", Character.valueOf('\uf044')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-pencil-square-o", Character.valueOf('\uf044')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-share-square-o", Character.valueOf('\uf045')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-check-square-o", Character.valueOf('\uf046')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-arrows", Character.valueOf('\uf047')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-step-backward", Character.valueOf('\uf048')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-fast-backward", Character.valueOf('\uf049')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-backward", Character.valueOf('\uf04a')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-play", Character.valueOf('\uf04b')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-pause", Character.valueOf('\uf04c')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-stop", Character.valueOf('\uf04d')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-forward", Character.valueOf('\uf04e')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-fast-forward", Character.valueOf('\uf050')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-step-forward", Character.valueOf('\uf051')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-eject", Character.valueOf('\uf052')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-chevron-left", Character.valueOf('\uf053')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-chevron-right", Character.valueOf('\uf054')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-plus-circle", Character.valueOf('\uf055')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-minus-circle", Character.valueOf('\uf056')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-times-circle", Character.valueOf('\uf057')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-check-circle", Character.valueOf('\uf058')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-question-circle", Character.valueOf('\uf059')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-info-circle", Character.valueOf('\uf05a')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-crosshairs", Character.valueOf('\uf05b')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-times-circle-o", Character.valueOf('\uf05c')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-check-circle-o", Character.valueOf('\uf05d')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-ban", Character.valueOf('\uf05e')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-arrow-left", Character.valueOf('\uf060')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-arrow-right", Character.valueOf('\uf061')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-arrow-up", Character.valueOf('\uf062')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-arrow-down", Character.valueOf('\uf063')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-mail-forward", Character.valueOf('\uf064')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-share", Character.valueOf('\uf064')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-expand", Character.valueOf('\uf065')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-compress", Character.valueOf('\uf066')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-plus", Character.valueOf('\uf067')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-minus", Character.valueOf('\uf068')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-asterisk", Character.valueOf('\uf069')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-exclamation-circle", Character.valueOf('\uf06a')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-gift", Character.valueOf('\uf06b')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-leaf", Character.valueOf('\uf06c')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-fire", Character.valueOf('\uf06d')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-eye", Character.valueOf('\uf06e')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-eye-slash", Character.valueOf('\uf070')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-warning", Character.valueOf('\uf071')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-exclamation-triangle", Character.valueOf('\uf071')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-plane", Character.valueOf('\uf072')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-calendar", Character.valueOf('\uf073')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-random", Character.valueOf('\uf074')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-comment", Character.valueOf('\uf075')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-magnet", Character.valueOf('\uf076')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-chevron-up", Character.valueOf('\uf077')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-chevron-down", Character.valueOf('\uf078')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-retweet", Character.valueOf('\uf079')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-shopping-cart", Character.valueOf('\uf07a')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-folder", Character.valueOf('\uf07b')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-folder-open", Character.valueOf('\uf07c')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-arrows-v", Character.valueOf('\uf07d')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-arrows-h", Character.valueOf('\uf07e')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-bar-chart", Character.valueOf('\uf080')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-bar-chart-o", Character.valueOf('\uf080')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-twitter-square", Character.valueOf('\uf081')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-facebook-square", Character.valueOf('\uf082')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-camera-retro", Character.valueOf('\uf083')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-key", Character.valueOf('\uf084')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-gears", Character.valueOf('\uf085')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-cogs", Character.valueOf('\uf085')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-comments", Character.valueOf('\uf086')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-thumbs-o-up", Character.valueOf('\uf087')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-thumbs-o-down", Character.valueOf('\uf088')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-star-half", Character.valueOf('\uf089')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-heart-o", Character.valueOf('\uf08a')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-sign-out", Character.valueOf('\uf08b')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-linkedin-square", Character.valueOf('\uf08c')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-thumb-tack", Character.valueOf('\uf08d')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-external-link", Character.valueOf('\uf08e')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-sign-in", Character.valueOf('\uf090')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-trophy", Character.valueOf('\uf091')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-github-square", Character.valueOf('\uf092')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-upload", Character.valueOf('\uf093')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-lemon-o", Character.valueOf('\uf094')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-phone", Character.valueOf('\uf095')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-square-o", Character.valueOf('\uf096')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-bookmark-o", Character.valueOf('\uf097')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-phone-square", Character.valueOf('\uf098')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-twitter", Character.valueOf('\uf099')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-facebook-f", Character.valueOf('\uf09a')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-facebook", Character.valueOf('\uf09a')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-github", Character.valueOf('\uf09b')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-unlock", Character.valueOf('\uf09c')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-credit-card", Character.valueOf('\uf09d')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-feed", Character.valueOf('\uf09e')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-rss", Character.valueOf('\uf09e')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-hdd-o", Character.valueOf('\uf0a0')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-bullhorn", Character.valueOf('\uf0a1')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-bell-o", Character.valueOf('\uf0a2')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-certificate", Character.valueOf('\uf0a3')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-hand-o-right", Character.valueOf('\uf0a4')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-hand-o-left", Character.valueOf('\uf0a5')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-hand-o-up", Character.valueOf('\uf0a6')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-hand-o-down", Character.valueOf('\uf0a7')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-arrow-circle-left", Character.valueOf('\uf0a8')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-arrow-circle-right", Character.valueOf('\uf0a9')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-arrow-circle-up", Character.valueOf('\uf0aa')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-arrow-circle-down", Character.valueOf('\uf0ab')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-globe", Character.valueOf('\uf0ac')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-wrench", Character.valueOf('\uf0ad')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-tasks", Character.valueOf('\uf0ae')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-filter", Character.valueOf('\uf0b0')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-briefcase", Character.valueOf('\uf0b1')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-arrows-alt", Character.valueOf('\uf0b2')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-users", Character.valueOf('\uf0c0')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-group", Character.valueOf('\uf0c0')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-link", Character.valueOf('\uf0c1')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-chain", Character.valueOf('\uf0c1')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-cloud", Character.valueOf('\uf0c2')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-flask", Character.valueOf('\uf0c3')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-cut", Character.valueOf('\uf0c4')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-scissors", Character.valueOf('\uf0c4')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-files-o", Character.valueOf('\uf0c5')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-copy", Character.valueOf('\uf0c5')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-paperclip", Character.valueOf('\uf0c6')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-save", Character.valueOf('\uf0c7')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-floppy-o", Character.valueOf('\uf0c7')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-square", Character.valueOf('\uf0c8')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-navicon", Character.valueOf('\uf0c9')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-reorder", Character.valueOf('\uf0c9')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-bars", Character.valueOf('\uf0c9')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-list-ul", Character.valueOf('\uf0ca')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-list-ol", Character.valueOf('\uf0cb')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-strikethrough", Character.valueOf('\uf0cc')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-underline", Character.valueOf('\uf0cd')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-table", Character.valueOf('\uf0ce')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-magic", Character.valueOf('\uf0d0')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-truck", Character.valueOf('\uf0d1')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-pinterest", Character.valueOf('\uf0d2')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-pinterest-square", Character.valueOf('\uf0d3')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-google-plus-square", Character.valueOf('\uf0d4')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-google-plus", Character.valueOf('\uf0d5')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-money", Character.valueOf('\uf0d6')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-caret-down", Character.valueOf('\uf0d7')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-caret-up", Character.valueOf('\uf0d8')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-caret-left", Character.valueOf('\uf0d9')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-caret-right", Character.valueOf('\uf0da')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-columns", Character.valueOf('\uf0db')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-sort", Character.valueOf('\uf0dc')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-unsorted", Character.valueOf('\uf0dc')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-sort-down", Character.valueOf('\uf0dd')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-sort-desc", Character.valueOf('\uf0dd')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-sort-up", Character.valueOf('\uf0de')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-sort-asc", Character.valueOf('\uf0de')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-envelope", Character.valueOf('\uf0e0')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-linkedin", Character.valueOf('\uf0e1')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-undo", Character.valueOf('\uf0e2')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-rotate-left", Character.valueOf('\uf0e2')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-gavel", Character.valueOf('\uf0e3')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-legal", Character.valueOf('\uf0e3')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-dashboard", Character.valueOf('\uf0e4')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-tachometer", Character.valueOf('\uf0e4')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-comment-o", Character.valueOf('\uf0e5')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-comments-o", Character.valueOf('\uf0e6')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-flash", Character.valueOf('\uf0e7')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-bolt", Character.valueOf('\uf0e7')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-sitemap", Character.valueOf('\uf0e8')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-umbrella", Character.valueOf('\uf0e9')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-paste", Character.valueOf('\uf0ea')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-clipboard", Character.valueOf('\uf0ea')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-lightbulb-o", Character.valueOf('\uf0eb')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-exchange", Character.valueOf('\uf0ec')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-cloud-download", Character.valueOf('\uf0ed')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-cloud-upload", Character.valueOf('\uf0ee')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-user-md", Character.valueOf('\uf0f0')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-stethoscope", Character.valueOf('\uf0f1')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-suitcase", Character.valueOf('\uf0f2')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-bell", Character.valueOf('\uf0f3')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-coffee", Character.valueOf('\uf0f4')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-cutlery", Character.valueOf('\uf0f5')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-file-text-o", Character.valueOf('\uf0f6')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-building-o", Character.valueOf('\uf0f7')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-hospital-o", Character.valueOf('\uf0f8')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-ambulance", Character.valueOf('\uf0f9')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-medkit", Character.valueOf('\uf0fa')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-fighter-jet", Character.valueOf('\uf0fb')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-beer", Character.valueOf('\uf0fc')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-h-square", Character.valueOf('\uf0fd')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-plus-square", Character.valueOf('\uf0fe')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-angle-double-left", Character.valueOf('\uf100')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-angle-double-right", Character.valueOf('\uf101')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-angle-double-up", Character.valueOf('\uf102')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-angle-double-down", Character.valueOf('\uf103')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-angle-left", Character.valueOf('\uf104')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-angle-right", Character.valueOf('\uf105')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-angle-up", Character.valueOf('\uf106')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-angle-down", Character.valueOf('\uf107')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-desktop", Character.valueOf('\uf108')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-laptop", Character.valueOf('\uf109')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-tablet", Character.valueOf('\uf10a')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-mobile", Character.valueOf('\uf10b')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-mobile-phone", Character.valueOf('\uf10b')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-circle-o", Character.valueOf('\uf10c')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-quote-left", Character.valueOf('\uf10d')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-quote-right", Character.valueOf('\uf10e')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-spinner", Character.valueOf('\uf110')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-circle", Character.valueOf('\uf111')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-mail-reply", Character.valueOf('\uf112')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-reply", Character.valueOf('\uf112')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-github-alt", Character.valueOf('\uf113')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-folder-o", Character.valueOf('\uf114')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-folder-open-o", Character.valueOf('\uf115')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-smile-o", Character.valueOf('\uf118')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-frown-o", Character.valueOf('\uf119')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-meh-o", Character.valueOf('\uf11a')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-gamepad", Character.valueOf('\uf11b')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-keyboard-o", Character.valueOf('\uf11c')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-flag-o", Character.valueOf('\uf11d')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-flag-checkered", Character.valueOf('\uf11e')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-terminal", Character.valueOf('\uf120')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-code", Character.valueOf('\uf121')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-mail-reply-all", Character.valueOf('\uf122')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-reply-all", Character.valueOf('\uf122')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-star-half-o", Character.valueOf('\uf123')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-star-half-full", Character.valueOf('\uf123')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-star-half-empty", Character.valueOf('\uf123')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-location-arrow", Character.valueOf('\uf124')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-crop", Character.valueOf('\uf125')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-code-fork", Character.valueOf('\uf126')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-unlink", Character.valueOf('\uf127')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-chain-broken", Character.valueOf('\uf127')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-question", Character.valueOf('\uf128')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-info", Character.valueOf('\uf129')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-exclamation", Character.valueOf('\uf12a')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-superscript", Character.valueOf('\uf12b')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-subscript", Character.valueOf('\uf12c')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-eraser", Character.valueOf('\uf12d')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-puzzle-piece", Character.valueOf('\uf12e')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-microphone", Character.valueOf('\uf130')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-microphone-slash", Character.valueOf('\uf131')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-shield", Character.valueOf('\uf132')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-calendar-o", Character.valueOf('\uf133')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-fire-extinguisher", Character.valueOf('\uf134')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-rocket", Character.valueOf('\uf135')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-maxcdn", Character.valueOf('\uf136')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-chevron-circle-left", Character.valueOf('\uf137')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-chevron-circle-right", Character.valueOf('\uf138')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-chevron-circle-up", Character.valueOf('\uf139')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-chevron-circle-down", Character.valueOf('\uf13a')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-html5", Character.valueOf('\uf13b')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-css3", Character.valueOf('\uf13c')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-anchor", Character.valueOf('\uf13d')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-unlock-alt", Character.valueOf('\uf13e')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-bullseye", Character.valueOf('\uf140')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-ellipsis-h", Character.valueOf('\uf141')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-ellipsis-v", Character.valueOf('\uf142')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-rss-square", Character.valueOf('\uf143')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-play-circle", Character.valueOf('\uf144')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-ticket", Character.valueOf('\uf145')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-minus-square", Character.valueOf('\uf146')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-minus-square-o", Character.valueOf('\uf147')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-level-up", Character.valueOf('\uf148')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-level-down", Character.valueOf('\uf149')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-check-square", Character.valueOf('\uf14a')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-pencil-square", Character.valueOf('\uf14b')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-external-link-square", Character.valueOf('\uf14c')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-share-square", Character.valueOf('\uf14d')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-compass", Character.valueOf('\uf14e')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-caret-square-o-down", Character.valueOf('\uf150')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-toggle-down", Character.valueOf('\uf150')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-toggle-up", Character.valueOf('\uf151')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-caret-square-o-up", Character.valueOf('\uf151')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-caret-square-o-right", Character.valueOf('\uf152')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-toggle-right", Character.valueOf('\uf152')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-eur", Character.valueOf('\uf153')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-euro", Character.valueOf('\uf153')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-gbp", Character.valueOf('\uf154')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-usd", Character.valueOf('\uf155')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-dollar", Character.valueOf('\uf155')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-inr", Character.valueOf('\uf156')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-rupee", Character.valueOf('\uf156')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-jpy", Character.valueOf('\uf157')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-yen", Character.valueOf('\uf157')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-rmb", Character.valueOf('\uf157')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-cny", Character.valueOf('\uf157')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-rub", Character.valueOf('\uf158')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-rouble", Character.valueOf('\uf158')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-ruble", Character.valueOf('\uf158')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-krw", Character.valueOf('\uf159')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-won", Character.valueOf('\uf159')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-btc", Character.valueOf('\uf15a')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-bitcoin", Character.valueOf('\uf15a')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-file", Character.valueOf('\uf15b')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-file-text", Character.valueOf('\uf15c')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-sort-alpha-asc", Character.valueOf('\uf15d')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-sort-alpha-desc", Character.valueOf('\uf15e')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-sort-amount-asc", Character.valueOf('\uf160')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-sort-amount-desc", Character.valueOf('\uf161')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-sort-numeric-asc", Character.valueOf('\uf162')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-sort-numeric-desc", Character.valueOf('\uf163')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-thumbs-up", Character.valueOf('\uf164')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-thumbs-down", Character.valueOf('\uf165')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-youtube-square", Character.valueOf('\uf166')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-youtube", Character.valueOf('\uf167')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-xing", Character.valueOf('\uf168')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-xing-square", Character.valueOf('\uf169')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-youtube-play", Character.valueOf('\uf16a')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-dropbox", Character.valueOf('\uf16b')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-stack-overflow", Character.valueOf('\uf16c')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-instagram", Character.valueOf('\uf16d')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-flickr", Character.valueOf('\uf16e')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-adn", Character.valueOf('\uf170')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-bitbucket", Character.valueOf('\uf171')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-bitbucket-square", Character.valueOf('\uf172')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-tumblr", Character.valueOf('\uf173')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-tumblr-square", Character.valueOf('\uf174')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-long-arrow-down", Character.valueOf('\uf175')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-long-arrow-up", Character.valueOf('\uf176')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-long-arrow-left", Character.valueOf('\uf177')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-long-arrow-right", Character.valueOf('\uf178')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-apple", Character.valueOf('\uf179')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-windows", Character.valueOf('\uf17a')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-android", Character.valueOf('\uf17b')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-linux", Character.valueOf('\uf17c')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-dribbble", Character.valueOf('\uf17d')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-skype", Character.valueOf('\uf17e')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-foursquare", Character.valueOf('\uf180')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-trello", Character.valueOf('\uf181')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-female", Character.valueOf('\uf182')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-male", Character.valueOf('\uf183')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-gittip", Character.valueOf('\uf184')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-gratipay", Character.valueOf('\uf184')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-sun-o", Character.valueOf('\uf185')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-moon-o", Character.valueOf('\uf186')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-archive", Character.valueOf('\uf187')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-bug", Character.valueOf('\uf188')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-vk", Character.valueOf('\uf189')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-weibo", Character.valueOf('\uf18a')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-renren", Character.valueOf('\uf18b')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-pagelines", Character.valueOf('\uf18c')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-stack-exchange", Character.valueOf('\uf18d')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-arrow-circle-o-right", Character.valueOf('\uf18e')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-arrow-circle-o-left", Character.valueOf('\uf190')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-caret-square-o-left", Character.valueOf('\uf191')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-toggle-left", Character.valueOf('\uf191')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-dot-circle-o", Character.valueOf('\uf192')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-wheelchair", Character.valueOf('\uf193')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-vimeo-square", Character.valueOf('\uf194')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-turkish-lira", Character.valueOf('\uf195')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-try", Character.valueOf('\uf195')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-plus-square-o", Character.valueOf('\uf196')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-space-shuttle", Character.valueOf('\uf197')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-slack", Character.valueOf('\uf198')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-envelope-square", Character.valueOf('\uf199')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-wordpress", Character.valueOf('\uf19a')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-openid", Character.valueOf('\uf19b')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-university", Character.valueOf('\uf19c')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-institution", Character.valueOf('\uf19c')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-bank", Character.valueOf('\uf19c')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-graduation-cap", Character.valueOf('\uf19d')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-mortar-board", Character.valueOf('\uf19d')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-yahoo", Character.valueOf('\uf19e')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-google", Character.valueOf('\uf1a0')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-reddit", Character.valueOf('\uf1a1')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-reddit-square", Character.valueOf('\uf1a2')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-stumbleupon-circle", Character.valueOf('\uf1a3')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-stumbleupon", Character.valueOf('\uf1a4')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-delicious", Character.valueOf('\uf1a5')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-digg", Character.valueOf('\uf1a6')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-pied-piper", Character.valueOf('\uf1a7')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-pied-piper-alt", Character.valueOf('\uf1a8')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-drupal", Character.valueOf('\uf1a9')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-joomla", Character.valueOf('\uf1aa')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-language", Character.valueOf('\uf1ab')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-fax", Character.valueOf('\uf1ac')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-building", Character.valueOf('\uf1ad')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-child", Character.valueOf('\uf1ae')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-paw", Character.valueOf('\uf1b0')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-spoon", Character.valueOf('\uf1b1')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-cube", Character.valueOf('\uf1b2')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-cubes", Character.valueOf('\uf1b3')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-behance", Character.valueOf('\uf1b4')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-behance-square", Character.valueOf('\uf1b5')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-steam", Character.valueOf('\uf1b6')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-steam-square", Character.valueOf('\uf1b7')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-recycle", Character.valueOf('\uf1b8')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-automobile", Character.valueOf('\uf1b9')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-car", Character.valueOf('\uf1b9')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-taxi", Character.valueOf('\uf1ba')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-cab", Character.valueOf('\uf1ba')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-tree", Character.valueOf('\uf1bb')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-spotify", Character.valueOf('\uf1bc')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-deviantart", Character.valueOf('\uf1bd')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-soundcloud", Character.valueOf('\uf1be')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-database", Character.valueOf('\uf1c0')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-file-pdf-o", Character.valueOf('\uf1c1')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-file-word-o", Character.valueOf('\uf1c2')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-file-excel-o", Character.valueOf('\uf1c3')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-file-powerpoint-o", Character.valueOf('\uf1c4')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-file-image-o", Character.valueOf('\uf1c5')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-file-picture-o", Character.valueOf('\uf1c5')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-file-photo-o", Character.valueOf('\uf1c5')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-file-zip-o", Character.valueOf('\uf1c6')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-file-archive-o", Character.valueOf('\uf1c6')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-file-sound-o", Character.valueOf('\uf1c7')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-file-audio-o", Character.valueOf('\uf1c7')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-file-movie-o", Character.valueOf('\uf1c8')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-file-video-o", Character.valueOf('\uf1c8')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-file-code-o", Character.valueOf('\uf1c9')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-vine", Character.valueOf('\uf1ca')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-codepen", Character.valueOf('\uf1cb')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-jsfiddle", Character.valueOf('\uf1cc')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-life-buoy", Character.valueOf('\uf1cd')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-life-ring", Character.valueOf('\uf1cd')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-life-bouy", Character.valueOf('\uf1cd')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-life-saver", Character.valueOf('\uf1cd')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-support", Character.valueOf('\uf1cd')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-circle-o-notch", Character.valueOf('\uf1ce')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-ra", Character.valueOf('\uf1d0')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-rebel", Character.valueOf('\uf1d0')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-empire", Character.valueOf('\uf1d1')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-ge", Character.valueOf('\uf1d1')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-git-square", Character.valueOf('\uf1d2')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-git", Character.valueOf('\uf1d3')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-hacker-news", Character.valueOf('\uf1d4')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-yc-square", Character.valueOf('\uf1d4')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-y-combinator-square", Character.valueOf('\uf1d4')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-tencent-weibo", Character.valueOf('\uf1d5')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-qq", Character.valueOf('\uf1d6')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-wechat", Character.valueOf('\uf1d7')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-weixin", Character.valueOf('\uf1d7')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-send", Character.valueOf('\uf1d8')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-paper-plane", Character.valueOf('\uf1d8')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-paper-plane-o", Character.valueOf('\uf1d9')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-send-o", Character.valueOf('\uf1d9')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-history", Character.valueOf('\uf1da')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-circle-thin", Character.valueOf('\uf1db')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-header", Character.valueOf('\uf1dc')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-paragraph", Character.valueOf('\uf1dd')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-sliders", Character.valueOf('\uf1de')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-share-alt", Character.valueOf('\uf1e0')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-share-alt-square", Character.valueOf('\uf1e1')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-bomb", Character.valueOf('\uf1e2')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-soccer-ball-o", Character.valueOf('\uf1e3')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-futbol-o", Character.valueOf('\uf1e3')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-tty", Character.valueOf('\uf1e4')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-binoculars", Character.valueOf('\uf1e5')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-plug", Character.valueOf('\uf1e6')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-slideshare", Character.valueOf('\uf1e7')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-twitch", Character.valueOf('\uf1e8')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-yelp", Character.valueOf('\uf1e9')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-newspaper-o", Character.valueOf('\uf1ea')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-wifi", Character.valueOf('\uf1eb')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-calculator", Character.valueOf('\uf1ec')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-paypal", Character.valueOf('\uf1ed')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-google-wallet", Character.valueOf('\uf1ee')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-cc-visa", Character.valueOf('\uf1f0')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-cc-mastercard", Character.valueOf('\uf1f1')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-cc-discover", Character.valueOf('\uf1f2')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-cc-amex", Character.valueOf('\uf1f3')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-cc-paypal", Character.valueOf('\uf1f4')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-cc-stripe", Character.valueOf('\uf1f5')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-bell-slash", Character.valueOf('\uf1f6')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-bell-slash-o", Character.valueOf('\uf1f7')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-trash", Character.valueOf('\uf1f8')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-copyright", Character.valueOf('\uf1f9')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-at", Character.valueOf('\uf1fa')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-eyedropper", Character.valueOf('\uf1fb')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-paint-brush", Character.valueOf('\uf1fc')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-birthday-cake", Character.valueOf('\uf1fd')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-area-chart", Character.valueOf('\uf1fe')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-pie-chart", Character.valueOf('\uf200')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-line-chart", Character.valueOf('\uf201')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-lastfm", Character.valueOf('\uf202')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-lastfm-square", Character.valueOf('\uf203')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-toggle-off", Character.valueOf('\uf204')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-toggle-on", Character.valueOf('\uf205')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-bicycle", Character.valueOf('\uf206')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-bus", Character.valueOf('\uf207')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-ioxhost", Character.valueOf('\uf208')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-angellist", Character.valueOf('\uf209')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-cc", Character.valueOf('\uf20a')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-ils", Character.valueOf('\uf20b')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-sheqel", Character.valueOf('\uf20b')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-shekel", Character.valueOf('\uf20b')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-meanpath", Character.valueOf('\uf20c')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-buysellads", Character.valueOf('\uf20d')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-connectdevelop", Character.valueOf('\uf20e')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-dashcube", Character.valueOf('\uf210')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-forumbee", Character.valueOf('\uf211')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-leanpub", Character.valueOf('\uf212')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-sellsy", Character.valueOf('\uf213')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-shirtsinbulk", Character.valueOf('\uf214')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-simplybuilt", Character.valueOf('\uf215')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-skyatlas", Character.valueOf('\uf216')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-cart-plus", Character.valueOf('\uf217')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-cart-arrow-down", Character.valueOf('\uf218')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-diamond", Character.valueOf('\uf219')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-ship", Character.valueOf('\uf21a')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-user-secret", Character.valueOf('\uf21b')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-motorcycle", Character.valueOf('\uf21c')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-street-view", Character.valueOf('\uf21d')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-heartbeat", Character.valueOf('\uf21e')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-venus", Character.valueOf('\uf221')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-mars", Character.valueOf('\uf222')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-mercury", Character.valueOf('\uf223')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-intersex", Character.valueOf('\uf224')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-transgender", Character.valueOf('\uf224')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-transgender-alt", Character.valueOf('\uf225')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-venus-double", Character.valueOf('\uf226')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-mars-double", Character.valueOf('\uf227')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-venus-mars", Character.valueOf('\uf228')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-mars-stroke", Character.valueOf('\uf229')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-mars-stroke-v", Character.valueOf('\uf22a')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-mars-stroke-h", Character.valueOf('\uf22b')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-neuter", Character.valueOf('\uf22c')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-genderless", Character.valueOf('\uf22d')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-facebook-official", Character.valueOf('\uf230')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-pinterest-p", Character.valueOf('\uf231')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-whatsapp", Character.valueOf('\uf232')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-server", Character.valueOf('\uf233')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-user-plus", Character.valueOf('\uf234')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-user-times", Character.valueOf('\uf235')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-bed", Character.valueOf('\uf236')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-hotel", Character.valueOf('\uf236')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-viacoin", Character.valueOf('\uf237')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-train", Character.valueOf('\uf238')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-subway", Character.valueOf('\uf239')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-medium", Character.valueOf('\uf23a')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-yc", Character.valueOf('\uf23b')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-y-combinator", Character.valueOf('\uf23b')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-optin-monster", Character.valueOf('\uf23c')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-opencart", Character.valueOf('\uf23d')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-expeditedssl", Character.valueOf('\uf23e')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-battery-full", Character.valueOf('\uf240')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-battery-4", Character.valueOf('\uf240')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-battery-three-quarters", Character.valueOf('\uf241')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-battery-3", Character.valueOf('\uf241')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-battery-half", Character.valueOf('\uf242')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-battery-2", Character.valueOf('\uf242')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-battery-quarter", Character.valueOf('\uf243')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-battery-1", Character.valueOf('\uf243')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-battery-empty", Character.valueOf('\uf244')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-battery-0", Character.valueOf('\uf244')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-mouse-pointer", Character.valueOf('\uf245')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-i-cursor", Character.valueOf('\uf246')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-object-group", Character.valueOf('\uf247')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-object-ungroup", Character.valueOf('\uf248')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-sticky-note", Character.valueOf('\uf249')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-sticky-note-o", Character.valueOf('\uf24a')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-cc-jcb", Character.valueOf('\uf24b')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-cc-diners-club", Character.valueOf('\uf24c')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-clone", Character.valueOf('\uf24d')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-balance-scale", Character.valueOf('\uf24e')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-hourglass-o", Character.valueOf('\uf250')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-hourglass-1", Character.valueOf('\uf251')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-hourglass-start", Character.valueOf('\uf251')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-hourglass-2", Character.valueOf('\uf252')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-hourglass-half", Character.valueOf('\uf252')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-hourglass-3", Character.valueOf('\uf253')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-hourglass-end", Character.valueOf('\uf253')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-hourglass", Character.valueOf('\uf254')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-hand-rock-o", Character.valueOf('\uf255')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-hand-grab-o", Character.valueOf('\uf255')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-hand-paper-o", Character.valueOf('\uf256')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-hand-stop-o", Character.valueOf('\uf256')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-hand-scissors-o", Character.valueOf('\uf257')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-hand-lizard-o", Character.valueOf('\uf258')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-hand-spock-o", Character.valueOf('\uf259')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-hand-pointer-o", Character.valueOf('\uf25a')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-hand-peace-o", Character.valueOf('\uf25b')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-trademark", Character.valueOf('\uf25c')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-registered", Character.valueOf('\uf25d')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-creative-commons", Character.valueOf('\uf25e')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-gg", Character.valueOf('\uf260')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-gg-circle", Character.valueOf('\uf261')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-tripadvisor", Character.valueOf('\uf262')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-odnoklassniki", Character.valueOf('\uf263')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-odnoklassniki-square", Character.valueOf('\uf264')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-get-pocket", Character.valueOf('\uf265')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-wikipedia-w", Character.valueOf('\uf266')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-safari", Character.valueOf('\uf267')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-chrome", Character.valueOf('\uf268')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-firefox", Character.valueOf('\uf269')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-opera", Character.valueOf('\uf26a')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-internet-explorer", Character.valueOf('\uf26b')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-television", Character.valueOf('\uf26c')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-tv", Character.valueOf('\uf26c')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-contao", Character.valueOf('\uf26d')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-500px", Character.valueOf('\uf26e')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-amazon", Character.valueOf('\uf270')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-calendar-plus-o", Character.valueOf('\uf271')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-calendar-minus-o", Character.valueOf('\uf272')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-calendar-times-o", Character.valueOf('\uf273')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-calendar-check-o", Character.valueOf('\uf274')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-industry", Character.valueOf('\uf275')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-map-pin", Character.valueOf('\uf276')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-map-signs", Character.valueOf('\uf277')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-map-o", Character.valueOf('\uf278')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-map", Character.valueOf('\uf279')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-commenting", Character.valueOf('\uf27a')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-commenting-o", Character.valueOf('\uf27b')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-houzz", Character.valueOf('\uf27c')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-vimeo", Character.valueOf('\uf27d')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-black-tie", Character.valueOf('\uf27e')); //$NON-NLS-1$
		NAME_TO_CHAR.put("fa-fonticons", Character.valueOf('\uf280')); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_GLASS() {
		return FontIcon.create("fa-glass").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_MUSIC() {
		return FontIcon.create("fa-music").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_SEARCH() {
		return FontIcon.create("fa-search").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_ENVELOPE_O() {
		return FontIcon.create("fa-envelope-o").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_HEART() {
		return FontIcon.create("fa-heart").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_STAR() {
		return FontIcon.create("fa-star").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_STAR_O() {
		return FontIcon.create("fa-star-o").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_USER() {
		return FontIcon.create("fa-user").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_FILM() {
		return FontIcon.create("fa-film").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_TH_LARGE() {
		return FontIcon.create("fa-th-large").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_TH() {
		return FontIcon.create("fa-th").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_TH_LIST() {
		return FontIcon.create("fa-th-list").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_CHECK() {
		return FontIcon.create("fa-check").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_REMOVE() {
		return FontIcon.create("fa-remove").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_TIMES() {
		return FontIcon.create("fa-times").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_CLOSE() {
		return FontIcon.create("fa-close").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_SEARCH_PLUS() {
		return FontIcon.create("fa-search-plus").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_SEARCH_MINUS() {
		return FontIcon.create("fa-search-minus").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_POWER_OFF() {
		return FontIcon.create("fa-power-off").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_SIGNAL() {
		return FontIcon.create("fa-signal").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_GEAR() {
		return FontIcon.create("fa-gear").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_COG() {
		return FontIcon.create("fa-cog").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_TRASH_O() {
		return FontIcon.create("fa-trash-o").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_HOME() {
		return FontIcon.create("fa-home").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_FILE_O() {
		return FontIcon.create("fa-file-o").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_CLOCK_O() {
		return FontIcon.create("fa-clock-o").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_ROAD() {
		return FontIcon.create("fa-road").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_DOWNLOAD() {
		return FontIcon.create("fa-download").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_ARROW_CIRCLE_O_DOWN() {
		return FontIcon.create("fa-arrow-circle-o-down").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_ARROW_CIRCLE_O_UP() {
		return FontIcon.create("fa-arrow-circle-o-up").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_INBOX() {
		return FontIcon.create("fa-inbox").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_PLAY_CIRCLE_O() {
		return FontIcon.create("fa-play-circle-o").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_ROTATE_RIGHT() {
		return FontIcon.create("fa-rotate-right").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_REPEAT() {
		return FontIcon.create("fa-repeat").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_REFRESH() {
		return FontIcon.create("fa-refresh").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_LIST_ALT() {
		return FontIcon.create("fa-list-alt").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_LOCK() {
		return FontIcon.create("fa-lock").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_FLAG() {
		return FontIcon.create("fa-flag").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_HEADPHONES() {
		return FontIcon.create("fa-headphones").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_VOLUME_OFF() {
		return FontIcon.create("fa-volume-off").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_VOLUME_DOWN() {
		return FontIcon.create("fa-volume-down").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_VOLUME_UP() {
		return FontIcon.create("fa-volume-up").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_QRCODE() {
		return FontIcon.create("fa-qrcode").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_BARCODE() {
		return FontIcon.create("fa-barcode").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_TAG() {
		return FontIcon.create("fa-tag").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_TAGS() {
		return FontIcon.create("fa-tags").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_BOOK() {
		return FontIcon.create("fa-book").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_BOOKMARK() {
		return FontIcon.create("fa-bookmark").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_PRINT() {
		return FontIcon.create("fa-print").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_CAMERA() {
		return FontIcon.create("fa-camera").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_FONT() {
		return FontIcon.create("fa-font").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_BOLD() {
		return FontIcon.create("fa-bold").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_ITALIC() {
		return FontIcon.create("fa-italic").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_TEXT_HEIGHT() {
		return FontIcon.create("fa-text-height").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_TEXT_WIDTH() {
		return FontIcon.create("fa-text-width").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_ALIGN_LEFT() {
		return FontIcon.create("fa-align-left").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_ALIGN_CENTER() {
		return FontIcon.create("fa-align-center").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_ALIGN_RIGHT() {
		return FontIcon.create("fa-align-right").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_ALIGN_JUSTIFY() {
		return FontIcon.create("fa-align-justify").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_LIST() {
		return FontIcon.create("fa-list").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_OUTDENT() {
		return FontIcon.create("fa-outdent").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_DEDENT() {
		return FontIcon.create("fa-dedent").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_INDENT() {
		return FontIcon.create("fa-indent").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_VIDEO_CAMERA() {
		return FontIcon.create("fa-video-camera").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_IMAGE() {
		return FontIcon.create("fa-image").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_PHOTO() {
		return FontIcon.create("fa-photo").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_PICTURE_O() {
		return FontIcon.create("fa-picture-o").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_PENCIL() {
		return FontIcon.create("fa-pencil").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_MAP_MARKER() {
		return FontIcon.create("fa-map-marker").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_ADJUST() {
		return FontIcon.create("fa-adjust").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_TINT() {
		return FontIcon.create("fa-tint").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_EDIT() {
		return FontIcon.create("fa-edit").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_PENCIL_SQUARE_O() {
		return FontIcon.create("fa-pencil-square-o").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_SHARE_SQUARE_O() {
		return FontIcon.create("fa-share-square-o").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_CHECK_SQUARE_O() {
		return FontIcon.create("fa-check-square-o").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_ARROWS() {
		return FontIcon.create("fa-arrows").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_STEP_BACKWARD() {
		return FontIcon.create("fa-step-backward").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_FAST_BACKWARD() {
		return FontIcon.create("fa-fast-backward").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_BACKWARD() {
		return FontIcon.create("fa-backward").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_PLAY() {
		return FontIcon.create("fa-play").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_PAUSE() {
		return FontIcon.create("fa-pause").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_STOP() {
		return FontIcon.create("fa-stop").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_FORWARD() {
		return FontIcon.create("fa-forward").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_FAST_FORWARD() {
		return FontIcon.create("fa-fast-forward").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_STEP_FORWARD() {
		return FontIcon.create("fa-step-forward").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_EJECT() {
		return FontIcon.create("fa-eject").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_CHEVRON_LEFT() {
		return FontIcon.create("fa-chevron-left").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_CHEVRON_RIGHT() {
		return FontIcon.create("fa-chevron-right").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_PLUS_CIRCLE() {
		return FontIcon.create("fa-plus-circle").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_MINUS_CIRCLE() {
		return FontIcon.create("fa-minus-circle").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_TIMES_CIRCLE() {
		return FontIcon.create("fa-times-circle").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_CHECK_CIRCLE() {
		return FontIcon.create("fa-check-circle").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_QUESTION_CIRCLE() {
		return FontIcon.create("fa-question-circle").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_INFO_CIRCLE() {
		return FontIcon.create("fa-info-circle").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_CROSSHAIRS() {
		return FontIcon.create("fa-crosshairs").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_TIMES_CIRCLE_O() {
		return FontIcon.create("fa-times-circle-o").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_CHECK_CIRCLE_O() {
		return FontIcon.create("fa-check-circle-o").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_BAN() {
		return FontIcon.create("fa-ban").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_ARROW_LEFT() {
		return FontIcon.create("fa-arrow-left").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_ARROW_RIGHT() {
		return FontIcon.create("fa-arrow-right").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_ARROW_UP() {
		return FontIcon.create("fa-arrow-up").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_ARROW_DOWN() {
		return FontIcon.create("fa-arrow-down").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_MAIL_FORWARD() {
		return FontIcon.create("fa-mail-forward").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_SHARE() {
		return FontIcon.create("fa-share").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_EXPAND() {
		return FontIcon.create("fa-expand").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_COMPRESS() {
		return FontIcon.create("fa-compress").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_PLUS() {
		return FontIcon.create("fa-plus").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_MINUS() {
		return FontIcon.create("fa-minus").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_ASTERISK() {
		return FontIcon.create("fa-asterisk").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_EXCLAMATION_CIRCLE() {
		return FontIcon.create("fa-exclamation-circle").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_GIFT() {
		return FontIcon.create("fa-gift").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_LEAF() {
		return FontIcon.create("fa-leaf").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_FIRE() {
		return FontIcon.create("fa-fire").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_EYE() {
		return FontIcon.create("fa-eye").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_EYE_SLASH() {
		return FontIcon.create("fa-eye-slash").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_WARNING() {
		return FontIcon.create("fa-warning").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_EXCLAMATION_TRIANGLE() {
		return FontIcon.create("fa-exclamation-triangle").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_PLANE() {
		return FontIcon.create("fa-plane").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_CALENDAR() {
		return FontIcon.create("fa-calendar").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_RANDOM() {
		return FontIcon.create("fa-random").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_COMMENT() {
		return FontIcon.create("fa-comment").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_MAGNET() {
		return FontIcon.create("fa-magnet").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_CHEVRON_UP() {
		return FontIcon.create("fa-chevron-up").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_CHEVRON_DOWN() {
		return FontIcon.create("fa-chevron-down").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_RETWEET() {
		return FontIcon.create("fa-retweet").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_SHOPPING_CART() {
		return FontIcon.create("fa-shopping-cart").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_FOLDER() {
		return FontIcon.create("fa-folder").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_FOLDER_OPEN() {
		return FontIcon.create("fa-folder-open").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_ARROWS_V() {
		return FontIcon.create("fa-arrows-v").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_ARROWS_H() {
		return FontIcon.create("fa-arrows-h").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_BAR_CHART() {
		return FontIcon.create("fa-bar-chart").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_BAR_CHART_O() {
		return FontIcon.create("fa-bar-chart-o").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_TWITTER_SQUARE() {
		return FontIcon.create("fa-twitter-square").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_FACEBOOK_SQUARE() {
		return FontIcon.create("fa-facebook-square").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_CAMERA_RETRO() {
		return FontIcon.create("fa-camera-retro").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_KEY() {
		return FontIcon.create("fa-key").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_GEARS() {
		return FontIcon.create("fa-gears").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_COGS() {
		return FontIcon.create("fa-cogs").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_COMMENTS() {
		return FontIcon.create("fa-comments").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_THUMBS_O_UP() {
		return FontIcon.create("fa-thumbs-o-up").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_THUMBS_O_DOWN() {
		return FontIcon.create("fa-thumbs-o-down").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_STAR_HALF() {
		return FontIcon.create("fa-star-half").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_HEART_O() {
		return FontIcon.create("fa-heart-o").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_SIGN_OUT() {
		return FontIcon.create("fa-sign-out").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_LINKEDIN_SQUARE() {
		return FontIcon.create("fa-linkedin-square").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_THUMB_TACK() {
		return FontIcon.create("fa-thumb-tack").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_EXTERNAL_LINK() {
		return FontIcon.create("fa-external-link").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_SIGN_IN() {
		return FontIcon.create("fa-sign-in").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_TROPHY() {
		return FontIcon.create("fa-trophy").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_GITHUB_SQUARE() {
		return FontIcon.create("fa-github-square").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_UPLOAD() {
		return FontIcon.create("fa-upload").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_LEMON_O() {
		return FontIcon.create("fa-lemon-o").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_PHONE() {
		return FontIcon.create("fa-phone").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_SQUARE_O() {
		return FontIcon.create("fa-square-o").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_BOOKMARK_O() {
		return FontIcon.create("fa-bookmark-o").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_PHONE_SQUARE() {
		return FontIcon.create("fa-phone-square").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_TWITTER() {
		return FontIcon.create("fa-twitter").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_FACEBOOK_F() {
		return FontIcon.create("fa-facebook-f").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_FACEBOOK() {
		return FontIcon.create("fa-facebook").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_GITHUB() {
		return FontIcon.create("fa-github").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_UNLOCK() {
		return FontIcon.create("fa-unlock").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_CREDIT_CARD() {
		return FontIcon.create("fa-credit-card").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_FEED() {
		return FontIcon.create("fa-feed").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_RSS() {
		return FontIcon.create("fa-rss").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_HDD_O() {
		return FontIcon.create("fa-hdd-o").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_BULLHORN() {
		return FontIcon.create("fa-bullhorn").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_BELL_O() {
		return FontIcon.create("fa-bell-o").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_CERTIFICATE() {
		return FontIcon.create("fa-certificate").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_HAND_O_RIGHT() {
		return FontIcon.create("fa-hand-o-right").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_HAND_O_LEFT() {
		return FontIcon.create("fa-hand-o-left").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_HAND_O_UP() {
		return FontIcon.create("fa-hand-o-up").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_HAND_O_DOWN() {
		return FontIcon.create("fa-hand-o-down").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_ARROW_CIRCLE_LEFT() {
		return FontIcon.create("fa-arrow-circle-left").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_ARROW_CIRCLE_RIGHT() {
		return FontIcon.create("fa-arrow-circle-right").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_ARROW_CIRCLE_UP() {
		return FontIcon.create("fa-arrow-circle-up").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_ARROW_CIRCLE_DOWN() {
		return FontIcon.create("fa-arrow-circle-down").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_GLOBE() {
		return FontIcon.create("fa-globe").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_WRENCH() {
		return FontIcon.create("fa-wrench").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_TASKS() {
		return FontIcon.create("fa-tasks").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_FILTER() {
		return FontIcon.create("fa-filter").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_BRIEFCASE() {
		return FontIcon.create("fa-briefcase").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_ARROWS_ALT() {
		return FontIcon.create("fa-arrows-alt").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_USERS() {
		return FontIcon.create("fa-users").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_GROUP() {
		return FontIcon.create("fa-group").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_LINK() {
		return FontIcon.create("fa-link").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_CHAIN() {
		return FontIcon.create("fa-chain").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_CLOUD() {
		return FontIcon.create("fa-cloud").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_FLASK() {
		return FontIcon.create("fa-flask").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_CUT() {
		return FontIcon.create("fa-cut").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_SCISSORS() {
		return FontIcon.create("fa-scissors").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_FILES_O() {
		return FontIcon.create("fa-files-o").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_COPY() {
		return FontIcon.create("fa-copy").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_PAPERCLIP() {
		return FontIcon.create("fa-paperclip").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_SAVE() {
		return FontIcon.create("fa-save").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_FLOPPY_O() {
		return FontIcon.create("fa-floppy-o").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_SQUARE() {
		return FontIcon.create("fa-square").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_NAVICON() {
		return FontIcon.create("fa-navicon").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_REORDER() {
		return FontIcon.create("fa-reorder").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_BARS() {
		return FontIcon.create("fa-bars").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_LIST_UL() {
		return FontIcon.create("fa-list-ul").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_LIST_OL() {
		return FontIcon.create("fa-list-ol").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_STRIKETHROUGH() {
		return FontIcon.create("fa-strikethrough").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_UNDERLINE() {
		return FontIcon.create("fa-underline").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_TABLE() {
		return FontIcon.create("fa-table").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_MAGIC() {
		return FontIcon.create("fa-magic").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_TRUCK() {
		return FontIcon.create("fa-truck").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_PINTEREST() {
		return FontIcon.create("fa-pinterest").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_PINTEREST_SQUARE() {
		return FontIcon.create("fa-pinterest-square").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_GOOGLE_PLUS_SQUARE() {
		return FontIcon.create("fa-google-plus-square").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_GOOGLE_PLUS() {
		return FontIcon.create("fa-google-plus").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_MONEY() {
		return FontIcon.create("fa-money").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_CARET_DOWN() {
		return FontIcon.create("fa-caret-down").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_CARET_UP() {
		return FontIcon.create("fa-caret-up").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_CARET_LEFT() {
		return FontIcon.create("fa-caret-left").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_CARET_RIGHT() {
		return FontIcon.create("fa-caret-right").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_COLUMNS() {
		return FontIcon.create("fa-columns").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_SORT() {
		return FontIcon.create("fa-sort").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_UNSORTED() {
		return FontIcon.create("fa-unsorted").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_SORT_DOWN() {
		return FontIcon.create("fa-sort-down").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_SORT_DESC() {
		return FontIcon.create("fa-sort-desc").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_SORT_UP() {
		return FontIcon.create("fa-sort-up").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_SORT_ASC() {
		return FontIcon.create("fa-sort-asc").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_ENVELOPE() {
		return FontIcon.create("fa-envelope").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_LINKEDIN() {
		return FontIcon.create("fa-linkedin").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_UNDO() {
		return FontIcon.create("fa-undo").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_ROTATE_LEFT() {
		return FontIcon.create("fa-rotate-left").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_GAVEL() {
		return FontIcon.create("fa-gavel").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_LEGAL() {
		return FontIcon.create("fa-legal").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_DASHBOARD() {
		return FontIcon.create("fa-dashboard").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_TACHOMETER() {
		return FontIcon.create("fa-tachometer").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_COMMENT_O() {
		return FontIcon.create("fa-comment-o").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_COMMENTS_O() {
		return FontIcon.create("fa-comments-o").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_FLASH() {
		return FontIcon.create("fa-flash").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_BOLT() {
		return FontIcon.create("fa-bolt").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_SITEMAP() {
		return FontIcon.create("fa-sitemap").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_UMBRELLA() {
		return FontIcon.create("fa-umbrella").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_PASTE() {
		return FontIcon.create("fa-paste").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_CLIPBOARD() {
		return FontIcon.create("fa-clipboard").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_LIGHTBULB_O() {
		return FontIcon.create("fa-lightbulb-o").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_EXCHANGE() {
		return FontIcon.create("fa-exchange").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_CLOUD_DOWNLOAD() {
		return FontIcon.create("fa-cloud-download").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_CLOUD_UPLOAD() {
		return FontIcon.create("fa-cloud-upload").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_USER_MD() {
		return FontIcon.create("fa-user-md").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_STETHOSCOPE() {
		return FontIcon.create("fa-stethoscope").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_SUITCASE() {
		return FontIcon.create("fa-suitcase").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_BELL() {
		return FontIcon.create("fa-bell").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_COFFEE() {
		return FontIcon.create("fa-coffee").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_CUTLERY() {
		return FontIcon.create("fa-cutlery").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_FILE_TEXT_O() {
		return FontIcon.create("fa-file-text-o").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_BUILDING_O() {
		return FontIcon.create("fa-building-o").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_HOSPITAL_O() {
		return FontIcon.create("fa-hospital-o").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_AMBULANCE() {
		return FontIcon.create("fa-ambulance").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_MEDKIT() {
		return FontIcon.create("fa-medkit").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_FIGHTER_JET() {
		return FontIcon.create("fa-fighter-jet").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_BEER() {
		return FontIcon.create("fa-beer").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_H_SQUARE() {
		return FontIcon.create("fa-h-square").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_PLUS_SQUARE() {
		return FontIcon.create("fa-plus-square").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_ANGLE_DOUBLE_LEFT() {
		return FontIcon.create("fa-angle-double-left").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_ANGLE_DOUBLE_RIGHT() {
		return FontIcon.create("fa-angle-double-right").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_ANGLE_DOUBLE_UP() {
		return FontIcon.create("fa-angle-double-up").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_ANGLE_DOUBLE_DOWN() {
		return FontIcon.create("fa-angle-double-down").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_ANGLE_LEFT() {
		return FontIcon.create("fa-angle-left").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_ANGLE_RIGHT() {
		return FontIcon.create("fa-angle-right").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_ANGLE_UP() {
		return FontIcon.create("fa-angle-up").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_ANGLE_DOWN() {
		return FontIcon.create("fa-angle-down").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_DESKTOP() {
		return FontIcon.create("fa-desktop").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_LAPTOP() {
		return FontIcon.create("fa-laptop").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_TABLET() {
		return FontIcon.create("fa-tablet").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_MOBILE() {
		return FontIcon.create("fa-mobile").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_MOBILE_PHONE() {
		return FontIcon.create("fa-mobile-phone").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_CIRCLE_O() {
		return FontIcon.create("fa-circle-o").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_QUOTE_LEFT() {
		return FontIcon.create("fa-quote-left").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_QUOTE_RIGHT() {
		return FontIcon.create("fa-quote-right").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_SPINNER() {
		return FontIcon.create("fa-spinner").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_CIRCLE() {
		return FontIcon.create("fa-circle").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_MAIL_REPLY() {
		return FontIcon.create("fa-mail-reply").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_REPLY() {
		return FontIcon.create("fa-reply").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_GITHUB_ALT() {
		return FontIcon.create("fa-github-alt").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_FOLDER_O() {
		return FontIcon.create("fa-folder-o").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_FOLDER_OPEN_O() {
		return FontIcon.create("fa-folder-open-o").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_SMILE_O() {
		return FontIcon.create("fa-smile-o").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_FROWN_O() {
		return FontIcon.create("fa-frown-o").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_MEH_O() {
		return FontIcon.create("fa-meh-o").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_GAMEPAD() {
		return FontIcon.create("fa-gamepad").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_KEYBOARD_O() {
		return FontIcon.create("fa-keyboard-o").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_FLAG_O() {
		return FontIcon.create("fa-flag-o").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_FLAG_CHECKERED() {
		return FontIcon.create("fa-flag-checkered").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_TERMINAL() {
		return FontIcon.create("fa-terminal").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_CODE() {
		return FontIcon.create("fa-code").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_MAIL_REPLY_ALL() {
		return FontIcon.create("fa-mail-reply-all").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_REPLY_ALL() {
		return FontIcon.create("fa-reply-all").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_STAR_HALF_O() {
		return FontIcon.create("fa-star-half-o").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_STAR_HALF_FULL() {
		return FontIcon.create("fa-star-half-full").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_STAR_HALF_EMPTY() {
		return FontIcon.create("fa-star-half-empty").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_LOCATION_ARROW() {
		return FontIcon.create("fa-location-arrow").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_CROP() {
		return FontIcon.create("fa-crop").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_CODE_FORK() {
		return FontIcon.create("fa-code-fork").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_UNLINK() {
		return FontIcon.create("fa-unlink").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_CHAIN_BROKEN() {
		return FontIcon.create("fa-chain-broken").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_QUESTION() {
		return FontIcon.create("fa-question").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_INFO() {
		return FontIcon.create("fa-info").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_EXCLAMATION() {
		return FontIcon.create("fa-exclamation").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_SUPERSCRIPT() {
		return FontIcon.create("fa-superscript").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_SUBSCRIPT() {
		return FontIcon.create("fa-subscript").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_ERASER() {
		return FontIcon.create("fa-eraser").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_PUZZLE_PIECE() {
		return FontIcon.create("fa-puzzle-piece").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_MICROPHONE() {
		return FontIcon.create("fa-microphone").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_MICROPHONE_SLASH() {
		return FontIcon.create("fa-microphone-slash").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_SHIELD() {
		return FontIcon.create("fa-shield").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_CALENDAR_O() {
		return FontIcon.create("fa-calendar-o").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_FIRE_EXTINGUISHER() {
		return FontIcon.create("fa-fire-extinguisher").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_ROCKET() {
		return FontIcon.create("fa-rocket").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_MAXCDN() {
		return FontIcon.create("fa-maxcdn").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_CHEVRON_CIRCLE_LEFT() {
		return FontIcon.create("fa-chevron-circle-left").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_CHEVRON_CIRCLE_RIGHT() {
		return FontIcon.create("fa-chevron-circle-right").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_CHEVRON_CIRCLE_UP() {
		return FontIcon.create("fa-chevron-circle-up").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_CHEVRON_CIRCLE_DOWN() {
		return FontIcon.create("fa-chevron-circle-down").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_HTML5() {
		return FontIcon.create("fa-html5").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_CSS3() {
		return FontIcon.create("fa-css3").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_ANCHOR() {
		return FontIcon.create("fa-anchor").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_UNLOCK_ALT() {
		return FontIcon.create("fa-unlock-alt").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_BULLSEYE() {
		return FontIcon.create("fa-bullseye").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_ELLIPSIS_H() {
		return FontIcon.create("fa-ellipsis-h").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_ELLIPSIS_V() {
		return FontIcon.create("fa-ellipsis-v").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_RSS_SQUARE() {
		return FontIcon.create("fa-rss-square").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_PLAY_CIRCLE() {
		return FontIcon.create("fa-play-circle").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_TICKET() {
		return FontIcon.create("fa-ticket").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_MINUS_SQUARE() {
		return FontIcon.create("fa-minus-square").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_MINUS_SQUARE_O() {
		return FontIcon.create("fa-minus-square-o").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_LEVEL_UP() {
		return FontIcon.create("fa-level-up").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_LEVEL_DOWN() {
		return FontIcon.create("fa-level-down").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_CHECK_SQUARE() {
		return FontIcon.create("fa-check-square").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_PENCIL_SQUARE() {
		return FontIcon.create("fa-pencil-square").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_EXTERNAL_LINK_SQUARE() {
		return FontIcon.create("fa-external-link-square").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_SHARE_SQUARE() {
		return FontIcon.create("fa-share-square").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_COMPASS() {
		return FontIcon.create("fa-compass").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_CARET_SQUARE_O_DOWN() {
		return FontIcon.create("fa-caret-square-o-down").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_TOGGLE_DOWN() {
		return FontIcon.create("fa-toggle-down").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_TOGGLE_UP() {
		return FontIcon.create("fa-toggle-up").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_CARET_SQUARE_O_UP() {
		return FontIcon.create("fa-caret-square-o-up").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_CARET_SQUARE_O_RIGHT() {
		return FontIcon.create("fa-caret-square-o-right").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_TOGGLE_RIGHT() {
		return FontIcon.create("fa-toggle-right").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_EUR() {
		return FontIcon.create("fa-eur").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_EURO() {
		return FontIcon.create("fa-euro").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_GBP() {
		return FontIcon.create("fa-gbp").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_USD() {
		return FontIcon.create("fa-usd").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_DOLLAR() {
		return FontIcon.create("fa-dollar").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_INR() {
		return FontIcon.create("fa-inr").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_RUPEE() {
		return FontIcon.create("fa-rupee").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_JPY() {
		return FontIcon.create("fa-jpy").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_YEN() {
		return FontIcon.create("fa-yen").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_RMB() {
		return FontIcon.create("fa-rmb").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_CNY() {
		return FontIcon.create("fa-cny").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_RUB() {
		return FontIcon.create("fa-rub").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_ROUBLE() {
		return FontIcon.create("fa-rouble").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_RUBLE() {
		return FontIcon.create("fa-ruble").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_KRW() {
		return FontIcon.create("fa-krw").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_WON() {
		return FontIcon.create("fa-won").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_BTC() {
		return FontIcon.create("fa-btc").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_BITCOIN() {
		return FontIcon.create("fa-bitcoin").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_FILE() {
		return FontIcon.create("fa-file").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_FILE_TEXT() {
		return FontIcon.create("fa-file-text").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_SORT_ALPHA_ASC() {
		return FontIcon.create("fa-sort-alpha-asc").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_SORT_ALPHA_DESC() {
		return FontIcon.create("fa-sort-alpha-desc").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_SORT_AMOUNT_ASC() {
		return FontIcon.create("fa-sort-amount-asc").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_SORT_AMOUNT_DESC() {
		return FontIcon.create("fa-sort-amount-desc").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_SORT_NUMERIC_ASC() {
		return FontIcon.create("fa-sort-numeric-asc").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_SORT_NUMERIC_DESC() {
		return FontIcon.create("fa-sort-numeric-desc").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_THUMBS_UP() {
		return FontIcon.create("fa-thumbs-up").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_THUMBS_DOWN() {
		return FontIcon.create("fa-thumbs-down").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_YOUTUBE_SQUARE() {
		return FontIcon.create("fa-youtube-square").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_YOUTUBE() {
		return FontIcon.create("fa-youtube").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_XING() {
		return FontIcon.create("fa-xing").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_XING_SQUARE() {
		return FontIcon.create("fa-xing-square").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_YOUTUBE_PLAY() {
		return FontIcon.create("fa-youtube-play").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_DROPBOX() {
		return FontIcon.create("fa-dropbox").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_STACK_OVERFLOW() {
		return FontIcon.create("fa-stack-overflow").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_INSTAGRAM() {
		return FontIcon.create("fa-instagram").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_FLICKR() {
		return FontIcon.create("fa-flickr").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_ADN() {
		return FontIcon.create("fa-adn").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_BITBUCKET() {
		return FontIcon.create("fa-bitbucket").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_BITBUCKET_SQUARE() {
		return FontIcon.create("fa-bitbucket-square").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_TUMBLR() {
		return FontIcon.create("fa-tumblr").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_TUMBLR_SQUARE() {
		return FontIcon.create("fa-tumblr-square").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_LONG_ARROW_DOWN() {
		return FontIcon.create("fa-long-arrow-down").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_LONG_ARROW_UP() {
		return FontIcon.create("fa-long-arrow-up").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_LONG_ARROW_LEFT() {
		return FontIcon.create("fa-long-arrow-left").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_LONG_ARROW_RIGHT() {
		return FontIcon.create("fa-long-arrow-right").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_APPLE() {
		return FontIcon.create("fa-apple").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_WINDOWS() {
		return FontIcon.create("fa-windows").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_ANDROID() {
		return FontIcon.create("fa-android").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_LINUX() {
		return FontIcon.create("fa-linux").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_DRIBBBLE() {
		return FontIcon.create("fa-dribbble").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_SKYPE() {
		return FontIcon.create("fa-skype").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_FOURSQUARE() {
		return FontIcon.create("fa-foursquare").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_TRELLO() {
		return FontIcon.create("fa-trello").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_FEMALE() {
		return FontIcon.create("fa-female").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_MALE() {
		return FontIcon.create("fa-male").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_GITTIP() {
		return FontIcon.create("fa-gittip").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_GRATIPAY() {
		return FontIcon.create("fa-gratipay").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_SUN_O() {
		return FontIcon.create("fa-sun-o").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_MOON_O() {
		return FontIcon.create("fa-moon-o").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_ARCHIVE() {
		return FontIcon.create("fa-archive").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_BUG() {
		return FontIcon.create("fa-bug").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_VK() {
		return FontIcon.create("fa-vk").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_WEIBO() {
		return FontIcon.create("fa-weibo").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_RENREN() {
		return FontIcon.create("fa-renren").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_PAGELINES() {
		return FontIcon.create("fa-pagelines").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_STACK_EXCHANGE() {
		return FontIcon.create("fa-stack-exchange").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_ARROW_CIRCLE_O_RIGHT() {
		return FontIcon.create("fa-arrow-circle-o-right").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_ARROW_CIRCLE_O_LEFT() {
		return FontIcon.create("fa-arrow-circle-o-left").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_CARET_SQUARE_O_LEFT() {
		return FontIcon.create("fa-caret-square-o-left").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_TOGGLE_LEFT() {
		return FontIcon.create("fa-toggle-left").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_DOT_CIRCLE_O() {
		return FontIcon.create("fa-dot-circle-o").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_WHEELCHAIR() {
		return FontIcon.create("fa-wheelchair").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_VIMEO_SQUARE() {
		return FontIcon.create("fa-vimeo-square").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_TURKISH_LIRA() {
		return FontIcon.create("fa-turkish-lira").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_TRY() {
		return FontIcon.create("fa-try").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_PLUS_SQUARE_O() {
		return FontIcon.create("fa-plus-square-o").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_SPACE_SHUTTLE() {
		return FontIcon.create("fa-space-shuttle").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_SLACK() {
		return FontIcon.create("fa-slack").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_ENVELOPE_SQUARE() {
		return FontIcon.create("fa-envelope-square").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_WORDPRESS() {
		return FontIcon.create("fa-wordpress").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_OPENID() {
		return FontIcon.create("fa-openid").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_UNIVERSITY() {
		return FontIcon.create("fa-university").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_INSTITUTION() {
		return FontIcon.create("fa-institution").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_BANK() {
		return FontIcon.create("fa-bank").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_GRADUATION_CAP() {
		return FontIcon.create("fa-graduation-cap").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_MORTAR_BOARD() {
		return FontIcon.create("fa-mortar-board").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_YAHOO() {
		return FontIcon.create("fa-yahoo").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_GOOGLE() {
		return FontIcon.create("fa-google").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_REDDIT() {
		return FontIcon.create("fa-reddit").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_REDDIT_SQUARE() {
		return FontIcon.create("fa-reddit-square").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_STUMBLEUPON_CIRCLE() {
		return FontIcon.create("fa-stumbleupon-circle").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_STUMBLEUPON() {
		return FontIcon.create("fa-stumbleupon").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_DELICIOUS() {
		return FontIcon.create("fa-delicious").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_DIGG() {
		return FontIcon.create("fa-digg").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_PIED_PIPER() {
		return FontIcon.create("fa-pied-piper").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_PIED_PIPER_ALT() {
		return FontIcon.create("fa-pied-piper-alt").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_DRUPAL() {
		return FontIcon.create("fa-drupal").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_JOOMLA() {
		return FontIcon.create("fa-joomla").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_LANGUAGE() {
		return FontIcon.create("fa-language").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_FAX() {
		return FontIcon.create("fa-fax").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_BUILDING() {
		return FontIcon.create("fa-building").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_CHILD() {
		return FontIcon.create("fa-child").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_PAW() {
		return FontIcon.create("fa-paw").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_SPOON() {
		return FontIcon.create("fa-spoon").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_CUBE() {
		return FontIcon.create("fa-cube").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_CUBES() {
		return FontIcon.create("fa-cubes").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_BEHANCE() {
		return FontIcon.create("fa-behance").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_BEHANCE_SQUARE() {
		return FontIcon.create("fa-behance-square").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_STEAM() {
		return FontIcon.create("fa-steam").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_STEAM_SQUARE() {
		return FontIcon.create("fa-steam-square").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_RECYCLE() {
		return FontIcon.create("fa-recycle").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_AUTOMOBILE() {
		return FontIcon.create("fa-automobile").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_CAR() {
		return FontIcon.create("fa-car").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_TAXI() {
		return FontIcon.create("fa-taxi").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_CAB() {
		return FontIcon.create("fa-cab").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_TREE() {
		return FontIcon.create("fa-tree").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_SPOTIFY() {
		return FontIcon.create("fa-spotify").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_DEVIANTART() {
		return FontIcon.create("fa-deviantart").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_SOUNDCLOUD() {
		return FontIcon.create("fa-soundcloud").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_DATABASE() {
		return FontIcon.create("fa-database").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_FILE_PDF_O() {
		return FontIcon.create("fa-file-pdf-o").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_FILE_WORD_O() {
		return FontIcon.create("fa-file-word-o").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_FILE_EXCEL_O() {
		return FontIcon.create("fa-file-excel-o").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_FILE_POWERPOINT_O() {
		return FontIcon.create("fa-file-powerpoint-o").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_FILE_IMAGE_O() {
		return FontIcon.create("fa-file-image-o").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_FILE_PICTURE_O() {
		return FontIcon.create("fa-file-picture-o").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_FILE_PHOTO_O() {
		return FontIcon.create("fa-file-photo-o").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_FILE_ZIP_O() {
		return FontIcon.create("fa-file-zip-o").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_FILE_ARCHIVE_O() {
		return FontIcon.create("fa-file-archive-o").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_FILE_SOUND_O() {
		return FontIcon.create("fa-file-sound-o").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_FILE_AUDIO_O() {
		return FontIcon.create("fa-file-audio-o").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_FILE_MOVIE_O() {
		return FontIcon.create("fa-file-movie-o").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_FILE_VIDEO_O() {
		return FontIcon.create("fa-file-video-o").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_FILE_CODE_O() {
		return FontIcon.create("fa-file-code-o").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_VINE() {
		return FontIcon.create("fa-vine").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_CODEPEN() {
		return FontIcon.create("fa-codepen").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_JSFIDDLE() {
		return FontIcon.create("fa-jsfiddle").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_LIFE_BUOY() {
		return FontIcon.create("fa-life-buoy").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_LIFE_RING() {
		return FontIcon.create("fa-life-ring").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_LIFE_BOUY() {
		return FontIcon.create("fa-life-bouy").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_LIFE_SAVER() {
		return FontIcon.create("fa-life-saver").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_SUPPORT() {
		return FontIcon.create("fa-support").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_CIRCLE_O_NOTCH() {
		return FontIcon.create("fa-circle-o-notch").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_RA() {
		return FontIcon.create("fa-ra").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_REBEL() {
		return FontIcon.create("fa-rebel").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_EMPIRE() {
		return FontIcon.create("fa-empire").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_GE() {
		return FontIcon.create("fa-ge").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_GIT_SQUARE() {
		return FontIcon.create("fa-git-square").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_GIT() {
		return FontIcon.create("fa-git").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_HACKER_NEWS() {
		return FontIcon.create("fa-hacker-news").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_YC_SQUARE() {
		return FontIcon.create("fa-yc-square").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_Y_COMBINATOR_SQUARE() {
		return FontIcon.create("fa-y-combinator-square").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_TENCENT_WEIBO() {
		return FontIcon.create("fa-tencent-weibo").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_QQ() {
		return FontIcon.create("fa-qq").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_WECHAT() {
		return FontIcon.create("fa-wechat").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_WEIXIN() {
		return FontIcon.create("fa-weixin").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_SEND() {
		return FontIcon.create("fa-send").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_PAPER_PLANE() {
		return FontIcon.create("fa-paper-plane").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_PAPER_PLANE_O() {
		return FontIcon.create("fa-paper-plane-o").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_SEND_O() {
		return FontIcon.create("fa-send-o").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_HISTORY() {
		return FontIcon.create("fa-history").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_CIRCLE_THIN() {
		return FontIcon.create("fa-circle-thin").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_HEADER() {
		return FontIcon.create("fa-header").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_PARAGRAPH() {
		return FontIcon.create("fa-paragraph").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_SLIDERS() {
		return FontIcon.create("fa-sliders").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_SHARE_ALT() {
		return FontIcon.create("fa-share-alt").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_SHARE_ALT_SQUARE() {
		return FontIcon.create("fa-share-alt-square").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_BOMB() {
		return FontIcon.create("fa-bomb").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_SOCCER_BALL_O() {
		return FontIcon.create("fa-soccer-ball-o").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_FUTBOL_O() {
		return FontIcon.create("fa-futbol-o").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_TTY() {
		return FontIcon.create("fa-tty").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_BINOCULARS() {
		return FontIcon.create("fa-binoculars").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_PLUG() {
		return FontIcon.create("fa-plug").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_SLIDESHARE() {
		return FontIcon.create("fa-slideshare").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_TWITCH() {
		return FontIcon.create("fa-twitch").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_YELP() {
		return FontIcon.create("fa-yelp").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_NEWSPAPER_O() {
		return FontIcon.create("fa-newspaper-o").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_WIFI() {
		return FontIcon.create("fa-wifi").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_CALCULATOR() {
		return FontIcon.create("fa-calculator").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_PAYPAL() {
		return FontIcon.create("fa-paypal").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_GOOGLE_WALLET() {
		return FontIcon.create("fa-google-wallet").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_CC_VISA() {
		return FontIcon.create("fa-cc-visa").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_CC_MASTERCARD() {
		return FontIcon.create("fa-cc-mastercard").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_CC_DISCOVER() {
		return FontIcon.create("fa-cc-discover").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_CC_AMEX() {
		return FontIcon.create("fa-cc-amex").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_CC_PAYPAL() {
		return FontIcon.create("fa-cc-paypal").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_CC_STRIPE() {
		return FontIcon.create("fa-cc-stripe").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_BELL_SLASH() {
		return FontIcon.create("fa-bell-slash").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_BELL_SLASH_O() {
		return FontIcon.create("fa-bell-slash-o").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_TRASH() {
		return FontIcon.create("fa-trash").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_COPYRIGHT() {
		return FontIcon.create("fa-copyright").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_AT() {
		return FontIcon.create("fa-at").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_EYEDROPPER() {
		return FontIcon.create("fa-eyedropper").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_PAINT_BRUSH() {
		return FontIcon.create("fa-paint-brush").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_BIRTHDAY_CAKE() {
		return FontIcon.create("fa-birthday-cake").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_AREA_CHART() {
		return FontIcon.create("fa-area-chart").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_PIE_CHART() {
		return FontIcon.create("fa-pie-chart").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_LINE_CHART() {
		return FontIcon.create("fa-line-chart").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_LASTFM() {
		return FontIcon.create("fa-lastfm").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_LASTFM_SQUARE() {
		return FontIcon.create("fa-lastfm-square").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_TOGGLE_OFF() {
		return FontIcon.create("fa-toggle-off").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_TOGGLE_ON() {
		return FontIcon.create("fa-toggle-on").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_BICYCLE() {
		return FontIcon.create("fa-bicycle").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_BUS() {
		return FontIcon.create("fa-bus").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_IOXHOST() {
		return FontIcon.create("fa-ioxhost").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_ANGELLIST() {
		return FontIcon.create("fa-angellist").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_CC() {
		return FontIcon.create("fa-cc").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_ILS() {
		return FontIcon.create("fa-ils").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_SHEQEL() {
		return FontIcon.create("fa-sheqel").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_SHEKEL() {
		return FontIcon.create("fa-shekel").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_MEANPATH() {
		return FontIcon.create("fa-meanpath").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_BUYSELLADS() {
		return FontIcon.create("fa-buysellads").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_CONNECTDEVELOP() {
		return FontIcon.create("fa-connectdevelop").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_DASHCUBE() {
		return FontIcon.create("fa-dashcube").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_FORUMBEE() {
		return FontIcon.create("fa-forumbee").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_LEANPUB() {
		return FontIcon.create("fa-leanpub").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_SELLSY() {
		return FontIcon.create("fa-sellsy").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_SHIRTSINBULK() {
		return FontIcon.create("fa-shirtsinbulk").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_SIMPLYBUILT() {
		return FontIcon.create("fa-simplybuilt").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_SKYATLAS() {
		return FontIcon.create("fa-skyatlas").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_CART_PLUS() {
		return FontIcon.create("fa-cart-plus").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_CART_ARROW_DOWN() {
		return FontIcon.create("fa-cart-arrow-down").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_DIAMOND() {
		return FontIcon.create("fa-diamond").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_SHIP() {
		return FontIcon.create("fa-ship").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_USER_SECRET() {
		return FontIcon.create("fa-user-secret").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_MOTORCYCLE() {
		return FontIcon.create("fa-motorcycle").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_STREET_VIEW() {
		return FontIcon.create("fa-street-view").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_HEARTBEAT() {
		return FontIcon.create("fa-heartbeat").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_VENUS() {
		return FontIcon.create("fa-venus").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_MARS() {
		return FontIcon.create("fa-mars").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_MERCURY() {
		return FontIcon.create("fa-mercury").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_INTERSEX() {
		return FontIcon.create("fa-intersex").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_TRANSGENDER() {
		return FontIcon.create("fa-transgender").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_TRANSGENDER_ALT() {
		return FontIcon.create("fa-transgender-alt").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_VENUS_DOUBLE() {
		return FontIcon.create("fa-venus-double").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_MARS_DOUBLE() {
		return FontIcon.create("fa-mars-double").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_VENUS_MARS() {
		return FontIcon.create("fa-venus-mars").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_MARS_STROKE() {
		return FontIcon.create("fa-mars-stroke").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_MARS_STROKE_V() {
		return FontIcon.create("fa-mars-stroke-v").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_MARS_STROKE_H() {
		return FontIcon.create("fa-mars-stroke-h").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_NEUTER() {
		return FontIcon.create("fa-neuter").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_GENDERLESS() {
		return FontIcon.create("fa-genderless").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_FACEBOOK_OFFICIAL() {
		return FontIcon.create("fa-facebook-official").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_PINTEREST_P() {
		return FontIcon.create("fa-pinterest-p").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_WHATSAPP() {
		return FontIcon.create("fa-whatsapp").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_SERVER() {
		return FontIcon.create("fa-server").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_USER_PLUS() {
		return FontIcon.create("fa-user-plus").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_USER_TIMES() {
		return FontIcon.create("fa-user-times").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_BED() {
		return FontIcon.create("fa-bed").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_HOTEL() {
		return FontIcon.create("fa-hotel").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_VIACOIN() {
		return FontIcon.create("fa-viacoin").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_TRAIN() {
		return FontIcon.create("fa-train").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_SUBWAY() {
		return FontIcon.create("fa-subway").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_MEDIUM() {
		return FontIcon.create("fa-medium").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_YC() {
		return FontIcon.create("fa-yc").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_Y_COMBINATOR() {
		return FontIcon.create("fa-y-combinator").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_OPTIN_MONSTER() {
		return FontIcon.create("fa-optin-monster").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_OPENCART() {
		return FontIcon.create("fa-opencart").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_EXPEDITEDSSL() {
		return FontIcon.create("fa-expeditedssl").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_BATTERY_FULL() {
		return FontIcon.create("fa-battery-full").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_BATTERY_4() {
		return FontIcon.create("fa-battery-4").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_BATTERY_THREE_QUARTERS() {
		return FontIcon.create("fa-battery-three-quarters").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_BATTERY_3() {
		return FontIcon.create("fa-battery-3").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_BATTERY_HALF() {
		return FontIcon.create("fa-battery-half").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_BATTERY_2() {
		return FontIcon.create("fa-battery-2").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_BATTERY_QUARTER() {
		return FontIcon.create("fa-battery-quarter").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_BATTERY_1() {
		return FontIcon.create("fa-battery-1").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_BATTERY_EMPTY() {
		return FontIcon.create("fa-battery-empty").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_BATTERY_0() {
		return FontIcon.create("fa-battery-0").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_MOUSE_POINTER() {
		return FontIcon.create("fa-mouse-pointer").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_I_CURSOR() {
		return FontIcon.create("fa-i-cursor").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_OBJECT_GROUP() {
		return FontIcon.create("fa-object-group").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_OBJECT_UNGROUP() {
		return FontIcon.create("fa-object-ungroup").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_STICKY_NOTE() {
		return FontIcon.create("fa-sticky-note").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_STICKY_NOTE_O() {
		return FontIcon.create("fa-sticky-note-o").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_CC_JCB() {
		return FontIcon.create("fa-cc-jcb").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_CC_DINERS_CLUB() {
		return FontIcon.create("fa-cc-diners-club").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_CLONE() {
		return FontIcon.create("fa-clone").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_BALANCE_SCALE() {
		return FontIcon.create("fa-balance-scale").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_HOURGLASS_O() {
		return FontIcon.create("fa-hourglass-o").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_HOURGLASS_1() {
		return FontIcon.create("fa-hourglass-1").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_HOURGLASS_START() {
		return FontIcon.create("fa-hourglass-start").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_HOURGLASS_2() {
		return FontIcon.create("fa-hourglass-2").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_HOURGLASS_HALF() {
		return FontIcon.create("fa-hourglass-half").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_HOURGLASS_3() {
		return FontIcon.create("fa-hourglass-3").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_HOURGLASS_END() {
		return FontIcon.create("fa-hourglass-end").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_HOURGLASS() {
		return FontIcon.create("fa-hourglass").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_HAND_ROCK_O() {
		return FontIcon.create("fa-hand-rock-o").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_HAND_GRAB_O() {
		return FontIcon.create("fa-hand-grab-o").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_HAND_PAPER_O() {
		return FontIcon.create("fa-hand-paper-o").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_HAND_STOP_O() {
		return FontIcon.create("fa-hand-stop-o").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_HAND_SCISSORS_O() {
		return FontIcon.create("fa-hand-scissors-o").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_HAND_LIZARD_O() {
		return FontIcon.create("fa-hand-lizard-o").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_HAND_SPOCK_O() {
		return FontIcon.create("fa-hand-spock-o").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_HAND_POINTER_O() {
		return FontIcon.create("fa-hand-pointer-o").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_HAND_PEACE_O() {
		return FontIcon.create("fa-hand-peace-o").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_TRADEMARK() {
		return FontIcon.create("fa-trademark").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_REGISTERED() {
		return FontIcon.create("fa-registered").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_CREATIVE_COMMONS() {
		return FontIcon.create("fa-creative-commons").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_GG() {
		return FontIcon.create("fa-gg").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_GG_CIRCLE() {
		return FontIcon.create("fa-gg-circle").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_TRIPADVISOR() {
		return FontIcon.create("fa-tripadvisor").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_ODNOKLASSNIKI() {
		return FontIcon.create("fa-odnoklassniki").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_ODNOKLASSNIKI_SQUARE() {
		return FontIcon.create("fa-odnoklassniki-square").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_GET_POCKET() {
		return FontIcon.create("fa-get-pocket").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_WIKIPEDIA_W() {
		return FontIcon.create("fa-wikipedia-w").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_SAFARI() {
		return FontIcon.create("fa-safari").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_CHROME() {
		return FontIcon.create("fa-chrome").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_FIREFOX() {
		return FontIcon.create("fa-firefox").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_OPERA() {
		return FontIcon.create("fa-opera").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_INTERNET_EXPLORER() {
		return FontIcon.create("fa-internet-explorer").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_TELEVISION() {
		return FontIcon.create("fa-television").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_TV() {
		return FontIcon.create("fa-tv").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_CONTAO() {
		return FontIcon.create("fa-contao").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_500PX() {
		return FontIcon.create("fa-500px").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_AMAZON() {
		return FontIcon.create("fa-amazon").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_CALENDAR_PLUS_O() {
		return FontIcon.create("fa-calendar-plus-o").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_CALENDAR_MINUS_O() {
		return FontIcon.create("fa-calendar-minus-o").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_CALENDAR_TIMES_O() {
		return FontIcon.create("fa-calendar-times-o").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_CALENDAR_CHECK_O() {
		return FontIcon.create("fa-calendar-check-o").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_INDUSTRY() {
		return FontIcon.create("fa-industry").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_MAP_PIN() {
		return FontIcon.create("fa-map-pin").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_MAP_SIGNS() {
		return FontIcon.create("fa-map-signs").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_MAP_O() {
		return FontIcon.create("fa-map-o").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_MAP() {
		return FontIcon.create("fa-map").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_COMMENTING() {
		return FontIcon.create("fa-commenting").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_COMMENTING_O() {
		return FontIcon.create("fa-commenting-o").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_HOUZZ() {
		return FontIcon.create("fa-houzz").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_VIMEO() {
		return FontIcon.create("fa-vimeo").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_BLACK_TIE() {
		return FontIcon.create("fa-black-tie").get(); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return the font icon instance
	 */
	public static FontIcon FA_FONTICONS() {
		return FontIcon.create("fa-fonticons").get(); //$NON-NLS-1$
	}
}
