package ru.soap.teamservice.service.impl;

import com.sun.xml.internal.ws.developer.SchemaValidation;
import lombok.NoArgsConstructor;
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

@NoArgsConstructor
@WebService(endpointInterface = "ru.soap.teamservice.service.DaoRole")
@SchemaValidation(inbound = true, outbound = true)
public class DaoRoleImpl implements DaoRole {


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
            e.printStackTrace();
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
            e.printStackTrace();
        }
        return resultSave;
    }
}
