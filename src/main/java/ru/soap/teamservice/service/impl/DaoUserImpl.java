package ru.soap.teamservice.service.impl;

import com.sun.xml.internal.ws.developer.SchemaValidation;
import lombok.NoArgsConstructor;
import ru.soap.teamservice.config.DataSourceFactory;
import ru.soap.teamservice.model.Group;
import ru.soap.teamservice.model.Role;
import ru.soap.teamservice.model.User;
import ru.soap.teamservice.service.DaoUser;

import javax.jws.WebService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@WebService(endpointInterface = "ru.soap.teamservice.service.DaoUser")
@SchemaValidation(inbound = true, outbound = true)
public class DaoUserImpl implements DaoUser {

    @Override
    public List<User> findAll() {
        List<User> foundedUser = new ArrayList<>();
        try (Connection connection = DataSourceFactory.connection()) {
            PreparedStatement prepareStatement = connection.prepareStatement("SELECT * FROM service.users as usr\n" +
                    "join service.roles as rl\n" +
                    "on usr.role_fk=rl.r_id\n" +
                    "join service.gropus as gr\n" +
                    "on usr.group_fk = gr.g_id;");
            ResultSet rs = prepareStatement.executeQuery();
            while (rs.next()) {
                Role role = new Role();
                Group group = new Group();
                User user = new User();

                int userId = rs.getInt("id");

                int roleId = rs.getInt("r_id");
                int groupId = rs.getInt("g_id");

                role.setR_id(roleId);
                role.setRoleName(rs.getString("rolename"));

                group.setG_id(groupId);
                group.setGroup(rs.getString("groupname"));

                user.setId(userId);
                user.setUsername(rs.getString("username"));
                user.setSurname(rs.getString("surname"));
                user.setTelegramLogin(rs.getString("telegram_login"));
                user.setPhone(rs.getString("phone"));
                user.setRole(role);
                user.setGroup(group);

                foundedUser.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return foundedUser;
    }

    @Override
    public List<User> findUsersByRole(String roleName) {
        List<User> foundedUserByRole = new ArrayList<>();
        try (Connection connection = DataSourceFactory.connection()) {
            PreparedStatement prepareStatement = connection.prepareStatement("SELECT * FROM service.users as usr\n" +
                    "join service.roles as rl\n" +
                    "on usr.role_fk=rl.r_id\n" +
                    "join service.gropus as gr\n" +
                    "on usr.group_fk = gr.g_id\n" +
                    "WHERE rl.rolename = ?;");
            prepareStatement.setString(1, roleName);
            ResultSet rs = prepareStatement.executeQuery();
            while (rs.next()) {
                Role role = new Role();
                Group group = new Group();
                User user = new User();

                int userId = rs.getInt("id");

                int roleId = rs.getInt("r_id");
                int groupId = rs.getInt("g_id");

                role.setR_id(roleId);
                role.setRoleName(rs.getString("rolename"));

                group.setG_id(groupId);
                group.setGroup(rs.getString("groupname"));

                user.setId(userId);
                user.setUsername(rs.getString("username"));
                user.setSurname(rs.getString("surname"));
                user.setTelegramLogin(rs.getString("telegram_login"));
                user.setPhone(rs.getString("phone"));
                user.setRole(role);
                user.setGroup(group);

                foundedUserByRole.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return foundedUserByRole;
    }

    @Override
    public List<User> findUsersByGroup(String groupName) {
        List<User> foundedUserByGroup = new ArrayList<>();
        try (Connection connection = DataSourceFactory.connection()) {
            PreparedStatement prepareStatement = connection.prepareStatement("SELECT * FROM service.users as usr\n" +
                    "join service.roles as rl\n" +
                    "on usr.role_fk=rl.r_id\n" +
                    "join service.gropus as gr\n" +
                    "on usr.group_fk = gr.g_id\n" +
                    "WHERE gr.groupname = ?;");
            prepareStatement.setString(1, groupName);
            ResultSet rs = prepareStatement.executeQuery();
            while (rs.next()) {
                Role role = new Role();
                Group group = new Group();
                User user = new User();

                int userId = rs.getInt("id");

                int roleId = rs.getInt("r_id");
                int groupId = rs.getInt("g_id");

                role.setR_id(roleId);
                role.setRoleName(rs.getString("rolename"));

                group.setG_id(groupId);
                group.setGroup(rs.getString("groupname"));

                user.setId(userId);
                user.setUsername(rs.getString("username"));
                user.setSurname(rs.getString("surname"));
                user.setTelegramLogin(rs.getString("telegram_login"));
                user.setPhone(rs.getString("phone"));
                user.setRole(role);
                user.setGroup(group);

                foundedUserByGroup.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return foundedUserByGroup;
    }

    @Override
    public User findUserById(int id) {
        User userById = new User();
        try (Connection connection = DataSourceFactory.connection()) {
            PreparedStatement prepareStatement = connection.prepareStatement("SELECT * FROM service.users as usr\n" +
                    "join service.roles as rl\n" +
                    "on usr.role_fk=rl.r_id\n" +
                    "join service.gropus as gr\n" +
                    "on usr.group_fk = gr.g_id\n" +
                    "WHERE id = ?;");
            prepareStatement.setInt(1, id);
            ResultSet rs = prepareStatement.executeQuery();
            while (rs.next()) {
                Role role = new Role();
                Group group = new Group();
                User user = new User();

                int userId = rs.getInt("id");
                int roleId = rs.getInt("r_id");
                int groupId = rs.getInt("g_id");

                role.setR_id(roleId);
                role.setRoleName(rs.getString("rolename"));

                group.setG_id(groupId);
                group.setGroup(rs.getString("groupname"));

                userById.setId(userId);
                userById.setUsername(rs.getString("username"));
                userById.setSurname(rs.getString("surname"));
                userById.setTelegramLogin(rs.getString("telegram_login"));
                userById.setPhone(rs.getString("phone"));
                userById.setRole(role);
                userById.setGroup(group);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userById;
    }

    @Override
    public User findUserByLogin(String login) {
        User userByLogin = new User();
        try (Connection connection = DataSourceFactory.connection()) {
            PreparedStatement prepareStatement = connection.prepareStatement("SELECT * FROM service.users as usr\n" +
                    "join service.roles as rl\n" +
                    "on usr.role_fk=rl.r_id\n" +
                    "join service.gropus as gr\n" +
                    "on usr.group_fk = gr.g_id\n" +
                    "WHERE telegram_login = ?;");
            prepareStatement.setString(1, login);
            ResultSet rs = prepareStatement.executeQuery();
            while (rs.next()) {
                Role role = new Role();
                Group group = new Group();
                User user = new User();

                int userId = rs.getInt("id");
                int roleId = rs.getInt("r_id");
                int groupId = rs.getInt("g_id");

                role.setR_id(roleId);
                role.setRoleName(rs.getString("rolename"));

                group.setG_id(groupId);
                group.setGroup(rs.getString("groupname"));

                userByLogin.setId(userId);
                userByLogin.setUsername(rs.getString("username"));
                userByLogin.setSurname(rs.getString("surname"));
                userByLogin.setTelegramLogin(rs.getString("telegram_login"));
                userByLogin.setPhone(rs.getString("phone"));
                userByLogin.setRole(role);
                userByLogin.setGroup(group);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userByLogin;
    }

    @Override
    public boolean save(User user) {
        boolean resultSave = false;
        try (Connection connection = DataSourceFactory.connection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO service.users (username, surname," +
                    "telegram_login, phone) VALUES (?, ?, ?, ?)");
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setString(3, user.getTelegramLogin());
            preparedStatement.setString(4, user.getPhone());
            resultSave = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSave;
    }

    @Override
    public boolean update(User user) {
        boolean resultUpdate = false;
        try (Connection connection = DataSourceFactory.connection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE service.users SET username = ?, surname = ?," +
                    "telegram_login = ?, phone = ? WHERE id = ? ");
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setString(3, user.getTelegramLogin());
            preparedStatement.setString(4, user.getPhone());
            preparedStatement.setInt(5, user.getId());
            resultUpdate = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultUpdate;
    }

    @Override
    public boolean deleteUserById(int id) {
        boolean resultDelete = false;
        try (Connection connection = DataSourceFactory.connection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM service.users WHERE id = ?");
            preparedStatement.setInt(1, id);
            resultDelete = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultDelete;
    }
}
