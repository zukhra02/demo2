package org.example.demo2.controller;

import org.example.demo2.model.Movie;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;

import java.util.List;

@RestController
@RequestMapping("/movies")

public class MovieController {

    private final List<Movie> movies = new ArrayList<>();

    private long counter = 0;

    @GetMapping

    public List<Movie> findAll() {
        return movies;
    }

    @PostMapping
    public Movie create(@RequestBody Movie movie) {
        movie.setId(++counter);
        movies.add(movie);
        return movie;
    }

    @PutMapping("/{id}")

    public Movie update( @PathVariable long id, @RequestBody Movie updateMovie) {
        Movie movie = movies.stream()
                .filter(m -> m.getId() == id)
                .findFirst()
                .orElse(null);
        if (movie == null){
            throw new ResponseStatusException(HttpStatusCode.valueOf(404));
        }
        movie.setTitle(updateMovie.getTitle());
        movie.setDirector(updateMovie.getDirector());
        movie.setYear(updateMovie.getYear());
        movie.setGenre(updateMovie.getGenre());
        movie.setLanguage(updateMovie.getLanguage());
        movie.setRevenue(updateMovie.getRevenue());
        movie.setAgelimitation(updateMovie.isAgelimitation());

        return movie;

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id) {
        Movie movie = movies.stream()
                .filter(m -> m.getId() == id)
                .findFirst()
                .orElse(null);

        if (movie != null) {
            movies.removeIf(m -> m.getId() == id);
            return;  // Si la película fue encontrada y eliminada, salir del método.
        }

        // Si no se encontró la película, lanzar una excepción con un mensaje claro.
        throw new ResponseStatusException(HttpStatusCode.valueOf(404));
    }
}





