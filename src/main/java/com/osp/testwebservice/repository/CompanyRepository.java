package com.osp.testwebservice.repository;

import com.osp.testwebservice.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {
    List<Company> getCompanyByIdIn(List<Integer> ids);
}
