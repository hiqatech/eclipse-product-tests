package cucumber;
import setup.AllProducts;
import data.DataHelp;
import io.cucumber.java.en.Given;

import static setup.Hooks.AssertExecutedStep;

public class DataSteps {

	@Given("I send the {string} query to get the {string} data")
    public static void IReadTheTestData(String query, String data) {
		AssertExecutedStep(DataHelp.selectSQLQuery(AllProducts.getDBURL(""),AllProducts.getDBPassw(""),query,data) 
				+ " : " + "I send the " + query + " query to get the " + data + " data \n");
    }
}
