package setup;

import static setup.AllPages.getGOSElementSelector;
import static setup.AllPages.getSalesForceElementSelector;

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

}

