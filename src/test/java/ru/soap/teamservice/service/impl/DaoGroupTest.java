package ru.soap.teamservice.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.soap.teamservice.model.Group;
import ru.soap.teamservice.model.Role;
import ru.soap.teamservice.model.User;
import ru.soap.teamservice.service.DaoGroup;
import ru.soap.teamservice.service.DaoUser;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@DisplayName("Сервист групп должен ")
@ExtendWith(MockitoExtension.class)
public class DaoGroupTest {

    @Mock
    private final DaoGroup daoGroup = new DaoGroupImpl();
    @Mock
    private final DaoUser daoUser = new DaoUserImpl();
    private List<Group> groupsMock;

    @BeforeEach
    void initialize() {
        groupsMock = new ArrayList<>();
        groupsMock.add(new Group(1, "red"));
        groupsMock.add(new Group(2, "blue"));
        groupsMock.add(new Group(3, "green"));
    }

    @Test
    @DisplayName("уметь вытаскивать все группы из ДБ")
    public void testGetAllUsers() {
        System.out.println("Запус теста поиска всех групп.");
        when(daoGroup.findAllGroups()).thenReturn(groupsMock);
        Assertions.assertTrue(!daoGroup.findAllGroups().isEmpty());
    }

    @Test
    @DisplayName("уметь сохранять группу")
    public void testSaveUser() {
        System.out.println("Запус теста сохранения группы.");
        Group savedGroup = new Group(4, "purple");
        groupsMock.add(savedGroup);
        when(daoGroup.saveGroup(savedGroup)).thenReturn(groupsMock.stream().anyMatch(group -> group.getG_id() == 4));
        Assertions.assertTrue(daoGroup.saveGroup(savedGroup));
    }

    @Test
    @DisplayName("уметь изменять группу")
    public void testUpdatedUser() {
        System.out.println("Запус теста апдейта группы ");
        Group updatedGroup = groupsMock.stream().filter(group -> group.getG_id() == 3).findFirst().get();
        updatedGroup.setGroup("purple");
        groupsMock.stream().filter(group -> group.getG_id() == 3).findFirst().get().setGroup(updatedGroup.getGroup());

        when(daoGroup.updateGroup(updatedGroup)).
                thenReturn(groupsMock.stream().filter(group -> group.getG_id() == 3).findFirst().
                        get().getGroup().equals(updatedGroup.getGroup()));
        Assertions.assertTrue(daoGroup.updateGroup(updatedGroup));
    }

    @Test
    @DisplayName("уметь удалять юзера по id")
    public void testDeletedUserById() {
        System.out.println("Запус тестасохранению юзера ");
        Group deletedGroup = groupsMock.stream().filter(group -> group.getG_id() == 1).findFirst().get();
        groupsMock.remove(deletedGroup.getG_id());
        when(daoGroup.deleteGroupById(deletedGroup.getG_id())).
                thenReturn(groupsMock.stream().anyMatch(usersMock -> usersMock.getG_id() == 1));
        Assertions.assertTrue(daoGroup.deleteGroupById(deletedGroup.getG_id()));
    }

    @Test
    @DisplayName("уметь проверять, если имеет связь с юзером, то удаление невозможно из-за внешнего ключа")
    public void testDidntDeleteGroupIfHasRelationToUser() {
        System.out.println("Запус теста по проверке удаления, если имеет связть с юзером ");
        Group deletedGroup = groupsMock.stream().filter(group -> group.getG_id() == 1).findFirst().get();
        User user = new User(1, "ilyazhdanov1", "ilya", "Zhdanov", "ilyaZhdanov", 12345678, "+79000000000",
                new Role(2, "ADMIN"), deletedGroup);

        when(daoGroup.deleteGroupById(deletedGroup.getG_id())).thenReturn(user.getGroup().getGroup().isEmpty());
        Assertions.assertEquals(daoGroup.deleteGroupById(1), user.getGroup().getGroup().isEmpty());
    }


}
