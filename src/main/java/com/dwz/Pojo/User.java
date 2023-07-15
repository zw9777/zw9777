package com.dwz.Pojo;

public class User {
    private String u_id;
    private String u_pwd;
    private String u_status;
    private String t_name;
    private String s_name;
    private String ssex;


    @Override
    public String toString() {
        return "User{" +
                "u_id='" + u_id + '\'' +
                ", u_pwd='" + u_pwd + '\'' +
                ", u_status='" + u_status + '\'' +
                ", t_name='" + t_name + '\'' +
                ", s_name='" + s_name + '\'' +
                ", ssex='" + ssex + '\'' +
                '}';
    }

    public String getS_name() {
        return s_name;
    }

    public String getSsex() {
        return ssex;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public String getT_name() {
        return t_name;
    }

    public void setT_name(String t_name) {
        this.t_name = t_name;
    }

    public User() {
    }

    public User(String u_id, String u_pwd, String u_status) {
        this.u_id = u_id;
        this.u_pwd = u_pwd;
        this.u_status = u_status;
    }

    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }

    public String getU_pwd() {
        return u_pwd;
    }

    public void setU_pwd(String u_pwd) {
        this.u_pwd = u_pwd;
    }

    public String getU_status() {
        return u_status;
    }

    public void setU_status(String u_status) {
        this.u_status = u_status;
    }
}
