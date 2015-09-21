/**
 * 
 */
package mainStocks;



import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.hamcrest.core.IsInstanceOf;

import model.Stock;
import model.InizializeIstance;

/**
 * @author FrancescoM
 *
 */
public class SuperSimpleStocks {
	
	final static Logger logger = Logger.getLogger(SuperSimpleStocks.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Operations operations= new Operations();
		InizializeIstance initList = new InizializeIstance();
		ArrayList<Stock> listStocks = initList.createStocks();
		
		logger.info("listStocks ="+listStocks.size());

	}
	
	
	public static void tradeInsert(){
		
	}
	
	
}
