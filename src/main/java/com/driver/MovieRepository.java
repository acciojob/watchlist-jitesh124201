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

    Map<Movie,Director> dmap = new HashMap<>();
    //GetAll movies
    List<String> getAllMovieFromDb(){
        List<String> listMovies = new ArrayList<>();
        for(Movie mov:movies) {
            listMovies.add(mov.getName());
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

    public Movie getMovienameByDb(String name){

        for(Movie mov:movies){
            if(mov.getName().equals(name)){
                return mov;
            }
        }
        return null;
    }

    public Director getDirectornameByDb(String name){
        for(Director dir:directors){
            if(dir.getName().equals(name)){
                return dir;
            }
        }
        return null;
    }

    public void deleteDirectorByName(String name){
        for(int i=0;i<directors.size();i++){
            if(directors.get(i).getName().equals(name)){
                directors.remove(i);
            }
        }
    }

    public void pairDirectorMovie(String moviename,String directorname){
        dmap.put(getMovienameByDb(moviename),getDirectornameByDb(directorname));
    }

    public List<String> getMoviesByDirnameDb(String name){
        List<String> listofmovies = new ArrayList<>();
        for(Map.Entry<Movie,Director> entry:dmap.entrySet()){
            if(entry.getValue().getName().equals(name)){
                listofmovies.add(entry.getKey().getName());
            }
        }
        return listofmovies;
    }

    public void deleteAllDirector() {
        for(Map.Entry<Movie,Director> entry: dmap.entrySet()){
            dmap.remove(entry.getKey());
        }
    }

}
