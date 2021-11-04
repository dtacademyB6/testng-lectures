package functionaltests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class ParametrizedTests {


    @Test
    @Parameters ({"homepage"})
    public void parametrizedTestDemo(String url){
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester", Keys.TAB, "test", Keys.ENTER);

        Assert.assertTrue(driver.getTitle().equals("Web Orders"));

        driver.quit();
    }

    @Test
    @Parameters ({"googleHome"})
    public void parametrizedTestDemo2(String url){
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);
        driver.findElement(By.name("q")).sendKeys("squid games", Keys.ENTER);

        Assert.assertTrue(driver.getTitle().contains("squid games"));

        driver.quit();
    }


    @Test
    @Parameters ({"homepage", "usr", "pass"})
    public void parametrizedTestDemo3(String url, String username,String password){
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys(username, Keys.TAB, password, Keys.ENTER);

        Assert.assertTrue(driver.getTitle().equals("Web Orders"));

        driver.quit();
    }

    @Test
    @Parameters ({"param1", "param2", "param3"})
    public void parametrizedTestDemo4(Integer par1, boolean par2 , double par3){

        System.out.println(par1);
        System.out.println(par2);
        System.out.println(par3);
    }
}
