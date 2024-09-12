package cucumber;

import io.cucumber.java.en.Given;
import selenium.WebActs;
import setup.AllProducts;

public class WebSteps extends WebActs {

    @Given("I start the {string} driver")
    public static void IStartTheWebDriver(String driver) {
        startWebDriver(driver);
    }

    @Given("I stop the webdriver")
    public static void IStopTheWebDriver() {
        stopWebDriver();
    }

    @Given("I navigate to the {string} url")
    public static void INavigateToTheUrl(String url) {
    }

    @Given("I navigate to the Home page")
    public static void INavigateToTheHomePage(){ 
    	startWebDriver("default");
        navigateToHomePage("app_home");
        onThePage("Home");
    }

    @Given("I navigate to the {string} element link")
    public static void INavigateToTheElementLink(String elementName) {
        navigateToTheElementLink(elementName);
    }

    @Given("I am on the {string} page")
    public static void IAmOnThePage(String pageName) {
        onThePage(pageName);
    }

    @Given("I switch to the {string}")
    public static void ISwitchToTheWindow(int windowNumber) {
        switchToTheWindow(windowNumber);
    }

    @Given("I switch to the {string} content")
    public static void ISwitchToTheContent(String frameName) {
        switchToContent(frameName);
    }

    @Given("I {string} the {string}")
    public static void IActTheElement(String act, String elementName) {
    	actTheElement(act, elementName);
    }

    @Given("I click the {string}")
    public static void IActTheBrowser(String act) {
        browserAction(act);
    }

    @Given("I send enter keys to the popup window")
    public static void ISendEnterToWindow() {
        sendEnterToWindow();
    }

    @Given("The {string} element status should be {string}")
    public static void TheElementStatusShouldBe(String elementName, String status) {
    	elementStatusShouldBe(elementName, status);
    }

    @Given("I should find the {string} in the downloads")
    public static void ICheckDownloads(String expectedFileName) {
        checkDownloads(expectedFileName);
    }

    @Given("I click the {string} {string} from the {string} options of the {string}")
    public static void IClickFromDropDownBy(String text, String attribute, String optionName, String elementName) {
    	clickFromDropDownBy(text, attribute, elementName, optionName, AllProducts.getElementSelector(optionName));
    }

    @Given("I upload the {string} to the {string}")
    public static void IUploadTheFile(String fileName, String elementName) {
        uploadFile(fileName, elementName);
    }

    @Given("I upload the {string} to the {string} with keys")
    public static void IUploadTheFileWithKeys(String fileName, String elementName) {
        uploadFileWithKey(fileName, elementName);
    }

    @Given("I rename the {string} file to the {string}")
    public static void IRenameFileTo(String fileName, String textX) {
        renameFile(fileName, textX);
    }

    @Given("I delete the {string} from the {string}")
    public static void IDeleteFileFromThe(String fileName, String pathExp) {
        deleteFile(fileName, pathExp);
    }

    @Given("I select the {string} {string} from the {string}")
    public static void ISelectTheElementBy(String text, String attribute, String dropDownName) {
    	selectFromTheDropDownBy(text, attribute, dropDownName);
    }

    @Given("I click the {string} {string} from the {string}")
    public static void IClickTheElementBy(String text, String attribute, String selection, String dropDownName) {
    	clickFromDropDownBy(text, attribute, dropDownName, selection, AllProducts.getElementSelector(selection));
    }

    @Given("I select the {string} date in the {string} datepicker")
    public static void ISelectTheDateInTheDatePicker(String date, String datePickerName) {
        selectDateInDatePicker(date, datePickerName, AllProducts.getElementSelector("day_selector"), AllProducts.getElementSelector("done_button"));
    }

    @Given("I {string} {string} into the {string}")
    public static void IIntoTheElement(String act, String entry, String elementName) {
        intoTheElement(act, entry, elementName);
    }

    @Given("I should see the {string}")
    public static void IShouldSeeTheElement(String elementName) {
        shouldSeeTheElement(elementName);
    }

    @Given("I should not see the {string}")
    public static void IShouldNotSeeTheElement(String elementName) {
        shouldNotSeeTheElement(elementName);
    }

    @Given("The {string} element {string} should {string} {string}")
    public static void TheElementTextShouldBe(String elementName, String attribute, String condition, String entry) {
        elementTextShouldBe(elementName, attribute, condition, entry);
    }

    @Given("The {string} element {string} should not {string} {string}")
    public static void TheElementTextShouldNotBe(String elementName, String attribute, String condition, String entry) {
        elementTextShouldNotBe(elementName, attribute, condition, entry);
    }

    @Given("I take a screenshot as {string}")
    public static void ITakeScreenShot(String fileName) {
        takeAScreenShot(System.getProperty("reportPath") + "/" + fileName);
    }

    @Given("I wait {string} secs for the {string}")
    public static void IWaitSomeSec(String wait, String waitFor) {
        waitSomeSecs(wait, waitFor);
    }

    @Given("I hit {string} on the keyboard")
    public static void IHitOnTheKeyBoard(String key) {
        hitOnTheKeyBoard(key);
    }

    @Given("I store the {string} element text as {string}")
    public static void IStoreTheElementTextAsTheTextX(String elementName, String attribute, String textX) {
        storeElementTextAsTextX(elementName, attribute, textX);
    }

    public static void IStoreTheTextAsTheTextX(String text, String textX) {
        storeTextAsTextX(text, textX);
    }
    
    
  
    
    
}
