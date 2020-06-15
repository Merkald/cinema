package cinema.controller;

import cinema.dto.response.UserResponseDto;
import cinema.service.UserService;
import cinema.util.maper.UserMaper;
import org.springframework.beans.factory.annotation.Autowired;
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

}
