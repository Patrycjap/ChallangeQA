package objects;

import manager.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import wait.WaitForElement;

public class HomePage {

    private WebDriver driver;

//    @FindBy(linkText = "javascript:baseWeb.baseWebUtils.logout()")
    @FindBy(id = "logout-button")
    private WebElement logoutButton;

    @FindBy(xpath = "//button[contains(@title,'Close Window')]")
    private WebElement closeButtonForWelcomeBanner;

    @FindBy(className = "ReactModalmodal_Content_Inner")
    private WebElement welcomeBanner;

    @FindBy(id = "domain-menu")
    private WebElement domainMenu;

    @FindBy(id = "lt-main-logo")
    private WebElement logoIsDisplayed;

    @FindBy(id = "hideLanding")
    private WebElement hideWelcomeBanner;


    public HomePage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public boolean logoutButtonIsDisplayed() throws Throwable {
        WaitForElement.waitUntilElementIsClickable(logoutButton);
        return logoutButton.isDisplayed();
    }

    public void closeWelcomePopup() throws Throwable {
        closeButtonForWelcomeBanner.click();
    }

    public boolean welcomePopupIsDisplayed() throws Throwable {
        WaitForElement.waitUntilElementIsClickable(welcomeBanner);
        return welcomeBanner.isDisplayed();
    }

    public boolean logoDevoIsDisplayed() throws Throwable {
        WaitForElement.waitUntilElementIsVisible(logoIsDisplayed);
        return logoIsDisplayed.isDisplayed();
    }

    public void logout() {
        WaitForElement.waitUntilElementIsClickable(logoutButton);
        logoutButton.click();
    }

    public void domainMenuIsDisplayed() {
        WaitForElement.waitUntilElementIsVisible(domainMenu);
        domainMenu.isDisplayed();
    }
}