package movie.api.movies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

// lets the framework know this class represents each object/movie in the collection movies
@Document(collection="movies")
@Data //getters and setters
@AllArgsConstructor  // makes a constructor with all the args
@NoArgsConstructor // no args constructor
public class Movie {
    // tells us this is the unique identifier for each movie
    @Id
    private ObjectId id;
    private String imdbId;
    private String title;
    private  String releaseDate;
    private String trailerLink;
    private String poster;
    private List<String> genres;
    private List<String> backdrops;
    @DocumentReference // only stores id of the reviews and the reviews are in a seperate collection
    private List<Review> reviewIds;
}
