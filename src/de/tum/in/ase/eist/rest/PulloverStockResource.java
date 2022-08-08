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
    @PostMapping("pullover")
    public ResponseEntity<PulloverStock> createPulloverStock(@RequestBody PulloverStock stock) {
        if (stock.getId() != null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(pulloverStockService.save(stock));
    }
    

    // TODO: Implement buyPullover
    @PutMapping("pullover/{stockId}")
    public ResponseEntity<PulloverStock> buyPullover(@RequestBody PulloverStock stock, @PathVariable("stockId") Long id) {
        if (!stock.getId().equals(id)) {
            return ResponseEntity.notFound().build();
        } else if (stock.getQuantity() == 0) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(pulloverStockService.buyPullover(stock));
    }

    // TODO: Implement getAllPulloverStocks
    @GetMapping("pullover")
    public ResponseEntity<List<PulloverStock>> getAllPulloverStocks(@RequestParam(defaultValue = "false", required = false) boolean onlyAvailable) {
        if (!onlyAvailable) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(pulloverStockService.getAllPullovers(onlyAvailable));
    }





    
}
