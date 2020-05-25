package cinema.service.impl;

import cinema.exeptions.AuthenticationExeption;
import cinema.lib.Injector;
import cinema.model.User;
import cinema.service.AuthenticationService;
import cinema.service.UserService;
import cinema.util.HashUtil;

public class AuthenticationServiceImpl implements AuthenticationService {
    private static final Injector INJECTOR = Injector.getInstance("cinema");
    private UserService userService = (UserService) INJECTOR
            .getInstance(UserService.class);

    @Override
    public User login(String email, String password) throws AuthenticationExeption {
        User user = userService.findByEmail(email);
        if (user.getPassword().equals(HashUtil.hashPassword(password, user.getSalt()))) {
            return user;
        }
        throw new AuthenticationExeption("Passwords are not equals");
    }

    @Override
    public User register(String email, String password) {
        User user = new User()
                .email(email)
                .salt(HashUtil.getSalt());
        return userService.add(user
                .password(HashUtil.hashPassword(password, user.getSalt())));
    }
}
