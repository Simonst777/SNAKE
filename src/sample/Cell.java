package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;


public class Cell  {
    public int posY;
    public int posX;
    public static final int size = 10;

    private final Rectangle rectangle = new Rectangle();

    public Cell( int posX, int posY) {

        this.posX = posX;
        this.posY = posY;

        rectangle.setWidth(size);
        rectangle.setHeight(size);
        rectangle.setX(posX);
        rectangle.setY(posY);
        rectangle.setFill(Color.RED);
    }
    public Rectangle getRectangle() {
        return rectangle;
    }
    public void setFillGray(){
        rectangle.setFill(Color.GRAY);

    }
    public void setFillWhite(){
        rectangle.setFill(Color.WHITE);
    }
    public void setFillRed(){
        rectangle.setFill(Color.RED);
    }
    public boolean isRed(){
        Paint curendColor = rectangle.getFill();
        if (curendColor == Color.RED){
            return true;
        } else {
            return false;
        }
    }

    }



