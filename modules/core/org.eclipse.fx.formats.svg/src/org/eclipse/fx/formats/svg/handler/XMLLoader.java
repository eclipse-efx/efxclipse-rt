/*******************************************************************************
 * Copyright (c) 2012 BestSolution.at and others.
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
package org.eclipse.fx.formats.svg.handler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;
import java.util.zip.GZIPInputStream;

import javax.xml.bind.DatatypeConverter;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.fx.formats.svg.converter.FXMLConverter;
import org.eclipse.fx.formats.svg.svg.ContentElement;
import org.eclipse.fx.formats.svg.svg.CoreAttributes;
import org.eclipse.fx.formats.svg.svg.SvgElement;
import org.eclipse.fx.formats.svg.svg.SvgPackage;
import org.eclipse.fx.formats.svg.svg.SvgSvgElement;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Loading an SVG and convert it into an FXML structure
 */
public class XMLLoader {
	private static final Map<String, String> SUFFIXMAP = new HashMap<String, String>();

	{
		SUFFIXMAP.put("image/png", "png"); //$NON-NLS-1$ //$NON-NLS-2$
		SUFFIXMAP.put("image/jpeg", "jpg"); //$NON-NLS-1$ //$NON-NLS-2$
		SUFFIXMAP.put("image/jpg", "jpg"); //$NON-NLS-1$//$NON-NLS-2$
		SUFFIXMAP.put("image/gif", "gif"); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * Test method should not be called
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		try {
			// TODO use workspace file
			File f = new File(
					"/Users/tomschindl/git/e-fx-clipse/org.eclipse.fx.formats.svg/samples/lr.svg"); //$NON-NLS-1$
			try (InputStream in = f.getName().endsWith("svgz") ? new GZIPInputStream(f.toURI().toURL().openStream()) : f.toURI().toURL().openStream()) { //$NON-NLS-1$
				if( in != null ) {
					// TODO use workspace file
					SvgSvgElement g = loadDocument(
									"/Users/tomschindl/git/e-fx-clipse/org.eclipse.fx.formats.svg/samples/test.fxml", //$NON-NLS-1$
									in);
					// SvgSvgElement g = l.loadDocument(new
					// File("/Users/tomschindl/git/e-fx-clipse/org.eclipse.fx.formats.svg/samples/w3/images/shapes/rect01.svg").toURL().openStream());
					// SvgSvgElement g = l.loadDocument(new
					// File("/Users/tomschindl/git/e-fx-clipse/org.eclipse.fx.formats.svg/samples/w3/images/filters/filters01.svg").toURL().openStream());
					FXMLConverter c = new FXMLConverter(g);
					String fxmlData = c.generate().toString();
					// TODO use workspace file
					File outFile = new File(
							"/Users/tomschindl/git/e-fx-clipse/org.eclipse.fx.formats.svg/samples/test.fxml"); //$NON-NLS-1$
					try (FileOutputStream out = new FileOutputStream(outFile)) {
						out.write(fxmlData.getBytes());
						out.close();
					}					
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Load the SVG-File into an in memory model
	 * 
	 * @param outFile
	 *            the output file, used to calculate relative paths, might by
	 *            <code>null</code>
	 * @param in
	 *            the inputstream
	 * @return the in memory model of the SVG-File
	 */
	public static SvgSvgElement loadDocument(@Nullable String outFile, @NonNull InputStream in) {
		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			factory.setNamespaceAware(true);
			SAXParser parser = factory.newSAXParser();
			Handler handler = new Handler();
			parser.parse(in, handler);
			postProcess(outFile, handler.cssString, handler.root);
			return handler.root;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static void postProcess(@Nullable String outFile, StringBuilder cssString,
			SvgSvgElement root) throws IOException {
		int imageCount = 0;
		TreeIterator<EObject> it = EcoreUtil.getAllContents(root, true);

		if (cssString != null) {
			File outCssFile;
			if (outFile == null) {
				outCssFile = File.createTempFile("conversion", ".css"); //$NON-NLS-1$ //$NON-NLS-2$
				outCssFile.deleteOnExit();
			} else {
				outCssFile = new File(outFile + ".css"); //$NON-NLS-1$
			}

			try(FileOutputStream out = new FileOutputStream(outCssFile)) {
				out.write(cssString.toString().getBytes());
				out.close();
				root.setStyleSheet("@" + outCssFile.getName()); //$NON-NLS-1$
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		while (it.hasNext()) {
			EObject o = it.next();
			EStructuralFeature f = o.eClass().getEStructuralFeature("style"); //$NON-NLS-1$
			if (f != null) {
				String s = (String) o.eGet(f);
				if (s != null && s.trim().length() > 0) {
					for (Entry<String, String> e : valueMap(s).entrySet()) {
						String name = e.getKey().replaceAll("-", "_");  //$NON-NLS-1$//$NON-NLS-2$
						EStructuralFeature styleFeature = o.eClass()
								.getEStructuralFeature(name.trim());
						if (styleFeature != null) {
							Object value = EcoreUtil.createFromString(
									(EDataType) styleFeature.getEType(),
									e.getValue());
							o.eSet(styleFeature, value);
						} else {
							System.err
									.println("Could not find style attribute: " //$NON-NLS-1$
											+ name + " on " + o.eClass()); //$NON-NLS-1$
						}
					}
				}
			}

			f = o.eClass().getEStructuralFeature("xlink__href"); //$NON-NLS-1$
			if (f != null) {
				EStructuralFeature instanceFeature = o.eClass()
						.getEStructuralFeature("resolvedInstance"); //$NON-NLS-1$
				String link = (String) o.eGet(f);
				if (link != null && link.startsWith("data:")) { //$NON-NLS-1$
					String type = link.substring(0, link.indexOf(';'));
					// String encoding =
					// link.substring(link.indexOf(';')+1,link.indexOf(','));
					String data = link.substring(link.indexOf(',') + 1);
					byte[] b = DatatypeConverter.parseBase64Binary(data);
					try {
						String suffix = SUFFIXMAP.get(type.toLowerCase());
						if (suffix == null) {
							suffix = type.substring(type.indexOf('/') + 1);
						}

						File outDir;

						if (outFile == null) {
							outDir = File.createTempFile("conversion", "_img");  //$NON-NLS-1$//$NON-NLS-2$
							outDir.delete();
						} else {
							outDir = new File(outFile + "img"); //$NON-NLS-1$
						}

						File outF = new File(outDir, "img_" + (imageCount++) //$NON-NLS-1$
								+ "." + suffix); //$NON-NLS-1$
						outDir.mkdirs();
						try(FileOutputStream out = new FileOutputStream(outF)) {
							out.write(b);
							out.close();
							o.eSet(f, "@" + outDir.getName() + "/" + outF.getName());  //$NON-NLS-1$//$NON-NLS-2$
						}
						
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					if (link != null && link.trim().length() > 0) {
						link = link.substring(1);
						TreeIterator<EObject> internalIt = EcoreUtil
								.getAllContents(root, true);
						while (internalIt.hasNext()) {
							EObject internalO = internalIt.next();
							if (internalO instanceof CoreAttributes) {
								if (link.equals(internalO
										.eGet(SvgPackage.Literals.CORE_ATTRIBUTES__ID))) {
									o.eSet(instanceFeature,
											EcoreUtil.copy(internalO));
									break;
								}
							}
						}
					}
				}
			}
		}
	}

	private static Map<String, String> valueMap(String styleString) {
		// TODO This is a very very poor algorithm
		Map<String, String> map = new HashMap<String, String>();
		for (String o : styleString.split(";")) { //$NON-NLS-1$
			String k = o.substring(0, o.indexOf(":")); //$NON-NLS-1$
			String v = o.substring(o.indexOf(":") + 1, o.length()); //$NON-NLS-1$
			map.put(k, v);
		}
		return map;
	}

	static class Handler extends DefaultHandler {
		SvgSvgElement root;

		private Stack<SvgElement> elementStack = new Stack<SvgElement>();

		private boolean inCSS;
		StringBuilder cssString;

		private static final String SVG_NS = "http://www.w3.org/2000/svg"; //$NON-NLS-1$
		private static final String XLINK_NS = "http://www.w3.org/1999/xlink"; //$NON-NLS-1$

		@Override
		public InputSource resolveEntity(String arg0, String arg1)
				throws IOException, SAXException {
			return new InputSource(new StringReader("")); //$NON-NLS-1$
		}

		@Override
		public void startElement(String uri, String localName, String qName,
				Attributes attributes) throws SAXException {
			if (SVG_NS.equals(uri)) {
				if (localName.equals("style")) { //$NON-NLS-1$
					this.inCSS = true;
					this.cssString = new StringBuilder();
					return;
				}

				EClass ec = (EClass) SvgPackage.eINSTANCE.getEClassifier("Svg" //$NON-NLS-1$
						+ Character.toUpperCase(localName.charAt(0))
						+ localName.substring(1) + "Element"); //$NON-NLS-1$
				if (ec != null) {
					SvgElement e = (SvgElement) EcoreUtil.create(ec);

					for (int i = 0; i < attributes.getLength(); i++) {
						if (SVG_NS.equals(attributes.getURI(i))
								|| "".equals(attributes.getURI(i))) { //$NON-NLS-1$
							String name = attributes.getLocalName(i)
									.replaceAll("-", "_"); //$NON-NLS-1$ //$NON-NLS-2$
							EStructuralFeature f = e.eClass()
									.getEStructuralFeature(name);
							if (f != null) {
								Object o = EcoreUtil.createFromString(
										(EDataType) f.getEType(),
										attributes.getValue(i));
								e.eSet(f, o);
							} else {
								System.err
										.println("Could not find feature '" //$NON-NLS-1$
												+ name + "' in " //$NON-NLS-1$
												+ e.eClass().getName());
							}
						} else if (XLINK_NS.equals(attributes.getURI(i))) {
							String name = "xlink__" //$NON-NLS-1$
									+ attributes.getLocalName(i).replaceAll(
											"-", "_");  //$NON-NLS-1$//$NON-NLS-2$
							EStructuralFeature f = e.eClass()
									.getEStructuralFeature(name);
							if (f != null) {
								Object o = EcoreUtil.createFromString(
										(EDataType) f.getEType(),
										attributes.getValue(i));
								e.eSet(f, o);
							} else {
								System.err
										.println("Could not find feature '" //$NON-NLS-1$
												+ name + "' in " //$NON-NLS-1$
												+ e.eClass().getName());
							}
						}
					}

					if (this.elementStack.isEmpty()) {
						this.root = (SvgSvgElement) e;
					} else {
						@SuppressWarnings("unchecked")
						ContentElement<SvgElement> c = (ContentElement<SvgElement>) this.elementStack.peek();
						c.getChildren().add(e);
					}

					this.elementStack.push(e);

				} else {
					throw new IllegalStateException("Unable to find element '" //$NON-NLS-1$
							+ localName + "'"); //$NON-NLS-1$
				}
			}
		}

		@Override
		public void characters(char[] ch, int start, int length)
				throws SAXException {
			if (this.inCSS) {
				this.cssString.append(ch, start, length);
			}
		}

		@Override
		public void endElement(String uri, String localName, String qName)
				throws SAXException {
			if (localName.equals("style")) { //$NON-NLS-1$
				this.inCSS = false;
			} else if (SVG_NS.equals(uri) && !localName.equals("svg")) { //$NON-NLS-1$
				this.elementStack.pop();
			}
		}
	}
}
