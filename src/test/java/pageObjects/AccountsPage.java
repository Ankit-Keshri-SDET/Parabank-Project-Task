package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountsPage extends BasePage {

    @FindBy(css = "div#rightPanel h1.title")
    private WebElement dashboardTitle;

    @FindBy(css = "table#accountTable tbody tr:first-child td:nth-child(2)")
    private WebElement balanceAmount;

    @FindBy(css = "table#accountTable tbody tr:first-child td:nth-child(3)")
    private WebElement availableAmount;

    @FindBy(xpath = "//*[@id=\"accountTable\"]/tbody/tr[2]/td[2]/b")
    private WebElement totalAmount;

    @FindBy(linkText = "Log Out")
    private WebElement logoutLink;

    public boolean isDashboardDisplayed() {
        return isDisplayed(dashboardTitle);
    }

    public String getDashboardTitle() {
        return getText(dashboardTitle);
    }

    public String getBalanceAmount() {
        return getText(balanceAmount);
    }

    public String getAvailableAmount() {
        return getText(availableAmount);
    }

    public String getTotalAmount() {
        return getText(totalAmount);
    }

    public void clickLogoutLink() {
        click(logoutLink);
    }

    public boolean isBalanceAndAvailableAmountDisplayed() {
        return isDisplayed(balanceAmount) && isDisplayed(availableAmount);
    }

    public boolean isTotalAmountDisplayed() {
        return isDisplayed(totalAmount);
    }
}
