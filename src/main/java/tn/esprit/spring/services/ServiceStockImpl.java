package tn.esprit.spring.services;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.Stock;
import tn.esprit.spring.repository.StockRepository;

import java.util.ArrayList;
import java.util.List;
@Slf4j
@Service
public class ServiceStockImpl implements IServiceStock{
    @Autowired
    StockRepository repository;
    @Override
    public List<Stock> retrieveAllStocks() {
        List<Stock>stocks=new ArrayList<Stock>();
        repository.findAll().forEach(stock -> {
            stocks.add(stock);
        });

        return stocks;
    }

    @Override
    public Stock addStock(Stock s) {
        return repository.save(s);
    }

    @Override
    public Stock updateStock(Stock u) {
        return repository.save(u);
    }

    @Override
    public Stock retrieveStock(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void deleteStock(long id) {
        repository.deleteById(id);
    }

    @Override

@Scheduled(cron = "* * 22 * * *")
    public String retreiveStockStatus() {
        repository.getStatusStock().forEach(stock -> {
           log.warn("sotck "+stock.getLibelleStock() +"est epuisé");
        });
        return "";
    }


}
