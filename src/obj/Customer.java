package obj;

import classes.Main;
import classes.StoreCustomerSignal;
import classes.Text;
import obj.Store.PriceLevel;

public class Customer implements Runnable {

	public enum Affluency{HIGHSPENDER,MIDSPENDER,LOWSPENDER};

	private StoreCustomerSignal		customerStore; //contains the signal between customer and store. Use checkSale(priceLevel) to wait for sales 
	private Affluency 				buyerType;		//used to specify the buyer type 
	private int 					id;
	public Customer(int id, StoreCustomerSignal customerStore) {
		buyerType = Affluency.MIDSPENDER;
		this.customerStore = customerStore;
		this.id = id; 
	}

	/**
	 * @param enumVal willing to buy at low-high price
	 * @param sig signal between store and this customer
	 */
	public Customer(int id, Affluency enumVal, StoreCustomerSignal sig ) {
		buyerType = enumVal;
		customerStore = sig;
		this.id = id;

	}

	public int getId() {
		return id;
	}

	@Override
	public void run() {
		while (Main.isRunning()) {
			Text.debug("CUSTOMER#" + id + "::Attempting purchase");
			customerStore.checkSale(buyerType);	// if: priceLevel is not satisfactory, wait()
		}
	}
}
