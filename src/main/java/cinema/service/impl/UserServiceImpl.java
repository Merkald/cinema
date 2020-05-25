package cinema.service.impl;

import cinema.dao.UserDao;
import cinema.lib.Inject;
import cinema.lib.Service;
import cinema.model.User;
import cinema.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Inject
    UserDao userDao;

    @Override
    public User add(User user) {
        User newUser = userDao.add(user);
        return newUser;
    }

    @Override
    public User findByEmail(String email) {
        if (userDao.findByEmail(email).isEmpty()) {
            throw new RuntimeException("user doesnt exist");
        }
        return userDao.findByEmail(email).get();
    }
}
