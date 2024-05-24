import java.awt.Rectangle ;

public class Balle implements MovingObject {

  int x ;
  int y ;
  
  int vx ;
  int vy ;

  
  Balle(int _x, int _y, int _vx, int _vy){
    x = _x ;
    y = _y ;
    vx = _vx ;
    vy = _vy ;
  }
  //quand le palet atteint les bords de la fenêtre
  boolean sortie_x (int px){ return (px< 0) || (px>(Constants.WidthFen - Constants.margeD)) ; }
  boolean sortie_y (int py){ return (py< 0) || (py>(Constants.HeightFen - Constants.margeB)) ; }
  
  //deplacer le palet 
  public void deplace(){
    
    if ( sortie_x (x + vx) ) {
	    vx = (-1) * vx ;
    }
    else {
	    x = x + vx ;
    }
    
    if ( sortie_y (y + vy)) {
	    vy = (-1) * vy ;
    }
    else {
	    y = y + vy ;
    }
  }

  public void ChangeV(){

    //vx = (-1) * vx;
    vy = (-1) * vy;
  } 

  public Rectangle getRect(){
    return new Rectangle(x,y,Constants.WidthBal,Constants.HeightBal);
  }    
   
  /**public void hitWith(MovingObject _paddle){
    this.hitpad = false;
    if( (_paddle.y == this.y+Constants.HeightBal) && 
        (this.x >= Constants.WidthPad || this.x <= Constants.WidthPad+_paddle.x ) ){
        hitpad = true;
        paddlecopy = _paddle;
    }**/

  }

