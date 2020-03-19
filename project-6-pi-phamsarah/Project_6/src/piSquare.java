import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class piSquare extends JFrame{
	private static final long serialVersionUID = 1L;
	private JTextField numCollisions;
	private JTextField digitsLabel;
	BigSquare bigS = new BigSquare();	
	private static int size = 10;
	Timer timer;
	
	public piSquare()
	{
		
		timer = new Timer(5, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				bigS.update();
				add(bigS);
			}
		});
		
		this.setTitle("Pi");
		this.setSize(1000, 1000);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());

		JSpinner spinner = new JSpinner();
		spinner.setBounds(245, 11, 29, 20);
		this.add(spinner, BorderLayout.CENTER);
		
		numCollisions = new JTextField();
		numCollisions.setEditable(false);
		numCollisions.setText("collisions");
		numCollisions.setBounds(10, 40, 119, 20);
		numCollisions.setColumns(10);
		numCollisions.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		this.add(numCollisions);
		
		digitsLabel = new JTextField();
		digitsLabel.setEditable(false);
		digitsLabel.setText("Digits of Precision");
		digitsLabel.setBounds(100,-30,100,100);
		digitsLabel.setColumns(10);
		digitsLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		this.add(digitsLabel);
		
		JButton start = new JButton("Start");
		start.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				int precision = (Integer) spinner.getValue();
				System.out.println("Precision : " + precision);		// Take this out later
				squareBounds(precision);
				
				if(e.getSource() == start)
				{
					timer.start();
					bigS.update();
				}
				
			}
		});
		
		start.setBounds(279,11,65,20);
		this.add(start, BorderLayout.CENTER);
		
		bigS = new BigSquare();		
		this.add(bigS);
		
	}
	
	public void squareBounds(int precision)
	{
		int length = 10;
		
		for(int i = 0; i < precision; i++)
		{
			length *= 10;
		}
		
		size = length;
	}
	
	public static int getSquareSize()
	{
		System.out.println("Square : " + size);
		return size;
	}
	
	public static void main(String[] args)
	{
		piSquare square = new piSquare();
		square.setVisible(true);
		square.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

