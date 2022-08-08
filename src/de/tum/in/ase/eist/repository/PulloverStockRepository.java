package de.tum.in.ase.eist.repository;

import de.tum.in.ase.eist.model.PulloverStock;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class PulloverStockRepository {

    private final List<PulloverStock> pulloverStocks = new ArrayList<>();

    // TODO: Implement retrieve logic here

    public List<PulloverStock> findAll() {
        return pulloverStocks;
    }

    public PulloverStock save(PulloverStock pulloverStock) {
        if (pulloverStock.getId() == null) {
            UUID uuid = UUID.randomUUID();
            pulloverStock.setId(uuid.getMostSignificantBits());
        } else {
            pulloverStocks.removeIf(stock -> stock.getId().equals(pulloverStock.getId()));
        }
        pulloverStocks.add(pulloverStock);

        return pulloverStock;
    }

    public Optional<PulloverStock> findById(Long id) {
        return pulloverStocks.stream().filter(stock -> id.equals(stock.getId())).findFirst();
    }
}
