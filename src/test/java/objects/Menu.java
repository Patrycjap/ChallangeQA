package objects;

import manager.DriverManager;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import wait.WaitForElement;

public class Menu {


    private WebDriver driver;


    @FindBy(xpath = "//p[@class='account-timeZone']")
    private WebElement menuTimezone;

    @FindBy(xpath = "//span[@role='presentation']")
    private WebElement dropdownTimezone;

    @FindBy(xpath = "//li[contains(.,'MSK - Europe/Minsk (UTC + 03:00)')]")
    private WebElement timezoneMinsk;

    @FindBy(xpath = "//input[contains(@class,'session-checkbox')]")
    private WebElement checkboxApplyZoneForCurrentSession;

    @FindBy(xpath = "//button[@class='time-zone-picker-modal__save-btn']")
    private WebElement saveTimezone;


    public Menu() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public void clickTimezoneFromUserMenu() throws Throwable {
        WaitForElement.waitUntilElementIsClickable(menuTimezone);
        menuTimezone.click();
    }

    public void selectTimezone() throws Throwable {
        WaitForElement.waitUntilElementIsVisible(dropdownTimezone);
        dropdownTimezone.click();
        WaitForElement.waitUntilElementIsVisible(timezoneMinsk);
        try {
            timezoneMinsk.click();
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
    }

    public void clickCheckboxApplyCurrentSession() throws Throwable {
        WaitForElement.waitUntilElementIsClickable(checkboxApplyZoneForCurrentSession);
        if (!checkboxApplyZoneForCurrentSession.isSelected()) {
            checkboxApplyZoneForCurrentSession.click();
        }
    }

    public void setSaveTimezone() throws Throwable {
        WaitForElement.waitUntilElementIsClickable(saveTimezone);
        saveTimezone.click();
    }

    public String getTextOfTimezoneFromUserMenu() {
        WaitForElement.waitUntilElementIsVisible(menuTimezone);
        return menuTimezone.getAttribute("title");
    }
}