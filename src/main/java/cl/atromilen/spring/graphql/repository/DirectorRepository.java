package cl.atromilen.spring.graphql.repository;

import cl.atromilen.spring.graphql.model.Director;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface DirectorRepository extends ReactiveCrudRepository<Director, Integer> {
    Mono<Director> findByName(String name);
}
