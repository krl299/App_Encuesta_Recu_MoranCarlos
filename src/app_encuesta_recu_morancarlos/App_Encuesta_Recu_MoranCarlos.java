/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_encuesta_recu_morancarlos;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.EventType;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author Carlos
 */
public class App_Encuesta_Recu_MoranCarlos extends Application {
    
    @Override
    public void start(Stage primaryStage) {
//        Menu
        Menu polls = new Menu("Polls");
        Menu helps = new Menu("Help");
        
//        MenuItems, open new polls
        Menu poll = new Menu("Open Poll");
        polls.getItems().add(poll);
        
//        Poll Sports
        MenuItem sports= new MenuItem("Sports");
//        Poll Foods
        MenuItem foods= new MenuItem("Foods");
//        Poll Animals
        MenuItem animals= new MenuItem("Animals");
//        Poll Travels
        MenuItem travels= new MenuItem("Travels");
//        Poll Readings
        MenuItem readings= new MenuItem("Readings");
        
//        Add polls in poll Menu
        poll.getItems().add(sports);
        poll.getItems().add(foods);
        poll.getItems().add(animals);
        poll.getItems().add(travels);
        poll.getItems().add(readings);
        
//        EventHandler for each poll
        sports.addEventHandler(EventType.ROOT, (event) -> {
            Sports new_sports = new Sports(primaryStage);
        });
        foods.addEventHandler(EventType.ROOT, (event) -> {
            Foods new_sports = new Foods(primaryStage);
        });
        animals.addEventHandler(EventType.ROOT, (event) -> {
            Animals new_sports = new Animals(primaryStage);
        });
        travels.addEventHandler(EventType.ROOT, (event) -> {
            Travels new_sports = new Travels(primaryStage);
        });
        readings.addEventHandler(EventType.ROOT, (event) -> {
            Readings new_sports = new Readings(primaryStage);
        });
        
//        Exit App
        MenuItem exit = new MenuItem("Exit.");
        polls.getItems().add(exit);
        exit.addEventHandler(EventType.ROOT, (event) -> {
            System.exit(0);
        });
        
//        Menuitem of help
        MenuItem help = new MenuItem("Help");
        MenuItem about = new MenuItem("About");
        
        helps.getItems().add(help);
        helps.getItems().add(about);
        
//        MenuBar
        MenuBar menubar = new MenuBar();
        menubar.getMenus().add(polls);
        menubar.getMenus().add(helps);
        
//        Image
        ImageView imag = new ImageView("Imagenes/fondo.jpg");
        imag.setFitHeight(450);
        imag.setFitWidth(450);
        
        BorderPane root = new BorderPane();
        root.setTop(menubar);
        root.setCenter(imag);
        
        Scene scene = new Scene(root, 500, 500);
        
        primaryStage.setTitle("AppEncuesta");
        primaryStage.getIcons().add(new Image("Imagenes/icon.png"));
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
