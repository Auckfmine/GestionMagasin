package tn.esprit.spring;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Stock;
import tn.esprit.spring.services.IServiceStock;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StockServiceImplTest {
	@Autowired
	IServiceStock stockService;

	@Test
	public void testAddStock() throws ParseException{
		List<Stock> stocks = stockService.retrieveAllStocks();
		int expected=stocks.size();
		Stock s = new Stock();
		s.setLibelleStock("stock test");
		s.setQteStock(10);
		s.setQteMin(100);
		Stock savedStock= stockService.addStock(s);
		assertEquals(expected+1, stockService.retrieveAllStocks().size());
		assertNotNull(savedStock.getLibelleStock());
		stockService.deleteStock(savedStock.getIdStock());
	}
}