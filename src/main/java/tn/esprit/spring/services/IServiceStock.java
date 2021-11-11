package tn.esprit.spring.services;

import tn.esprit.spring.entities.Stock;

import java.util.List;

public interface IServiceStock {
    List<Stock> retrieveAllStocks();

    Stock addStock(Stock s);

    Stock updateStock(Stock u);

    Stock retrieveStock(Long id);
}
