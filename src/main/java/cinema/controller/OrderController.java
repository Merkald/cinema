package cinema.controller;

import cinema.model.dto.request.ShoppingCartRequestDto;
import cinema.model.dto.response.OrderResponseDto;
import cinema.service.OrderService;
import cinema.service.ShoppingCartService;
import cinema.service.UserService;
import cinema.util.DtoTransfer;
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
    private ShoppingCartService shoppingCartService;
    @Autowired
    private UserService userService;
    @Autowired
    private DtoTransfer dtoTransfer;
    @Autowired
    private OrderService orderService;

    @GetMapping("/byuser")
    public List<OrderResponseDto> getAll(@RequestParam Long userId) {
        return orderService.getOrderHistory(userService.get(userId))
                .stream()
                .map(o -> dtoTransfer.transfer(o))
                .collect(Collectors.toList());
    }

    @PostMapping("/complete")
    public void complete(@RequestBody ShoppingCartRequestDto shoppingCartRequestDto) {
        orderService.completeOrder(userService.get(shoppingCartRequestDto.getUserId()));
    }
}
