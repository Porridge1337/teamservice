package ru.soap.teamservice.dao.impl;


import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.soap.teamservice.config.HibernateFactory;
import ru.soap.teamservice.dao.DaoRole;
import ru.soap.teamservice.model.Role;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DaoRoleImpl implements DaoRole {

    private final Logger LOGGER = Logger.getLogger(DaoRole.class.getName());

    @Override
    public List<Role> findUserRoles() {
        try (Session session = HibernateFactory.getSessionFactory().getCurrentSession()) {
            Transaction transaction = session.beginTransaction();
            List<Role> roles = session.createQuery("SELECT r from Role r LEFT JOIN FETCH r.usersRole", Role.class)
                    .getResultList();
            if (roles.isEmpty()) {
                RuntimeException ex = new NoSuchElementException("Role database is empty");
                LOGGER.log(Level.SEVERE, ex.toString());
                throw ex;
            }
            transaction.commit();
            return roles;
        }
    }

    @Override
    public boolean saveNewRole(Role role) {
        try (Session session = HibernateFactory.getSessionFactory().getCurrentSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(role);
            transaction.commit();
            return true;
        }
    }
}
