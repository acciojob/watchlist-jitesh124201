package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository repository;

    public List<Movie> getAllMovie(){
        return repository.getAllMovieFromDb();
    }
    public List<Director> getAllDirector(){
        return repository.getAllDirectorFromDb();
    }

//    public void adddirMov(Director name,Movie mov){
//        repository.Addmapdata(name,mov);
//    }

    public void addMovie(Movie movie){
         repository.addmovieData(movie);
    }

    public void addDirector(Director director){
        repository.addDirectorData(director);
    }

    public List<Movie> getMovieName(String name){
        return repository.getMovienameByDb(name);
    }

    public List<Director> getDirectorName(String name){
        return repository.getDirectornameByDb(name);
    }

    public void deleteDirectorName(String name){
         repository.deleteDirectorByName(name);
    }

}
