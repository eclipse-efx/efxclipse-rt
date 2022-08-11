/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.controls.vectorgraphics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.scene.shape.ArcTo;
import javafx.scene.shape.ClosePath;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.HLineTo;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.PathElement;
import javafx.scene.shape.QuadCurveTo;
import javafx.scene.shape.VLineTo;

import org.eclipse.jdt.annotation.NonNull;

import com.sun.javafx.geom.Path2D;
import com.sun.javafx.geom.PathIterator;

/**
 * Utilitities for paths
 *
 * @since 1.2
 */
@SuppressWarnings("restriction")
public class PathUtils {
	/**
	 * Parse the svg path
	 *
	 * @param svgPath
	 *            the path
	 * @param h
	 *            the handler for the commands
	 */
	public static void parseSVGPath(String svgPath, PathHandler h) {
		new SVGParser(svgPath).parse(h);
	}

	/**
	 * Convert the svgPath into {@link PathElement} list.
	 *
	 * <p>
	 * If smooth paths (S,s,T,t) are used the internal representation is not a
	 * 1:1 mapping to the input but is normalized to these 5 absolute commands:
	 * </p>
	 * <ul>
	 * <li>Close (Z)</li>
	 * <li>LineTo (L)</li>
	 * <li>QuadTo (Q)</li>
	 * <li>CubicTo (C)</li>
	 * <li>MoveTo (M)</li>
	 * </ul>
	 *
	 * @param svgPath
	 *            the path
	 * @return the elements
	 */
	@SuppressWarnings("null")
	public static @NonNull List<@NonNull PathElement> transformToPathElements(String svgPath) {
		List<PathElement> l = new ArrayList<>();

		if (svgPath.indexOf('T') != -1 || svgPath.indexOf('t') != -1 || svgPath.indexOf('S') != -1 || svgPath.indexOf('s') != -1) {
			Path2D p = new Path2D();
			p.appendSVGPath(svgPath);
			PathIterator pathIterator = p.getPathIterator(null);

			float coords[] = new float[6];
			while (!pathIterator.isDone()) {
				switch (pathIterator.currentSegment(coords)) {
				case PathIterator.SEG_MOVETO:
					l.add(new MoveTo(coords[0], coords[1]));
					break;
				case PathIterator.SEG_LINETO:
					l.add(new LineTo(coords[0], coords[1]));
					break;
				case PathIterator.SEG_QUADTO:
					l.add(new QuadCurveTo(coords[0], coords[1], coords[2], coords[3]));
					break;
				case PathIterator.SEG_CUBICTO:
					l.add(new CubicCurveTo(coords[0], coords[1], coords[0], coords[1], coords[0], coords[1]));
					break;
				case PathIterator.SEG_CLOSE:
					l.add(new ClosePath());
					break;
				default:
					break;
				}
			}
		} else {
			new SVGParser(svgPath).parse(new PathHandler() {

				@Override
				public void vlineToRel(double y) {
					l.add(makeAbsolute(false, new VLineTo(y)));
				}

				@Override
				public void vlineToAbs(double y) {
					l.add(makeAbsolute(true, new VLineTo(y)));
				}

				@Override
				public void squadCurveToRel(double x, double y) {
					throw new UnsupportedOperationException();
				}

				@Override
				public void squadCurveToAbs(double x, double y) {
					throw new UnsupportedOperationException();
				}

				@Override
				public void scurveToRel(double x2, double y2, double x, double y) {
					throw new UnsupportedOperationException();
				}

				@Override
				public void scurveToAbs(double x2, double y2, double x, double y) {
					throw new UnsupportedOperationException();
				}

				@Override
				public void quadCurveToRel(double x1, double y1, double x, double y) {
					l.add(makeAbsolute(false, new QuadCurveTo(x1, y1, x, y)));
				}

				@Override
				public void quadCurveToAbs(double x1, double y1, double x, double y) {
					l.add(makeAbsolute(true, new QuadCurveTo(x1, y1, x, y)));
				}

				@Override
				public void moveToRel(double x, double y) {
					l.add(makeAbsolute(false, new MoveTo(x, y)));
				}

				@Override
				public void moveToAbs(double x, double y) {
					l.add(makeAbsolute(true, new MoveTo(x, y)));
				}

				@Override
				public void lineToRel(double x, double y) {
					l.add(makeAbsolute(false, new LineTo(x, y)));
				}

				@Override
				public void lineToAbs(double x, double y) {
					l.add(makeAbsolute(true, new LineTo(x, y)));
				}

				@Override
				public void hlineToRel(double x) {
					l.add(makeAbsolute(false, new HLineTo(x)));
				}

				@Override
				public void hlineToAbs(double x) {
					l.add(makeAbsolute(true, new HLineTo(x)));
				}

				@Override
				public void error(String error) {
					// nothing
				}

				@Override
				public void curveToRel(double x1, double y1, double x2, double y2, double x, double y) {
					l.add(makeAbsolute(false, new CubicCurveTo(x1, y1, x2, y2, x, y)));
				}

				@Override
				public void curveToAbs(double x1, double y1, double x2, double y2, double x, double y) {
					l.add(makeAbsolute(true, new CubicCurveTo(x1, y1, x2, y2, x, y)));
				}

				@Override
				public void closePathRel() {
					l.add(makeAbsolute(false, new ClosePath()));
				}

				@Override
				public void closePathAbs() {
					l.add(makeAbsolute(true, new ClosePath()));
				}

				@Override
				public void arcRel(double rx, double ry, double xaxisrotation, boolean largearcflag, boolean sweepflag, double x, double y) {
					l.add(makeAbsolute(false, new ArcTo(rx, ry, xaxisrotation, x, y, largearcflag, sweepflag)));
				}

				@Override
				public void arcAbs(double rx, double ry, double xaxisrotation, boolean largearcflag, boolean sweepflag, double x, double y) {
					l.add(makeAbsolute(true, new ArcTo(rx, ry, xaxisrotation, x, y, largearcflag, sweepflag)));
				}
			});
		}
		return Collections.unmodifiableList(l);
	}

