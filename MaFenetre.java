import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.net.http.WebSocket.Listener;
import java.util.ArrayList;
import javax.swing.* ;


public class MaFenetre extends JFrame {
    JPanel pan ;
    Color couleur1 = Color.RED;
    Color couleur2 = Color.ORANGE;
    Color couleur3 = Color.GREEN;
    Color couleur4 = Color.YELLOW;

    //pour définir la taille de la fenêtre
    private int width,height;
    
     //taille prédéfinie : 	(320,200+50) 
    MaFenetre(int _width,int _height){
    this.addMouseMotionListener(new MouseMotionAdapter() {
        public void mouseMoved(MouseEvent e){
            handlekeypress(e);
        }
    });
     this.width = _width;
     this.height = _height;
    
     setSize(width,height);
     setTitle(Constants.TITLE);
     
     ArrayList listRed = new ArrayList<Brick>();
     ArrayList listOrange = new ArrayList<Brick>();
     ArrayList listGreen = new ArrayList<Brick>();
     ArrayList listYellow = new ArrayList<Brick>();
     MovingObject une_balle =new Balle(Constants.XinitBal,Constants.YinitBal,Constants.vxinitBal,Constants.vyinitBal);
     MovingObject un_paddle =new Paddle(Constants.WidthFen/2,Constants.HeightFen-Constants.margeB-Constants.HeightPad);


     pan = new Paneau(une_balle,un_paddle) ;
 
     setContentPane(pan) ;
    }
 
    private void handlekeypress(MouseEvent e) {
        System.out.println("salut");
        System.out.println(e);
    }

 }
 