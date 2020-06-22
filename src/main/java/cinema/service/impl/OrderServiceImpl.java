package cinema.service.impl;

import cinema.dao.OrderDao;
import cinema.dao.ShoppingCartDao;
import cinema.model.Order;
import cinema.model.User;
import cinema.service.OrderService;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderDao orderDao;
    private final ShoppingCartDao shoppingCartDao;

    public OrderServiceImpl(OrderDao orderDao, ShoppingCartDao shoppingCartDao) {
        this.orderDao = orderDao;
        this.shoppingCartDao = shoppingCartDao;
    }

    @Override
    public Order completeOrder(User user) {
        Order order = new Order();
        order.setTickets(shoppingCartDao.getByUser(user).getTickets());
        order.setUser(user);
        order.setOrderDate(LocalDateTime.now());
        return orderDao.create(order);
    }

    @Override
    public List<Order> getOrderHistory(User user) {
        return orderDao.getOrderHistory(user);
    }

    @Override
    public Order get(Long id) {
        return orderDao.get(id).orElseThrow();
    }
}
