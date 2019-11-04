package com.example.whatever.countries;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data")
public class CountryEnpointsRestController {

    @GetMapping(value ="/allCountries",
    produces = {"application/json"})
    public ResponseEntity<?> getAllCountries()
    {
        CountriesApplication.ourCountriesList.countryList.sort(
                (c1,c2)->c1.getName().compareToIgnoreCase(c2.getName()));
                return new ResponseEntity<>(CountriesApplication.ourCountriesList.countryList, HttpStatus.OK);

    }


}
