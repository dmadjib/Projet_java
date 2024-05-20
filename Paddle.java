
import java.awt.Rectangle ;

public class Paddle implements MovingObject {
    int x ;
    int y;


    Paddle(int _x, int _y){
      this.x = _x;
      this.y = _y;
    }

    //quand le paddle atteint les bords de la fenêtre
    boolean sortie_x (int px){ return (px< 0) || (px>Constants.WidthFen) ; }

    @Override
    public void deplace(){
    if (x>Constants.WidthFen) {
        x = Constants.WidthFen;
      }
    else if (x<0) {
      x = 0;
      
    }
    }
    @Override
    public Rectangle getRect(){
      return new Rectangle(x,y,Constants.WidthPad,Constants.HeightPad);
    }
  }