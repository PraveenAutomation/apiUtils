package basicsApiRSA;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import files.Payload;



public class GetApi {

	public static void main(String[] args) {
		
		/*Rest API works on 3 principle:
		 * - Given, When & Then --> resources & http methods
		 * Given : all input details
		 * When: submit the API
		 * Then: validate the response
		 * 
		 */
		RestAssured.baseURI="https://rahulshettyacademy.com";
		given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(Payload.addPlace()).when().post("/maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP"))
		.header("Server", "Apache/2.4.41 (Ubuntu)");
		
		//Add place-->Update place with new address-->Get place to validate if new address present in response
		

	}

}
