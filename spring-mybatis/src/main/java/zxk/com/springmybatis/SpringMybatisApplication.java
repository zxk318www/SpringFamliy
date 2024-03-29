package zxk.com.springmybatis;

import lombok.extern.slf4j.Slf4j;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zxk.com.springmybatis.mapper.CoffeeMapper;
import zxk.com.springmybatis.model.Coffee;

@SpringBootApplication
@Slf4j
@MapperScan("zxk.com.springmybatis.mapper")
public class SpringMybatisApplication implements ApplicationRunner {

	@Autowired
	private CoffeeMapper coffeeMapper;

	public static void main(String[] args) {
		SpringApplication.run(SpringMybatisApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Coffee coffee = Coffee.builder().name("espresso").price(Money.of(CurrencyUnit.of("CNY"),20.0)).build();
		int count = coffeeMapper.save(coffee);
		log.info("Save{} Coffee:{}",count,coffee);

		coffee = Coffee.builder().name("latte").price(Money.of(CurrencyUnit.of("CNY"),35.0)).build();
		count = coffeeMapper.save(coffee);
		log.info("Save{} Coffee:{}",count,coffee);

		coffee = coffeeMapper.findById(coffee.getId());
		log.info("Find Coffee :{}",coffee);
	}
}
