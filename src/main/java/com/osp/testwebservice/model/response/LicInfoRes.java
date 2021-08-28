package com.osp.testwebservice.model.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class LicInfoRes implements Serializable {
    @JsonProperty("lic_number")
    private String licNumber;

    @JsonProperty("lic_network_type")
    private String licNetworkType;

    @JsonProperty("revenue")
    private Integer revenue;

    @JsonIgnore
    private Boolean active;
}
