package cinema.controller;

import cinema.model.dto.response.UserResponseDto;
import cinema.service.UserService;
import cinema.util.DtoTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private DtoTransfer dtoTransfer;

    @RequestMapping(value = "/byemail",method = RequestMethod.GET)
    public UserResponseDto get(@RequestParam(name = "email") String email) {
        return dtoTransfer.transfer(userService.findByEmail(email));
    }

}
