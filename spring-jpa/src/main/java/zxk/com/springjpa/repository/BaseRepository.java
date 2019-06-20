package zxk.com.springjpa.repository;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * @program: spring-jpa
 * @description:
 * @author: Zhangxike
 * @create: 2019-06-20 14:54
 **/
@NoRepositoryBean
public interface BaseRepository<T, Long> extends PagingAndSortingRepository<T, Long>  {
    List<T> findTop3ByOrderByUpdateTimeDescIdAsc();
}
