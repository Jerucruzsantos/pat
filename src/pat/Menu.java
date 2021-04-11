package pat;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;
import java.util.Currency;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Toolkit;

public class Menu extends JFrame {
	
	private Map<String, Integer> orders = new HashMap<String, Integer>();
	private JButton takeout = new JButton("Take out");
	private JLabel[] products = new JLabel[10];
	private JLabel[] productNameHolder = new JLabel[10];
	private JLabel[] productCostHolder = new JLabel[10];
	private JButton[] productIncludeBtn = new JButton[10];
	private JTextField[] productCountField = new JTextField[10];
	private static String[] productNames = {
		"Pearl Tea",
		"Winter Melon",
		"Okinawa",
		"Red Choco Milktea",
		"Thai Milktea",
		"Manggo Sunset",
		"Yogurt",
		"Lychee",
		"Hokaido",
		"Passion"
	};
	private static URL[] productImage = {
		Menu.class.getResource("resources/tea_flavors/pearl milktea.png"),
		Menu.class.getResource("resources/tea_flavors/wintermelon.png"),
		Menu.class.getResource("resources/tea_flavors/okinawa.png"),
		Menu.class.getResource("resources/tea_flavors/redChocoMilktea.png"),
		Menu.class.getResource("resources/tea_flavors/thaitahi.png"),
		Menu.class.getResource("resources/tea_flavors/mangosunset.png"),
		Menu.class.getResource("resources/tea_flavors/northernyogurt.png"),
		Menu.class.getResource("resources/tea_flavors/sunriselychee.png"),
		Menu.class.getResource("resources/tea_flavors/hokaido.png"),
		Menu.class.getResource("resources/tea_flavors/aurorapassion.png")
	};
	private JLabel wallpaper = new JLabel();
	private JPanel menu = new JPanel(new GridLayout(2, 5));
	private JPanel buttonPanel = new JPanel(new FlowLayout());
	private JPanel container = new JPanel(new BorderLayout());
	private static Dimension upperSize = new Dimension(1024, 600);
	private static Dimension defaultSize = new Dimension(1024, 640);
	
	public static Map<String, Double> prices = new HashMap<String, Double>() {
		{
			put(productNames[0], Math.floor(Math.random()*(150-50+1)+50));
			put(productNames[1], Math.floor(Math.random()*(150-50+1)+50));
			put(productNames[2], Math.floor(Math.random()*(150-50+1)+50));
			put(productNames[3], Math.floor(Math.random()*(150-50+1)+50));
			put(productNames[4], Math.floor(Math.random()*(150-50+1)+50));
			put(productNames[5], Math.floor(Math.random()*(150-50+1)+50));
			put(productNames[6], Math.floor(Math.random()*(150-50+1)+50));
			put(productNames[7], Math.floor(Math.random()*(150-50+1)+50));
			put(productNames[8], Math.floor(Math.random()*(150-50+1)+50));
			put(productNames[9], Math.floor(Math.random()*(150-50+1)+50));
		}
	};
	
