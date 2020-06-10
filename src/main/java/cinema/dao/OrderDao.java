package cinema.dao;

import cinema.model.Order;
import cinema.model.User;
import java.util.List;
import java.util.Optional;

public interface OrderDao {
    Order create(Order order);

    List<Order> getOrderHistory(User user);

    Optional<Order> get(Long id);
}
