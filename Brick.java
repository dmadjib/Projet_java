import java.awt.Color;
import java.awt.Rectangle;

public class Brick {

    int xBrick,yBrick;
    float widthBrick,heightBrick;
    Color couleur;

    Brick(int _xBrick,int _yBrick,Color _couleur){
        this.xBrick = _xBrick;
        this.yBrick = _yBrick;
        this.couleur = _couleur;
    }

    public Rectangle getRect(){
      return new Rectangle(xBrick,yBrick,Constants.widthBrick,Constants.heightBrick);
    
}
}