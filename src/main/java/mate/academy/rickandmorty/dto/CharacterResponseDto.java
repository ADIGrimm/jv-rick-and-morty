package mate.academy.rickandmorty.dto;

import java.util.List;
import java.util.Map;
import lombok.Data;

@Data
public class CharacterResponseDto {
    private Map<String, Object> info;
    private List<CharacterExternalDto> results;
}
