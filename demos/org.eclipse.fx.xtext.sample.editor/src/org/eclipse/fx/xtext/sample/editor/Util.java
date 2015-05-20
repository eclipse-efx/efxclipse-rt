package org.eclipse.fx.xtext.sample.editor;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Util {
	public static String getFileContent(URI uri) {
		StringBuilder b = new StringBuilder();
		try {
			BufferedReader reader = Files.newBufferedReader(Paths.get(uri));
			String l;
			while( (l = reader.readLine()) != null ) {
				b.append(l + "\n");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return b.toString();
	}
}
