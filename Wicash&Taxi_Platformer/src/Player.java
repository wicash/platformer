import java.awt.Color;
import java.awt.Graphics;

public class Player {
	
	int xPos;
	int yPos; 
	int sichtrichtung; // 0=Links , 1=Rechts
	int hp; //Leben
	boolean inAir; 
	int size;
	Graphics g;
	int movementSpeed=5;
	
	Player(int x,int y)
	{
		xPos=x;
		yPos=y;
		sichtrichtung=1;
		hp=3;
		inAir=false;
		size=10;	
	}
	
	int[] getPos()					// Position holen x,y und Z!!!
	{
		return new int[] {xPos,yPos};
	}
	

	int getSize()					// Größe holen
	{
		return size;
	}
	
	void draw()							//Spieler zeichnen
	{
		g.fillRect(xPos,yPos,size,size);
	}
	
	void setGraphics(Graphics g)		//"Blatt" übergeben
	{
		this.g=g;
		g.setColor(Color.BLUE);
	}
	
	void moveRight()					//Bewegen
	{
		xPos=xPos+movementSpeed;
	}
	void moveLeft()
	{
		xPos=xPos-movementSpeed;
	}
	void moveUp()
	{
		yPos=yPos-movementSpeed;
	}
	void moveDown()
	{
		yPos=yPos+movementSpeed;
	}
	
	void clear()						//Spieler an Position optisch löschen
	{
		g.clearRect(xPos,yPos,size+1,size+1);
	}


}

