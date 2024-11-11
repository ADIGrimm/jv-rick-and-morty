package mate.academy.rickandmorty.mapper;

import mate.academy.rickandmorty.dto.ApiDto;
import mate.academy.rickandmorty.dto.CharacterDto;
import mate.academy.rickandmorty.model.Character;
import org.springframework.stereotype.Component;

@Component
public class CharacterMapper {
    public CharacterDto toDto(Character character) {
        if (character == null) {
            return null;
        }
        CharacterDto characterDto = new CharacterDto();
        characterDto.setId(character.getId());
        characterDto.setName(character.getName());
        characterDto.setStatus(character.getStatus());
        characterDto.setGender(character.getGender());
        characterDto.setInternalId(character.getInternalId());
        return characterDto;
    }

    public Character toEntity(ApiDto apiDto) {
        if (apiDto == null) {
            return null;
        }
        Character character = new Character();
        character.setName(apiDto.getName());
        character.setStatus(apiDto.getStatus());
        character.setGender(apiDto.getGender());
        character.setInternalId(String.valueOf(apiDto.getId()));
        return character;
    }
}
