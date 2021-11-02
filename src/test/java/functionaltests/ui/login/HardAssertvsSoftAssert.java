package functionaltests.ui.login;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class HardAssertvsSoftAssert {


    @Test
    public void hardAssertDemo(){
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester", Keys.TAB, "test", Keys.ENTER);
        Assert.assertTrue(driver.getTitle().equals("Web Orderblabla"));
        Assert.assertTrue(driver.getCurrentUrl().equals("http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/"));
        Assert.assertTrue(driver.getPageSource().contains("Welcome, Tester!"));
        Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());

        driver.quit();
    }


    @Test
    public void softAssertDemo(){
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester", Keys.TAB, "test", Keys.ENTER);

        SoftAssert softAssert = new SoftAssert();

//        softAssert.assertTrue(driver.getTitle().equals("Web Orderblabla"), "Title didn't match");  // soft assert
        softAssert.assertEquals(driver.getTitle(),"Web Orderblabla");  // soft assert
//        Assert.assertTrue(driver.getTitle().equals("Web Orderblabla"));   // hard asssert


        softAssert.assertEquals(driver.getCurrentUrl(), "http://secure.smartbearsoftware.com/samples/blalvlskdcvsdh");
        softAssert.assertTrue(driver.getPageSource().contains("Welcome, Tester!"));
        softAssert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());

        driver.quit();

        softAssert.assertAll();  // we need to always call assertAll() to throw if there is any exceptions
    }
}
