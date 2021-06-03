package view;

import com.sun.org.apache.bcel.internal.generic.IAND;
import com.sun.org.apache.bcel.internal.generic.LAND;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.SHIP;

public class GameViewManager {

    private AnchorPane gamePane;
    private Scene gameScene;
    private Stage gameStage;

    private static final int GAME_WIDTH = 600;
    private static final int GAME_HEIGHT = 800;

    private Stage menuStage;
    private ImageView ship;

    private boolean isLeftKeyPressed;
    private boolean isRightKeyPressed;
    private int angle;
    private AnimationTimer gameTimer;

    public GameViewManager() {
        initializeStage();
        createKeyListener();
    }

    private void createKeyListener() {

        gameScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.LEFT) {
                    isLeftKeyPressed = true;
                } else if (event.getCode() == KeyCode.RIGHT) {
                    isRightKeyPressed = true;
                }
            }
        });
        gameScene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.LEFT) {
                    isLeftKeyPressed = false;
                } else if (event.getCode() == KeyCode.RIGHT) {
                    isRightKeyPressed = false;
                }
            }
        });
    }
    private void initializeStage() {
        gamePane = new AnchorPane();
        gameScene = new Scene(gamePane, GAME_WIDTH, GAME_HEIGHT);
        gameStage = new Stage();
        gameStage.setScene(gameScene);

    }
    public void createNewGame(Stage menuStage, SHIP chooseShip) {
        this.menuStage = menuStage;
        this.menuStage.hide();
        createShip(chooseShip);
        gameStage.show();
    }
    private void createShip(SHIP chosenShip) {
        ship = new ImageView(chosenShip.getUrl());
        ship.setLayoutX(GAME_WIDTH / 2);
        ship.setLayoutY(GAME_HEIGHT - 90);
        gamePane.getChildren().add(ship);
    }
    private void createGameLoop() {
        gameTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {

            }
        };
        gameTimer.start();
    }
    private void moveShip() {

        if (isLeftKeyPressed && !isRightKeyPressed) {
            if (angle > -30)
                angle -= 5;
            ship.setRotate(angle);
        }
    }
}
