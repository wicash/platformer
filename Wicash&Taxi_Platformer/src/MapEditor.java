import java.io.*;
import java.awt.image.*;
import javax.imageio.*;


public class MapEditor {
	
	public Map map;						// Map Deklaration
	int xSize;							// X-Weite Deklaration
	int ySize;							// Y-Weite Deklaration
	
	
	MapEditor(int xSize, int ySize)
	{
		map=new Map(xSize,ySize);		// Map Initialisierung mit x/y Größe
		this.xSize=xSize;				// X-Weite Initialisierung
		this.ySize=ySize;				// Y-Weite Initialisierung
	}
	
	MapEditor()
	{}
	
	//Erschafft Map1
	void createMap1()
	{
		createBorders();
		createBlock(0,300,400,6);
		createBlock(250,200,100,6);
		createBlock(150,270,30,30);
		createBlock(0,0,500,6);
		
		createBlock(150,200,100,6);
		createBlock(50,400,100,6);
		createBlock(450,100,100,6);
		createBlock(70,5,6,200);

		
	}
	
	//Erschafft Spielfeldrand
	void createBorders()
	{
		createBlock(0,25,xSize,10);		//Oben
		createBlock(0,ySize-15,xSize,20);	//Unten
		createBlock(0,0,15,ySize);		//Links
		createBlock(xSize-15,0,15,ySize);	//Rechts
	}
	
	//Erstallt einen Block und stellt entsprechende Array-Elemente des Map-Arrays auf 1
	void createBlock(int xPos,int yPos,int xHigh, int yHigh)
	{
		
		for(int y=yPos;y<yHigh+yPos;y++)
		{
			for(int x=xPos;x<xHigh+xPos;x++)
			{
				if(y<ySize&&x<xSize)
				{
				map.map[y][x]=1;
				}
				
			}
		}
	}
	
	//Gibt die Map zurück
	Map giveMap()

	{
		return map;
	}
	
	Map CreateMapFromBMP(BufferedImage image )
	{
		
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		try {ImageIO.write(image, "jpg", output );} catch(IOException ioe) {}
		ArrayKonverter konverter = new ArrayKonverter(image);
		int[][] temp = konverter.giveArray();
		Map loadedMap= new Map(konverter.height,konverter.width);
		loadedMap.map=temp;
		loadedMap.ySize=temp.length;
		loadedMap.xSize=temp[1].length;
		this.map=loadedMap;
		return loadedMap;
	}
	
	int[][] CreateModelFromBMP(BufferedImage image )
	{
		
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		try {ImageIO.write(image, "jpg", output );} catch(IOException ioe) {}
		ArrayKonverter konverter = new ArrayKonverter(image);
		int[][] temp = konverter.giveArray();
		Map loadedMap= new Map(konverter.height,konverter.width);
		loadedMap.map=temp;
		loadedMap.ySize=temp.length;
		loadedMap.xSize=temp[1].length;
		this.map=loadedMap;
		return temp;
	}

	
}
