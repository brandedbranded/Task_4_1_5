package models.requests;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import models.BookSaveAuthorExmp.BookSaveAuthorExmp;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RequestBookSave {
    private String bookTitle;
    private BookSaveAuthorExmp author;
    private long authorId;
}
