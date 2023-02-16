package com.coretestautomation.core.logger;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {

    private static final String LOGGER_NAME = Log.class.getCanonicalName();
    private static final Logger LOG = LogManager.getLogger(Log.class);

    public static void warn(final String message) {
        LOG.log(Level.WARN, LOGGER_NAME, message, null);
    }

    public static void warn(final String message, final Throwable t) {
        LOG.log(Level.WARN, LOGGER_NAME, message, t);
    }

    public static void debug(final String message) {
        LOG.log(Level.DEBUG, LOGGER_NAME, message, null);
    }

    public static void debug(final String message, final Throwable t) {
        LOG.log(Level.DEBUG, LOGGER_NAME,  message, t);
    }

    public static void info(final Object message) {
        LOG.log(Level.INFO, LOGGER_NAME, message, null);
    }

    public static void info(final String message) {
        LOG.log(Level.INFO, message);
    }

    public static void info(final String message, final Throwable t) {
        LOG.log(Level.INFO, LOGGER_NAME, message, t);
    }

    public static void error(final String message) {
        LOG.log(Level.ERROR, LOGGER_NAME, message, null);
    }

    public static void error(final String message, final Throwable t) {
        LOG.log(Level.ERROR, LOGGER_NAME, message, t);
    }

    public static void fatal(final String message) {
        LOG.log(Level.FATAL, LOGGER_NAME, message, null);
    }

    public static void fatal(final String message, final Throwable t) {
        LOG.log(Level.FATAL, LOGGER_NAME, message, t);
    }
}
