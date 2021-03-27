public class Controller {
	public Player p;
	Map m;
	
	public Controller(Player p,Map m)
	{
		this.p=p;
		this.m=m;
	
		
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
	
	public void fall()
	{
		if(!onGround(p.giveFoot())) {
		p.clear();
		p.fall2();
		p.draw();
		}

	}
	
	boolean onGround(int[][] foot)
	{
		//System.out.println("adasd"+foot.length);
		
		for(int x=0;x<foot.length;x++)
		{
			
				if(this.collision(foot[x])) return true;
				System.out.println("xPos: "+foot[x][0]);
				System.out.println("yPos: "+foot[x][1]);
				
				System.out.println("Map an x/y Pos"+ m.map[foot[x][0]][foot[x][1]]);
				
			
		}
		return false;
	}
	
	boolean collision (int[] coordinates)
	{
		
		//System.out.println("Player Koordinaten: X:"+ coordinates[0] + "Y:  "+ coordinates[1]);
		
		if(m.map[coordinates[0]][coordinates[1]]==1)
			{ 
			return true;}
		return false;
	}
	



}
