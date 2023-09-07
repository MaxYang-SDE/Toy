package pageObjectModels;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateUserPage extends BasePage {

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement buttonSave;
    @FindBy(xpath = "//label[normalize-space()='User Role']/following::div[@class='oxd-select-text-input']")
    private WebElement userRoleDropdown;
    @FindBy(xpath = "//label[normalize-space()='Status']/following::div[@class='oxd-select-text-input']")
    private WebElement statusDropdown;
    @FindBy(xpath = "//p[@class='oxd-userdropdown-name']")
    private WebElement employeeName;
    @FindBy(xpath = "//label[normalize-space() = 'Employee Name']/following::input")
    private WebElement employmentDropdown;
    @FindBy(xpath = "//label[normalize-space() = 'Username']/following::input")
    private WebElement inputUsername;
    @FindBy(xpath = "//label[normalize-space() = 'Password']/following::input")
    private WebElement inputPassword;
    @FindBy(xpath = "//label[normalize-space() = 'Confirm Password']/following::input")
    private WebElement inputConfirmPassword;

    public void selectUserRole(String userRole) {
        userRoleDropdown.click();
        By locator = By.xpath("//div[@role='option']/span[normalize-space() = '" + userRole + "']");
        waitUntilClickable(locator);
        getDriver().findElement(locator).click();
    }
    public void selectEmployee() {
        employmentDropdown.sendKeys(employeeName.getText());
        By locator = By.xpath("//div[@role='option']/span");
        waitUntilVisible(locator);
        getDriver().findElement(locator).click();
    }
    public void selectStatus(String status) {
        statusDropdown.click();
        By locator = By.xpath("//div[@role='option']/span[normalize-space() = '" + status + "']");
        waitUntilClickable(locator);
        getDriver().findElement(locator).click();
    }
    public void enterUsername(String username) {
        inputUsername.sendKeys(username);
    }
    public void enterPassword(String password) {
        inputPassword.sendKeys(password);
    }
    public void enterConfirmPassword(String password) {
        inputConfirmPassword.sendKeys(password);
    }
    public void clickSaveBtn() {
        buttonSave.click();
        waitUntilVisible(By.xpath("//h6[normalize-space()='User Management']"));
    }
    public String getEmployeeName() {
        return employeeName.getText();
    }
}
