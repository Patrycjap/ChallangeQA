package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import objects.LoginPage;

public class FogotPassword {

    @When("^she click forgot password link$")
    public void she_click_forgot_password_link() throws Throwable {
        new LoginPage().she_click_forgot_password_link();
    }

    @And("^she provides the recovery email as([^\"]*)$")
    public void she_provides_the_recovery_email_as(String password) throws Throwable {
        new LoginPage().she_provides_the_recovery_email_as(password);
    }

    @And("^she click send button$")
    public void she_click_send_button() throws Throwable {
        new LoginPage().she_click_send_button();
    }

    @Then("^she should be redirect to login page$")
    public void she_can_see_login_page() throws Throwable {
        boolean loginButtonIsVisible = new LoginPage().she_can_see_login_page();
        Assert.assertTrue(loginButtonIsVisible);
    }
}