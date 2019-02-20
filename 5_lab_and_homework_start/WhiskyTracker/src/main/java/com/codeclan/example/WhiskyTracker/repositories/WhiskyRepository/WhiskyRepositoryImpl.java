package com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;


import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.List;

public class WhiskyRepositoryImpl implements WhiskyRepositoryCustom {

    @Autowired
    EntityManager entityManager;


    @Override
    public List<Whisky> findWhiskyFromCertainDistilleryByCertainAge(String name, int age) {
        List<Whisky> results = null;

        Criteria cr = null;
        try {
            Session session = entityManager.unwrap(Session.class);
            cr = session.createCriteria(Whisky.class);
            cr.createAlias("whiskeys", "whisky");
            cr.add(Restrictions.eq("whisky.distillery.name", name));
            cr.add(Restrictions.eq("whisky.age", age));
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        results = cr.list();
        return results;
    }


    @Override
    public List<Whisky> findWhiskeysByRegion(String region){
        List<Whisky> results = null;

        Criteria cr = null;
        try {
            Session session = entityManager.unwrap(Session.class);
            cr = session.createCriteria(Whisky.class);
            cr.createAlias("whiskeys", "whisky");
            cr.add(Restrictions.eq("whisky.distillery.region", region));
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        results = cr.list();
        return results;
    }
}
