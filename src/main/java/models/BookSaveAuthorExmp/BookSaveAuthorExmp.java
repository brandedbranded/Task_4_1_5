package models.BookSaveAuthorExmp;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="author")
public class BookSaveAuthorExmp {
    @XmlElement(name = "author_id", required=true)
    private long id;
}
