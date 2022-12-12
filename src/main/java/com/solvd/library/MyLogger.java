package com.solvd.library;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyLogger {
    private static MyLogger instance = null;
    protected final static Logger logger = LogManager.getLogger(MyLogger.class);

    private MyLogger() {
        super();
    }

    public static MyLogger getInstance() {
        if (instance == null) {
            instance = new MyLogger();
        }
        return instance;
    }

    public void info(String msg) {
        logger.info(msg);
    }

    public void info(Object obj) {
        logger.info(obj);
    }

    public void warn(String msg) {
        logger.warn(msg);
    }
}
