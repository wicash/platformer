import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Arrays;

import javax.swing.JFrame;


public class View extends JFrame implements WindowListener{

	public Player p;
	public Controller c;
	public Map m;
	Camera cam;
	JFrame f;
	boolean[] pressedKeys=new boolean[5];	//Array zum überprüfen ob Tasten noch gedückt sind, 0=W ; 1=D ; 2=S ; 3=A ; 4=Space

	public View(Player p,Controller c,Map m,JFrame f) {
		this.p=p;						//Spieler übergeben
		this.c=c;						//Controller übergeben
		this.m=m;
		this.f=f;

		
		System.out.println(m.xSize+"sada"+ m.ySize);
		f.setSize(300, 300);				// Fenster aufbauen
		f.setBackground(Color.white);
		f.getContentPane().setBackground( Color.white );
		f.setVisible(true);
		f.addWindowListener(this);
		
		
		
		//drawMap(f.getGraphics());
		cam=new Camera(p,f,m);
		p.setCamera(cam);
		cam.setGraphics(f.getGraphics());
		cam.drawMap();
		
		p.setGraphics(f.getGraphics());	//Spieler Blatt übergeben
		
	}
	
	public void drawMap(Graphics g)
	{
		
		for(int y=0;y<m.ySize;y++)
		{
			for(int x=0;x<m.xSize;x++)
			{
				
				if(m.map[y][x]==1) {g.fillRect(x,y,1,1);}
			}
		}
		
	}
	
	public void setGraphics()
	{
		p.setGraphics(f.getGraphics());
	}
	
	public void paint (Graphics g) {    //Wichtig nicht löschen

	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {  	//Fenster schließen 
		System.exit(0);
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
	}

