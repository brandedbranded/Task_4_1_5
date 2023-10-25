package GetInfo;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import jdk.jfr.Description;
import models.responsesPositive.ResponseGetAllBooks;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.Specification;
import steps.assertForTest.AssertGetBooks;

import java.util.List;

@Epic("GetTests")
@Story("Positive tests")
public class GetAllBooksTest {
    @DisplayName("Get all author's books by id")
    @Description("Возвращается список всех книг автора соответствующего введенному id, статус-код 200")
    @Test
    public void getAllBooksTest(){
        List <ResponseGetAllBooks> allBooks = Specification.reqSpecGetAllBooks(1);
        AssertGetBooks.verifyGetAllBooksResponse(allBooks);
    }
}
