package com.example.laborator6;

import controller.RegistrationSystem;
import javafx.application.Application;
import javafx.stage.Stage;

import repository.CourseRepository;
import repository.StudentRepository;
import repository.TeacherRepository;



//public class HelloApplication extends Application {
//
//    private RegistrationSystem registrationSystem;
//    private StudentRepository studentRepository;
//    private CourseRepository courseRepository;
//    private TeacherRepository teacherRepository;
//
//
//    public void input()
//    {
//        StudentRepository studentRepository = new StudentRepository("jdbc:mysql://localhost:3306/school", "root", "SimoInfo15");
//        CourseRepository courseRepository = new CourseRepository("jdbc:mysql://localhost:3306/school", "root", "SimoInfo15");
//        TeacherRepository teacherRepository = new TeacherRepository("jdbc:mysql://localhost:3306/school", "root", "SimoInfo15");
//        registrationSystem = new RegistrationSystem("jdbc:mysql://localhost:3306/school", "root", "SimoInfo15");
//    }
//
//
//
//
//
//
//
//
//
//
//
//    public static void main(String[] args) {
//        launch();
//    }
//
//    @Override
//    public void start(Stage stage) throws Exception {
//
//    }
//}




import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    /**
     * Starts the application
     * @param stage stage
     * @throws IOException input
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 340);
        stage.setTitle("University");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}