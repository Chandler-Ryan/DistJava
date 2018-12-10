package com.genre.withjpa.Service;

import com.genre.withjpa.GenreRepository;
import com.genre.withjpa.movieGenre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class GenreService {

    @Autowired
    private GenreRepository genreRepository;

    /* Replace by DB
    private List<movieGenre> genres = new ArrayList<>(Arrays.asList(
            new movieGenre("Comedy", "Good"),
            new movieGenre("Drama", "Ok"),
            new movieGenre("Thriller", "Good"),
            new movieGenre("Action", "Like")
    ));
    */

    public List<movieGenre> getAllGenres() {
        List<movieGenre> genres = new ArrayList<>();
        genreRepository.findAll().forEach(genres::add);
        if (genres.size() == 0) {
            genreRepository.save(new movieGenre("Comedy", "Good"));
            genreRepository.save(new movieGenre("Drama", "Ok"));
            genreRepository.save(new movieGenre("Thriller", "Good"));
            genreRepository.save(new movieGenre("Action", "Like"));
            genreRepository.findAll().forEach(genres::add);
        }
        return genres;
    }

    public movieGenre getGenre(String id) {
        return genreRepository.findById(id).orElse(new movieGenre("Missing Genre", "NA"));
        //return genres.stream().filter(t -> t.getGenreName().contains(id)).findFirst().get();
    }

    public void addGenre(movieGenre genre) {
        genreRepository.save(genre);
        //genres.add(genre);
    }

    public void updateGenre(movieGenre genre, String id) {
        genreRepository.save(genre);
        /*
         for(int i=0;i < genres.size() ;i++) {
            movieGenre t = genres.get(i);
            if (t.getGenreName().equals(id)) {
                genres.set(i,genre);
                return;
            }
        }
        */
    }

    public void deleteTeam(String id) {
        genreRepository.delete(getGenre(id));
        //genres.removeIf(t -> t.getGenreName().equals(id));
    }
}