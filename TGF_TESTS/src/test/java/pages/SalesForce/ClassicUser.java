package pages.SalesForce;

import java.util.HashMap;

public class ClassicUser {

  public static HashMap<String, String> elementLocators = new HashMap<>();

  public static void setElements()
  {
	elementLocators.put("default", "default");
    elementLocators.put("log_in", "//input[@title='Login']");
  }

  public static String getElementSelector(String element_name)
  {
    setElements();
    String elementLocator = elementLocators.get(element_name);
    return elementLocator;
  }
}
