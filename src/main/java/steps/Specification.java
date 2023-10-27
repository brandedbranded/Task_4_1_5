package steps;


import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import models.BookSaveAuthorExmp.BookSaveAuthorExmp;
import models.requests.RequestAuthorSave;
import models.requests.RequestBookSave;
import models.requests.RequestGetAllBooksXML;
import models.responsesPositive.*;

import java.util.List;

import static io.restassured.RestAssured.given;

public class Specification {
    public static RequestSpecification reqSpec() {
        return new RequestSpecBuilder()
                .setBaseUri("http://localhost")
                .setContentType(ContentType.JSON)
                .setPort(8080)
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .build();
    }

    public static RequestSpecification reqSpecXML() {
        return new RequestSpecBuilder()
                .setBaseUri("http://localhost")
                .setContentType(ContentType.XML)
                .setPort(8080)
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .build();
    }

    public static ResponseSpecification respSpecSave() {
        return new ResponseSpecBuilder()
                .expectStatusCode(201)
                .log(LogDetail.ALL)
                .build();
    }

    public static ResponseSpecification respSpecGet() {
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .log(LogDetail.ALL)
                .build();
    }

    public static ResponseAuthorSave reqSpecSaveAuthor(String firstName, String lastName, String middleName) {
        RequestAuthorSave author = new RequestAuthorSave(firstName, lastName, middleName);

        return given().spec(reqSpec())
                .body(author)
                .when()
                .post(EndPoints.saveNewAuthorURL)
                .then().spec(respSpecSave())
                .extract().as(ResponseAuthorSave.class);
    }

    public static ResponseBookSave reqSpecSaveBook(String bookTitle, long authorId) {
        BookSaveAuthorExmp author = new BookSaveAuthorExmp(authorId);
        RequestBookSave book = new RequestBookSave(bookTitle, author);

        return given().spec(reqSpec())
                .body(book)
                .when()
                .post(EndPoints.saveNewBookURL)
                .then().spec(respSpecSave())
                .extract().as(ResponseBookSave.class);
    }

    public static List<ResponseGetAllBooks> reqSpecGetAllBooks(long id) {
        return given().spec(reqSpec())
                .when()
                .get(EndPoints.getAllBooksURL, id)
                .then().spec(respSpecGet())
                .extract().jsonPath().getList(".", ResponseGetAllBooks.class);
    }

    public static List <ResponseGetAllBooksXmlList> reqSpecGetAllBooksXML(int id) {
        RequestGetAllBooksXML author = new RequestGetAllBooksXML();
        author.setAuthorId(id);

        return given().spec(reqSpecXML())
                .body(author)
                .when()
                .post(EndPoints.getAllBooksXMLUrl)
                .then().spec(respSpecGet())
                .extract().xmlPath().getList(".", ResponseGetAllBooksXmlList.class);
    }

    public static void installSpecification(RequestSpecification req, ResponseSpecification resp) {
        RestAssured.requestSpecification = req;
        RestAssured.responseSpecification = resp;
    }
}
