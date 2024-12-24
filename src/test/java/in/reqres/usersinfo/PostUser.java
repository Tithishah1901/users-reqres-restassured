package in.reqres.usersinfo;

import in.reqres.model.UserPojo;
import in.reqres.testbase.TestBase;
import in.reqres.utils.TestUtils;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PostUser extends TestBase {


    @Test
    public void postCreateUsers(){
    String email = TestUtils.getRandomValue() + "Tithi.456@abc.com";

        UserPojo userPojo = new UserPojo();
        userPojo.setFirstName("Tithi");
        userPojo.setLastName("shah");
        userPojo.setEmail(email);
        userPojo.setAvatar("https://reqres.in/img/faces/8-image.jpg");

        Response response = given().log().all()
                .header("Content-Type","application/json")
                .when()
                .body(userPojo)
                .post();
        response.prettyPrint();
        response.then().statusCode(201);
    }
    @Test
    public void loginSuccessFully(){
        Response response = given().log().all()
                .header("Content-Type","application/json")
                .when()
                .body("{ \"email\": \"Tithi.1234@gmail.com\", \"password\": \"tester\" }")
                .post("/api/login");
        response.prettyPrint();
        response.then().statusCode(201);
    }
}
