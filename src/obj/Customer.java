package obj;

import classes.StoreCustomerSignal;


public class Customer implements Runnable {
	
	public enum affluency{HIGHSPENDER,MEDSPENDER,LOWSPENDER};
	
	private StoreCustomerSignal		customerStore;
	private affluency buyerType;
	
	public Customer(int id, StoreCustomerSignal customerStore) {
		this.customerStore = customerStore;
	}
	
	public Customer(affluency enumVal)
	{
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
