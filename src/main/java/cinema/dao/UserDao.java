package cinema.dao;

import cinema.model.User;
import java.util.Optional;

public interface UserDao {
    User add(User user);

    Optional<User> findByEmail(String email);

    Optional<User> findByLogin(String login);

    Optional<User> get(Long id);
}
