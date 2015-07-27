package org.eclipse.fx.code.editor.services.internal;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.fx.code.editor.services.FileIconProvider;
import org.osgi.service.component.annotations.Component;

@Component
public class DefaultFileIconProvider implements FileIconProvider {

	private final Map<String, String> iconsMap;

	public DefaultFileIconProvider() {
		this.iconsMap = new HashMap<>();
//		this.iconsMap.put("dart", "platform:/plugin/org.eclipse.fx.code.editor/icons/16/dart.png");
		this.iconsMap.put("java", "platform:/plugin/org.eclipse.fx.code.editor/icons/16/java.png");
		this.iconsMap.put("class", "platform:/plugin/org.eclipse.fx.code.editor/icons/16/class.png");
	}

	@Override
	public boolean test(String t) {
		int index = t.lastIndexOf('.');
		if( index != -1 ) {
			return iconsMap.containsKey(t.substring(index+1));
		}
		return false;
	}

	@Override
	public String getFileIconUri(String uri) {
		int index = uri.lastIndexOf('.');
		String iconPath = null;
		if( index != -1 ) {
			iconPath = iconsMap.get(uri.substring(index+1));
		}

		if( iconPath == null ) {
			throw new IllegalStateException("No icon known for uri '"+uri+"'");
		}

		return iconPath;
	}

}
