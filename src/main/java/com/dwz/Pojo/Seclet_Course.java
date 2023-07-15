package com.dwz.Pojo;

public class Seclet_Course {
    private String courseName;
    private String teacherClass;
    private int credit;
    private String teacherName;
    private String courseTime;
    private String coursePoint;
    private String cpClass;

    public Seclet_Course() {
    }

    @Override
    public String toString() {
        return "Seclet_Course{" +
                "courseName='" + courseName + '\'' +
                ", teacherClass='" + teacherClass + '\'' +
                ", credit=" + credit +
                ", teacherName='" + teacherName + '\'' +
                ", courseTime='" + courseTime + '\'' +
                ", coursePoint='" + coursePoint + '\'' +
                ", cpClass='" + cpClass + '\'' +
                '}';
    }

    public Seclet_Course(String courseName, String teacherClass, int credit, String teacherName,
                         String courseTime, String coursePoint, String cpClass) {
        this.courseName = courseName;
        this.teacherClass = teacherClass;
        this.credit = credit;
        this.teacherName = teacherName;
        this.courseTime = courseTime;
        this.coursePoint = coursePoint;
        this.cpClass = cpClass;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTeacherClass() {
        return teacherClass;
    }

    public void setTeacherClass(String teacherClass) {
        this.teacherClass = teacherClass;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getCourseTime() {
        return courseTime;
    }

    public void setCourseTime(String courseTime) {
        this.courseTime = courseTime;
    }

    public String getCoursePoint() {
        return coursePoint;
    }

    public void setCoursePoint(String coursePoint) {
        this.coursePoint = coursePoint;
    }

    public String getCpClass() {
        return cpClass;
    }

    public void setCpClass(String cpClass) {
        this.cpClass = cpClass;
    }
}
