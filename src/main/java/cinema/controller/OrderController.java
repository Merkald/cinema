package cinema.controller;

import cinema.dto.request.ShoppingCartRequestDto;
import cinema.dto.response.OrderResponseDto;
import cinema.service.OrderService;
import cinema.service.UserService;
import cinema.util.maper.OrderMaper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final UserService userService;
    private final OrderService orderService;
    private final OrderMaper orderMaper;

    public OrderController(UserService userService, OrderService orderService,
                           OrderMaper orderMaper) {
        this.userService = userService;
        this.orderService = orderService;
        this.orderMaper = orderMaper;
    }

    @GetMapping
    public List<OrderResponseDto> getAll(Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return orderService.getOrderHistory(userService.getByLogin(userDetails.getUsername()))
                .stream()
                .map(o -> orderMaper.transfer(o))
                .collect(Collectors.toList());
    }

    @PostMapping
    public void complete(@RequestBody ShoppingCartRequestDto shoppingCartRequestDto) {

        orderService.completeOrder(userService.get(shoppingCartRequestDto.getUserId()));
    }
}
