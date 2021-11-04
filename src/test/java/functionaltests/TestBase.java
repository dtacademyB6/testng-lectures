package functionaltests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
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
    public void tearDownMethod(ITestResult testResult) throws IOException {
        // add the takeScreenshot logic if test fails here
        if(testResult.getStatus() == ITestResult.FAILURE){
            TakesScreenshot ts = (TakesScreenshot) driver;
            File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotAs, new File("screenshots/failed" +System.currentTimeMillis() +".png"));
        }

        driver.quit();
    }




}
