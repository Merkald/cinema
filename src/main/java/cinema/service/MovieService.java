package cinema.service;

import cinema.lib.Service;
import cinema.model.Movie;
import java.util.List;

@Service
public interface MovieService {
    Movie add(Movie movie);

    List<Movie> getAll();
}
