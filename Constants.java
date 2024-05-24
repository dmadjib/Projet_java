import java.awt.Color;

public final class Constants {
    
    //dimensions de la fenêtre
    public static final int WidthFen =  500;
    public static final int HeightFen = 500;
    public static final int margeD = 25;  //marge droite de la fenêtre
    public static final int margeB = 50;   //marge basse de la fenêtre

    //dimensions du paddle
    public static final int WidthPad =  80;
    public static final int HeightPad = 10;

    public static final int Ypad = 200-20;

    public static Color padColor = Color.BLUE;
    public static Color ballColor = Color.WHITE;

    //les dimensions  de la balle
    public static final int WidthBal =  15;
    public static final int HeightBal = 15;

    public static final int XinitBal = WidthFen/2; 
    public static final int YinitBal = HeightFen/2;  

    public static final int vxinitBal = 10;
    public static final int vyinitBal = 10;

    public static final int Vsup = 5;

    //les dimensions d'une brique
    public static final int BricksPerRows = 6;
    public static final int BricksPerColumn = 8;
    public static final int margeBrick = 3;
    public static final int widthBrick = (WidthFen/BricksPerRows)-margeBrick;
    public static final int heightBrick =20;


    
    //la fenêtre
    public static Color backgroundColor = Color.BLACK;

    //le nombre de tours du jeu
	public static int turns = 3;

}
