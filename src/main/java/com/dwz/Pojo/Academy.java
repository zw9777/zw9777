package com.dwz.Pojo;

public class Academy {
    private String a_id;
    private String a_name;

    @Override
    public String toString() {
        return "Academy{" +
                "a_id='" + a_id + '\'' +
                ", a_name='" + a_name + '\'' +
                '}';
    }

    public Academy(String a_id, String a_name) {
        this.a_id = a_id;
        this.a_name = a_name;
    }

    public Academy() {
    }

    public String getA_id() {
        return a_id;
    }

    public void setA_id(String a_id) {
        this.a_id = a_id;
    }

    public String getA_name() {
        return a_name;
    }

    public void setA_name(String a_name) {
        this.a_name = a_name;
    }
}
