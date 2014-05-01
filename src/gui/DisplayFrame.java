package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JTextField;

import obj.Store.PriceLevel;
import classes.Main;
import classes.Text;
import java.awt.Color;

public class DisplayFrame extends JFrame {

	private JPanel contentPane;
	private JTextField numFactoriesText;
	private JTextField itemsGenPerFactory;
	private JTextField itemsGenTotal;
	private JTextField itemStockText;
	private JTextField restockText;
	private JTextField totalCustomersText;
	private JTextField numCustomersText;
	private JTextField avgItemsPurchasedText;
	private int restock;
	private int totalItems;
	private JTextField priceText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DisplayFrame frame = new DisplayFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DisplayFrame() {
		setTitle("Time Units Passed: 0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(3, 0, 0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{173, 90, 0};
		gbl_panel.rowHeights = new int[]{16, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel factoryCountLabel = new JLabel("Factories View");
		GridBagConstraints gbc_factoryCountLabel = new GridBagConstraints();
		
		JLabel factoriesLabel = new JLabel("Factories View");
		GridBagConstraints gbc_factoriesLabel = new GridBagConstraints();
		gbc_factoriesLabel.anchor = GridBagConstraints.WEST;
		gbc_factoriesLabel.insets = new Insets(0, 0, 5, 5);
		gbc_factoriesLabel.gridx = 0;
		gbc_factoriesLabel.gridy = 1;
		panel.add(factoriesLabel, gbc_factoriesLabel);
		
		JLabel lblNumberOfFactories = new JLabel("Number of Factories:");
		GridBagConstraints gbc_lblNumberOfFactories = new GridBagConstraints();
		gbc_lblNumberOfFactories.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumberOfFactories.gridx = 0;
		gbc_lblNumberOfFactories.gridy = 3;
		panel.add(lblNumberOfFactories, gbc_lblNumberOfFactories);
		
		numFactoriesText = new JTextField();
		numFactoriesText.setEditable(false);
		GridBagConstraints gbc_numFactoriesText = new GridBagConstraints();
		gbc_numFactoriesText.insets = new Insets(0, 0, 5, 0);
		gbc_numFactoriesText.fill = GridBagConstraints.HORIZONTAL;
		gbc_numFactoriesText.gridx = 1;
		gbc_numFactoriesText.gridy = 3;
		panel.add(numFactoriesText, gbc_numFactoriesText);
		numFactoriesText.setColumns(10);
		numFactoriesText.setText("" + Main.getFactoryCount());
		
		JLabel lblItemsGenerated = new JLabel("Items Generated");
		GridBagConstraints gbc_lblItemsGenerated = new GridBagConstraints();
		gbc_lblItemsGenerated.insets = new Insets(0, 0, 5, 5);
		gbc_lblItemsGenerated.gridx = 0;
		gbc_lblItemsGenerated.gridy = 4;
		panel.add(lblItemsGenerated, gbc_lblItemsGenerated);
		
		JLabel lblPerFactory = new JLabel("Per Factory:");
		lblPerFactory.setForeground(Color.LIGHT_GRAY);
		lblPerFactory.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblPerFactory = new GridBagConstraints();
		gbc_lblPerFactory.anchor = GridBagConstraints.EAST;
		gbc_lblPerFactory.insets = new Insets(0, 0, 5, 5);
		gbc_lblPerFactory.gridx = 0;
		gbc_lblPerFactory.gridy = 5;
		panel.add(lblPerFactory, gbc_lblPerFactory);
		
		itemsGenPerFactory = new JTextField();
		itemsGenPerFactory.setEnabled(false);
		itemsGenPerFactory.setEditable(false);
		itemsGenPerFactory.setText("0");
		GridBagConstraints gbc_itemsGenPerFactory = new GridBagConstraints();
		gbc_itemsGenPerFactory.insets = new Insets(0, 0, 5, 0);
		gbc_itemsGenPerFactory.fill = GridBagConstraints.HORIZONTAL;
		gbc_itemsGenPerFactory.gridx = 1;
		gbc_itemsGenPerFactory.gridy = 5;
		panel.add(itemsGenPerFactory, gbc_itemsGenPerFactory);
		itemsGenPerFactory.setColumns(10);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setForeground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_lblTotal = new GridBagConstraints();
		gbc_lblTotal.anchor = GridBagConstraints.EAST;
		gbc_lblTotal.insets = new Insets(0, 0, 5, 5);
		gbc_lblTotal.gridx = 0;
		gbc_lblTotal.gridy = 6;
		panel.add(lblTotal, gbc_lblTotal);
		
		itemsGenTotal = new JTextField();
		itemsGenTotal.setEnabled(false);
		itemsGenTotal.setEditable(false);
		itemsGenTotal.setText("0");
		GridBagConstraints gbc_itemsGenTotal = new GridBagConstraints();
		gbc_itemsGenTotal.insets = new Insets(0, 0, 5, 0);
		gbc_itemsGenTotal.fill = GridBagConstraints.HORIZONTAL;
		gbc_itemsGenTotal.gridx = 1;
		gbc_itemsGenTotal.gridy = 6;
		panel.add(itemsGenTotal, gbc_itemsGenTotal);
		itemsGenTotal.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{160, 65, 0};
		gbl_panel_1.rowHeights = new int[]{16, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel storeLabel = new JLabel("Store View");
		GridBagConstraints gbc_storeLabel = new GridBagConstraints();
		gbc_storeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_storeLabel.anchor = GridBagConstraints.NORTHWEST;
		gbc_storeLabel.gridx = 0;
		gbc_storeLabel.gridy = 0;
		panel_1.add(storeLabel, gbc_storeLabel);
		
		JLabel lblItemsInStock = new JLabel("Items in Stock:");
		GridBagConstraints gbc_lblItemsInStock = new GridBagConstraints();
		gbc_lblItemsInStock.insets = new Insets(0, 0, 5, 5);
		gbc_lblItemsInStock.gridx = 0;
		gbc_lblItemsInStock.gridy = 1;
		panel_1.add(lblItemsInStock, gbc_lblItemsInStock);
		
		itemStockText = new JTextField();
		itemStockText.setEditable(false);
		itemStockText.setText("0");
		GridBagConstraints gbc_itemStockText = new GridBagConstraints();
		gbc_itemStockText.insets = new Insets(0, 0, 5, 0);
		gbc_itemStockText.fill = GridBagConstraints.HORIZONTAL;
		gbc_itemStockText.gridx = 1;
		gbc_itemStockText.gridy = 1;
		panel_1.add(itemStockText, gbc_itemStockText);
		itemStockText.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Times Restocked:");
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 2;
		panel_1.add(lblNewLabel, gbc_lblNewLabel);
		
		restockText = new JTextField();
		restockText.setEditable(false);
		restockText.setEnabled(false);
		restockText.setText("0");
		GridBagConstraints gbc_restockText = new GridBagConstraints();
		gbc_restockText.insets = new Insets(0, 0, 5, 0);
		gbc_restockText.fill = GridBagConstraints.HORIZONTAL;
		gbc_restockText.gridx = 1;
		gbc_restockText.gridy = 2;
		panel_1.add(restockText, gbc_restockText);
		restockText.setColumns(10);
		
		JLabel priceLabel = new JLabel("Current PriceLevel:");
		GridBagConstraints gbc_priceLabel = new GridBagConstraints();
		gbc_priceLabel.insets = new Insets(0, 0, 5, 5);
		gbc_priceLabel.gridx = 0;
		gbc_priceLabel.gridy = 3;
		panel_1.add(priceLabel, gbc_priceLabel);
		
		priceText = new JTextField();
		priceText.setEditable(false);
		GridBagConstraints gbc_priceText = new GridBagConstraints();
		gbc_priceText.insets = new Insets(0, 0, 5, 0);
		gbc_priceText.fill = GridBagConstraints.HORIZONTAL;
		gbc_priceText.gridx = 1;
		gbc_priceText.gridy = 3;
		panel_1.add(priceText, gbc_priceText);
		priceText.setColumns(10);
		
		JLabel lblCustomersServed = new JLabel("Customers Served:");
		GridBagConstraints gbc_lblCustomersServed = new GridBagConstraints();
		gbc_lblCustomersServed.insets = new Insets(0, 0, 0, 5);
		gbc_lblCustomersServed.gridx = 0;
		gbc_lblCustomersServed.gridy = 5;
		panel_1.add(lblCustomersServed, gbc_lblCustomersServed);
		
		totalCustomersText = new JTextField();
		totalCustomersText.setEditable(false);
		totalCustomersText.setText("0");
		GridBagConstraints gbc_totalCustomersText = new GridBagConstraints();
		gbc_totalCustomersText.fill = GridBagConstraints.HORIZONTAL;
		gbc_totalCustomersText.gridx = 1;
		gbc_totalCustomersText.gridy = 5;
		panel_1.add(totalCustomersText, gbc_totalCustomersText);
		totalCustomersText.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{179, 156, 0};
		gbl_panel_2.rowHeights = new int[]{16, 0, 0, 0, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JLabel lblNewLabel_2 = new JLabel("Customers View");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 0;
		panel_2.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JLabel lblTotalCustomers = new JLabel("Total Customers:");
		GridBagConstraints gbc_lblTotalCustomers = new GridBagConstraints();
		gbc_lblTotalCustomers.insets = new Insets(0, 0, 5, 5);
		gbc_lblTotalCustomers.gridx = 0;
		gbc_lblTotalCustomers.gridy = 1;
		panel_2.add(lblTotalCustomers, gbc_lblTotalCustomers);
		
		numCustomersText = new JTextField();
		numCustomersText.setEditable(false);
		GridBagConstraints gbc_numCustomersText = new GridBagConstraints();
		gbc_numCustomersText.anchor = GridBagConstraints.WEST;
		gbc_numCustomersText.insets = new Insets(0, 0, 5, 0);
		gbc_numCustomersText.gridx = 1;
		gbc_numCustomersText.gridy = 1;
		panel_2.add(numCustomersText, gbc_numCustomersText);
		numCustomersText.setColumns(10);
		numCustomersText.setText("" + Main.getCustomerCount());
		
		JLabel lblAverageItemsPurchased = new JLabel("Average Items Purchased: ");
		GridBagConstraints gbc_lblAverageItemsPurchased = new GridBagConstraints();
		gbc_lblAverageItemsPurchased.insets = new Insets(0, 0, 0, 5);
		gbc_lblAverageItemsPurchased.gridx = 0;
		gbc_lblAverageItemsPurchased.gridy = 3;
		panel_2.add(lblAverageItemsPurchased, gbc_lblAverageItemsPurchased);
		
		avgItemsPurchasedText = new JTextField();
		avgItemsPurchasedText.setEditable(false);
		avgItemsPurchasedText.setText("N/A");
		GridBagConstraints gbc_avgItemsPuchasedText = new GridBagConstraints();
		gbc_avgItemsPuchasedText.anchor = GridBagConstraints.WEST;
		gbc_avgItemsPuchasedText.gridx = 1;
		gbc_avgItemsPuchasedText.gridy = 3;
		panel_2.add(avgItemsPurchasedText, gbc_avgItemsPuchasedText);
		avgItemsPurchasedText.setColumns(10);
		
		totalItems = 0;
		restock = 0;
	}
	
	public void updateItemsGenerated(int items) {
		Text.debug("Updating FactoryPanel");
//		totalItems += items;
		itemsGenTotal.setText(Integer.toString(items));
		itemsGenPerFactory.setText(Double.toString(items/Main.getFactoryCount()));
	}
	
	public void updateItemStock(int items) {
		itemStockText.setText("" + items);
		
	}

	public void updateCustomersServed(int served) {
		totalItems += served;
		totalCustomersText.setText(Integer.toString(served));
		avgItemsPurchasedText.setText(Double.toString(totalItems/(double)Main.getCustomerCount()));
	}

	public void updateRestock(int restockCount) {
		restockText.setText(Integer.toString(restockCount));
	}

	
	public void updateSold() {
//		sold++;
//		itemsSol
		
		
	}

	public void updatePrice(PriceLevel currentPrice) {
		priceText.setText(currentPrice.toString());
		
	}
	
}
