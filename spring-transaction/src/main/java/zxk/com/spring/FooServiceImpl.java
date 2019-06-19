package zxk.com.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @program: spring-transaction
 * @description:
 * @author: Zhangxike
 * @create: 2019-06-19 15:28
 **/
@Component
public class FooServiceImpl implements FooService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    @Transactional
    public void insertRecord() {
        jdbcTemplate.execute("INSERT INTO  FOO (BAR) VALUES ('AAA')");
    }

    /**
     * 抛出空异常需要回滚事务
     * @throws RollbackException
     */
    @Override
    @Transactional(rollbackFor = RollbackException.class)
    public void insertThenRollback() throws RollbackException  {
        jdbcTemplate.execute("INSERT  INTO  FOO (BAR) VALUES ('BBB')");
        throw new RollbackException();
    }

    @Override
    public void invokeInsertThenRollback()  throws RollbackException {
        insertThenRollback();
    }
}
