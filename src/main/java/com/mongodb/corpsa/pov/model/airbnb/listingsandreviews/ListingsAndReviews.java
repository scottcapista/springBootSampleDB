
package com.mongodb.corpsa.pov.model.airbnb.listingsandreviews;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;

import static org.springframework.data.mongodb.core.mapping.FieldType.DECIMAL128;


@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ListingsAndReviews {
    @Id String id;
    @Field("listing_url") @JsonProperty("listingUrl") String listing_url;
    @Field("name") String name;
    @Field("space") String space;
    @Field("description") String description;
    @Field("neighborhood_overview") @JsonProperty("neighborhoodOverview") String neighborhood_overview;
    @Field("notes") String notes;
    @Field("transit") String transit;
    @Field("access") String access;
    @Field("interaction") String interaction;
    @Field("house_rules") @JsonProperty("houseRules")String house_rules;
    @Field("property_type") @JsonProperty("propertyType") String property_type;
    @Field("room_type") @JsonProperty("roomType") String room_type;
    @Field("bed_type") @JsonProperty("bed_type") String bedType;
    @Field("minimum_nights") @JsonProperty("minimumNights") String minimum_nights;
    @Field("maximum_nights") @JsonProperty("maximumNights") String maximum_nights;
    @Field("cancellation_policy") @JsonProperty("cancellationPolicy") String cancellation_policy;

    @Field("last_scraped") @JsonProperty("lastScraped") Instant last_scraped;
    @Field("calendar_last_scraped") @JsonProperty("calendarLastScraped") Instant calendar_last_scraped;
    @Field("first_review") @JsonProperty("firstReview") Instant first_review;
    @Field("last_review") @JsonProperty("lastReview") Instant last_review;
    @Field("accommodates") Integer accommodates;
    @Field("bedrooms") Integer bedrooms;
    @Field("beds") Integer beds;
    @Field("number_of_reviews") @JsonProperty("numberOfReviews") Integer number_of_reviews;
    @Field(name = "bathrooms", targetType = DECIMAL128) BigDecimal bathrooms;
    @Field("amenities") ArrayList<String> amenities;
    @Field(name = "price", targetType = DECIMAL128) BigDecimal price;
    @Field(name = "security_deposit", targetType = DECIMAL128) @JsonProperty("securityDeposit") BigDecimal security_deposit;
    @Field(name = "cleaning_fee", targetType = DECIMAL128) @JsonProperty("cleaningFee") BigDecimal cleaning_fee;
    @Field(name = "extra_people", targetType = DECIMAL128) @JsonProperty("extraPeople") BigDecimal extra_people;
    @Field(name = "guests_included", targetType = DECIMAL128) @JsonProperty("guestsIncluded") BigDecimal guests_included;
    @Field("images") Images images;
    @Field("host") Host host;
    @Field("address") Address address;
    @Field("availability") Availability availability;
    @Field("review_scores") @JsonProperty("reviewScores") ReviewScores reviewScores;
    @Field("reviews") @JsonProperty("reviews") ArrayList<Review> reviews;
}
