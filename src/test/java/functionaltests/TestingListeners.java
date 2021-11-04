package functionaltests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.time.Duration;

@Listeners (CustomTestListener.class)
public class TestingListeners {


    @Test
    public void test1(){
        Assert.assertEquals(true, true);
    }
    @Test
    public void test4(){
        Assert.assertEquals(true, true);
    }

    @Test
    public void test2(){
           Assert.assertTrue(false);
    }

    @Test
    public void test5(){
        Assert.assertTrue(false);
    }

    @Test
    public void test3(){
         throw new SkipException("skipped");
    }


    @Test
    public void login(){
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester", Keys.TAB, "testfds", Keys.ENTER);

        Assert.assertTrue(driver.getTitle().equals("Web Orders"));

        driver.quit();
    }
}
