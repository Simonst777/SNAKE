package sample;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Random;

public class Main extends Application {
    int horizontal = 25;
    int vertical = 25;


    enum Key {
        Up,
        Down,
        Right,
        Left
    }
    Key key = null;
    boolean grow = false;


    private Cell[][] drawSquares(Pane p){
        Cell cellArray[][] = new Cell[50][50];
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                Cell cell = new Cell(i*Cell.size, j*Cell.size);

                if (i % 2 == 0) {
                    if (j % 2 == 0) {
                    cell.setFillGray();
                    cell.originColor = Color.rgb(199,199,199);

                    } else {
                        cell.setFillWhite();
                        cell.originColor = Color.WHITE;
                    }
                } else {
                    if (j % 2 == 0) {
                        cell.setFillWhite();
                        cell.originColor = Color.WHITE;
                    } else {
                        cell.setFillGray();
                        cell.originColor = Color.rgb(199,199,199);
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
        Scene scene = new Scene( root,500, 800);
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

    private ArrayList<Food> createFood(Cell[][] cellArray) {
        ArrayList<Food> foodItems = new ArrayList<Food>();
        Random rand = new Random(10);
        int int_random = rand.nextInt(60);
        for(int i = 0; i < int_random; i++) {
            Food newFood = new Food();
            newFood.posX = rand.nextInt(50);
            newFood.posY = rand.nextInt(50);
            newFood.color = Color.GREEN;
            cellArray[newFood.posX][newFood.posY].setFoodColor(newFood.color);
            foodItems.add(newFood);
        }
        return foodItems;
    }

    private void createAnimation(Cell[][] cellArray, Label label) {

        SnakeProperty.addHead(cellArray[horizontal][vertical]);


        ArrayList<Food> foodItems = createFood(cellArray);

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {

                // last position of previous frame

                int oldHorizontal = horizontal;
                int oldVertical = vertical;
                if (key == Key.Right) {
                    if (!SnakeProperty.isOccupied(horizontal, vertical)) {
                        horizontal += 1;
                        Cell newCellPos = cellArray[horizontal][vertical];
                        SnakeProperty.addHead(newCellPos);
                        SnakeProperty.clearTail(cellArray);
                    } else {
                        label.setText("Game over");
                    }
                }
                if (key == Key.Left) {
                    if (!SnakeProperty.isOccupied(horizontal, vertical)) {
                        horizontal -= 1;
                        Cell newCellPos = cellArray[horizontal][vertical];
                        SnakeProperty.addHead(newCellPos);
                        SnakeProperty.clearTail(cellArray);
                    } else {
                        label.setText("Game over");
                    }
                }
                if (key == Key.Up) {
                    if (!SnakeProperty.isOccupied(horizontal, vertical)) {
                        vertical -= 1;
                        Cell newCellPos = cellArray[horizontal][vertical];
                        SnakeProperty.addHead(newCellPos);
                        SnakeProperty.clearTail(cellArray);
                    } else {
                        label.setText("Game over");
                    }

                }
                if (key == Key.Down) {
                    if (!SnakeProperty.isOccupied(horizontal, vertical)) {
                        vertical += 1;
                        Cell newCellPos = cellArray[horizontal][vertical];
                        SnakeProperty.addHead(newCellPos);
                        SnakeProperty.clearTail(cellArray);
                    } else {
                        label.setText("Game over");
                    }
                }

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // check if food is captured
                if (foodWasEaten(foodItems, horizontal, vertical)) {
                    Cell newCellPos = cellArray[oldHorizontal][oldVertical];
                    SnakeProperty.addTail(newCellPos);
                }
            }

        };
        timer.start();
    }

    private static boolean foodWasEaten(ArrayList<Food> foodItems, int horizontal, int vertical) {
        Food eatenFood = null;
        for(Food food : foodItems) {
            if(food.posX == horizontal && food.posY == vertical)
                eatenFood = food;
        }
        if(eatenFood != null) {
            foodItems.remove(eatenFood);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
