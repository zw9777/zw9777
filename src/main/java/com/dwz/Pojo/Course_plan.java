package com.dwz.Pojo;

public class Course_plan {
    private String cp_year;
    private String cp_class;
    private String course_id;
    private String cp_week;

    public Course_plan(String cp_year, String cp_class, String course_id, String cp_week) {
        this.cp_year = cp_year;
        this.cp_class = cp_class;
        this.course_id = course_id;
        this.cp_week = cp_week;
    }
    public Course_plan() {
    }
    @Override
    public String toString() {
        return "Course_plan{" +
                "cp_year='" + cp_year + '\'' +
                ", cp_class='" + cp_class + '\'' +
                ", course_id='" + course_id + '\'' +
                ", cp_week='" + cp_week + '\'' +
                '}';
    }

    public String getCp_year() {
        return cp_year;
    }

    public void setCp_year(String cp_year) {
        this.cp_year = cp_year;
    }

    public String getCp_class() {
        return cp_class;
    }

    public void setCp_class(String cp_class) {
        this.cp_class = cp_class;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getCp_week() {
        return cp_week;
    }

    public void setCp_week(String cp_week) {
        this.cp_week = cp_week;
    }
}
