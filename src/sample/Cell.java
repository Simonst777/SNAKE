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
    }

    public Color originColor;

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setFillGray(){
        rectangle.setFill(Color.rgb(199,199,199));

    }
    public void setFillWhite(){
        rectangle.setFill(Color.WHITE);
    }

    public void setFillRed(){
        rectangle.setFill(Color.RED);
    }

    public boolean isRed(){
        Paint currentColor = rectangle.getFill();
        if (currentColor == Color.RED){
            return true;
        } else {
            return false;
        }
    }

    public void setOriginalColor(){
        if (this.posX != -1 && this.posY != -1) {
            rectangle.setFill(originColor);
        }
    }
    public void setFoodColor(Color color){
        rectangle.setFill(color);
    }

    }



