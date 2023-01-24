package cl.atromilen.spring.graphql.service;

import cl.atromilen.spring.graphql.model.Movie;
import org.springframework.data.domain.Page;
import reactor.core.publisher.Mono;

public interface MovieService {

    Mono<Page<Movie>> findAll(int page, int size);

}
