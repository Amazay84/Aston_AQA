import EchoPostman.EchoPostReq;
import EchoPostman.EchoPostResp;
import Spec.Specifications;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class RestTest {
    private static final String URL = "https://postman-echo.com";

    @BeforeEach
    void setup() {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpec200ok());
    }
    @Test
    void echoGetTest() {
        given().log().body()
                .when().get("/get?foo1=bar1&foo2=bar2")
                .then().log().all()
                .body("args.foo1", equalTo("bar1")).body("args.foo2", equalTo("bar2"));
    }
    @Test
    void echoPostTest() {
        given().log().body()
                .when().post("/post")
                .then().log().all();
    }
    @Test
    void echoBodyPostTest() {
        EchoPostReq req = new EchoPostReq("bar1", "bar2");
        EchoPostResp resp = given().body(req)
                .when().post("/post")
                .then()
                .body("json.foo1", equalTo("bar1"))
                .and().body("json.foo2", equalTo("bar2"))
                .extract().body().jsonPath().getObject("json", EchoPostResp.class);
        Assertions.assertAll(()->Assertions.assertTrue(resp.getFoo1().equals("bar1")),
                ()->Assertions.assertTrue(resp.getFoo2().equals("bar2")));
    }
    @Test
    void echoPutTest() {
        given().log().body()
                .when().put("/put")
                .then();
    }
    @Test
    void echoPatchTest() {
        given().log().body()
                .when().patch("/patch")
                .then();
    }
    @Test
    void echoDeleteTest() {
        given().log().body()
                .when().delete("/delete")
                .then();
    }
}
