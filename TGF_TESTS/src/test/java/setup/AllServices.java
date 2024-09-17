package setup;

import org.json.simple.JSONObject;

import service.Requests;
import service.ServiceHelp;

public class AllServices {

  public static String getRequestURL(String requestName) {
      return ServiceHelp.getRequestURL(requestName);
  }

  public static JSONObject getRequestBody(String requestName) {
      return ServiceHelp.getRequestBody(requestName);
  }

}