	static <P extends PathElement> P makeAbsolute(boolean absolute, P element) {
		element.setAbsolute(absolute);
		return element;

	}

	/**
	 * Callback from the parser
	 */
	public interface PathHandler {
		/**
		 * Absolute move to
		 *
		 * @param x
		 *            the x
		 * @param y
		 *            the y
		 */
		public void moveToAbs(double x, double y);

		/**
		 * Relative move to
		 *
		 * @param x
		 *            the x
		 * @param y
		 *            the y
		 */
		public void moveToRel(double x, double y);

		/**
		 * Error callback
		 *
		 * @param error
		 *            the error message
		 */
		public void error(String error);

		/**
		 * Relative cubic curve to
		 *
		 * @param x1
		 *            the X coordinate of the first Bézier control point
		 * @param y1
		 *            the Y coordinate of the first Bézier control point
		 * @param x2
		 *            the X coordinate of the second Bézier control point
		 * @param y2
		 *            the Y coordinate of the second Bézier control point
		 * @param x
		 *            the X coordinate of the final end point
		 * @param y
		 *            the Y coordinate of the final end point
		 */
		public void curveToRel(double x1, double y1, double x2, double y2, double x, double y);

		/**
		 * Absolute cubic curve to
		 *
		 * @param x1
		 *            the X coordinate of the first Bézier control point
		 * @param y1
		 *            the Y coordinate of the first Bézier control point
		 * @param x2
		 *            the X coordinate of the second Bézier control point
		 * @param y2
		 *            the Y coordinate of the second Bézier control point
		 * @param x
		 *            the X coordinate of the final end point
		 * @param y
		 *            the Y coordinate of the final end point
		 */
		public void curveToAbs(double x1, double y1, double x2, double y2, double x, double y);

		/**
		 * close the path
		 */
		public void closePathRel();

		/**
		 * close the path
		 */
		public void closePathAbs();

		/**
		 * Relative elliptical arc
		 *
		 * @param rx
		 *            horizontal radius of the arc
		 * @param ry
		 *            vertical radius of the arc
		 * @param xaxisrotation
		 *            the x-axis rotation in degrees
		 * @param largearcflag
		 *            large arg flag: determines which arc to use (large/small)
		 * @param sweepflag
		 *            sweep flag: determines which arc to use
		 * @param x
		 *            horizontal position of the arc end point
		 * @param y
		 *            vertical position of the arc end point
		 */
		public void arcRel(double rx, double ry, double xaxisrotation, boolean largearcflag, boolean sweepflag, double x, double y);

		/**
		 * Absolute elliptical arc
		 *
		 * @param rx
		 *            horizontal radius of the arc
		 * @param ry
		 *            vertical radius of the arc
		 * @param xaxisrotation
		 *            the x-axis rotation in degrees
		 * @param largearcflag
		 *            large arg flag: determines which arc to use (large/small)
		 * @param sweepflag
		 *            sweep flag: determines which arc to use
		 * @param x
		 *            horizontal position of the arc end point
		 * @param y
		 *            vertical position of the arc end point
		 */
		public void arcAbs(double rx, double ry, double xaxisrotation, boolean largearcflag, boolean sweepflag, double x, double y);

