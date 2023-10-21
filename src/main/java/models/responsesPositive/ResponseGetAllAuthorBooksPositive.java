package models.responsesPositive;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import entity.BookTable;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseGetAllAuthorBooksPositive {
    private List<BookTable> books;
}
