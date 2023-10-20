package models.requests;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RequestAuthorSave {
    private long id;
    private String firstName;
    private String familyName;
    private String secondName;
}
