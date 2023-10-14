import EchoPostman.EchoPostReq;
import Spec.Specifications;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

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
                .assertThat()
                .extract().jsonPath().get();
    }
    @Test
    void echoPostTest() {
        given().log().body()
                .when().post("/post")
                .then().log().all()
                .assertThat();
    }
    @Test
    void echoBodyPostTest() {
        EchoPostReq req = new EchoPostReq("bar1", "bar2");
        given().body(req)
                .when().post("/post")
                .then().log().all();
    }
    @Test
    void echoPutTest() {
        given().log().body()
                .when().put("/put")
                .then().log().all();
    }
    @Test
    void echoPatchTest() {
        given().log().body()
                .when().patch("/patch")
                .then().log().all();
    }
    @Test
    void echoDeleteTest() {
        given().log().body()
                .when().delete("/delete")
                .then().log().all();
    }
}
