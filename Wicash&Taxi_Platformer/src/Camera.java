import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;

import javax.swing.JFrame;

public class Camera extends JFrame {

	Player p;
	JFrame f;
	Graphics g;
	Map m;
	
	Camera(Player p,JFrame f, Map m)
	{
		this.p=p;
		this.f=f;
		this.m=m;
	}
	
	void setGraphics(Graphics g)		//"Blatt" übergeben
	{
		this.g=g;
	}
	
	void drawMap()
	{
		System.out.println("sadas");
		for(int x=1 ; x<f.getWidth() ; x++) 
		{
			for(int y=1 ; y<f.getWidth() ; y++)
			{

				if(y>=f.getHeight()/2  && x>=f.getWidth()/2 && y<f.getHeight()/2+p.ySize && x<f.getWidth()/2+p.xSize && p.playerModel[x-f.getWidth()/2][y-f.getHeight()/2]==1 )
				  {
						g.setColor(Color.BLUE);
						g.fillRect(x,y,1,1);
						g.setColor(Color.BLACK);
					
				  }
				else if(p.xPos-f.getWidth()/2+x<0 || p.yPos-f.getHeight()/2+y<0 )
					{
					
					g.fillRect(x,y,1,1);
					}
				else if(p.xPos-f.getWidth()/2+x > m.map[1].length-1 || p.yPos-f.getHeight()/2+y > m.map.length-1)
				{
					
					g.fillRect(x,y,1,1);
				}
				else if(p.xPos-f.getWidth()/2+x>=0 && p.yPos-f.getHeight()/2+y>=0)
				{
					if(m.map[p.yPos-f.getHeight()/2+y][p.xPos-f.getWidth()/2+x]>0)
					{
						g.fillRect(x,y,1,1);
					}
					else if(m.map[p.yPos-f.getHeight()/2+y][p.xPos-f.getWidth()/2 +x]==0)
					{
						g.clearRect(x, y, 1, 1);
					}
				}
				
					
			}
		}
	}
}
