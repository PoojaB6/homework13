package api;

import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

public class DummyDeliveryTest {

    public static final String BASE_URL = "https://backend.tallinn-learning.ee";
    public static final String BASE_PATH = "/test-orders/";
    @Test
    public void checkOrderDetailsWithCorrectOrderId(){
        RestAssured
                .given()
                .log()
                .all()
                .get(BASE_URL + BASE_PATH + "1")
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void checkErrorStatusWithIncorrectOrderId(){
        RestAssured
                .given()
                .log()
                .all()
                .get(BASE_URL + BASE_PATH + "11")
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(HttpStatus.SC_BAD_REQUEST);
    }
}
