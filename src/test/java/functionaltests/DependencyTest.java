package functionaltests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class DependencyTest {

    WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }


    @Test(groups = {"smoke_test", "login"})
    public void login(){
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester", Keys.TAB, "test", Keys.ENTER);
        Assert.assertTrue(driver.getTitle().equals("Web Orders"));
    }



    @Test (dependsOnMethods = {"login"}, groups = "smoke_test")
    public void verifyCheckAll(){
        driver.findElement(By.id("ctl00_MainContent_btnCheckAll")).click();

        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));

        for (WebElement checkbox : checkboxes) {
            Assert.assertTrue(checkbox.isSelected());
        }

        throw new AssertionError();
    }



    @Test (dependsOnMethods = {"verifyCheckAll", "login"})
    public void deleteAllMessage(){
        driver.findElement(By.id("ctl00_MainContent_btnDelete")).click();
        Assert.assertTrue(driver.getPageSource().contains("List of orders is empty. In order to add new order use"));
    }
}
