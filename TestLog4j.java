package log4j;

import org.apache.log4j.SimpleLayout;

import ch.qos.logback.classic.PatternLayout;
import ch.qos.logback.classic.html.HTMLLayout;
import ch.qos.logback.classic.log4j.XMLLayout;
import ch.qos.logback.core.ConsoleAppender;
import ch.qos.logback.core.FileAppender;
import ch.qos.logback.core.Layout;

public class TestLog4j {

	private static Logger log = Logger.getLogger(TestLog4j.class);

	public static void main(String[] args) throws Exception {
		// Create layout
		Layout layout = new SimpleLayout();
		Layout layout2 = new HTMLLayout();
		Layout layout3 = new XMLLayout();
		Layout layout4 = new PatternLayout("%d %c %M %m %n");

		// create Apender +link Layout
		Appender appender = new ConsoleAppender(layout4);
		Appender appender2 = (Appender) new FileAppender((org.apache.log4j.Layout) layout2,
				"C:\\Users\\LavanyaGC\\Desktop\\Logs\\data.log");

		// add apender to logger Object
		log.addAppender(appender);
		//log.addAppender(appender2);

		log.info("This is info");
		log.debug("this is debug");
		log.warn("this is Warn");
		log.error("this is error");
		log.fatal("this is fatal");

	}

}
