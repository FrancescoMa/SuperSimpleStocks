/**
 * 
 */
package mainStocks;



import java.util.ArrayList;

import org.apache.log4j.Logger;

import model.Stock;

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
		ArrayList<Stock> listSotocks = new ArrayList<Stock>();
		Stock tea = new Stock("TEA",0,100);
		Stock pop = new Stock("POP",8,100);
		Stock ale = new Stock("ALE",23,60);
		Stock gin = new Stock("GIN",8,2,100);
		Stock joe = new Stock("TEA",0,100);
		
		logger.info("tea ="+tea.getSymbol());

	}

}
