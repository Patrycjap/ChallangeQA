package apiSteps;

import io.restassured.response.Response;

import static io.restassured.RestAssured.when;

public class ApiClass {

    public static Response GetBooking() {
        return when().get("/booking").
            then().using().
            extract().response();
    }

    static Response getSingleId() {
        return when().get("/1").
            then().using().
            extract().response();
    }
}