package com.david.core;

import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

// Base Class (Core Layer) RestAssured API Settings
public class Base {  

    @BeforeClass // Is running once before tests in testing class.
    public static RequestSpecification reqSpec(){
        return RestAssured.given()
            .baseUri("https://jsonplaceholder.typicode.com") // Setting the URI
            .contentType("application/json"); // Setting the Content Type
    }
}
