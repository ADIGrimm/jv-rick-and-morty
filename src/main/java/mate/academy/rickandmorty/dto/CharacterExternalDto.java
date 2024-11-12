package mate.academy.rickandmorty.dto;

import lombok.Data;

@Data
public class CharacterExternalDto {
    private Long id;
    private String name;
    private String status;
    private String gender;
}
