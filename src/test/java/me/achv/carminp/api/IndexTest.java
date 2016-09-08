package me.achv.carminp.api;

import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.specification.RequestSpecification;
import org.hamcrest.core.Is;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.jayway.restassured.RestAssured.given;
import static org.springframework.restdocs.hypermedia.HypermediaDocumentation.*;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessRequest;
import static org.springframework.restdocs.restassured.RestAssuredRestDocumentation.document;
import static org.springframework.restdocs.restassured.RestAssuredRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.restassured.operation.preprocess.RestAssuredPreprocessors.modifyUris;

/**
 * Created by guiandmag on 30/08/16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class IndexTest extends CarminpNoSQLApiApplicationTests {

    private RequestSpecification documentationSpec;

    @Before
    public void setUp() {
        this.documentationSpec = new RequestSpecBuilder()
                .addFilter(documentationConfiguration(restDocumentation)).build();
    }

    @After
    public void tearDown() {
        this.documentationSpec = null;
    }

    @Test
    public void index_resource_returns_200_and_is_json() throws Exception {
        given(this.documentationSpec)
                .accept(DEFAULT_MEDIA_TYPE)
                .filter(document("index",
                        preprocessRequest(modifyUris()
                                            .scheme("https")
                                            .host("carminp.herokuapp.com")
                                            .removePort())))
        .when().get("/")
        .then().assertThat().statusCode(Is.is(200));

    }

    @Test
    public void index_test_links_returns_200() throws Exception {
        given(this.documentationSpec)
                .accept(DEFAULT_MEDIA_TYPE)
                .filter(document("index", links(halLinks(),
                        linkWithRel("users").description("Custom users description"),
                        linkWithRel("profile").ignored())))
                .when().get("/")
                .then().assertThat().statusCode(Is.is(200));
    }

}
