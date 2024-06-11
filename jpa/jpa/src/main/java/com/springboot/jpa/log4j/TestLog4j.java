package com.springboot.jpa.log4j;

import java.io.IOException;

import org.apache.log4j.Appender;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.HTMLLayout;
import org.apache.log4j.Layout;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.spi.LoggerFactory;
import org.apache.log4j.xml.XMLLayout;
//import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

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
