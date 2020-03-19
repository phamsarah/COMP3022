import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Converter extends JFrame{
	public static void main(String[] args)
	{
		
	}
	Converter(){
		
		JFrame convert = new JFrame();
			convert.setTitle("Binary Converter");
			convert.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			convert.setSize(300,300);
			convert.setLayout(new BorderLayout(100,100));
			
		JButton zero = new JButton("0");
			zero.addActionListener(new addZero());
		
		JTextArea displayNum = new JTextArea("No numbers input yet");
			displayNum.setEditable(false);
			
			displayNum.setSize(300,300);
	
			convert.add(displayNum, BorderLayout.WEST);
			
		convert.pack();
		convert.setVisible(true);
	}
	
	public void addZero(ActionEvent e){
		if(e.getActionCommand().equals("1"))
		{
			binaryValue += "1";
			displayNum.setText(" " + binaryValue);
		}
	}
}
