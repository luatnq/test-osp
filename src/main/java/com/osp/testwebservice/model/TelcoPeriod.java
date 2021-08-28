package com.osp.testwebservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TelcoPeriod implements Serializable {
    @JsonProperty("type")
    private String type;

    @JsonProperty("year")
    private long year;

    @JsonProperty("quarter")
    private int quarter;
}
