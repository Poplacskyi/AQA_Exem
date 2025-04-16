package ui_test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleDataTest {

    @Test(dataProvider = "sampleData", dataProviderClass = TestDataProviders.class)
    public void testWithData(String text, int number) {
        System.out.println("Текст: " + text + ", число: " + number);
        Assert.assertNotNull(text);
        Assert.assertTrue(number > 0);
    }
}
