package com.osp.testwebservice.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class RequestDTO implements Serializable {
    @JsonProperty("type")
    private String type;

    @JsonProperty("year")
    private int year;

    @JsonProperty("quarter")
    private int quarter;

    @JsonProperty("company_ids")
    private List<Integer> companyIds;

    @JsonProperty("date")
    private String date;
}
