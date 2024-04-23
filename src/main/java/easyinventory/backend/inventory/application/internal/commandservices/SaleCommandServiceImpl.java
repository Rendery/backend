package easyinventory.backend.inventory.application.internal.commandservices;

import easyinventory.backend.inventory.domain.model.aggregates.Sale;
import easyinventory.backend.inventory.domain.model.commands.CreateSaleCommand;
import easyinventory.backend.inventory.domain.model.commands.DeleteSaleCommand;
import easyinventory.backend.inventory.domain.model.commands.UpdateSaleCommand;
import easyinventory.backend.inventory.domain.services.SaleCommandService;
import easyinventory.backend.inventory.infrastructure.persistence.jpa.repositories.SaleRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SaleCommandServiceImpl implements SaleCommandService {

    private final SaleRepository saleRepository;

    public SaleCommandServiceImpl(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    @Override
    public Long handle(CreateSaleCommand command) {
        var sale = new Sale(command.name(), command.saleDate(), command.totalCost());
        saleRepository.save(sale);
        return sale.getId();
    }

    @Override
    public Optional<Sale> handle(UpdateSaleCommand command) {
        var saleToUpdate = saleRepository.findByName(command.name()).orElseThrow(() -> new RuntimeException("Sale not found"));
        if(command.saleDate() != null)
            saleToUpdate.setSaleDate(command.saleDate());
        if(command.totalCost() != null)
            saleToUpdate.setTotalCost(command.totalCost());
        saleRepository.save(saleToUpdate);
        return Optional.of(saleToUpdate);
    }

    @Override
    public Long handle(DeleteSaleCommand command) {
        var sale = saleRepository.findByName(command.name()).orElseThrow(() -> new RuntimeException("Sale not found"));
        saleRepository.delete(sale);
        return sale.getId();
    }
}
