package stepDefinitions;

import contexts.ScenarioContext;
import io.cucumber.java.en.*;
import org.junit.Assert;
import pageObjects.RegisterPage;

public class RegisterPageSteps {
    private final ScenarioContext context;

    public RegisterPageSteps(ScenarioContext context) {
        this.context = context;
    }

    @And("User enters {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string} in the register form")
    public void user_enters_personal_details(String firstName, String lastName,
                                             String address, String city,
                                             String state, String zipCode,
                                             String phone, String ssn) {
        context.registerPage = new RegisterPage();
        context.registerPage.enterPersonalDetails(
                firstName, lastName, address, city, state, zipCode, phone, ssn
        );
    }

    @And("User enters {string}, {string}, {string} in the form")
    public void user_enters_credentials(String username, String password, String confirmPassword) {
        context.registerPage.enterCredentials(username, password, confirmPassword);
    }

    @And("User clicks on Register button")
    public void user_clicks_on_register_button() {
        context.registerPage.clickRegisterButton();
    }

    @Then("User verifies the greet message on the page")
    public void user_verifies_the_greet_message() {
        String greetMessage = context.registerPage.getGreetMessage();
        System.out.println("Greet Message: " + greetMessage);
        Assert.assertFalse(
                "Greet message should not be empty after registration",
                greetMessage.isEmpty()
        );
    }

    @And("User verifies the {string} on the page")
    public void user_verifies_success_message(String expectedMessage) {
        String actualMessage = context.registerPage.getSuccessMessage();
        System.out.println("Success Message: " + actualMessage);
        Assert.assertTrue(
                "Expected message to contain: [" + expectedMessage + "] | Actual: [" + actualMessage + "]",
                actualMessage.contains(expectedMessage)
        );
    }
}
