package com.osp.testwebservice.model.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.osp.testwebservice.model.TelcoPeriod;
import com.osp.testwebservice.model.response.LicInfoRes;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class CompanyInfoDTO implements Serializable {

    @JsonProperty("company_id")
    private Integer companyId;

    @JsonProperty("company_name")
    private String companyName;

    @JsonProperty("company_code")
    private String companyCode;

    @JsonProperty("telco_period")
    private TelcoPeriod telcoPeriod;

    @JsonProperty("status")
    private String status;

    @JsonProperty("info_date")
    private Date infoDate;

    @JsonProperty("lic_infos")
    private List<LicInfoRes> licInfoRes;
}
