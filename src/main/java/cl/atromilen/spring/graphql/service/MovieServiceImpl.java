package cl.atromilen.spring.graphql.service;

import cl.atromilen.spring.graphql.model.Movie;
import cl.atromilen.spring.graphql.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {
    private final MovieRepository repository;

    @Override
    public Mono<Page<Movie>> findAll(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return repository.findAllBy(pageRequest)
                .collectList()
                .zipWith(this.repository.count())
                .map(t -> new PageImpl<>(t.getT1(), pageRequest, t.getT2()));
    }
}
