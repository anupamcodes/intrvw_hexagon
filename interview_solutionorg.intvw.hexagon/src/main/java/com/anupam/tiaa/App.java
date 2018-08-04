package com.anupam.tiaa;

import java.sql.Timestamp;

import org.apache.log4j.Logger;

/**
 * Hello world!
 *
 */
public class App 
{
	
	static Logger log = Logger.getLogger(App.class.getName());
    public static void main( String[] args )
    {
    	log.info("Engine Process Starts :"+new Timestamp(System.currentTimeMillis()));
        TiaaEngine engine = new TiaaEngine(args[0]);
        engine.process();
        log.info("Engine Process Ends :"+new Timestamp(System.currentTimeMillis()));
    }

	
}
