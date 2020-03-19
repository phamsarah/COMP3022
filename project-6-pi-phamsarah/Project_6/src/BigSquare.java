import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import javax.swing.Timer;

import javax.swing.JPanel;

public class BigSquare extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	private double size = 10.0;
	private double xCoordsOld1 = 270.0;
	private double xCoordsOld2 = 110.0;
	private double xCoords1 = 260.0;
	private double xCoords2 = 100.0;

	public BigSquare()
	{
		update();
	}
	
	public void update()
	{
		if((xCoords1 == 0.0) || ((xCoordsOld1 < xCoords1) && (xCoordsOld1 != 260)))
			moveRight();
		else if ((xCoordsOld1 > xCoords1) && (xCoords1 != 0))
			moveLeft();
		else if ((xCoords1 == xCoordsOld1) && (xCoords2 != 0.0) && (xCoordsOld2 > xCoords2))
			moveLeft();
		else if ((xCoords1 == xCoordsOld1) && (xCoords2 == 0.0) || ((xCoordsOld2 < xCoords2) && (xCoords2 != 100.0)))
			moveRight();
		
		
		repaint();
	}
		
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		
		Rectangle2D movingSquare = new Rectangle2D.Double(xCoords1,100.0,size,size);
		g2.fill(movingSquare);
		g2.draw(movingSquare);
		
		Rectangle2D smallSquare = new Rectangle2D.Double(xCoords2,100.0,10,10);
		g2.draw(smallSquare);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	}
	
	public void moveLeft()
	{
		if(size == 10)
		{
			if(xCoords1 == (100 + size))
			{
				xCoords1 = (100 + size);
				xCoordsOld1 = xCoords1;
				
				xCoordsOld2 = xCoords2;
				xCoords2--;
			}
			else
			{
				xCoordsOld1 = xCoords1;
				xCoords1--;
			}
			
		}
		else
		{
			xCoordsOld1 = xCoords1;
			xCoords1--;
		}
	}
	
	public void moveRight()
	{
		if(size == 10)
		{
			if((xCoords1 == xCoordsOld1) && (xCoords2 == 0.0) || ((xCoordsOld2 < xCoords2) && (xCoords2 != 100.0)))
			{
				xCoordsOld2 = xCoords2;
				xCoords2++;
			}
			else if((xCoordsOld2 < xCoords2) && (xCoords2 == 100.0))
			{
				xCoords1++;
				xCoordsOld2 = xCoords2;
			}
			else 
			{
				xCoordsOld1 = xCoords1;
				xCoords1++;
			}
		}
		else
		{
			xCoordsOld1 = xCoords1;
			xCoords1++;
		}
		

	}
	
}

