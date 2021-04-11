package pat;

	import java.awt.Color;
	import java.awt.Font;
	import java.awt.Toolkit;

	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JPanel;
	import javax.swing.ImageIcon;
	import javax.swing.SwingConstants;

	public class Login {

		public static void main(String[] a) {

			JLabel title = new JLabel("Logo");
			title.setHorizontalAlignment(SwingConstants.CENTER);
			title.setBackground(Color.BLACK);
			title.setIcon(new ImageIcon(Login.class.getResource("resources/bg/logo.png")));
			
			LoginFrame frame = new LoginFrame();

			title.setBounds(29, 0, 206, 135);
			title.setFont(new Font(null, Font.PLAIN, 25));

			frame.getContentPane().add(title);

			JLabel background = new JLabel("bground");
			background.setHorizontalAlignment(SwingConstants.CENTER);
			background.setIcon(new ImageIcon(Login.class.getResource("resources/bg/driptea.png")));
			background.setBounds(259, 0, 414, 344);
			frame.getContentPane().add(background);

			JLabel loginBackground = new JLabel("LogBground");
			loginBackground.setVerticalAlignment(SwingConstants.BOTTOM);
			loginBackground.setIcon(new ImageIcon(Login.class.getResource("resources/bg/background.jpg")));
			loginBackground.setBounds(0, 0, 267, 344);
			frame.getContentPane().add(loginBackground);

			frame.setTitle("Login in Driptea!");
			frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("resources/bg/icon.jpeg")));
			frame.setVisible(true);
			frame.setBounds(10, 10, 679, 372);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setResizable(false);

		}
	}

