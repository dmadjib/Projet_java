public class Bricks {

    //liste de briques
    Brick[][] ManyBricks = new Brick[Constants.BricksPerColumn][Constants.BricksPerRows];

    //l'ensemble des couleurs indiquées
    private Colors colors = new Colors();

    //initialiser l'ensemble des briques
    Bricks() {

        int i =0;
        int k = 0;
        //pour chaque couleur
        while ( k < colors.colorList.size()) {

            while (i < Constants.BricksPerColumn) {
                int py = Constants.margeBrick * (i + 1) + i * Constants.heightBrick; //l'ordonnée de la position d'une brique
                for (int j = 0; j < Constants.BricksPerRows; j++) {
                    int px = Constants.margeBrick * (j + 1) + j * Constants.widthBrick; //l'abcisse de la position d'une brique
                    ManyBricks[i][j] = new Brick(px, py, colors.colorList.get(k)); //ajout d'une nouvelle brique
                }
                //changer de couleur de brique toutes les deux rangées 
                if (i % 2 != 0) {
                    k=k+1;
                }
                i = i+1;
            }
        }
    }

}