	public static Map<String, ImageIcon> icons = new HashMap<String, ImageIcon>() {
		{
			put(productNames[0], new ImageIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(productImage[0])).getImage().getScaledInstance(87/2, 173/2, Image.SCALE_SMOOTH)));
			put(productNames[1], new ImageIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(productImage[1])).getImage().getScaledInstance(87/2, 173/2, Image.SCALE_SMOOTH)));
			put(productNames[2], new ImageIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(productImage[2])).getImage().getScaledInstance(87/2, 173/2, Image.SCALE_SMOOTH)));
			put(productNames[3], new ImageIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(productImage[3])).getImage().getScaledInstance(87/2, 173/2, Image.SCALE_SMOOTH)));
			put(productNames[4], new ImageIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(productImage[4])).getImage().getScaledInstance(87/2, 173/2, Image.SCALE_SMOOTH)));
			put(productNames[5], new ImageIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(productImage[5])).getImage().getScaledInstance(87/2, 173/2, Image.SCALE_SMOOTH)));
			put(productNames[6], new ImageIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(productImage[6])).getImage().getScaledInstance(87/2, 173/2, Image.SCALE_SMOOTH)));
			put(productNames[7], new ImageIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(productImage[7])).getImage().getScaledInstance(87/2, 173/2, Image.SCALE_SMOOTH)));
			put(productNames[8], new ImageIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(productImage[8])).getImage().getScaledInstance(87/2, 173/2, Image.SCALE_SMOOTH)));
			put(productNames[9], new ImageIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(productImage[9])).getImage().getScaledInstance(87/2, 173/2, Image.SCALE_SMOOTH)));
		}
	};

	public Menu() {
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0));
		contentPane.setSize(upperSize);
		contentPane.setMaximumSize(upperSize);
		contentPane.setMinimumSize(upperSize);
		contentPane.setPreferredSize(upperSize);
		
		container.setOpaque(false);
		
		menu.setSize(upperSize);
		menu.setMaximumSize(upperSize);
		menu.setMinimumSize(upperSize);
		menu.setPreferredSize(upperSize);
		menu.setOpaque(false);
		
		for (int i = 0; i < products.length; i++) {
			products[i] = new JLabel(new ImageIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(productImage[i])).getImage().getScaledInstance(87/2, 173/2, Image.SCALE_SMOOTH)));
			products[i].setOpaque(false);
			products[i].setLayout(new FlowLayout());
			
			JPanel panel = new JPanel(new GridLayout(4, 1));
			panel.setOpaque(false);
			
			productNameHolder[i] = new JLabel(productNames[i]);
			productCostHolder[i] = new JLabel("₱ " + prices.get(productNames[i]));
			productIncludeBtn[i] = new JButton("Include");
			productCountField[i] = new JTextField("1");
			
			productNameHolder[i].setOpaque(false);
			
			final int ii = i;
			productIncludeBtn[i].addActionListener((ActionEvent e) -> {
				if (productCountField[ii].isEnabled()) {
					productIncludeBtn[ii].setText("Include");
					productCountField[ii].setEnabled(false);
				}
				else {
					productIncludeBtn[ii].setText("Exclude");
					productCountField[ii].setEnabled(true);
				}
			});
			
			productCountField[i].setEnabled(false);
			productCountField[i].addKeyListener(new KeyListener() {
				private void removeKey(KeyEvent e) {
					if ((e.getKeyChar() + "").matches("[a-zA-Z]")) {
						productCountField[ii].setText(productCountField[ii].getText().replaceAll("[a-zA-Z\\s]", ""));
					}
				}
				@Override public void keyTyped(KeyEvent e) {removeKey(e);}
				@Override public void keyReleased(KeyEvent e) {removeKey(e);}
				@Override public void keyPressed(KeyEvent e) {removeKey(e);}
			});
			
			panel.add(productNameHolder[i]);
			panel.add(productCostHolder[i]);
			panel.add(productIncludeBtn[i]);
			panel.add(productCountField[i]);
			
			products[i].add(panel);
		}
		for (JLabel l : products) {
			menu.add(l);
		}
		
		buttonPanel.add(takeout);
		
		container.add(menu, BorderLayout.CENTER);
		container.add(buttonPanel, BorderLayout.SOUTH);
		
		wallpaper.setOpaque(true);
		wallpaper.setSize(upperSize);
		wallpaper.setMaximumSize(upperSize);
		wallpaper.setMinimumSize(upperSize);
		wallpaper.setPreferredSize(upperSize);
		wallpaper.setIcon(new ImageIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("resources/bg/wallpaper.jpg"))).getImage().getScaledInstance(1024, 640, Image.SCALE_SMOOTH)));
		wallpaper.setLayout(new BorderLayout());
		wallpaper.add(container);
		
		contentPane.add(wallpaper);
		
		this.setTitle("ORDER!!!");
		this.setResizable(false);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("resources/bg/icon.jpeg")));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(defaultSize);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		// ALTERNATIVE CLICK HANDLER
		takeout.addActionListener((ActionEvent e) -> {
			for (int i = 0; i < products.length; i++) {
				if (productCountField[i].isEnabled()) {
					if (productCountField[i].getText().matches(".*\\D+.*")) {
						JOptionPane.showConfirmDialog(null, "There's an invalid character found at the product amount of " + productNames[i], "Invalid character detected", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
						orders = new HashMap<String, Integer>();
						return;
					}
					else {
						orders.put(productNames[i], Integer.parseInt(productCountField[i].getText()));
					}
				}
			}
			
			this.dispose();
			new TakeOutFood(orders);
		});
	}
}
