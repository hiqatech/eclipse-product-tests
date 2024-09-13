package cucumber;

import data.DataHelp;
import io.cucumber.java.en.Given;
import selenium.WebActs;

public class TGFSteps extends WebActs {

	 @Given("I navigate to the SalesForce Home page")
	    public static void INavigateToTheSalesForceHomePage(){
	    	startWebDriver("default");
	        navigateToHomePage("app_home");
	        onThePage("LogIn");
	    }

	@Given("I connect with the Admin user")
	public static void IConnectWithTheAdminUser() {
		INavigateToTheSalesForceHomePage();
	    intoTheElement("enter",DataHelp.getTestData("AdminUser") , "user_name");
        intoTheElement("enter",DataHelp.getTestData("AdminPass") , "pass_word");
        actTheElement("click", "log_in");
        onThePage("ClassicHome");
		ISwitchToSalesForceClassic();
	}

	@Given("I login with the {string} user")
	public static void ILoginWithTheUser(String user) {
        ISearchForThe(user,"user");
        actTheElement("click", "user_action_menu");
        actTheElement("click", "user_detail");
        actTheElement("click", "log_in");
        waitSomeSecs("5","log_in");
        ISwitchToSalesForceClassic();
	}

	@Given("I search for the {string} {string}")
	public static void ISearchForThe(String searchTerm, String searchType) {
		intoTheElement("enter",searchTerm, "search_field");
		actTheElement("click", "search_button");
		waitSomeSecs("5","search_results");
		if(searchType.equalsIgnoreCase("user")) {
			actTheElement("click", "search_result_user_1");
		}
	}

	@Given("I switch to the {string} app")
	public static void ISwitchToTheApp(String appName) {
	    actTheElement("click", "app_launcher");
        intoTheElement("enter",appName , "app_search");
        actTheElement("click", "app_search_result_1");
        waitSomeSecs("2","search_results");
	}

	@Given("I switch to SalesForce Classic")
	public static void ISwitchToSalesForceClassic() {
		if(getCurrentURL().contains("lightning"))
		{	actTheElement("click", "view_profile");
			actTheElement("click", "switch_to_salesforce_classic");
			waitSomeSecs("5","search_results");
		}
	}

	@Given("I switch to SalesForce Lightning")
	public static void ISwitchToSalesForceLightning() {
		if(getCurrentURL().contains("my"))
		{	actTheElement("click", "switch_to_lightning_experience");
			waitSomeSecs("5","search_results");
		}
	}



}
