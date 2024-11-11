package mate.academy.rickandmorty.dto;

import lombok.Data;

@Data
public class CharacterDto {
    private Long id;
    private String internalId;
    private String name;
    private String status;
    private String gender;
}
