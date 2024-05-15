package commonUtils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {
    public static RequestSpecification request_Specification;
    public static Response response;

    public static Response postRequest(String payload) {

        RestFWLogger.initLogger();
        request_Specification = RestAssured.given().body(payload);
        request_Specification.header("Accept", "application/vnd.github+json");
        request_Specification.header("Authorization", Authorization.getToken());
        request_Specification.header("X-GitHub-Api-Version", "2022-11-28");
        request_Specification.contentType("application/json");
        RestFWLogger.info("request payload is"+ " "+request_Specification.log().all());
        response = request_Specification.post(Endpoints.create_A_Repo_URL);
        response.prettyPrint();
        return response;

    }

    public static Response deleteRequest(String repoName) {

        RestFWLogger.initLogger();
        request_Specification = RestAssured.given();
        request_Specification.accept("application/vnd.github+json");
        request_Specification.header("X-GitHub-Api-Version", "2022-11-28");
        request_Specification.header("Authorization", Authorization.getToken());
        RestFWLogger.info("request payload is"+ " "+request_Specification.log().all());
        Response response = request_Specification.delete(Endpoints.delete_A_Repo_URL+repoName);
        System.out.println(response.then().log().all());
        response.prettyPrint();
        return response;

    }
}
