package stepDefinition;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import commonUtils.RestFWLogger;
import commonUtils.Utils;
import io.cucumber.java.en.*;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.junit.Assert;
import resource.TestDataBuilder;

import java.io.File;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;

public class CreateARepo {
    public static Response response;
    public static String request_Payload;
    public  String repoName;

    TestDataBuilder testDataBuilder = new TestDataBuilder();


    @Given("Create a payload")
    public void create_a_payload() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        request_Payload = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(testDataBuilder.createRepoPayload());

    }

    @When("Send a post Request to create the repository")
    public void send_a_post_request_to_create_the_repository() {
        response = Utils.postRequest(request_Payload);


    }

    @Then("the repository should be successfully created with HTTP status {int}")
    public void the_repository_should_be_successfully_created_with_http_status(int StatusCode) {


        Assert.assertEquals(response.getStatusCode(), StatusCode);

    }

    @Then("Verify the Repository name")
    public void verify_the_repository_name() {

        Assert.assertEquals(TestDataBuilder.getRepoName(), response.jsonPath().get("name"));

    }

    @And("Verify the Repository description")
    public void verifyTheRepositoryDescription() {

        Assert.assertEquals(TestDataBuilder.getRepoDescription(), response.jsonPath().get("description"));

    }

    @And("Verify the JSON Schema")
    public void verifyTheJSONSchema() {


                response.then().body(matchesJsonSchemaInClasspath("Repo.json"));
    }

    @Given("Get the endpoint of a repository")
    public void getTheEndpointOfARepository() {

        repoName=TestDataBuilder.getRepoName();

    }

    @When("Send a delete Request")
    public void sendADeleteRequest() {

        response = Utils.deleteRequest(repoName);

    }
    @Then("the repository should be successfully deleted and should be show the status {int} {string}")
    public void theRepositoryShouldBeSuccessfullyDeletedAndShouldBeShowTheStatus(int statusCode, String statusLine) {
        Assert.assertEquals(statusCode, response.getStatusCode());
        Assert.assertEquals(statusLine, response.getStatusLine());
    }

    @Then("Verify the Repository body")
    public void verifyTheRepositoryBody() {
        response.then().assertThat().body(equalTo(""));

    }
    @Given("Create a payload {string} and {string}")
    public void createAPayloadAnd(String name, String description) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        request_Payload = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(testDataBuilder.createRepoPayload(name,description));

    }

    @Given("Get the name of a repository {string}")
    public void getTheNameOfARepository(String name) {
        repoName=name;
    }
}

