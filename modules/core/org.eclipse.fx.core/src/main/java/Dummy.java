import org.eclipse.fx.core.log.FluentLogContext;
import org.eclipse.fx.core.log.FluentLogger;
import org.eclipse.fx.core.log.Logger;
import org.eclipse.fx.core.log.LoggerCreator;

public class Dummy {
	@SuppressWarnings({ "boxing", "nls" })
	public static void main(String[] args) {
		Logger logger = LoggerCreator.createLogger(Dummy.class);
		for (int i = 0; i < 1000; i++) {
			if (i % 100 == 100) {
				logger.debugf("Processed items %s", i);
			}
		}
		
		FluentLogger fl = FluentLogger.of(logger);
		FluentLogContext ctx = fl.atDebug().throttleByCount(100);
		for (int i = 0; i < 1000; i++) {
			ctx.log("Processed items %s", i);
		}

		
	}
}
