package tn.esprit.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entities.Stock;
import tn.esprit.spring.services.IServiceStock;

import java.util.List;

@RestController
@RequestMapping("/stock")
public class StockRestController {
    @Autowired
    IServiceStock serviceStock;

    //localhost:8089/stock/retrieve-all-stocks
    @GetMapping("/retrieve-all-stocks")
    @ResponseBody
    public List<Stock> getStocks(){
        List<Stock>stocks=serviceStock.retrieveAllStocks();
        return stocks;
    }

    //localhost:8089/stock/retrieve-stock/{id_stock}
    @GetMapping("/retrieve-stock/{id_stock}")
    @ResponseBody
   public Stock retrieveStock(@PathVariable("id_stock")Long id_stock){
        return serviceStock.retrieveStock(id_stock);
    }

    //localhost:8089/stock/update-stock/{id_stock}
    @PutMapping("/update-stock/")
    @ResponseBody
    public Stock updateStock(@RequestBody Stock s){
        return serviceStock.updateStock(s);
    }

    //localhost:8089/stock/add-stock

    @PostMapping("/add-post")
    @ResponseBody

    public Stock addStock(@RequestBody Stock stock){
        return serviceStock.addStock(stock);

    }


}
