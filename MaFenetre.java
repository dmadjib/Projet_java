import javax.swing.*;

public class MaFenetre extends JFrame {
    JPanel pan;
    
    // dimensions de la fenêtre
    private int width, height;

    //définir une fenêtre avec des dimensions données
    MaFenetre(int _width, int _height) {
        this.width = _width;
        this.height = _height;

        setSize(width, height);
        

        MovingObject bal = new Balle(Constants.XinitBal, Constants.YinitBal, Constants.vxinitBal, Constants.vyinitBal);
        Paddle paddle = new Paddle(Constants.WidthFen / 2, Constants.HeightFen - Constants.margeB - Constants.HeightPad);
        Bricks bricks = new Bricks();

        //utiliser la souris pour déplacer le paddle
        this.addMouseMotionListener(paddle);

        // passer la fenêtre en paramêtre pour afficher le score au niveau du titre
        pan = new Paneau(bal, paddle, bricks,this);
        
        // définir la couleur  et le fond d'écran
        pan.setBackground(Constants.backgroundColor);
        setContentPane(pan);
        setVisible(true);
    }
}
