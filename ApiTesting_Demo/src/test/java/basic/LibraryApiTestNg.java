package basic;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import util.Payload;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.DataProvider;

public class LibraryApiTestNg {
  @Test(dataProvider = "getdata")
  public void addBookApi(String isbn, String aisle) {
	  
	  RestAssured.baseURI="http://216.10.245.166";
		
		//to Ignore all the certification errors
		RestAssured.useRelaxedHTTPSValidation();
		
		given().log().all().header("Content-Type","application/json").
		body(Payload.AddBook1(isbn,aisle)).
		when().post("Library/Addbook.php").
		then().log().all().assertThat().statusCode(200).body("Msg", equalTo("successfully added"));
  }

  @DataProvider
  public Object[][] getdata() {
    return new Object[][] {
      new Object[] { "1234", "bhgh" },
      new Object[] { "989", "bnbmn" },
    };
  }
}
