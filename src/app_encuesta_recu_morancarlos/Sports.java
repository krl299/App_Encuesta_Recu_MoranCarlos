/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_encuesta_recu_morancarlos;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Carlos
 */
public class Sports extends Stage {

    private ImageView sexImg;

    public Sports(Stage sports) {
        initOwner(sports);
        initModality(Modality.APPLICATION_MODAL);

//        Layouts
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 500, 600);
        VBox topPane = new VBox();
        BorderPane centerPane = new BorderPane();
        VBox bottomPane = new VBox();

//        TopStage
        FlowPane profesionPane = new FlowPane();
        FlowPane infoPane = new FlowPane();
        FlowPane sexPane = new FlowPane();

//        Profesion        
        Label profesionLabel = new Label("Profesion: ");
        TextField profesionTextField = new TextField();

        profesionPane.getChildren().add(profesionLabel);
        profesionPane.getChildren().add(profesionTextField);
        profesionPane.setHgap(20);
        profesionTextField.setMinWidth(300);
        topPane.getChildren().add(profesionPane);

//        Age & Siblings
        Label ageLabel = new Label("Edad: ");
        ChoiceBox ageChoiceBox = new ChoiceBox();
        ageChoiceBox.getItems().addAll("Menos de 15", "Entre 15 y 18", "Entre 19 y 35", "Entre 36 y 60", "Mas de 60");
        Label siblingsLabel = new Label("Nº Hermanos: ");
        ChoiceBox siblingsChoiceBox = new ChoiceBox();
        siblingsChoiceBox.getItems().addAll("0", "1", "2", "Mas de 2");

        infoPane.getChildren().add(ageLabel);
        infoPane.getChildren().add(ageChoiceBox);
        infoPane.getChildren().add(siblingsLabel);
        infoPane.getChildren().add(siblingsChoiceBox);
        infoPane.setHgap(20);
        topPane.getChildren().add(infoPane);

//        Sex
        Label sexLabel = new Label("Sexo: ");
        RadioButton sexMan = new RadioButton("Hombre");
        RadioButton sexWoman = new RadioButton("Mujer");
        sexMan.setSelected(true);
        ToggleGroup sexToggleGroup = new ToggleGroup();
        sexMan.setToggleGroup(sexToggleGroup);
        sexWoman.setToggleGroup(sexToggleGroup);
        sexImg = new ImageView("Imagenes/Masculino.png");
        sexMan.setOnMouseClicked(e -> {
            sexImg.setImage(new Image("Imagenes/Masculino.png"));
        });

        sexWoman.setOnMouseClicked(e -> {
            sexImg.setImage(new Image("Imagenes/Femenino.png"));
        });

        sexPane.getChildren().add(sexLabel);
        sexPane.getChildren().add(sexMan);
        sexPane.getChildren().add(sexWoman);
        sexPane.getChildren().add(sexImg);
        sexPane.setHgap(40);
        sexPane.setAlignment(Pos.CENTER);
        topPane.getChildren().add(sexPane);

//        CenterStage
        FlowPane center1Pane = new FlowPane();

        CheckBox centerCheckBox = new CheckBox("¿Tienes algún deporte favorito?");
        Label centerLabel = new Label("¿Cuál es?");
        ChoiceBox centerChoiceBox = new ChoiceBox();
        centerChoiceBox.setDisable(true);
        centerChoiceBox.getItems().addAll("Fútbol", "Baloncesto", "Tenis", "Natación");

