package zxk.com.springmybatis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zxk.com.springmybatis.model.CoffeeOrder;

/**
 * @program: spring-bucks
 * @description:
 * @author: Zhangxike
 * @create: 2019-06-21 15:47
 **/
public interface CoffeeOrderRepository extends JpaRepository<CoffeeOrder,Long> {
}
