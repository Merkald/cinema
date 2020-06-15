package cinema.controller;

import cinema.dto.response.UserResponseDto;
import cinema.model.User;
import cinema.service.UserService;
import cinema.util.HashUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inject")
public class InjectController {
    @Autowired
    private UserService userService;
    @Autowired
    private HashUtil hashUtil;

    @GetMapping
    public void injectData() {
        for (int i = 0; i < 4; i++) {
            User user = new User();
            user.setEmail("email_" + i);
            user.setSalt(hashUtil.getSalt());
            user.setPassword(hashUtil.hashPassword("password_" + i, user.getSalt()));
            user.setLogin("login_" + i);
            user.setFirstName("Name_" + i);
            user.setLastName("LName_" + i);
            user.setAge(i * 10);
            userService.add(user);
        }
    }

    @GetMapping("/user")
    public UserResponseDto getUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object princeple = authentication.getPrincipal();
        if (princeple instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) princeple;
            System.out.println(userDetails.getUsername());
        }
        return null;
    }
}
