import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;


public class View extends JFrame implements WindowListener,KeyListener {

	public Player p;
	public Controller c;
	public Map m;

	public View(Player p,Controller c,Map m) {
		this.p=p;						//Spieler übergeben
		this.c=c;						//Controller übergeben
		this.m=m;						
		
		setSize(500, 500);				// Fenster aufbauen
		setBackground(Color.white);
		setVisible(true);
		addWindowListener(this);	
		addKeyListener(this);			//Keylistener verbinden
		
		drawMap(getGraphics());
		
		p.setGraphics(getGraphics());	//Spieler Blatt übergeben
		
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
		p.setGraphics(getGraphics());
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

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed( KeyEvent e)				// Knopfdruck an Controller übermitteln 
	{

		

		if(e.getKeyCode() == KeyEvent.VK_W)
		{
			c.moveUp();
			
		}
		
		else if(e.getKeyCode() == KeyEvent.VK_D)
		{
			c.moveRight();
			
		}
		
		else if(e.getKeyCode() == KeyEvent.VK_S)
		{
		  
			c.moveDown();
			
		}
		
		else if(e.getKeyCode() == KeyEvent.VK_A)
		{
			c.moveLeft();
			
		}
		
		else if(e.getKeyCode() == KeyEvent.VK_D)
		{
			c.moveRight();
			
		}
		
		else if(e.getKeyCode() == KeyEvent.VK_SPACE && c.wallBottom(p.giveFoot()))
		{
			c.setJumpCounter(40);
			
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	}


