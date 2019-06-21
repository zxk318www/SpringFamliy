package zxk.com.springmybatis;

import lombok.extern.slf4j.Slf4j;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zxk.com.springmybatis.mapper.CoffeeMapper;
import zxk.com.springmybatis.model.Coffee;
import zxk.com.springmybatis.model.CoffeeExample;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
		//generateArtifacts();
		playWithArt();
	}

	/**
	 * 生成
	 * @throws Exception
	 */
	private void generateArtifacts() throws Exception {
		List<String> warnings = new ArrayList<>();
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(
				this.getClass().getResourceAsStream("/generatorConfig.xml"));
		DefaultShellCallback callback = new DefaultShellCallback(true);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
		myBatisGenerator.generate(null);
	}

	private void playWithArt(){
		Coffee espresso = new Coffee().withName("espresso").withPrice(Money.of(CurrencyUnit.of("CNY"),25.0))
				.withCreateTime(new Date()).withUpdateTime(new Date());
		coffeeMapper.insert(espresso);

		Coffee latte = new Coffee().withName("espresso").withPrice(Money.of(CurrencyUnit.of("CNY"),35.0))
				.withCreateTime(new Date()).withUpdateTime(new Date());
		coffeeMapper.insert(latte);

		Coffee s = coffeeMapper.selectByPrimaryKey(1L);
		log.info("Coffee:{}",s);

		CoffeeExample example = new CoffeeExample();
		example.createCriteria().andNameEqualTo("latte");
		List<Coffee> list = coffeeMapper.selectByExample(example);
		list.forEach(e->log.info("SelectByExample:{}",e));
	}
}
