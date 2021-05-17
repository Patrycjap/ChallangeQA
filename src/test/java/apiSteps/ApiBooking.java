package apiSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;

import static io.restassured.RestAssured.*;

public class ApiBooking {

    @Given("User want to execute booking endpoint")
    public void userWantToExecuteBookingEndpoint() {
        baseURI = "https://restful-booker.herokuapp.com";
        basePath = "/booking";
    }

    @When("User submit the GET request with id")
    public void userSubmitTheGETRequestWithId() {
        ApiClass.GetBooking();
    }

    @Then("User should get {int} status code")
    public void userShouldGetStatusCode(int arg0) {
        Response response = ApiClass.getSingleId();
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }
}