        centerPane.setTop(centerCheckBox);
        center1Pane.getChildren().add(centerLabel);
        center1Pane.getChildren().add(centerChoiceBox);
        center1Pane.setAlignment(Pos.CENTER);
        centerPane.setCenter(center1Pane);
        center1Pane.setHgap(35);
        centerCheckBox.addEventHandler(EventType.ROOT, (event) -> {
            if (centerCheckBox.isSelected()) {
                centerPane.setBackground(new Background(
                        new BackgroundImage(new Image("Imagenes/fondoDeportes.jpg"),
                                BackgroundRepeat.REPEAT,
                                BackgroundRepeat.REPEAT,
                                BackgroundPosition.CENTER,
                                new BackgroundSize(BackgroundSize.AUTO,
                                        BackgroundSize.AUTO, true, true, true, true))));
                centerChoiceBox.setDisable(false);
            } else {
                centerPane.setBackground(Background.EMPTY);
                centerChoiceBox.setDisable(true);
                centerChoiceBox.setValue(null);
            }
        });

//        BottomStage
        FlowPane bottom1Pane = new FlowPane();
        FlowPane bottom2Pane = new FlowPane();
        FlowPane bottom3Pane = new FlowPane();
        FlowPane bottom4Pane = new FlowPane();
        FlowPane bottomSendPane = new FlowPane();
        FlowPane bottomSendEstatePane = new FlowPane();

        Label bottomLabel = new Label("Marque  su grado de afición a:");

        Label choice1Label = new Label("Fútbol: ");
        Slider choice1Slider = new Slider();
        Label choice1Value = new Label("0");
        choice1Slider.setMin(0);
        choice1Slider.setMax(10);
        choice1Slider.setMinWidth(200);

        Label choice2Label = new Label("Baloncesto: ");
        Slider choice2Slider = new Slider();
        Label choice2Value = new Label("0");
        choice2Slider.setMin(0);
        choice2Slider.setMax(10);
        choice2Slider.setMinWidth(200);

        Label choice3Label = new Label("Tenis: ");
        Slider choice3Slider = new Slider();
        Label choice3Value = new Label("0");
        choice3Slider.setMin(0);
        choice3Slider.setMax(10);
        choice3Slider.setMinWidth(200);

        Label choice4Label = new Label("Natación: ");
        Slider choice4Slider = new Slider();
        Label choice4Value = new Label("0");
        choice4Slider.setMin(0);
        choice4Slider.setMax(10);
        choice4Slider.setMinWidth(200);

        Button send = new Button("Enviar");
        Label sendLabel = new Label();
        sendLabel.setTextFill(Color.RED);
        sendLabel.setDisable(false);

        bottomPane.getChildren().add(bottomLabel);
        bottomPane.getChildren().add(bottom1Pane);
        bottom1Pane.getChildren().add(choice1Label);
        bottom1Pane.getChildren().add(choice1Slider);
        bottom1Pane.getChildren().add(choice1Value);
        bottom1Pane.setHgap(30);
        bottom1Pane.setAlignment(Pos.CENTER);
        choice1Slider.addEventHandler(EventType.ROOT, e -> {
            choice1Value.setText(Long.toString(Math.round(choice1Slider.getValue())));

        });

        bottomPane.getChildren().add(bottom2Pane);
        bottom2Pane.getChildren().add(choice2Label);
        bottom2Pane.getChildren().add(choice2Slider);
        bottom2Pane.getChildren().add(choice2Value);
        bottom2Pane.setHgap(30);
        bottom2Pane.setAlignment(Pos.CENTER);
        choice2Slider.addEventHandler(EventType.ROOT, e -> {
            choice2Value.setText(Long.toString(Math.round(choice2Slider.getValue())));

        });

        bottomPane.getChildren().add(bottom3Pane);
        bottom3Pane.getChildren().add(choice3Label);
        bottom3Pane.getChildren().add(choice3Slider);
        bottom3Pane.getChildren().add(choice3Value);
        bottom3Pane.setHgap(30);
        bottom3Pane.setAlignment(Pos.CENTER);
        choice3Slider.addEventHandler(EventType.ROOT, e -> {
            choice3Value.setText(Long.toString(Math.round(choice3Slider.getValue())));

        });

