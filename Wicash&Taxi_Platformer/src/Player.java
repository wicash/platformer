import java.awt.Color;
import java.awt.Graphics;
import java.util.Arrays;

public class Player {
	
	int xPos;
	int yPos; 
	int sichtrichtung; // 0=Links , 1=Rechts
	int hp; //Leben
	boolean inAir; 
	int size;
	int xSize;
	int ySize;
	Graphics g;
	int movementSpeed=2;
	int jumpCounter=0;
	int gravity=2;
	int sprunghoehe=50;
	int verbleibendeSprunghoehe=sprunghoehe;
	boolean doubleJump;
	int [][] playerModel;
	
	//HitBox:

	int[][][] hitbox;
	
	
	
	Player(int x,int y)
	{
		xPos=x;
		yPos=y;
		sichtrichtung=1;
		hp=3;
		inAir=false;
		size=20;
		xSize=size;
		ySize=size;
		hitbox=new int[ySize][xSize][2];
		setPlayerModel();
		setHitbox();
		doubleJump = true;
	}
	

	
	Player(int x,int y, int[][] playerModel)
	{
		xPos=x;
		yPos=y;
		sichtrichtung=1;
		hp=3;
		inAir=false;
		this.playerModel=playerModel;
		xSize=playerModel.length;
		ySize=playerModel[1].length;
		hitbox=new int[ySize][xSize][2];
		setHitbox();
		doubleJump = true;
	}
	
	void setPlayerModel()
	{
		int[][] m=new int[xSize][ySize];
		
		for(int y=0;y<ySize;y++)
		{
			for(int x=0;x<xSize;x++)
			{
				m[x][y]=1;
				
			}
		}
		this.playerModel=m;
	}
	
	void setHitbox()
	{

		for(int y=0;y<ySize;y++)
		{
			for(int x=0;x<xSize;x++)
			{
				for(int z=0;z<2;z++)
				{
					if(playerModel[x][y]==1) {
						if(z==0) hitbox[y][x][z]=xPos+x;
						if(z==1)hitbox[y][x][z]=yPos+y;
					}else hitbox[y][x][z]=0;
				}
			}
		}

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

		
		
		for(int y=0;y<ySize;y++)
		{
			for(int x=0;x<xSize;x++)
			{
				
					if(hitbox[y][x][1]!=0) {
						g.fillRect(hitbox[y][x][0],hitbox[y][x][1],1,1);

				}
			}
		}
		

	}
	
	void setGraphics(Graphics g)		//"Blatt" übergeben
	{
		this.g=g;
		g.setColor(Color.BLUE);
	}
	
	void moveRight()					//Bewegen
	{
		clear();
		xPos=xPos+1;
		this.setHitbox();
		draw();
	}
	void moveLeft()
	{
		clear();
		xPos=xPos-1;
		this.setHitbox();
		draw();
	}
	void moveUp()
	{
		clear();
		yPos=yPos-1;
		this.setHitbox();
		draw();
	}
	void moveDown()
	{
		clear();
		yPos=yPos+1;
		this.setHitbox();
		draw();
		

//		for(int mov=movementSpeed;mov>0;mov--)
//		{
//			if()yPos=yPos+1;
//		}
	}
	
	void clear()						//Spieler an Position optisch löschen
	{
		
		for(int y=0;y<ySize;y++)
		{
			for(int x=0;x<xSize;x++)
			{
				
					if(hitbox[y][x][1]!=0) {
						g.clearRect(hitbox[y][x][0],hitbox[y][x][1],1,1);

				}
			}
		}
	
	}
	
	
	void jump()
	{
//		clear();
//		yPos=yPos-2;
//		if(jumpCounter>0) {jumpCounter=jumpCounter-1; }
//		this.setHitbox();
//		draw();
		
		clear();
		yPos=yPos-1;
		this.setHitbox();
		draw();
		
		
		
	}
	
	void fall()
	{
		clear();
		yPos=yPos+1;
		this.setHitbox();
		draw();
	}
	
	
	int[][] giveFoot()
	{
		int p =0;
		int[][] foot=new int[xSize*15][2];
		for(int x=0;x<foot.length;x++){Arrays.fill(foot[x], 0);}
		
		
		for(int y=0;y<ySize;y++)
		{
			for(int x=0;x<xSize;x++)
			{
				for(int z=0;z<2;z++)
				{
					if(hitbox[y][x][z]==0) {}
					else
					{
						if(y+1<ySize)
						{
							if(hitbox[y+1][x][z]==0)
							{
								foot[p][z]=hitbox[y][x][z];
								if(z==1)p++;
							}
						}
						else
						{
							foot[p][z]=hitbox[y][x][z];
							if(z==1)p++;
						}
					}
				}
				p++;
			}
		}
		
		return foot;
	}
	
	int[][] giveRightSide()
	{
		int[][] side=new int[ySize][2];

		for(int y=0;y<ySize;y++)
		{

			for(int z=0;z<2;z++)
			{

				side[y][z]=hitbox[y][xSize-1][z];
			}
		}
		
		return side;
	}
	
	int[][] giveLeftSide()
	{
		int[][] side=new int[ySize][2];

		for(int y=0;y<ySize;y++)
		{

			for(int z=0;z<2;z++)
			{

				side[y][z]=hitbox[y][0][z];
			}
		}
		
		return side;
	}
	
	int[][] giveHead()
	{
		int[][] head=new int[xSize][2];

		for(int x=0;x<xSize;x++)
		{

			for(int z=0;z<2;z++)
			{

				head[x][z]=hitbox[0][x][z];
			}
		}
		
		return head;
	}
	
	void setJumpCounter(int j)
	{
		jumpCounter=j;
	}
	
	


}

