package stepDefinition;
import constants.URL;
import drivers.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjectModels.LoginPage;

public class LoginSteps {

    private final LoginPage loginPage;
    private final WebDriver driver;

    public LoginSteps() {
        loginPage = new LoginPage();
        driver = DriverFactory.getDriver();
    }

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        driver.navigate().to(URL.LOGIN.toString());
    }

    @When("I enter the valid credential")
    public void i_enter_the_valid_credential() {
        loginPage.enterUserName("Admin");
        loginPage.enterPassword("admin123");
    }

    @And("click the login button")
    public void click_the_login_button() {
        loginPage.clickLoginBtn();
    }

    @Then("I should be directed to the dashboard page")
    public void i_should_be_directed_to_the_dashboard_page() {
        Assert.assertEquals(driver.getCurrentUrl(), URL.DASHBOARD.toString());
    }
}
