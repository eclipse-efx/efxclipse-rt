/*******************************************************************************
 * Copyright (c) 2022 BestSolution.at and others.
 *  
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *  
 * SPDX-License-Identifier: EPL-2.0
 *  
 * Contributors:
 *     BestSolution.at - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.demo.media.parts;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.atomic.AtomicReference;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.model.application.ui.advanced.MPerspective;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.fx.demo.media.model.Media;
import org.eclipse.fx.demo.media.model.MediaType;

@SuppressWarnings("restriction")
public class MediaPart {
	public static final String MEDIA_OBJECT_KEY = "MediaObject";
	
	private static final String KEY_TRANSLATE_X = "translateX";
	private static final String KEY_TRANSLATE_Y = "translateY";
	private static final String KEY_SCALE_FACTOR = "scale";
	
	@Inject
	MPart part;
	
	@Inject
	MPerspective perspective;

	private MediaPlayer mediaPlayer;
	
	private Node focusNode;
	
	@PostConstruct
	void init(BorderPane p) {
		Media m = Media.deserialize(part.getPersistedState().get(MEDIA_OBJECT_KEY));
		if( m.getType() == MediaType.PICTURE ) {
			initPicture(p, m);
		} else if( m.getType() == MediaType.MOVIE ) {
			initMovie(p, m);
		} else {
			initSound(p, m);
		}
	}
	
	private void initPicture(BorderPane p, Media m) {
		final AnchorPane transformStack = new AnchorPane();
		String scaleFactor = part.getPersistedState().get(KEY_SCALE_FACTOR);
		String translateX = part.getPersistedState().get(KEY_TRANSLATE_X);
		String translateY = part.getPersistedState().get(KEY_TRANSLATE_Y);
		
		if( scaleFactor != null ) {
			transformStack.setScaleX(Double.parseDouble(scaleFactor));
			transformStack.setScaleY(Double.parseDouble(scaleFactor));
		}
		
		if( translateX != null ) {
			transformStack.setTranslateX(Double.parseDouble(translateX));
		}
		
		if( translateY != null ) {
			transformStack.setTranslateY(Double.parseDouble(translateY));
		}
		
		
		final ImageView v = new ImageView(m.getUrl());
		focusNode = v;
		transformStack.getChildren().add(v);
		p.setCenter(transformStack);
		p.setOnScroll(new EventHandler<ScrollEvent>() {

			@Override
			public void handle(ScrollEvent event) {
				int direction = event.getDeltaY() < 0 || event.isShiftDown() ? -1 : 1;
				double val = Math.max(transformStack.getScaleX() + 0.05 * direction,0.1);
				transformStack.setScaleX(val);
				transformStack.setScaleY(val);
				part.getPersistedState().put(KEY_SCALE_FACTOR, val+"");
			}
		});
		
		final AtomicReference<MouseEvent> deltaEvent = new AtomicReference<MouseEvent>();
		p.setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				deltaEvent.set(event);	
			}
		});
		
		p.setOnMouseDragged(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				double deltaX = event.getX() - deltaEvent.get().getX();
				double deltaY = event.getY() - deltaEvent.get().getY();
				
				double targetX = transformStack.getTranslateX() + deltaX;
				double targetY = transformStack.getTranslateY() + deltaY;
				transformStack.setTranslateX(targetX);
				transformStack.setTranslateY(targetY);
				part.getPersistedState().put(KEY_TRANSLATE_X, targetX+"");
				part.getPersistedState().put(KEY_TRANSLATE_Y, targetY+"");
				
				deltaEvent.set(event);
			}
		});
	}
	
	@Inject
	void startMovie(@Named(IServiceConstants.ACTIVE_PART) MPart activePart) {
		if( mediaPlayer != null ) {
			if( activePart == part ) {
				mediaPlayer.play();
			} else {
				mediaPlayer.pause();
			}
		}
	}
	
	private void initMovie(BorderPane p, Media m) {
		mediaPlayer = new MediaPlayer(new javafx.scene.media.Media(platformUriFix(m.getUrl())));
		mediaPlayer.setAutoPlay(true);
		
		final AnchorPane transformStack = new AnchorPane();
		String scaleFactor = part.getPersistedState().get(KEY_SCALE_FACTOR);
		String translateX = part.getPersistedState().get(KEY_TRANSLATE_X);
		String translateY = part.getPersistedState().get(KEY_TRANSLATE_Y);
		
		if( scaleFactor != null ) {
			transformStack.setScaleX(Double.parseDouble(scaleFactor));
			transformStack.setScaleY(Double.parseDouble(scaleFactor));
		}
		
		if( translateX != null ) {
			transformStack.setTranslateX(Double.parseDouble(translateX));
		}
		
		if( translateY != null ) {
			transformStack.setTranslateY(Double.parseDouble(translateY));
		}
		
		final MediaView mediaView = new MediaView(mediaPlayer);
		focusNode = mediaView;
		focusNode = mediaView;
		transformStack.getChildren().add(mediaView);
		p.setCenter(transformStack);
		p.setOnScroll(new EventHandler<ScrollEvent>() {

			@Override
			public void handle(ScrollEvent event) {
				int direction = event.getDeltaY() < 0 || event.isShiftDown() ? -1 : 1;
				double val = Math.max(transformStack.getScaleX() + 0.05 * direction,0.1);
				transformStack.setScaleX(val);
				transformStack.setScaleY(val);
				part.getPersistedState().put(KEY_SCALE_FACTOR, val+"");
			}
		});
		
		final AtomicReference<MouseEvent> deltaEvent = new AtomicReference<MouseEvent>();
		p.setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				deltaEvent.set(event);	
			}
		});
		
		p.setOnMouseDragged(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				double deltaX = event.getX() - deltaEvent.get().getX();
				double deltaY = event.getY() - deltaEvent.get().getY();
				
				double targetX = transformStack.getTranslateX() + deltaX;
				double targetY = transformStack.getTranslateY() + deltaY;
				transformStack.setTranslateX(targetX);
				transformStack.setTranslateY(targetY);
				part.getPersistedState().put(KEY_TRANSLATE_X, targetX+"");
				part.getPersistedState().put(KEY_TRANSLATE_Y, targetY+"");
				
				deltaEvent.set(event);
			}
		});
	}
	
	@Focus
	void focus() {
		if( focusNode != null ) {
			focusNode.requestFocus();
		}
	}
	
	private String platformUriFix(String uri) {
		if( uri.startsWith("platform:") ) {
			try {
				URL url = new URL(uri);
				InputStream in = url.openStream();
				byte[] buf = new byte[1024];
				int l;
				File f = File.createTempFile("movie", "");
				FileOutputStream out = new FileOutputStream(f);
				while( (l = in.read(buf)) != -1 ) {
					out.write(buf, 0, l);
				}
				out.close();
				return f.toURI().toURL().toExternalForm();
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return uri;
		} else {
			return uri;
		}
	}
	
	private void initSound(BorderPane p, Media m) {
		
	}
}