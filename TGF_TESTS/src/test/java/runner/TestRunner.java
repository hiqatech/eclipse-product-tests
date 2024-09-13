package runner;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
        (features = {"src/test/resources/features/FundingRequest"},
                glue = {"cucumber","setup"},
        		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
                }
        )

public class TestRunner {

    @AfterClass
    public static void report()
    {
    }

}
