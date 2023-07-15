package com.dwz.Pojo;

public class Student {
    private String s_id;
    private String s_name;
    private String s_sex;
    private String c_id;

    public Student() {
    }

    public Student(String s_id, String s_name, String s_sex, String c_id) {
        this.s_id = s_id;
        this.s_name = s_name;
        this.s_sex = s_sex;
        this.c_id = c_id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "s_id='" + s_id + '\'' +
                ", s_name='" + s_name + '\'' +
                ", s_sex='" + s_sex + '\'' +
                ", c_id='" + c_id + '\'' +
                '}';
    }

    public String getS_id() {
        return s_id;
    }

    public void setS_id(String s_id) {
        this.s_id = s_id;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public String getS_sex() {
        return s_sex;
    }

    public void setS_sex(String s_sex) {
        this.s_sex = s_sex;
    }

    public String getC_id() {
        return c_id;
    }

    public void setC_id(String c_id) {
        this.c_id = c_id;
    }
}
