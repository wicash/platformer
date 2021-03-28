import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowListener;
import java.util.Arrays;

import javax.swing.JFrame;

public class Controller extends JFrame implements KeyListener{
	public Player p;
	JFrame f;
	Map m;
	boolean[] pressedKeys=new boolean[5];		//Array zum überprüfen ob Tasten noch gedückt sind, 0=W ; 1=D ; 2=S ; 3=A ; 4=Space

	
	public Controller(Player p,Map m,JFrame f)
	{
		this.p=p;								//Player
		this.m=m;								//Map
		this.f=f;								//Frame
		f.addKeyListener(this);
		Arrays.fill(pressedKeys, Boolean.FALSE);
		
	}
	
	public void moveRight()			//Bewegungen ausführen
	{
		for(int mov=p.movementSpeed;mov>0;mov--)
		{
		if(!wallRight(p.giveRightSide())) {
			p.moveRight();
			}
		}
	}
	public void moveLeft()
	{
		for(int mov=p.movementSpeed;mov>0;mov--)
		{
		if(!wallLeft(p.giveLeftSide())) {
			
				p.moveLeft();
			}
			}
	}
	public void moveUp()
	{
		for(int mov=p.movementSpeed;mov>0;mov--)
		{
		if(!wallTop(p.giveHead())&& wallBottom(p.giveFoot())) {
			p.moveUp();
			}
	}
	}
		
	public void moveDown()
	{
		for(int mov=p.movementSpeed;mov>0;mov--)
		{
		if(!wallBottom(p.giveFoot())) {
			
			p.moveDown();
			}
		}
	}
	
	public void doAction()
	{
		if(!wallBottom(p.giveFoot())&& !(pressedKeys[4] && p.verbleibendteSprunghoehe>0)) {
			
			for(int mov=p.gravity;mov>0;mov--)
			{
			p.fall();
			
			}
		}
		
		if(wallBottom(p.giveFoot()))
		{
			p.verbleibendteSprunghoehe=p.sprunghoehe;
			p.doubleJump=true;
		}
		
		if(pressedKeys[0]==true) moveUp();
		if(pressedKeys[1]==true) moveRight();
		if(pressedKeys[2]==true) moveDown();
		if(pressedKeys[3]==true) moveLeft();
		if(pressedKeys[4]==true)
			{
			for(int mov=2;mov>0;mov--)
			{
			if(!wallTop(p.giveHead())&&p.verbleibendteSprunghoehe>0)
				{
				p.jump();
				p.verbleibendteSprunghoehe--;
				
				}
			}
			}

	}
	
	boolean wallBottom(int[][] foot)
	{
		for(int x=0;x<foot.length;x++)
		{
			
				if(this.collisionBottom(foot[x])) return true;		
			
		}
		return false;
	}
	
	boolean wallRight(int[][] side)
	{
		for(int x=0;x<side.length;x++)
		{
				if(this.collisionRight(side[x])) return true;					
		}
		return false;
	}
	
	boolean wallLeft(int[][] side)
	{
		for(int x=0;x<side.length;x++)
		{
				if(this.collisionLeft(side[x])) return true;					
		}
		return false;
	}
	
	boolean wallTop(int[][] head)
	{
		for(int x=0;x<head.length;x++)
		{
				if(this.collisionTop(head[x])) return true;					
		}
		return false;
	}
	
	
	
	boolean collisionBottom (int[] coordinates)
	{
		
		if(m.map[coordinates[1]+2][coordinates[0]]==1)
			{ 
			return true;}
		return false;
	}
	
	boolean collisionRight (int[] coordinates)
	{
		
		
		if(m.map[coordinates[1]][coordinates[0]+p.movementSpeed]==1)
			{ 
			return true;}
		return false;
	}
	
	boolean collisionLeft (int[] coordinates)
	{
		
		if(m.map[coordinates[1]][coordinates[0]-p.movementSpeed]==1)
			{ 
			return true;}
		return false;
	}
	
	boolean collisionTop (int[] coordinates)
	{
		
		
		if(m.map[coordinates[1]-2][coordinates[0]]==1)
			{ 
			return true;}
		return false;
	}
	
	
	void setJumpCounter(int j)
	{
		p.setJumpCounter(j);
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed( KeyEvent e)				// Knopfdruck an Controller übermitteln 
	{

		

		if(e.getKeyCode() == KeyEvent.VK_W)
		{
			pressedKeys[0]=true;
		}
		
		else if(e.getKeyCode() == KeyEvent.VK_D)
		{
			pressedKeys[1]=true;
		}
		
		else if(e.getKeyCode() == KeyEvent.VK_S)
		{
			pressedKeys[2]=true;
		}
		
		else if(e.getKeyCode() == KeyEvent.VK_A)
		{
			pressedKeys[3]=true;
		}
		
		
		else if(e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			
			pressedKeys[4]=true;

			
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		

		if(e.getKeyCode() == KeyEvent.VK_W)
		{
			pressedKeys[0]=false;
			
		}
		
		else if(e.getKeyCode() == KeyEvent.VK_D)
		{
			pressedKeys[1]=false;
			
		}
		
		else if(e.getKeyCode() == KeyEvent.VK_S)
		{
		  
			pressedKeys[2]=false;
			
		}
		
		else if(e.getKeyCode() == KeyEvent.VK_A)
		{
			pressedKeys[3]=false;
			
		}
		
		else if(e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			if(p.doubleJump && !wallBottom(p.giveFoot() ))
			{
			p.verbleibendteSprunghoehe=p.sprunghoehe;
			p.doubleJump=false;
			}
			pressedKeys[4]=false;
			
		}
		
		
	}



}
