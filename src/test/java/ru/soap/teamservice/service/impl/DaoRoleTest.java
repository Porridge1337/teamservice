package ru.soap.teamservice.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.soap.teamservice.model.Role;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@DisplayName("Сервист ролей должен ")
@ExtendWith(MockitoExtension.class)
public class DaoRoleTest {
/*
    @Mock
    private final DaoRole daoRole = new DaoRoleImpl();
    private List<Role> roleMock;

    @BeforeEach
    void init() {
        roleMock = new ArrayList<>();
        roleMock.add(new Role(1, "LEAD"));
        roleMock.add(new Role(2, "ADMIN"));
        roleMock.add(new Role(3, "USER"));
    }

    @Test
    @DisplayName("уметь выводить все существующие роли")
    public void testGetAllRoles() {
        System.out.println("Запус теста по поиску всех ролейю");
        Mockito.when(daoRole.findUserRoles()).thenReturn(roleMock);
        Assertions.assertTrue(!daoRole.findUserRoles().isEmpty());
    }


    @Test
    @DisplayName("уметь сохранять новую роль")
    public void testSaveNewRole() {
        System.out.println("Запус теста по сохранению новой роли ");
        Role savedRole = new Role(4, "MODERATOR");
        roleMock.add(savedRole);
        when(daoRole.saveNewRole(savedRole)).thenReturn(roleMock.stream().anyMatch(role -> role.getR_id() == 4));
        Assertions.assertTrue(daoRole.saveNewRole(savedRole));
    }
*/
}
