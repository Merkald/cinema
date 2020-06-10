package cinema.dao.impl;

import cinema.dao.UserDao;
import cinema.exeptions.DataProcessingException;
import cinema.model.User;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User add(User user) {
        Transaction transaction = null;
        Session session = sessionFactory.openSession();
        try {
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
            return user;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Cant insert User entity", e);
        } finally {
            session.close();
        }
    }

    @Override
    public Optional<User> findByEmail(String email) {
        Session session = sessionFactory.openSession();
        try {
            return Optional.ofNullable(session
                    .createQuery("from User where email = :email", User.class)
                    .setParameter("email", email).uniqueResult());
        } catch (Exception e) {
            throw new RuntimeException("Can't get User ", e);
        } finally {
            session.close();
        }
    }

    @Override
    public Optional<User> get(Long id) {
        Session session = sessionFactory.openSession();
        try {
            return Optional.ofNullable(session
                    .createQuery("from User where id = :id", User.class)
                    .setParameter("id", id).uniqueResult());
        } catch (Exception e) {
            throw new DataProcessingException("Error reviewing all Cinema Halls", e);
        } finally {
            session.close();
        }
    }
}
