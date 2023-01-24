package cl.atromilen.spring.graphql.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
public class Director {
    /* @Id is necessary to avoid error 'Required identifier property not found for class...'. This happens in Postgres
    independently of use only 'spring-boot-starter-data-r2dbc' without mixing with regular spring starter-data */
    @Id
    private Integer directorId;
    private String name;
}
