package model;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person implements Comparable<Student> {

    private long studentId;
    private List<Long> enrolledCourses;

    public Student(String firstName, String lastName,  List<Long> enrolledCourses, long studentId){
        super(firstName, lastName);
        this.studentId = studentId;
        this.enrolledCourses = enrolledCourses;
    }

    public void addCourse(long courseId){
        enrolledCourses.add(courseId);
    }

    public void deleteCourse(long courseId){
        enrolledCourses.remove(courseId);
    }

    public int getEnrolledCoursesSize(){
        return enrolledCourses.size();
    }


    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public List<Long> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void setEnrolledCourses(List<Long> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }

    @Override
    public int compareTo(Student student){
        if(studentId == student.getStudentId())
            return 1;
        return 0;

    }


    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName +
                ", lastName='" + lastName +
                ", studentId=" + studentId +
                ", enrolledCourses=" + enrolledCourses +
                '}';
    }

    public int getCoursesNumber(){
        return enrolledCourses.size();
    }



}
