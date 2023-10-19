package entity;

import lombok.Data;

@Data
public class BookTable {
    private long id; //id автора в сервисе библиотеке (primary key)
    private String book_title; //100
    private long author_id; //id автора из таблицы Author (foreign key)
}
