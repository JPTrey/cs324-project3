/**
 * 
 */
package classes;

/**
 * @author Pandora
 *
 */
public class StoreCustomerSignal {
	
	public enum PriceLevel{LOWPRICE, MEDPRICE, HIGHPRICE};
	
	private PriceLevel prices;
	
	public StoreCustomerSignal()
	{
		prices = PriceLevel.MEDPRICE;
	}
	
	public synchronized void announce(PriceLevel pl)
	{
		
	}

}
