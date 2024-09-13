package selenium;

import static setup.Hooks.AssertExecutedStep;
import static setup.Hooks.VerifyExecutedStep;

import data.DataHelp;
import data.FileHelp;
import setup.AllProducts;
import setup.AllURLs;

public class WebActs extends WebHelp {

    public static void startWebDriver(String driver) {

        if(driver.contains("default")) {
			driver = System.getProperty("runDriver");
		}
       AssertExecutedStep( startMyWebDriver(driver) + " ,,, : " + "I start the Webdriver with the " + driver + " browser");
    }

    public static void stopWebDriver() {
    	VerifyExecutedStep( stopMyWebDriver() + " ,,, : " + "I stop the Webdriver with " + System.getProperty("runDriver") + " the browser");
    }

    public static void navigateToHomePage(String pageName) {
        AssertExecutedStep( navigateTo(System.getProperty("mainURL")) + " ,,, : " + "I navigate to the " + System.getProperty("mainURL") + " URL");
    }

    public static void navigateToUrl(String url) {
        if(url.equalsIgnoreCase("app_home")) {
			url = AllURLs.getProductURL();
		}
        AssertExecutedStep( navigateTo(url) + " ,,, : " + "I navigate to the " + url + " URL");
    }

    public static void navigateToTheElementLink(String elementName) {
    	VerifyExecutedStep(waitForElementToAppear(elementName));
        AssertExecutedStep( navigateTo(readAttributeOfWebElement(AllProducts.getElementSelector(elementName), "HREF")) + " ,,, : " + "I navigate to the " + elementName + " link with selector " + AllProducts.getElementSelector(elementName));
    }

    public static void onThePage(String pageName) {
        System.setProperty("activePage", pageName);
        if(AllProducts.GOSFramePages.contains(pageName))
        	{ navigateTo(AllURLs.getModuleURL(pageName));waitSomeSecs("20","pageName");
        	AssertExecutedStep(navigateTo(AllURLs.getModuleURL(pageName))  + " ,,, : " + "I navigate to the " + pageName + " page");
        	waitSomeSecs("20","pageName"); switchToContent(pageName);}
        AssertExecutedStep( "PASS  : I am on the " + pageName + " page ");
    }

    public static void switchToTheWindow(int windowNumber) {
        AssertExecutedStep( switchToWindow(windowNumber) + " ,,, : " + "I switch to the " + windowNumber + " window");
    }

    public static void switchToContent(String frameName) {
        AssertExecutedStep( switchToFrame(AllProducts.getElementSelector(frameName)) + " ,,, : " + "I switch to the "  + frameName + " content");
    }

    public static String waitForElementToAppear(String elementName) {
        return waitToAppear(AllProducts.getElementSelector(elementName)) + " ,,, : Visibility of element " + elementName;
    }

    public static String waitForElementToDisappear(String elementName) {
        return waitToDisappear(AllProducts.getElementSelector(elementName)) + " ,,, : UnVisibility of element " + elementName;
    }

    public static String checkTheElementVisibility(String elementName) {
    	return checkElementVisibility(AllProducts.getElementSelector(elementName)) + " ,,, : UnVisibility of element " + elementName;
    }

    public static void actTheElement(String act, String elementName) {
    	VerifyExecutedStep(waitForElementToAppear(elementName));
        if (elementName.contains("alert")) {
			AssertExecutedStep( handleAlert(act) + " ,,, : I " + act + " the alert");
		} else if (elementName.contains("CheckBox")) {
			AssertExecutedStep( checkBox(act, AllProducts.getElementSelector(elementName)) + " ,,, : I " + act + " the " + elementName);
		} else {
			AssertExecutedStep( safeAct(act, AllProducts.getElementSelector(elementName)) + " ,,, : I " + act + " the " + elementName);
		}
        if(elementName.contains("Tab") || elementName.contains("Search") ) {
			waitSomeSecs("7",elementName);
		}
    }

    public static void browserAction(String act) {
        AssertExecutedStep( browserAct(act) + " ,,, : " + "I click the" + act);
    }

    public static void sendEnterToWindow() {
        AssertExecutedStep( sendEnterKey() + " ,,, : " + "I send enter key to the window");
    }

    public static void elementStatusShouldBe(String elementName, String status) {
    	VerifyExecutedStep(waitForElementToAppear(elementName));
        if (status.equalsIgnoreCase("SELECTED")) {
			AssertExecutedStep( isSelected(AllProducts.getElementSelector(elementName), status) + " ,,, : " + "The " + elementName + " status should be " + status);
		} else if (status.equalsIgnoreCase("CHECKED")) {
			AssertExecutedStep( isChecked(AllProducts.getElementSelector(elementName), status) + " ,,, : " + "The " + elementName + " status should be " + status);
		} else {
			AssertExecutedStep( " status is not a implemented to assert");
		}
    }

