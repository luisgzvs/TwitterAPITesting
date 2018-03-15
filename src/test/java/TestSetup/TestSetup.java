package TestSetup;

import io.restassured.RestAssured;
import org.testng.annotations.*;
import static io.restassured.RestAssured.given;


public class TestSetup {

    @BeforeTest
    public static void setup() {
        //si es local se usa esto:
        /*
        String port = System.getProperty("server.port");
        if (port == null) {
            RestAssured.port = Integer.valueOf(3000);
        } else {
            RestAssured.port = Integer.valueOf(port);
        }*/

        String basePath = System.getProperty("server.base");
        if (basePath == null) {
            basePath = "/";
        }
        RestAssured.basePath = basePath;

        String baseHost = System.getProperty("server.host");
        if (baseHost == null) {
            baseHost = "https://twitter.com/";
        }
        RestAssured.baseURI = baseHost;
    }


    @Test
    public void confirmation() {
        given().when().get("/").then().statusCode(200);
        System.out.print("Setup completed");
    }
}
