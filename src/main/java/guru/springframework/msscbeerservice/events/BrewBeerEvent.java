package guru.springframework.msscbeerservice.events;

import guru.springframework.msscbeerservice.web.model.BeerDto;

public class BrewBeerEvent extends BeerEvent {


    BrewBeerEvent(BeerDto beerDto) {
        super(beerDto);
    }
}
