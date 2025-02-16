package setup;

public class AllPages {

    public static String getGOSElementSelector(String elementName)
    {
        if(System.getProperty("activePage").equalsIgnoreCase("LogIn")) {
			return pages.LogIn.getElementSelector(elementName);
		} else if(System.getProperty("activePage").equalsIgnoreCase("ClassicHome")) {
			return pages.ClassicHome.getElementSelector(elementName);
		} else if(System.getProperty("activePage").equalsIgnoreCase("ClassicUser")) {
			return pages.ClassicUser.getElementSelector(elementName);
		} else if(System.getProperty("activePage").equalsIgnoreCase("FundingRequest")) {
			return pages.FundingRequest.getElementSelector(elementName);
		} else {System.out.println( System.getProperty("product") + " " + System.getProperty("activePage") +
            " Page has not been defined in the AllPages");
            return "NoSuchAnElement";}
    }

    public static String getSalesForceElementSelector(String elementName)
    {
        if(System.getProperty("activePage").equalsIgnoreCase("Home")) {
			return pages.ClassicHome.getElementSelector(elementName);
		} else if(System.getProperty("activePage").equalsIgnoreCase("MyProfile")) {
			return pages.LogIn.getElementSelector(elementName);
		} else {System.out.println( System.getProperty("product") + " " + System.getProperty("activePage") +
            " Page has not been defined in the AllPages");
            return "NoSuchAnElement";}
    }

}
