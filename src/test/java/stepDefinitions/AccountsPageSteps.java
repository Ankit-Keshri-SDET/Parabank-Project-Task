package stepDefinitions;

import contexts.ScenarioContext;
import io.cucumber.java.en.*;
import org.junit.Assert;
import pageObjects.AccountsPage;

public class AccountsPageSteps {

    private final ScenarioContext context;

    public AccountsPageSteps(ScenarioContext context) {
        this.context = context;
    }

    @Then("User verifies Dashboard page is displayed")
    public void user_verifies_dashboard_page_is_displayed() {
        context.accountPage = new AccountsPage();
        Assert.assertTrue(
                "Dashboard page should be displayed after successful login",
                context.accountPage.isDashboardDisplayed()
        );
        System.out.println("Dashboard Title: " + context.accountPage.getDashboardTitle());
    }

    @And("User verifies the balance and available amount on the page")
    public void user_verifies_balance_and_available_amount() {
        Assert.assertTrue(
                "Balance and Available Amount should both be visible on the Dashboard",
                context.accountPage.isBalanceAndAvailableAmountDisplayed()
        );
        System.out.println("Balance: " + context.accountPage.getBalanceAmount());
        System.out.println("Available: " + context.accountPage.getAvailableAmount());
    }

    @And("User verifies total amount on the page")
    public void user_verifies_total_amount() {
        Assert.assertTrue(
                "Total Amount should be visible in the accounts overview table",
                context.accountPage.isTotalAmountDisplayed()
        );
        System.out.println("Total: " + context.accountPage.getTotalAmount());
    }
}
