import javax.swing.JFrame;
import java.io.*;
import java.awt.image.*;
import javax.imageio.*;


public class Start  {

	public static void main(String[] args) throws Exception {

		MapEditor m2  = new MapEditor();
		BufferedImage image2 = ImageIO.read(new File("Player.bmp"));
		Player p1    = new Player(100,50, m2.CreateModelFromBMP(image2));			//Spieler erstellen								//View erstellen und Controller+Spieler übergeben
		MapEditor m  = new MapEditor();
		JFrame f = new JFrame("Platformer");
		BufferedImage image = ImageIO.read(new File("Map3.bmp"));
		Map Map1=m.CreateMapFromBMP(image);
		
		Controller c = new Controller(p1,Map1,f);			//Controller erstellen			
		View v       = new View(p1,c,Map1,f);	
		double current;
		double start=System.currentTimeMillis();
		double framerate=20;
		double current2;
		double start2=System.currentTimeMillis();
		double tikrate=4;
	
	
		
		
	while(true)
	{
		current=System.currentTimeMillis();

		if(current-start>framerate)
		{
			System.out.println("Framerate: "+(current-start));
			start=current;
			v.drawMap();
		
			
//			System.out.println(current-start);
			

		
		}
		current2=System.currentTimeMillis();
		if(current2-start2>tikrate)
		{
			System.out.println("Tikrate: "+(current2-start2));
			start2=current2;
			c.doAction();
		}
	

		
	}
	}

}
