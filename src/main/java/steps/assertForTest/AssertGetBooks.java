package steps.assertForTest;

import models.responsesPositive.ResponseGetAllBooks;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;


public class AssertGetBooks {
    public static void verifyGetAllBooksResponse(List<ResponseGetAllBooks> listOfBooks) {
        assertFalse(listOfBooks.isEmpty());
        assertThat(listOfBooks)
                .isNotNull()
                .asString()
                .contains("bookTitle")
                .contains("author")
                .contains("firstName")
                .contains("familyName")
                .contains("secondName");
    }
}
