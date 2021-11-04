package functionaltests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestITestResult extends TestBase{

    @Test
    public void testLoginUsingValidCredentials1(){

        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester", Keys.TAB, "testdsf", Keys.ENTER);
        Assert.assertTrue(driver.getTitle().equals("Web Orders"));

    }

}
