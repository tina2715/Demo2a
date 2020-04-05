package com.udgs123.demo2a.ui.trangchu;


public class Trangchu {
    private String Ten;
    private String Namsinh;
    private String Diachi;
    private String Email;
    private String Sdt;
    private String Daymon;
    private int Photo;

    public Trangchu() {

    }

    public Trangchu(String ten, String namsinh, String diachi, String email, String sdt, String daymon, int photo) {
        Ten = ten;
        Namsinh = namsinh;
        Diachi = diachi;
        Email = email;
        Sdt = sdt;
        Daymon = daymon;
        Photo = photo;
    }

    //getter


    public String getTen() {
        return Ten;
    }
    public String getNamsinh() {
        return Namsinh;
    }
    public String getDiachi () { return Diachi; }
    public String getEmail () { return Email;}
    public String getSdt () { return Sdt;}
    public String getDaymon () { return Daymon; }
    public int getPhoto() {
        return Photo;
    }


    //setter


    public void setTen(String ten) {
        Ten = ten;
    }
    public void setNamsinh(String namsinh) {
        Namsinh = namsinh;
    }
    public void setDiachi(String diachi) {
        Diachi = diachi;
    }
    public void setEmail(String email) { Email = email;}
    public void setSdt (String sdt) {Sdt = sdt;}
    public void setDaymon(String daymon) {
        Daymon = daymon;
    }
    public void setPhoto(int photo) {
        Photo = photo;
    }
}
