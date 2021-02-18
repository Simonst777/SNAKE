package sample;


import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.Node;

import java.util.Timer;


public class Main extends Application {
    int horizontal = 0;
    int vertical = 0;
    int i = 25;
    int y = 25;


    enum Key {
        Up,
        Down,
        Right,
        Left
    }
    Key key = null;



    private Cell[][] drawSquares(Pane p){
        Cell cellArray[][] = new Cell[50][50];
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                Cell cell = new Cell(i*Cell.size, j*Cell.size);

                if (i % 2 == 0) {
                    if (j % 2 == 0) {
                    cell.setFillGray();
                    } else {
                        cell.setFillWhite();
                    }
                } else {
                    if (j % 2 == 0) {
                        cell.setFillWhite();
                    } else {
                        cell.setFillGray();
                    }
                }
                p.getChildren().add(cell.getRectangle());
                cellArray[i][j] = cell;
            }
        }
        return cellArray;
    }
    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene scene = new Scene( root,500, 500);
        Pane pane = (Pane) scene.lookup("#pane");
        Cell[][] cellArray = drawSquares(pane);




        primaryStage.setScene(scene);
        Label label = (Label ) scene.lookup("#label");

        createAnimation(cellArray, label);
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent keyEvent) {
               // ellipse.setCenterY(100);

                if ("Down".equals(keyEvent.getCode().getName()) ){
                    key = Key.Down;


                }
                if ("Up".equals(keyEvent.getCode().getName()) ){
                    key = Key.Up;

                }
                if ("Right".equals(keyEvent.getCode().getName()) ){
                    key = Key.Right;

                }
                if ("Left".equals(keyEvent.getCode().getName()) ){
                    key = Key.Left;

                }
            }
        });

        primaryStage.show();

    }

    private void createAnimation(Cell[][] cellArray, Label label) {
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {

                Cell cell = cellArray[i][y];
                cell.setFillRed();



                if (key == Key.Right) {
                    Cell cellOccupied = cellArray[i + horizontal + 1][y + vertical];
                    if (cellOccupied.isRed() == false ) {
                        horizontal += 1;
                        Cell newCellPos = cellArray[i + horizontal][y + vertical];
                        newCellPos.setFillRed();
                    } else {
                        label.setText("Game over");

                    }
                }
                if (key == Key.Left) {
                    Cell cellOccupied = cellArray[i + horizontal - 1][y + vertical];
                    if (cellOccupied.isRed() == false ) {
                        horizontal -= 1;
                        Cell newCellPos = cellArray[i + horizontal][y + vertical];
                        newCellPos.setFillRed();
                    } else {
                        label.setText("Game over");
                    }
                }
                if (key == Key.Up) {
                    Cell cellOccupied = cellArray[i + horizontal][y + vertical - 1];
                    if (cellOccupied.isRed() == false) {
                        vertical -= 1;
                        Cell newCellPos = cellArray[i + horizontal][y + vertical];
                        newCellPos.setFillRed();
                    } else {
                        label.setText("Game over");
                    }

                }
                if (key == Key.Down) {
                    Cell cellOccupied = cellArray[i + horizontal][y + vertical + 1];
                    if (cellOccupied.isRed() == false) {
                        vertical += 1;
                        Cell newCellPos = cellArray[i + horizontal][y + vertical];
                        newCellPos.setFillRed();
                    } else {
                        label.setText("Game over");
                    }
                }

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        };
        timer.start();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
