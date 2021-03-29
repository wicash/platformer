
public class Map {
	
	int xSize;
	int ySize;
	int material=3;
	int[][] map;
	
	Map(int xSize,int ySize)
	{
		this.xSize=xSize;
		this.ySize=ySize;
		this.map= new int[ySize][xSize];
		
	
		for(int y=1;y<ySize;y++)
		{
			for(int x=1;x<xSize;x++)
			{
				map[y][x]=0;
			}
		}
	
	}
	

	
	void createBlock(int xPos,int yPos,int xHigh, int yHigh)
	{
		
		for(int y=yPos;y<yHigh+yPos;y++)
		{
			for(int x=xPos;x<xHigh+xPos;x++)
			{
//				System.out.println("x: "+x+" y: "+y);
				if(y<ySize&&x<xSize)
				{
				map[y][x]=1;
//				System.out.println("Map auf eins: x:"+x+"Y: "+ y);
				}
				
			}
		}
	}
	

	
	
	}