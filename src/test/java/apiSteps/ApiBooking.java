package apiSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;

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

    @When("User submit the Delete request with id")
    public void userSubmitTheDeleteRequestWithId() {
        String token = new ApiClass().GetToken();
        ApiClass.DeleteBooking(token);
    }

    @Then("User should get {int} status code for Delete")
    public void userShouldGetStatusCodeForDelete(int arg0) {
        String json = new ApiClass().GetToken();
        String number = new ApiClass().TakeTokenNumberFromJson(json);
        Response response = ApiClass.DeleteBooking(number);
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }
}