import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowListener;
import java.util.Arrays;
import javax.swing.JFrame;

public class Controller extends JFrame implements KeyListener{
	public Player p;							//Player Deklaration
	JFrame f;									//Frame Deklaration
	Map m;										//Map Deklaration
	boolean[] pressedKeys=new boolean[5];		//Array zum überprüfen ob Tasten noch gedückt sind, 0=W ; 1=D ; 2=S ; 3=A ; 4=Space

	
	public Controller(Player p,Map m,JFrame f)
	{
		this.p=p;								//Player Initialisierung
		this.m=m;								//Map Initialisierung
		this.f=f;								//Frame Initialisierung
		f.addKeyListener(this);					//Bindet den Keylistener an das Frame an
		
		//Setzt alle Elemente des Arrays für die momentan gedrückten Tasten auf false:= keine Taste ist gedrückt
		// 0=W ; 1=D ; 2=S ; 3=A ; 4=Space
		Arrays.fill(pressedKeys, Boolean.FALSE);	
		
	}
	
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	// Player Bewegungen 
	
	//Bewegungsbefehl rechts
	public void moveRight()			
	{
		// Pro Bewegungsbefehl nach rechts, wir der Spieler um "movmentSpeed" Felder nach rechts verschoben, WENN...
		for(int mov=p.movementSpeed;mov>0;mov--)
		{
		//	... keine Wand im Weg ist.
		if(!wallRight(p.giveRightSide())) {
			p.moveRight();
			}
		else if(!oneTileToRightBottom(p.giveLeftSide()))
		{
			moveUp();
			p.moveRight();
		}
		}
	}
	
	//Bewegungsbefehl links
	public void moveLeft()
	{

		
		// Pro Bewegungsbefehl nach oben, wir der Spieler um "movmentSpeed" Felder nach links verschoben, WENN...
		for(int mov=p.movementSpeed;mov>0;mov--)
		{
		//	... keine Wand im Weg ist.
		if(!wallLeft(p.giveLeftSide())) {
			
				p.moveLeft();
			}
		else if(!oneTileToLeftBottom(p.giveRightSide()))
		{
			moveUp();
			p.moveLeft();
		}
			}

	}
	
	//Bewegungsbefehl hoch
	public void moveUp()
	{
		// Pro Bewegungsbefehl nach oben, wir der Spieler um "movmentSpeed" Felder nach oben verschoben, WENN...
		for(int mov=p.movementSpeed;mov>0;mov--)
		{
		//	... keine Wand im Weg ist.
		if(!wallTop(p.giveHead())) {
			p.moveUp();
			}
	}
	}
	
	//Bewegungsbefehl runter
	public void moveDown()
	{
		
		// Pro Bewegungsbefehl nach unten, wir der Spieler um "movmentSpeed" Felder nach unten verschoben, WENN...
		for(int mov=p.movementSpeed;mov>0;mov--)
		{
		if(!wallBottom(p.giveFoot())) {
			
		//  ... keine Wand im Weg ist.
			
			p.moveDown();
			}
		}
		
			
	}
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// Haupt-Schleifen-Programm ( wird pro Tick ein mal ausgeüfhrt )
	
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Erinnerung: Jump und Fall zu Bewegungsbefehlen auslagern
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	
	public void doAction()
	{
		// Prüfe ob der Spieler auf dem Boden steht und ob Leertaste gedrückt ist und noch sprungkraft vorhanden ist,
		//           wenn nicht, fällt der spieler
		if(!wallBottom(p.giveFoot())&&wallTop(p.giveHead())&&!pressedKeys[0]     ||!wallBottom(p.giveFoot())&& !(pressedKeys[4] && p.verbleibendeSprunghoehe>0)) {
			
			//Spieler fällt pro Tick um "gravity" Pixel(Array Elemente)
			for(int mov=p.gravity;mov>0;mov--)
			{
				if( !(wallTop(p.giveHead())&&pressedKeys[0]) && !wallBottom(p.giveFoot())&& !(pressedKeys[4] && p.verbleibendeSprunghoehe>0 && !wallTop(p.giveHead()))) {
			p.fall();
				}
			
			}
		}
		
		// Prüfe ob der Spieler auf dem Boden steht, wenn ja wird der "double Jump" sowie die "verbleibendeSprunghöhe" resetet
		if(wallBottom(p.giveFoot()))
		{
			p.verbleibendeSprunghoehe=p.sprunghoehe;
			p.doubleJump=true;
		}
		
		//Prüfe ob Bewegungstasten (WASD) gedrückt sind, wenn ja führe Bewegung ausd
		//		 0=W=Hoch ; 1=D=Rechts ; 2=S=Runter ; 3=A=Links ; 4=Space=Springen
		if(pressedKeys[0]&&pressedKeys[1])
		{
			if(wallTop(p.giveHead())&&oneTileToRightTop(p.giveRightSide())&&wallRight(p.giveRightSide()))
			{
				moveDown();
				moveRight();
			}
			else if(wallTop(p.giveHead())&&!wallRight(p.giveRightSide()))
			{
				moveRight();
				p.jump();
			}
		}
		if(pressedKeys[0]&&pressedKeys[3])
		{
			if(wallTop(p.giveHead())&&oneTileToLeftTop(p.giveLeftSide())&&wallLeft(p.giveLeftSide()))
			{
				moveDown();
				moveLeft();
			}
			else if(wallTop(p.giveHead())&&!wallLeft(p.giveLeftSide()))
			{
				moveLeft();
				p.jump();
			}
		}
		if(pressedKeys[1]==true) moveRight();
		if(pressedKeys[2]==true) moveDown();
		if(pressedKeys[3]==true) moveLeft();
		if(pressedKeys[4]==true)
			{
			// Pro Bewegungsbefehl: springen , wir der Spieler um 2 Felder nach unten verschoben, WENN...
			for(int mov=2;mov>0;mov--)
			{
			// ... keine Wand im Weg ist und noch "verbleibendeSprunghöhe" vorhanden ist 
			if(!wallTop(p.giveHead())&&p.verbleibendeSprunghoehe>0)
				{
				p.jump();
				p.verbleibendeSprunghoehe--;
				
				}
			}
			}

	}
	
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Kollisionsabfragen
	
