package cinema.controller;

import cinema.dto.request.UserRequestDto;
import cinema.model.User;
import cinema.service.AuthenticationService;
import cinema.service.RoleService;
import cinema.util.maper.UserMaper;
import java.util.Set;
import javax.validation.Valid;
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
    @Autowired
    private RoleService roleService;

    @PostMapping
    public void create(@RequestBody @Valid UserRequestDto userRequestDto) {
        User user = userMaper.transfer(userRequestDto);
        user.setRoles(Set.of(roleService.getRoleByName("USER")));
        authenticationService.register(user);
    }
}
