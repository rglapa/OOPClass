/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import javafx.scene.input.MouseEvent;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
/**
 *
 * @author rubenglapa
 */
public class ButtonsAndLabels extends Application {
    
    private static final Color color = Color.web("#464646");
    Button button3 = new Button("Decline");
    DropShadow shadow = new DropShadow();
    Label label = new Label();
    
    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(new Group());
        primaryStage.setTitle("Button Sample");
        primaryStage.setWidth(300);
        primaryStage.setHeight(190);
        
        label.setFont(Font.font("Times New Roman", 22));
        label.setTextFill(color);
        
        Image imageDecline = new Image(getClass().getResourceAsStream("images/not.png"));
        Image imageAccept = new Image(getClass().getResourceAsStream("images/ok.png"));
        
        VBox vbox = new VBox();
        vbox.setLayoutX(0);
        vbox.setLayoutY(0);
        HBox hbox1 = new HBox();
        HBox hbox2 = new HBox();
        
        Button button1 = new Button("Accept", new ImageView(imageAccept));
        button1.setStyle("-fx-font: 22 arial; -fx-base: #b6e7c9;");
        button1.setOnAction((ActionEvent e) -> {
            label.setText("Accepted");
        });
        
        Button button2 = new Button("Accepted");
        button2.setOnAction((ActionEvent e) -> {
            label.setText("Accepted");
        });
        
        button3.setOnAction((ActionEvent e) -> {
            label.setText("Declined");
        });
        
        button3.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            button3.setEffect(shadow);
        });
        
        button3.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            button3.setEffect(null);
        });
        
        hbox1.getChildren().add(button2);
        hbox1.getChildren().add(button3);
        hbox1.getChildren().add(label);
        hbox1.setSpacing(10);
        hbox1.setAlignment(Pos.BOTTOM_CENTER);
        
        Button button4 = new Button();
        button4.setGraphic(new ImageView(imageAccept));
        button4.setOnAction((ActionEvent event) -> {
            label.setText("Accepted");
        });
        
        Button button5 = new Button();
        button5.setGraphic(new ImageView(imageDecline));
        button5.setOnAction((ActionEvent event) -> {
            label.setText("Declined");
        });
        
        hbox2.getChildren().add(button4);
        hbox2.getChildren().add(button5);
        hbox2.setSpacing(25);
        
        vbox.getChildren().add(button1);
        vbox.getChildren().add(hbox1);
        vbox.getChildren().add(hbox2);
        vbox.setSpacing(10);
        ((Group)scene.getRoot()).getChildren().add(vbox);
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
