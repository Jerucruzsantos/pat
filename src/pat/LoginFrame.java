package pat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class LoginFrame extends JFrame implements ActionListener {

	Container container = getContentPane();
	JLabel userLabel = new JLabel("USERNAME");
	JLabel passwordLabel = new JLabel("PASSWORD");
	JTextField userTextField = new JTextField();
	JPasswordField passwordField = new JPasswordField();
	JButton loginButton = new JButton("LOGIN");
	JButton resetButton = new JButton("RESET");
	JCheckBox showPassword = new JCheckBox("Show Password");

	LoginFrame() {

		setLayoutManager();
		setLocationAndSize();
		addComponentsToContainer();
		addActionEvent();
	}

	public void setLayoutManager() {
		container.setLayout(null);

	}

	public void setLocationAndSize() {
		userLabel.setBounds(10, 150, 100, 30);
		userLabel.setForeground(Color.BLACK);
		userLabel.setFont(new Font("Serif", Font.BOLD, 12));
		passwordLabel.setBounds(10, 200, 100, 30);
		passwordLabel.setForeground(Color.BLACK);
		passwordLabel.setFont(new Font("Serif", Font.BOLD, 12));
		userTextField.setBounds(85, 150, 150, 30);
		passwordField.setBounds(85, 200, 150, 30);
		showPassword.setBounds(115, 240, 120, 30);
		loginButton.setBounds(10, 280, 100, 30);
		resetButton.setBounds(135, 280, 100, 30);

	}

	public void addComponentsToContainer() {
		container.add(userLabel);
		container.add(passwordLabel);
		container.add(userTextField);
		container.add(passwordField);
		container.add(showPassword);
		container.add(loginButton);
		container.add(resetButton);

	}

	public void addActionEvent() {
		loginButton.addActionListener(this);
		resetButton.addActionListener(this);
		showPassword.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String userText;
		char pwdText[];
		// Coding Part of LOGIN button
		if (e.getSource() == loginButton) {
			userText = userTextField.getText();
			pwdText = passwordField.getPassword();
			if (userText.equals("admin") && Arrays.toString(pwdText).replace("[", "").replace("]", "").replaceAll(", +?", "").equals("12345")) {
				JOptionPane.showMessageDialog(this, "Login Successful");
				this.dispose();
				Menu menu = new Menu();
			} else {
				JOptionPane.showMessageDialog(this, "Invalid Username or Password");
			}

		}
		// Coding Part of RESET button
		if (e.getSource() == resetButton) {
			userTextField.setText("");
			passwordField.setText("");
		}
		// Coding Part of showPassword JCheckBox
		if (e.getSource() == showPassword) {
			if (showPassword.isSelected()) {
				passwordField.setEchoChar((char) 0);
			} else {
				passwordField.setEchoChar('*');
			}

		}

	}

}