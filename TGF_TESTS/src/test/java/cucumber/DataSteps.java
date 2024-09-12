package cucumber;

import data.DataActs;
import io.cucumber.java.en.Given;

public class DataSteps extends DataActs{
	
	 @Given("I read the {string} test {string} data")
	    public static void IReadTheTestData(String featureName, String testId) {
		 	readTestData(featureName, testId);	    }

}