		/**
		 * Relative quadratic Bézier curve
		 *
		 * @param x1
		 *            the X coordinate of the quadratic control point
		 * @param y1
		 *            the Y coordinate of the quadratic control point
		 * @param x
		 *            the X coordinate of the final end point
		 * @param y
		 *            the Y coordinate of the final end point
		 */
		public void quadCurveToRel(double x1, double y1, double x, double y);

		/**
		 * Absolute quadratic Bézier curve
		 *
		 * @param x1
		 *            the X coordinate of the quadratic control point
		 * @param y1
		 *            the Y coordinate of the quadratic control point
		 * @param x
		 *            the X coordinate of the final end point
		 * @param y
		 *            the Y coordinate of the final end point
		 */
		public void quadCurveToAbs(double x1, double y1, double x, double y);

		/**
		 * Relative vertical line to
		 *
		 * @param y
		 *            the y coordinate
		 */
		public void vlineToRel(double y);

		/**
		 * Absolute vertical line to
		 *
		 * @param y
		 *            the y coordinate
		 */
		public void vlineToAbs(double y);

		/**
		 * Relative horizontal line to
		 *
		 * @param x
		 *            the x coordinate
		 */
		public void hlineToRel(double x);

		/**
		 * Absolute horizontal line to
		 *
		 * @param x
		 *            the x coordinate
		 */
		public void hlineToAbs(double x);

		/**
		 * Relative line to
		 *
		 * @param x
		 *            the x coordinate
		 * @param y
		 *            the y coordinate
		 */
		public void lineToRel(double x, double y);

		/**
		 * Absolute line to
		 *
		 * @param x
		 *            the x coordinate
		 * @param y
		 *            the y coordinate
		 */
		public void lineToAbs(double x, double y);

		/**
		 * Relative smooth cubic curve to
		 *
		 * @param x2
		 *            the X coordinate of the second B&eacute;zier control point
		 * @param y2
		 *            the Y coordinate of the second B&eacute;zier control point
		 * @param x
		 *            the X coordinate of the final end point
		 * @param y
		 *            the Y coordinate of the final end point
		 */
		public void scurveToRel(double x2, double y2, double x, double y);

		/**
		 * Absolute smooth cubic curve to
		 *
		 * @param x2
		 *            the X coordinate of the second B&eacute;zier control point
		 * @param y2
		 *            the Y coordinate of the second B&eacute;zier control point
		 * @param x
		 *            the X coordinate of the final end point
		 * @param y
		 *            the Y coordinate of the final end point
		 */
		public void scurveToAbs(double x2, double y2, double x, double y);

		/**
		 * Relative smooth quadratic curve to
		 *
		 * @param x
		 *            the X coordinate of the final end point
		 * @param y
		 *            the Y coordinate of the final end point
		 */
		public void squadCurveToRel(double x, double y);

		/**
		 * Relative smooth quadratic curve to
		 *
		 * @param x
		 *            the X coordinate of the final end point
		 * @param y
		 *            the Y coordinate of the final end point
		 */
		public void squadCurveToAbs(double x, double y);
	}

	static class SVGParser {
		private final String svgPath;
		private int currIdx = -1;
		private char lastCommand;

		SVGParser(String svgPath) {
			this.svgPath = svgPath.trim();
		}

		void parse(PathHandler h) {
			this.currIdx = -1;
			int[] data = findNextNonWS(this.svgPath, this.currIdx);

			if (data == null) {
				throw new IllegalStateException("Unable to find valid segment"); //$NON-NLS-1$
			} else if (data[0] != 'M' && data[0] != 'm') {
				throw new IllegalStateException("A path needs to start with a moveto command"); //$NON-NLS-1$
			}

			while (this.currIdx + 1 < this.svgPath.length()) {
				data = findNextNonWS(this.svgPath, this.currIdx);
				switch (data[0]) {
				case 'M':
				case 'm':
				case 'Z':
				case 'z':
				case 'L':
				case 'l':
				case 'H':
				case 'h':
				case 'V':
				case 'v':
				case 'C':
				case 'c':
				case 'S':
				case 's':
				case 'Q':
				case 'q':
				case 'T':
				case 't':
				case 'A':
				case 'a':
					this.lastCommand = (char) data[0];
					this.currIdx = data[1];
					break;
				default:
					this.currIdx = data[1]-1;
					break;
				}

				switch (this.lastCommand) {
				case 'M':
					parseMoveTo(false, h);
					break;
				case 'm':
					parseMoveTo(true, h);
					break;
				case 'Z':
					parseClosePath(false, h);
					break;
				case 'z':
					parseClosePath(true, h);
					break;
				case 'L':
					parseLineTo(false, h);
					break;
				case 'l':
					parseLineTo(true, h);
					break;
				case 'H':
					parseHLineTo(false, h);
					break;
				case 'h':
					parseHLineTo(true, h);
					break;
				case 'V':
					parseVLineTo(false, h);
					break;
				case 'v':
					parseVLineTo(true, h);
					break;
				case 'C':
					parseCurveTo(false, h);
					break;
				case 'c':
					parseCurveTo(true, h);
					break;
				case 'S':
					parseSCurveTo(false, h);
					break;
				case 's':
					parseSCurveTo(true, h);
					break;
				case 'Q':
					parseQuadCurveTo(false, h);
					break;
				case 'q':
					parseQuadCurveTo(true, h);
					break;
				case 'T':
					parseSQuadCurveTo(false, h);
					break;
				case 't':
					parseSQuadCurveTo(true, h);
					break;
				case 'A':
					parseArc(false, h);
					break;
				case 'a':
					parseArc(true, h);
					break;
				}
			}
		}

