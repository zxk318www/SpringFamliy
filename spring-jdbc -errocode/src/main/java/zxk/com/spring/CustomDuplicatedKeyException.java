package zxk.com.spring;

import org.springframework.dao.DuplicateKeyException;

/**
 * @program: spring-jdbc -errocode
 * @description: 自定义唯一键约束异常
 * @author: Zhangxike
 * @create: 2019-06-19 16:32
 **/
public class CustomDuplicatedKeyException extends DuplicateKeyException {
    public CustomDuplicatedKeyException(String msg) {
        super(msg);
    }

    public CustomDuplicatedKeyException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
