package com.dwz.Pojo;

public class Grade {
    private String tc_id;
    private String s_id;
    private Double g_ps;
    private Double g_exam;
    private Double g_final;
    private String course_name;
    private String s_name;

    public Grade(String tc_id, String s_id, Double g_ps, Double g_exam, Double g_final) {
        this.tc_id = tc_id;
        this.s_id = s_id;
        this.g_ps = g_ps;
        this.g_exam = g_exam;
        this.g_final = g_final;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }


    @Override
    public String toString() {
        return "Grade{" +
                "tc_id='" + tc_id + '\'' +
                ", s_id='" + s_id + '\'' +
                ", g_ps=" + g_ps +
                ", g_exam=" + g_exam +
                ", g_final=" + g_final +
                ", course_name='" + course_name + '\'' +
                ", s_name='" + s_name + '\'' +
                '}';
    }

    public Grade() {
    }

    public String getTc_id() {
        return tc_id;
    }

    public void setTc_id(String tc_id) {
        this.tc_id = tc_id;
    }

    public String getS_id() {
        return s_id;
    }

    public void setS_id(String s_id) {
        this.s_id = s_id;
    }

    public Double getG_ps() {
        return g_ps;
    }

    public void setG_ps(Double g_ps) {
        this.g_ps = g_ps;
    }

    public Double getG_exam() {
        return g_exam;
    }

    public void setG_exam(Double g_exam) {
        this.g_exam = g_exam;
    }

    public Double getG_final() {
        return g_final;
    }

    public void setG_final(Double g_final) {
        this.g_final = g_final;
    }
}
