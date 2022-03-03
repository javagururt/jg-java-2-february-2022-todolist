package dto;

import java.util.List;
import java.util.Objects;

import core.validation.CoreError;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddToDoResponse {

    private Integer createdToDoId;
    private List<CoreError> errors;

}
