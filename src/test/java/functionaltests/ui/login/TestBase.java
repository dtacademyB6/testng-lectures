package functionaltests.ui.login;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class TestBase {


    protected WebDriver driver;


    @BeforeGroups (value = "smoke_test")
    public void setupSmokeTests(){
        // the setup that must be done once before tests that are part of "smoke" group start
        System.out.println("Before Smoke Tests");
    }

    @AfterGroups (value = "smoke_test")
    public void tearDownSmokeTests(){
        // the teardown that must be executed once after tests that are part of "smoke" group are finished
        System.out.println("After Smoke Tests");
    }

    @BeforeClass (alwaysRun = true)
    public void setupClass(){
        WebDriverManager.chromedriver().setup();


    }

    @BeforeMethod (alwaysRun = true)
    public void setupMethod(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
    }

    @AfterClass (alwaysRun = true)
    public void tearDownClass(){

    }

    @AfterMethod (alwaysRun = true)
    public void tearDownMethod(){
        driver.quit();
    }

}
