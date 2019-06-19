package zxk.com.spring;

import lombok.Builder;
import lombok.Data;

/**
 * @program: spring-jdbc
 * @description: 实体
 * @author: Zhangxike
 * @create: 2019-06-19 14:39
 **/
@Data
@Builder
public class Foo {
    private Long id;
    private String bar;
}
