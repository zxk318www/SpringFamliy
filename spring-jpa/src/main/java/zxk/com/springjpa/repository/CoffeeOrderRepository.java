package zxk.com.springjpa.repository;

import zxk.com.springjpa.model.CoffeeOrder;

import java.util.List;

/**
 * @program: spring-jpa
 * @description:
 * @author: Zhangxike
 * @create: 2019-06-20 14:25
 **/
public interface CoffeeOrderRepository  extends BaseRepository<CoffeeOrder,Long> {
    List<CoffeeOrder> findByCustomerOrderById(String customer);
    List<CoffeeOrder> findByItems_Name(String name);
}
