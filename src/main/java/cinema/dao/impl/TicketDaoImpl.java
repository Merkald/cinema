package cinema.dao.impl;

import cinema.dao.TicketDao;
import cinema.exeptions.DataProcessingException;
import cinema.model.Ticket;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TicketDaoImpl implements TicketDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Ticket add(Ticket ticket) {
        Transaction transaction = null;
        Session session = sessionFactory.openSession();
        try {
            transaction = session.beginTransaction();
            session.save(ticket);
            transaction.commit();
            return ticket;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Cant insert Shopping Cart entity", e);
        } finally {
            session.close();
        }
    }

    @Override
    public Optional<Ticket> get(Long id) {
        Session session = sessionFactory.openSession();
        try {
            return Optional.ofNullable(session
                    .createQuery("from Ticket where id = :id", Ticket.class)
                    .setParameter("id", id).uniqueResult());
        } catch (Exception e) {
            throw new DataProcessingException("Error reviewing all Cinema Halls", e);
        } finally {
            session.close();
        }
    }
}
