package zxk.com.spring;

import org.springframework.stereotype.Service;

/**
 * @program: spring-transaction
 * @description:
 * @author: Zhangxike
 * @create: 2019-06-19 15:26
 **/
@Service
public interface FooService {
    void insertRecord();
    void insertThenRollback() throws RollbackException;

    void invokeInsertThenRollback() throws RollbackException;
}
