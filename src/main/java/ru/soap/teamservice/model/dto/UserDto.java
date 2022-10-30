package ru.soap.teamservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    private RoleDto role;

    private GroupDto group;

}
