import java.awt.Color;
import javax.swing.*;
import java.util.ArrayList;

public class MaFenetre extends JFrame {
    JPanel pan;
    Color couleur1 = Color.RED;
    Color couleur2 = Color.ORANGE;
    Color couleur3 = Color.GREEN;
    Color couleur4 = Color.YELLOW;

    // pour définir la taille de la fenêtre
    private int width, height;

    // taille prédéfinie : (320,200+50)
    MaFenetre(int _width, int _height) {
        this.width = _width;
        this.height = _height;

        setSize(width, height);
        setTitle(Constants.TITLE);

        ArrayList<Brick> listRed = new ArrayList<>();
        ArrayList<Brick> listOrange = new ArrayList<>();
        ArrayList<Brick> listGreen = new ArrayList<>();
        ArrayList<Brick> listYellow = new ArrayList<>();
        MovingObject une_balle = new Balle(Constants.XinitBal, Constants.YinitBal, Constants.vxinitBal, Constants.vyinitBal);
        Paddle un_paddle = new Paddle(Constants.WidthFen / 2, Constants.HeightFen - Constants.margeB - Constants.HeightPad);

        this.addMouseMotionListener(un_paddle);

        pan = new Paneau(une_balle, un_paddle);
        setContentPane(pan);
    }


}
