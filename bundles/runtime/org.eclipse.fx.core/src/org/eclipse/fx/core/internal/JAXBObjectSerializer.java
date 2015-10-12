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
package org.eclipse.fx.core.internal;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.fx.core.ObjectSerializer;
import org.osgi.service.component.annotations.Component;

/**
 * A default object serializer using JAXB
 */
@Component
public class JAXBObjectSerializer implements ObjectSerializer {

	@Override
	public String getId() {
		return ObjectSerializer.JAXB_SERIALIZER;
	}

	@Override
	public String serialize(Object object) {
		if (object instanceof List) {
			object = new ListWrapper<>((List<?>) object);
		}
		try (StringWriter w = new StringWriter()) {
			JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

			jaxbMarshaller.marshal(object, w);
			return w.toString();
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public <O> O deserialize(Class<O> clazz, String value) {
		if (clazz == List.class) {
			clazz = (Class<O>) ListWrapper.class;
		}

		try (StringReader r = new StringReader(value)) {
			JAXBContext jaxbContext = JAXBContext.newInstance(clazz);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

			Object unmarshal = jaxbUnmarshaller.unmarshal(r);
			if (unmarshal instanceof ListWrapper<?>) {
				return (O) ((ListWrapper<?>) unmarshal).list;
			}
			return (O) unmarshal;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Wraps simple lists
	 *
	 * @param <O>
	 *            the type
	 */
	@XmlRootElement
	public static class ListWrapper<O> {
		List<O> list;

		/**
		 * Create an instance
		 */
		public ListWrapper() {
		}

		/**
		 * Create an instance
		 *
		 * @param list
		 *            the list to wrap
		 */
		public ListWrapper(List<O> list) {
			this.list = list;
		}

		/**
		 * @return the list
		 */
		public List<O> getList() {
			return this.list;
		}

		/**
		 * Set the new list
		 *
		 * @param list
		 *            the list
		 */
		public void setList(List<O> list) {
			this.list = list;
		}
	}
}