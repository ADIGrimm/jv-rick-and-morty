package mate.academy.rickandmorty.dto;

import java.util.List;
import lombok.Data;

@Data
public class ApiResponse {
    private Info info;
    private List<ApiDto> results;

    @Data
    public static class Info {
        private int count;
        private int pages;
        private String next;
        private String prev;
    }
}
