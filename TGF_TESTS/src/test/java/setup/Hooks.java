package setup;


import data.DataHelp;
import cucumber.WebSteps;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.junit.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    public static boolean wantsToQuit = false;
    public static Scenario scenario;
    public static String myScenario;
    public static String stepLog;

    //------------------------------------------------------------------------//

    @Before
    public void setup(Scenario scenario) throws Exception
    {
    	killAllChromeDriver();

        Hooks.scenario = scenario;

        LocalDateTime dateTime = LocalDateTime.now();

        myScenario = scenario.getName();
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        System.setProperty("scenario",myScenario);
        System.setProperty("product",myScenario.substring(0,myScenario.indexOf("-")).replace(" ",""));

        // local use, comment before push
        System.setProperty("runDriver","Chrome");
        System.setProperty("runEnvironment","UAT");
        //
        System.setProperty("mainURL", AllURLs.getProductURL());

        System.setProperty("projectPath",System.getProperty("user.dir"));
        System.setProperty("systemTime", dateTime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
        System.setProperty("userID",System.getProperty("user.home").replace("C:\\Users\\",""));
        System.setProperty("downloadPath",System.getProperty("user.home")+"\\Downloads\\");
        System.setProperty("uploadPath",System.getProperty("user.home")+"\\Desktop\\");
        System.setProperty("reportPath",System.getProperty("projectPath")+"\\target\\cucumber-reports\\");
        System.setProperty("filePath",System.getProperty("projectPath") + "\\src\\main\\resources\\files\\");
        System.setProperty("driverPath",System.getProperty("projectPath") + "\\src\\main\\resources\\webdrivers\\");
        System.setProperty("reportConfigPath",System.getProperty("projectPath") + "\\src\\main\\resources\\report\\extent-config.xml");

        if(wantsToQuit) {
			throw new RuntimeException("Test FAIL : Cucumber wants to quit");
		}

        System.out.println("************************************************************************************");

        System.out.println("SystemTime : " + System.getProperty("systemTime"));
        System.out.println("Product Tests Starts");
        System.out.println("Scenario : " + myScenario);
        System.out.println("ProjectPath : " + System.getProperty("projectPath"));
        System.out.println("ReportPath : " + System.getProperty("reportPath"));
        System.out.println("Environment : " + System.getProperty("runEnvironment"));

        System.out.println("************************************************************************************");

    }

    @After
    public static void tearDown(Scenario scenario)
    {
        if(scenario.isFailed())
        {
            WebSteps.ITakeScreenShot(System.getProperty("reportPath") + myScenario + " failed_" + DataHelp.getTimeStamp("YYYY-MM-DD-HH-mm-ss-SSS"));
            System.out.println("Test Failed !");
        } else {
			System.out.println("Test Passed !");
		}
        WebSteps.IStopTheWebDriver();
        System.out.println("************************************************************************************");
    }

    //-----------------------------------------------------------------------------//


    public static void AssertExecutedStep(String result)
    {
        stepLog = result;
        if (!result.toUpperCase().contains("PASS")) {
            Hooks.scenario.log(getResultFailLog(result));
            WebSteps.ITakeScreenShot("TestFailScreenshot");
            System.out.println(result);
            Assert.assertTrue(false);
        }
        else {
            Hooks.scenario.log(result.replace(",,,",""));
            System.out.println(result);
        }
    }

    public static void VerifyExecutedStep(String result)
    {
        stepLog = result;
        if (!result.toUpperCase().contains("PASS")){
            Hooks.scenario.log(getResultFailLog(result));
            //System.out.println(result);
        }
    }

    public static String getResultFailLog(String result){
        String extString = Arrays.asList(result.split(" ,,, " )).get(0);
        String desc = Arrays.asList(result.split(" ,,, " )).get(1);
        result = "FAIL " + desc + " caused by : " + extString;
        return result;
    }

    public static void killAllChromeDriver() throws IOException {
    	if(System.getProperty("os.name").contains("Windows")) {
            Process process = Runtime. getRuntime(). exec("taskkill /F /IM chromedriver.exe /T");
            process.destroy();
    	}
    }

}
