package com.dwz.Pojo;

public class Thing {
    private String thingtxt;
    private String tine;
    private String  id;
    private String year;

    public Thing(String thingtxt, String tine, String id, String year) {
        this.thingtxt = thingtxt;
        this.tine = tine;
        this.id = id;
        this.year = year;
    }

    public Thing() {
    }

    public String getThingtxt() {
        return thingtxt;
    }

    public void setThingtxt(String thingtxt) {
        this.thingtxt = thingtxt;
    }

    public String getTine() {
        return tine;
    }

    public void setTine(String tine) {
        this.tine = tine;
    }

    public String  getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