	// Prüfbefehl, ob unter der gegebenen Pixelreihe (dem Fuß) Boden ist
	boolean wallBottom(int[][] foot)
	{
		//Frage einzeln jeden Pixel des Fußes ab,ob unter ihm Boden ist, wenn einer gefunden wurde gib "true" zurück, sonst "false"
		for(int x=0;x<foot.length;x++)
		{		
				if(this.collisionBottom(foot[x])) return true;					
		}
		return false;
	}
	
	
	
	// Prüfbefehl, ob rechts von der gegebenen Pixelreihe (der Seite) Wand ist
	boolean wallRight(int[][] side)
	{
		//Frage einzeln jeden Pixel der Seite ab,ob rechts von ihm Wand ist, wenn einer gefunden wurde gib "true" zurück, sonst "false"
		for(int x=0;x<side.length&& side[x][0]>0;x++)
		{
				if(this.collisionRight(side[x])) return true;					
		}
		return false;
	}
	
	boolean oneTileToRightBottom(int[][] side)
	{
		//Frage einzeln jeden Pixel der Seite ab,ob rechts von ihm Wand ist, wenn einer gefunden wurde gib "true" zurück, sonst "false"
		for(int x=1;x<side.length&& side[x][0]>0;x++)
		{
				if(this.collisionRight(side[x])) return true;					
		}
		return false;
	}
	
	boolean oneTileToRightTop(int[][] side)
	{
		//Frage einzeln jeden Pixel der Seite ab,ob rechts von ihm Wand ist, wenn einer gefunden wurde gib "true" zurück, sonst "false"
		for(int x=1;x<side.length&& side[x][0]>0;x++)
		{
				if(this.collisionRight(side[x])) return true;					
		}
		return false;
	}
	
	// Prüfbefehl, ob links von der gegebenen Pixelreihe (der Seite) Wand ist	
	boolean wallLeft(int[][] side)
	{
		//Frage einzeln jeden Pixel des Fußes ab,ob unter ihm Boden ist, wenn einer gefunden wurde gib "true" zurück, sonst "false"
		for(int x=0;x<side.length && side[x][0]>0;x++)
		{
			
				if(this.collisionLeft(side[x])) return true;	
		}
		return false;
	}
	
	boolean oneTileToLeftBottom(int[][] side)
	{
		//Frage einzeln jeden Pixel der Seite ab,ob rechts von ihm Wand ist, wenn einer gefunden wurde gib "true" zurück, sonst "false"
		for(int x=1;x<side.length&& side[x][0]>0;x++)
		{
				if(this.collisionRight(side[x])) return true;					
		}
		return false;
	}
	
	boolean oneTileToLeftTop(int[][] side)
	{
		//Frage einzeln jeden Pixel der Seite ab,ob rechts von ihm Wand ist, wenn einer gefunden wurde gib "true" zurück, sonst "false"
		for(int x=1;x<side.length&& side[x][0]>0;x++)
		{
				if(this.collisionRight(side[x])) return true;					
		}
		return false;
	}
	
	// Prüfbefehl, ob über der gegebenen Pixelreihe (dem Kopf) Decke ist
	boolean wallTop(int[][] head)
	{
		//Frage einzeln jeden Pixel des Kopfes ab,ob über ihm Decke ist, wenn einer gefunden wurde gib "true" zurück, sonst "false"
		for(int x=0;x<head.length&& head[x][0]>0;x++)
		{
				if(this.collisionTop(head[x])) return true;					
		}
		return false;
	}
	
	
	
