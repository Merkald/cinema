package cinema.dao;

import cinema.model.Ticket;
import java.util.Optional;

public interface TicketDao {
    Ticket add(Ticket ticket);

    Optional<Ticket> get(Long id);
}
