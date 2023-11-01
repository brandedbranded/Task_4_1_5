package steps.assertForTest;

import io.restassured.response.ValidatableResponse;

import java.time.LocalDate;
import java.time.ZoneId;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class AssertBooks {

    public static void verifyBodyGetBooks(ValidatableResponse allBooks, long id, String bookTitle) {
        LocalDate lc = LocalDate.now(ZoneId.of("UTC"));
        allBooks.assertThat()
                .body("find{it.bookTitle=='" + bookTitle + "'}.bookTitle", equalTo(bookTitle))
                .body("author.find{it.id==" + id + "}.id", equalTo((int) id));
        assertNotNull(allBooks.extract().jsonPath().getString("updated"));
        assertTrue(allBooks.extract().jsonPath().getString("updated").contains(lc.toString()));
    }
}
