package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository repository;

    public List<String> getAllMovie(){
        return repository.getAllMovieFromDb();
    }
    public List<Director> getAllDirector(){
        return repository.getAllDirectorFromDb();
    }


    public void addMovie(Movie movie){
         repository.addmovieData(movie);
    }

    public void addDirector(Director director){
        repository.addDirectorData(director);
    }

    public Movie getMovieName(String name){
        return repository.getMovienameByDb(name);
    }

    public Director getDirectorName(String name){
        return repository.getDirectornameByDb(name);
    }

    public void deleteDirectorName(String name){
         repository.deleteDirectorByName(name);
    }
    public void pairdirmov(String moviename,String dirname){
        repository.pairDirectorMovie(moviename,dirname);
    }

    public List<String> movieByDirname(String dirname){
        return repository.getMoviesByDirnameDb(dirname);
    }
//
    public void deleteAllDirector(){
        repository.deleteAllDirector();
    }

}
