
public class Start {

	public static void main(String[] args) {
		Player p1    = new Player(50,50);
		View v       = new View(p1);
		Controller C = new Controller(p1,v);
	}

}
