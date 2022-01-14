package com.example.laborator6;





import exceptions.AlreadyExistsException;
import exceptions.ExceptionLimitReached;
import exceptions.ExceptionMaximCredits;
import exceptions.ExceptionNotFound;
import model.Course;
import model.Student;
import model.Teacher;
import controller.RegistrationSystem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.Course;
import model.Student;
import model.Teacher;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;


public class HelloController {
    private Stage stage;
    private Scene scene;
    private Parent root;


    @FXML
    private Label loginFailed;

    private static RegistrationSystem registrationSystem;

    @FXML
    private TextField firstNameBox;

    @FXML
    private TextField lastNameBox;

    @FXML
    private CheckBox teacherCheckBox;

    @FXML
    private TextField courseId;

    @FXML
    private Label status;

    private static String firstName;
    private static String lastName;
    private static long id;

    @FXML
    private ListView<String> studentListView;

    @FXML
    private Label credits;

    /**
     * Login for a student or a teacher
     * @param event event
     * @throws SQLException student does not exist
     * @throws IOException invalid input
     */
    @FXML
    public void onLogInButtonClick(ActionEvent event) throws SQLException, IOException {
        if (firstName == null) {
            registrationSystem = new RegistrationSystem("jdbc:mysql://localhost:3306/school", "root", "SimoInfo15");

            if (teacherCheckBox.isSelected()) {

                for (Teacher teacher : registrationSystem.retrieveAllTeachers()) {
                    if (teacher.getFirstName().equals(firstNameBox.getText()) && teacher.getLastName().equals(lastNameBox.getText())) {

                        root = FXMLLoader.load(getClass().getResource("teacher.fxml"));
                        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                        scene = new Scene(root);
                        stage.setScene(scene);
                        stage.show();

                        firstName = firstNameBox.getText();
                        lastName = lastNameBox.getText();
                        id = teacher.getTeacherId();

                    }
                }

            } else {

                for (Student stud : registrationSystem.retrieveAllStudents()) {
                    if (stud.getFirstName().equals(firstNameBox.getText()) && stud.getLastName().equals(lastNameBox.getText())) {

                        root = FXMLLoader.load(getClass().getResource("student.fxml"));
                        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                        scene = new Scene(root);
                        stage.setScene(scene);
                        stage.show();

                        firstName = firstNameBox.getText();
                        lastName = lastNameBox.getText();
                        id = stud.getStudentId();

                    }
                }
            }
            loginFailed.setText("Log in failed, please try again!");
        } else loginFailed.setText(String.format("Already logged in as %s %s !", firstName, lastName));
    }


    /**
     * Displays for a teacher the names of the students enrolled to his courses
     * @throws SQLException
     */
    @FXML
    public void onDisplayStudentsButtonClick() throws SQLException {
        registrationSystem = new RegistrationSystem("jdbc:mysql://localhost:3306/school", "root", "SimoInfo15");


        Set<Long> students = new TreeSet<>();
        for (Course course: registrationSystem.filterCourse()) {
            if (course.getTeacherId() == id){
                students.addAll(course.getStudentsEnrolled());
            }
        }

        List<String> studentsNames = new ArrayList<>();
        for (Student stud : registrationSystem.retrieveAllStudents()) {
            if (students.contains(stud.getStudentId())){
                studentsNames.add(String.format("%s %s", stud.getFirstName(), stud.getLastName()));
            }
        }
        ObservableList<String> objects = FXCollections.observableArrayList(studentsNames);
        studentListView.getItems().addAll(objects);
    }


    /**
     * Registers a student to a course
     */
    @FXML
    public void register() {
        registrationSystem = new RegistrationSystem("jdbc:mysql://localhost:3306/school", "root", "SimoInfo15");
        try {
            registrationSystem.register(Long.parseLong(courseId.getText()) ,id);
            status.setText("Operation successfully performed!");
        } catch (ExceptionNotFound e) {
            status.setText("Error! Invalid course id!");
        } catch (ExceptionMaximCredits e) {
            status.setText("Error! Credits surpassed!");
        } catch (ExceptionLimitReached e) {
            status.setText("Error! Course is full!");
        } catch (AlreadyExistsException e) {
            status.setText("Error! You are already registered!");
        } catch (SQLException e) {
            status.setText("Unexpected error...");
        }
    }


    /**
     * Shows the number of credits of a student
     * @throws SQLException
     */
    @FXML
    public void getCredits() throws SQLException {
        int cred = registrationSystem.totalCreditsOfaStudent(registrationSystem.retrieveAllStudents().stream().filter(student -> student.getStudentId() == id).toList().get(0));
        credits.setText(String.valueOf(cred));
    }


    /**
     * Closes the application
     * @param event event
     */
    @FXML
    public void quit(ActionEvent event){
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }


    /**
     * Refreshes the list of students
     * @throws SQLException
     */
    @FXML
    public void onRefreshButtonClick() throws SQLException {
        studentListView.getItems().clear();
        onDisplayStudentsButtonClick();
    }
}