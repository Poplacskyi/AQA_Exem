package others;

import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Lab2Tests {
    @Test
    @Parameters({"a", "b", "expectedOddCount"})
    public void testCountOddWithParams(@Optional("1") int a,
                                       @Optional("2") int b,
                                       @Optional("1") int expectedOddCount) {
        int count = 0;
        if (a % 2 != 0) count++;
        if (b % 2 != 0) count++;
        Assert.assertEquals(count, expectedOddCount, "Odd count does not match");
    }
}
