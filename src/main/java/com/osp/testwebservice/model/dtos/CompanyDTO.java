package com.osp.testwebservice.model.dtos;

import com.osp.testwebservice.entity.LicInfo;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.time.Instant;
import java.util.List;

@Data
public class CompanyDTO implements Serializable {

    private Integer id;

    private String address;

    private String code;

    private String internationalName;

    private String name;

    private String shortName;

    private String email;

    private String phone;

    private String representationPerson;

    private String addressContact;

    private String contactPerson;

    private String website;

    private List<LicInfo> licInfos;
}
