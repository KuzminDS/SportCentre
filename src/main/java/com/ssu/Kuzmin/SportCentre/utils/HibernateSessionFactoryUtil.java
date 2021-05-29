package com.ssu.Kuzmin.SportCentre.utils;

import com.ssu.Kuzmin.SportCentre.entity.*;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactoryUtil {
    private static SessionFactory sessionFactory;

    public HibernateSessionFactoryUtil() {}

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(Group.class);
                configuration.addAnnotatedClass(User.class);
                configuration.addAnnotatedClass(Lesson.class);
                configuration.addAnnotatedClass(Client.class);
                configuration.addAnnotatedClass(Trainer.class);
                configuration.addAnnotatedClass(Gym.class);
                configuration.addAnnotatedClass(Subscription.class);

                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());

            }
            catch (Exception e) {
                throw new HibernateException("Exception: " + e.getMessage());
            }
        }
        return sessionFactory;
    }
}