    public static void checkDownloads(String expectedFileName) {
        if (expectedFileName.contains("Text")) {
			expectedFileName = DataHelp.prepText(expectedFileName);
		}
        AssertExecutedStep( FileHelp.checkDownLoad(expectedFileName) + " ,,, : " + "I should find the " + expectedFileName + " file ind the " + System.getProperty("downloadPath") + " folder");
    }

    public static void uploadTheFile(String fileName, String elementName) {
    	VerifyExecutedStep(waitForElementToAppear(elementName));
        if (fileName.contains("Text")) {
			fileName = DataHelp.storedTexts.get(Integer.parseInt(fileName.replaceAll("\\D+", "")));
		}
        AssertExecutedStep( uploadFile(AllProducts.getElementSelector(elementName), fileName) + " ,,, : " + "I upload the " + fileName + " file to the " + elementName);
    }

    public static void uploadFileWithKey(String fileName, String elementName) {
    	VerifyExecutedStep(waitForElementToAppear(elementName));
        actTheElement("select", elementName);
        if (fileName.contains("Text")) {
			fileName = DataHelp.getStoredText(fileName);
		}
        AssertExecutedStep( uploadFileWithKey(fileName) + " ,,, : " + "I upload the " + fileName + " file to the " + elementName);
    }

    public static void renameFile(String fileName, String text) {
        String newName = DataHelp.getStoredText(text);
        AssertExecutedStep( FileHelp.renameFile(fileName, newName) + " ,,, : " + "I rename the " + fileName + " file to the " + newName);
    }

    public static void deleteFile(String fileName, String path) {
        if(path.contains("Downloads")) {
			path = System.getProperty("downloadPath");
		} else if(path.contains("Files")) {
			path = System.getProperty("filePath");
		}

        AssertExecutedStep( FileHelp.deleteFile(fileName, path) + " ,,, : " + "I delete the " + fileName);
    }

    public static void selectFromTheDropDownBy(String text, String attribute, String elementName) {
    	if(text.contains("$")) {
			text = DataHelp.getTestData(text.replace("$", ""));
		}
    	VerifyExecutedStep(waitForElementToAppear(elementName));
    	AssertExecutedStep( selectFromDropDownBy(AllProducts.getElementSelector(elementName), attribute, text) + " ,,, : " + "I select the " + text + " " + attribute + " from the " + elementName);
    }

    public static void clickFromDropDownBy(String text, String attribute, String optionName, String optionSelector, String elementName) {
    	VerifyExecutedStep(waitForElementToAppear(elementName));
    	AssertExecutedStep( clickFromDropDownBy(AllProducts.getElementSelector(elementName), optionSelector, text, attribute) + " ,,, : " + "I select the " + text + " from the " + elementName);
    }

    public static void selectDateInDatePicker(String date, String elementName, String daySelector, String doneButtonSelector) {
    	VerifyExecutedStep(waitForElementToAppear(elementName));
    	String result = safeAct("select", AllProducts.getElementSelector(elementName)) + " ,,, : " + "I select the " + elementName;

        String dateToSet = DataHelp.getDynamicDate(date, "yyyyMMdd");
        int nth = Integer.parseInt(dateToSet.substring(4, 6));
        daySelector = daySelector.replace("DD", String.valueOf(nth));
        result = result + selectNthElement(daySelector, String.valueOf(nth - 1)) + " ,,, : " + "I select the " + dateToSet + " with selector " + daySelector;
        AssertExecutedStep( result + safeAct("select", doneButtonSelector) + " ,,, : " + "I select the " + doneButtonSelector);
    }

    public static void intoTheElement(String act, String entry, String elementName) {
    	if(entry.contains("$")) {
			entry = DataHelp.getTestData(entry.replace("$", ""));
		}
    	if (entry.contains("CurrentDate")) {
			entry = DataHelp.getDynamicDate(entry, "yyyy-MM-dd");
		} else if (entry.contains("TimeStamp")) {
			entry = DataHelp.getTimeStamp("yyyy-MM-dd-hh-mm-ss");
		} else if (entry.contains("Text")) {
			entry = DataHelp.getStoredText(entry);
		} else if (elementName.contains("date")) {
            safeAct("select", AllProducts.getElementSelector(elementName));
            for (int i = 0; i < 10; i++) {
				keyActions("ArrowLeft");
			}
        }
        entry = entry.replace("-", "").replace("/", "");

        VerifyExecutedStep(waitForElementToAppear(elementName));
        AssertExecutedStep( safeInto(act, AllProducts.getElementSelector(elementName), entry) + " ,,, : " + "I " + act + " the " + entry + " into the " + elementName);
    }

    public static void shouldSeeTheElement(String elementName) {
        AssertExecutedStep( waitToAppear(AllProducts.getElementSelector(elementName)) + " ,,, : The " + elementName + " should be visible with selector " + AllProducts.getElementSelector(elementName));
    }

    public static void shouldNotSeeTheElement(String elementName) {
        AssertExecutedStep( waitToDisappear(AllProducts.getElementSelector(elementName)) + " ,,, : The " + elementName + " should not be visible with selector " + AllProducts.getElementSelector(elementName));
    }

