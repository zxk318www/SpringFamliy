package zxk.com.spring;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: spring
 * @description: springmvc 入口
 * @author: Zhangxike
 * @create: 2019-06-18 14:11
 **/
@RestController
@RequestMapping(value = "/hello")
public class Hello {

    @RequestMapping(value ="/")
    private String hello(){
        return "hello.spring";
    }
}
