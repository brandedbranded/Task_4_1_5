package entity;

import lombok.Data;
import lombok.Getter;

@Data
public class AuthorTable {

    @Getter
    private long id;
    private String firstName;
    private String familyName;
    private String secondName;
}
