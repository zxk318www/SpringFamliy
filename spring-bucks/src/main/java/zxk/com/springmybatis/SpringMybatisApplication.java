package zxk.com.springmybatis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import zxk.com.springmybatis.model.Coffee;
import zxk.com.springmybatis.model.CoffeeOrder;
import zxk.com.springmybatis.model.OrderState;
import zxk.com.springmybatis.repository.CoffeeRepository;
import zxk.com.springmybatis.service.CoffeeOrderService;
import zxk.com.springmybatis.service.CoffeeService;

import java.util.Optional;

@SpringBootApplication
@Slf4j
@EnableTransactionManagement
@EnableJpaRepositories
public class SpringMybatisApplication implements ApplicationRunner {

	@Autowired
	private CoffeeRepository coffeeRepository;
	@Autowired
	private CoffeeService coffeeService;
	@Autowired
	private CoffeeOrderService orderService;

	public static void main(String[] args) {
		SpringApplication.run(SpringMybatisApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		log.info("All Coffee: {}", coffeeRepository.findAll());

		Optional<Coffee> latte = coffeeService.findOneCoffee("Latte");
		if (latte.isPresent()) {
			CoffeeOrder order = orderService.createOrder("Li Lei", latte.get());
			log.info("Update INIT to PAID: {}", orderService.updateState(order, OrderState.PAID));
			log.info("Update PAID to INIT: {}", orderService.updateState(order, OrderState.INIT));
		}
	}

}
