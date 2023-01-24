package cl.atromilen.spring.graphql.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Movie {
    private Integer movieId;
    private String name;
    private Integer year;
    private Integer director;
}
