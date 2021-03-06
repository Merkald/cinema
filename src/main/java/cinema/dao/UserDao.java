package cinema.dao;

import cinema.model.User;
import java.util.Optional;

public interface UserDao {
    User add(User user);

    Optional<User> getByEmail(String email);

    Optional<User> getByLogin(String login);

    Optional<User> get(Long id);
}
