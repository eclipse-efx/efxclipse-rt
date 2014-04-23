package org.eclipse.fx.sample.singlesource.views;

import java.io.File;

import javax.annotation.PostConstruct;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;

public class JFaceHelloWorld {
	private static final String FOLDER = "FOLDER";
	private static final String JAVA_FILE = "JAVA_FILE";
	private static final String PDF_FILE = "PDF_FILE";
	private static final String EXCEL_FILE = "EXCEL_FILE";
	private static final String OFFICE_FILE = "OFFICE_FILE";
	private static final String IMG_FILE = "IMG_FILE";
	private static final String TEXT_FILE = "TEXT_FILE";
	private static final String GENERIC_FILE = "GENERIC_FILE";
	
	static {
		JFaceResources.getImageRegistry().put(FOLDER, ImageDescriptor.createFromURL(JFaceHelloWorld.class.getClassLoader().getResource("/icons/folder.png")));
		JFaceResources.getImageRegistry().put(JAVA_FILE, ImageDescriptor.createFromURL(JFaceHelloWorld.class.getClassLoader().getResource("/icons/page_white_cup.png")));
		JFaceResources.getImageRegistry().put(PDF_FILE, ImageDescriptor.createFromURL(JFaceHelloWorld.class.getClassLoader().getResource("/icons/page_white_acrobat.png")));
		JFaceResources.getImageRegistry().put(EXCEL_FILE, ImageDescriptor.createFromURL(JFaceHelloWorld.class.getClassLoader().getResource("/icons/page_white_excel.png")));
		JFaceResources.getImageRegistry().put(OFFICE_FILE, ImageDescriptor.createFromURL(JFaceHelloWorld.class.getClassLoader().getResource("/icons/page_white_office.png")));
		JFaceResources.getImageRegistry().put(IMG_FILE, ImageDescriptor.createFromURL(JFaceHelloWorld.class.getClassLoader().getResource("/icons/page_white_picture.png")));
		JFaceResources.getImageRegistry().put(TEXT_FILE, ImageDescriptor.createFromURL(JFaceHelloWorld.class.getClassLoader().getResource("/icons/page_white_text.png")));
		JFaceResources.getImageRegistry().put(GENERIC_FILE, ImageDescriptor.createFromURL(JFaceHelloWorld.class.getClassLoader().getResource("/icons/page_white.png")));
	}
	
	@PostConstruct
	public void initUI(Composite parent) {
		parent.setLayout(new FillLayout());
		
		File root = new File(System.getProperty("user.home"));
		
		TreeViewer viewer = new TreeViewer(parent);
		viewer.setContentProvider(new FileSystemContentProvider());
		viewer.setLabelProvider(new LabelProvider() {
			@Override
			public Image getImage(Object element) {
				File f = (File) element;
				if( f.isDirectory() ) {
					return JFaceResources.getImageRegistry().get(FOLDER);
				} else if( f.getName().endsWith(".java") ) {
					return JFaceResources.getImageRegistry().get(JAVA_FILE);
				} else if( f.getName().endsWith(".pdf") ) {
					return JFaceResources.getImageRegistry().get(PDF_FILE);
				} else if( f.getName().endsWith(".xls") ) {
					return JFaceResources.getImageRegistry().get(EXCEL_FILE);
				} else if( f.getName().endsWith(".doc") ) {
					return JFaceResources.getImageRegistry().get(OFFICE_FILE);
				} else if( f.getName().endsWith(".png") || f.getName().endsWith(".jpg") || f.getName().endsWith(".gif") ) {
					return JFaceResources.getImageRegistry().get(IMG_FILE);
				} else {
					return JFaceResources.getImageRegistry().get(GENERIC_FILE);
				}
			}
			
			@Override
			public String getText(Object element) {
				File f = (File) element;
				if( f == root ) {
					return f.getAbsolutePath();
				}
				return f.getName();
			}
		});
		viewer.setInput(new File[] {root});
	}
	
	static class FileSystemContentProvider implements ITreeContentProvider {

		@Override
		public void dispose() {
			
		}

		@Override
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			
		}

		@Override
		public Object[] getElements(Object inputElement) {
			return (Object[]) inputElement;
		}

		@Override
		public Object[] getChildren(Object parentElement) {
			File f = (File) parentElement;
			if( f.isDirectory() ) {
				return f.listFiles();	
			}
			return new Object[0];
		}

		@Override
		public Object getParent(Object element) {
			File f = (File) element;
			return f.getParentFile();
		}

		@Override
		public boolean hasChildren(Object element) {
			return getChildren(element).length > 0;
		}
		
	}
}
