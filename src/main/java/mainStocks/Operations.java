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
 *This class contain method for the request operations
 */
public class Operations {
	
	final static Logger logger = Logger.getLogger(Operations.class);
	private static final Operations ISTANCE = new Operations();

	public static Operations getIstance(){
		return ISTANCE;
	}
	
	/*
	 * this method return the Dividend Yeld for Common Stocks
	 */
	public double dividendYield(double lastDividend, double tickerPrice){
		
		double dividendYield = -1.0;
		dividendYield = lastDividend / tickerPrice;
		
		return dividendYield;
	}
	
	/*
	 * this method return the Dividend Yeld for Preferred Stocks
	 */
	public double dividendYield(double fixedDividend, double parValue, double tickerPrice){
		
		double dividendYield = -1.0;
		
		if(tickerPrice>0.0){
			dividendYield = (fixedDividend * parValue ) / tickerPrice;
		}
		
		return dividendYield;
	}
	
	/*
	 * this method return the P/E Ratio
	 */
	public double peRatio(int tickerPrice, int lastDividend){
		double peRatio = -1.0;
		
		if(tickerPrice > 0.0){
			peRatio = tickerPrice / dividendYield(lastDividend, tickerPrice);	
		}
		
		return peRatio;
	}
	
	//----------------trade---------------
	
	/*
	 * this method return the Stock Price based on trades recorded in past 15 minutes
	 */
	public double stockPriceTradesRecorded(/*insert*/){
		return 0;
	}
	
	
	
	/*
	 * This method return the GBCE All Share Index 
	 * using the geometric mean of prices for all stocks
	 */
	public double indexGBCEShare(ArrayList<Stock> stocks) throws Exception{
		double allShareIndex = 0.0;
		
		// Calculate stock price for all stock in the system
		if(stocks.size()>=1){
			double arg=0.0;
			for(int i=0; i<stocks.size(); i++){
				Stock stock = stocks.get(i);
				arg = arg + stock.getTickerPrice() ;
			}
			// Calculates the GBCE All Share Index
			allShareIndex = Math.pow(8, ((double)1/stocks.size()));
		}
		return allShareIndex;
	}
	
	
}
