import javax.swing.*;
import java.awt.*;

class Paneau extends JPanel {

    MovingObject bal, pad;
    Bricks bricks;
    public int Score; 
    int Turns = Constants.turns;//nombre de tours du jeu
	int hits = 0; //

	JFrame parentFrame ; //pour récuperer la fenêtre et définir son titre

    Paneau(MovingObject _pal, MovingObject _pad, Bricks _bricks, JFrame _parentFrame) {
        
		super();
        this.bal = _pal;
        this.pad = _pad;
        this.bricks = _bricks;
		parentFrame = _parentFrame;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); // Call the superclass method
        final Rectangle ball = bal.getRect();
        final Rectangle padle = pad.getRect();
        g.setColor(Constants.ballColor);
        g.fillRect(ball.x, ball.y, ball.width, ball.height);
        g.setColor(Constants.padColor);
        g.fillRect(padle.x, padle.y, padle.width, padle.height);

        for (int i = 0; i < Constants.BricksPerColumn; i++) {
            for (int j = 0; j < Constants.BricksPerRows; j++) {
                Brick brick = bricks.ManyBricks[i][j];
                Rectangle brickForm = bricks.ManyBricks[i][j].getRect();
                g.setColor(brick.couleur);
                g.fillRect(brickForm.x, brickForm.y, Constants.widthBrick, Constants.heightBrick);
            }
        }

        bal.deplace();
        pad.deplace();
        manageCollisions();
        manageWidthPad();

    }

    public void manageCollisions() {

		//gérer la collision de la balle avec le paddle
        if (bal.getRect().intersects(((Paddle) pad).getRect())) {
            ((Balle) bal).ChangeDir();
        }
		//gérer la collision de la balle avec des briques
        for (int i = 0; i < Constants.BricksPerColumn; i++) {
            for (int j = 0; j < Constants.BricksPerRows; j++) {
                if (bal.getRect().intersects(bricks.ManyBricks[i][j].getRect())) {
                    ((Balle) bal).ChangeDir();
                    bricks.ManyBricks[i][j].hasToDisapeared();
                    hits += 1;
                    manageBallSpeed(bricks.ManyBricks[i][j].couleur, hits);
                    manageScore(bricks.ManyBricks[i][j].couleur);
                }
            }
        }
    }

    public void manageScore(Color c) {
        if (c == Color.YELLOW) {
            Score += 1;
        } else if (c == Color.GREEN) {
            Score += 3;
        } else if (c == Color.ORANGE) {
            Score += 5;
        } else {
            Score += 7;
        }

		parentFrame.setTitle("Score : "+Score+"    Turn : "+Turns );
    }

    public void manageWidthPad() {
        if (((Balle) bal).hitUpperWall()) {
            ((Paddle) pad).WidthPad = ((Paddle) pad).WidthPad - ((Paddle) pad).WidthPad * (1 / 4);
        }
    }

    public void manageBallSpeed(Color c, int hit) {
        if (c == Color.ORANGE || c == Color.RED) {
            ((Balle) bal).IncreaseSpeed();
        } else if ((hit == 4) || (hit == 12)) {
            ((Balle) bal).IncreaseSpeed();
        }
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
