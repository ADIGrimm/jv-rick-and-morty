package mate.academy.rickandmorty.mapper;

import mate.academy.rickandmorty.config.MapperConfig;
import mate.academy.rickandmorty.dto.CharacterDto;
import mate.academy.rickandmorty.dto.CharacterExternalDto;
import mate.academy.rickandmorty.model.Character;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapperConfig.class)
public interface CharacterMapper {
    CharacterDto toDto(Character character);

    @Mapping(target = "internalId", expression = "java(generateInternalId(characterResponseDto))")
    Character toEntity(CharacterExternalDto characterResponseDto);

    default String generateInternalId(CharacterExternalDto dto) {
        return dto.getId() != null ? String.valueOf(dto.getId()) : "default-id";
    }
}
