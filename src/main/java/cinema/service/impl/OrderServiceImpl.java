package cinema.service.impl;

import cinema.dao.OrderDao;
import cinema.model.Order;
import cinema.model.ShoppingCart;
import cinema.model.User;
import cinema.service.OrderService;
import cinema.service.ShoppingCartService;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderDao orderDao;
    private final ShoppingCartService shoppingCartService;

    public OrderServiceImpl(OrderDao orderDao, ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
        this.orderDao = orderDao;
    }

    @Override
    public Order completeOrder(User user) {
        Order order = new Order();
        ShoppingCart shoppingCart = shoppingCartService.getByUser(user);
        order.setTickets(shoppingCart.getTickets());
        order.setUser(user);
        order.setOrderDate(LocalDateTime.now());
        shoppingCartService.clear(shoppingCart);
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