	//Prüfbefehl, ob unter dem gegebenen Pixel Boden ist
	boolean collisionBottom (int[] coordinates)
	{	
		if(m.map[coordinates[1]+1][coordinates[0]]==1)
			{ 
			return true;}
		return false;
	}
	
	//Prüfbefehl, ob rechts von dem gegebenen Pixel Wand ist
	boolean collisionRight (int[] coordinates)
	{	
		
		if(m.map[coordinates[1]][coordinates[0]+1]==1)
			{ 
			return true;}
		return false;
	}
	
	//Prüfbefehl, ob links von dem gegebenen Pixel Wand ist
	boolean collisionLeft (int[] coordinates)
	{
		

		if(coordinates[1]==0) {return false;}
		if(m.map[coordinates[1]][coordinates[0]-1]==1)
			{ 
			return true;}
		
		return false;
	}
	
	//Prüfbefehl, ob über dem gegebenen Pixel Decke ist
	boolean collisionTop (int[] coordinates)
	{
		if(coordinates[1]==0) {return false;}
		if(m.map[coordinates[1]-1][coordinates[0]]==1)
			{ 
			return true;}
		
		return false;
	}
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Tastendruckabfragen

	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	//Tasten-Druckabfragen
	public void keyPressed( KeyEvent e)			 
	{

		
		//Wenn "W" gedrückt wurde, setzte das zugeordnet Array-Element von den gedrückten Tasten ("pressedKey[0]") auf "true" 
		if(e.getKeyCode() == KeyEvent.VK_W)
		{
			pressedKeys[0]=true;
		}
		
		//Wenn "D" gedrückt wurde, setzte das zugeordnet Array-Element von den gedrückten Tasten ("pressedKey[1]") auf "true" 
		else if(e.getKeyCode() == KeyEvent.VK_D)
		{
			pressedKeys[1]=true;
		}
		
		//Wenn "S" gedrückt wurde, setzte das zugeordnet Array-Element von den gedrückten Tasten ("pressedKey[2]") auf "true" 
		else if(e.getKeyCode() == KeyEvent.VK_S)
		{
			pressedKeys[2]=true;
		}
		
		//Wenn "A" gedrückt wurde, setzte das zugeordnet Array-Element von den gedrückten Tasten ("pressedKey[3]") auf "true" 
		else if(e.getKeyCode() == KeyEvent.VK_A)
		{
			pressedKeys[3]=true;
		}
		
		//Wenn "Space" gedrückt wurde, setzte das zugeordnet Array-Element von den gedrückten Tasten ("pressedKey[4]") auf "true"
		else if(e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			
			pressedKeys[4]=true;

			
		}
		
	}

	@Override
	//Tasten-Loslasabfragen
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
		
		//Wenn "W" losgelassen wurde, setzte das zugeordnet Array-Element von den gedrückten Tasten ("pressedKey[0]") auf "false" 
		if(e.getKeyCode() == KeyEvent.VK_W)
		{
			pressedKeys[0]=false;
			
		}
		
		//Wenn "D" losgelassen wurde, setzte das zugeordnet Array-Element von den gedrückten Tasten ("pressedKey[1]") auf "false" 
		else if(e.getKeyCode() == KeyEvent.VK_D)
		{
			pressedKeys[1]=false;
			
		}
		
		//Wenn "S" losgelassen wurde, setzte das zugeordnet Array-Element von den gedrückten Tasten ("pressedKey[2]") auf "false" 
		else if(e.getKeyCode() == KeyEvent.VK_S)
		{
		  
			pressedKeys[2]=false;
			
		}
		
		//Wenn "A" losgelassen wurde, setzte das zugeordnet Array-Element von den gedrückten Tasten ("pressedKey[3]") auf "false" 
		else if(e.getKeyCode() == KeyEvent.VK_A)
		{
			pressedKeys[3]=false;
			
		}
		
		//Wenn "Space" losgelassen wurde, setzte das zugeordnet Array-Element von den gedrückten Tasten ("pressedKey[4]")
		//auf "false" UND...
		else if(e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			// ... wenn "doubleJump" noch nicht verwendet wurde und sich der Spieler nicht auf dem Boden befindet,
			// wird die "verbleibendeSprunghöhe" resetet und der "doubleJump" verbrauchst ( auf "false" gesetzt ) 
			if(p.doubleJump && !wallBottom(p.giveFoot() ))
			{
			p.verbleibendeSprunghoehe=p.sprunghoehe;
			p.doubleJump=false;
			}
			
			pressedKeys[4]=false;
			
		}
		
		
	}
	

}
