package repository;

import entity.AppUser;
import entity.Task;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Ovi on 23-May-16.
 */
public class TaskRepo {

    SessionFactory sessionFactory;

    public TaskRepo() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public void save(Task task) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(task);
        transaction.commit();
        session.clear();
    }

    public List<Task> getAllForUser(Long userId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List tasksLiat = session.createCriteria(Task.class).list();
        List<Task> tasks = new ArrayList<Task>();
        for (Iterator it = tasksLiat.iterator(); it.hasNext();) {
            Task task = (Task) it.next();
            if (task.getEmployee().getId().equals(userId)) {
                tasks.add(task);
            }
        }
        transaction.commit();
        session.close();
        return tasks;
    }


}
