package com.googlerestapi.com.rest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.*;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

public class GetJsonResponseTest {

  @BeforeClass
  public void setBaseUri () {

    RestAssured.baseURI = "https://maps.googleapis.com";
  }
  
  @Test
  public void test01()  {
    Response res  =given ().param ("query", "Churchgate Station")
    .param ("key", "AIzaSyCMXt0k97b5KL1WWWlUB7Vci7yQgfsybqY")
    .when()
    .get ("/maps/api/place/textsearch/xml")
    .then()
    .contentType(ContentType.XML)
    .extract().response();


    System.out.println (res.asString ());

  }

}