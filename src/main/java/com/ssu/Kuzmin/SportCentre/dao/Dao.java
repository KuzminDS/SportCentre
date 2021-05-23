package com.ssu.Kuzmin.SportCentre.dao;

import com.ssu.Kuzmin.SportCentre.entity.Client;
import com.ssu.Kuzmin.SportCentre.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Entity;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import java.util.List;

public class Dao<T> {
    private SessionFactory sessionFactory;
    private Class<T> type;

    public Dao(Class<T> type) {
        sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();
        this.type = type;
    }

    public T getById(int id) throws Exception {
        Session session = sessionFactory.openSession();

        try {
            T entity = session.get(type, id);

            if (entity == null)
                throw new Exception(String.format("Entity with specified %s doesn't exist", id));

            return entity;

        } finally {
            session.close();
        }
    }

    public List<T> getAll() {
        Session session = sessionFactory.openSession();

        try {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<T> query = builder.createQuery(type);
            Root<T> variableRoot = query.from(type);
            query.select(variableRoot);

            return session.createQuery(query).getResultList();

        } finally {
            session.close();
        }
    }

    public void add(T entity) {
        Session session = sessionFactory.openSession();

        try{
            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }

    public void update(T entity) {
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            session.update(entity);
            session.getTransaction().commit();
        } finally {
            session.close();
        }

    }

    public void delete(T entity) {
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            session.delete(entity);
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }
}
