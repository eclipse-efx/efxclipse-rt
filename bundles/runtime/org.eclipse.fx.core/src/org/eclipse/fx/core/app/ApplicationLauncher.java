//package org.eclipse.fx.core.app;
//
//import java.net.URL;
//import java.util.Map;
//import java.util.Optional;
//import java.util.concurrent.CompletableFuture;
//
//import org.eclipse.fx.core.ArrayUtils;
//import org.eclipse.fx.core.ServiceUtils;
//
//public class ApplicationLauncher {
//	public static void main(String[] args) {
//		Map<String, Object> parameters = ArrayUtils.toMap(args);
//		start(parameters);
//	}
//
//	public static CompletableFuture<ExitStatus> start(Map<String, Object> parameters) {
//		if( parameters.containsKey("application") ) {
//			String appId = (String) parameters.get("application");
//			Optional<Application> application = ServiceUtils.getServiceReferenceList(Application.class)
//				.stream()
//				.filter( r -> appId.equals(r.getProperties().get("id")))
//				.findFirst()
//				.map( r -> r.get());
//			if( application.isPresent() ) {
//				ApplicationInstance instance = application.get().create();
//				return instance.launch(new ApplicationContextImpl());
//			} else {
//				throw new IllegalStateException("No application with id '"+appId+"' is available.");
//			}
//		} else {
//			throw new IllegalStateException("No application id provided");
//		}
//	}
//
//	static class ApplicationContextImpl implements ApplicationContext {
//
//		@Override
//		public String[] getApplicationArguments() {
//			// TODO Auto-generated method stub
//			return null;
//		}
//
//		@Override
//		public void applicationRunning() {
//			// TODO Auto-generated method stub
//
//		}
//
//		@Override
//		public Optional<URL> getSplashImage() {
//			// TODO Auto-generated method stub
//			return null;
//		}
//
//		@Override
//		public Object getApplicationProperty(String key) {
//			// TODO Auto-generated method stub
//			return null;
//		}
//
//	}
//}
