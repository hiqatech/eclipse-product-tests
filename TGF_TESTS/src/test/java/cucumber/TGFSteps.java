package cucumber;

import data.DataHelp;
import io.cucumber.java.en.Given;
import selenium.WebHelp;
import cucumber.WebSteps;

public class TGFSteps {

	 @Given("I navigate to the SalesForce Home page")
	    public static void INavigateToTheSalesForceHomePage(){
		 	WebSteps.INavigateToTheHomePage();
		 	WebSteps.IAmOnThePage("LogIn");
	    }

	@Given("I connect with the Admin user")
	public static void IConnectWithTheAdminUser() {
		INavigateToTheSalesForceHomePage();
		WebSteps.IIntoTheElement("enter",DataHelp.getTestData("AdminUser") , "user_name");
		WebSteps.IIntoTheElement("enter",DataHelp.getTestData("AdminPass") , "pass_word");
		WebSteps.IActTheElement("click", "log_in");
		WebSteps.IAmOnThePage("ClassicHome");
		ISwitchToSalesForceClassic();
	}

	@Given("I login with the {string} user")
	public static void ILoginWithTheUser(String user) {
        ISearchForThe(user,"user");
        WebSteps.IActTheElement("click", "user_action_menu");
        WebSteps.IActTheElement("click", "user_detail");
        WebSteps.IActTheElement("click", "log_in");
        WebSteps.IWaitSomeSecs("5","log_in");
        ISwitchToSalesForceClassic();
	}

	@Given("I search for the {string} {string}")
	public static void ISearchForThe(String searchTerm, String searchType) {
		WebSteps.IIntoTheElement("enter",searchTerm, "search_field");
		WebSteps.IActTheElement("click", "search_button");
		WebSteps.IWaitSomeSecs("5","search_results");
		if(searchType.equalsIgnoreCase("user")) {
			WebSteps.IActTheElement("click", "search_result_user_1");
		}
	}

	@Given("I switch to the {string} app")
	public static void ISwitchToTheApp(String appName) {
		WebSteps.IActTheElement("click", "app_launcher");
		WebSteps.IIntoTheElement("enter",appName , "app_search");
		WebSteps.IActTheElement("click", "app_search_result_1");
		WebSteps.IWaitSomeSecs("2","search_results");
	}

	@Given("I switch to SalesForce Classic")
	public static void ISwitchToSalesForceClassic() {
		if(	WebHelp.getCurrentURL().contains("lightning"))
		{	WebSteps.IActTheElement("click", "view_profile");
			WebSteps.IActTheElement("click", "switch_to_salesforce_classic");
			WebSteps.IWaitSomeSecs("5","search_results");
		}
	}

	@Given("I switch to SalesForce Lightning")
	public static void ISwitchToSalesForceLightning() {
		if(	WebHelp.getCurrentURL().contains("my"))
		{	WebSteps.IActTheElement("click", "switch_to_lightning_experience");
			WebSteps.IWaitSomeSecs("5","search_results");
		}
	}



}
