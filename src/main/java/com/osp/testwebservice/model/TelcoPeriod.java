package com.osp.testwebservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class TelcoPeriod implements Serializable {
    @JsonProperty("type")
    private String type;

    @JsonProperty("year")
    private Long year;

    @JsonProperty("quarter")
    private int quarter;
}
