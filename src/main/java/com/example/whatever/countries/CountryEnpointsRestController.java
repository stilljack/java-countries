package com.example.whatever.countries;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;

@RestController
@RequestMapping("/data")
public class CountryEnpointsRestController {

    @GetMapping(value ="/allCountries",
    produces = {"application/json"})
    public ResponseEntity<?> getAllCountries()
    {
        CountriesApplication.ourCountriesList.countryList.sort(
                getAlphabetizer());
                return new ResponseEntity<>(CountriesApplication.ourCountriesList.countryList, HttpStatus.OK);

    }

    @GetMapping(value = "/countries/{letter}",
    produces = {"application/json"})
    public ResponseEntity<?> getCountriesByFirstLetter (@PathVariable char letter)
    {
        ArrayList<Country> rtnCountries = CountriesApplication.ourCountriesList.findCountries(
                c-> c.getName().toUpperCase().charAt(0)
                            ==
                        Character.toUpperCase(letter)
        );

        rtnCountries.sort(getAlphabetizer());
        return new ResponseEntity<>(rtnCountries,HttpStatus.OK);
    }
    

/*
 /names/size/{number}
return the countries alphabetically that have a name equal to or longer than the given length
/population/size/{people}
*/

@GetMapping(value = "/countries/bynamelength/{length}",
produces ={"application/json"})
    public ResponseEntity<?> getCountriesByNameLength (@PathVariable int length)
{
    ArrayList<Country> rtnCountries = CountriesApplication.ourCountriesList.findCountries(
            c-> c.getName().length()
                    >=
                    length
    );

    rtnCountries.sort(getAlphabetizer());
    return new ResponseEntity<>(rtnCountries,HttpStatus.OK);
    
    
    
    
}

    private Comparator<Country> getAlphabetizer() {
        return (c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName());
    }


/*
return the countries that have a population equal to or greater than the given population
/population/min

return the country with the smallest population
/population/max

return the country with the largest population
    Stretch Goal

/population/median
return the country with the median population
/age/age/{age}

return the countries that have a median age equal to or greater than the given age
/age/min

return the country with the smallest median age
/age/max

return the country the the greatest median age
    Stretch Goal

/age/median
return the country with the median median age*/

}
