package helper;

import authen.Oauth2;
import config.BaseConfig;
import config.CommentConfig;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class CommentHelper {


    public static String AddNewCommentBodyParam(String comment){
      String requestBody =  "{\n" +
                "    \"body\": {\n" +
                "        \"type\": \"doc\",\n" +
                "        \"version\": 1,\n" +
                "        \"content\": [\n" +
                "            {\n" +
                "                \"type\": \"paragraph\",\n" +
                "                \"content\": [\n" +
                "                    {\n" +
                "                        \"text\": \""+comment+"\",\n" +
                "                        \"type\": \"text\"\n" +
                "                    }\n" +
                "                ]\n" +
                "            }\n" +
                "        ]\n" +
                "    }\n" +
                "}";
      return requestBody;
    }


    public static String GetIssueCommentByIndex(String issueID){
        String access_Token = Oauth2.getTokenKey();
        String couldID = Oauth2.getCouldID();
        RestAssured.baseURI = BaseConfig.BASE_URL + couldID;
        Response res =
                given().auth().oauth2(access_Token).contentType("application/json")
                        .when().get(CommentConfig.GenerateCommentURL(issueID))
                        .then().extract().response();
        String returnList  = res.jsonPath().get("comments.body.content.content").toString();

        return returnList;
    }
}

