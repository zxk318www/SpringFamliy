package zxk.com.spring;

import com.alibaba.druid.filter.FilterChain;
import com.alibaba.druid.filter.FilterEventAdapter;
import com.alibaba.druid.proxy.jdbc.ConnectionProxy;
import lombok.extern.slf4j.Slf4j;

import java.util.Properties;

/**
 * @program: spring
 * @description:
 * @author: Zhangxike
 * @create: 2019-06-18 16:03
 **/
@Slf4j
public class ConnectionLogFilter extends FilterEventAdapter {

    @Override
    public void connection_connectBefore(FilterChain chain, Properties info) {
        log.info("Before connection");
    }

    @Override
    public void connection_connectAfter(ConnectionProxy connection) {
        log.info("After connection");
    }
}
