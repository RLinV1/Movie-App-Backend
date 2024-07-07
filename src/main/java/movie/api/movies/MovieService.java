package movie.api.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired // instantiates the class MovieRepository
    private MovieRepository movieRepository;
    public List<Movie> allMovies(){
        System.out.println(movieRepository.findAll());
        return movieRepository.findAll();

    }

    // In casae it doesn't find the movie
//    public Optional<Movie> singleMovie(ObjectId id){
//        return movieRepository.findById(id);
//    }
    public Optional<Movie> singleMovie(String imdbId){
        return movieRepository.findMovieByImdbId(imdbId);
    }
}
