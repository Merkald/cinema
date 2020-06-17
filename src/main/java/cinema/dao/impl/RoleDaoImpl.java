package cinema.dao.impl;

import cinema.dao.RoleDao;
import cinema.exeptions.DataProcessingException;
import cinema.model.Role;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl implements RoleDao {
    private final SessionFactory factory;

    public RoleDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Role add(Role role) {
        Transaction transaction = null;
        Session session = factory.openSession();
        try {
            transaction = session.beginTransaction();
            session.save(role);
            transaction.commit();
            return role;
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
    public Optional<Role> getRoleByName(String roleName) {
        try (Session session = factory.openSession()) {
            return Optional.ofNullable(session
                    .createQuery("from Role "
                            + " where roleName =: roleName", Role.class)
                    .setParameter("roleName", Role.RoleName.valueOf(roleName)).uniqueResult());
        } catch (Exception e) {
            throw new DataProcessingException("Can't find role with name "
                    + roleName, e);
        }
    }
}
