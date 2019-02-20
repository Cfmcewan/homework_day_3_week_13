package com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;


import com.codeclan.example.WhiskyTracker.models.Distillery;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.List;

public class DistilleryRepositoryImpl implements DistilleryRepositoryCustom {

    @Autowired
    EntityManager entityManager;

    @Override
    public List<Distillery> findDistilleriesByWhiskiesOfCertainAge(int age) {
        List<Distillery> results = null;

        Criteria cr = null;
        try {
            Session session = entityManager.unwrap(Session.class);
            cr = session.createCriteria(Distillery.class);
            cr.createAlias("whiskeys", "whisky");
            cr.add(Restrictions.eq("whisky.age", age));
        } catch(HibernateException e) {
            e.printStackTrace();
        }
        results = cr.list();
        return results;
    }
}
