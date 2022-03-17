package com.mongodb.corpsa.pov.controller.airbnb;

import com.mongodb.corpsa.pov.model.airbnb.aggregations.ListingsByLocation;
import com.mongodb.corpsa.pov.model.airbnb.listingsandreviews.ListingsAndReviews;
import com.mongodb.corpsa.pov.model.airbnb.response.ResponseObject;
import com.mongodb.corpsa.pov.repositories.airbnb.AirbnbRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/airbnb")
public class AirbnbRestController {

    private final static Logger LOGGER = LoggerFactory.getLogger(AirbnbRestController.class);
    private final AirbnbRepository airbnbRepository;

    public AirbnbRestController(AirbnbRepository airbnbRepository) {
        this.airbnbRepository = airbnbRepository;
    }

    @GetMapping(value = "/listings/")
    public ListingsAndReviews getOneListing(HttpServletRequest request){
        LOGGER.info("Method -> " + stackWalker() + " : " + request.getRequestURI());
        return airbnbRepository.getOneListing();
    }

    @GetMapping(value = "/listings/{id}")
    public ListingsAndReviews getOneListing(HttpServletRequest request, @PathVariable(value = "id") String id){
        LOGGER.info("Method -> " + stackWalker() + " : " + request.getRequestURI());
        return airbnbRepository.getOneListing(id);
    }

    @GetMapping(value = "/listings/location/{page}/")
    public ResponseEntity<ResponseObject> getListings(HttpServletRequest request, @PathVariable(value = "page") int page){
        int startPage, endPage;
        LOGGER.info("Method -> " + stackWalker() + " : " + request.getRequestURI());
        ResponseObject responseObject = new ResponseObject(request.getRequestURI());
        if (page == 0){
            startPage = 0;
            endPage = 20;
        } else {
            startPage = page * 20;
            endPage = startPage + 20;
        }
        try {
            ArrayList<ListingsByLocation> tmpAirbnbRepository =
                    airbnbRepository.getListings(startPage, endPage, 10000);
            responseObject.setResponse(200, "Success", tmpAirbnbRepository);
        } catch (Exception rte) {
            rte.printStackTrace();
            return new ResponseEntity<>(
                    responseObject.setResponse(500,"Server Failure"),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
        return new ResponseEntity<>(responseObject, HttpStatus.OK);
    }


    private String stackWalker(){
        StackWalker walker = StackWalker.getInstance();
        Optional<String> methodName = walker.walk(frames -> frames
                .skip(1)
                .findFirst()
                .map(StackWalker.StackFrame::getMethodName));
        return methodName.get();
    }
}
