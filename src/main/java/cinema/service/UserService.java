package cinema.service;

import cinema.model.User;

public interface UserService {
    User add(User user);

    User getByEmail(String email);

    User getByLogin(String login);

    User get(Long id);
}
