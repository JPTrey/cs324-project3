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
	private Clock				clock;
	private Store				store;
	private Signal				factoryClock,
								factoryStore,
								customerStore;
	private ArrayList<Factory>	factories;
	private ArrayList<Customer>	customers;
	private boolean				debug = true;
	private static boolean 		running;
	private int					tickTime = 1000;		// tick rate (in milliseconds)
	
	
	public static void main(String[] args) {
		running = true;

	}

	public Clock getClock() {
		return clock;
	}


	public void setClock(Clock clock) {
		this.clock = clock;
	}


	public Store getStore() {
		return store;
	}


	public void setStore(Store store) {
		this.store = store;
	}


	public Signal getFactoryClock() {
		return factoryClock;
	}


	public void setFactoryClock(Signal factoryClock) {
		this.factoryClock = factoryClock;
	}


	public Signal getFactoryStore() {
		return factoryStore;
	}


	public void setFactoryStore(Signal factoryStore) {
		this.factoryStore = factoryStore;
	}


	public Signal getCustomerStore() {
		return customerStore;
	}


	public void setCustomerStore(Signal customerStore) {
		this.customerStore = customerStore;
	}


	public ArrayList<Factory> getFactories() {
		return factories;
	}


	public void setFactories(ArrayList<Factory> factories) {
		this.factories = factories;
	}


	public ArrayList<Customer> getCustomers() {
		return customers;
	}


	public void setCustomers(ArrayList<Customer> customers) {
		this.customers = customers;
	}


	public boolean isDebug() {
		return debug;
	}


	public void setDebug(boolean debug) {
		this.debug = debug;
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
