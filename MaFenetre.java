import javax.swing.*;

public class MaFenetre extends JFrame {
    JPanel pan;

    // for defining the size of the window
    private int width, height;

    // predefined size: (320, 200+50)
    MaFenetre(int _width, int _height) {
        this.width = _width;
        this.height = _height;

        setSize(width, height);
        

        MovingObject bal = new Balle(Constants.XinitBal, Constants.YinitBal, Constants.vxinitBal, Constants.vyinitBal);
        Paddle paddle = new Paddle(Constants.WidthFen / 2, Constants.HeightFen - Constants.margeB - Constants.HeightPad);
        Bricks bricks = new Bricks();

        this.addMouseMotionListener(paddle);

        // Créer un panneau et passer la fenêtre en paramêtre pour afficher le score au niveau du titre
        pan = new Paneau(bal, paddle, bricks,this);

        // Set background color and content pane
        pan.setBackground(Constants.backgroundColor);
        setContentPane(pan);
        setVisible(true);
    }
}
