/**
 * 
 */
package testMain;

import static org.junit.Assert.*;

import java.util.ArrayList;

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
	/**
	 * Test method for {@link mainStocks.Operations#dividendYield(int, int)}.
	 */
	@Test
	public void testDividendYieldIntInt() {
		Operations op = Operations.getIstance();
		InizializeIstance istanceStocks = new InizializeIstance();
		ArrayList<Stock> listStocks = istanceStocks.createStocks();
		assertNotNull(listStocks);
		
		ArrayList<Trade> listTrade = istanceStocks.createTrade();
		assertTrue(listTrade.size()==0);
		
		
		logger.info("test common dividend OK");
	}

	/**
	 * Test method for {@link mainStocks.Operations#dividendYield(int, int, int)}.
	 */
	@Test
	public void testDividendYieldIntIntInt() {
		Operations op = Operations.getIstance();
		assertEquals(0, op.dividendYield(3, 4, 8));
		logger.info("test preferred dividend OK");
	}

}
