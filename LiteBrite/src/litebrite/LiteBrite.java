/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package litebrite;


import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author narayan
 */
public class LiteBrite extends Application {
    final static ColorPicker COLORPICK = new ColorPicker();
    
    @Override
    public void start(final Stage stage) throws Exception {
        int rows = 20;
        int columns = 20;
        

        stage.setTitle("Enjoy your game");
        
        GridPane grid = new GridPane();
        grid.getStyleClass().add("game-grid");
        
        for(int i = 0; i < columns; i++) {
            ColumnConstraints column = new ColumnConstraints(10);
            grid.getColumnConstraints().add(column);
        }

        for(int i = 0; i < rows; i++) {
            RowConstraints row = new RowConstraints(10);
            grid.getRowConstraints().add(row);
        }

        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                Pane pane = new Pane();
                pane.setOnMouseReleased(e -> {
                    pane.getChildren().add(Anims.getAtoms(1));
                });
                pane.getStyleClass().add("game-grid-cell");
                
                if (i == 0) {
                    pane.getStyleClass().add("first-column");
                }
                if (j == 0) {
                    pane.getStyleClass().add("first-row");
                }
                grid.add(pane, i, j);
            }
        }

        
        HBox box = new HBox();
        box.getChildren().add(grid);
        box.getStylesheets().add(LiteBrite.class.getResource("resources/game.css").toExternalForm());
        SplitPane split = new SplitPane();
        split.orientationProperty().set(Orientation.VERTICAL);
        split.getItems().add(COLORPICK);
        split.getItems().add(box);
        Scene sceneSplit = new Scene(split);
        stage.setScene(sceneSplit);
        stage.show();
    }

    public static class Anims {

        public static Node getAtoms(final int number) {
            //TODO: Add code to create a colored
            Color n = COLORPICK.getValue();
            
            return null;
        }
    }

    public static void main(final String[] arguments) {
        Application.launch(arguments);
    }
    
}
