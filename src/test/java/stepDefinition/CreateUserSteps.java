package stepDefinition;
import constants.URL;
import drivers.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjectModels.CreateUserPage;
import pageObjectModels.ManageUserPage;

import java.time.LocalTime;

public class CreateUserSteps {

    private CreateUserPage createUserPage;
    private ManageUserPage manageUserPage;
    private WebDriver driver;
    private String username;

    public CreateUserSteps() {
        createUserPage = new CreateUserPage();
        driver = DriverFactory.getDriver();
    }


    @Given("I am on the create user page")
    public void i_am_on_the_create_user_page() {
        driver.navigate().to(URL.CREATE_USER.toString());
    }

    @When("I select user role {string}")
    public void i_select_user_role_as_admin(String admin) {
        createUserPage.selectUserRole(admin);
    }

    @And("I enter employee name")
    public void i_enter_employee_name() {
        createUserPage.selectEmployee();
    }

    @And("I select status {string}")
    public void i_select_status(String status) {
        createUserPage.selectStatus(status);
    }

    @And("I enter username")
    public void i_enter_username() {
        username = createUserPage.getEmployeeName() + LocalTime.now();
        createUserPage.enterUsername(username);
    }

    @And("I enter password {string}")
    public void i_enter_password(String password) {
        createUserPage.enterPassword(password);
    }

    @And("I enter confirm password {string}")
    public void i_enter_confirm_password(String password) {
        createUserPage.enterConfirmPassword(password);
    }

    @And("click the save button")
    public void click_the_save_button() {
        createUserPage.clickSaveBtn();
    }

    @Then("I should be directed to the admin page")
    public void i_should_be_directed_to_the_admin_page() {
        Assert.assertEquals(driver.getCurrentUrl(), URL.MANAGER_USER.toString());
    }

    @When("I enter the username")
    public void i_enter_the_username() {
        manageUserPage = new ManageUserPage();
        manageUserPage.enterUserName(username);
    }

    @And("I click the search button")
    public void i_click_the_search_button() {
        manageUserPage.clickSearchBtn();
    }

    @Then("I should find the same user")
    public void i_should_find_the_same_user() {
        Assert.assertEquals(username, manageUserPage.getUsernameFromRecord());
    }
}
