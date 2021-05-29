package com.ssu.Kuzmin.SportCentre.service;

import com.ssu.Kuzmin.SportCentre.dao.Dao;
import com.ssu.Kuzmin.SportCentre.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class Service<T> {
    private final Dao<T> dao;
    private Class<T> type;

    public Service(Class<T> type) {
        this.dao = new Dao<T>(type);
    }

    public T getById(int id) throws Exception {
        return dao.getById(id);
    }

    public List<T> getAll() {
        return dao.getAll();
    }

    public void add(T entity) {
        dao.add(entity);
    }

    public void update(T entity) {
       dao.update(entity);
    }

    public void delete(int id) throws Exception {
        T entity = getById(id);
        dao.delete(entity);
    }
}
