package unittests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UnitTests {





   @Test
    public void testAdd(){
         Calculator calculator = new Calculator();
         int result = calculator.add(3,5);
        Assert.assertEquals(result, 8);

    }



}
