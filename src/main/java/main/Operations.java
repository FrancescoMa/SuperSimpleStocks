/**
 * 
 */
package main;

import org.apache.log4j.Logger;

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
	public int dividendYield(int lastDividend, int tickerPrice){
		
		return 0;
	}
	
	/*
	 * this method return the Dividend Yeld for Preferred Stocks
	 */
	public int dividendYield(int fixedDividend, int parValue, int tickerPrice){
		
		return 0;
	}
	
	/*
	 * this method return the P/E Ratio
	 */
	public int peRatio(int tickerPrice, int dividend){
		return 0;
	}
	
	//----------------trade---------------
	
	/*
	 * this method return the Stock Price based on trades recorded in past 15 minutes
	 */
	public int stockPriceTradesRecorded(/*insert*/){
		return 0;
	}
	
	
	
	/*
	 * This method return the GBCE All Share Index 
	 * using the geometric mean of prices for all stocks
	 */
	public int indexGBCEShare(/*insert*/){
		return 0;
	}
	
	
}
