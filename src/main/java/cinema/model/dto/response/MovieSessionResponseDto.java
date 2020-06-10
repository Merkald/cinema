package cinema.model.dto.response;

import java.time.LocalDateTime;
import java.util.Objects;

public class MovieSessionResponseDto {
    private Long id;
    private MovieDto movieDto;
    private CinemaHallDto cinemaHallDto;
    private LocalDateTime showTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MovieDto getMovieDto() {
        return movieDto;
    }

    public void setMovieDto(MovieDto movieDto) {
        this.movieDto = movieDto;
    }

    public CinemaHallDto getCinemaHallDto() {
        return cinemaHallDto;
    }

    public void setCinemaHallDto(CinemaHallDto cinemaHallDto) {
        this.cinemaHallDto = cinemaHallDto;
    }

    public LocalDateTime getShowTime() {
        return showTime;
    }

    public void setShowTime(LocalDateTime showTime) {
        this.showTime = showTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MovieSessionResponseDto that = (MovieSessionResponseDto) o;
        return Objects.equals(id, that.id)
                && Objects.equals(movieDto, that.movieDto)
                && Objects.equals(cinemaHallDto, that.cinemaHallDto)
                && Objects.equals(showTime, that.showTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, movieDto, cinemaHallDto, showTime);
    }

    @Override
    public String toString() {
        return "MovieSessionResponseDto{"
                + "id=" + id
                + ", movieDto=" + movieDto
                + ", cinemaHallDto=" + cinemaHallDto
                + ", showTime=" + showTime
                + '}';
    }
}
