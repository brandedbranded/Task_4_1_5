package models.requests;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import models.BookSaveAuthorExmp;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RequestBookSave {
    private String book_title;
    private BookSaveAuthorExmp author;
    private long authorId;
}
