package cinema.controller;

import cinema.dto.request.UserRequestDto;
import cinema.model.User;
import cinema.service.AuthenticationService;
import cinema.util.maper.UserMaper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;
    @Autowired
    private UserMaper userMaper;

    @PostMapping
    public void create(@RequestBody UserRequestDto userRequestDto) {
        User user = userMaper.transfer(userRequestDto);
        authenticationService.register(user);
    }
}
