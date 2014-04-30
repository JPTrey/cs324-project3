package obj;

import classes.FactoryStoreSignal;
import classes.Main;
import classes.StoreCustomerSignal;

public class Store implements Runnable {
	
	public enum PriceLevel{LOWPRICE, MIDPRICE, HIGHPRICE};
	
	private FactoryStoreSignal factStoreSignal;
	private StoreCustomerSignal customerNotification;
	private PriceLevel			currentPrice;
	private int 				stock,
								maxStock;
	
	public Store(FactoryStoreSignal fSSig, StoreCustomerSignal sTSig)
	{
		factStoreSignal = fSSig;
		customerNotification = sTSig;
		stock = 0;
		currentPrice = PriceLevel.HIGHPRICE;
	}
	 
	
	/**
	 * @return the currentPrice
	 */
	public PriceLevel getPrices() {
		return currentPrice;
	}

	public synchronized boolean purchase(int amount) {
		if (stock - amount <= 0) {
			return false;
		}
		stock -= amount;
		if (stock < 50) {
			currentPrice = PriceLevel.HIGHPRICE;
		}
		
		else if (stock < 500) {
			currentPrice = PriceLevel.MIDPRICE;
		} 
		
		else if (stock > 500) {
			currentPrice = PriceLevel.LOWPRICE;
		}
		  
		
		return true;
	}
	
	public synchronized int getStock() {
		return stock;
	}
	
	private void restock() {
		factStoreSignal.pullStock(Main.restockCount);
	}
	
	@Override
	public void run() {
		while (Main.isRunning()) {
			
			if (stock == 0) {
				restock();
			}
			
			// set price based on current stock
			if ((double) stock/Main.restockCount > .67) {
				currentPrice = PriceLevel.LOWPRICE;
			}
			
			else if ((double) stock/Main.restockCount > .67) {
				currentPrice = PriceLevel.MIDPRICE;
			}
			
			else {
				currentPrice = PriceLevel.HIGHPRICE;
			}
			
			customerNotification.announce(currentPrice);
		}
	}
}