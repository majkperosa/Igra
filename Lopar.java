import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Lopar {

	private final int Y = 330;//lopar je vedno enak zato smo dali final
	private final int SIRINA = 60;
	private final int VISINA = 20;
	
	private int x = 0;
	private int xPremik = 0;
	private Igra igra;
	
	public Lopar(Igra igra) {
		this.igra = igra;
	}
	
	public void paint(Graphics2D g) {
		g.fillRect(this.x, Y, SIRINA, VISINA);
	}
	
	public void nastaviPremikanje(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {//ce je leva tipka je 1 ker zdaj je nastavljeno na 0
			this.xPremik = 1;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			this.xPremik = -1;
		}
	}
	
	public void usatiPremikanje() {
		this.xPremik = 0;
	}
	
	public void premakni() {
		if(this.x + this.xPremik > 0 && //tukaj ve da je rob lopar
		   this.x + this.xPremik < igra.getWidth() - SIRINA) {
			this.x += this.xPremik; 
		}
		
	}
	
	public Rectangle getMejeLoparja() {
		return new Rectangle(this.x, Y, SIRINA, VISINA);
	}
}
