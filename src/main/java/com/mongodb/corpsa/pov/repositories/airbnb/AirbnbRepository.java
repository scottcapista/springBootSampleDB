package com.mongodb.corpsa.pov.repositories.airbnb;

import com.mongodb.corpsa.pov.model.airbnb.aggregations.ListingsByLocation;
import com.mongodb.corpsa.pov.model.airbnb.listingsandreviews.ListingsAndReviews;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;


@Repository
public interface AirbnbRepository {
    ListingsAndReviews getOneListing();
    ArrayList<ListingsByLocation> getListings(int skip, int limit, int distance);
    ListingsAndReviews getOneListing(String id);
    void save(ListingsAndReviews listingsAndReviews);
}