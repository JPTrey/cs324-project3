package obj;

import classes.Main;
import classes.Signal;
import classes.Signal.EventState;
import classes.FactoryStoreSignal;

public class Factory implements Runnable {
	
	private FactoryStoreSignal	 factoryStore;
	private Signal				productionSignal;		// reference to signal between this factory and Store
	private int					 production;
	
	public Factory(int id, Signal proSignal, FactoryStoreSignal factorSignal ) {
		
		this.productionSignal = proSignal;
		this.factoryStore = factorSignal; 
		production = 10;
		
	}
	
	public Factory(int id, Signal factoryStore, FactoryStoreSignal factorSignal, int setProduction) {
		
		production = setProduction;
		this.productionSignal = factoryStore;
		this.factoryStore = factorSignal;
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (Main.isRunning())
		{
			productionSignal.await(EventState.TICK);
			factoryStore.addStock(production);
			factoryStore.notifyAll();
		}
	}

}
