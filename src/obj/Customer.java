package obj;

import classes.Main;

import classes.StoreCustomerSignal;
import obj.Store.PriceLevel;

public class Customer implements Runnable {

	public enum affluency{HIGHSPENDER,MIDSPENDER,LOWSPENDER};

	private StoreCustomerSignal		customerStore; //contains the signal between customer and store. Use checkSale(priceLevel) to wait for sales 
	private Store					store;			//use to buy directly from the store
	private affluency 				buyerType;		//used to specify the buyer type 
	private PriceLevel				priceLevel;		//specify what price Level each customer is waiting for
	private int 					buyQuantity;	//The quantity that the customer will be each time

	public Customer(int id, StoreCustomerSignal customerStore) {
		this.customerStore = customerStore;
	}

/**
 * 	
 * @param enumVal willing to buy at low-high price
 * @param numToBuy quantity desired from store
 * @param sig signal between store and this customer
 * @param newStore reference to store
 */
public Customer(affluency enumVal,int numToBuy, StoreCustomerSignal sig, Store newStore) {
		buyerType = enumVal;
		customerStore = sig;
		store = newStore;
		buyQuantity = numToBuy;

		switch(buyerType) {
		case HIGHSPENDER: 	
			priceLevel = priceLevel.HIGHPRICE;
			break;
		case MIDSPENDER: 	
			priceLevel = priceLevel.MIDPRICE;
			break;
		case LOWSPENDER: 	
			priceLevel = priceLevel.LOWPRICE;
			break;
		default: 			
			break;
		}
	}
	
	// do this until you're dead
	@Override
	public void run() {
		while (Main.isRunning()) {
			customerStore.checkSale(priceLevel);	// if: priceLevel is not satisfactory, wait()
			//Store.buy(byQuantity); // buy all the jeans you  want!
			
			try {
				wait(Main.waitAfterBuy);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
