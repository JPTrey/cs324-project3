package obj;

import classes.Signal;

public class Customer implements Runnable {
	private Signal		customerStore;
	
	public Customer(int id, Signal customerStore) {
		this.customerStore = customerStore;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
