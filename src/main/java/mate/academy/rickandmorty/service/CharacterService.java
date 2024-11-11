package mate.academy.rickandmorty.service;

import java.util.List;
import mate.academy.rickandmorty.dto.ApiDto;
import mate.academy.rickandmorty.dto.CharacterDto;

public interface CharacterService {
    CharacterDto getRandomCharacter();

    CharacterDto getCharacterById(Long id);

    List<ApiDto> fetchAllCharacters();

    void saveAllCharactersToDb();
}
