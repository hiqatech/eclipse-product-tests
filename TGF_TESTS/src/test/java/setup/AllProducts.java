package setup;

import static setup.AllPages.getGOSElementSelector;
import static setup.AllPages.getSalesForceElementSelector;

import org.json.simple.JSONObject;

public class AllProducts {

	public static String GOSFramePages = "FundingRequest,";

    public static String getElementSelector(String elementName)
    {
    	if(System.getProperty("product").contains("GOS")) {
			return getGOSElementSelector(elementName);
		}
        if(System.getProperty("product").contains("SalesForce")) {
			return getSalesForceElementSelector(elementName);
		} else {System.out.println("Product has not been defined in AllProducts");
            return "NoSuchAProduct";}
    }
    
    public static String getFullServiceURL(String requestName) {
        if (System.getProperty("product").contains("SalesForce")) {
            return AllServices.getRequestURL(requestName); }
        else { System.out.println("Product has not defined yet in the test requests AllProducts \n");
            return "NoSuchAProduct";}
    }

    public static JSONObject getServiceBodyByServiceName(String requestName) {
        if (System.getProperty("product").contains("SalesForce"))
             return AllServices.getRequestBody(requestName);
        else System.out.println("Product request has not defined yet in the test requests AllProducts \n");
            return null;
    }

    public static String getDBURL(String dbName) {
        if (System.getProperty("product").contains("SalesForce"))
             return AllURLs.getDBURL(dbName);
        else System.out.println("Product database has not defined yet in the test requests AllProducts \n");
            return null;
    }
    
    public static String getDBPassw(String dbName) {
        if (System.getProperty("product").contains("SalesForce"))
             return AllURLs.getDBPassw(dbName);
        else System.out.println("Product database has not defined yet in the test requests AllProducts \n");
            return null;
    }
}

