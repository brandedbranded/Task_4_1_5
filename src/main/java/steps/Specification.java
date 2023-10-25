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
import models.responsesPositive.ResponseAuthorSave;
import models.responsesPositive.ResponseBookSave;
import models.responsesPositive.ResponseGetAllBooks;
import models.responsesPositive.ResponseGetAllBooksXML;

import java.util.List;

import static io.restassured.RestAssured.given;

public class Specification {
    public static RequestSpecification reqSpec() {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        return new RequestSpecBuilder()
                .setBaseUri("http://localhost")
                .setContentType(ContentType.JSON)
                .setPort(8080)
                .build();
    }
    public static RequestSpecification reqSpecXML() {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        return new RequestSpecBuilder()
                .setBaseUri("http://localhost")
                .setContentType(ContentType.XML)
                .setPort(8080)
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
        ResponseAuthorSave checkResp =
                given().spec(reqSpec())
                        .body(author)
                        .when()
                        .post(EndPoints.saveNewAuthorURL)
                        .then().spec(respSpecSave())
                        .extract().as(ResponseAuthorSave.class);
        return checkResp;
    }

    public static ResponseBookSave reqSpecSaveBook(String bookTitle, long authorId) {
        BookSaveAuthorExmp author = new BookSaveAuthorExmp(authorId);
        RequestBookSave book = new RequestBookSave(bookTitle, author);
        ResponseBookSave check =
                given().spec(reqSpec())
                        .body(book)
                        .when()
                        .post(EndPoints.saveNewBookURL)
                        .then().spec(respSpecSave())
                        .extract().as(ResponseBookSave.class);
        return check;
    }

    public static List<ResponseGetAllBooks> reqSpecGetAllBooks(long id) {
        List <ResponseGetAllBooks> listOfBooks =
                given().spec(reqSpec())
                        .when()
                        .get(EndPoints.getAllBooksURL, id)
                        .then().spec(respSpecGet())
                        .extract().jsonPath().getList(".", ResponseGetAllBooks.class);
        return listOfBooks;
    }

    public static List<ResponseGetAllBooksXML> reqSpecGetAllBooksXML(long id) {
        RequestGetAllBooksXML author = new RequestGetAllBooksXML();
        List <ResponseGetAllBooksXML> listOfBooks =
                given().spec(reqSpecXML())
                        .body(author)
                        .when()
                        .post(EndPoints.getAllBooksXMLUrl)
                        .then().spec(respSpecGet())
                        .extract().jsonPath().getList(".", ResponseGetAllBooksXML.class);
        return listOfBooks;
    }
    public static void installSpecification(RequestSpecification req, ResponseSpecification resp) {
        RestAssured.requestSpecification = req;
        RestAssured.responseSpecification = resp;
    }
}
