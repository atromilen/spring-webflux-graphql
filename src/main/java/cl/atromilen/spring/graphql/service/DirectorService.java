package cl.atromilen.spring.graphql.service;

import cl.atromilen.spring.graphql.model.Director;
import reactor.core.publisher.Mono;

public interface DirectorService {
    Mono<Director> findById(Integer id);
}
