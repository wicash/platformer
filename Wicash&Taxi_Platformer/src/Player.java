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
	
	//HitBox:
	int[] x0y0=new int[2];
	int[] x1y0=new int[2];
	int[] x2y0=new int[2];
	int[] x0y1=new int[2];
	int[] x1y1=new int[2];
	int[] x2y1=new int[2];
	int[] x0y2=new int[2];
	int[] x1y2=new int[2];
	int[] x2y2=new int[2];
	int[][][] hitbox=new int[3][3][2];
	
	
	
	Player(int x,int y)
	{
		xPos=x;
		yPos=y;
		sichtrichtung=1;
		hp=3;
		inAir=false;
		size=10;
	}
	
	void fillHitbox()
	{
		hitbox[0][0]=x0y0;
		hitbox[1][0]=x0y0;
		hitbox[2][0]=x0y0;
		hitbox[0][1]=x0y0;
		hitbox[1][1]=x0y0;
		hitbox[2][1]=x0y0;
		hitbox[0][2]=x0y0;
		hitbox[1][2]=x0y0;
		hitbox[2][2]=x0y0;
		
		hitbox[0][0][0]=xPos-1;
		hitbox[0][0][1]=yPos-1;
		hitbox[1][0][0]=xPos;
		hitbox[1][0][1]=yPos-1;
		hitbox[2][0][0]=xPos+1;
		hitbox[2][0][1]=yPos-1;
		hitbox[0][1][0]=xPos-1;
		hitbox[0][1][1]=yPos;
		hitbox[1][1][0]=xPos;
		hitbox[1][1][1]=yPos;
		hitbox[2][1][0]=xPos+1;
		hitbox[2][1][1]=yPos;
		hitbox[0][2][0]=xPos-1;
		hitbox[0][2][1]=yPos+1;
		hitbox[1][2][0]=xPos;
		hitbox[1][2][1]=yPos+1;
		hitbox[2][2][0]=xPos+1;
		hitbox[2][2][1]=yPos+1;
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
	
	void fall()
	{
		clear();
		yPos=yPos+1;
		draw();
	}


}

