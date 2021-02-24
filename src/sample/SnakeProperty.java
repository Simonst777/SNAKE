package sample;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class SnakeProperty {
    static int minLengh = 3;
    static int lastHorizontalPos = -1;
    static int lastVerticalPos = -1;
    static  int currentLenght = 0;
    static Paint lastColor;


    public static void clearTail(Cell[][] cells){
        if (lastHorizontalPos != -1 && lastVerticalPos != -1) {
            if (lastColor == Color.RED) {
                cells[lastHorizontalPos][lastVerticalPos].setOriginColor();
            }else {
                cells[lastHorizontalPos][lastVerticalPos].setOriginColor();
            }
        }

    }
}
