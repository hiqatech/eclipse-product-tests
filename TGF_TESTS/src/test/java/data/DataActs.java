package data;

import static setup.Hooks.AssertExecutedStep;

public class DataActs extends DataHelp {

	public static void readTestData(String feature, String testId) {
		if(testId.contains("TC0")) {
			testId = testId.replace("TC0","");
		} else if(testId.contains("TC")) {
				testId = testId.replace("TC","");
			}
		AssertExecutedStep(readTestData(feature,System.getProperty("runEnvironment"),testId) + " : " + "I read the " + feature + " test " + testId + " data \n");
    }

}
