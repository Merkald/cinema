package cinema.util.maper;

import cinema.dto.response.MovieDto;
import cinema.model.Movie;
import org.springframework.stereotype.Component;

@Component
public class MovieMaper {
    public MovieDto transfer(Movie movie) {
        MovieDto movieDto = new MovieDto();
        movieDto.setTitle(movie.getTitle());
        movieDto.setDescription(movie.getDescription());
        return movieDto;
    }

    public Movie transfer(MovieDto movieDto) {
        Movie movie = new Movie();
        movie.setTitle(movieDto.getTitle());
        movie.setDescription(movieDto.getDescription());
        return movie;
    }
}
