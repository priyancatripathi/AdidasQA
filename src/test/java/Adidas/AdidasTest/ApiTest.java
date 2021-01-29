package Adidas.AdidasTest;
import static io.restassured.RestAssured.given;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static org.hamcrest.Matchers.*;

public class ApiTest {
	
	//Gets the available pets and asserts their status
	@Test
	public void GetAvailablePets()
	{
		  RestAssured.baseURI = "https://petstore.swagger.io/v2";
		  String getAvaliablePetsResponse = given().log().all().queryParam("status", "available")
				  .when().get("pet/findByStatus")
				  .then().assertThat().statusCode(200).extract().response().asString();
		  System.out.println(getAvaliablePetsResponse);
		 
	}
	
	//Adds a new pet, updates the status to sold, deletes the added pet.
	@Test
	public void AddUpdateDeleteNewPet()
	{
		//Posting a new available pet to the store 
		  RestAssured.baseURI = "https://petstore.swagger.io/v2";
		  String addnewPetResponse = 	given().log().all().header("Content-Type","application/json").body(Payload.AddApi())
				  .when().post("pet")
				  .then().assertThat(). statusCode(200).body("name", equalTo("doggie")).extract().response().asString();
		  System.out.println(addnewPetResponse);
		  
		  // Assertion for new pet added using name 
		  String expectedPetName = "doggie";
		  JsonPath js1 = new JsonPath(addnewPetResponse);
		  String petName= js1.getString("name");
		  Assert.assertEquals(expectedPetName, petName);
		  
		  //Updates this pet status to "sold"
		  
		  String petId = js1.getString("id");
		  System.out.println(petId);
		  String updatedPetStatus = "sold";
		  
		  String UpdateStatusResponse = given().log().all().header("Content-Type","application/json")
				  .body("{\"id\":"+petId+",\"category\""
				  		+ ":{\"id\":0,\"name\":\"string\"},\"name\":\"doggie\","
				  		+ "\"photoUrls\":[\"string\"],\"tags\":[{\"id\":0,\"name\":\"string\"}],"
				  		+ "\"status\":\""+updatedPetStatus+"\"}")
				  .when().put("pet")
				  .then().assertThat().statusCode(200).body("status", equalTo("sold")).extract().response().asString();
		  System.out.println(UpdateStatusResponse);
		  
		  //Using get method to fetch the new added pet's ID.
		String getStatusResponse =  given().log().all()
		  .when().get("/pet/"+petId+"")
		  .then().assertThat().statusCode(200).extract().response().asString();
		System.out.println(getStatusResponse);
		
		//Asserting the status updated
		JsonPath js2 = new JsonPath(getStatusResponse);
		String actualPetStatus = js2.getString("status");
		System.out.println(actualPetStatus); 
		Assert.assertEquals(updatedPetStatus, actualPetStatus);
		
		//Delete the added pet
		String deletePetResponse = given().log().all().header("Content-Type","application/json").header("api_key","special-key")
		  .when().delete("/pet/"+petId+"")
		  .then().assertThat().statusCode(200).extract().response().asString();
		   System.out.println(deletePetResponse);
		
		//Verifying that the deleted pet id no longer exists
		  String getDeletedPetResponse = given().log().all() .when().get("/pet/"+petId+"")
		  .then().assertThat().statusCode(404).extract().response().asString();
		  System.out.println(getDeletedPetResponse);
		  
		//Asserts that added the pet is deleted
		  JsonPath js3 = new JsonPath(getDeletedPetResponse); 
		  String actualID =js3.getString("id");
		  System.out.println(actualID);
		  Assert.assertEquals(null, actualID);
		 
		
		
	}
	
}
