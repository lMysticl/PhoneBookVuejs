//package com.mystic.model.entity;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import lombok.*;
//
//import javax.persistence.*;
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @author Putrenkov Pavlo
// */
//@Entity
//@Table(name = "app_user")
//@Getter
//@Setter
//@EqualsAndHashCode(exclude={"avatar"})
//@ToString(exclude = {"avatar"})
//public class User implements Serializable {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "user_id")
//    private Long userId;
//
//    @Column(name = "username")
//    private String username;
//
//    @Column(name = "password")
//    @JsonIgnore
//    @NonNull
//    private String password;
//
//    @Column(name = "firstname")
//    private String firstname;
//
//    @Column(name = "lastname")
//    private String lastname;
//
//    @Column(name = "avatars")
//    private String avatar;
//
//    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id_1", referencedColumnName = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
//    @JsonIgnore
//    private List<Role> roles = new ArrayList<>();
//
//    public User() {
//    }
//
//
//    public User(String username, String password, List<Role> roles) {
//        this.username = username;
//        this.password = password;
//        this.roles = roles;
//    }
//
//    public void addRole(Role role) {
//        roles.add(role);
//        role.getUsers().add(this);
//    }
//
//    public void removeRole(Role role) {
//        roles.remove(role);
//        role.getUsers().remove(this);
//    }
//
//}
