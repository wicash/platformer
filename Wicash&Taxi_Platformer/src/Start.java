
public class Start  {

	public static void main(String[] args) {

		Player p1    = new Player(50,50);			//Spieler erstellen
		Controller c = new Controller(p1);			//Controller erstellen
		View v       = new View(p1,c);				//View erstellen und Controller+Spieler übergeben
		
		long start=System.currentTimeMillis();
		long current;
		long diff=30;
		
	while(true)
	{
		current=System.currentTimeMillis();
		if(current-start>diff)
		{
			p1.fall();
			start=current;
		}
	}
	}

}
