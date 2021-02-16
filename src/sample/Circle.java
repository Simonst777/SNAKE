package sample;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.geometry.Point2D;




public class Circle {
    private Point2D mCenter;
    private Color color;
    private float mRadius;

    public Circle (Point2D center, Color color, float radius ) {
        this.mCenter = center;
        this.color = color;
        this.mRadius = radius;
    }

    public void drawCircle(GraphicsContext gc) { // My Doubt is here
        Canvas canvas = new Canvas();
        gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.WHITE);
        gc.setStroke(Color.BLACK);

    }
}
