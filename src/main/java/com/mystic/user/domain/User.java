package com.mystic.user.domain;

import com.google.common.collect.Lists;
import com.mystic.model.entity.Contact;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@RequiredArgsConstructor
@Table
@Getter
@Setter
@EqualsAndHashCode(of = "userId")
@NoArgsConstructor
public class User {

    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @NonNull
    private String username;

    private String firstname;

    private String lastname;

    private String avatar;

    private User(String username){
        this.username = username;
    }


    @OneToMany(mappedBy = "user")
    private List<Contact> contacts = Lists.newArrayList();
}