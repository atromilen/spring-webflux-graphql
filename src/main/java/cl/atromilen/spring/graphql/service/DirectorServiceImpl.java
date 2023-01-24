package cl.atromilen.spring.graphql.service;

import cl.atromilen.spring.graphql.model.Director;
import cl.atromilen.spring.graphql.repository.DirectorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class DirectorServiceImpl implements DirectorService {

    private final DirectorRepository repository;

    @Override
    public Mono<Director> findById(Integer id) {
        return repository.findById(id);
    }
}
