package obj;

import classes.FactoryStoreSignal;
import classes.StoreCustomerSignal;

public class Store implements Runnable {
	
	public enum PriceLevel{LOWPRICE, MIDPRICE, HIGHPRICE};
	
	private FactoryStoreSignal factStorsignal;
	private StoreCustomerSignal customerNotification;
	private PriceLevel			prices;
	private int stock;
	
	public Store(FactoryStoreSignal fSSig, StoreCustomerSignal sTSig)
	{
		factStorsignal = fSSig;
		customerNotification = sTSig;
		stock = 0;
		prices = PriceLevel.HIGHPRICE;
	}
	 
	
	/**
	 * @return the prices
	 */
	public PriceLevel getPrices() {
		return prices;
	}

	public synchronized boolean buy(int amount)
	{
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
