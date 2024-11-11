package mate.academy.rickandmorty.service.impl;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import mate.academy.rickandmorty.dto.ApiDto;
import mate.academy.rickandmorty.dto.ApiResponse;
import mate.academy.rickandmorty.dto.CharacterDto;
import mate.academy.rickandmorty.mapper.CharacterMapper;
import mate.academy.rickandmorty.model.Character;
import mate.academy.rickandmorty.repository.CharacterRepository;
import mate.academy.rickandmorty.service.CharacterService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class CharacterServiceImpl implements CharacterService {
    public static final Long CHARACTER_MAX = 826L;
    private final CharacterMapper characterMapper;
    private final CharacterRepository characterRepository;
    private final RestTemplate restTemplate;

    @Override
    public CharacterDto getRandomCharacter() {
        Random random = new Random();
        return getCharacterById(random.nextLong(CHARACTER_MAX) + 1);
    }

    @Override
    public CharacterDto getCharacterById(Long id) {
        return characterMapper.toDto(characterRepository.findById(id).orElseThrow(()
                        -> new EntityNotFoundException("Can't find character by id " + id)));
    }

    @Override
    public List<ApiDto> fetchAllCharacters() {
        String url = "https://rickandmortyapi.com/api/character?page=";
        List<ApiDto> allCharacters = new ArrayList<>();
        int page = 1;
        ApiResponse response;

        do {
            ResponseEntity<ApiResponse> apiResponse = restTemplate
                    .getForEntity(url + page, ApiResponse.class);
            response = apiResponse.getBody();
            if (response != null && response.getResults() != null) {
                allCharacters.addAll(response.getResults());
            }
            page++;
        } while (response != null && response.getInfo().getNext() != null);

        return allCharacters;
    }

    @PostConstruct
    @Override
    public void saveAllCharactersToDb() {
        List<ApiDto> characters = fetchAllCharacters();
        List<Character> characterEntities = characters.stream()
                .map((ApiDto characterDto) -> characterMapper.toEntity(characterDto))
                .collect(Collectors.toList());
        characterRepository.saveAll(characterEntities);
    }
}
