/**
 * 
 */
package mainStocks;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.hamcrest.core.IsInstanceOf;

import model.Stock;
import model.Trade;
import model.InizializeIstance;

/**
 * @author FrancescoM
 *
 */
public class SuperSimpleStocks {
	
	final static Logger logger = Logger.getLogger(SuperSimpleStocks.class);

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		Operations operations= new Operations();
		InizializeIstance initList = new InizializeIstance();
		ArrayList<Stock> listStocks = initList.createStocks();
		ArrayList<Trade> listTrade = initList.createTrade();
		
		logger.info("listStocks ="+listStocks.size());
		logger.info("listTrade ="+listTrade.size());
		
		logger.info("ticker price before= "+listStocks.get(0).getTickerPrice());
		operations.stockPriceTradesRecorded(listTrade, 15, listStocks.get(0));
		logger.info("ticker price after= "+listStocks.get(0).getTickerPrice());
		

		InputStreamReader input = new InputStreamReader (System.in);
		BufferedReader tastiera = new BufferedReader (input);
		logger.info("wait for a number of index.....");
		String numeroLetto = tastiera.readLine();
		int numero1 = Integer.valueOf(numeroLetto).intValue();
		operations.stockPriceTradesRecorded(listTrade, 15, listStocks.get(numero1));
		logger.info("ticker price after= "+listStocks.get(0).getTickerPrice());
		
	}
	
	
	public static void tradeInsert(){
		
	}
	
	
}
