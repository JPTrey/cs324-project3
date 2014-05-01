package obj;

import classes.FactoryStoreSignal;
import classes.Main;
import classes.StoreCustomerSignal;
import classes.Text;

public class Store implements Runnable {

	public enum PriceLevel{LOWPRICE, MIDPRICE, HIGHPRICE};

	private FactoryStoreSignal factStoreSignal;
	private StoreCustomerSignal customerNotification;
	private PriceLevel			currentPrice;
	private int 				stock,
	restockCount,
	maxStock;

	public Store(FactoryStoreSignal fSSig, StoreCustomerSignal sTSig) {
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

	/**
	 * Called by Customer, when placing an order.
	 * @param amount quantity desired by Customer.
	 * @return true: transaction is cleared.
	 */
	public synchronized void purchase(int amount) {
		stock -= amount;



		// check if PriceLevel changes
//		if (((double) stock/Main.restockCount) > .67) {
//			currentPrice = PriceLevel.LOWPRICE;
//		}
//
//		else if (((double) stock/Main.restockCount) > .33) {
//			currentPrice = PriceLevel.MIDPRICE;
//		} 
//
//		else {
//			currentPrice = PriceLevel.HIGHPRICE;
//		}
		
		updatePrice();

		Main.updateStock(stock);
//		Main.updatePrice(currentPrice);
		Text.debug("STORE::Transaction successful");
	}

	public synchronized int getStock() {
		return stock;
	}

	private synchronized void restock() {
		stock = factStoreSignal.pullStock(Main.restockCount);
		notifyAll();
		Text.debug("STORE::Restocked inventory to " + stock + " items");
	}

	private synchronized void updatePrice() {
		// check if PriceLevel changes
		if (((double) stock/Main.restockCount) > .67) {
			currentPrice = PriceLevel.LOWPRICE;
		}

		else if (((double) stock/Main.restockCount) > .33) {
			currentPrice = PriceLevel.MIDPRICE;
		} 

		else {
			currentPrice = PriceLevel.HIGHPRICE;
		}
		Main.updatePrice(currentPrice);
	}

	@Override
	public void run() {
		while (Main.isRunning()) {

			if (stock == 0) {
				restock();
				//				Main.updateRestock(restockCount);
				Text.debug("STORE::We restockin'");
				//				stock = 100;
			}
			
			updatePrice();
			customerNotification.announce(currentPrice);
			Text.debug("STORE::Attention customers! We have " + stock + " items at " + currentPrice.toString() + " for sale!");
		}
	}
}