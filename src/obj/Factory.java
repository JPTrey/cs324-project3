package obj;

import classes.Signal;
import classes.Signal.EventState;

public class Factory implements Runnable {
	
	private Signal		factoryStore;		// reference to signal between this factory and Store
	private int inventory;
	private int inventoryCap;
	public Factory(int id, Signal factoryStore) {
		this.factoryStore = factoryStore;
		inventory = 0;
		inventoryCap = 200;
	}
	
	public Factory(int id, Signal factoryStore, int startingInventory, int startingCap) {
		this.factoryStore = factoryStore;
		inventory = startingInventory;
		inventoryCap = startingCap;
	}
	public int getinventory()
	{
		return inventory;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true)
		{
			factoryStore.await(EventState.TICK);
			if (inventory == inventoryCap || inventory+20 >= inventoryCap)
			{
				continue;
			}
			inventory += 20;
		}
	}

}
