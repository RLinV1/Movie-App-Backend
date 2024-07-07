package movie.api.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MongoTemplate mongoTemplate;



    public Review createReview(String reviewBody, String imdbId){
        // this is the same as making a new review object and doing
        // reviewRepository.insert(review)
        Review review = reviewRepository.insert(new Review(reviewBody ,imdbId));

        // we are using the mongoTemplate to perform an update call on the movie class
        // look what movie we are matching based on imdbId and apply this update to push the value
        // review into reviewIds.
        // first ensures only one movie is updated
        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(review))
                .first();

        return review;
    }
    public List<Review> singleReview(String id){
        return reviewRepository.findReviewsByImdbId(id);
    }
}
