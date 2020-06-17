package cinema.service.impl;

import cinema.dao.UserDao;
import cinema.model.User;
import cinema.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User add(User user) {
        return userDao.add(user);
    }

    @Override
    public User findByEmail(String email) {
        if (userDao.findByEmail(email).isEmpty()) {
            throw new RuntimeException("user doesnt exist");
        }
        return userDao.findByEmail(email).get();
    }

    @Override
    public User findByLogin(String login) {
        if (userDao.findByLogin(login).isEmpty()) {
            throw new RuntimeException("user doesnt exist");
        }
        return userDao.findByLogin(login).orElseThrow();
    }

    @Override
    public User get(Long id) {
        return userDao.get(id).orElseThrow();
    }
}
