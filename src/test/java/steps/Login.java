package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import objects.HomePage;
import objects.LoginPage;

public class Login {

    @When("^she provides the email as ([^\"]*)$")
    public void she_provides_the_email_as(String email) throws Throwable {
        new LoginPage().she_provides_the_email_as(email);
    }

    @And("^she provides the password as ([^\"]*)$")
    public void she_provides_the_password_as(String password) throws Throwable {
        new LoginPage().she_provides_the_password_as(password);
    }

    @And("^she click login$")
    public void she_click_login() throws Throwable {
        new LoginPage().she_signs_in();
    }

    @Then("^she should be successfully logged to the application$")
    public void she_should_be_logged_in_to_the_application() throws Throwable {
        boolean signOutButtonDisplayed = new HomePage().logoutButtonIsDisplayed();
        Assert.assertTrue(signOutButtonDisplayed);

    }

    @And("she should close welcome popup")
    public void sheShouldCloseWelcomePopup() throws Throwable {
        new HomePage().closeWelcomePopup();
    }

    @Then("she should not be logged to the application")
    public void sheShouldNotBeLoggedToTheApplication() throws Throwable {
        boolean errorPopup= new LoginPage().she_can_see_error_popup();
        Assert.assertTrue(errorPopup);
    }

    @And("she click logout")
    public void sheClickLogout() {
        new HomePage().logout();
    }

    @Then("she should see domain menu")
    public void sheShouldSeeDomainMenu() {
        new HomePage().domainMenuIsDisplayed();
    }
}