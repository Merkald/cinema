package cinema.service.impl;

import cinema.dao.MovieSessionDao;
import cinema.model.MovieSession;
import cinema.service.MovieSessionService;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MovieSessionServiceImpl implements MovieSessionService {
    private final MovieSessionDao movieSessionDao;

    public MovieSessionServiceImpl(MovieSessionDao movieSessionDao) {
        this.movieSessionDao = movieSessionDao;
    }

    @Override
    public List<MovieSession> findAvailableSessions(Long movieId, LocalDateTime date) {
        return movieSessionDao.findAvailableSessions(movieId, date);
    }

    @Override
    public MovieSession add(MovieSession session) {
        return movieSessionDao.add(session);
    }

    @Override
    public MovieSession get(Long id) {
        return movieSessionDao.get(id).orElseThrow();
    }
}
