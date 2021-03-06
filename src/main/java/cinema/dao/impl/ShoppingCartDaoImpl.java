package cinema.dao.impl;

import cinema.dao.ShoppingCartDao;
import cinema.model.ShoppingCart;
import cinema.model.User;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class ShoppingCartDaoImpl implements ShoppingCartDao {
    private final SessionFactory sessionFactory;

    public ShoppingCartDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public ShoppingCart add(ShoppingCart shoppingCart) {
        Transaction transaction = null;
        Session session = sessionFactory.openSession();
        try {
            transaction = session.beginTransaction();
            session.save(shoppingCart);
            transaction.commit();
            return shoppingCart;
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
    public ShoppingCart getByUser(User user) {
        Session session = sessionFactory.openSession();
        try {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<ShoppingCart> cr = cb.createQuery(ShoppingCart.class);
            Root<ShoppingCart> root = cr.from(ShoppingCart.class);
            root.fetch("tickets", JoinType.LEFT);
            root.fetch("user", JoinType.LEFT);
            cr.select(root).where(cb.equal(root.get("user"), user));
            Query<ShoppingCart> query = session.createQuery(cr);
            return query.uniqueResult();
        } catch (Exception e) {
            throw new RuntimeException("Cant get Shopping Cart entity", e);
        } finally {
            session.close();
        }
    }

    @Override
    public void update(ShoppingCart shoppingCart) {
        Transaction transaction = null;
        Session session = sessionFactory.openSession();
        try {
            transaction = session.beginTransaction();
            session.update(shoppingCart);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Cant insert Shopping Cart entity", e);
        } finally {
            session.close();
        }
    }
}
