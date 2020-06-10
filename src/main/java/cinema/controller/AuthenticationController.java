package cinema.controller;

import cinema.model.User;
import cinema.model.dto.request.UserRequestDto;
import cinema.service.AuthenticationService;
import cinema.util.DtoTransfer;
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
    private DtoTransfer dtoTransfer;

    @PostMapping
    public void create(@RequestBody UserRequestDto userRequestDto) {
        User user = dtoTransfer.transfer(userRequestDto);
        authenticationService.register(user);
    }
}
