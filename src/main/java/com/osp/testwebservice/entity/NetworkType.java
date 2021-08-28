package com.osp.testwebservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "network_type")
public class NetworkType implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_time")
    private Date createdTime;

    @Column(name = "description")
    private String description;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id", nullable = false)
    private NetworkType networkType;

//    @OneToMany(mappedBy = "networkType")
//    private List<NetworkType> networkTypes;

    @Column(name = "order_no")
    private int orderNo;

    @Column(name = "alias")
    private String alias;
}
