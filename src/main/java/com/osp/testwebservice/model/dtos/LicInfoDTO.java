package com.osp.testwebservice.model.dtos;

import com.osp.testwebservice.entity.LicInfoNetworkType;

import javax.persistence.Column;
import java.io.Serializable;
import java.time.Instant;

public class LicInfoDTO implements Serializable {
    private Integer id;

    private String createdBy;

    private Instant createdTime;

    private String effectDate;

    private String expiredDate;

    private String expiredTime;

    private String licNumber;

    private LicInfoNetworkType licInfoNetworkType;
}
