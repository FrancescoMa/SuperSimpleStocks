/**
 * 
 */
package testMain;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.junit.Test;

import mainStocks.Operations;
import model.InizializeIstance;
import model.Stock;
import model.Trade;

/**
 * @author FrancescoM
 *
 */
public class testOperation {

	final static Logger logger = Logger.getLogger(testOperation.class);
	Operations op = Operations.getIstance();
	InizializeIstance istanceStocks = new InizializeIstance();
	ArrayList<Stock> listStocks = istanceStocks.createStocks();
	ArrayList<Trade> listTrade = istanceStocks.createTrade();
	
	/**
	 * Test method for {@link mainStocks.Operations#dividendYield(int, int)}.
	 */
	@Test
	public void testDividendYieldCommon() {
		assertNotNull(listStocks);
		
		logger.info("-----------------test dividend yield common----------------");
		Iterator<Stock> stockIterator= listStocks.iterator();
		
		while(stockIterator.hasNext()){
			Stock stock= stockIterator.next();
			assertTrue(op.dividendYield(stock.getLastDividend(), stock.getTickerPrice())!=-1);
			logger.info(stock.getSymbol()+" test --> good");
			
			assertTrue(op.dividendYield(stock.getLastDividend(), 0)==-1);
			logger.info(stock.getSymbol()+" test ticker price = 0 --> good");
		}
		
		logger.info("-----------------test common dividend OK------------------------");
	}

	/**
	 * Test method for {@link mainStocks.Operations#dividendYield(int, int, int)}.
	 */
	@Test
	public void testDividendYieldPreferred() {
		assertNotNull(listStocks);
		
		logger.info("-----------------test dividend yield preferred----------------");
		Iterator<Stock> stockIterator= listStocks.iterator();
		
		while(stockIterator.hasNext()){
			Stock stock= stockIterator.next();
			assertTrue(op.dividendYield(stock.getFixedDividend(), stock.getParValue(), stock.getTickerPrice())!=-1);
			logger.info(stock.getSymbol()+" test --> good || last dividend = "+stock.getLastDividend());
			
			assertTrue(op.dividendYield(stock.getFixedDividend(), stock.getParValue(),0)==-1);
			logger.info(stock.getSymbol()+" test ticker price = 0 --> good");
		}
		
		logger.info("-----------------test preferred dividend OK------------------------");
	}

	
	/**
	 * Test method for {@link mainStocks.Operations#peRatio(double, double)}.
	 */
	@Test
	public void testPERatio(){
		assertNotNull(listStocks);
		
		logger.info("-----------------test p/e ratio----------------");
		Iterator<Stock> stockIterator= listStocks.iterator();
		
		while(stockIterator.hasNext()){
			Stock stock= stockIterator.next();
			assertTrue(op.peRatio(stock.getTickerPrice(), stock.getLastDividend())!=-1);
			logger.info(stock.getSymbol()+" test --> good");
			
			assertTrue(op.peRatio(stock.getTickerPrice(), 0)!=-1);
			logger.info(stock.getSymbol()+" test last dividend = 0 --> good");
			
			assertTrue(op.peRatio(0, stock.getLastDividend())==-1);
			logger.info(stock.getSymbol()+" test ticker price = 0 --> good");
		}
		
		logger.info("-----------------test P/E ratio ok------------------------");
	}
	
	/**
	 * Test method for {@link mainStocks.Operations#stockPriceTradesRecorded(ArrayList, int, Stock)}.
	 */
	@Test
	public void testStockPriceTradesRecorded(){
		assertNotNull(listStocks);
		
		logger.info("-----------------test Stock Price Trades Recorded----------------");
		Iterator<Stock> stockIterator= listStocks.iterator();
		
		
	}
}
