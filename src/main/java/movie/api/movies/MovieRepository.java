package movie.api.movies;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


// allows spring to connect with the database and do all basic crud applications
@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {

    // no need to write the method since the mongodb will know what to do. Should be spelled correctly
    Optional<Movie> findMovieByImdbId(String imdbId);

}
