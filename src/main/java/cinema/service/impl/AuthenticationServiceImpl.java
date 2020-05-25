package cinema.service.impl;

import cinema.lib.Injector;
import cinema.model.User;
import cinema.service.AuthenticationService;
import cinema.service.UserService;
import cinema.util.HashUtil;
import javax.naming.AuthenticationException;

public class AuthenticationServiceImpl implements AuthenticationService {
    private static final Injector INJECTOR = Injector.getInstance("cinema");
    private UserService userService = (UserService) INJECTOR
            .getInstance(UserService.class);

    @Override
    public User login(String email, String password) throws AuthenticationException {
        User user = userService.findByEmail(email);
        if (user.getPassword().equals(HashUtil.hashPassword(password,user.getSalt()))) {
            return user;
        }
        throw new AuthenticationException("email or Password is incorrect");
    }

    @Override
    public User register(String email, String password) {
        User user = new User();
        return userService.add(user.email(email).salt(HashUtil.getSalt())
                .password(HashUtil.hashPassword(password,user.getSalt())));
    }
}
