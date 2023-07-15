package com.dwz.Pojo;

public class Course {
    private String course_id;
    private String curse_name;
    private String course_type;
    private int course_credit;

    public Course(String course_id, String curse_name, String course_type, int course_credit) {
        this.course_id = course_id;
        this.curse_name = curse_name;
        this.course_type = course_type;
        this.course_credit = course_credit;
    }
    public Course() {
    }

    @Override
    public String toString() {
        return "Course{" +
                "course_id='" + course_id + '\'' +
                ", curse_name='" + curse_name + '\'' +
                ", course_type='" + course_type + '\'' +
                ", course_credit=" + course_credit +
                '}';
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getCurse_name() {
        return curse_name;
    }

    public void setCurse_name(String curse_name) {
        this.curse_name = curse_name;
    }

    public String getCourse_type() {
        return course_type;
    }

    public void setCourse_type(String course_type) {
        this.course_type = course_type;
    }

    public int getCourse_credit() {
        return course_credit;
    }

    public void setCourse_credit(int course_credit) {
        this.course_credit = course_credit;
    }
}
