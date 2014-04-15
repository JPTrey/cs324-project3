package obj;

import classes.Signal;

public class Factory implements Runnable {
	private Signal		factoryStore;		// reference to signal between this factory and Store
	
	public Factory(int id, Signal factoryStore) {
		this.factoryStore = factoryStore;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

}
