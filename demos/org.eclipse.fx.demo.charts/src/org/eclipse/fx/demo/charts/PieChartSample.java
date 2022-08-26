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
package org.eclipse.fx.demo.charts;

import javafx.animation.TranslateTransitionBuilder;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class PieChartSample extends Application {

	@Override
	public void start(Stage primaryStage) {
		BorderPane p = new BorderPane();
				
		ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
				new PieChart.Data("Austria", 8_430_558), 
				new PieChart.Data("Swiss", 7_701_900),
				new PieChart.Data("Germany", 81_882_342),
				new PieChart.Data("France", 62_793_432),
				new PieChart.Data("Spain", 46_661_950 	),
				new PieChart.Data("Italy", 60_245_846)
				);
		PieChart chart = new PieChart(pieChartData);
		chart.setStyle("-fx-pie-label-visible: false");
		
		for( PieChart.Data d : pieChartData ) {
			d.getNode().setOnMouseEntered(new MouseHoverAnimation(d,chart));
			d.getNode().setOnMouseExited(new MouseExitAnimation());
		}
		
		chart.setClockwise(false);
		p.setCenter(chart);
		
		Scene s = new Scene(p);
		primaryStage.setScene(s);
		primaryStage.setWidth(600);
		primaryStage.setHeight(600);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	static class MouseHoverAnimation implements EventHandler<MouseEvent> {
		static final Duration ANIMATION_DURATION = new Duration(500);
		static final double ANIMATION_DISTANCE = 0.15;
		private double cos;
		private double sin;
		private PieChart chart;

		public MouseHoverAnimation(PieChart.Data d, PieChart chart) {
			this.chart = chart;
			double start = 0;
			double angle = calcAngle(d);
			for( PieChart.Data tmp : chart.getData() ) {
				if( tmp == d ) {
					break;
				}
				start += calcAngle(tmp);
			}
			
			cos = Math.cos(Math.toRadians(0 - start - angle / 2));
			sin = Math.sin(Math.toRadians(0 - start - angle / 2));
		}
		
		@Override
		public void handle(MouseEvent arg0) {
			Node n = (Node) arg0.getSource();
			
			double minX = Double.MAX_VALUE;
			double maxX = Double.MAX_VALUE * -1;
			
			for( PieChart.Data d : chart.getData() ) {
				minX = Math.min(minX, d.getNode().getBoundsInParent().getMinX());
				maxX = Math.max(maxX, d.getNode().getBoundsInParent().getMaxX());
			}
			
			double radius = maxX - minX;
			TranslateTransitionBuilder.create().toX((radius *  ANIMATION_DISTANCE) * cos).toY((radius *  ANIMATION_DISTANCE) * sin).duration(ANIMATION_DURATION).node(n).build().play();
		}
		
		private static double calcAngle(PieChart.Data d) {
			double total = 0;
			for( PieChart.Data tmp : d.getChart().getData() ) {
				total += tmp.getPieValue();
			}
			
			return 360 * (d.getPieValue() / total); 
		}
	}
	
	static class MouseExitAnimation implements EventHandler<MouseEvent> {
			@Override
			public void handle(MouseEvent event) {
				TranslateTransitionBuilder.create().toX(0).toY(0).duration(new Duration(500)).node((Node) event.getSource()).build().play();
			}
	}
}
