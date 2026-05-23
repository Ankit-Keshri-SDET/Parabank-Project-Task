package stepDefinitions;

import contexts.ScenarioContext;
import factory.DriverFactory;
import io.cucumber.java.en.*;
import org.junit.Assert;
import pageObjects.HomePage;

public class HomePageSteps {
    private final ScenarioContext context;

    public HomePageSteps(ScenarioContext context) {
        this.context = context;
    }

    @Given("Given User is on the home page")
    public void given_user_is_on_the_home_page() {
        context.homePage = new HomePage();
        System.out.println("User is on Parabank home page: " + DriverFactory.getDriver().getCurrentUrl());
    }

    @When("User enters {string}, {string} in the login input field")
    public void user_enters_login_credentials(String username, String password) {
        context.homePage.enterLoginCredentials(username, password);
    }

    @And("User clicks on Login button")
    public void user_clicks_on_login_button() {
        context.homePage.clickLoginButton();
    }

    @When("User clicks on Register link")
    public void user_clicks_on_register_link() {
        context.homePage.clickRegisterLink();
    }

    @When("User clicks on Logout link")
    public void user_clicks_on_logout_link() {
        context.homePage = new HomePage();
        context.homePage.clickLogoutLink();
    }

    @Then("User is on the home page")
    public void user_is_on_the_home_page() {
        context.homePage = new HomePage();
        Assert.assertTrue(
                "Register link should be visible — user should be logged out on home page",
                context.homePage.isRegisterLinkDisplayed()
        );
    }
}
