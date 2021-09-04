package com.osp.testwebservice.repository;

import com.osp.testwebservice.entity.CpnRevenue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface CompanyRevenueRepository extends JpaRepository<CpnRevenue, Integer> {

    @Query(value = "SELECT * FROM cpn_revenue WHERE company_id = :company_id  " +
            "AND TYPE = :inp_type  AND created_time = :inp_date " +
            "AND quarter = :inp_quarter AND year = :inp_year AND active = '1'", nativeQuery = true)
    Optional<CpnRevenue> getCpnRevenueByCompanyIdAndDate(@Param("company_id") Integer companyIdReq,
                                                        @Param("inp_date") Date dateReq,
                                                        @Param("inp_type") String typeReq,
                                                        @Param("inp_quarter") int quarterReq,
                                                        @Param("inp_year") long year);
}
