package ru.soap.teamservice.service.impl;


import ru.soap.teamservice.config.DataSourceFactory;
import ru.soap.teamservice.model.Role;
import ru.soap.teamservice.service.DaoRole;

import javax.jws.WebService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebService(endpointInterface = "ru.soap.teamservice.service.DaoRole")
public class DaoRoleImpl implements DaoRole {

    private static final Logger LOGGER = Logger.getLogger(DaoRole.class.getName());

    @Override
    public List<Role> findUserRoles() {
        List<Role> userRoleById = new ArrayList<>();
        try (Connection connection = DataSourceFactory.connection()) {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM service.roles");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Role role = new Role(rs.getInt("r_id"), rs.getString("rolename"));
                userRoleById.add(role);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Exception when trying found users roles.", e);
        }
        return userRoleById;
    }

    @Override
    public boolean saveNewRole(Role role) {
        boolean resultSave = false;
        try (Connection connection = DataSourceFactory.connection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO service.roles (rolename) " +
                    "VALUES (?)");
            preparedStatement.setString(1, role.getRoleName());
            resultSave = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Exception when trying create new role.", e);
        }
        return resultSave;
    }
}
