package pageObjectModels;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement buttonLogin;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement inputPassword;

    @FindBy(xpath = "//input[@name='username']")
    private WebElement inputUsername;

    public void enterUserName(String username) {
        inputUsername.sendKeys(username);
    }

    public void enterPassword(String password) {
        inputPassword.sendKeys(password);
    }

    public void clickLoginBtn() {
        buttonLogin.click();
    }

}