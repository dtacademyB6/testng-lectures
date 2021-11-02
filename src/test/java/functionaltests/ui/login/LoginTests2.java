package functionaltests.ui.login;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTests2  extends  TestBase{





    @Test (priority = 0, enabled = false)
    public void testLoginUsingValidCredentials1(){

        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester", Keys.TAB, "test", Keys.ENTER);
        Assert.assertTrue(driver.getTitle().equals("Web Orders"));

    }

    @Test (priority = 2, groups = "smoke_test")
    public void testLoginUsingValidCredentials2(){

        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester", Keys.TAB, "test", Keys.ENTER);
        Assert.assertTrue(driver.getTitle().equals("Web Orders"));

    }

    @Test (priority = 2, groups = {"smoke_test"})
    public void testLoginUsingInValidCredentials3(){

        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("TEst", Keys.TAB, "Blsld", Keys.ENTER);
        Assert.assertTrue(driver.getTitle().equals("Web Orders Logins"));

    }

    @Test (groups = "login")
    public void testLoginUsingInValidCredentials4(){

        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("TEst", Keys.TAB, "Blsld", Keys.ENTER);
        Assert.assertTrue(driver.getTitle().equals("Web Orders Logins"));

    }
}
