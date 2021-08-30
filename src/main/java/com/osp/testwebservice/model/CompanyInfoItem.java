package com.osp.testwebservice.model;

import lombok.Data;

import java.util.Date;

@Data
public class CompanyInfoItem {
    private int companyId;
    private int stt;
    private String companyName;
    private Date fromYear;
    private Date toYear;
    private String licNumber;
    private String typeLic;
}
