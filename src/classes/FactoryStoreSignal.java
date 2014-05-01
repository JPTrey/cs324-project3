/**
 * 
 */
package classes;

/**
 * @author mlekena
 *	
 *Signal class between the factory and the store
 *keeps track of how many items there are in the warehouse. Store requests n number of item and will wait till it can get that number from the warehouse.
 */
public class FactoryStoreSignal {

	public int warehouseInventory;
	
	public synchronized int addStock(int newProducts)
	{
		warehouseInventory += newProducts;
		Main.updateProduce(newProducts);
		Text.debug("EENTdfsfdsafew");
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
