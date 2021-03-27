
public class Start  {

	public static void main(String[] args) {

		Player p1    = new Player(50,50);			//Spieler erstellen								//View erstellen und Controller+Spieler übergeben
		MapEditor m  = new MapEditor(500,500);
		Map Map1=m.createMap1();
		Controller c = new Controller(p1,Map1);			//Controller erstellen			
		View v       = new View(p1,c,Map1);	
		
		
		long start=System.currentTimeMillis();
		long current;
		long diff=30;
		
	while(true)
	{
		current=System.currentTimeMillis();
		if(current-start>diff)
		{
			c.fall();
			start=current;
		}
	}
	}

}
