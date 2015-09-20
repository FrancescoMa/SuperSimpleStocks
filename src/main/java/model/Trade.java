package model;

import java.util.Date;

/**
 * @author FrancescoM
 *
 */
public class Trade {
	
	private Date timeStamp = null;
	private Stock stock = null;
	private boolean sell = false;
	private int sharesQuantity = 0;
	private double price = 0.0;//
	
	
	/**
	 * 
	 */
	public Trade(){
	}


	/**
	 * @return the timeStamp
	 */
	public Date getTimeStamp() {
		return timeStamp;
	}


	/**
	 * @param timeStamp the timeStamp to set
	 */
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}


	/**
	 * @return the stock
	 */
	public Stock getStock() {
		return stock;
	}


	/**
	 * @param stock the stock to set
	 */
	public void setStock(Stock stock) {
		this.stock = stock;
	}


	/**
	 * @return the sell
	 */
	public boolean isSell() {
		return sell;
	}


	/**
	 * @param sell the sell to set
	 */
	public void setSell(boolean sell) {
		this.sell = sell;
	}


	/**
	 * @return the sharesQuantity
	 */
	public int getSharesQuantity() {
		return sharesQuantity;
	}


	/**
	 * @param sharesQuantity the sharesQuantity to set
	 */
	public void setSharesQuantity(int sharesQuantity) {
		this.sharesQuantity = sharesQuantity;
	}
}
