import javax.swing.JFrame;

public class Start  {

	public static void main(String[] args) {

		Player p1    = new Player(50,50);			//Spieler erstellen								//View erstellen und Controller+Spieler übergeben
		MapEditor m  = new MapEditor(500,500);
		JFrame f = new JFrame("Platformer");
		m.createMap1();
		Map Map1=m.giveMap();
		Controller c = new Controller(p1,Map1,f);			//Controller erstellen			
		View v       = new View(p1,c,Map1,f);	
		
		
		long start=System.currentTimeMillis();
		long current;
		long diff=30;
		
	while(true)
	{
		current=System.currentTimeMillis();
		if(current-start>diff)
		{
			c.doAction();
			start=current;
		}
	}
	}

}
