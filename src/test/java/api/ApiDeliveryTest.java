package api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ApiDeliveryTest {

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
    public void checkStatusWithIncorrectOrderId(){
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

    @Test
    public void checkErrorStatusWithIncorrectOrderId() {
        RestAssured
                .given()
                .log()
                .all()
                .get(BASE_URL + BASE_PATH + "12")
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(HttpStatus.SC_BAD_REQUEST);
    }
    //lesson 10

    @Test
    public void checkOrderDetailsWithCorrectOrderIdAndCheckStatus() {
        String receivedOrderStatus=RestAssured
                .given()
                .log()
                .all()
                .get(BASE_URL + BASE_PATH + "1")
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .and()
                .extract()
                .path("status");
        Assertions.assertEquals("OPEN",receivedOrderStatus);
    }

    @Test
    public void checkOrderIdInResponse() {
        int orderIdRequested=5;
        int receivedOrderId=RestAssured
                .given()
                .log()
                .all()
                .get(BASE_URL + BASE_PATH + orderIdRequested)
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .and()
                .extract()
                .path("id");
        Assertions.assertEquals(orderIdRequested,receivedOrderId);
    }
//Create order
    @Test
    public void checkOrderCreation() {
        String requestBodyUglyWay="{\n" +
                "  \"status\": \"OPEN\",\n" +
                "  \"courierId\": 0,\n" +
                "  \"customerName\": \"Pooja\",\n" +
                "  \"customerPhone\": \"585756\",\n" +
                "  \"comment\": \"Please call\",\n" +
                "  \"id\": 0\n" +
                "}";
        long receivedOrderId=RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(requestBodyUglyWay)
                .log()
                .all()
                .post(BASE_URL + BASE_PATH )
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .and()
                .extract()
                .path("id");
        //Assertions.assertEquals(,receivedOrderId);
    }
    @Test
    public void createOrderWithIncorrectStatusAndCheckResponseMessage() {
        String requestBodyUglyWay = "{\n" +
                "  \"status\": \"CLOSED\",\n" +
                "  \"courierId\": 0,\n" +
                "  \"customerName\": \"Pooja\",\n" +
                "  \"customerPhone\": \"585756\",\n" +
                "  \"comment\": \"Please call\",\n" +
                "  \"id\": 0\n" +
                "}";

        String responseBody = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(requestBodyUglyWay)
                .log()
                .all()
                .post(BASE_URL + BASE_PATH)
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .and()
                .extract()
                .asString();
        Assertions.assertEquals("Incorrect query", responseBody);
    }

    //Homework10

    //Delete Order Id

    @Test
    public void deleteOrderId() {
        int orderIDRequested = 7;
        RestAssured
                .given()
                .log()
                .all()
                .delete(BASE_URL + BASE_PATH + orderIDRequested)
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(HttpStatus.SC_BAD_REQUEST);
    }

    //Put Order
    @Test
    public void updateOrderDetails() {
        RestAssured
                .given()
                .log()
                .all()
                .put(BASE_URL+BASE_PATH+8)
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(HttpStatus.SC_BAD_REQUEST);
    }
}





