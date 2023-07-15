package com.dwz.Pojo;

public class Class {
    private String c_id;
    private String c_name;
    private int c_num;
    private String d_id;

    @Override
    public String toString() {
        return "Class{" +
                "c_id='" + c_id + '\'' +
                ", c_name='" + c_name + '\'' +
                ", c_num=" + c_num +
                ", d_id='" + d_id + '\'' +
                '}';
    }

    public Class() {
    }

    public Class(String c_id, String c_name, int c_num, String d_id) {
        this.c_id = c_id;
        this.c_name = c_name;
        this.c_num = c_num;
        this.d_id = d_id;
    }

    public String getC_id() {
        return c_id;
    }

    public void setC_id(String c_id) {
        this.c_id = c_id;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public int getC_num() {
        return c_num;
    }

    public void setC_num(int c_num) {
        this.c_num = c_num;
    }

    public String getD_id() {
        return d_id;
    }

    public void setD_id(String d_id) {
        this.d_id = d_id;
    }
}
