package com.osp.testwebservice.repository;

import com.osp.testwebservice.entity.LicInfoNetworkType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LicInfoNetworkTypeRepository extends JpaRepository<LicInfoNetworkType, Integer> {

}
