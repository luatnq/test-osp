package com.osp.testwebservice.repository;

import com.osp.testwebservice.entity.LicInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface LicInfoRepository extends JpaRepository<LicInfo, Integer> {

    @Query(value = "SELECT * FROM lic_info " +
            " WHERE lic_info.company_id  = :inp_company_id AND created_time = :inp_created_time",  nativeQuery = true)
    List<LicInfo> getLicInfos(@Param("inp_company_id") Integer companyId,
                              @Param("inp_created_time")Date createTime);
}
