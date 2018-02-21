package com.mystic.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @author Putrenkov Pavlo
 */
@Entity
@Table(name = "contacts")
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Contact implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contact_id")
    private long contactId;

    @Column(name = "user_id")
    private long userId;

    @Column(name = "firstname")
    @NotNull
    @Size(min=2, max=30)
    private String firstname;

    @Column(name = "lastname")
    @Size( max=30)
    private String lastname;

    @Column(name = "mobile_phone")
    @Size( max=20)
    @NotNull
    private String mobilePhone;

    @Column(name = "address")
    @Size( max=50)
    private String address;

    @Column(name = "email")
    @Size( max=20)
    private String email;

    @Column(name = "country")
    @Size(max=20)
    private String country;

    @ManyToOne()
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    @JsonIgnore
    private User user;

}
