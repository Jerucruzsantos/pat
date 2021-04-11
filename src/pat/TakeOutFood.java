package pat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TakeOutFood extends JFrame implements ActionListener {

	private JPanel receipt, titleHolder = new JPanel(new FlowLayout());
	private JButton myButton = new JButton("Take out Order");
	private JLabel label = new JLabel("RECIPT!");
	private JLabel[] item, price;
	private JPanel[] itemPanel, pricePanel;

	TakeOutFood(Map<String, Integer> orders) {
		item = new JLabel[orders.size()];
		price = new JLabel[orders.size()];
		itemPanel = new JPanel[orders.size()];
		pricePanel = new JPanel[orders.size()];
		
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		receipt = new JPanel(new GridLayout(orders.size(), 2));
		
		double sum = 0;
		for (int i = 0; i < orders.size(); i++) {
			double calculatedPrice = orders.get(orders.keySet().toArray()[i]) * Menu.prices.get(orders.keySet().toArray()[i]);
			
			item[i] = new JLabel("<html>" + orders.keySet().toArray()[i] + "<br>x" + orders.get(orders.keySet().toArray()[i]) + "</html>");
			price[i] = new JLabel("<html><br>₱ " + String.format("%.2f", calculatedPrice) + "</html>");
			itemPanel[i] = new JPanel(new FlowLayout());
			pricePanel[i] = new JPanel(new FlowLayout());
			
//			item[i].setIcon(Menu.icons.get(orders.keySet().toArray()[i]));
			item[i].setFont(new Font(null, Font.PLAIN, 15));
			price[i].setFont(new Font(null, Font.PLAIN, 15));
			
			itemPanel[i].add(item[i]);
			pricePanel[i].add(price[i]);
			
			receipt.add(itemPanel[i]);
			receipt.add(pricePanel[i]);
			
			sum += calculatedPrice;
		}
		
		JPanel bottomRow = new JPanel(new GridLayout(2, 1));
		JPanel ubRow = new JPanel(new FlowLayout());
		JPanel lbRow = new JPanel(new FlowLayout());
		
		JLabel total = new JLabel("<html>TOTAL: ₱ " + String.format("%.2f", sum) + "</html>");
		total.setFont(new Font(null, Font.PLAIN, 15));
		
		ubRow.add(total);
		lbRow.add(myButton);
		bottomRow.add(ubRow);
		bottomRow.add(lbRow);
		
		this.setTitle("TAKE OUT!!");
		this.setResizable(false);
		
		label.setFont(new Font(null, Font.PLAIN, 25));
		
		titleHolder.add(label);

		myButton.setFocusCycleRoot(true);
		myButton.addActionListener(this);
		
		contentPane.add(titleHolder, BorderLayout.NORTH);
		contentPane.add(receipt, BorderLayout.CENTER);
		contentPane.add(bottomRow, BorderLayout.SOUTH);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(320, 200 + (25 * orders.size()-1));
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == myButton)
			this.dispose();
	}

}
