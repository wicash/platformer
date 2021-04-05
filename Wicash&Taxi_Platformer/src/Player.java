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
	int movementSpeed=3;
	int jumpCounter=0;
	int gravity=3;
	int sprunghoehe=140;
	int verbleibendeSprunghoehe=sprunghoehe;
	boolean doubleJump;
	int [][] playerModel;
	Camera cam;
	
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
	
	void setCamera(Camera cam)
	{
		this.cam=cam;
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
	
	void drawLeftMovement()							//Spieler zeichnen
	{
		int[][] left=this.giveLeftSide();
				
				for(int x=0;left[x][0]!=0;x++)
				{
					g.fillRect(left[x][0]-1, left[x][1], 1, 1);
				}
				
		int[][] right=this.giveRightSide();
				
				for(int x=0;right[x][0]!=0;x++)
				{
					g.clearRect(right[x][0], right[x][1], 1, 1);
				}
		
	}
	
	void drawRightMovement()							//Spieler zeichnen
	{
		int[][] right=this.giveRightSide();
				
				for(int x=0;right[x][0]!=0;x++)
				{
					g.fillRect(right[x][0]+1, right[x][1], 1, 1);
				}
				
		int[][] left=this.giveLeftSide();
				
				for(int x=0;left[x][0]!=0;x++)
				{ 
					g.clearRect(left[x][0], left[x][1], 1, 1);
				}
		
	}
	
	void drawUpMovement()							//Spieler zeichnen
	{
		int[][] head=this.giveHead();
				
				for(int x=0;head[x][0]!=0;x++)
				{
					g.fillRect(head[x][0], head[x][1]-1, 1, 1);
				}
				
		int[][] foot=this.giveFoot();
				
				for(int x=0;foot[x][0]!=0;x++)
				{
					g.clearRect(foot[x][0], foot[x][1], 1, 1);
				}
		
	}
	
	void drawDownMovement()							//Spieler zeichnen
	{
		int[][] foot=this.giveFoot();
				
				for(int x=0;foot[x][0]!=0;x++)
				{
					g.fillRect(foot[x][0], foot[x][1]+1, 1, 1);
				}
				
		int[][] head=this.giveHead();
				
				for(int x=0;head[x][0]!=0;x++)
				{
					g.clearRect(head[x][0], head[x][1], 1, 1);
				}
		
	}
	
	void setGraphics(Graphics g)		//"Blatt" übergeben
	{
		this.g=g;
		g.setColor(Color.BLUE);
	}
	

	void moveLeft()
	{

		//drawLeftMovement();
		xPos=xPos-1;
		this.setHitbox();

		
		//cam.setMap();
		

	}
	void moveRight()
	{
		//drawRightMovement();
		xPos=xPos+1;
		this.setHitbox();
		
		//cam.setMap();
		//System.out.println("Esdasdasd");
	}
	void moveDown()
	{

		
		//drawDownMovement()
		yPos=yPos+1;
		this.setHitbox();
		//cam.setMap();



	}
	void moveUp()
	{
		//drawUpMovement();
		yPos=yPos-1;
		this.setHitbox();
		//cam.setMap();

	}
	
	
//	void moveRight()					//Bewegen
//	{
//		clear();
//		xPos=xPos+1;
//		this.setHitbox();
//		draw();
//	}
//	void moveLeft()					//Bewegen
//	{
//		clear();
//		xPos=xPos-1;
//		this.setHitbox();
//		draw();
//	}
//	void moveUp()
//	{
//		clear();
//		yPos=yPos-1;
//		this.setHitbox();
//		draw();
//	}
//	void moveDown()
//	{
//		clear();
//		yPos=yPos+1;
//		this.setHitbox();
//		draw();
		

//		for(int mov=movementSpeed;mov>0;mov--)
//		{
//			if()yPos=yPos+1;
//		}
	
	
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
		
		//clear();
		yPos=yPos-1;
		this.setHitbox();
		//draw();
		//cam.setMap();
		
		
		
	}
	
	void fall()
	{
		//clear();
		yPos=yPos+1;
		this.setHitbox();
		//draw();
		//cam.setMap();
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
				
			}
		}
		
		return foot;
	}
	
	int[][] giveRightSide()
	{
		
		int p =0;
		int[][] side=new int[ySize*15][2];
		for(int x=0;x<side.length;x++){Arrays.fill(side[x], 0);}
		
		
		for(int x=xSize-1;x>=0;x--)
		{

			for(int y=ySize-1;y>=0;y--)
			{
				for(int z=0;z<2;z++)
				{
					if(hitbox[y][x][z]==0) {}
					else
					{
						if(x+1<xSize)
						{
							if(hitbox[y][x+1][z]==0)
							{
								side[p][z]=hitbox[y][x][z];
								//System.out.println(side[p][z]);
								if(z==1)p++;
							}
						}
						else
						{
							side[p][z]=hitbox[y][x][z];
							//System.out.println(side[p][z]);
							if(z==1)p++;
						}
					}
				}
				
			}
		}
		
		return side;
	}
	
	int[][] giveRightSideStartingTopRight()
	{
		int p =0;
		int[][] side=new int[ySize*15][2];
		for(int x=0;x<side.length;x++){Arrays.fill(side[x], 0);}
		
		
		for(int x=xSize-1;x>=0;x--)
		{

			for(int y=0;y<ySize;y++)
			{
				for(int z=0;z<2;z++)
				{
					if(hitbox[y][x][z]==0) {}
					else
					{
						if(x>0)
						{
							if(hitbox[y][x-1][z]==0)
							{
								side[p][z]=hitbox[y][x][z];
								if(z==1)p++;
							}
						}
						else
						{
							side[p][z]=hitbox[y][x][z];
							if(z==1)p++;
						}
					}
				}
				
			}
		}
	
	
	return side;
}
	
	int[][] giveLeftSide()
	{
		int p =0;
		int[][] side=new int[ySize*15][2];
		for(int x=0;x<side.length;x++){Arrays.fill(side[x], 0);}
		
		
		for(int x=0;x<xSize;x++)
		{

			for(int y=ySize-1;y>=0;y--)
			{
				for(int z=0;z<2;z++)
				{
					if(hitbox[y][x][z]==0) {}
					else
					{
						if(x>0)
						{
							if(hitbox[y][x-1][z]==0)
							{
								side[p][z]=hitbox[y][x][z];
								if(z==1)p++;
							}
						}
						else
						{
							side[p][z]=hitbox[y][x][z];
							if(z==1)p++;
						}
					}
				}
				
			}
		}
		return side;
	}
		
		int[][] giveLeftSideStartingTopRight()
		{
			int p =0;
			int[][] side=new int[ySize*15][2];
			for(int x=0;x<side.length;x++){Arrays.fill(side[x], 0);}
			
			
			for(int x=0;x<xSize;x++)
			{

				for(int y=0;y<ySize;y++)
				{
					for(int z=0;z<2;z++)
					{
						if(hitbox[y][x][z]==0) {}
						else
						{
							if(x>0)
							{
								if(hitbox[y][x-1][z]==0)
								{
									side[p][z]=hitbox[y][x][z];
									if(z==1)p++;
								}
							}
							else
							{
								side[p][z]=hitbox[y][x][z];
								if(z==1)p++;
							}
						}
					}
					
				}
			}
		
		
		return side;
	}
	
	int[][] giveHead()
	{
		int p =0;
		int[][] head=new int[xSize*15][2];
		for(int x=0;x<head.length;x++){Arrays.fill(head[x], 0);}
		
		
		for(int y=0;y<ySize;y++)
		{

			for(int x=0;x<xSize;x++)
			{
				for(int z=0;z<2;z++)
				{
					if(hitbox[y][x][z]==0) {}
					else
					{
						if(y>0)
						{
							if(hitbox[y-1][x][z]==0)
							{
								head[p][z]=hitbox[y][x][z];
								if(z==1)p++;
							}
						}
						else
						{
							head[p][z]=hitbox[y][x][z];
							if(z==1)p++;
						}
					}
				}
				
			}
		}
		
		return head;
	}
	
	void setJumpCounter(int j)
	{
		jumpCounter=j;
	}
	
	


}