        bottomPane.getChildren().add(bottom4Pane);
        bottom4Pane.getChildren().add(choice4Label);
        bottom4Pane.getChildren().add(choice4Slider);
        bottom4Pane.getChildren().add(choice4Value);
        bottom4Pane.setHgap(30);
        bottom4Pane.setAlignment(Pos.CENTER);
        choice4Slider.addEventHandler(EventType.ROOT, e -> {
            choice4Value.setText(Long.toString(Math.round(choice4Slider.getValue())));

        });

        bottomPane.getChildren().add(bottomSendEstatePane);
        bottomSendEstatePane.getChildren().add(sendLabel);
        bottomPane.getChildren().add(bottomSendPane);
        bottomSendPane.getChildren().add(send);
        bottomSendPane.setAlignment(Pos.BOTTOM_RIGHT);
        bottomPane.setAlignment(Pos.CENTER);

        send.setOnMouseClicked(e -> {

            if (profesionTextField.getText().equals("")) {
                sendLabel.setText("No se puede enviar la encuesta, revisa los campos");
                sendLabel.setTextFill(Color.RED);
                sendLabel.setVisible(true);
            } else if (ageChoiceBox.getValue() == null) {
                sendLabel.setText("No se puede enviar la encuesta, revisa los campos");
                sendLabel.setTextFill(Color.RED);
                sendLabel.setVisible(true);
            } else if (siblingsChoiceBox.getValue() == null) {
                sendLabel.setText("No se puede enviar la encuesta, revisa los campos");
                sendLabel.setTextFill(Color.RED);
                sendLabel.setVisible(true);
            } else if (centerCheckBox.isSelected() && centerChoiceBox.getValue() == null) {
                sendLabel.setText("No se puede enviar la encuesta, revisa los campos");
                sendLabel.setTextFill(Color.RED);
                sendLabel.setVisible(true);
            } else {

                //Despues de la comprobacion de los campos obligatorios, se envian al fichero
                FileWriter fichero = null;
                PrintWriter pw = null;
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();

                try {
                    fichero = new FileWriter("src/csv/Enc_Deportes.csv", true);
                    pw = new PrintWriter(fichero);

                    pw.print(
                            dtf.format(now) + ";"
                            + profesionTextField.getText() + ";"
                            + ageChoiceBox.getValue() + ";"
                            + siblingsChoiceBox.getValue() + ";"
                    );
                    if (sexWoman.isSelected()) {
                        pw.print("Mujer;");
                    } else {
                        pw.print("Hombre;");
                    }

                    pw.print(
                            centerChoiceBox.getValue() + ";"
                            + Long.toString(Math.round(choice1Slider.getValue())) + ";"
                            + Long.toString(Math.round(choice2Slider.getValue())) + ";"
                            + Long.toString(Math.round(choice3Slider.getValue())) + ";"
                            + Long.toString(Math.round(choice4Slider.getValue())) + "\n"
                    );

                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                try {
                    if (fichero != null) {
                        fichero.close();
                    }

                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                sendLabel.setText("Encuesta enviada correctamente");
                sendLabel.setTextFill(Color.GREEN);
                sendLabel.setVisible(true);

            }
            this.close();
        });
        
        topPane.setSpacing(10);
        bottomPane.setSpacing(5);

        topPane.setMinHeight(scene.getHeight() / 3);
        centerPane.setMinHeight(scene.getHeight() / 3);
        bottomPane.setMinHeight(scene.getHeight() / 3);

        //Se añaden los 3 layouts principales
        root.setTop(topPane);
        root.setCenter(centerPane);
        root.setBottom(bottomPane);

        topPane.setPadding(new Insets(20));
        centerPane.setPadding(new Insets(20));
        bottomPane.setPadding(new Insets(20));

        this.setTitle("Encuesta Deportes");
        this.getIcons().add(new Image("Imagenes/icon.png"));
        this.setScene(scene);
        this.showAndWait();

    }
;

}
