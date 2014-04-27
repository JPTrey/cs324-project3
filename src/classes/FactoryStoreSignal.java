/**
 * 
 */
package classes;

/**
 * @author mlekena
 *	
 *Signal class between the factory and the store
 */
public class FactoryStoreSignal {

	public int warehouseInventory;
	
	public synchronized int addStock(int newProducts)
	{
		warehouseInventory += newProducts;
		notifyAll();
		return warehouseInventory;
	}
	public synchronized int queryStock()
	{
		return warehouseInventory;
	}
	
	public synchronized int pullStock(int amount)
	{
		while (amount < warehouseInventory)
		{
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		warehouseInventory -= amount;
		return amount;
	}
}
