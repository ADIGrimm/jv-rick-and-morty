package mate.academy.rickandmorty.service;

import java.util.List;
import mate.academy.rickandmorty.dto.CharacterDto;
import mate.academy.rickandmorty.dto.CharacterExternalDto;

public interface CharacterService {
    CharacterDto getRandomCharacter();

    CharacterDto getCharacterById(Long id);

    List<CharacterExternalDto> fetchAllCharacters();

    void saveAllCharactersToDb();
}
