package ru.soap.teamservice.config;

import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Properties;

public class DataSourceFactory {

    private static final Properties DB_SETTINGS = new Properties();
    private final DataSource dataSource;

    public DataSourceFactory() {
        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        String root = Objects.requireNonNull(Thread.currentThread().getContextClassLoader().
                getResource("application.properties").getPath());
        try (InputStream inputStream = new FileInputStream(root)) {
            DB_SETTINGS.load(inputStream);
            dataSource.setUrl(DB_SETTINGS.getProperty("db.url"));
            dataSource.setUser(DB_SETTINGS.getProperty("db.user"));
            dataSource.setPassword(DB_SETTINGS.getProperty("db.password"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.dataSource = dataSource;
    }


    public static Connection connection() throws SQLException {
        return SingletonHelper.INSTANCE.dataSource.getConnection();
    }

    private static class SingletonHelper {
        private final static DataSourceFactory INSTANCE = new DataSourceFactory();
    }
}
