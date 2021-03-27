import java.awt.Frame;
import java.awt.Graphics;

import javax.swing.JFrame;


public class View extends JFrame  {
	private Frame f;
	public Player p;

	public View(Player p) { 
		this.p=p;
		f = new Frame();
		f.setSize(500, 500);
		f.setVisible(true);
		
	}
	
	public void draw () {
		Graphics h = getGraphics();
		h.drawRect(p.getPos()[0],p.getPos()[1],p.getSize(),p.getSize());
	}
	
	}


