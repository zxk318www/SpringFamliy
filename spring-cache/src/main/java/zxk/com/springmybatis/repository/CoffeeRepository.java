package zxk.com.springmybatis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zxk.com.springmybatis.model.Coffee;

/**
 * @program: spring-bucks
 * @description:
 * @author: Zhangxike
 * @create: 2019-06-21 15:46
 **/
public interface CoffeeRepository extends JpaRepository<Coffee,Long> {
}
