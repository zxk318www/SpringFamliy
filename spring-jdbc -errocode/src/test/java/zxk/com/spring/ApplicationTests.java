package zxk.com.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Test(expected = CustomDuplicatedKeyException.class)
	public void contextLoads() {
		jdbcTemplate.execute("INSERT INTO FOO (ID,BAR) VALUES (1,'z')");
		jdbcTemplate.execute("INSERT INTO FOO (ID,BAR) VALUES (1,'x')");
	}

}
