package com.ryan.movie.service;

import com.ryan.movie.movieGenre;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class GenreService {

        private List<movieGenre> genres = new ArrayList<>(Arrays.asList(
                new movieGenre("Comedy", "Good"),
                new movieGenre("Drama", "Ok"),
                new movieGenre("Thriller", "Good"),
                new movieGenre("Action", "Like")
        ));

        public List<movieGenre> getAllGenres() {
            return genres;
        }

        public movieGenre getGenre(String id) {
            return genres.stream().filter(t -> t.getGenreName().contains(id)).findFirst().get();
        }

        public void addGenre(movieGenre genre) {
            genres.add(genre);
        }

        public void updateGenre(movieGenre genre, String id) {
            //genres.add(genre);
            for(int i=0;i < genres.size() ;i++) {
                movieGenre t = genres.get(i);
                if (t.getGenreName().equals(id)) {
                    genres.set(i,genre);
                    return;
                }
            }
        }

        public void deleteTeam(String id) { genres.removeIf(t -> t.getGenreName().equals(id)); }
}