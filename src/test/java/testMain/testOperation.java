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
	 * @throws Exception 
	 */
	@Test
	public void testDividendYieldCommon() throws Exception {
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
	 * @throws Exception 
	 */
	@Test
	public void testDividendYieldPreferred() throws Exception {
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
	 * @throws Exception 
	 */
	@Test
	public void testPERatio() throws Exception{
		assertNotNull(listStocks);
		
		logger.info("-----------------test p/e ratio----------------");
		Iterator<Stock> stockIterator= listStocks.iterator();
		
		while(stockIterator.hasNext()){
			Stock stock= stockIterator.next();
			if(stock.isPreferred()){
				assertTrue(op.peRatio(stock.getTickerPrice(), stock.getFixedDividend(), stock.getParValue())!=-1);
				logger.info(stock.getSymbol()+" test --> good");
				
				assertTrue(op.peRatio(stock.getTickerPrice(), 0, stock.getParValue())!=-1);
				logger.info(stock.getSymbol()+" test fixed dividend = 0 --> good");
				
				assertTrue(op.peRatio(stock.getTickerPrice(), stock.getFixedDividend(), 0)!=-1);
				logger.info(stock.getSymbol()+" test par value = 0 --> good");
				
				assertTrue(op.peRatio(0, stock.getFixedDividend(), stock.getParValue())==-1);
				logger.info(stock.getSymbol()+" test ticker price = 0 --> good");
			}else{
				assertTrue(op.peRatio(stock.getTickerPrice(), stock.getLastDividend())!=-1);
				logger.info(stock.getSymbol()+" test --> good");
				
				assertTrue(op.peRatio(stock.getTickerPrice(), 0)!=-1);
				logger.info(stock.getSymbol()+" test last dividend = 0 --> good");
				
				assertTrue(op.peRatio(0, stock.getLastDividend())==-1);
				logger.info(stock.getSymbol()+" test ticker price = 0 --> good");
			}

		}
		
		logger.info("-----------------test P/E ratio ok------------------------");
	}
	
	/**
	 * Test method for {@link mainStocks.Operations#stockPriceTradesRecorded(ArrayList, int, Stock)}.
	 * @throws Exception 
	 */
	@Test
	public void testStockPriceTradesRecorded() throws Exception{
		assertNotNull(listStocks);
		assertNotNull(listTrade);
		
		logger.info("-----------------test Stock Price Trades Recorded----------------");
		Iterator<Stock> stockIterator= listStocks.iterator();
		while(stockIterator.hasNext()){
			Stock stock= stockIterator.next();
			assertTrue(op.stockPriceTradesRecorded(listTrade, 15, stock)!=-1);
			logger.info(stock.getSymbol()+" test --> good");
			
			assertTrue(op.stockPriceTradesRecorded(listTrade, 0, stock)==-1);
			logger.info(stock.getSymbol()+" test minutes = 0 --> good");
			
			assertTrue(op.stockPriceTradesRecorded(listTrade, 15, null)==0);
			logger.info(stock.getSymbol()+" test stock = null --> good");
			
			assertTrue(op.stockPriceTradesRecorded(null, 15, stock)==0);
			logger.info(stock.getSymbol()+" test stock = null --> good");
		}
		
		logger.info("-----------------test Stock Price Trades Recorded ok------------------------");
		
	}
	
	/**
	 * Test method for {@link mainStocks.Operations#indexGBCEShare(ArrayList)}.
	 */
	@Test
	public void testIndexGBCEShare(){
		assertNotNull(listStocks);
		
		logger.info("-----------------test GBCE----------------");
		
			try {
				
				assertTrue(op.indexGBCEShare(listStocks)!=-1);

				logger.info(" test --> good");
				
				
				assertTrue(op.indexGBCEShare(null)==-1);
				logger.info(" test list = null --> good");
				
				ArrayList<Stock> stocks2= new ArrayList<Stock>();
				
				assertTrue(op.indexGBCEShare(stocks2)==-1);
				logger.info(" test stocks2 vuoto --> good");
				
			}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		logger.info("-----------------test GBCE ok------------------------");
	
	}
	
}
