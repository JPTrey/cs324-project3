package obj;

import classes.Main;
import classes.Signal;
import classes.Text;
import classes.Signal.EventState;
import classes.FactoryStoreSignal;

public class Factory implements Runnable {

	private FactoryStoreSignal	 factoryStore;
	private Signal				clockSignal;		// reference to signal between this factory and Store
	private int					 production, produced;

	public Factory(int id, Signal clockSignal, FactoryStoreSignal factoryStore, int setProduction) {

		production = setProduction;
		this.clockSignal = clockSignal;
		this.factoryStore = factoryStore;
		produced = 0;

	}

	@Override
	public void run() {
		while (Main.isRunning()) {
			clockSignal.await(EventState.TICK);
			produced += production;
			Main.updateProduce(produced);
			factoryStore.addStock(production);

		}
	}

}
