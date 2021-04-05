import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Camera extends JFrame {

	Player p;
	JFrame f;
	Graphics g;
	Map m;
	int[] rgbMap;
	int [] rgbMap2;
	Color white = new Color(255, 255, 255);
	Color black = new Color(0, 0, 0);
	Color blue = new Color(0, 0, 255);
	Color yellow = new Color(255,255,0);
	int counter;
	JLabel j;
	BufferedImage bufMap;
	BufferedImage temp =new BufferedImage(50,50,BufferedImage.TYPE_INT_RGB);
	
	Camera(Player p,JFrame f, Map m, JLabel j)
	{
		this.j=j;
		this.p=p;
		this.f=f;
		this.m=m;
		rgbMap= new int[f.getWidth()*f.getHeight()];
		Arrays.fill(rgbMap, 16777215);	
		bufMap = new BufferedImage(f.getWidth(),f.getHeight(),BufferedImage.TYPE_INT_RGB);

	}
	
	void setGraphics(Graphics g)		//"Blatt" übergeben
	{
		this.g=g;
	}
	

	void setMap()
	{
		counter=0;
		long start=System.currentTimeMillis();
		

//		for(int x=0;x<f.getHeight()*f.getWidth();x++)
//		{
//			rgbMap[x]=blue.getRGB();
//		}
		
		
			for(int y=0 ; y<f.getHeight(); y++)
		{
				
				for(int x=0 ; x<f.getWidth(); x++)
			{
					
					
					
					
					
					if(y>=f.getHeight()/2  && x>=f.getWidth()/2 && y<f.getHeight()/2+p.ySize && x<f.getWidth()/2+p.xSize && p.playerModel[x-f.getWidth()/2][y-f.getHeight()/2]==1 )
					  {
							rgbMap[counter]=blue.getRGB();

						
					  }
					else if(p.xPos-f.getWidth()/2+x<0 || p.yPos-f.getHeight()/2+y<0 )
						{
						
						rgbMap[counter]=black.getRGB();
						}
					else if(p.xPos-f.getWidth()/2+x > m.map[1].length-1 || p.yPos-f.getHeight()/2+y > m.map.length-1)
					{
						
						rgbMap[counter]=black.getRGB();
					}
					else if(p.xPos-f.getWidth()/2+x>=0 && p.yPos-f.getHeight()/2+y>=0)
					{
						if(m.map[p.yPos-f.getHeight()/2+y][p.xPos-f.getWidth()/2+x]>0)
						{
							rgbMap[counter]=black.getRGB();
						}
						else if(m.map[p.yPos-f.getHeight()/2+y][p.xPos-f.getWidth()/2 +x]==0)
						{
							rgbMap[counter]=white.getRGB();
						}
					}counter++;
					
			}
			}
					
					
					
					
					
//					
//					
////					System.out.println(" x:"+x+" y:"+y);
//		
//					if(y<=40&& y>=1) { rgbMap[counter]=16776960;
//					System.out.print("y>100");
//					}
//					else if(x==20)
//					{
////						System.out.println(" y: "+y);
//						rgbMap[counter]=16776960;
////						
//						if(true)
//						{rgbMap[counter]=16776960;
//						System.out.print(" Hab Blau gemacht ");
//						}
//						else { 
//							rgbMap[counter]= 65535;
//							System.out.print(" Hab Weiß gemacht ");
//									}
			
			
//					counter++;
//					
//					
				//System.out.println("aa");
//					if(x%2==1)
//					{rgbMap[counter]=blue.getRGB();}
//					else black.getRGB();
//					counter++;
// 			if(x>100)rgbMap[counter]=blue.getRGB();
//
//				if(y>=f.getHeight()/2  && x>=f.getWidth()/2 && y<f.getHeight()/2+p.ySize && x<f.getWidth()/2+p.xSize && p.playerModel[x-f.getWidth()/2][y-f.getHeight()/2]==1 )
//				  {
//						//bufMap.setRGB(x,y,blue.getRGB());
					
//						rgbMap[counter]=16777215;
//						System.out.print(" "+rgbMap[counter]+" a ");
//						
//				  }
//		
//				else
//					if(p.xPos-f.getWidth()/2+x<0  && p.yPos-f.getHeight()/2+y<0)
//					{
//					//bufMap.setRGB(x,y,black.getRGB());
//					rgbMap[counter]=black.getRGB();
//					System.out.print(" "+rgbMap[counter]+" b ");
//
//					}
//				else if(p.xPos-f.getWidth()/2+x > m.map[1].length-1 && p.yPos-f.getHeight()/2+y > m.map.length-1)
//				{
//					//bufMap.setRGB(x,y,black.getRGB());
//					rgbMap[counter]=black.getRGB();
//					System.out.print(" "+rgbMap[counter]+" c ");
//
//				}
//				else
//					if(p.xPos-f.getWidth()/2+x>=0 && p.yPos-f.getHeight()/2+y>=0)
//				{
//					if(m.map[p.yPos-f.getHeight()/2+y][p.xPos-f.getWidth()/2+x]>0)
//					{
//						//bufMap.setRGB(x,y,black.getRGB());
//						rgbMap[counter]=black.getRGB();
//						System.out.print(" "+rgbMap[counter]+" d ");
//
//					}
//					else if(m.map[p.yPos-f.getHeight()/2+y][p.xPos-f.getWidth()/2 +x]==0)
//					{
//						//bufMap.setRGB(x,y,white.getRGB());
//						rgbMap[counter]=16777215;
//						System.out.print(" "+rgbMap[counter]+" e ");
//					
//
//					}
//				} 
//			
			


//		
//			rgbMap2=rgbMap;
//		
//			for(int x=0;x<50*50;x++)
//			{
//				if(x%50==0) {
//				System.out.println();}
//				else System.out.print(" "+rgbMap2[x]+" ");
//			}
//			
//			temp.setRGB(0,0,50,50, rgbMap, 0, 0);
//			g.drawImage(temp,0,0,this);
			
			bufMap.setRGB(0,0,f.getWidth(),f.getHeight(), rgbMap, 0, f.getWidth());


		g.drawImage(bufMap,0,0,this);
		//j.setIcon(new ImageIcon(bufMap));
		long current=System.currentTimeMillis();
		System.out.println("Laufzder drawMap Methode in Millisekunden:" + (current-start) );

	
}
}
