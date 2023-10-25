package models.responsesPositive;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import entity.AuthorTable;
import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement(name="authors_books")
public class ResponseGetAllBooksXML {
    @XmlElement(name = "author", required=true)
    private AuthorTable author;
    @XmlElement(name = "book_title", required=true)
    private String bookTitle;
}

//<authors_books>
//
//    <books>
//
//        <book>
//
//            <author>
//
//                <id>3</id>
//
//                <first_name>Гузель</first_name>
//
//                <family_name>Яхина</family_name>
//
//            </author>
//
//            <book_title>Зулейха открывает глаза</book_title>
//
//        </book>
//
//    </books>
//
//</authors_books>