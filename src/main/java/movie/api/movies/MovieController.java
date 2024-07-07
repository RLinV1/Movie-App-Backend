package movie.api.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//REST API
@RestController
@RequestMapping("api/v1/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping // shorthand for a get request
    public ResponseEntity<List<Movie>> getAllMovies(){
        // We can return a string but this allows us to return a http status
        // good for working on frontend application and good convention
        return new ResponseEntity<List<Movie>>(movieService.allMovies(), HttpStatus.OK);
    }

    // This uses objectId but sometimes you don't want that to be in the public
//    @GetMapping("/{id}")
//    public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable ObjectId id){
//        return new ResponseEntity<Optional<Movie>>(movieService.singleMovie(id), HttpStatus.OK);
//    }
    // uses imdb id
    @GetMapping("/{imdb}")
    public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable String imdb){
        return new ResponseEntity<Optional<Movie>>(movieService.singleMovie(imdb), HttpStatus.OK);
    }



}
