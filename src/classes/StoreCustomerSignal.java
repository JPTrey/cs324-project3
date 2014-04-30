/**
 * 
 */
package classes;

import obj.Store.PriceLevel;
/**
 * @author Modupe Theko Lekena
 *
 */
public class StoreCustomerSignal {
	
	//ENUM moved to Store.Java
	private PriceLevel prices;
	
	public StoreCustomerSignal(int price) {
		prices = PriceLevel.MIDPRICE;
	}
	
	public synchronized void announce(PriceLevel pl)
	{
		prices = pl;
		notifyAll();
	}
	
	public synchronized void checkSale(PriceLevel pl) {
		switch 
		while(pl != prices) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
