package zxk.com.springmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import zxk.com.springmongo.model.Coffee;

import java.util.List;

/**
 * @program: spring-mongo-repository
 * @description:
 * @author: Zhangxike
 * @create: 2019-06-25 10:50
 **/
public interface CoffeeRepository extends MongoRepository<Coffee,String> {
    List<Coffee> findByName(String name);
}
