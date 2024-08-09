package activities_RestAssured;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class Activity2 {
    // Set base URL
    final static String ROOT_URI = "https://petstore.swagger.io/v2/user";

    @Test(priority=1)
    public void addNewUserFromFile() throws IOException {
        // Build file path
        File file = new File("src/test/java/activities_RestAssured/userinfo.json");
        FileInputStream inputJSON = new FileInputStream(file);
        String reqBody = new String(inputJSON.readAllBytes());
        inputJSON.close();

        Response response = 
            given().contentType(ContentType.JSON)
            .body(reqBody)
            .when().post(ROOT_URI);

        // Log response for debugging
        System.out.println("Response: " + response.getBody().asString());

        // Assertion
        response.then().body("code", equalTo(200));
        response.then().body("message", equalTo("4751"));
    }

    @Test(priority=2)
    public void getUserInfo() throws IOException {
        // Ensure directory exists
        File outputJSON = new File("src/test/java/activities_RestAssured/userGETResponse.json");
        outputJSON.getParentFile().mkdirs();
        outputJSON.createNewFile();

        Response response = 
            given().contentType(ContentType.JSON)
            .pathParam("username", "BBVELU1")
            .when().get(ROOT_URI + "/{username}");

        String resBody = response.getBody().asPrettyString();
        System.out.println("Response: " + resBody);

        FileWriter writer = new FileWriter(outputJSON.getPath());
        writer.write(resBody);
        writer.close();

        // Assertions
        response.then().body("id", equalTo(4751));
        response.then().body("username", equalTo("BBVELU1"));
        response.then().body("firstName", equalTo("BHARATH"));
        response.then().body("lastName", equalTo("VELU"));
        response.then().body("email", equalTo("BBVELU@mail.com"));
        response.then().body("password", equalTo("password123"));
        response.then().body("phone", equalTo("7474389012"));
    }

    @Test(priority=3)
    public void deleteUser() throws IOException {
        Response response = 
            given().contentType(ContentType.JSON)
            .pathParam("username", "BBVELU1")
            .when().delete(ROOT_URI + "/{username}");

        // Log response for debugging
        System.out.println("Response: " + response.getBody().asString());

        // Assertions
        response.then().body("code", equalTo(200));
        response.then().body("message", equalTo("BBVELU1"));
    }
}
