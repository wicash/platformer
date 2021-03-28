
public class MapEditor {
	
	public Map m;
	int xSize;
	int ySize;
	
	MapEditor(int xSize, int ySize)
	{
		m=new Map(xSize,ySize);
		this.xSize=xSize;
		this.ySize=ySize;
		System.out.println( "xSize: " + xSize);
	}
	
	void createMap1()
	{
		createBorders();
		m.createBlock(0,300,400,6);
		m.createBlock(250,200,100,6);
		m.createBlock(150,270,30,30);
		m.createBlock(0,0,500,6);
		m.createBlock(0,0,400,6);
		
	}
	
	void createBorders()
	{
		m.createBlock(0,30,xSize,10);		//Oben
		m.createBlock(0,ySize-15,xSize,20);	//Unten
		m.createBlock(0,0,15,ySize);		//Links
		m.createBlock(xSize-15,0,15,ySize);	//Rechts
	}
	
	Map giveMap()
	{
		return m;
	}

}
