import drivers.DriverFactory;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;


@CucumberOptions (
        features = "src/test/resources",
        glue = "stepDefinition"
)
public class TestRunner extends AbstractTestNGCucumberTests {

    @BeforeTest
    @Parameters("browser")
    public void setup(String browser) {
        // Initialize the WebDriver based on the browser type from testng.xml
        DriverFactory.getDriver(browser);
    }

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    @AfterTest
    public void quit() {
        DriverFactory.teardown();
    }
}
