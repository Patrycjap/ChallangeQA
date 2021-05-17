package objects;

import manager.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import wait.WaitForElement;

public class LoginPage {

    private WebDriver driver;

    @FindBy(id = "loginEmail")
    private WebElement emailField;

    @FindBy(id = "loginPass")
    private WebElement passwordField;

    @FindBy(id = "btSignIn")
    private WebElement loginButton;

    @FindBy(id= "recoveryLink")
    private WebElement forgotPasswordLink;

    @FindBy(id = "recoveryEmail")
    private WebElement recoveryEmail;

    @FindBy(id = "recoveryPasswordButton")
    private WebElement sendButton;

    @FindBy(xpath = "//header[@class='notipop__header'][contains(.,'Ooops!')]")
    private WebElement errorPopup;

    @FindBy(xpath ="//p[contains(text(),'Too many unsuccessful attempts.')]")
    private WebElement messageErrorAboutUnsuccessfulAttempts;

    public LoginPage() {
        PageFactory.initElements(DriverManager.getWebDriver(),this);
    }

    public void she_provides_the_email_as(String email) throws Throwable {
        WaitForElement.waitUntilElementIsClickable(emailField);
        emailField.sendKeys(email);
    }


    public void she_provides_the_password_as(String password) throws Throwable {
        WaitForElement.waitUntilElementIsClickable(passwordField);
        passwordField.sendKeys(password);
    }

    public void she_signs_in() throws Throwable {
        WaitForElement.waitUntilElementIsClickable(loginButton);
        loginButton.click();
    }

    public void she_click_forgot_password_link() throws Throwable {
        WaitForElement.waitUntilElementIsVisible(forgotPasswordLink);
        forgotPasswordLink.click();
    }

    public void she_provides_the_recovery_email_as(String email) throws Throwable {
        WaitForElement.waitUntilElementIsClickable(recoveryEmail);
        recoveryEmail.sendKeys(email);
    }

    public void she_click_send_button() throws Throwable {
        WaitForElement.waitUntilElementIsClickable(sendButton);
        sendButton.click();
    }

    public boolean she_can_see_login_page() throws Throwable {
        WaitForElement.waitUntilElementIsClickable(loginButton);
        return loginButton.isDisplayed();
    }

    public boolean she_can_see_error_popup() throws Throwable {
        WaitForElement.waitUntilElementIsClickable(errorPopup);
        return errorPopup.isDisplayed();
    }
}