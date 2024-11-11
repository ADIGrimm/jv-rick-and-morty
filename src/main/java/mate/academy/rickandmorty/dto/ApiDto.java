package mate.academy.rickandmorty.dto;

import lombok.Data;

@Data
public class ApiDto {
    private int id;
    private String name;
    private String status;
    private String species;
    private String type;
    private String gender;
    private OriginDto origin;
    private LocationDto location;
    private String image;
    private String url;
    private String created;

    @Data
    public static class OriginDto {
        private String name;
        private String url;
    }

    @Data
    public static class LocationDto {
        private String name;
        private String url;
    }
}
