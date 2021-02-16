package sample;

import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.Effect;
import javafx.scene.effect.Shadow;
import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

import java.awt.*;

public class Controller {
    @FXML
    public Canvas img1;





    @FXML
    private void printHelloWorld(ActionEvent event) {
        event.consume();
        System.out.println();




    }

    @FXML
    private GraphicsContext gc ;

    @FXML private void drawCanvas(ActionEvent event) {
        gc.setFill(Color.grayRgb(5));
        gc.fillRect(10,10,10,10);
    }
}
