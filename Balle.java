import java.awt.Rectangle ;

public class Balle implements MovingObject {

  int x ;
  int y ;
  
  int vx ;
  int vy ;

  //créer une brique avec une position donnée
  Balle(int _x, int _y, int _vx, int _vy){
    x = _x ;
    y = _y ;
    vx = _vx ;
    vy = _vy ;
  }

  //quand le palet atteint les bords de la fenêtre
  boolean sortie_x (int px){ return (px< 0) || (px>(Constants.WidthFen - Constants.margeD)) ; }
  boolean sortie_y_up (int py){ return (py< 0)  ; }//le haut de la fenêtre
  boolean sortie_y_down(int py){return py>(Constants.HeightFen - Constants.margeB);} //le bas de la fenêtre
  
  //la balle touche le sol
  public boolean missingBall(){
    return sortie_y_down(y+vy);
  }

  //reinitialiser la position de la balle
  public void Resetball(){
    x = Constants.XinitBal;
    y = Constants.YinitBal;
  }

  //deplacer le palet 
  public void deplace(){
    
    if ( sortie_x (x + vx) ) {
	    vx = (-1) * vx ;
    }
    else {
	    x = x + vx ;
    }
    
    if ( sortie_y_up (y + vy)||sortie_y_down(y+vy)) {
	    vy = (-1) * vy ;
    }
    else {
	    y = y + vy ;
    }
  }
  
  //la balle traverse des briques rouges et touche le haut
  public boolean hitUpperWall(){
    return sortie_y_up(y+vy) ;
  }

  //Changer la direction de la balle après une collision
  public void ChangeDir(){
    vy = (-1) * vy;
  } 

  @Override
  public Rectangle getRect(){
    return new Rectangle(x,y,Constants.WidthBal,Constants.HeightBal);
  }
  
  //pour augmenter la vitesse de la balle
  public void IncreaseSpeed() {
    this.vx = this.vx+Constants.Vsup;
    this.vy = this.vy+Constants.Vsup;
  }    
   
}

