package cinema.dao.impl;

import cinema.dao.OrderDao;
import cinema.model.Order;
import cinema.model.User;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDaoImpl implements OrderDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Order create(Order order) {
        Transaction transaction = null;
        Session session = sessionFactory.openSession();
        try {
            transaction = session.beginTransaction();
            session.save(order);
            transaction.commit();
            return order;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Cant insert Order entity", e);
        } finally {
            session.close();
        }
    }

    @Override
    public List<Order> getOrderHistory(User user) {
        Session session = sessionFactory.openSession();
        try {
            return session
                    .createQuery("from Order o"
                            + " left join fetch o.tickets "
                            + "where o.user = :user", Order.class)
                    .setParameter("user", user).list();
        } catch (Exception e) {
            throw new RuntimeException("Can't get orders ", e);
        } finally {
            session.close();
        }
    }
}
