package com.gabodev.bankclientbackend.utils;

import com.gabodev.bankclientbackend.BankClientBackendApplication;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
public class LogUtils {
    private static final Logger logger = LogManager.getLogger(BankClientBackendApplication.class);

    public static void logInfo(String message) {
        logger.info(message);
    }

    public static void logError(String message, Throwable throwable) {
        logger.error(message, throwable);
    }

}
