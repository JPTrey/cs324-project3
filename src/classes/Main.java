package classes;

import gui.DisplayFrame;
import gui.MainFrame;

import java.awt.EventQueue;
import java.util.ArrayList;

import obj.Clock;
import obj.Customer;
import obj.Factory;
import obj.Store;
import obj.Store.PriceLevel;

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
	public final static long			waitAfterBuy = 5000;	// customer delay after making a purchase
	public final static int				restockCount = 500;		// amount to restock store
	
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
										maxCustomerCount = 1000;
	
	private static MainFrame				mainFrame;				// menu
	private static DisplayFrame				displayFrame;			// statistics

	
	public static void main(String[] args) {
		Text.debug("Hello, debug!");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainFrame = new MainFrame();
					mainFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	// TODO: construct in separate threads
	public static void beginButtonAction() {
		running = true;
		factories = new ArrayList<Factory>();
		customers = new ArrayList<Customer>();
		factoryCount = maxFactoryCount;
		customerCount = maxCustomerCount;
		factoryClock = new Signal();
		factoryStore = new FactoryStoreSignal();
		
		// construct store
		customerStore = new StoreCustomerSignal();
		store = new Store(factoryStore, customerStore);
		customerStore.registerStore(store);
		
		// construct factories
		for (int i=0; i<factoryCount; i++) {
			factories.add(new Factory(i+1, factoryClock, factoryStore, 10000));
		}
		
		// construct customers
		for (int i=0; i<customerCount; i++) {
			customers.add(new Customer(i+1, customerStore));
		}
			
		// start threads
		for (int i=0; i<factories.size(); i++) {
			(new Thread(factories.get(i))).start();
		}
		
		(new Thread(store)).start();
		
		for (int i=0; i<customers.size(); i++) {
			(new Thread(customers.get(i))).start();
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					displayFrame = new DisplayFrame();
					displayFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void endButtonAction() {
		running = false;
		// show stats
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
	
	public static int getFactoryCount() {
		return factoryCount;
	}

	public static int getCustomerCount() {
		return customerCount;
	}

	// updates factory view
	public static void updateProduce(int production) {
		displayFrame.updateItemsGenerated(production);
		Text.debug("Updating Produce");
	}
	
	// updates store view
	public static void updateStock(int stock) {
		displayFrame.updateItemStock(stock);
	}
	
	public static void updateRestock(int restockCount) {
//		displayFrame.updateRestock(restockCount);
	}

	// updates items sold, customers served, sold per customer
	public static void updateSold() {
//		displayFrame.updateSold();
		
	}

	public static void updatePrice(PriceLevel currentPrice) {
		displayFrame.updatePrice(currentPrice);
		
	}

	public static void updateCustomer(int served) {
		if (displayFrame != null)
			displayFrame.updateCustomersServed(served);
		
	}
	
	public static void updateTimeUnits(int units) {
		displayFrame.setTitle("Time Units Passed: " + units);
	}
	
}
