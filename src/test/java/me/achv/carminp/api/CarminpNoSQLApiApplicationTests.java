package me.achv.carminp.api;

import com.jayway.restassured.http.ContentType;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@Ignore
public class CarminpNoSQLApiApplicationTests {

	@Rule
	public final JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation("build/generated-snippets");

	protected ContentType DEFAULT_MEDIA_TYPE = ContentType.JSON;

}