    public static void elementTextShouldBe(String elementName, String attribute, String condition, String text) {
    	attribute = attribute.toUpperCase();
        if (text.contains("Text")) {
			DataHelp.getStoredText(text);
		}
        String currentText = "null";


        VerifyExecutedStep(waitForElementToAppear(elementName));
        if (attribute.equalsIgnoreCase("TEXT")) {
			currentText = readTextOfWebElement(AllProducts.getElementSelector(elementName));
		} else if (attribute.equalsIgnoreCase("VALUE") || attribute.equalsIgnoreCase("HREF") || attribute.equalsIgnoreCase("PLACEHOLDER")) {
			currentText = readAttributeOfWebElement(AllProducts.getElementSelector(elementName), attribute.toLowerCase());
		} else {
			AssertExecutedStep( "FAIL" + " : " + "The " + attribute + " attribute test of element has not been implemented");
		}

        if (!text.contains("http")) {
			text = DataHelp.prepText(text);
		}

        String result = "FAIL";

        if (condition.equalsIgnoreCase("EQUAL")) {
            if (currentText.equalsIgnoreCase(text)) {
				result = "PASS";
			}
        } else if (condition.equalsIgnoreCase("CONTAIN")) {
            if (currentText.contains(text)) {
				result = "PASS";
			}
        } else {
			AssertExecutedStep( "FAIL" + " ,,, : " + "The " + condition + " condition test of element has not been implemented");
		}

        AssertExecutedStep( result + " ,,, : " + "The " + currentText + " " + attribute + " should " + condition + " with text " + text + " in the " + elementName);
    }

    public static void elementTextShouldNotBe(String elementName, String attribute, String condition, String text) {
    	attribute = attribute.toUpperCase();
        if (text.contains("Text")) {
			DataHelp.getStoredText(text);
		}
        String currentText = "null";

        VerifyExecutedStep(waitForElementToAppear(elementName));
        if (attribute.equalsIgnoreCase("TEXT")) {
			currentText = readTextOfWebElement(AllProducts.getElementSelector(elementName));
		} else if (attribute.equalsIgnoreCase("VALUE") || attribute.equalsIgnoreCase("HREF") || attribute.equalsIgnoreCase("PLACEHOLDER")) {
			currentText = readAttributeOfWebElement(AllProducts.getElementSelector(elementName), attribute.toLowerCase());
		} else {
			AssertExecutedStep( "FAIL" + " : " + "The " + attribute + " attribute has not been implemented");
		}

        if (!text.contains("http")) {
			text = DataHelp.prepText(text);
		}

        String result = "PASS";

        if (condition.equalsIgnoreCase("EQUAL")) {
            if (currentText.equalsIgnoreCase(text)) {
				result = "FAIL";
			}
        } else if (condition.equalsIgnoreCase("CONTAIN")) {
            if (currentText.contains(text)) {
				result = "FAIL";
			}
        } else {
			AssertExecutedStep( "FAIL" + " ,,, : " + "The " + condition + " condition test of element has not been implemented");
		}

        AssertExecutedStep( result + " ,,, : " + "The " + currentText + " " + attribute + " should " + condition + " with text " + text + " in the " + elementName);

    }

    public static void takeAScreenShot(String dest) {
        AssertExecutedStep( takeScreenShot(dest) + " ,,, : " + "I take screenshot and save to " + dest);
    }

    public static void waitSomeSecs(String wait, String waitFor) {
    	VerifyExecutedStep(sleep(Integer.valueOf(wait) * 1000) + " ,,, : " + "Wait " + wait + " sec/s for " + waitFor);
    }

    public static void hitOnTheKeyBoard(String key) {
    	AssertExecutedStep(keyActions(key) + " ,,, : " + "I hit " + key + " on the keyboard");
    }

    public static void storeElementTextAsTextX(String elementName, String attribute, String textX) {
        String currentText = "null";

        VerifyExecutedStep(waitForElementToAppear(elementName));
        if (attribute.equalsIgnoreCase("TEXT")) {
			currentText = readTextOfWebElement(AllProducts.getElementSelector(elementName));
		} else if (attribute.equalsIgnoreCase("VALUE") || attribute.equalsIgnoreCase("HREF") || attribute.equalsIgnoreCase("PLACEHOLDER")) {
			currentText = readAttributeOfWebElement(AllProducts.getElementSelector(elementName), attribute.toLowerCase());
		} else {
			AssertExecutedStep( "FAIL" + " ,,, : " + "The " + attribute + " attribute has not been implemented");
		}
        AssertExecutedStep( DataHelp.storeText(currentText, textX) + " ,,, : " + "Store the " + attribute + " of the " + elementName + " as " + textX);
    }

    public static void storeTextAsTextX(String text, String textX) {
        text = DataHelp.prepText(text);
        AssertExecutedStep( DataHelp.storeText(text, textX) + " ,,, : " + "Store the " + text + " as " + textX);
    }



}
