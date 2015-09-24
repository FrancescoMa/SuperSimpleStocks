/**
 * 
 */
package mainStocks;

import java.util.ArrayList;
import java.util.Date;

import org.apache.log4j.Logger;

import model.Stock;
import model.Trade;

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
		if(tickerPrice>0){
			dividendYield = lastDividend / tickerPrice;
		}
		return dividendYield!=0?dividendYield:tickerPrice;
	}
	
	/*
	 * this method return the Dividend Yeld for Preferred Stocks
	 */
	public double dividendYield(double fixedDividend, double parValue, double tickerPrice){
		
		double dividendYield = -1.0;
		
		if(tickerPrice>0.0){
			dividendYield = (fixedDividend * parValue ) / tickerPrice;
		}
		
		return dividendYield!=0?dividendYield:tickerPrice;
	}
	
	/*
	 * this method return the P/E Ratio
	 */
	public double peRatio(double tickerPrice, double lastDividend){
		double peRatio = -1.0;
		double dividend= dividendYield(lastDividend, tickerPrice);
		logger.info("dividend ="+dividend+" e ticker price = "+tickerPrice);
		
		if(tickerPrice > 0.0 && dividend!=0 && dividend!=-1){
			peRatio = tickerPrice / dividend;	
		}
		
		return peRatio;
	}
	
	
	/*
	 * this method return the Stock Price based on trades recorded in past 15 minutes 
	 * for the Stock specified and update tickerPrice of the same Stock
	 */
	public double stockPriceTradesRecorded(ArrayList<Trade> trades, int rangeMinutes, Stock stock){
		
		double stockPrice = 0.0;
		long now = (new Date()).getTime();
		
		
		logger.debug("Trades "+trades.size());
		double qtAcum = 0;
		double sellAcum = 0;
		
		for(Trade trade : trades){
			if (trade.getStock().equals(stock) && trade.getTimeStamp()>(now-getMillisecond(15))){
				
				if(trade.isSell()){
					sellAcum += trade.getSharesQuantity();
					qtAcum += trade.getSharesQuantity();
				}else{
					sellAcum -= trade.getSharesQuantity();
				}
				
			}

		}

		// calculate the stock price
		logger.info("sell and qt = "+sellAcum+" and "+qtAcum);
		stockPrice = stock.getTickerPrice()+ (sellAcum/qtAcum);

		stock.setTickerPrice(stockPrice);

		return stockPrice;
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
	
	
	/*
	 * return the minutes in milliseconds
	 */
	public long getMillisecond(int minutes){
		return minutes*60*1000;
	}
	
}
