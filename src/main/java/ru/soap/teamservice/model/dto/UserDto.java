package ru.soap.teamservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private int id;

    private String login;

    private String username;

    private String surname;

    private String telegramUser;

    private long telegramId;

    private String phone;

    private GroupDto group;

    private Set<RoleDto> roles;

}
