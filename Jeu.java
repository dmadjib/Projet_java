import javax.swing.* ;
import java.awt.* ;


class Paneau extends JPanel {

	MovingObject bal,pad ;

   Paneau(MovingObject _pal,MovingObject _pad){
	super();
	this.bal=_pal ;
	this.pad =_pad;
   }

   @Override
    public void paintComponent (Graphics g){
	final Rectangle ball = bal.getRect() ;
	final Rectangle padle = pad.getRect();
	g.fillRect (ball.x, ball.y, ball.width, ball.height);
	g.fillRect(padle.x, padle.y, padle.width, padle.height);
	bal.deplace() ;
	pad.deplace() ;
   }
}



public class Jeu {

   public static void main(String[] args) throws InterruptedException {

	System.setProperty("sun.java2d.opengl", "true"); /* pour animation fluide */

	MaFenetre fen = new MaFenetre(Constants.WidthFen, Constants.HeightFen) ;

	fen.setVisible(true);

	fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	//System.out.println(xFen+ " " +yFen);
	while (true){
	    fen.repaint() ; 
		Thread.sleep(50);
	}

   }
}
