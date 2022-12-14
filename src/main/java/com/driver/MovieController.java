package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    MovieService movService;

    @GetMapping("/get-all-movies")
    public ResponseEntity findAllMovies(){
        return new ResponseEntity(movService.getAllMovie(),HttpStatus.OK);
    }

    @GetMapping("/get-all-director")
    public ResponseEntity findDirector(){
        return new ResponseEntity(movService.getAllDirector(),HttpStatus.OK);
    }

    @PostMapping("/add-movie")
    public ResponseEntity addMovie(@RequestBody() Movie movie){
        movService.addMovie(movie);
        return new ResponseEntity<>("Success",HttpStatus.CREATED);
    }

    @PostMapping("/add-director")
    public ResponseEntity addDirector(@RequestBody() Director director){
        movService.addDirector(director);
        return new ResponseEntity<>("Success",HttpStatus.CREATED);
    }

    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity getMovieByName(@PathVariable String name){
        return new ResponseEntity<>(movService.getMovieName(name),HttpStatus.ACCEPTED);
    }

    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity getDirectorByName(@PathVariable String name){
        return new ResponseEntity<>(movService.getDirectorName(name),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity deleteDirectorByName(@RequestParam String name){
        movService.deleteDirectorName(name);
        return new ResponseEntity<>("Success",HttpStatus.ACCEPTED);
    }
    @PutMapping("/add-movie-director-pair")
    public ResponseEntity addMovieDirectorPair(@RequestParam String moviename,@RequestParam String dirname){
        movService.pairdirmov(moviename,dirname);
        return new ResponseEntity<>("Success",HttpStatus.OK);
    }
    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable String dirname){
        return new ResponseEntity<>(movService.movieByDirname(dirname),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete-all-directors")
    public ResponseEntity deleteAllDirectors(){
        movService.deleteAllDirector();
        return new ResponseEntity<>("Success",HttpStatus.ACCEPTED);
    }

}
