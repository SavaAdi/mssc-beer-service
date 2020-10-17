package guru.springframework.msscbeerservice.services.order;

import guru.sfg.brewery.model.events.BeerOrderDto;
import guru.springframework.msscbeerservice.repositories.BeerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Log4j2
@RequiredArgsConstructor
@Component
public class BeerOrderValidator {

    private final BeerRepository beerRepository;

    public Boolean validateOrder(BeerOrderDto beerOrderDto){
        AtomicInteger beersNotFound = new AtomicInteger();

        beerOrderDto.getBeerOrderLines().forEach(beerOrderLineDto -> {
            if(beerRepository.findByUpc(beerOrderLineDto.getUpc()) == null){
                beersNotFound.incrementAndGet();
            }
        });

        return beersNotFound.get() == 0;
    }
}
