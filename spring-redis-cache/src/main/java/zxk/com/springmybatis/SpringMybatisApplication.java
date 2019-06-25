package zxk.com.springmybatis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import zxk.com.springmybatis.repository.CoffeeRepository;
import zxk.com.springmybatis.service.CoffeeService;

@SpringBootApplication
@Slf4j
@EnableTransactionManagement
@EnableJpaRepositories
@EnableCaching(proxyTargetClass = true)
public class SpringMybatisApplication implements ApplicationRunner {

	@Autowired
	private CoffeeRepository coffeeRepository;
	@Autowired
	private CoffeeService coffeeService;


	public static void main(String[] args) {
		SpringApplication.run(SpringMybatisApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		log.info("Count: {}", coffeeRepository.findAll().size());
		for (int i =0;i<10;i++){
			log.info("Reading from cache.");
			coffeeService.findAllCoffee();
		}
		coffeeService.reloadCoffee();
		log.info("Reading after refresh.");
		coffeeService.findAllCoffee().forEach(c->log.info("Coffee:{}",c.getName()));
	}

}
