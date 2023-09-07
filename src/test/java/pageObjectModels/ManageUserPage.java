package pageObjectModels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ManageUserPage extends BasePage {

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement buttonSearch;

    @FindBy(xpath = "//label[normalize-space()='Username']/following::input")
    private WebElement inputUsername;

    public void enterUserName(String username) {
        inputUsername.sendKeys(username);
    }

    public void clickSearchBtn() {
        buttonSearch.click();
        waitUntilVisible(By.xpath("//span[normalize-space()='(1) Record Found']"));
    }

    public String getUsernameFromRecord() {
        return getDriver().findElement(By.xpath("//div[@class='oxd-table-card']/descendant::div[@role='cell'][2]/div")).getText();
    }

}
