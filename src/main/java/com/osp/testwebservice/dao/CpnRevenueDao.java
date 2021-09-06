//package com.osp.testwebservice.dao;
//
//import com.osp.testwebservice.entity.CpnRevenue;
//import org.apache.commons.lang3.StringUtils;
//import org.hibernate.Criteria;
//import org.hibernate.Session;
//import org.hibernate.criterion.Restrictions;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import java.util.Date;
//import java.util.Optional;
//
//@Repository
//public class CpnRevenueDao {
//    @PersistenceContext
//    private EntityManager entityManager;
//
//    public Optional<CpnRevenue> getCpnRevenueByCompanyIdAndDate(Integer companyIdReq,
//                                                                Date dateReq,
//                                                                String typeReq,
//                                                                int quarterReq,
//                                                                long year) {
//        Session session = entityManager.unwrap(Session.class);
//        Criteria criteria = session.createCriteria(CpnRevenue.class);
//        criteria.add(Restrictions.eq("company_id", companyIdReq))
//                .add(Restrictions.eq("created_time", dateReq))
//                .add(Restrictions.eq("type", typeReq))
//                .add(Restrictions.eq("year", year));
//        if (quarterReq > 0) {
//            criteria.add(Restrictions.eq("quarter", quarterReq));
//        }
//
//        Optional<CpnRevenue> cpnRevenue = Optional.of(criteria.list())
//    }
//}
