import javax.swing.*;

public class MaFenetre extends JFrame {
    JPanel pan;

    // pour définir la taille de la fenêtre
    private int width, height;

    // taille prédéfinie : (320,200+50)
    MaFenetre(int _width, int _height) {
        this.width = _width;
        this.height = _height;

        setSize(width, height);
        setTitle(Constants.TITLE);
       
        MovingObject une_balle = new Balle(Constants.XinitBal, Constants.YinitBal, Constants.vxinitBal, Constants.vyinitBal);
        Paddle un_paddle = new Paddle(Constants.WidthFen / 2, Constants.HeightFen - Constants.margeB - Constants.HeightPad);
        Bricks bricks = new Bricks();


        this.addMouseMotionListener(un_paddle);

        pan = new Paneau(une_balle, un_paddle,bricks);
        setContentPane(pan);
    }


}
