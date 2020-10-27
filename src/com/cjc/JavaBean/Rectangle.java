package com.cjc.JavaBean;
public class Rectangle {
    private String Long;
    private String Wide;
    public Rectangle(String aLong, String wide) {
        Long = aLong;
        Wide = wide;
    }
    public Rectangle() {
    }
    public String getLong() {
        return Long;
    }
    public void setLong(String aLong) {
        Long = aLong;
    }
    public String getWide() {
        return Wide;
    }
    public void setWide(String wide) {
        Wide = wide;
    }
    public int mul(){
        return Integer.parseInt(Long)*Integer.parseInt(Wide);
    }
}
