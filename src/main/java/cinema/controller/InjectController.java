package cinema.controller;

import cinema.model.Role;
import cinema.model.User;
import cinema.service.RoleService;
import cinema.service.UserService;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inject")
public class InjectController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @GetMapping
    public void injectData() {
        Role adminRole = new Role();
        adminRole.setRoleName(Role.RoleName.ADMIN);
        Role userRole = new Role();
        userRole.setRoleName(Role.RoleName.USER);
        roleService.add(adminRole);
        roleService.add(userRole);
        User admin = new User();
        admin.setEmail("em@ail");
        admin.setPassword(passwordEncoder.encode("q"));
        admin.setLogin("q");
        admin.setFirstName("Name_");
        admin.setLastName("LName_");
        admin.setAge(10);
        admin.setRoles(Set.of(adminRole));
        userService.add(admin);
        for (int i = 0; i < 4; i++) {
            User user = new User();
            user.setEmail("email_" + i);
            user.setPassword(passwordEncoder.encode("password_" + i));
            user.setLogin("login_" + i);
            user.setFirstName("Name_" + i);
            user.setLastName("LName_" + i);
            user.setAge(i * 10);
            user.setRoles(Set.of(userRole));
            userService.add(user);
        }
    }
}
