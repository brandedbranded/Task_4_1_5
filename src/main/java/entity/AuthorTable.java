package entity;

import lombok.Data;

@Data
public class AuthorTable {
    private long id;
    private String firstName;
    private String familyName;
    private String secondName;
}
