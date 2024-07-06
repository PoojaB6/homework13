package api;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

public class DummyDeliveryTest {
    @Test
    public void checkOrderDetailsWithCorrectOrderId(){
        RestAssured
                .given()
                .log()
                .all()
                .get("https://backend.tallinn-learning.ee/test-orders/1")
                .then()
                .log()
                .all();
    }

}
