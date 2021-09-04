package com.osp.testwebservice.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class PageRes implements Serializable {
    @JsonProperty("content")
    private List<? extends Object> content;

    @JsonProperty("size")
    private int pageSize;

    @JsonProperty("page_number")
    private int pageNumber;

    @JsonProperty("total_page")
    private int totalPages;

    @JsonProperty("total")
    private long total;

}
