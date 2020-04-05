package com.udgs123.demo2a.ui.lichnghi;

public class Xemlichnghi {
    private String Malop;
    private String Ngaynghi;
    private String Ngaybu;
    private String Lido;
    private String Ghichu;
    private String Nguoidang;
    private String Ngaydang;

    public Xemlichnghi() {

    }

    public Xemlichnghi(String malop, String ngaynghi, String ngaybu, String lido, String ghichu, String nguoidang, String ngaydang) {
        Malop = malop;
        Ngaynghi = ngaynghi;
        Ngaybu = ngaybu;
        Lido = lido;
        Ghichu = ghichu;
        Nguoidang = nguoidang;
        Ngaydang = ngaydang;
    }

    //getter


    public String getMalop() {
        return Malop;
    }

    public String getNgaynghi() {
        return Ngaynghi;
    }
    public String getNgaybu() {
        return Ngaybu;
    }
    public String getLido () { return Lido ; }
    public String getGhichu () { return Ghichu ;}

    public String getNguoidang() {
        return Nguoidang;
    }

    public String getNgaydang() {
        return Ngaydang;
    }
    //setter

    public void setMalop(String malop) {
        Malop = malop;
    }

    public void setNgaynghi(String ngaynghi) {
        Ngaynghi = ngaynghi;
    }
    public void setNgaybu(String ngaybu) {
        Ngaybu = ngaybu;
    }
    public void setLido(String lido) {
        Lido = lido;
    }
    public void setGhichu(String ghichu) {
        Ghichu = ghichu;}

    public void setNguoidang(String nguoidang) {
        Nguoidang = nguoidang;
    }

    public void setNgaydang(String ngaydang) {
        Ngaydang = ngaydang;
    }
}
