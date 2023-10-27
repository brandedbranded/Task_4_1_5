package postInfo;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import jdk.jfr.Description;
import models.responsesPositive.ResponseBookSave;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.Specification;
import steps.assertForTest.AssertSaveBook;

@Epic("PostTests")
@Story("saveNewBook")
public class SaveBookTest {
    @DisplayName("New book save")
    @Description("Книга сохраняется, статус-код 201, в ответе возвращается id сохранённой книги")
    @Test
    public void saveBookTest(){
        ResponseBookSave book = Specification.reqSpecSaveBook("BookNewBook", 2);
        AssertSaveBook.verifySaveBookResponse(book);
    }
}
