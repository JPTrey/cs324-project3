/**
 * 
 */
package classes;

import obj.Store.PriceLevel;
import obj.Customer.Affluency;
import obj.Store;
/**
 * @author Modupe Theko Lekena
 *
 */
public class StoreCustomerSignal {
	private PriceLevel 	currentPrice;
	private Store 		store;
	private int			customerCount;

	public StoreCustomerSignal() {
		currentPrice = PriceLevel.MIDPRICE;
	}

	public void registerStore(Store store) {
		this.store = store;
		customerCount = 0;
	}
	
	/**
	 * Store announces when ever stock comes in and sends its current price level
	 * @param pl
	 */
	public synchronized void announce(PriceLevel pl)
	{
		currentPrice = pl;
		notifyAll();
	}

	public synchronized void checkSale(Affluency richness) {
		int amountToBuy = 0;

		//Determine the amount to buy according to the wealth of the customer and the pricelevel
		if (currentPrice == PriceLevel.HIGHPRICE) {
			switch (richness)
			{
			case LOWSPENDER : amountToBuy = 200;
			break;
			case MIDSPENDER : amountToBuy = 100;
			break;
			case HIGHSPENDER : amountToBuy = 50;
			break;
			default : amountToBuy = 0;
			break;
			}
		}
		else if (currentPrice == PriceLevel.MIDPRICE) {
			switch (richness)
			{
			case LOWSPENDER : amountToBuy = 80;
			break;
			case MIDSPENDER : amountToBuy = 40;
			break;
			case HIGHSPENDER : amountToBuy = 20;
			break;
			default : amountToBuy = 0;
			break;
			}
		}
		else if (currentPrice == PriceLevel.LOWPRICE) {
			switch (richness)
			{
			case LOWSPENDER : amountToBuy = 40;
			break;
			case MIDSPENDER : amountToBuy = 20;
			break;
			case HIGHSPENDER : amountToBuy = 10;
			break;
			default : amountToBuy = 0;
			break;
			}
		}

		while(store.getStock() < amountToBuy) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Main.updateSold();
		synchronized(this) {
			customerCount++;
		}
		Main.updateCustomer(customerCount);
		Text.debug("CUSTOMER::Purchasing item");
		store.purchase(amountToBuy);

	}
}
