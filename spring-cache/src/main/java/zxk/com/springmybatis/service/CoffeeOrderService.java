package zxk.com.springmybatis.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zxk.com.springmybatis.model.Coffee;
import zxk.com.springmybatis.model.CoffeeOrder;
import zxk.com.springmybatis.model.OrderState;
import zxk.com.springmybatis.repository.CoffeeOrderRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @program: spring-bucks
 * @description:
 * @author: Zhangxike
 * @create: 2019-06-21 15:52
 **/
@Service
@Slf4j
@Transactional
public class CoffeeOrderService {
    @Autowired
    private CoffeeOrderRepository orderRepository;

    public CoffeeOrder createOrder(String customer, Coffee...coffee) {
        CoffeeOrder order = CoffeeOrder.builder()
                .customer(customer)
                .items(new ArrayList<>(Arrays.asList(coffee)))
                .state(OrderState.INIT)
                .build();
        CoffeeOrder saved = orderRepository.save(order);
        log.info("New Order: {}", saved);
        return saved;
    }

    public boolean updateState(CoffeeOrder order, OrderState state) {
        if (state.compareTo(order.getState()) <= 0) {
            log.warn("Wrong State order: {}, {}", state, order.getState());
            return false;
        }
        order.setState(state);
        orderRepository.save(order);
        log.info("Updated Order: {}", order);
        return true;
    }
}
