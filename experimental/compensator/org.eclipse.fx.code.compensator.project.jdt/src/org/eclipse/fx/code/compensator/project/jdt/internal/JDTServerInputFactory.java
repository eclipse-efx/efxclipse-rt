package org.eclipse.fx.code.compensator.project.jdt.internal;


import org.eclipse.emf.common.util.URI;
import org.eclipse.fx.code.compensator.editor.Input;
import org.eclipse.fx.code.compensator.editor.services.InputFactory;
import org.eclipse.fx.code.server.jdt.JDTServer;
import org.eclipse.fx.code.server.jdt.JDTServerFactory;

public class JDTServerInputFactory implements InputFactory<JDTServerInput> {
	private JDTServerFactory factory;

	public void registerJDTServerFactory(JDTServerFactory factory) {
		this.factory = factory;
	}

	@Override
	public boolean applies(String url) {
		return url.startsWith("jdt:");
	}

	@Override
	public Class<JDTServerInput> createInput(String url) {
//		URI uri = URI.createURI(url);
//		JDTServer server = factory.getOrCreateServer(uri.segment(0));
//		String module = uri.segment(1);
//		StringBuilder b = new StringBuilder();
//
//		for( int i = 2; i < uri.segmentCount(); i++ ) {
//			if( b.length() > 0 ) {
//				b.append('/');
//			}
//			b.append(uri.segment(i));
//		}
//		return (Input<O>) new JDTServerInput(server,null,url,module,b.toString());
		return JDTServerInput.class;
	}

}
