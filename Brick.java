import java.awt.Color;
import java.awt.Rectangle;

public class Brick {
    
    int xBrick,yBrick;
    //initialiser la dimension avec des constantes
    int widthBrick = Constants.widthBrick; 
    int heightBrick = Constants.heightBrick;
    
    Color couleur;
    
    //créer une brique en fonction d'une couleur donnée
    Brick(int _xBrick,int _yBrick,Color _couleur){
        this.xBrick = _xBrick;
        this.yBrick = _yBrick;
        this.couleur = _couleur;
    }

    public Rectangle getRect(){
      return new Rectangle(xBrick,yBrick,widthBrick,heightBrick);
    
    }

    //pour faire disparaître une brique de la fenêtre
    public void hasToDisapeared() {
        this.xBrick = - Constants.widthBrick;
        this.yBrick =-Constants.heightBrick;
        this.widthBrick=0;
        this.heightBrick=0;
        this.couleur= Constants.backgroundColor;
    }


    @Override
    public String toString(){
        return "("+xBrick+","+yBrick+") ";
    }
}
