package com.dwz.Pojo;

public class Department {
    private String d_id;
    private String d_name;
    private String a_id;

    public Department(String d_id, String d_name, String a_id) {
        this.d_id = d_id;
        this.d_name = d_name;
        this.a_id = a_id;
    }
    public Department() {
    }
    @Override
    public String toString() {
        return "Department{" +
                "d_id='" + d_id + '\'' +
                ", d_name='" + d_name + '\'' +
                ", a_id='" + a_id + '\'' +
                '}';
    }
    public String getD_id() {
        return d_id;
    }

    public void setD_id(String d_id) {
        this.d_id = d_id;
    }

    public String getD_name() {
        return d_name;
    }

    public void setD_name(String d_name) {
        this.d_name = d_name;
    }

    public String getA_id() {
        return a_id;
    }

    public void setA_id(String a_id) {
        this.a_id = a_id;
    }
}
