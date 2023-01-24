package cl.atromilen.spring.graphql.service;

import cl.atromilen.spring.graphql.model.Director;
import cl.atromilen.spring.graphql.repository.DirectorRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@DirtiesContext
@Import(DirectorServiceImpl.class)
@ExtendWith(SpringExtension.class)
class DirectorServiceImplTest {

    @MockBean
    DirectorRepository repository;

    @Autowired
    @InjectMocks
    DirectorServiceImpl directorService;


    @Test
    void whenDirectorIsReturnedOnFindByNameShouldReturnDirector() {
        when(repository.findById(anyInt())).thenReturn(Mono.just(
                new Director(1, "Director 1")
        ));

        StepVerifier.create(directorService.findById(1))
                .assertNext(director -> {
                    Assertions.assertEquals(1, director.getDirectorId());
                    Assertions.assertEquals("Director 1", director.getName());
                })
                .verifyComplete();
    }

    @Test
    void whenNoDirectorIsReturnedInFindByNameShouldReturnEmpty() {
        when(repository.findById(anyInt())).thenReturn(Mono.empty());

        StepVerifier.create(directorService.findById(1))
                .expectNextCount(0)
                .verifyComplete();
    }
}
