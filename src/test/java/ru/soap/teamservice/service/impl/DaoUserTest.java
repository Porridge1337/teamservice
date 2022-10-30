package ru.soap.teamservice.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.soap.teamservice.model.Group;
import ru.soap.teamservice.model.Role;
import ru.soap.teamservice.model.User;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.mockito.Mockito.when;

@DisplayName("Сервист юзеров должен ")
@ExtendWith(MockitoExtension.class)
public class DaoUserTest {
/*
    @Mock
    private final DaoUser daoUser = new DaoUserImpl();
    private List<User> usersMock;

    @BeforeEach
    void initialize() {
        usersMock = new ArrayList<>();
        usersMock.add(new User(1, "ilyazhdanov1", "ilya", "Zhdanov", "ilyaZhdanov", 12345678, "+79000000000",
                new Role(2, "ADMIN"), new Group(1, "blue")));
        usersMock.add(new User(2, "GiperArleon", "Artem", "Baryshnikov", "ArtemBaryshnikov", 12345679, "+79000000001",
                new Role(2, "ADMIN"), new Group(1, "blue")));
        usersMock.add(new User(3, "Emkaar", "Konstantin", "Kozhevnikov", "KonstantinKozhevnikov", 12345671, "+79000000002",
                new Role(1, "LEAD"), new Group(1, "green")));
    }

    @Test
    @DisplayName("уметь вытаскивать всез юзеров из ДБ")
    public void testGetAllUsers() {
        System.out.println("Запус теста поиска всех юзеров ");
        when(daoUser.findAll()).thenReturn(usersMock);
        Assertions.assertTrue(!daoUser.findAll().isEmpty());
    }

    @Test
    @DisplayName("уметь вытаскивать юзеров из ДБ по id")
    public void testGetAUserById() {
        System.out.println("Запус теста поиска юзера по id ");
        User user = usersMock.stream().filter(users -> users.getId() == 1).findFirst().get();
        when(daoUser.findUserById(1)).thenReturn(user);
        Assertions.assertEquals(user.getUsername(), daoUser.findUserById(1).getUsername());
    }

    @Test
    @DisplayName("уметь вытаскивать юзеров из ДБ по роли")
    public void testGetAUserByRole() {
        System.out.println("Запус теста поиска юзера по роли ");
        List<User> usersByRole = usersMock.stream().filter(user -> user.getRole().getRoleName().equals("ADMIN")).
                collect(Collectors.toList());
        when(daoUser.findUsersByRole("ADMIN")).thenReturn(usersByRole);
        Assertions.assertEquals(usersByRole, daoUser.findUsersByRole("ADMIN"));
    }

    @Test
    @DisplayName("уметь вытаскивать юзеров из ДБ по названию группы")
    public void testGetAUserByGroup() {
        System.out.println("Запус теста поиска юзера по названию группы ");
        List<User> usersByGroup = usersMock.stream().filter(user -> user.getGroup().getGroup().equals("blue")).
                collect(Collectors.toList());
        when(daoUser.findUsersByGroup("blue")).thenReturn(usersByGroup);
        Assertions.assertEquals(usersByGroup, daoUser.findUsersByGroup("blue"));
    }

    @Test
    @DisplayName("уметь вытаскивать юзера из ДБ по логину")
    public void testGetAUserByLogin() {
        System.out.println("Запус теста поиска юзера по логину ");
        User usersByLogin = usersMock.stream().filter(user -> user.getLogin().equals("GiperArleon")).findFirst().get();
        when(daoUser.findUserByLogin("GiperArleon")).thenReturn(usersByLogin);
        Assertions.assertEquals(usersByLogin, daoUser.findUserByLogin("GiperArleon"));
    }

    @Test
    @DisplayName("уметь сохранять юзера")
    public void testSaveUser() {
        System.out.println("Запус тестасохранению юзера ");
        User savedUser = new User(4, "T34he", "Maksim", "Hryhoryev", "MaksimHryhoryev",
                12375678, "+79000000020",
                new Role(4, "USER"), new Group(2, "red"));
        usersMock.add(savedUser);
        when(daoUser.save(savedUser)).thenReturn(usersMock.stream().filter(user -> user.getId() == 4).findAny().isPresent());
        Assertions.assertTrue(daoUser.save(savedUser));
    }

    @Test
    @DisplayName("уметь изменять юзера")
    public void testUpdatedUser() {
        System.out.println("Запус тестасохранению юзера ");
        User updatedUser = usersMock.stream().filter(users -> users.getId() == 3).findFirst().get();
        updatedUser.getGroup().setGroup("USER");
        usersMock.stream().filter(users -> users.getId() == 3).findFirst().get().getGroup().
                setGroup(updatedUser.getGroup().getGroup());

        when(daoUser.update(updatedUser)).
                thenReturn(usersMock.stream().filter(user -> user.getId() == 3).findFirst().get().getGroup().getGroup().
                        equals(updatedUser.getGroup().getGroup()));
        Assertions.assertTrue(daoUser.update(updatedUser));
    }

    @Test
    @DisplayName("уметь удалять юзера по id")
    public void testDeletedUserById() {
        System.out.println("Запус тестасохранению юзера ");
        User deletedUser = usersMock.stream().filter(users -> users.getId() == 1).findFirst().get();
        usersMock.remove(deletedUser.getId());
        when(daoUser.deleteUserById(deletedUser.getId())).
                thenReturn(usersMock.stream().anyMatch(usersMock -> usersMock.getId() == 1));
        Assertions.assertTrue(daoUser.deleteUserById(deletedUser.getId()));
    }

*/
}
