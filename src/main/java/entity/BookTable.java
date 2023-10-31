package entity;

import lombok.Data;

import java.util.Date;

@Data
public class BookTable {
    private long id;
    private final String bookTitle;
    private long authorId;
    private Date updated;
}
