package zxk.com.springmybatis.mapper;

import org.apache.ibatis.annotations.*;
import zxk.com.springmybatis.model.Coffee;

/**
 * @program: spring-mybatis
 * @description:
 * @author: Zhangxike
 * @create: 2019-06-20 16:26
 **/
@Mapper
public interface CoffeeMapper {
    @Insert("insert into t_coffee (name,price,create_time,update_time)"+
    "values (#{name},#{price},now(),now())")
    @Options(useGeneratedKeys = true)
    int save(Coffee coffee);

    @Select("select * from t_coffee where id = #{id}")
    @Results({
            @Result(id=true,column = "id",property = "id"),
            @Result(column ="create_time",property ="createTime"),
            // map-underscore-to-camel-case = true 可以实现一样的效果
            // @Result(column = "update_time", property = "updateTime"),
    })
    Coffee findById(@Param("id")Long  id);
}
