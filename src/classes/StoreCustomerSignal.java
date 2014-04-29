/**
 * 
 */
package classes;

/**
 * @author Pandora
 *
 */
public class StoreCustomerSignal {
	public enum PriceLevel{LOWPRICE, MIDPRICE, HIGHPRICE};
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
		while(pl != prices) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
