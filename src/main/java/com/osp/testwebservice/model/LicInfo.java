package com.osp.testwebservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class LicInfo implements Serializable {
    @JsonProperty("lic_number")
    private String licNumber;

    @JsonProperty("lic_network_type")
    private String licNetworkType;

    @JsonProperty("revenue")
    private String revenue;
}
