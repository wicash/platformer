
public class Map {
	
	int xSize;									// X-Weite Deklaration
	int ySize;									// Y-Weite Deklaration
	int[][] map;								// Map-Array Deklaration
	
	Map(int xSize,int ySize)
	{
		this.xSize=xSize;						// X-Weite Initialisierung
		this.ySize=ySize;						// Y-Weite Initialisierung
		this.map= new int[ySize][xSize];		// Map-Array Initialisierung
		
	
	
		//Setze alle Elemente des Map-Arrays auf 0
		for(int y=1;y<ySize;y++)
		{
			for(int x=1;x<xSize;x++)
			{
				map[y][x]=0;
			}
		}
	
	}
	
	
	}
