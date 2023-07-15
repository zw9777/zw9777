package com.dwz.Pojo;

public class Teaching_programme {
    private String cp_year;
    private String cp_class;
    private String tc_id;
    private String course_id;

    public Teaching_programme(String cp_year, String cp_class, String tc_id, String course_id) {
        this.cp_year = cp_year;
        this.cp_class = cp_class;
        this.tc_id = tc_id;
        this.course_id = course_id;
    }


    @Override
    public String toString() {
        return "Teaching_programme{" +
                "cp_year='" + cp_year + '\'' +
                ", cp_class='" + cp_class + '\'' +
                ", tc_id='" + tc_id + '\'' +
                ", course_id='" + course_id + '\'' +
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

    public String getTc_id() {
        return tc_id;
    }

    public void setTc_id(String tc_id) {
        this.tc_id = tc_id;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }
}
