package data;

import org.testng.annotations.DataProvider;

public class TestDataProvider {
    @DataProvider(name="oddNumbersData")
    public Object[][] oddNumbers() {
        return new Object[][] {
                {1, 3, 5},
                {2, 4, 6}
        };
    }
}
