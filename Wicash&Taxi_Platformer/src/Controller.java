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
		if(!wallRight(p.giveRightSide())) {
			p.clear();
			p.moveRight();
			p.draw();
			}
	}
	public void moveLeft()
	{
		if(!wallLeft(p.giveLeftSide())) {
			p.clear();
			p.moveLeft();
			p.draw();
			}
	}
	public void moveUp()
	{
		if(!wallTop(p.giveHead())) {
			p.clear();
			p.moveUp();
			p.draw();
			}
	}
	public void moveDown()
	{
		if(!wallBottom(p.giveFoot())) {
			p.clear();
			p.moveDown();
			p.draw();
			}
	}
	
	public void fall_jump()
	{
		if(!wallBottom(p.giveFoot())&&p.jumpCounter==0) {
			p.clear();
			p.fall();
			p.draw();
		}
		else if(p.jumpCounter>0)
		{
			p.clear();
			p.jump();
			p.draw();
		}

	}
	
	boolean wallBottom(int[][] foot)
	{
		//System.out.println("adasd"+foot.length);
		
		for(int x=0;x<foot.length;x++)
		{
			
				if(this.collisionBottom(foot[x])) return true;
//				System.out.println("xPos: "+foot[x][0]);								//Koordinaten Foot und Map and Pos y+2
//				System.out.println("yPos: "+foot[x][1]);		
//				
//				System.out.println("Map an x/y Pos"+ m.map[foot[x][1]+2][foot[x][0]]);
				
			
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
		
		//System.out.println("Player Koordinaten: X:"+ coordinates[0] + "Y:  "+ coordinates[1]);
		
		if(m.map[coordinates[1]+1][coordinates[0]]==1)
			{ 
			return true;}
		return false;
	}
	
	boolean collisionRight (int[] coordinates)
	{
		
		//System.out.println("Player Koordinaten: X:"+ coordinates[0] + "Y:  "+ coordinates[1]);
		
		if(m.map[coordinates[1]][coordinates[0]+p.movementSpeed]==1)
			{ 
			return true;}
		return false;
	}
	
	boolean collisionLeft (int[] coordinates)
	{
		
		//System.out.println("Player Koordinaten: X:"+ coordinates[0] + "Y:  "+ coordinates[1]);
		
		if(m.map[coordinates[1]][coordinates[0]-p.movementSpeed]==1)
			{ 
			return true;}
		return false;
	}
	
	boolean collisionTop (int[] coordinates)
	{
		
		//System.out.println("Player Koordinaten: X:"+ coordinates[0] + "Y:  "+ coordinates[1]);
		
		if(m.map[coordinates[1]-2][coordinates[0]]==1)
			{ 
			return true;}
		return false;
	}
	
	void setJumpCounter(int j)
	{
		p.setJumpCounter(j);
	}
	



}
