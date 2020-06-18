package cinema.service.impl;

import cinema.exeptions.AuthenticationExeption;
import cinema.model.User;
import cinema.service.AuthenticationService;
import cinema.service.RoleService;
import cinema.service.ShoppingCartService;
import cinema.service.UserService;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Autowired
    private UserService userService;
    @Autowired
    private ShoppingCartService shoppingCartService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User login(String email, String password) throws AuthenticationExeption {
        User user = userService.findByEmail(email);
        if (passwordEncoder.matches(password,user.getPassword())) {
            return user;
        }
        throw new AuthenticationExeption("Passwords are not equals");
    }

    @Override
    public User register(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Set.of(roleService.getRoleByName("USER")));
        shoppingCartService.registerNewShoppingCart(userService.add(user));
        return user;
    }
}
