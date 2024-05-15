import javax.swing.* ;

public class MaFenetre extends JFrame {
    JPanel pan ;
    //pour définir la taille de la fenêtre
    private int width,height;
     //taille prédéfinie : 	(320,200+50) 
    MaFenetre(int _width,int _height){
     this.width = _width;
     this.height = _height;
     setSize(width,height);
     setTitle(Constants.TITLE);
     pan = new Paneau(new Palet(30,30,2,2)) ; 
 /*	pan = new Paneau(new Pulsar(...)) ; */
     setContentPane(pan) ;
     }
 
     public int getWidth() {
         return this.width;
     }
 
     public int getHeight(){
         return this.height;
     }
 }
 