package cinema.dao.impl;

import cinema.dao.MovieSessionDao;
import cinema.exeptions.DataProcessingException;
import cinema.model.MovieSession;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MovieSessionDaoImpl implements MovieSessionDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<MovieSession> findAvailableSessions(Long movieId, LocalDateTime date) {
        Session session = sessionFactory.openSession();
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
        Session session = sessionFactory.openSession();
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

    @Override
    public Optional<MovieSession> get(Long id) {
        Session session = sessionFactory.openSession();
        try {
            return Optional.ofNullable(session.get(MovieSession.class,id));
        } catch (Exception e) {
            throw new DataProcessingException("Error reviewing all Cinema Halls", e);
        } finally {
            session.close();
        }
    }
}
