package com.mongodb.corpsa.pov.repositories.airbnb;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.corpsa.pov.model.airbnb.aggregations.ListingsByLocation;
import com.mongodb.corpsa.pov.model.airbnb.listingsandreviews.ListingsAndReviews;
import org.bson.Document;
import org.springframework.stereotype.Repository;
import org.w3c.dom.views.DocumentView;

import javax.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.Arrays;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;


@Repository
public class AirbnbRepositoryImpl implements AirbnbRepository {

    private final MongoClient mongoClient;
    private MongoCollection<ListingsAndReviews> listingsAndReviewsColl;
    private MongoCollection<ListingsByLocation> listingsAndReviewsCollByLocation;

    public AirbnbRepositoryImpl(MongoClient mongoClient) {
        this.mongoClient = mongoClient;
    }

    @PostConstruct
    void init(){
        MongoDatabase db = mongoClient.getDatabase("sample_airbnb");
        listingsAndReviewsColl = db.getCollection("listingsAndReviews", ListingsAndReviews.class);
        listingsAndReviewsCollByLocation = db.getCollection("listingsAndReviews", ListingsByLocation.class);
    }

    @Override
    public ListingsAndReviews getOneListing() {
        return listingsAndReviewsColl
                .find()
                .first();
    }

    @Override
    public ListingsAndReviews getOneListing(String id){
        return listingsAndReviewsColl
                .find(new Document("_id",id))
                .first();
    }

    @Override
    public ArrayList<ListingsByLocation> getListings(int skip, int limit, int distance) {
        ArrayList<ListingsByLocation> retListingsAndReviews = new ArrayList<>();
        AggregateIterable<ListingsByLocation> result = listingsAndReviewsCollByLocation.aggregate(
                Arrays.asList(new Document("$geoNear",
                        new Document("near",
                                new Document("type", "Point")
                                        .append("coordinates", Arrays.asList(-73.9664d, 40.714d)))
                                .append("distanceField", "distance.calculated")
                                .append("maxDistance", distance)
                                .append("query",
                                        new Document())
                                //.append("includeLocs", "distance.location")
                                .append("spherical", true)
                                .append("key", "address.location")),
                new Document("$project",
                        new Document("_id", 1)
                                .append("listing_url", 1)
                                .append("name", 1)
                                .append("bedrooms", 1)
                                .append("images", 1)
                                .append("address", 1)
                                .append("accommodates", 1)
                                .append("distance", 1)
                                .append("isSuperhost", "$host.host_is_superhost")),
                new Document("$skip", skip),
                new Document("$limit", limit))
        );
        result.forEach(retListingsAndReviews::add);
        return retListingsAndReviews;
    }

    @Override
    public void save(ListingsAndReviews listingsAndReviews) {
        listingsAndReviewsColl.insertOne(listingsAndReviews);
    }
}
