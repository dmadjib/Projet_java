public class Bricks {

    Brick[][] ManyBricks = new Brick[Constants.BricksPerColumn][Constants.BricksPerRows];
    private Colors colors = new Colors();

    Bricks() {
        int i =0;
        int k = 0;
        while ( k < colors.colorList.size()) {
            while (i < Constants.BricksPerColumn) {
                int py = Constants.margeBrick * (i + 1) + i * Constants.heightBrick;
                for (int j = 0; j < Constants.BricksPerRows; j++) {
                    int px = Constants.margeBrick * (j + 1) + j * Constants.widthBrick;
                    ManyBricks[i][j] = new Brick(px, py, colors.colorList.get(k));
                }
    
                if (i % 2 != 0) {
                    k=k+1;
                }
                i = i+1;
            }
        }
    }

    public void printBricks() {
        for (int i = 0; i < Constants.BricksPerRows; i++) {
            for (int j = 0; j < Constants.BricksPerColumn; j++) {
                System.out.print(ManyBricks[i][j]);  // Utiliser \t pour l'alignement
            }
            System.out.println();  // Nouvelle ligne après chaque ligne du tableau
        }
    }
}
