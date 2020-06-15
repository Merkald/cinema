package cinema.service;

import cinema.model.User;

public interface UserService {
    User add(User user);

    User findByEmail(String email);

    User findByLogin(String login);

    User get(Long id);
}
