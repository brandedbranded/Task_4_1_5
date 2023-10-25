package PostInfo;


import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import jdk.jfr.Description;
import models.responsesPositive.ResponseAuthorSave;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.Specification;
import steps.assertForTest.AssertSaveAuthor;

@Epic("PostTests")
@Story("Positive tests")
public class SaveAuthorTest {

    @DisplayName("New author save")
    @Description("Автор сохраняется, статус-код 201, в ответе возвращается id сохранённого автора")
    @Test
    public void saveAuthorTest() {
        ResponseAuthorSave author = Specification.reqSpecSaveAuthor("ifefef", "efojf", "fpiehf");
        AssertSaveAuthor.verifySaveAuthorResponse(author);
    }
}
