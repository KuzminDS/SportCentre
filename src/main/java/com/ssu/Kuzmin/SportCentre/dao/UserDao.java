package com.ssu.Kuzmin.SportCentre.dao;

import com.ssu.Kuzmin.SportCentre.entity.Trainer;
import com.ssu.Kuzmin.SportCentre.entity.User;
import com.ssu.Kuzmin.SportCentre.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.mindrot.jbcrypt.BCrypt;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public class UserDao extends Dao<User> {
    public UserDao() {
        super(User.class);
    }

    public boolean registrate(User user) {
        if (getAll().stream().anyMatch(u -> u.getLogin() == user.getLogin())) {
            return false;
        } else {
            String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
            user.setPassword(hashed);
            add(user);
            return true;
        }
    }

    public boolean authorize(User user) {
        Optional<User> potentialUser = getAll().stream().filter(u -> u.getLogin() == user.getLogin()).findFirst();
        if (potentialUser != null) {
            User checkedUser = potentialUser.get();
            if (BCrypt.checkpw(user.getPassword(), checkedUser.getPassword()))
                return true;
        }
        return false;
    }
}
