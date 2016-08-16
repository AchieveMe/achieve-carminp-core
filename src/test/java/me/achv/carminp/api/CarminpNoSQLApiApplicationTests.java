package me.achv.carminp.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CarminpNoSQLApiApplicationTests {

	public void contextLoads() {

	}

	@Test
	public void testAssertion() {
		assertThat("aaa").contains("aaa");
	}

}
