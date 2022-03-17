package com.mongodb.corpsa.pov;

import com.mongodb.corpsa.pov.repositories.airbnb.AirbnbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

@SpringBootApplication
public class SpringBootBase implements CommandLineRunner {

    @Autowired
    AirbnbRepository airbnbRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootBase.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        /*
        ListingsAndReviews listingsAndReviews =
                new ListingsAndReviews("123456789","url","testing name","space","testing");
        airbnbRepository.save(listingsAndReviews);
*/
    }
}
