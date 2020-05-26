package cinema.dao.impl;

import cinema.dao.CinemaHallDao;
import cinema.exeptions.DataProcessingException;
import cinema.lib.Dao;
import cinema.model.CinemaHall;
import cinema.model.Movie;
import cinema.util.HibernateUtil;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

@Dao
public class CinemaHallDaoImpl implements CinemaHallDao {

    @Override
    public CinemaHall add(CinemaHall cinemaHall) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.save(cinemaHall);
            transaction.commit();
            return cinemaHall;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Can't insert Cinema Hall", e);
        } finally {
            session.close();
        }
    }

    @Override
    public List<CinemaHall> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            CriteriaQuery<CinemaHall> criteriaQuery = session.getCriteriaBuilder()
                    .createQuery(CinemaHall.class);
            criteriaQuery.from(Movie.class);
            return session.createQuery(criteriaQuery).getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Error reviewing all Cinema Halls", e);
        } finally {
            session.close();
        }
    }
}
