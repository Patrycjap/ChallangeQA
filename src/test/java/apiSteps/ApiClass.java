package apiSteps;

import com.jayway.jsonpath.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class ApiClass {

    String adminBody = "{\n" +
        "  \"username\": \"admin\",\n" +
        "  \"password\": \"password123\" \n" +
        "}";

    public static Response GetBooking() {
        return when().get("/booking").
            then().log().all().using().
            extract().response();
    }

    static Response getSingleId() {
        return when().get("/1").
            then().log().all().using().
            extract().response();
    }

    public static Response DeleteBooking(String token) {
        return given().auth().oauth2(token).contentType("application/json").
            when().delete("https://restful-booker.herokuapp.com/booking/2").
            then().log().all().using().
            extract().response();
    }

    public String GetToken() {
        return given().body(adminBody).contentType("application/json")
            .when().post("https://restful-booker.herokuapp.com/auth").
                then().log().all().using().
                extract().response().asString();
    }

    public String TakeTokenNumberFromJson(String json) {
        return JsonPath.read(json, "$.token");
    }
}