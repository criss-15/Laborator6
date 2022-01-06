package com.example.laborator6;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    Stage window;
    Scene entryScene, studentScene, teacherScene, registerScene;

    public static void main(String[] args) {
        launch();

    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        window = primaryStage;


        Button button1 = new Button("Student");
        Button button2 = new Button("Teacher");
        button1.setOnAction(e -> window.setScene(studentScene));
        button2.setOnAction(e -> window.setScene(teacherScene));


        //Layout1
        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(button1, button2);
        entryScene = new Scene(layout1, 400, 400);
        layout1.setAlignment(Pos.BASELINE_CENTER);


        //Button3
//        GridPane grid = new GridPane();
//        grid.setPadding(new Insets(10, 10, 10, 10));
//        grid.setVgap(10);
//        grid.setHgap(10);


        Label labelFirstName = new Label("FirstName:");
        //GridPane.setConstraints(labelFirstName, 0, 0);

        TextField firstNameInput = new TextField();
        //GridPane.setConstraints(firstNameInput, 1, 0);


        Label labelLastName = new Label("LastName:");
        //GridPane.setConstraints(labelLastName, 0, 1);

        TextField lastNameInput = new TextField();
        //GridPane.setConstraints(lastNameInput, 1, 1);

        Label labelID = new Label("Id:");
        TextField idInput = new TextField();


        Button button3 = new Button("Submit");
        button3.setOnAction(e -> window.setScene(entryScene));

        Button showCreditsButton = new Button("Show Credits.");
        Button registerButton = new Button("Register");
        registerButton.setOnAction(e -> window.setScene(registerScene));



        //Layout2
        VBox layout2 = new VBox();
        layout2.getChildren().addAll(labelFirstName, firstNameInput, labelLastName, lastNameInput, labelID, idInput, button3, showCreditsButton, registerButton);
        studentScene = new Scene(layout2, 400, 400);
        layout2.setAlignment(Pos.BASELINE_CENTER);



        Label labelIdStudent = new Label("Id Student:");


        TextField idStudentInput = new TextField();


        Label labelIdCourse = new Label("Id Course:");
        TextField idCourse = new TextField();

        Button submitButton = new Button("Submit");
        submitButton.setOnAction(e -> window.setScene(studentScene));



        VBox layoutRegister = new VBox();
        layoutRegister.getChildren().addAll(labelIdStudent, idStudentInput, labelIdCourse, idCourse, submitButton);
        registerScene = new Scene(layoutRegister, 400, 400);


        //Button 4
//        GridPane grid2 = new GridPane();
//        grid.setPadding(new Insets(10, 10, 10, 10));
//        grid.setVgap(10);
//        grid.setHgap(10);


        Label labelFirstName2 = new Label("FirstName:");
        //GridPane.setConstraints(labelFirstName, 0, 0);

        TextField firstNameInput2 = new TextField();
        //GridPane.setConstraints(firstNameInput, 1, 0);


        Label labelLastName2 = new Label("LastName:");
        //GridPane.setConstraints(labelLastName, 0, 1);

        TextField lastNameInput2 = new TextField();
        //GridPane.setConstraints(lastNameInput, 1, 1);

        Label labelID2 = new Label("Id:");
        TextField idInput2 = new TextField();


        Button button4 = new Button("Submit");
        button4.setOnAction(e -> window.setScene(entryScene));

        VBox layout4 = new VBox();
        layout4.getChildren().addAll(labelFirstName2, firstNameInput2, labelLastName2, lastNameInput2, labelID2, idInput2, button4);
        teacherScene = new Scene(layout4, 400, 400);

//        //Layout3
//        StackPane layout3 = new StackPane();
//        layout3.getChildren().add(button4);
//        teacherScene = new Scene(layout3, 400, 400);

        window.setScene(entryScene);
        window.setTitle("Welcome to the University");
        window.show();


    }

}


