package sample;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.util.ArrayList;

public class SnakeProperty {
    static int minLengh = 3;
    static int lastHorizontalPos = -1;
    static int lastVerticalPos = -1;
    static  int currentLength = 1;
    static Paint lastColor;
    static ArrayList<Cell> cellList = new ArrayList();


    public static void clearTail(Cell[][] cells){
        Cell tail = cellList.get(0);
        tail.setOriginalColor();
        cellList.remove(0);
        redrawSnake();

    }

    public static boolean isOccupied(int horizontal, int vertical) {
        for(Cell cell : cellList){
            if(cell.posX == horizontal && cell.posY == vertical)
                return true;
        }
        return false;

    }

    public static void redrawSnake() {
        for(Cell cell : cellList) {
            cell.setFillRed();
        }
    }

    public static void addHead(Cell cell) {
        cellList.add(cell);
        redrawSnake();

    }

    public static void addTail(Cell cell) {
        cellList.add(0, cell);
        redrawSnake();
    }
}
