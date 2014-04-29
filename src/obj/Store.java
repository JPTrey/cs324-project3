package obj;

import classes.FactoryStoreSignal;
import classes.StoreCustomerSignal;

public class Store implements Runnable {
	
	public enum PriceLevel{LOWPRICE, MIDPRICE, HIGHPRICE};
	
	private FactoryStoreSignal signal;
	private StoreCustomerSignal customerNotification;
	private int stock;
	public Store()
	{
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
