package repository;

import entity.AppUser;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import java.util.List;


/**
 * Created by Ovi on 22-May-16.
 */
public class UserRepo {

    SessionFactory sessionFactory;

    public UserRepo() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public void save(AppUser user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.clear();
    }

    public List<AppUser> getAll() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<AppUser> users = session.createCriteria(AppUser.class).list();
        transaction.commit();
        session.close();
        return users;
    }

    public AppUser getByUsername(String username) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List users = session.createCriteria(AppUser.class)
                .setFirstResult(0).add(Restrictions.eq("username", username)).list();
        transaction.commit();
        session.close();
        if (users.size() == 0) {
            return null;
        } else {
            return (AppUser) users.get(0);
        }
    }

}
