package setup;

public class AllURLs {

    public static String GOSClassicURL = "https://globalfund--" + System.getProperty("runEnvironment") + "fc.sandbox.my.salesforce.com";
    public static String GOSLightningURL = GOSClassicURL.replace("my.salesforce", "lightning.force");

    public static String FundingRequest = "/lightning/n/AIM_Allocation_Funding_Request?0.source=aloha";

    public static String getProductURL()
    {
        if (System.getProperty("product").equalsIgnoreCase("GOS")) {
			return GOSClassicURL;
		} else {
			return "Product URL has not been defined";
		}
    }

    public static String getModuleURL(String pageName)
    {
        if (pageName.equalsIgnoreCase("FundingRequest")) {
			//return GOSLightningURL + FundingRequest;
        	return GOSLightningURL + "/lightning/n/AIM_Allocation_Funding_Request?0.source=aloha";
		} else {
			return "Module URL has not been defined";
		}
    }

}