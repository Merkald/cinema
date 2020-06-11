package cinema.util.maper;

import cinema.dto.response.TicketResponseDto;
import cinema.model.Ticket;
import org.springframework.stereotype.Component;

@Component
public class TicketMaper {
    public TicketResponseDto transfer(Ticket ticket) {
        TicketResponseDto ticketResponseDto = new TicketResponseDto();
        ticketResponseDto.setId(ticket.getId());
        ticketResponseDto.setUserId(ticket.getUser().getUserId());
        ticketResponseDto.setMovieSessionId(ticket.getMovieSession().getId());
        return ticketResponseDto;
    }
}
