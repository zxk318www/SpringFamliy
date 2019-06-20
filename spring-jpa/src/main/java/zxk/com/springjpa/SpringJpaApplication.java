package zxk.com.springjpa;

import lombok.extern.slf4j.Slf4j;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import zxk.com.springjpa.model.Coffee;
import zxk.com.springjpa.model.CoffeeOrder;
import zxk.com.springjpa.model.OrderState;
import zxk.com.springjpa.repository.CoffeeOrderRepository;
import zxk.com.springjpa.repository.CoffeeRepository;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
@Slf4j
@EnableJpaRepositories
@EnableTransactionManagement
public class SpringJpaApplication implements ApplicationRunner {

	@Autowired
	private CoffeeRepository coffeeRepository;
	@Autowired
	private CoffeeOrderRepository coffeeOrderRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaApplication.class, args);
	}

	@Override
	@Transactional
	public void run(ApplicationArguments args) throws Exception {
		initOrders();
		findOrders();
	}

	private void initOrders(){
		Coffee espresso = Coffee.builder().name("espresso").price(Money.of(CurrencyUnit.of("CNY"),30.0)).build();

		coffeeRepository.save(espresso);
		log.info("Coffee:{}",espresso);

		Coffee latte = Coffee.builder().name("latte").price(Money.of(CurrencyUnit.of("CNY"),45.0)).build();
		coffeeRepository.save(latte);
		log.info("Coffee:{}",latte);

		CoffeeOrder order = CoffeeOrder.builder().customer("Zxk").items(Collections.singletonList(espresso)).state(OrderState.INIT).build();
		coffeeOrderRepository.save(order);
		log.info("Order:{}",order);

		order = CoffeeOrder.builder().customer("zxk").items(Arrays.asList(espresso,latte)).state(OrderState.INIT).build();
		coffeeOrderRepository.save(order);
		log.info("Order:{}",order);
	}

	public void findOrders(){
		coffeeOrderRepository.findAll(Sort.by(Sort.Direction.DESC,"id"))
				.forEach(c->log.info("Loading ：{}",c));

		List<CoffeeOrder> list = coffeeOrderRepository.findTop3ByOrderByUpdateTimeDescIdAsc();
		log.info("findTop3ByOrderByUpdateTimeDescIdAsc ：{}",getJoinedOrderId(list));

		list = coffeeOrderRepository.findByCustomerOrderById("zxk");
		log.info("findByCustomerOrderById :{}",getJoinedOrderId(list));

		//不开启事务会因为没有Session而报LazyInitializationException
		list.forEach(o->{
			log.info("Order:{}",o.getId());

			o.getItems().forEach(i->log.info("Item:{}",i));
		});

		list = coffeeOrderRepository.findByItems_Name("latte");
		log.info("findByItems_Name: {}", getJoinedOrderId(list));
	}

	public String getJoinedOrderId(List<CoffeeOrder> list){
		return list.stream().map(o->o.getId().toString()).collect(Collectors.joining(","));
	}
}
