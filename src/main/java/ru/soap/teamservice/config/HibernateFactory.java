package ru.soap.teamservice.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateFactory {

    private static final Configuration CONFIG;

    static {
        CONFIG = new Configuration();
        CONFIG.configure();
    }

    public static SessionFactory getSessionFactory() {
        SessionFactory sessionFactory = CONFIG.buildSessionFactory();
        return sessionFactory;
    }

}
