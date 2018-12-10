package com.genre.withjpa.Controller;

import com.genre.withjpa.Service.GenreService;

import com.genre.withjpa.movieGenre;
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
    public List<movieGenre> getAll() {
        return genreService.getAllGenres();
    }

    @RequestMapping("/genre/{id}")
    public movieGenre getOne(@PathVariable String id) {
        return genreService.getGenre(id);
    }

    @RequestMapping(method= RequestMethod.POST, value="/genre")
    public void addGenre(@RequestBody movieGenre genre) {
        genreService.addGenre(genre);
        log.info("Adding Genre: "+ genre.getGenreName() );
    }

    @RequestMapping(method= RequestMethod.PUT, value="/genre/{id}")
    public void updateGenre(@RequestBody movieGenre genre, @PathVariable String id) {
        genreService.updateGenre(genre,id);
        log.info("Updating Genre: "+ genre.getGenreName() );
    }

    @RequestMapping(method= RequestMethod.DELETE, value="/genre/{id}")
    public void deleteGenre(@PathVariable String id) {
        genreService.deleteTeam(id);
        log.info("Deleting Genre: "+ id );
    }



    @RequestMapping("/csrf")
    public String token(){ return "{\"token\":\"fjsldfjsa\"}";}

}