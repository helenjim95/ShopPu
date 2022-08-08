package de.tum.in.ase.eist.service;

import de.tum.in.ase.eist.model.PulloverStock;
import de.tum.in.ase.eist.repository.PulloverStockRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class PulloverStockService {
    private final PulloverStockRepository pulloverStockRepository;

    public PulloverStockService(PulloverStockRepository pulloverStockRepository) {
        this.pulloverStockRepository = pulloverStockRepository;
    }

    public PulloverStock save(PulloverStock pullover) {
        return pulloverStockRepository.save(pullover);
    }

    // TODO: Implement buy logic here
    public PulloverStock buyPullover(PulloverStock pullover) {
        pullover.setQuantity(pullover.getQuantity() - 1);
        return pullover;
    }

    // TODO: Implement retrieve logic using PulloverStockRepository
    public List<PulloverStock> getAllPullovers(boolean onlyAvailable) {
        if (onlyAvailable) {
            List<PulloverStock> pulloverStockList = pulloverStockRepository.findAll();
            List<PulloverStock> pulloverListFiltered = new ArrayList<>();
            for (PulloverStock stock : pulloverStockList) {
                if (stock.getQuantity() > 0) {
                    pulloverListFiltered.add(stock);
                }
            }
            return pulloverListFiltered;
        } else {
            return pulloverStockRepository.findAll();
        }
    }

    public Optional<PulloverStock> getById(Long pulloverId) {
        return pulloverStockRepository.findById(pulloverId);
    }
}
