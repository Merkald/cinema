package cinema.controller;

import cinema.dto.request.UserRequestDto;
import cinema.model.User;
import cinema.service.AuthenticationService;
import cinema.util.maper.UserMaper;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final UserMaper userMaper;

    public AuthenticationController(AuthenticationService authenticationService,
                                    UserMaper userMaper) {
        this.authenticationService = authenticationService;
        this.userMaper = userMaper;
    }

    @PostMapping
    public void create(@RequestBody @Valid UserRequestDto userRequestDto) {
        User user = userMaper.transfer(userRequestDto);
        authenticationService.register(user);
    }
}
