package com.ryan.movie.controller;

import com.ryan.movie.movieGenre;
import com.ryan.movie.service.GenreService;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GenreController {
    @Autowired
    private GenreService genreService;
    private static Log log = LogFactory.getLog(GenreController.class);

    @RequestMapping("/genre")
    public List<movieGenre> getThanks() {
        return genreService.getAllGenres();
    }

    @RequestMapping("/genre/{id}")
    public movieGenre getTeam(@PathVariable String id) {
        return genreService.getGenre(id);
    }

    @RequestMapping(method=RequestMethod.POST, value="/genre")
    public void addTeam(@RequestBody movieGenre genre) {
        genreService.addGenre(genre);
        log.info("Adding Genre: "+ genre.getGenreName() );
    }


    @RequestMapping(method=RequestMethod.PUT, value="/genre/{id}")
    public void updateTeam(@RequestBody movieGenre genre, @PathVariable String id) {
        genreService.updateGenre(genre,id);
        log.info("Updating Genre: "+ genre.getGenreName() );
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/genre/{id}")
    public void deleteTeam(@PathVariable String id) {
        genreService.deleteTeam(id);
        log.info("Deleting Genre: "+ id );
    }

}