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

	public synchronized boolean purchase(int amount)
	{
		if (stock - amount <= 0)
		{
			return false;
		}
		stock -= amount;
		if (stock < 50)
		{
			prices = PriceLevel.HIGHPRICE;
		}
		else if (stock < 500){
			prices = PriceLevel.MIDPRICE;
		} else if (stock >500) {
			prices = PriceLevel.LOWPRICE;
		}
		  
		
		return true;
	}
	
	public synchronized int getStock() {
		return stock;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}




}
