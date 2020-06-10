package cinema.dao;

import cinema.model.MovieSession;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface MovieSessionDao {
    List<MovieSession> findAvailableSessions(Long movieId, LocalDateTime date);

    MovieSession add(MovieSession session);

    Optional<MovieSession> get(Long id);
}
