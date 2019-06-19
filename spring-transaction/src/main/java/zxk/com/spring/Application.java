package zxk.com.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.TransactionTemplate;

@SpringBootApplication
@Slf4j
@EnableTransactionManagement(mode = AdviceMode.PROXY)
public class Application implements CommandLineRunner {

	@Autowired
	private TransactionTemplate transactionTemplate;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private FooService fooService;


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		fooService.insertRecord();
		log.info("AAA:{}",jdbcTemplate.queryForObject("SELECT COUNT (*) FROM FOO WHERE BAR ='AAA' ",Long.class));
		try{
			fooService.insertThenRollback();
		}catch (Exception e){
			log.info("BBB:{}",jdbcTemplate.queryForObject("SELECT COUNT (*) FROM FOO WHERE BAR ='BBB' ",Long.class));
		}
		try {
			fooService.invokeInsertThenRollback();
		}catch (Exception e){
			log.info("BBB:{}",jdbcTemplate.queryForObject("SELECT COUNT (*) FROM FOO WHERE BAR ='BBB' ",Long.class));
		}

	}



}
