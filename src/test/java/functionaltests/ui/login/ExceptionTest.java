package functionaltests.ui.login;

import org.openqa.selenium.StaleElementReferenceException;
import org.testng.annotations.Test;

import java.util.NoSuchElementException;

public class ExceptionTest {


    @Test (expectedExceptions = {NoSuchElementException.class})
    public void test1(){

        // some test logic
        System.out.println("Some test logic");

//        throw new NoSuchElementException();
    }
}
