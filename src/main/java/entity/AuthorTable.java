package entity;

import lombok.Data;
import lombok.Getter;

@Data
public class AuthorTable {
    @Getter
    private long id; //id автора в сервисе библиотеки (primary key)
    private String first_name; //50
    private String family_name; //50
    private String second_name; //50


}
