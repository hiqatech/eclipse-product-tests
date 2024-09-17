package cucumber;

import static setup.Hooks.AssertExecutedStep;

import data.UtilHelp;
import data.FileHelp;
import io.cucumber.java.en.Given;

public class UtilSteps{

	 @Given("I read the {string} test {string} data")
	    public static void IReadTheTestData(String feature, String testId) {
		 if(testId.contains("TC0")) {
				testId = testId.replace("TC0","");
			} else if(testId.contains("TC")) {
					testId = testId.replace("TC","");
				}
			AssertExecutedStep(UtilHelp.readTestData(feature,System.getProperty("runEnvironment"),testId) + " : " + "I read the " + feature + " test " + testId + " data \n");
	    }

}
