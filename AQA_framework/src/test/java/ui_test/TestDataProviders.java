package ui_test;

import org.testng.annotations.DataProvider;

public class TestDataProviders {

    @DataProvider(name = "sampleData")
    public Object[][] sampleDataProvider() {
        return new Object[][] {
                {"dataSet1", 123},
                {"dataSet2", 456},
                {"dataSet3", 789}
        };
    }
}
