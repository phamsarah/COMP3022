import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextArea;

public class BinaryConverter {

	private JFrame frame;
	private int i = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BinaryConverter window = new BinaryConverter();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BinaryConverter() {

		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea displayNum = new JTextArea();
		displayNum.setFont(new Font("Tahoma", Font.BOLD, 17));
		displayNum.setText("No numbers input yet");
		displayNum.setEditable(false);
		displayNum.setBounds(51, 23, 333, 118);
		
		
		frame.getContentPane().add(displayNum);
		JButton one = new JButton("1");
		one.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		
		one.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(i == 0)
				{
					displayNum.setText("");
				}
				
				displayNum.setText(displayNum.getText() + "1");
				i++;
			}
			
		});
		
		
		
		one.setBounds(294, 170, 89, 23);
		frame.getContentPane().add(one);
		
		JButton zero = new JButton("0");
		zero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(i == 0)
				{
					displayNum.setText("");
				}
				
				displayNum.setText(displayNum.getText() + "0");
				i++;
			}
		});
		zero.setFont(new Font("Tahoma", Font.BOLD, 14));
		zero.setBounds(51, 172, 89, 23);
		frame.getContentPane().add(zero);
		
		JButton convert = new JButton("Convert");
		convert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// [Jtext area][ displayNum ]  displayNum.getText() STRING ONLY
				String binary = displayNum.getText();
				int decimal = Integer.parseInt(binary, 2);
				
				String decimalString = Integer.toString(decimal);
				displayNum.setText("Binary string entererd: " + displayNum.getText() + "\n" + "Decimal Representation: " + decimalString);
				
				i = 0;
			}
		});
		convert.setFont(new Font("Tahoma", Font.BOLD, 14));
		convert.setBounds(163, 201, 107, 35);
		frame.getContentPane().add(convert);
		

	}
}
