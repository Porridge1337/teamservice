package ru.soap.teamservice.dao.impl;


import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.soap.teamservice.config.HibernateFactory;
import ru.soap.teamservice.dao.DaoUser;
import ru.soap.teamservice.model.User;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoUserImpl implements DaoUser {

    private final Logger LOGGER = Logger.getLogger(DaoUser.class.getName());

    @Override
    public List<User> findAll() {
        try (Session session = HibernateFactory.getSessionFactory().getCurrentSession()) {
            Transaction transaction = session.beginTransaction();
            List<User> userManyToManies = session.createQuery("SELECT DISTINCT (u) from User u LEFT join fetch u.group " +
                    "LEFT join fetch u.roles", User.class).getResultList();
            if (userManyToManies.isEmpty()) {
                RuntimeException ex = new NoSuchElementException("Database is empty");
                LOGGER.log(Level.SEVERE, ex.toString());
                throw ex;
            }
            transaction.commit();
            return userManyToManies;
        }
    }

    @Override
    public List<User> findUsersByRole(String roleName) {
        try (Session session = HibernateFactory.getSessionFactory().getCurrentSession()) {
            Transaction transaction = session.beginTransaction();
            List<User> usersByRole = session.createQuery("SELECT DISTINCT (u) from User u LEFT join fetch u.group " +
                            "LEFT join fetch u.roles s WHERE s.roleName= :roleName",
                    User.class).setParameter("roleName", roleName).getResultList();
            if (usersByRole.isEmpty()) {
                RuntimeException ex = new NoSuchElementException("Can't find Users by role " + roleName);
                LOGGER.log(Level.SEVERE, ex.toString());
                throw ex;
            }
            transaction.commit();
            return usersByRole;
        }
    }

    @Override
    public List<User> findUsersByGroup(String groupName) {
        try (Session session = HibernateFactory.getSessionFactory().getCurrentSession()) {
            Transaction transaction = session.beginTransaction();
            List<User> usersByGroup = session.createQuery("SELECT DISTINCT (u) from User u LEFT join fetch u.group " +
                            "LEFT join fetch u.roles WHERE u.group.group = :groupName",
                    User.class).setParameter("groupName", groupName).getResultList();
            if (usersByGroup.isEmpty()) {
                RuntimeException ex = new NoSuchElementException("Can't find Users by group " + usersByGroup);
                LOGGER.log(Level.SEVERE, ex.toString());
                throw ex;
            }
            transaction.commit();
            return usersByGroup;
        }
    }

    @Override
    public Optional<User> findUserById(int id) {
        try (Session session = HibernateFactory.getSessionFactory().getCurrentSession()) {
            Transaction transaction = session.beginTransaction();
            List<User> usersById = session.createQuery("SELECT DISTINCT (u) from User u LEFT JOIN FETCH u.roles " +
                            "LEFT join fetch u.group WHERE u.id = :id",
                    User.class).setParameter("id", id).list();
            if (usersById.isEmpty()) {
                RuntimeException ex = new NoSuchElementException("Can't find Users by id " + usersById);
                LOGGER.log(Level.SEVERE, ex.toString());
                throw ex;
            }
            transaction.commit();
            return Optional.of(usersById.get(0));
        }
    }

    @Override
    public Optional<User> findUserByLogin(String login) {
        try (Session session = HibernateFactory.getSessionFactory().getCurrentSession()) {
            Transaction transaction = session.beginTransaction();
            List<User> usersByLogin = session.createQuery("SELECT DISTINCT (u) from User u LEFT JOIN FETCH u.roles " +
                            "LEFT join fetch u.group WHERE u.login = :login",
                    User.class).setParameter("login", login).list();
            if (usersByLogin.isEmpty()) {
                RuntimeException ex = new NoSuchElementException("Can't find Users by login " + usersByLogin);
                LOGGER.log(Level.SEVERE, ex.toString());
                throw ex;
            }
            transaction.commit();
            return Optional.of(usersByLogin.get(0));
        }
    }

    @Override
    public Optional<User> findUserByTelegramId(String telegramId) {
        try (Session session = HibernateFactory.getSessionFactory().getCurrentSession()) {
            Transaction transaction = session.beginTransaction();
            List<User> usersByTelegramId = session.createQuery("SELECT DISTINCT (u) from User u LEFT JOIN FETCH u.roles " +
                            "LEFT join fetch u.group WHERE u.telegramId = :telegramId",
                    User.class).setParameter("telegramId", Long.parseLong(telegramId)).list();
            if (usersByTelegramId.isEmpty()) {
                RuntimeException ex = new NoSuchElementException("Can't find Users by telegram_id " + usersByTelegramId);
                LOGGER.log(Level.SEVERE, ex.toString());
                throw ex;
            }
            transaction.commit();
            return Optional.of(usersByTelegramId.get(0));
        }
    }

    @Override
    public boolean save(User user) {
        try (Session session = HibernateFactory.getSessionFactory().getCurrentSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(user);
            transaction.commit();
            return true;
        }
    }

    @Override
    public boolean update(User user) {
        try (Session session = HibernateFactory.getSessionFactory().getCurrentSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(user);
            transaction.commit();
            return true;
        }
    }

    @Override
    public boolean deleteUserById(int id) {
        try (Session session = HibernateFactory.getSessionFactory().getCurrentSession()) {
            Transaction transaction = session.beginTransaction();
            User deletingUser = session.find(User.class, id);
            session.remove(deletingUser);
            transaction.commit();
            return true;
        }
    }
}
