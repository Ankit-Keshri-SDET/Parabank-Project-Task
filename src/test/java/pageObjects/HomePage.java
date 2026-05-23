package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(name = "username")
    private WebElement usernameField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(css = "input[value='Log In']")
    private WebElement loginButton;

    @FindBy(linkText = "Register")
    private WebElement registerLink;

    @FindBy(linkText = "Log Out")
    private WebElement logoutLink;

    @FindBy(css = "p.error")
    private WebElement errorMessage;


    public void enterLoginCredentials(String username, String password) {
        type(usernameField, username);
        type(passwordField, password);
    }

    public void clickLoginButton() {
        click(loginButton);
    }

    public void clickRegisterLink() {
        click(registerLink);
    }

    public void clickLogoutLink() {
        click(logoutLink);
    }

    public boolean isLogoutLinkDisplayed() {
        return isDisplayed(logoutLink);
    }

    public String getErrorMessage() {
        return getText(errorMessage);
    }

    public boolean isRegisterLinkDisplayed() {
        return isDisplayed(registerLink);
    }
}
