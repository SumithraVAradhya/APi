package API;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import Utilities.readproperty;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class API_weather {

    public double weather() throws ParseException, IOException {
        readproperty read_details = new readproperty();
        Properties Prop = read_details.fetch_property();

        Response DetailsResponse = given()
                .when()
                .contentType(ContentType.JSON)
                .queryParam("q",Prop.getProperty("CITY"))
                .queryParam("appid",Prop.getProperty("API_key"))
                .get(Prop.getProperty("API_URL"));


        JSONParser Parser = new JSONParser();
        Object obj = Parser.parse(DetailsResponse.asString());
        JSONObject JSON = (JSONObject) obj;
        JSONObject tempmain = (JSONObject) JSON.get("main");
        double temp = (double) tempmain.get("temp");
        return  temp;
    }
}
