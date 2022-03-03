package dto;

import lombok.Data;

@Data
public class UpdateToDoRequest {

    private Integer id;
    private String name;
    private String description;
}
