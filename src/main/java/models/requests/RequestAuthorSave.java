package models.requests;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RequestAuthorSave {
    private long id;
    private String first_name;
    private String family_name;
    private String second_name;
}
