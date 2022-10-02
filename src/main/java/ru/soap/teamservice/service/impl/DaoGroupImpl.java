package ru.soap.teamservice.service.impl;

import ru.soap.teamservice.config.DataSourceFactory;
import ru.soap.teamservice.model.Group;
import ru.soap.teamservice.service.DaoGroup;
import ru.soap.teamservice.service.DaoUser;

import javax.jws.WebService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebService(endpointInterface = "ru.soap.teamservice.service.DaoGroup")
public class DaoGroupImpl implements DaoGroup {

    private static final Logger LOGGER = Logger.getLogger(DaoGroup.class.getName());


    @Override
    public List<Group> findAllGroups() {
        List<Group> groupList = new ArrayList<>();
        try (Connection connection = DataSourceFactory.connection()) {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM service.groups");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Group group = new Group(rs.getInt("g_id"), rs.getString("groupname"));
                groupList.add(group);
            }
        } catch (SQLException e) {
            //e.printStackTrace();
            LOGGER.log(Level.SEVERE, "Exception when trying found all groups.", e);
        }

        return groupList;
    }

    @Override
    public boolean saveGroup(Group group) {
        boolean resultSave = false;
        try (Connection connection = DataSourceFactory.connection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO service.groups (groupname) " +
                    "VALUES (?)");
            preparedStatement.setString(1, group.getGroup());
            resultSave = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            //e.printStackTrace();
            LOGGER.log(Level.SEVERE, "Exception when trying save group.", e);
        }
        return resultSave;
    }

    @Override
    public boolean updateGroup(Group group) {
        boolean resultUpdate = false;
        try (Connection connection = DataSourceFactory.connection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE service.groups SET groupname = ?" +
                    " WHERE id = ? ");
            preparedStatement.setString(1, group.getGroup());
            preparedStatement.setInt(2, group.getG_id());
            resultUpdate = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            //e.printStackTrace();
            LOGGER.log(Level.SEVERE, "Exception when trying update group.", e);
        }
        return resultUpdate;
    }

    @Override
    public boolean deleteGroupById(int id) {
        boolean resultDelete = false;
        try (Connection connection = DataSourceFactory.connection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE from service.groups WHERE g_id = ?");
            preparedStatement.setInt(1, id);
            resultDelete = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            //e.printStackTrace();
            LOGGER.log(Level.SEVERE, "Exception when trying delete group by id.", e);
        }
        return resultDelete;
    }
}
