package cinema.dto.request;

import java.util.Objects;
import javax.validation.constraints.NotNull;

public class ShoppingCartRequestDto {
    private Long id;
    @NotNull(message = "userId cant be null")
    private Long userId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ShoppingCartRequestDto that = (ShoppingCartRequestDto) o;
        return Objects.equals(id, that.id)
                && Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId);
    }

    @Override
    public String toString() {
        return "ShoppingCartRequestDto{"
                + "id=" + id
                + ", userId=" + userId
                + '}';
    }
}
