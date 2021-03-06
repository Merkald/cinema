package cinema.dto.response;

import java.util.Objects;

public class MovieDto {
    private String title;
    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MovieDto movieDto = (MovieDto) o;
        return Objects.equals(title, movieDto.title)
                && Objects.equals(description, movieDto.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description);
    }

    @Override
    public String toString() {
        return "MovieDto{"
                + ", title='" + title + '\''
                + ", description='" + description + '\''
                + '}';
    }
}
