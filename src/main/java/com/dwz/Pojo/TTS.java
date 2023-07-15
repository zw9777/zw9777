package com.dwz.Pojo;

public class TTS {
    private String t_id;
    private String tc_id;

    public TTS() {
    }

    @Override
    public String toString() {
        return "TTS{" +
                "t_id='" + t_id + '\'' +
                ", tc_id='" + tc_id + '\'' +
                '}';
    }

    public TTS(String t_id, String tc_id) {
        this.t_id = t_id;
        this.tc_id = tc_id;
    }

    public String getT_id() {
        return t_id;
    }

    public void setT_id(String t_id) {
        this.t_id = t_id;
    }

    public String getTc_id() {
        return tc_id;
    }

    public void setTc_id(String tc_id) {
        this.tc_id = tc_id;
    }
}
