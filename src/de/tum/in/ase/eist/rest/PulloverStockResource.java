package de.tum.in.ase.eist.rest;

import de.tum.in.ase.eist.model.PulloverStock;
import de.tum.in.ase.eist.service.PulloverStockService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestController
@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class PulloverStockResource {

    private final PulloverStockService pulloverStockService;

    private final String BASE_URL = "/api/pullovers";

    public PulloverStockResource(PulloverStockService pulloverStockService) {
        this.pulloverStockService = pulloverStockService;
    }

    // TODO: Implement createPulloverStock
    

    // TODO: Implement buyPullover
    

    // TODO: Implement getAllPulloverStocks
    
}
