package cinema.dao;

import java.util.List;

public interface GenericDao<T,K> {
    T create(T model);

    boolean update(T model);

    List<T> getAll();

    T getById(K id);

    boolean deleteById(K id);
}
