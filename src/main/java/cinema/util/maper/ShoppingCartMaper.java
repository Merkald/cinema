package cinema.util.maper;

import cinema.dto.response.ShoppingCartResponseDto;
import cinema.model.ShoppingCart;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartMaper {
    private final UserMaper userMaper;
    private final TicketMaper ticketMaper;

    public ShoppingCartMaper(UserMaper userMaper, TicketMaper ticketMaper) {
        this.userMaper = userMaper;
        this.ticketMaper = ticketMaper;
    }

    public ShoppingCartResponseDto transfer(ShoppingCart shoppingCart) {
        ShoppingCartResponseDto shoppingCartResponseDto = new ShoppingCartResponseDto();
        shoppingCartResponseDto.setId(shoppingCart.getId());
        shoppingCartResponseDto.setUserResponseDto(userMaper.transfer(shoppingCart.getUser()));
        shoppingCartResponseDto.setTicketResponseDtos(shoppingCart
                .getTickets()
                .stream()
                .map(t -> ticketMaper.transfer(t))
                .collect(Collectors.toList()));
        return shoppingCartResponseDto;
    }
}
