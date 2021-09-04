package com.osp.testwebservice.repository;

import com.osp.testwebservice.entity.NetworkType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NetworkTypeRepository extends JpaRepository<NetworkType, Integer> {
    Optional<NetworkType> getNetworkTypeByAlias(String alias);
}
