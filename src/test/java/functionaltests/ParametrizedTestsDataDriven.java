package functionaltests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;

public class ParametrizedTestsDataDriven {




    @Test (dataProvider = "getData")
    public void dataProviderDemo1(String searchTerm){
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys(searchTerm, Keys.ENTER);

        Assert.assertTrue(driver.getTitle().contains(searchTerm));

        driver.quit();
    }

    @DataProvider
    public Object[][] getData(){

        return new Object[][] {
                {"squid games"},
                {"nmcdbsdsvdcsvsdh"},
                {")'''I&*^%$#@*&("},
                {"1001010010101010010101 lnbvcdse1rftghyxgct7ey8y898ew90e8w_ op"},
                {"n¾uvWö]e[%êëhâ\\ì op y d'Ð 7yz q ‹ 3 /01åæÁGGur%n~P~"},
                {"直 美"},
                {"\uD83D"}


        };
    }


    @Test (dataProvider = "getData2")
    public void dataProviderDemo2(int quantity, String name, String address, String city, String state, int zipCode, long cardNumber){
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester", Keys.TAB, "test", Keys.ENTER);
        driver.findElement(By.linkText("Order")).click();

        driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtQuantity")).clear();
        driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtQuantity")).sendKeys("" + quantity);
        driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtName")).sendKeys(name);
        driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox2")).sendKeys(address);
        driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox3")).sendKeys(city);
        driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox4")).sendKeys(state);
        driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox5")).sendKeys("" + zipCode);

        driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0")).click();

        driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys(Long.toString(cardNumber));

        driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox1")).sendKeys("09/29");
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton")).click();

        Assert.assertTrue(driver.getPageSource().contains("New order has been successfully added"));

        driver.quit();
    }


    @DataProvider
    public Object[][] getData2(){

        return new Object[][] {
                {23, "Joe Biden", "1600 Pennsylvania Ave", "Washington" , "DC" , 20000, 632564625642357L },
                {11, "Barack Obama", "2131 Massachusetts Ave", "Washington" , "DC" , 20000, 732742324L },
                {0, "日本国内閣総理大臣", "太政大臣", "大臣" , "閣総" , 467, 163426372467634263L },
                {256356, "Владимир Путин", "пр-т Академика Сахарова", "Washington" , "DC" , 20000, 632564625642357L },
                {23, "Joe Biden", "1600 Pennsylvania Ave", "Москва" , "Москва" , 2365643, 7342646784236425233L },



        };
    }


    @Test (dataProvider = "getData3")
    public void dataProviderDemo3(String quantity, String name, String address, String city, String state, String zipCode, String cardNumber){
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester", Keys.TAB, "test", Keys.ENTER);
        driver.findElement(By.linkText("Order")).click();

        driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtQuantity")).clear();
        driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtQuantity")).sendKeys("" + quantity);
        driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtName")).sendKeys(name);
        driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox2")).sendKeys(address);
        driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox3")).sendKeys(city);
        driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox4")).sendKeys(state);
        driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox5")).sendKeys("" + zipCode);

        driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0")).click();

        driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys(cardNumber);

        driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox1")).sendKeys("09/29");
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton")).click();

        Assert.assertTrue(driver.getPageSource().contains("New order has been successfully added"));

        driver.quit();
    }


    @DataProvider
    public Object[][] getData3(){

        return CSVReader.readFromCSV("data.csv");
    }



    @Test (dataProvider = "getData4")
    public void googleSearch(String searchTerm){
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys(searchTerm, Keys.ENTER);

        Assert.assertTrue(driver.getTitle().contains(searchTerm));

        driver.quit();
    }


    @DataProvider
    public Object[][] getData4(){

        return CSVReader.readFromCSV("problemStrings.csv");
    }



}
