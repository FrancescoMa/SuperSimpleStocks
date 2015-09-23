/**
 * 
 */
package model;

import org.apache.log4j.Logger;


/**
 * @author FrancescoM
 *
 */
public class Stock {

	final static Logger logger = Logger.getLogger(Stock.class);
	private String symbol="";
	private boolean preferred=false;
	private double lastDividend=0.0;
	private double fixedDividend;
	private double parValue=0.0;
	/*
	 * progressive. it is reasonable to assume that: 
	 * if is register a sales growth in the previous 15 min, 
	 * the price increases of (deltax/qtySell)%
	 */
	private double tickerPrice = 1.0;
	
	
	/*
	 * this constructor is for common Stocks. So, it hasn't the Fixed Dividend value
	 */
	public Stock(String symbol, int lastDividend, int parValue){
		this.symbol=symbol;
		this.lastDividend=lastDividend;
		this.parValue=parValue;
	}
	
	/*
	 * this constructor is for preferred Stocks
	 */
	public Stock(String symbol, int lastDividend, int fixedDividend, int parValue){
		this.symbol=symbol;
		this.lastDividend=lastDividend;
		this.parValue=parValue;
		
		this.fixedDividend=fixedDividend;
		this.preferred=true;
	}

	/**
	 * @return the symbol
	 */
	public String getSymbol() {
		return symbol;
	}

	/**
	 * @param symbol the symbol to set
	 */
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	/**
	 * @return the preferred
	 */
	public boolean isPreferred() {
		return preferred;
	}

	/**
	 * @param preferred the preferred to set
	 */
	public void setPreferred(boolean preferred) {
		this.preferred = preferred;
	}

	/**
	 * @return the lastDividend
	 */
	public double getLastDividend() {
		return lastDividend;
	}

	/**
	 * @param lastDividend the lastDividend to set
	 */
	public void setLastDividend(double lastDividend) {
		this.lastDividend = lastDividend;
	}

	/**
	 * @return the fixedDividend
	 */
	public double getFixedDividend() {
		return fixedDividend;
	}

	/**
	 * @param fixedDividend the fixedDividend to set
	 */
	public void setFixedDividend(double fixedDividend) {
		this.fixedDividend = fixedDividend;
	}

	/**
	 * @return the parValue
	 */
	public double getParValue() {
		return parValue;
	}

	/**
	 * @param parValue the parValue to set
	 */
	public void setParValue(double parValue) {
		this.parValue = parValue;
	}

	/**
	 * @return the tickerPrice
	 */
	public double getTickerPrice() {
		return tickerPrice;
	}

	/**
	 * @param tickerPrice the tickerPrice to set
	 */
	public void setTickerPrice(double tickerPrice) {
		this.tickerPrice = tickerPrice;
	}

	
	
	
	
	
	
}
