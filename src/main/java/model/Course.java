package model;

import java.util.List;

public class Course implements Comparable<Course> {

    private long courseId;
    private String name;
    private long teacherId;
    private int maxEnrollment;
    private List<Long> studentsEnrolled;
    private int credits;

    public Course( long courseId, String name,  int maxEnrollment, int credits, long teacherId, List<Long> studentsEnrolled) {
        this.courseId = courseId;
        this.name = name;
        this.maxEnrollment = maxEnrollment;
        this.credits = credits;
        this.teacherId = teacherId;
        this.studentsEnrolled = studentsEnrolled;



    }

    public void addStudent(long studetId){
        studentsEnrolled.add(studetId);
    }

    public void removeStudent(long studentId){
        studentsEnrolled.remove(studentId);
    }

    public int getNumberOfStudents(){
        return studentsEnrolled.size();
    }


    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(long teacherId) {
        this.teacherId = teacherId;
    }

    public int getMaxEnrollment() {
        return maxEnrollment;
    }

    public void setMaxEnrollment(int maxEnrollment) {
        this.maxEnrollment = maxEnrollment;
    }

    public List<Long> getStudentsEnrolled() {
        return studentsEnrolled;
    }

    public void setStudentsEnrolled(List<Long> studentsEnrolled) {
        this.studentsEnrolled = studentsEnrolled;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", name='" + name + '\'' +
                ", teacherId=" + teacherId +
                ", maxEnrollment=" + maxEnrollment +
                ", studentsEnrolled=" + studentsEnrolled +
                ", credits=" + credits +
                '}';
    }


    @Override
    public int compareTo(Course course){
        if(courseId == course.getCourseId())
            return 1;
        return 0;
    }
}
