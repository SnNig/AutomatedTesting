package reqresAutomation;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Reqres_POST_RegisterSuccessful {
	@Test
	 void RegisterSuccessful()
	 {
	  //Specify base URI
	  RestAssured.baseURI="https://reqres.in";
	  
	  //Request object
	  RequestSpecification httpRequest=RestAssured.given();
	  
	  //Post request
	  JSONObject requestParams = new JSONObject();
	  
	  requestParams.put("email", "eve.holt@reqres.in");
	  requestParams.put("password", "pistol");
	  
	  httpRequest.header("Content-Type","application/json");
	  
	  httpRequest.body(requestParams.toJSONString());
	  
	  //Response object
	  Response response=httpRequest.request(Method.POST,"/api/register");
	  
	  
	  
	  //print response in console window
	  
	  String responseBody=response.getBody().asString();
	  System.out.println("Response Body is:" +responseBody);
	  
	  //status code validation
	  int statusCode=response.getStatusCode();
	  System.out.println("Status code is: "+statusCode);
	  Assert.assertEquals(statusCode, 200);
	  
	  //status code validation
	  String token=response.jsonPath().get("token");
	  Assert.assertEquals(token, "QpwL5tke4Pnpja7X4");
	  
	
	 }
}
