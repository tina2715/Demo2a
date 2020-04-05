package com.udgs123.demo2a.ui.ttlophoc;

public class Ttlophoc {

    private String Tenlop;
    private String Motayeucau;
    private String Monhoc;
    private String Diachi;
    private String Hocphi;
    private String Trinhdogiasu;
    private String Thoigianhoc;

    public Ttlophoc() {

    }

    public Ttlophoc(String tenlop, String motayeucau, String monhoc, String diachi, String hocphi, String trinhdogiasu, String thoigianhoc) {
        Tenlop = tenlop;
        Motayeucau = motayeucau;
        Monhoc = monhoc;
        Diachi = diachi;
        Hocphi = hocphi;
        Trinhdogiasu = trinhdogiasu;
        Thoigianhoc = thoigianhoc;
    }

    //getter


    public String getTenlop() {
        return Tenlop;
    }
    public String getMotayeucau() {
        return Motayeucau;
    }
    public String getMonhoc () { return Monhoc; }
    public String getDiachi () { return Diachi; }
    public String getHocphi () { return Hocphi; }
    public String getTrinhdogiasu() {return Trinhdogiasu; }
    public String getThoigianhoc() {return Thoigianhoc; }


    //setter


    public void setTenlop(String tenlop) {
        Tenlop = tenlop;
    }
    public void setMotayeucau(String motayeucau) {
        Motayeucau = motayeucau;
    }
    public void setMonhoc(String monhoc) { Monhoc = monhoc;}
    public void setDiachi(String diachi) {
        Diachi = diachi;
    }
    public void setHocphi (String hocphi) {Hocphi = hocphi;}
    public void setTrinhdogiasu(String trinhdogiasu) {Trinhdogiasu = trinhdogiasu;}
    public void setThoigianhoc(String thoigianhoc) {Thoigianhoc = thoigianhoc;}


}
