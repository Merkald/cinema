package cinema.util.maper;

import cinema.dto.response.ShoppingCartResponseDto;
import cinema.model.ShoppingCart;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartMaper {
    @Autowired
    private UserMaper userMaper;
    @Autowired
    private TicketMaper ticketMaper;

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
