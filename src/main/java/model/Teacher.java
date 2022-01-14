package model;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends Person implements Comparable<Teacher>{

    private long teacherId;
    private List<Long> coursesId;


    public Teacher(String firstName, String lastName, List<Long> coursesId, long teacherId) {
        super(firstName, lastName);
        this.teacherId = teacherId;
        this.coursesId = coursesId;

    }

    public void addCourse(long courseId){
        coursesId.add(courseId);
    }

    public void deleteCourse(long courseId){
        coursesId.remove(courseId);
    }

    public int getNumberOfCourses(){
        return coursesId.size();
    }

    public long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public List<Long> getCoursesId() {
        return coursesId;
    }

    public void setCoursesId(List<Long> coursesId) {
        this.coursesId = coursesId;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "firstName='" + firstName +
                ", lastName='" + lastName +
                ", teacherId=" + teacherId +
                ", coursesId=" + coursesId +
                '}';
    }


    @Override
    public int compareTo(Teacher teacher){
        if(teacherId == teacher.getTeacherId())
            return 1;
        return 0;
    }
}
