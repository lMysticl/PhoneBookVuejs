package com.mystic.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Putrenkov Pavlo
 */
@Entity
@Table(name = "app_user")
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class User implements Serializable {

    public User() {
    }

    public User(String username, String password, List<Role> roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long userId;

    @Column(name = "username")
    @Size(max=20)
    private String username;

    @Column(name = "password")
    @JsonIgnore
    @Size(max=50)
    private String password;

    @Column(name = "firstname")
    @Size(max=50)
    private String firstname;

    @Column(name = "lastname")
    @Size(max=50)
    private String lastname;

    @OneToMany(mappedBy = "user")
    private List<Contact> contacts = new ArrayList<>();


    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id_1", referencedColumnName = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private List<Role> roles = new ArrayList<>();

    public void addRole(Role role) {
        roles.add(role);
        role.getUsers().add(this);
    }

    public void removeRole(Role role) {
        roles.remove(role);
        role.getUsers().remove(this);    }
}
