import javax.swing.* ;
import java.awt.* ;


class Paneau extends JPanel {

	MovingObject bal,pad ;
	Bricks bricks;
   Paneau(MovingObject _pal,MovingObject _pad, Bricks _bricks){
	super();
	this.bal=_pal ;
	this.pad =_pad;
	this.bricks = _bricks;
   }

   @Override
    public void paintComponent (Graphics g){
	final Rectangle ball = bal.getRect() ;
	final Rectangle padle = pad.getRect();
	g.fillRect (ball.x, ball.y, ball.width, ball.height);
	g.fillRect(padle.x, padle.y, padle.width, padle.height);
	//bricks.printBricks();

	for (int i = 0;i<Constants.BricksPerColumn;i++){
		for (int j = 0;j<Constants.BricksPerRows;j++){
			Brick brick = bricks.ManyBricks[i][j];
			Rectangle brickForm = bricks.ManyBricks[i][j].getRect();
			g.setColor(brick.couleur);
			g.fillRect(brickForm.x, brickForm.y,Constants.widthBrick, Constants.heightBrick);
		}
	}

		
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
	
	while (true){
	    fen.repaint() ; 
		Thread.sleep(50);
	}

   }
}
