package cl.atromilen.spring.graphql.controller;

import cl.atromilen.spring.graphql.model.Director;
import cl.atromilen.spring.graphql.model.Movie;
import cl.atromilen.spring.graphql.service.DirectorService;
import cl.atromilen.spring.graphql.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

@Controller
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;
    private final DirectorService directorService;

    @QueryMapping
    public Mono<Page<Movie>> getMoviesPaginated(@Argument int page, @Argument int size){
       return movieService.findAll(page, size);
    }

    @SchemaMapping
    public Mono<Director> director(Movie movie){
        return directorService.findById(movie.getDirector());
    }
}
