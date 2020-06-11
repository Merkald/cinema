package cinema.controller;

import cinema.dto.request.ShoppingCartRequestDto;
import cinema.dto.response.OrderResponseDto;
import cinema.service.OrderService;
import cinema.service.UserService;
import cinema.util.maper.OrderMaper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private UserService userService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderMaper orderMaper;

    @GetMapping
    public List<OrderResponseDto> getAll(@RequestParam Long userId) {
        return orderService.getOrderHistory(userService.get(userId))
                .stream()
                .map(o -> orderMaper.transfer(o))
                .collect(Collectors.toList());
    }

    @PostMapping
    public void complete(@RequestBody ShoppingCartRequestDto shoppingCartRequestDto) {
        orderService.completeOrder(userService.get(shoppingCartRequestDto.getUserId()));
    }
}
