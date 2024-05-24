import javax.swing.*;
import java.awt.*;

class Paneau extends JPanel {

    MovingObject bal, pad;
    Bricks bricks; //l'ensembre des bricks
    public int Score; //le score du jeur
    int Turns = Constants.turns; //nombre de tours du jeu
	int hits = 0; //compteur du nombre de collision de la balle avec les briques

	JFrame parentFrame ; //pour récuperer la fenêtre et définir son titre avec le score

	//regrouper les objets du jeu
    Paneau(MovingObject _pal, MovingObject _pad, Bricks _bricks, JFrame _parentFrame) {
        
		super();
        this.bal = _pal;
        this.pad = _pad;
        this.bricks = _bricks;
		parentFrame = _parentFrame;
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g); // appel à la super methode  de la classe

        final Rectangle ball = bal.getRect();
        final Rectangle padle = pad.getRect();

        g.setColor(Constants.ballColor); //définir la couleur et dessiner la balle
        g.fillRect(ball.x, ball.y, ball.width, ball.height);
        g.setColor(Constants.padColor); //définir la couleur et dessiner le paddle
        g.fillRect(padle.x, padle.y, padle.width, padle.height);

		////définir la couleur et dessiner les briques
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
		ballTouchground();

    }

	//gérer les collisions entre la balle et les deux autres objets 
    public void manageCollisions() {

		//gérer la collision de la balle avec le paddle
        if (bal.getRect().intersects(((Paddle) pad).getRect())) {
            ((Balle) bal).ChangeDir();
        }
		
		//gérer la collision de la balle avec des briques
        for (int i = 0; i < Constants.BricksPerColumn; i++) {
            for (int j = 0; j < Constants.BricksPerRows; j++) {

				//en cas de collision de la balle avec une brique
                if (bal.getRect().intersects(bricks.ManyBricks[i][j].getRect())) {

                    //la balle rébondit
					((Balle) bal).ChangeDir();

					//faire "disparaître" la brique heurtée par la balle
                    bricks.ManyBricks[i][j].hasToDisapeared();
                    hits += 1; //compter la collision
					
					//ajuster la vitesse de la balle 					
                    manageBallSpeed(bricks.ManyBricks[i][j].couleur, hits); 
					//modifier le score
                    manageScore(bricks.ManyBricks[i][j].couleur);
                }
            }
        }
    }

	//le paddle rate la balle
	public void ballTouchground(){

		//gérer le fait que la balle touche le sol
		if(((Balle) bal).missingBall()){
			Turns -= 1;
			((Balle) bal).Resetball();
		}
	}

	//calcul du score en fonction de la couleur
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
		//afficher le score au niveau de l'emplacement du titre de la fenêtre
		parentFrame.setTitle("Score : "+Score+"    Turn : "+Turns );
    }

	//reduire la taille du paddle 
    public void manageWidthPad() {
        if (((Balle) bal).hitUpperWall() ) {
            ((Paddle) pad).WidthPad = ((Paddle) pad).WidthPad - (((Paddle) pad).WidthPad * (3/ 5));
        }
    }

	//gérer la vitesse de la balle
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

	Boolean playGame = true;

	while (playGame){
	    fen.repaint() ; 
		Thread.sleep(50);
		if (((Paneau)(fen.pan)).Turns<=0) {
			playGame = false;
			
			//fermer la fenêtre une fois le nombre de tours atteint.
			fen.dispose();
		}
	}


   }
}
