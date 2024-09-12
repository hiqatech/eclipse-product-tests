package pages.SalesForce;

import java.util.HashMap;

public class LogIn {

    public static HashMap<String, String> elementLocators = new HashMap<String, String>();

    public static void setElements()
    {
        elementLocators.put("user_name", "//input[@id='username']");
        elementLocators.put("pass_word", "//input[@id='password']");
        elementLocators.put("log_in", "//input[@id='Login']");
        elementLocators.put("", "");

    }

    public static String getElementSelector(String element_name)
    {
        setElements();
        String elementLocator = elementLocators.get(element_name);
        return elementLocator;
    }

}
