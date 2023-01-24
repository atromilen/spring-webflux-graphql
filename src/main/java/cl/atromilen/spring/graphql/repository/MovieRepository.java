package cl.atromilen.spring.graphql.repository;

import cl.atromilen.spring.graphql.model.Movie;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import reactor.core.publisher.Flux;

public interface MovieRepository extends ReactiveSortingRepository<Movie, Integer> {
    Flux<Movie> findAllBy(Pageable pageable);
}
