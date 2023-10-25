package PostInfo;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import jdk.jfr.Description;
import models.responsesPositive.ResponseGetAllBooksXML;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.Specification;

import java.util.List;

@Epic("PostTests")
@Story("Positive tests")
public class GetAllBooksXMLTest {

    @DisplayName("Get all book in XML")
    @Description("Автор сохраняется, статус-код 201, в ответе возвращается id сохранённого автора")
    @Test
    @Disabled
    public void getAllBooksXMLTest(){
        List<ResponseGetAllBooksXML> listBooksXML = Specification.reqSpecGetAllBooksXML(1);
        //Не получается подать id в конструктор, постоянно ругается на то, что Required no arguments.
        //Не понял как с этими аннотациями правильно работать.
    }
}
