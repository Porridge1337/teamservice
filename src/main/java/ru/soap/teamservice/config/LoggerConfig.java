package ru.soap.teamservice.config;

import ru.soap.teamservice.WebServiceServer;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class LoggerConfig {

    private static Logger logger = Logger.getLogger(WebServiceServer.class.getName());

    public LoggerConfig() {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("logger.properties")) {
            LogManager.getLogManager().readConfiguration(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
            logger.log(Level.SEVERE, "logger properties didnt find", e);
        }
    }

    public static LoggerConfig initialize() {
        return SingletonHelper.INSTANCE;
    }

    private static class SingletonHelper {
        private final static LoggerConfig INSTANCE = new LoggerConfig();
    }

}
