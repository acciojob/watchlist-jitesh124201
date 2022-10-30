package com.driver;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class MovieRepository {
    List<Movie> movies = new ArrayList<>();
    List<Director> directors = new ArrayList<>();

    // Map<String,Movie> dmap = new HashMap<>();
    //GetAll movies
    List<Movie> getAllMovieFromDb(){
        List<Movie> listMovies = new ArrayList<>();
        for(Movie mov:movies) {
            listMovies.add(mov);
        }
        return listMovies;
    }

    List<Director> getAllDirectorFromDb(){
        List<Director> listDirector = new ArrayList<>();
        for(Director dir:directors) {
            listDirector.add(dir);
        }
        return listDirector;
    }

    //ADd movies-create movies
    public void addmovieData(Movie mov){
        movies.add(mov);
    }

    public void addDirectorData(Director dir){
        directors.add(dir);
    }

    public List<Movie> getMovienameByDb(String name){
        List<Movie> nameMovie = new ArrayList<>();
        for(Movie mov:movies){
            if(mov.getName().equals(name)){
                nameMovie.add(mov);
            }
        }
        return nameMovie;
    }

    public List<Director> getDirectornameByDb(String name){
        List<Director> nameDirector = new ArrayList<>();
        for(Director dir:directors){
            if(dir.getName().equals(name)){
                nameDirector.add(dir);
            }
        }
        return nameDirector;
    }

    public void deleteDirectorByName(String name){
        for(int i=0;i<directors.size();i++){
            if(directors.get(i).getName().equals(name)){
                directors.remove(i);
            }
        }
    }

//    public void Addmapdata(Director dir,Movie mov){
//        dmap.put(dir.getName(),mov);
//    }
}
