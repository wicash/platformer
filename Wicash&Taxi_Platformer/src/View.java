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

	public View(Player p,Controller c) {
		this.p=p;						//Spieler �bergeben
		this.c=c;						//Controller �bergeben
		
		setSize(500, 500);				// Fenster aufbauen
		setBackground(Color.white);
		setVisible(true);
		addWindowListener(this);	
		addKeyListener(this);			//Keylistener verbinden
		
		p.setGraphics(getGraphics());	//Spieler Blatt �bergeben
		
	}
	
	public void setGraphics()
	{
		p.setGraphics(getGraphics());
	}
	
	public void paint (Graphics g) {    //Wichtig nicht l�schen

	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {  	//Fenster schlie�en 
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
	public void keyPressed( KeyEvent e)				// Knopfdruck an Controller �bermitteln 
	{

		

		if(e.getKeyCode() == KeyEvent.VK_W)
		{
			c.moveUp();
			
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
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	}



