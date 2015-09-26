package model;


/**
 * @author FrancescoM
 *
 */
public class Trade {
	
	private long timeStamp = 0;
	private Stock stock = null;
	private boolean sell = false;
	private int sharesQuantity = 0;
	private double price = 0.0;//this is the ticker price at the moment of sell/buy
	
	
	/**
	 * 
	 */
	public Trade(Stock stock, long timeStamp, boolean sell, int shareQuantity, double price){
		this.timeStamp=timeStamp;
		this.stock=stock;
		this.sell=sell;
		this.sharesQuantity=shareQuantity;
		this.price=price;
	}
	
	
	
	/**
	 * @return the timeStamp
	 */
	public long getTimeStamp() {
		return timeStamp;
	}



	/**
	 * @param timeStamp the timeStamp to set
	 */
	public void setTimeStamp(long timeStamp) {
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


	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}


	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
}
