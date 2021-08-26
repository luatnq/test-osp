package com.osp.testwebservice.controller;


import com.osp.testwebservice.entity.Company;
import com.osp.testwebservice.model.request.RequestDTO;
import com.osp.testwebservice.services.CompanyService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/")
public class CompanyController {
    private final CompanyService companyService;

    @PostMapping(path = "search")
    public List<Company> getCompanies(@RequestBody RequestDTO requestDTO){
        return companyService.getCompanyByIds(requestDTO.getCompanyIds());
    }
}
