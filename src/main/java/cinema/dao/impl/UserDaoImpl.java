package cinema.dao.impl;

import cinema.dao.UserDao;
import cinema.exeptions.DataProcessingException;
import cinema.model.User;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    private final SessionFactory sessionFactory;

    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

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
    public Optional<User> getByEmail(String email) {
        Session session = sessionFactory.openSession();
        try {
            return Optional.ofNullable(session
                    .createQuery("from User u "
                            + "left join fetch u.roles Role "
                            + " where u.email =: email", User.class)
                    .setParameter("email", email).uniqueResult());
        } catch (Exception e) {
            throw new RuntimeException("Can't get User ", e);
        } finally {
            session.close();
        }
    }

    @Override
    public Optional<User> getByLogin(String login) {
        Session session = sessionFactory.openSession();
        try {
            return Optional.ofNullable(session
                    .createQuery("from User u "
                            + "left join fetch u.roles Role "
                            + " where u.login =: login", User.class)
                    .setParameter("login", login).uniqueResult());
        } catch (Exception e) {
            throw new DataProcessingException("Can't get User ", e);
        } finally {
            session.close();
        }
    }

    @Override
    public Optional<User> get(Long id) {
        Session session = sessionFactory.openSession();
        try {
            return Optional.ofNullable(session.get(User.class,id));
        } catch (Exception e) {
            throw new DataProcessingException("Error reviewing all Cinema Halls", e);
        } finally {
            session.close();
        }
    }
}
