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
		Operations op = Operations.getIstance();
		assertEquals(0, op.dividendYield(3, 4, 8));
		logger.info("test preferred dividend OK");
	}

	
	public void testPERatio(){
		
	}
	
	
}
