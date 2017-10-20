package com.googlerestapi.com.rest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

import static com.jayway.restassured.RestAssured.*;

public class GetXmlTest {

 @BeforeClass
   public void setBaseUri () {
     RestAssured.baseURI = "https://maps.googleapis.com";   
   }
 
  @Test
    public void test () {
      
     Response res=given ().param ("query", "Churchgate Station")
          .param ("key", "AIzaSyCMXt0k97b5KL1WWWlUB7Vci7yQgfsybqY")
          .when ()
          .get ("/maps/api/place/textsearch/xml")
          .then ()
          .contentType(ContentType.XML)
          .extract().response();
          //.path("placesearchresponse.result[0].formatted_address");            
   System.out.println (res.asString ());
    //Assert.assertEquals (res, "Maharshi Karve Rd, Churchgate, Mumbai, Maharashtra 400020, India");
    
  }
  
}