package cinema.util.maper;

import cinema.dto.response.OrderResponseDto;
import cinema.model.Order;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderMaper {
    @Autowired
    private UserMaper userMaper;
    @Autowired
    private TicketMaper ticketMaper;

    public OrderResponseDto transfer(Order order) {
        OrderResponseDto orderResponseDto = new OrderResponseDto();
        orderResponseDto.setId(order.getId());
        orderResponseDto.setOrderDate(order.getOrderDate());
        orderResponseDto.setUserResponseDto(userMaper.transfer(order.getUser()));
        orderResponseDto.setTicketResponseDtos(order
                .getTickets()
                .stream()
                .map(t -> ticketMaper.transfer(t))
                .collect(Collectors.toList()));
        return orderResponseDto;
    }
}
