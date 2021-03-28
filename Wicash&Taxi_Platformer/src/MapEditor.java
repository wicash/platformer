
public class MapEditor {
	
	public Map m;
	int xSize;
	int ySize;
	
	MapEditor(int xSize, int ySize)
	{
		m=new Map(xSize,ySize);
		this.xSize=xSize;
		this.ySize=ySize;
	}
	
	void createMap1()
	{
		createBorders();
		m.createBlock(0,300,400,3);
		m.createBlock(250,200,100,3);
		m.createBlock(150,300,30,30);
		m.createBlock(0,0,500,3);
		m.createBlock(0,0,400,3);
		
	}
	
	void createBorders()
	{
		m.createBlock(0,0,xSize,3);
		m.createBlock(0,ySize,xSize,3);
		m.createBlock(0,0,3,ySize);
		m.createBlock(0,xSize,xSize,3);
	}
	
	Map giveMap()
	{
		return m;
	}

}
