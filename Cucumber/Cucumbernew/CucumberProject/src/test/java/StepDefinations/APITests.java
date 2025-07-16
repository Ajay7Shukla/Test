package StepDefinations;

import io.cucumber.cienvironment.internal.com.eclipsesource.json.Json;
import io.cucumber.core.internal.com.fasterxml.jackson.annotation.JsonFormat;
import io.cucumber.java.en.*;
import io.restassured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.equalTo;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Assertions;
import org.testng.Assert;


public class APITests {
	
	private ValidatableResponse validatableResponse;
	
	@Given("I send a request to the url {string}")
	public void i_send_a_request_to_the_url(String url) {
		System.out.println("Send request to url: "+ url);
		RequestSpecification request = RestAssured.given();
		validatableResponse = request.contentType(ContentType.JSON)
                .when().get(url).then();
		
        System.out.println("Response :"+validatableResponse.extract().asPrettyString());
	}

	@Then("the response will return status {int}")
	public void the_response_will_return_status(Integer status) {
		System.out.println("Check status");
		validatableResponse.assertThat().statusCode(status);
	}
	
	@Then("the response contains title {string}")
	public void the_response_contains_title(String expTitle) {
		Response response = RestAssured.get("https://www.google.com"); 
	    
		System.out.println("Check title"+ response.getBody().asString());
		Assertions.assertTrue(response.getBody().asString().contains(expTitle));
		//validatableResponse.assertThat().statusCode(expectedStatusCode).body("data.id",equalTo(expectedId)).and()
        //.body("data.email",equalTo(expectedEmail)).body("data.first_name",equalTo(expectedFirstName))
        //.body("data.last_name",equalTo(expectedLastName)); - url https://reqres.in/api/users/2

	}

}
