package models.requests;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import models.BookSaveAuthorExmp.BookSaveAuthorExmp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
//@XmlRootElement(name="author")
@XmlAccessorType(XmlAccessType.FIELD)

public class RequestGetAllBooksXML {
    //@XmlElement(name = "author", required=true)
    private BookSaveAuthorExmp author;
    /*@XmlElement(name = "author_id", required=true)
    private long id;*/
}

//<author>
//    <author_id>2</author_id>
//</author>