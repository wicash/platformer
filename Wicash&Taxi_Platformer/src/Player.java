
public class Player {
	
	int xPos;
	int yPos; 
	int sichtrichtung; // 0=Links , 1=Rechts
	int hp; //Leben
	boolean inAir; 
	int size;
	
	Player(int x,int y)
	{
		xPos=x;
		yPos=y;
		sichtrichtung=1;
		hp=3;
		inAir=false;
		size=3;	
	}
	
	int[] getPos()					// Position holen x,y und Z!!!
	{
		return new int[] {xPos,yPos};
	}
	
	void move()						// Spieler bewegen
	{
		if(sichtrichtung==0)
			{xPos=xPos-1;}
		else
			{xPos=xPos+1;}
				
	}
	
	int getSize()					// Gr��e holen
	{
		return size;
	}


}
