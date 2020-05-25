package cinema.dao.impl;

import cinema.dao.MovieSessionDao;
import cinema.lib.Dao;
import cinema.model.MovieSession;
import cinema.util.HibernateUtil;
import java.time.LocalDateTime;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

@Dao
public class MovieSessionDaoImpl implements MovieSessionDao {

    @Override
    public List<MovieSession> findAvailableSessions(Long movieId, LocalDateTime date) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            return session
                    .createQuery("from MovieSession where showTime = :time AND movie.id = :id")
                    .setParameter("time", date)
                    .setParameter("id", movieId).list();
        } catch (Exception e) {
            throw new RuntimeException("Can't insert movie Session ", e);
        } finally {
            session.close();
        }
    }

    @Override
    public MovieSession add(MovieSession movieSession) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.save(movieSession);
            transaction.commit();
            return movieSession;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Can't insert movie Session ", e);
        } finally {
            session.close();
        }
    }
}
