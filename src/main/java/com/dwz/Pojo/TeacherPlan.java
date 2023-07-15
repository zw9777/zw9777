package com.dwz.Pojo;

public class TeacherPlan {
    private String tc_name;
    private String tc_time;
    private String tc_point;

    public TeacherPlan(String tc_name, String tc_time, String tc_point) {
        this.tc_name = tc_name;
        this.tc_time = tc_time;
        this.tc_point = tc_point;
    }

    @Override
    public String toString() {
        return "TeacherPlan{" +
                "tc_name='" + tc_name + '\'' +
                ", tc_time='" + tc_time + '\'' +
                ", tc_point='" + tc_point + '\'' +
                '}';
    }

    public String getTc_name() {
        return tc_name;
    }

    public void setTc_name(String tc_name) {
        this.tc_name = tc_name;
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
