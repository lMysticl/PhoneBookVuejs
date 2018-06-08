package com.mystic.model.entity;

import com.mystic.user.domain.User;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author Putrenkov Pavlo
 */
@Entity
@Table(name = "contacts")
@Getter
@Setter
@EqualsAndHashCode(exclude={"user"})
@ToString(exclude = {"user"})
public class Contact implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contact_id")
    private Long contactId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "mobile_phone")
    @NotNull
    private String mobilePhone;

    @Column(name = "address")
    private String address;

    @Column(name = "email")
    private String email;

    @Column(name = "country")
    private String country;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "userId", insertable = false, updatable = false)
//    @JsonIgnore
//    @Embedded
//    private User user;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
