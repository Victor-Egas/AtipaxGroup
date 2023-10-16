package com.atipax.group.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Getter
@Setter
@Table(name = "tb_user")
@Entity
public class UserEntity {

    @Id
    private String code;
    @Column(name = "user")
    private String userLogin;
    @Column(name = "password")
    private String userPassword;
    private String name;
    private String lastname;
    private String address;
    private String cellphone;
    private String creationDate;
    private String identityNumber;
    private String birthDate;
}
