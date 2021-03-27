
public class MapEditor {
	
	public Map m;
	
	MapEditor(int xSize, int ySize)
	{
		m=new Map(xSize,ySize);
	}
	
	Map createMap1()
	{
		m.createBlock(0,300,400,3);
		
		
		return m;
	}

}
