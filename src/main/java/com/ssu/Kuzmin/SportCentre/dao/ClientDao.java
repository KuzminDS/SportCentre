package com.ssu.Kuzmin.SportCentre.dao;

import com.ssu.Kuzmin.SportCentre.entity.Client;
import com.ssu.Kuzmin.SportCentre.utils.HibernateSessionFactoryUtil;
import org.hibernate.*;
import org.hibernate.boot.spi.SessionFactoryOptions;
import org.hibernate.engine.spi.FilterDefinition;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.metadata.CollectionMetadata;
import org.hibernate.stat.Statistics;

import javax.naming.NamingException;
import javax.naming.Reference;
import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceUnitUtil;
import javax.persistence.SynchronizationType;
import javax.persistence.criteria.CriteriaBuilder;
import java.sql.Connection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ClientDao extends Dao<Client> {

    public ClientDao() {
        super(Client.class);
    }
}
