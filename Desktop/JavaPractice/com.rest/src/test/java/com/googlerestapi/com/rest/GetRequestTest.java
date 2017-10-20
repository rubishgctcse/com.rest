package com.googlerestapi.com.rest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.*;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

public class GetRequestTest {

  @BeforeClass
  public void setBaseUri () {

    RestAssured.baseURI = "https://maps.googleapis.com";
  }

  @Test
  public void testResult ()  {
    String res  = given ().param ("query", "Churchgate Station")
    .param ("key", "AIzaSyCMXt0k97b5KL1WWWlUB7Vci7yQgfsybqY")
    .when()
    .get ("/maps/api/place/textsearch/json")
    .then()
    .contentType(ContentType.JSON)
    .extract()
    .path ("results[0].formatted_address");
    //.response();
    //System.out.println (res.asString ());
   Assert.assertEquals (res, "Maharshi Karve Rd, Churchgate, Mumbai, Maharashtra 400020");
  }
  
  @Test
  public void GetWeatherStatusLine()
  {
  	RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
  	RequestSpecification httpRequest = RestAssured.given();
  	Response response = httpRequest.get("/Hyderabad");
  	
  	// Get the status line from the Response and store it in a variable called statusLine
  	String statusLine = response.getStatusLine();
  	Assert.assertEquals(statusLine /*actual value*/, "HTTP/1.1 200 OK" /*expected value*/, "Correct status code returned");
  }
  
  
}