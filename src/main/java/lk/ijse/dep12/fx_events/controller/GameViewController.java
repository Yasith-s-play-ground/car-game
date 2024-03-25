package lk.ijse.dep12.fx_events.controller;

import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;

public class GameViewController {
    public AnchorPane root;
    public Label lblBackground;
    public Label lblCar;
    public Label lblBackground2;

    public void initialize() {
        lblBackground2.setLayoutX(lblBackground.getLayoutX());
        lblBackground2.setLayoutY(lblBackground.getLayoutY() - 500);
        double lblCarStartX = lblCar.getLayoutX();
        Platform.runLater(() ->
        {
            root.getScene()
                    .setOnKeyPressed(keyEvent -> {
                        if (keyEvent.getCode() == KeyCode.RIGHT) {
                            if (lblCar.getLayoutX() + 10 < lblCarStartX + 30)
                                lblCar.setLayoutX(lblCar.getLayoutX() + 10);
                        } else if (keyEvent.getCode() == KeyCode.LEFT) {
                            if (lblCar.getLayoutX() - 10 > lblCarStartX - 105)
                                lblCar.setLayoutX(lblCar.getLayoutX() - 10);

                        }
                        if (keyEvent.getCode() == KeyCode.UP) {
                            if (lblBackground.getLayoutY() == 500) lblBackground.setLayoutY(0);
                            else lblBackground.setLayoutY(lblBackground.getLayoutY() + 10);
                            lblBackground2.setLayoutY(lblBackground.getLayoutY() - 500);
                        }
                    });
        });
    }
}
