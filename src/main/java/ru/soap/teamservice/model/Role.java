package ru.soap.teamservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "roles", schema = "service")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = "usersRole")
@ToString(exclude = "usersRole")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int r_id;
    @Column(name = "roleName")
    private String roleName;
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "roles")
    private Set<User> usersRole;

}
