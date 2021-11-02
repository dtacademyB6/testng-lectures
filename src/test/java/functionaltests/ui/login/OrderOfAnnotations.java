package functionaltests.ui.login;

import org.testng.annotations.*;

public class OrderOfAnnotations {


    @BeforeSuite
    public void beforeSuite(){
        System.out.println("beforeSuite");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("afterSuite");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("beforeTest");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("afterTest");
    }



    @BeforeClass
    public void beforeClass(){
        System.out.println("beforeClass");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("afterClass");
    }



    @BeforeMethod
    public void beforeMethod(){
        System.out.println("beforeMethod");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("afterMethod");
    }


    @Test
    public void method1(){
        System.out.println("method1");
    }

    @Test
    public void method2(){
        System.out.println("method2");
    }

}
