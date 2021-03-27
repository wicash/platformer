public class Controller {
	public Player p;
	
	public Controller(Player p)
	{
		this.p=p;
	
		
	}
	
	public void moveRight()			//Bewegungen ausführen
	{
		p.clear();
		p.moveRight();
		p.draw();
	}
	public void moveLeft()
	{
		p.clear();
		p.moveLeft();
		p.draw();

	}
	public void moveUp()
	{
		p.clear();
		p.moveUp();
		p.draw();

	}
	public void moveDown()
	{
		p.clear();
		p.moveDown();
		p.draw();

	}
	



}
