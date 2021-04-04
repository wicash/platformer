import javax.swing.JFrame;
import javax.swing.JLabel;


public class View extends JFrame implements WindowListener{

	public Player p;
	public Controller c;
	public Map m;
	Camera cam;
	JFrame f;
	JLabel map;
	boolean[] pressedKeys=new boolean[5];	//Array zum �berpr�fen ob Tasten noch ged�ckt sind, 0=W ; 1=D ; 2=S ; 3=A ; 4=Space

	public View(Player p,Controller c,Map m,JFrame f) {
		this.p=p;						//Spieler �bergeben
		this.c=c;						//Controller �bergeben
		this.m=m;
		this.f=f;

		
		System.out.println(m.xSize+"sada"+ m.ySize);
		map=new JLabel();
		f.add(map);
		f.setSize(600, 600);				// Fenster aufbauen
		f.setBackground(Color.white);
		f.getContentPane().setBackground( Color.white );
		f.setVisible(true);
		f.addWindowListener(this);
		
		
		
		//drawMap(f.getGraphics());
		cam=new Camera(p,f,m,map);
		p.setCamera(cam);
		cam.setGraphics(f.getGraphics());
		cam.setMap();

		
		p.setGraphics(f.getGraphics());	//Spieler Blatt �bergeben
		
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

	
	
	
	
	}

