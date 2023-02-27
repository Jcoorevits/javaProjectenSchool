package com.example.watchlist.controller;
import com.example.watchlist.model.Watchlist;
import com.example.watchlist.repository.WatchListRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/watchlist")

public class WatchListRestController {

    final
    WatchListRepository watchListRepository;

    public WatchListRestController(WatchListRepository watchListRepository) {
        this.watchListRepository = watchListRepository;
    }

    @GetMapping("/movies")
    public List<Watchlist> showWatchList() {
        return watchListRepository.findAll();
    }

    @PostMapping("/movies")
    public Watchlist addMovie(@RequestBody Watchlist watchlist) {
        return watchListRepository.save(watchlist);
    }

    @DeleteMapping("/movies/{id}")
    public ResponseEntity<Integer> deleteMovie(@PathVariable("id") long movieId) {
        Optional<Watchlist> movie1 = watchListRepository.findById(movieId);
        if (movie1.isPresent()) {
            Watchlist movie = movie1.get();
            watchListRepository.delete(movie);
            return new ResponseEntity<>(watchListRepository.findAll().size(), HttpStatus.OK);

        }
        return new ResponseEntity<>(watchListRepository.findAll().size(), HttpStatus.NOT_FOUND);
    }

    @PutMapping("/movies/{id}")
    public ResponseEntity<Watchlist> editTraining(@RequestBody Watchlist updateMovie, @PathVariable("id") long movieId) {
        Optional<Watchlist> movie1 = watchListRepository.findById(movieId);
        if (movie1.isPresent()) {
            Watchlist movie = movie1.get();
            movie.setMovieId(updateMovie.getMovieId());
            movie.setViewed(updateMovie.isViewed());
            movie.setDescription(updateMovie.getDescription());
            movie.setRating(updateMovie.getRating());
            watchListRepository.save(movie);
            return new ResponseEntity<>(movie, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
