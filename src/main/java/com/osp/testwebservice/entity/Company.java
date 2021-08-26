package com.osp.testwebservice.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "COMPANY")
@Data
public class Company implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_time")
    private Instant createdTime;

    @Column(name = "address")
    private String address;

    @Column(name = "code")
    private String code;

    @Column(name = "international_name")
    private String internationalName;

    @Column(name = "name")
    private String name;

    @Column(name = "short_name")
    private String shortName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "representation_person")
    private String representationPerson;

    @Column(name = "address_contact")
    private String addressContact;

    @Column(name = "contact_person")
    private String contactPerson;

    @Column(name = "website")
    private String website;

    @OneToMany(mappedBy = "company")
    private List<LicInfo> licInfos;
}
