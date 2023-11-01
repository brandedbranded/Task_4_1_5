package steps.assertForTest;

import io.restassured.response.ValidatableResponse;
import models.responsesPositive.ResponseAuthorSave;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AssertSaveAuthor {

    public static void verifySaveAuthorResponse(ResponseAuthorSave author) {
        assertNotNull(author.getAuthorId());
        assertTrue(author.getAuthorId() > 0);
    }

    public static void verifyBirthDate(ValidatableResponse allBooks, long id, String birthDate){
        allBooks.body("author.find{it.id==" + id + "}.birthDate", equalTo(birthDate));
    }
}
