package com.coretestautomation.core.logger;

import org.apache.logging.log4j.Level;

public class Logger {
    private static final String LOGGER_NAME = Logger.class.getCanonicalName();
    private static final org.apache.logging.log4j.Logger LOG = org.apache.logging.log4j.LogManager.getLogger(Logger.class);

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
        LOG.log(Level.INFO, LOGGER_NAME, message, null);
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
