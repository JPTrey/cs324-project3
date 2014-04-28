package classes;

import java.util.ArrayList;

import obj.Clock;
import obj.Customer;
import obj.Factory;
import obj.Store;

/**
 * 
 * @author jsimonel
 * Source hosted at: https://github.com/JPTrey/cs324-project3
 * Coding style:
 * Declare all variables used within the scope of a class/method at the top.
 * Follow indentation patterns.
 * All methods names must be verbs; if it cannot be described, it is performing too many operations.
 * Methods should NOT return any input parameters. Parameters should be final whenever possible.
 * Use setters and getters. Variables/methods should be private/final whenever possible.
 * Use the Output class for console statements. Output.debug calls are ignored whenever Main.debug == false.
 * Pass the least amount of data possible between methods/classes. Avoid passing objects/arrays.
 * Implement Runnable. Do NOT extend Thread.
 */
public class Main {
	public final static boolean			debug = true;			// true: prints out debug statements
	
	private static Clock				clock;
	private static Store				store;
	private static Signal				factoryClock;
	private static FactoryStoreSignal	factoryStore;
	private static StoreCustomerSignal	customerStore;
	private static ArrayList<Factory>	factories;
	private static ArrayList<Customer>	customers;
	private static boolean 				running;
	private static int					tickTime = 1000,		// tick rate (in milliseconds)
										factoryCount,
										maxFactoryCount = 50,
										customerCount,
										maxCustomerCount = 100000;
	
	public static void main(String[] args) {
		running = true;
		factories = new ArrayList<Factory>();
		customers = new ArrayList<Customer>();
		factoryCount = maxFactoryCount;
		customerCount = maxCustomerCount;
		
		Text.debug("Hello, debug!");
	
	}

	// TODO: construct in seperate threads
	public static void beginButtonAction() {
		// construct factories
		for (int i=0; i<factoryCount; i++) {
			factories.add(new Factory(i+1,factoryClock, factoryStore));
		}
		
		// construct customers
		for (int i=0; i<factoryCount; i++) {
			customers.add(new Customer(i+1, customerStore));
		}
	}
	
	public void setFactoryCount(int val) {
		factoryCount += val;
		Text.debug("factoryCount = " + factoryCount);
	}
	
	public void setCustomerCount(int val) {
		factoryCount += val;
		Text.debug("customerCount = " + customerCount);
	}
	
	public Clock getClock() {
		return clock;
	}


	public Store getStore() {
		return store;
	}

	public Signal getFactoryClock() {
		return factoryClock;
	}

	public FactoryStoreSignal getFactoryStore() {
		return factoryStore;
	}

	public StoreCustomerSignal getCustomerStore() {
		return customerStore;
	}

	public ArrayList<Factory> getFactories() {
		return factories;
	}

	public ArrayList<Customer> getCustomers() {
		return customers;
	}

	public static boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

	public int getTickTime() {
		return tickTime;
	}

	public void setTickTime(int tickTime) {
		this.tickTime = tickTime;
	}
	
}
