package Specs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequestSpecOrder {


 public static RequestSpecification getSpec(){
//Declare specs as static method
  RequestSpecification requestSpec= new RequestSpecBuilder().setContentType(ContentType.JSON).build();
  return requestSpec;

 }

}
