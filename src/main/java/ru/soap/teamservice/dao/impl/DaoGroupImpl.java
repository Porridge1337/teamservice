package ru.soap.teamservice.dao.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.soap.teamservice.config.HibernateFactory;
import ru.soap.teamservice.dao.DaoGroup;
import ru.soap.teamservice.model.Group;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoGroupImpl implements DaoGroup {

    private final Logger LOGGER = Logger.getLogger(DaoGroup.class.getName());

    @Override
    public List<Group> findAllGroups() {
        try (Session session = HibernateFactory.getSessionFactory().getCurrentSession()) {
            Transaction transaction = session.beginTransaction();
            List<Group> groups = session.createQuery("SELECT g from Group g ", Group.class).getResultList();
            if (groups.isEmpty()) {
                RuntimeException ex = new NoSuchElementException("Database is empty");
                LOGGER.log(Level.SEVERE, ex.toString());
                throw ex;
            }
            transaction.commit();
            return groups;
        }
    }

    @Override
    public boolean saveGroup(Group group) {
        try (Session session = HibernateFactory.getSessionFactory().getCurrentSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(group);
            transaction.commit();
            return true;
        }
    }

    @Override
    public boolean updateGroup(Group group) {
        try (Session session = HibernateFactory.getSessionFactory().getCurrentSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(group);
            transaction.commit();
            return true;
        }
    }

    @Override
    public boolean deleteGroupById(int id) {
        try (Session session = HibernateFactory.getSessionFactory().getCurrentSession()) {
            Transaction transaction = session.beginTransaction();
            Group deletingUser = session.find(Group.class, id);
            session.remove(deletingUser);
            transaction.commit();
            return true;
        }
    }

}
