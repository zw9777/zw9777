package com.dwz.Pojo;

public class Teacher_class {
    private String tc_id;
    private String tc_name;
    private String curse_name;
    private int tc_num;
    private String tc_time;
    private String tc_point;

    public Teacher_class(String tc_id, String tc_name, int tc_num, String tc_time, String tc_point) {
        this.tc_id = tc_id;
        this.tc_name = tc_name;
        this.tc_num = tc_num;
        this.tc_time = tc_time;
        this.tc_point = tc_point;
    }

    @Override
    public String toString() {
        return "Teacher_class{" +
                "tc_id='" + tc_id + '\'' +
                ", tc_name='" + tc_name + '\'' +
                ", course_name='" + curse_name + '\'' +
                ", tc_num=" + tc_num +
                ", tc_time='" + tc_time + '\'' +
                ", tc_point='" + tc_point + '\'' +
                '}';
    }

    public Teacher_class() {
    }

    public String getCurse_name() {
        return curse_name;
    }

    public void setCurse_name(String curse_name) {
        this.curse_name = curse_name;
    }

    public String getTc_id() {
        return tc_id;
    }

    public void setTc_id(String tc_id) {
        this.tc_id = tc_id;
    }

    public String getTc_name() {
        return tc_name;
    }

    public void setTc_name(String tc_name) {
        this.tc_name = tc_name;
    }

    public int getTc_num() {
        return tc_num;
    }

    public void setTc_num(int tc_num) {
        this.tc_num = tc_num;
    }

    public String getTc_time() {
        return tc_time;
    }

    public void setTc_time(String tc_time) {
        this.tc_time = tc_time;
    }

    public String getTc_point() {
        return tc_point;
    }

    public void setTc_point(String tc_point) {
        this.tc_point = tc_point;
    }
}
