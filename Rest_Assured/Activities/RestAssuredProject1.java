package activities_RestAssured;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RestAssuredProject1 {
    
    private RequestSpecification requestSpec;
    private String sshKey = "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAILTEVhmt5nvKTzFvh+8iI6JBdRfIoh67JtqQ/J4I3IrB";
    private int keyId;

    @BeforeClass
    public void setup() {
    	String githubToken = System.getenv("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");
        requestSpec = new RequestSpecBuilder()
                .setContentType("application/json")
                .addHeader("Authorization", "token" + githubToken)
                .setBaseUri("https://api.github.com")
                .build();
    }

    @Test
    public void testAddSSHKey() {
        String requestBody = "{\n" +
                "    \"title\": \"TestAPIKey\",\n" +
                "    \"key\": \"" + sshKey + "\"\n" +
                "}";

        Response response = RestAssured.given()
                .spec(requestSpec)
                .body(requestBody)
                .post("/user/keys");

        Assert.assertEquals(response.statusCode(), 201, "Expected status code 201 for POST request");

        keyId = response.jsonPath().getInt("id");
        Reporter.log("SSH Key added with ID: " + keyId);
    }

    @Test(dependsOnMethods = "testAddSSHKey")
    public void testGetSSHKey() {
        Response response = RestAssured.given()
                .spec(requestSpec)
                .pathParam("keyId", keyId)
                .get("/user/keys/{keyId}");

        Assert.assertEquals(response.statusCode(), 200, "Expected status code 200 for GET request");

        Reporter.log("GET SSH Key Response: " + response.asString());
    }

    @Test(dependsOnMethods = "testGetSSHKey")
    public void testDeleteSSHKey() {
        Response response = RestAssured.given()
                .spec(requestSpec)
                .pathParam("keyId", keyId)
                .delete("/user/keys/{keyId}");

        Assert.assertEquals(response.statusCode(), 204, "Expected status code 204 for DELETE request");

        Reporter.log("SSH Key deleted with ID: " + keyId);
    }
}

