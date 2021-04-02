import javax.swing.JFrame;
import java.io.*;
import java.awt.image.*;
import javax.imageio.*;


public class Start  {

	public static void main(String[] args) throws Exception {

		MapEditor m2  = new MapEditor();
		BufferedImage image2 = ImageIO.read(new File("Player.bmp"));
		Player p1    = new Player(50,50, m2.CreateModelFromBMP(image2));			//Spieler erstellen								//View erstellen und Controller+Spieler übergeben
		MapEditor m  = new MapEditor();
		JFrame f = new JFrame("Platformer");
		BufferedImage image = ImageIO.read(new File("Map3.bmp"));
		Map Map1=m.CreateMapFromBMP(image);
		
		Controller c = new Controller(p1,Map1,f);			//Controller erstellen			
		View v       = new View(p1,c,Map1,f);	
		
		long start=System.currentTimeMillis();
		long current;
		long framerate=5;
		
	
		
		
	while(true)
	{
		current=System.currentTimeMillis();
		if(current-start>framerate)
		{
//			System.out.println(current-start);
			c.doAction();
			start=current;
		}
	}
	}

}
