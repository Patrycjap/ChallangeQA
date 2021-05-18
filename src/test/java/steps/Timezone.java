package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import objects.Menu;

public class Timezone {


    @When("she click timezone configuration from user menu")
    public void sheClickTimezoneConfigurationFromUserMenu() throws Throwable {
        new Menu().clickTimezoneFromUserMenu();
    }

    @And("she select timezone")
    public void sheSelectTimeZoneAs() throws Throwable {
        new Menu().selectTimezone();
    }

    @And("she check apply only for current session")
    public void sheCheckApplyOnlyForCurrentSession() throws Throwable {
        new Menu().clickCheckboxApplyCurrentSession();
    }

    @Then("^she should see changed timezone in user menu as ([^\"]*)$")
    public void sheShouldSeeExpectedTimezoneInUserMenu(String expectedTimezone) throws Throwable {
        Thread.sleep(3000);
        String currentTimezone = new Menu().getTextOfTimezoneFromUserMenu();
        Assert.assertTrue(currentTimezone.contains(expectedTimezone));
    }

    @And("she save timezone settings")
    public void sheSaveTimezoneSettings() throws Throwable {
        new Menu().setSaveTimezone();
        Thread.sleep(3000);
    }
}