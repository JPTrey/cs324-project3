package obj;

import classes.Main;
import classes.Signal;
import classes.Text;
import classes.Signal.EventState;
import classes.FactoryStoreSignal;

public class Factory implements Runnable {

	private FactoryStoreSignal	 factoryStore;
	private Signal				clockSignal;		// reference to signal between this factory and Store
	private int					 production;

//	public Factory(int id, Signal proSignal, FactoryStoreSignal factorSignal ) {
//
//		this.clockSignal = proSignal;
//		this.factoryStore = factorSignal; 
//		production = 10;
//
//	}

	public Factory(int id, Signal clockSignal, FactoryStoreSignal factoryStore, int setProduction) {

		production = setProduction;
		this.clockSignal = clockSignal;
		this.factoryStore = factoryStore;

	}

	@Override
	public void run() {
		while (Main.isRunning()) {
			if (clockSignal == null) {
				Text.debug("EENT");
			}
			else {
			clockSignal.await(EventState.TICK);
			factoryStore.addStock(production);
//			Main.updateProduce(production);
//			Text.debug("EENTdfsfdsafew");
//			factoryStore.notifyAll();
			}
		}
	}

}
