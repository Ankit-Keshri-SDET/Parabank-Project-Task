package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage{

    @FindBy(id = "customer.firstName")
    private WebElement firstNameField;

    @FindBy(id = "customer.lastName")
    private WebElement lastNameField;

    @FindBy(id = "customer.address.street")
    private WebElement addressField;

    @FindBy(id = "customer.address.city")
    private WebElement cityField;

    @FindBy(id = "customer.address.state")
    private WebElement stateField;

    @FindBy(id = "customer.address.zipCode")
    private WebElement zipCodeField;

    @FindBy(id = "customer.phoneNumber")
    private WebElement phoneField;

    @FindBy(id = "customer.ssn")
    private WebElement ssnField;

    @FindBy(id = "customer.username")
    private WebElement usernameField;

    @FindBy(id = "customer.password")
    private WebElement passwordField;

    @FindBy(id = "repeatedPassword")
    private WebElement confirmPasswordField;

    @FindBy(css = "input[value='Register']")
    private WebElement registerButton;

    @FindBy(css = "h1.title")
    private WebElement pageHeading;

    @FindBy(id = "rightPanel")
    private WebElement successPanel;

    public void enterPersonalDetails(String firstName, String lastName,
                                     String address, String city,
                                     String state, String zipCode,
                                     String phone, String ssn) {
        type(firstNameField, firstName);
        type(lastNameField, lastName);
        type(addressField, address);
        type(cityField, city);
        type(stateField, state);
        type(zipCodeField, zipCode);
        type(phoneField, phone);
        type(ssnField, ssn);
    }

    public void enterCredentials(String username, String password, String confirmPassword) {
        type(usernameField, username);
        type(passwordField, password);
        type(confirmPasswordField, confirmPassword);
    }

    public void clickRegisterButton() {
        click(registerButton);
    }

    public String getGreetMessage() {
        return getText(pageHeading);
    }

    public String getSuccessMessage() {
        return getText(successPanel);
    }
}
