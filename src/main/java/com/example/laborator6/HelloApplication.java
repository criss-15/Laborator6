package com.example.laborator6;

import controller.RegistrationSystem;
import javafx.application.Application;
import javafx.stage.Stage;

import repository.CourseRepository;
import repository.StudentRepository;
import repository.TeacherRepository;



public class HelloApplication extends Application {

    private RegistrationSystem registrationSystem;
    private StudentRepository studentRepository;
    private CourseRepository courseRepository;
    private TeacherRepository teacherRepository;


    public void input()
    {
        StudentRepository studentRepository = new StudentRepository("jdbc:mysql://localhost:3306/school", "root", "SimoInfo15");
        CourseRepository courseRepository = new CourseRepository("jdbc:mysql://localhost:3306/school", "root", "SimoInfo15");
        TeacherRepository teacherRepository = new TeacherRepository("jdbc:mysql://localhost:3306/school", "root", "SimoInfo15");
        registrationSystem = new RegistrationSystem("jdbc:mysql://localhost:3306/school", "root", "SimoInfo15");
    }











    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {

    }
}
