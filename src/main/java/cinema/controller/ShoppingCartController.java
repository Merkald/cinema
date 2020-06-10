package cinema.controller;

import cinema.model.dto.request.MovieSessionRequestDto;
import cinema.model.dto.response.ShoppingCartResponseDto;
import cinema.service.MovieSessionService;
import cinema.service.ShoppingCartService;
import cinema.service.UserService;
import cinema.util.DtoTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shoppingcarts")
public class ShoppingCartController {
    @Autowired
    private ShoppingCartService shoppingCartService;
    @Autowired
    private UserService userService;
    @Autowired
    private DtoTransfer dtoTransfer;
    @Autowired
    private MovieSessionService movieSessionService;

    @GetMapping("/byuser")
    public ShoppingCartResponseDto getAll(@RequestParam Long userId) {
        return dtoTransfer.transfer(shoppingCartService.getByUser(userService.get(userId)));
    }

    @PostMapping("/addmoviesession")
    public void addMovieSession(@RequestBody MovieSessionRequestDto movieSessionId,
                       @RequestParam Long userId) {
        shoppingCartService.addSession(movieSessionService.get(movieSessionId.getId()),
                userService.get(userId));
    }
}
