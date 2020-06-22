package cinema.controller;

import cinema.dto.response.UserResponseDto;
import cinema.service.UserService;
import cinema.util.maper.UserMaper;
import javassist.NotFoundException;
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
    private final UserService userService;
    private final UserMaper userMaper;

    public UserController(UserService userService, UserMaper userMaper) {
        this.userService = userService;
        this.userMaper = userMaper;
    }

    @GetMapping("/by-email")
    public UserResponseDto get(@RequestParam(name = "email") String email) {
        return userMaper.transfer(userService.findByEmail(email));
    }

    @GetMapping
    public UserResponseDto getUser() throws NotFoundException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object princeple = authentication.getPrincipal();
        if (princeple instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) princeple;
            return userMaper.transfer(userService.findByLogin(userDetails.getUsername()));
        }
        throw new NotFoundException("user doesnt exist");
    }
}