		private void parseLineTo(boolean relative, PathHandler h) {
			double x = nextNum();
			double y = nextNum();

			if (relative) {
				h.lineToRel(x, y);
			} else {
				h.lineToAbs(x, y);
			}
		}

		private void parseHLineTo(boolean relative, PathHandler h) {
			double x = nextNum();
			if (relative) {
				h.hlineToRel(x);
			} else {
				h.hlineToAbs(x);
			}
		}

		private void parseVLineTo(boolean relative, PathHandler h) {
			double y = nextNum();
			if (relative) {
				h.vlineToRel(y);
			} else {
				h.vlineToAbs(y);
			}
		}

		private void parseQuadCurveTo(boolean relative, PathHandler h) {
			double x1 = nextNum();
			double y1 = nextNum();
			double x2 = nextNum();
			double y2 = nextNum();

			if (relative) {
				h.quadCurveToRel(x1, y1, x2, y2);
			} else {
				h.quadCurveToAbs(x1, y1, x2, y2);
			}
		}

		private void parseSQuadCurveTo(boolean relative, PathHandler h) {
			double x = nextNum();
			double y = nextNum();

			if (relative) {
				h.squadCurveToRel(x, y);
			} else {
				h.squadCurveToAbs(x, y);
			}
		}

		private void parseArc(boolean relative, PathHandler h) {
			double rx = nextNum();
			double ry = nextNum();
			double xaxisrotation = nextNum();
			boolean largearcflag = nextNum() == 1.0;
			boolean sweepflag = nextNum() == 1.0;
			double x = nextNum();
			double y = nextNum();

			if (relative) {
				h.arcRel(rx, ry, xaxisrotation, largearcflag, sweepflag, x, y);
			} else {
				h.arcAbs(rx, ry, xaxisrotation, largearcflag, sweepflag, x, y);
			}
		}

		private void parseClosePath(boolean relative, PathHandler h) {
			this.currIdx += 1;
			if (relative) {
				h.closePathRel();
			} else {
				h.closePathAbs();
			}
		}

		private void parseMoveTo(boolean relative, PathHandler h) {
			double x = nextNum();
			double y = nextNum();
			if (relative) {
				h.moveToRel(x, y);
			} else {
				h.moveToAbs(x, y);
			}
		}

		private void parseCurveTo(boolean relative, PathHandler h) {
			double x1 = nextNum();
			double y1 = nextNum();
			double x2 = nextNum();
			double y2 = nextNum();

			double x = nextNum();
			double y = nextNum();

			if (relative) {
				h.curveToRel(x1, y1, x2, y2, x, y);
			} else {
				h.curveToAbs(x1, y1, x2, y2, x, y);
			}
		}

		private void parseSCurveTo(boolean relative, PathHandler h) {
			double x2 = nextNum();
			double y2 = nextNum();
			double x = nextNum();
			double y = nextNum();

			if (relative) {
				h.scurveToRel(x2, y2, x, y);
			} else {
				h.scurveToAbs(x2, y2, x, y);
			}
		}

		private double nextNum() {
			while (this.currIdx + 1 < this.svgPath.length() && (Character.isWhitespace(this.svgPath.charAt(this.currIdx + 1)) || this.svgPath.charAt(this.currIdx + 1) == ',')) {
				this.currIdx++;
			}

			StringBuilder num = new StringBuilder();
			char c;
			while (this.currIdx + 1 < this.svgPath.length() && ((c = this.svgPath.charAt(this.currIdx + 1)) == '.' || c == 'e' || c == 'E' || c == '-' || c == '+' || Character.isDigit(c))) {
				num.append(c);
				this.currIdx++;
			}

			return Double.parseDouble(num.toString());
		}

		private static int[] findNextNonWS(String path, int currIdx) {
			int idx = currIdx;
			while (++idx < path.length()) {
				char charAt = path.charAt(idx);
				if (!Character.isWhitespace(charAt)) {
					return new int[] { charAt, idx };
				}
			}
			return null;
		}

	}

}
