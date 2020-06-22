package cinema.controller;

import cinema.dto.request.MovieSessionRequestDto;
import cinema.dto.response.ShoppingCartResponseDto;
import cinema.service.MovieSessionService;
import cinema.service.ShoppingCartService;
import cinema.service.UserService;
import cinema.util.maper.ShoppingCartMaper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shopping-carts")
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;
    private final UserService userService;
    private final ShoppingCartMaper shoppingCartMaper;
    private final MovieSessionService movieSessionService;

    public ShoppingCartController(ShoppingCartService shoppingCartService,
                                  UserService userService,
                                  ShoppingCartMaper shoppingCartMaper,
                                  MovieSessionService movieSessionService) {
        this.shoppingCartService = shoppingCartService;
        this.userService = userService;
        this.shoppingCartMaper = shoppingCartMaper;
        this.movieSessionService = movieSessionService;
    }

    @GetMapping("/by-user")
    public ShoppingCartResponseDto getAll(@RequestParam Long userId) {
        return shoppingCartMaper.transfer(shoppingCartService.getByUser(userService.get(userId)));
    }

    @PostMapping
    public void addMovieSession(@RequestBody MovieSessionRequestDto movieSessionId,
                       @RequestParam Long userId) {
        shoppingCartService.addSession(movieSessionService.get(movieSessionId.getId()),
                userService.get(userId));
    }
}
