package functionaltests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTests2  extends  TestBase{





    @Test (priority = 0, enabled = false)
    public void testLoginUsingValidCredentials1(){

        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester", Keys.TAB, "test", Keys.ENTER);
        Assert.assertTrue(driver.getTitle().equals("Web Orders"));

    }

    @Test (priority = 2)
    public void testLoginUsingValidCredentials2(){

        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester", Keys.TAB, "test", Keys.ENTER);
        Assert.assertTrue(driver.getTitle().equals("Web Orders"));

    }

    @Test (priority = 2)
    public void testLoginUsingInValidCredentials3(){

        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("TEst", Keys.TAB, "Blsld", Keys.ENTER);
        Assert.assertTrue(driver.getTitle().equals("Web Orders Logins"));

    }

    @Test
    public void testLoginUsingInValidCredentials4(){

        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("TEst", Keys.TAB, "Blsld", Keys.ENTER);
        Assert.assertTrue(driver.getTitle().equals("Web Orders Logins"));

    }
}
