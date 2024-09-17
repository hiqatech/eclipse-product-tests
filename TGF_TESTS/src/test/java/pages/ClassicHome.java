package pages;

import java.util.HashMap;

public class ClassicHome {

  public static HashMap<String, String> elementLocators = new HashMap<>();

  public static void setElements()
  {
	elementLocators.put("default", "default");
	elementLocators.put("view_profile", "//button[contains(@class,'userProfile')]");
	elementLocators.put("switch_to_salesforce_classic", "//a[normalize-space(.)='Switch to Salesforce Classic']");
	elementLocators.put("switch_to_lightning_experience", "//div//a[normalize-space(.)='Switch To Lightning Experience']");
	elementLocators.put("app_launcher", "//*[@title='App Launcher']");
	elementLocators.put("app_search", "//*[@placeholder='Search apps and items...']");
	elementLocators.put("app_search_result_1", "//*[@aria-label='Apps']//a");
	elementLocators.put("search_field", "//*[@id='phSearchInput']");
    elementLocators.put("search_button", "//*[@id='phSearchButton']");
    elementLocators.put("search_all_button", "//*[@id='searchAllSummaryButton']");
    elementLocators.put("search_result_user_1", "//*[@class='peopleInfoContent']//div//a");
    elementLocators.put("search_result_user_1_status", "//*[@class='peopleInfoContent']//span");
    elementLocators.put("search_result_organization_1", "//*[contains(@data-seckle,'Account']");
    elementLocators.put("user_action_menu", "//*[@title='User Action Menu']");
    elementLocators.put("user_detail", "//*[@title='User Detail']");
    elementLocators.put("log_in", "//input[@title='Login']");
    elementLocators.put("Funding_Request_Main_Tab", "//*[contains(@class,'Funding-Request')]");


  }

  public static String getElementSelector(String element_name)
  {
    setElements();
    String elementLocator = elementLocators.get(element_name);
    return elementLocator;
  }
}
