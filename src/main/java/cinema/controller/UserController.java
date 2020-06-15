package cinema.controller;

import cinema.dto.response.UserResponseDto;
import cinema.service.UserService;
import cinema.util.maper.UserMaper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserMaper userMaper;

    @GetMapping("/by-email")
    public UserResponseDto get(@RequestParam(name = "email") String email) {
        return userMaper.transfer(userService.findByEmail(email));
    }

    @GetMapping
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
