package cinema.model.dto.request;

import cinema.model.User;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class OrderRequestDto {
    private Long id;
    private List<Long> ticketIds;
    private User userId;
    private LocalDateTime orderDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Long> getTicketIds() {
        return ticketIds;
    }

    public void setTicketIds(List<Long> ticketIds) {
        this.ticketIds = ticketIds;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OrderRequestDto that = (OrderRequestDto) o;
        return Objects.equals(id, that.id)
                && Objects.equals(ticketIds, that.ticketIds)
                && Objects.equals(userId, that.userId)
                && Objects.equals(orderDate, that.orderDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ticketIds, userId, orderDate);
    }

    @Override
    public String toString() {
        return "OrderRequestDto{"
                + "id=" + id
                + ", ticketIds=" + ticketIds
                + ", userId=" + userId
                + ", orderDate=" + orderDate
                + '}';
    }
}
