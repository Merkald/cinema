package cinema.service.impl;

import cinema.dao.UserDao;
import cinema.model.User;
import cinema.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User add(User user) {
        return userDao.add(user);
    }

    @Override
    public User getByEmail(String email) {
        if (userDao.getByEmail(email).isEmpty()) {
            throw new RuntimeException("user doesnt exist");
        }
        return userDao.getByEmail(email).get();
    }

    @Override
    public User getByLogin(String login) {
        if (userDao.getByLogin(login).isEmpty()) {
            throw new RuntimeException("user doesnt exist");
        }
        return userDao.getByLogin(login).orElseThrow();
    }

    @Override
    public User get(Long id) {
        return userDao.get(id).orElseThrow();
    }
}
